package cz.cvut.fit.dpo.strategy.tree.node;

import java.util.NoSuchElementException;

import cz.cvut.fit.dpo.strategy.util.ReflectionObject;

public class BinaryNode<T> extends ReflectionObject {

	private final BinaryNode<T> left;
	private final BinaryNode<T> right;
	private final T content;
	
	public BinaryNode( Builder<T> builder ) {
		this.content = builder.content;
		this.left = builder.left;
		this.right = builder.right;
	}

	public T content() {
		return content;
	}
	
	public boolean hasLeft() {
		return ( left != null );
	}
	// Node elvis;
	// boolean building = elvis.hasLeft();
	
	public boolean hasRight() {
		return ( right != null );
	}
	
	public BinaryNode<T> left() {
		if ( ! hasLeft() ) {
			throw new NoSuchElementException();
		}
		return left;		
	}
	
	public BinaryNode<T> right() {
		if ( ! hasRight() ) {
			throw new NoSuchElementException();	
		}
		return right;
	}
	
	public static <T> Builder<T> builder( T content) {
		return new Builder<T>( content );
	}

	public static class Builder<T> {
		
		private final T content;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		public Builder( T content ) {
			this.content = content;
		}
		
		public Builder<T> withLeft( Builder<T> left ) {
			this.left = left.build();
			return this;
		}
		
		public Builder<T> withRight( Builder<T> right ) {
			this.right = right.build();
			return this;
		}		
		
		public BinaryNode<T> build() {
			return new BinaryNode<T>( this );
		}
	}
	
}
