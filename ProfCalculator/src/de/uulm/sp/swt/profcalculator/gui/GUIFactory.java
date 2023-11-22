package de.uulm.sp.swt.profcalculator.gui;

import javax.swing.*;

// AbstractFactory of Abstract Factory Pattern
public interface GUIFactory {
    JLabel createLabel();

    JButton createButton(String title);
}
