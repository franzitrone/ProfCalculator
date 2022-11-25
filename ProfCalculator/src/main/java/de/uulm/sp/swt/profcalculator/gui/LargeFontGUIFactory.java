package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LargeFontGUIFactory implements GUIFactory {
	
	final static Font FONT = new Font("Arial", 24);
	
	@Override
	public Label createLabel() {
		Label label = new Label();
		label.setFont(FONT);
		return label;
	}

	@Override
	public Button createButton(String title) {
		Button button = new Button(title);
		button.setFont(FONT);
		return button;
	}

}
