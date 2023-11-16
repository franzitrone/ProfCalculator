package de.uulm.sp.swt.profcalculator;

import de.uulm.sp.swt.profcalculator.expressions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfCalculator implements Runnable, ActionListener {

    private final static Value DEFAULT_VALUE = new Value(0);
    private Expression expression = DEFAULT_VALUE;
    private JLabel errorLabel = new JLabel();
    private JTextField inputField = new JTextField();
    private JButton addButton = new JButton("+");
    private JButton multButton = new JButton("*");
    private JLabel resultLabel = new JLabel();

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            int newValue = Integer.parseInt(inputField.getText());
            if (event.getSource() == addButton) {
                expression = new Add(expression, new Value(newValue));
            } else {
                expression = new Mult(expression, new Value(newValue));
            }
            expression = new NecessaryBrackets(expression);
            updateGUI();
            inputField.requestFocusInWindow();
        } catch (NumberFormatException e) {
            errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
        }
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Professorial Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        errorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        inputField.setAlignmentX(Component.LEFT_ALIGNMENT);
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        multButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        errorLabel.setForeground(Color.RED);
        inputField.setPreferredSize(new Dimension(300, 20));
        addButton.addActionListener(this);
        multButton.addActionListener(this);

        frame.add(errorLabel);
        frame.add(inputField);
        frame.add(addButton);
        frame.add(multButton);
        frame.add(resultLabel);
        updateGUI();
        frame.pack();
        frame.setVisible(true);
    }

    private void updateGUI() {
        resultLabel.setText(expression.computeEquation());
        inputField.setText("");
        errorLabel.setText(" ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ProfCalculator());
    }
}
