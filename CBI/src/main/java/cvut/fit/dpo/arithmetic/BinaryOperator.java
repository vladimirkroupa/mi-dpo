package cvut.fit.dpo.arithmetic;


/**
 * Represents the Binary operations like + - etc.
 * 
 * @author Jan Kurš
 * 
 */
public abstract class BinaryOperator implements ArithmeticExpression {
	
	private final ArithmeticExpression leftOperand;
	private final ArithmeticExpression rightOperand;

	public BinaryOperator(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public Integer evaluate() {
		return evaluate(leftOperand, rightOperand);
	}

	protected abstract Integer evaluate(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand);
	
	public ArithmeticExpression getFirstOperand() {
		return leftOperand;
	}

	public ArithmeticExpression getSecondOperand() {
		return rightOperand;
	}

}
