package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BlueFontGUIFactory implements GUIFactory {
	
	final static Color BLUE = Color.web("#0000AA");
	
	@Override
	public Label createLabel() {
		Label label = new Label();
		label.setTextFill(BLUE);
		return label;
	}

	@Override
	public Button createButton(String title) {
		Button button = new Button(title);
		button.setTextFill(BLUE);
		return button;
	}

}
