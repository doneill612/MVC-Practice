package mvc.calculator;

/**
 * The logic model for our calculator. <br>This class contains all of the pertinent
 * information about how to do basic mathematical operations supported by
 * the calculator - in this case to add, multiply, subtract, and divide.
 * @author David
 *
 */
public final class CalculatorModel {

	/**
	 * The first number to perform an operation with
	 */
	private double currentEntry;
	/**
	 * The second number to perform an operation with
	 */
	private double nextEntry;
	/**
	 * The result of an operation
	 */
	private double result;
	/**
	 * Have we pressed an operation button?
	 */
	private boolean calculating;
	/**
	 * The operation we are performing.
	 */
	private Operations operation;
	
	/**
	 * The type of operation we are trying to execute.
	 * @author David
	 *
	 */
	protected static enum Operations {
		ADD, MULTIPLY, DIVIDE, SUBTRACT;
	}
	/**
	 * Not much to say here
	 */
	protected CalculatorModel() {
		
	}
	/**
	 * Check if the calculator is calculating
	 * @return
	 */
	public boolean isCalculating() {
		return calculating;
	}
	/**
	 * Set the calculating parameter
	 * @param calculating
	 */
	public void setCalculating(boolean calculating) {
		this.calculating = calculating;
	}
	
	/**
	 * Add two numbers together
	 * @param first
	 * @param second
	 * @return the result
	 */
	private double add(double first, double second) {
		return first + second;
	}
	/**
	 * Subtract two numbers
	 * @param first
	 * @param second
	 * @return the result
	 */
	private double subtract(double first, double second) {
		return first - second;
	}
	/**
	 * Multiply two numbers together
	 * @param first
	 * @param second
	 * @return the result
	 */
	private double multiply(double first, double second) {
		return first * second;
	}
	/**
	 * Divide two numbers into each other
	 * @param first
	 * @param second
	 * @return the result
	 */
	private double divide(double first, double second) {
		return first / second;
	}
	/**
	 * Get the current entry
	 * @return {@code currentEntry}
	 */
	public double getCurrentEntry() {
		return currentEntry;
	}
	/**
	 * Get the next entry
	 * @return {@code nextEntry}
	 */
	public double getNextEntry() {
		return nextEntry;
	}
	/**
	 * Set the current entry
	 * @param value
	 */
	public void setCurrentEntry(double value) {
		this.currentEntry = value;
		calculating = true;
	}
	/**
	 * Set the next entry
	 * @param value
	 */
	public void setNextEntry(double value) {
		this.nextEntry = value;
	}
	/**
	 * Get the current operation we are planning to execute
	 * @return {@code operation}
	 */
	public Operations getOperation() {
		return operation;
	}
	/**
	 * Set the operation we want to execute
	 * @param operation
	 */
	public void setOperation(Operations operation) {
		this.operation = operation;
	}
	/**
	 * Calculate the result
	 * @return {@code result}
	 */
	public double calculateResult() {
		switch(operation) {
			case ADD:
				result = add(currentEntry, nextEntry);
				break;
			case MULTIPLY:
				result = multiply(currentEntry, nextEntry);
				break;
			case DIVIDE:
				result = divide(currentEntry, nextEntry);
				break;
			case SUBTRACT:
				result = subtract(currentEntry, nextEntry);
				break;
			default: result = 0; break;
		}
		currentEntry = result;
		nextEntry = 0;
		calculating = false;
		return result;
	}
	
	/**
	 * Clear the model data
	 */
	public void clear() {
		nextEntry = currentEntry = 0;
		result = 0;
		calculating = false;
	}
}