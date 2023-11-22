package de.uulm.sp.swt.profcalculator.gui;

import javax.swing.*;

public interface GUIFactory {

    JLabel createLabel();

    JButton createButton(String title);

}