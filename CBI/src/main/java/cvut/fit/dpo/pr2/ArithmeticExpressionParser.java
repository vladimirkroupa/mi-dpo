package cvut.fit.dpo.pr2;

import java.util.regex.Pattern;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.builder.ArithmeticExpressionBuilder;

public class ArithmeticExpressionParser {
	
	private final ArithmeticExpressionBuilder builder; 
	
	public ArithmeticExpressionParser(ArithmeticExpressionBuilder builder) {
		this.builder = builder;
	}

	public ArithmeticExpression parse(String rpnInput) {

		if (rpnInput.trim().isEmpty()) {
			throw new IllegalArgumentException("Empty expression.");
		}

		for (String token : rpnInput.split(" ")) {
			parseToken(token);
		}
		
		return builder.getResult();
	}

	private void parseToken(String token) {
		if (isNumericOperand(token)) {
			Integer value = Integer.parseInt(token);
			builder.buildNumericOperand(value);
		} else {
			switch (token) {
				case "+" : builder.buildAddOperator(); break;
				case "-" : builder.buildSubtractOperator(); break;
				case "(" : builder.buildOpeningBracketOperator(); break;
				case ")" : builder.buildClosingBracketOperator(); break;
				default : throw new IllegalArgumentException("Unknown expression element: " + token);
			}
		}
	}
	
	private boolean isNumericOperand(String s) {
		final String REGEXP = "\\d";
		return Pattern.matches(REGEXP, s);
	}

}
