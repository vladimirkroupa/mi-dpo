package cz.cvut.fit.dpo.strategy.tree.node;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.collect.Lists;

/**
 * Immutable tree node using {@link ArrayList} to hold child nodes.
 *
 * @param <T>
 * 
 * @author kroupvla
 */
public class ImmutableNode<T> implements Node<T> {

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
	 * Builder for {@link BinaryNode}. 
	 *
	 * @param <T> node content type
	 * 
	 * @author kroupvla
	 */
	public static class Builder<T> {
		
		private final T content;
		private List<ImmutableNode<T>> children;
		
		public Builder( T content ) {
			this.content = content;
			children = Lists.newArrayList();
		}
		
		public Builder<T> addChild( Builder<T> child ) {
			children.add( child.build() );
			return this;
		}
		
		public ImmutableNode<T> build() {
			return new ImmutableNode<T>( this );
		}
		
	}
}
