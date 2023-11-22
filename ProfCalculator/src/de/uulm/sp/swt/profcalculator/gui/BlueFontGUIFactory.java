package de.uulm.sp.swt.profcalculator.gui;

import javax.swing.*;
import java.awt.*;

// ConcreteFactory of Abstract Factory Pattern
public class BlueFontGUIFactory implements GUIFactory {

    final static Color BLUE = new Color(0, 0, 255);

    @Override
    public JLabel createLabel() {
        JLabel label = new JLabel();
        label.setForeground(BLUE);
        return label;
    }

    @Override
    public JButton createButton(String title) {
        JButton button = new JButton(title);
        button.setForeground(BLUE);
        return button;
    }
}
