package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public interface GUIFactory {

	Label createLabel();

	Button createButton(String title);

}