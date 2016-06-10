package mvc.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A controller class to mediate the exchange of information between the model and the view.
 * @author David
 *
 */
public class CalculatorController {
	
	/**
	 * The view
	 */
	private CalculatorView view;
	/**
	 * The model
	 */
	private CalculatorModel model;
	
	/**
	 * We pass a view and model object into the constructor, and assign some action listeners to the buttons.
	 * Action listeners are used to monitor events on a particular JComponent, such as keystrokes, mouse clicks,
	 * mouse hovers, etc.
	 * @param v
	 * @param m
	 */
	public CalculatorController(CalculatorView v, CalculatorModel m) {
		this.view = v;
		this.model = m;
		
		for(int i = 0; i < 10; i++)
			view.getNumberButton(i).addActionListener(new NumberButtonClickedListener(i));
		
		view.getAdditionButton().addActionListener(new OperationButtonListener(CalculatorModel.Operations.ADD));
		view.getSubtractionButton().addActionListener(new OperationButtonListener(CalculatorModel.Operations.SUBTRACT));
		view.getMultiplyButton().addActionListener(new OperationButtonListener(CalculatorModel.Operations.MULTIPLY));
		view.getDivideButton().addActionListener(new OperationButtonListener(CalculatorModel.Operations.DIVIDE));
		view.getEqualsButton().addActionListener(new CalculateButtonListener());
		view.getClearButton().addActionListener(new ClearButtonListener());
	}
	/**
	 * This listener will capture what happens when a user interactions with a number button.
	 * @author David
	 *
	 */
	private class NumberButtonClickedListener implements ActionListener {
		
		/**
		 * The button pressed
		 */
		private int button;
		/**
		 * Assign the number to the listener.
		 * @param entry
		 */
		private NumberButtonClickedListener(int entry) {
			this.button = entry;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/**
			 * If we are calculating, reset the input field so
			 * a new input can start being constructed.
			 */
			if(model.isCalculating()) {
				model.setCalculating(false);
				view.setInputFieldText("");
			}
			String currentEntry = view.getInputFieldText();
			/**
			 * Begin constructing the input. Each subsequent press of a number
			 * button continues to add on characters to the end of the input.
			 * This is because we have already removed the previous entry in
			 * the {@code if} statement above.
			 */
			view.setInputFieldText(currentEntry.concat(String.valueOf(button)));
			
		}
		
	}
	/**
	 * This listener will capture what happens when a user interactions with an operation button.
	 * @author David
	 *
	 */
	private class OperationButtonListener implements ActionListener {
		
		/**
		 * The operation selected
		 */
		private CalculatorModel.Operations operation;
		/**
		 * Assign the operation to the listener.
		 * @param operation
		 */
		private OperationButtonListener(CalculatorModel.Operations operation) {
			this.operation = operation;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * If the input field is empty, assign a base starting value
			 * of zero.
			 */
			if(view.getInputFieldText().isEmpty())
				view.setInputFieldText("0");
			double currentValue = Double.parseDouble(view.getInputFieldText());
			/**
			 * Set the current value to zero.
			 */
			model.setCurrentEntry(currentValue);
			/**
			 * Assign the operation in the model.
			 */
			model.setOperation(operation);
			/**
			 * If we have alredy entered a previous value, continue compounding
			 * the operations from the previous calculation.
			 */
			if(model.getNextEntry() != 0)
				view.setInputFieldText(String.valueOf(model.calculateResult()));
		}
		
	}
	
	/**
	 * This listener will capture what happens when a user interactions with the equals button.
	 * @author David
	 *
	 */
	private class CalculateButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * Set the value of the calculation parameter if there is
			 * some non-zero value still in there.
			 */
			model.setNextEntry(Double.parseDouble(view.getInputFieldText()));
			/**
			 * Calculate the result, convert it to a string, and pass it into the view.
			 */
			view.setInputFieldText(String.valueOf(model.calculateResult()));
			/**
			 * We are now calculating with the result value, so we can just immediately
			 * call another operation if we wanted to.
			 */
			model.setCalculating(true);
		}
		
	}
	/**
	 * This listener will capture what happens when a user interactions with the clear button.
	 * @author David
	 *
	 */
	private class ClearButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * Clear the model data
			 */
			model.clear();
			/**
			 * Reset the input field
			 */
			view.setInputFieldText("");
		}
		
	}
}
