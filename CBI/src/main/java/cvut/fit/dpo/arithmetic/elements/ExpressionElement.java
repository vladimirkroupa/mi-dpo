package cvut.fit.dpo.arithmetic.elements;

public abstract class ExpressionElement
{
	public abstract String stringValue();

	@Override
	public String toString() {
		return stringValue();
	}
	
}
