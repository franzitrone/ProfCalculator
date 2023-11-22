package de.uulm.sp.swt.profcalculator.gui;

import javax.swing.*;
import java.awt.*;

// ConcreteFactory of Abstract Factory Pattern
public class LargeFontGUIFactory implements GUIFactory {
    final static Font FONT = new Font("Arial", Font.PLAIN, 24);

    @Override
    public JLabel createLabel() {
        JLabel label = new JLabel();
        label.setFont(FONT);
        return label;
    }

    @Override
    public JButton createButton(String title) {
        JButton button = new JButton(title);
        button.setFont(FONT);
        return button;
    }
}
