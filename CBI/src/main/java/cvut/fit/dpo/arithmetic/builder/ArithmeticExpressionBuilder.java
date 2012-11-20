package cvut.fit.dpo.arithmetic.builder;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;

public interface ArithmeticExpressionBuilder {

	void buildNumericOperand(Integer value);
	
	void buildAddOperator();
	
	void buildSubtractOperator();
	
	void buildOpeningBracketOperator();
	
	void buildClosingBracketOperator();
	
	ArithmeticExpression getResult();
	
}
