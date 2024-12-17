package de.uulm.sp.swt.profcalculator;

import de.uulm.sp.swt.profcalculator.expressions.*;
import de.uulm.sp.swt.profcalculator.gui.BlueFontGUIFactory;
import de.uulm.sp.swt.profcalculator.gui.GUIFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.LinkedList;

public class ProfCalculator implements Runnable, ActionListener {

    private Expression expression = new CounterValue(this, false);
    private GUIFactory guiFactory = new BlueFontGUIFactory();
    private JLabel errorLabel = guiFactory.createLabel();
    private JTextField inputField = new JTextField();
    private JButton additionButton = guiFactory.createButton("+");
    private JButton multiplicationButton = guiFactory.createButton("*");
    private JButton undoButton = guiFactory.createButton("UNDO");
    private JButton redoButton = guiFactory.createButton("REDO");
    private JLabel resultLabel = guiFactory.createLabel();
    private LinkedList<Expression.Command> commandHistory = new LinkedList<>();
    private int commandHistoryPosition = -1;

    private void undo() {
        if (commandHistoryPosition < 0) {
            return;
        }

        expression = commandHistory.get(commandHistoryPosition).undo();
        commandHistoryPosition--;
    }

    private void redo() {
        if (isLastCommand()) {
            return;
        }

        commandHistoryPosition++;
        expression = commandHistory.get(commandHistoryPosition).apply();
    }

    private Expression addCommand(Expression previousExpression, Expression newExpression) {
        clearRedoCommands();

        commandHistoryPosition++;
        commandHistory.addLast(newExpression.asCommand(previousExpression));

        return newExpression;
    }

    private boolean isLastCommand() {
        return commandHistoryPosition + 1 >= commandHistory.size();
    }

    private void clearRedoCommands() {
        while (!isLastCommand()) {
            commandHistory.removeLast();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Object source = event.getSource();
            if (source == additionButton || source == multiplicationButton) {
                int newValue = Integer.parseInt(inputField.getText());
                if (event.getSource() == additionButton) {
                    expression = addCommand(expression, new Addition(expression, new Value(newValue)));
                    Logger.getLogger().log("+ " + newValue);
                } else if (event.getSource() == multiplicationButton) {
                    expression = addCommand(expression, new Multiplication(expression, new Value(newValue)));
                    Logger.getLogger().log("* " + newValue);
                }
            } else if (event.getSource() == undoButton) {
                undo();
                Logger.getLogger().log("UNDO");
            } else if (event.getSource() == redoButton) {
                redo();
                Logger.getLogger().log("REDO");
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
        additionButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        multiplicationButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        errorLabel.setForeground(Color.RED);
        inputField.setPreferredSize(new Dimension(300, 20));
        additionButton.addActionListener(this);
        multiplicationButton.addActionListener(this);
        undoButton.addActionListener(this);
        redoButton.addActionListener(this);

        frame.add(errorLabel);
        frame.add(inputField);
        frame.add(additionButton);
        frame.add(multiplicationButton);
        frame.add(undoButton);
        frame.add(redoButton);
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

    public void updateResultLabel() {
        resultLabel.setText(expression.computeEquation());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ProfCalculator());
    }
}
