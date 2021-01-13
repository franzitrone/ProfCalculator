package de.uulm.sp.swt.profcalculator;

import de.uulm.sp.swt.profcalculator.expressions.Addition;
import de.uulm.sp.swt.profcalculator.expressions.CounterValue;
import de.uulm.sp.swt.profcalculator.expressions.Expression;
import de.uulm.sp.swt.profcalculator.expressions.Multiplication;
import de.uulm.sp.swt.profcalculator.expressions.NecessaryBrackets;
import de.uulm.sp.swt.profcalculator.expressions.Value;
import de.uulm.sp.swt.profcalculator.gui.BlueFontGUIFactory;
import de.uulm.sp.swt.profcalculator.gui.GUIFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProfCalculator	extends Application implements EventHandler<ActionEvent> {

	private Expression expression = new CounterValue(this);
	
	private GUIFactory guiFactory = new BlueFontGUIFactory();

	private Label errorLabel = guiFactory.createLabel();

	private TextField inputField = new TextField();

	private Button additionButton = guiFactory.createButton("+");
	private Button multiplicationButton = guiFactory.createButton("*");

	private Label resultLabel = guiFactory.createLabel();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Professorial Calculator");
		errorLabel.setTextFill(Color.web("#AA0000"));

		VBox layout = new VBox(10, errorLabel, inputField, additionButton, multiplicationButton, resultLabel);
		layout.setPadding(new Insets(20, 80, 20, 80));
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
		additionButton.setOnAction(this);
		multiplicationButton.setOnAction(this);
		updateGUI();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			int newValue = Integer.parseInt(inputField.getText());
			if (event.getSource() == additionButton) {
				expression = new Addition(expression, new Value(newValue));
				Logger.getLogger().log("+ " + newValue);
			}
			else if (event.getSource() == multiplicationButton) {
				expression = new Multiplication(expression, new Value(newValue));
				Logger.getLogger().log("* " + newValue);
			}
			expression = new NecessaryBrackets(expression);
			updateGUI();
			inputField.requestFocus();
		} catch (NumberFormatException e) {
			errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
		}
	}

	public void updateGUI() {
		resultLabel.setText(expression.computeEquation());
		inputField.setText("");
		errorLabel.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
