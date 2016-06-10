package mvc.calculator;

public class Calculator {

	/**
	 * Launch the calculator
	 * @param args
	 */
	public static void main(String[] args) {
		new CalculatorController(new CalculatorView(), new CalculatorModel());
	}
	
}
