package mvc.calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * The view of our calculator. This is the GUI which will be displayed to the user,
 * and where the user will send input to the controller.
 * @author David
 *
 */
public class CalculatorView {

	/**
	 * The main calculator frame
	 */
	private JFrame calculator;
	/**
	 * The un-editable text field where input is displayed
	 */
	private JTextField inputField;
	/**
	 * A container panel where our number buttons are stored
	 */
	private JPanel numberButtonPanel;
	/**
	 * A container panel where our operation buttons are stored
	 */
	private JPanel operationsPanel;
	/**
	 * The add button
	 */
	private JButton addButton;
	/**
	 * The subtract button
	 */
	private JButton subtractButton;
	/**
	 * The multiply button
	 */
	private JButton multiplyButton;
	/**
	 * The divide button
	 */
	private JButton divideButton;
	/**
	 * The clear entry button
	 */
	private JButton clearButton;
	/**
	 * A button array containing buttons for the numbers 0-9
	 */
	private JButton[] numberButtons = new JButton[10];
	private JButton equalsButton;

	/**
	 * A protected contructor so as to limit the access point of the view to this package.
	 * <br>We only want to be able to instantiate our view in the controller, and since we
	 * are working from one package, best practice says to keep everything as localized (i.e. private)
	 * as possible.
	 */
	protected CalculatorView() {
		initialize();
		calculator.setVisible(true);
	}
	
	/**
	 * Initialization of all the view components.
	 */
	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Simple Calculator");
		calculator.setBounds(100, 100, 329, 225);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		
		
		inputField = new JTextField();
		inputField.setEditable(false);
		inputField.setBounds(10, 11, 249, 29);
		calculator.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		numberButtonPanel = new JPanel();
		numberButtonPanel.setBounds(10, 51, 174, 125);
		calculator.getContentPane().add(numberButtonPanel);
		numberButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for(int i = 1; i < 10; i ++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtonPanel.add(numberButtons[i]);
		}
		numberButtons[0] = new JButton("0");
		numberButtonPanel.add(numberButtons[0]);
		
		operationsPanel = new JPanel();
		operationsPanel.setBounds(194, 51, 65, 125);
		calculator.getContentPane().add(operationsPanel);
		operationsPanel.setLayout(null);
		
		addButton = new JButton("+");
		addButton.setBounds(0, 0, 65, 23);
		operationsPanel.add(addButton);
		
		subtractButton = new JButton("-");
		subtractButton.setBounds(0, 21, 65, 23);
		operationsPanel.add(subtractButton);
		
		multiplyButton = new JButton("*");
		multiplyButton.setBounds(0, 44, 65, 23);
		operationsPanel.add(multiplyButton);
		
		divideButton = new JButton("/");
		divideButton.setBounds(0, 66, 65, 23);
		operationsPanel.add(divideButton);
		
		clearButton = new JButton("C");
		clearButton.setBounds(0, 102, 65, 23);
		operationsPanel.add(clearButton);
		
		equalsButton = new JButton("=");
		equalsButton.setBounds(258, 95, 55, 23);
		calculator.getContentPane().add(equalsButton);
	}
	
	/**
	 * Accessor method for a button from the {@code numberButton} array.
	 * @param buttonIndex
	 * @return the associated {@code JButton}
	 */
	protected JButton getNumberButton(int buttonIndex) {
		return numberButtons[buttonIndex];
	}
	/**
	 * Accessor method for the add button.
	 * @return {@code addButton}
	 */
	protected JButton getAdditionButton() {
		return addButton;
	}
	/**
	 * Accessor method for the subtract button.
	 * @return {@code subtractButton}
	 */
	protected JButton getSubtractionButton() {
		return subtractButton;
	}
	/**
	 * Accessor method for the multiply button.
	 * @return {@code multiplyButton}
	 */
	protected JButton getMultiplyButton() {
		return multiplyButton;
	}
	/**
	 * Accessor method for the divide button.
	 * @return {@code divideButton}
	 */
	protected JButton getDivideButton() {
		return divideButton;
	}
	/**
	 * Accessor method for the clear button.
	 * @return {@code clearButton}
	 */
	protected JButton getClearButton() {
		return clearButton;
	}
	/**
	 * Accessor method for the equals button.
	 * @return{@code equalsButton}
	 */
	protected JButton getEqualsButton() {
		return equalsButton;
	}
	/**
	 * Accessor method for the text in the input field
	 * @return
	 */
	protected String getInputFieldText() {
		return inputField.getText();
	}
	/**
	 * Mutator method for changing the text in the input field
	 * @param text
	 */
	protected void setInputFieldText(String text) {
		inputField.setText(text);
	}
}
