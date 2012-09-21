package cz.cvut.fit.dpo.strategy.tree.node;

import java.util.NoSuchElementException;

import cz.cvut.fit.dpo.strategy.util.ReflectionObject;

/**
 * Adapts {@link BinaryNode} to more general (n-ary) {@link INode}.
 * 
 * @param <T> node content type
 * 
 * @author kroupvla
 */
public class BinaryNodeToNaryAdapter<T> extends ReflectionObject implements INode<T> {

	private final BinaryNode<T> adaptee;
	
	public BinaryNodeToNaryAdapter( BinaryNode<T> adaptee ) {
		this.adaptee = adaptee;
	}

	@Override
	public T content() {
		return adaptee.content();
	}

	@Override
	public boolean hasChild( int index ) {
		switch ( index ) {
			case 0 : return childCount() >= 1; 
			case 1 : return childCount() == 2;
			default: return false;
		}
	}

	@Override
	public INode<T> child( int index ) {
		if ( ! hasChild( index ) ) {
			throw new NoSuchElementException();
		}
		switch ( index ) {
			case 0 : return adapt( adaptee.hasLeft() ? adaptee.left() : adaptee.right() );
			case 1 : return adapt( adaptee.right() ) ;
			default: throw new IllegalStateException();
		}
	}

	@Override
	public int childCount() {
		int count = 0;
		if ( adaptee.hasLeft() ) {
			count++;
		}
		if ( adaptee.hasRight() ) {
			count++;
		}
		return count;
	}
	
	private INode<T> adapt( BinaryNode<T> adaptee ) {
		return new BinaryNodeToNaryAdapter<T>( adaptee );
	}
	
}
