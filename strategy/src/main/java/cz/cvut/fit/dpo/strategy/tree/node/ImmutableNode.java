package cz.cvut.fit.dpo.strategy.tree.node;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.collect.Lists;

import cz.cvut.fit.dpo.strategy.util.ReflectionObject;

/**
 * Immutable tree node using {@link ArrayList} to hold child nodes.
 *
 * @param <T> type of node content
 * 
 * @author kroupvla
 */
public class ImmutableNode<T> extends ReflectionObject implements Node<T> {

	private final List<ImmutableNode<T>> children;
	private final T content;
	
	public ImmutableNode( Builder<T> builder ) {
		this.content = builder.content;
		this.children = builder.children;
	}

	@Override
	public T content() {
		return content;
	}

	@Override
	public boolean hasChild( int index ) {
		return ( index < childCount() );
	}

	@Override
	public Node<T> child( int index ) {
		if (! hasChild( index ) ) {
			throw new NoSuchElementException();
		}
		return children.get( index );
	}

	@Override
	public int childCount() {
		return children.size();
	}
	
	/**
	 * Convenience method to construct {@ImmutableNode.Builder} builder for this class.
	 * 
	 * @param content node content
	 * @return builder initialized with content
	 */
	public static <T> ImmutableNode.Builder<T> builder( T content ) {
		return new Builder<T>( content );
	}

	/**
	 * Builder for {@link BinaryNode}. 
	 *
	 * @param <T> type of node content
	 */
	public static class Builder<T> {
		
		private final T content;
		private List<ImmutableNode<T>> children;
		
		/**
		 * Constructor.
		 * 
		 * @param content content of the node
		 */
		public Builder( T content ) {
			this.content = content;
			children = Lists.newArrayList();
		}
		
		/**
		 * Adds child to this node.
		 * 
		 * @param child node to add
		 * @return builder for chaining
		 */
		public Builder<T> addChild( Builder<T> child ) {
			addChild( child.build() );
			return this;
		}
		
		/**
		 * Adds child to this node.
		 * 
		 * @param child node to add
		 * @return builder for chaining
		 */
		public Builder<T> addChild( ImmutableNode<T> child ) {
			children.add( child );
			return this;
		}
		
		/**
		 * @return ImmutableNode built from this builder instance
		 */
		public ImmutableNode<T> build() {
			return new ImmutableNode<T>( this );
		}
		
	}
}
