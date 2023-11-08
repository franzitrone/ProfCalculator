package de.uulm.sp.swt.profcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfCalculator implements Runnable, ActionListener {

    private final static VALUE defaultvalue = new VALUE(0);
    private add addition = new add(defaultvalue, defaultvalue);
    private JLabel ERROR = new JLabel(" ");
    private JTextField i = new JTextField("");
    private JButton a = new JButton("+");
    private JLabel reSult = new JLabel(addition.computeAnEquationRepresentingTheExpressionAndItsValue());

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            int newValue = Integer.parseInt(i.getText()); int oldResult = addition.evaluatetheexpressiontoanintegervalue();
            addition = new add(new VALUE(oldResult), new VALUE(newValue)); reSult.setText(addition.computeAnEquationRepresentingTheExpressionAndItsValue());
            i.setText(""); ERROR.setText(" "); i.requestFocusInWindow();
        } catch (NumberFormatException e) { ERROR.setText("\"" + i.getText() + "\" is not a valid integer");}
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Professorial Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        //Didn't really work:
        //frame.setLayout(new BorderLayout());
        //Box layout = Box.createVerticalBox();
        //frame.getContentPane().add(layout);


        ERROR.setAlignmentX(Component.LEFT_ALIGNMENT);
        i.setAlignmentX(Component.LEFT_ALIGNMENT);
        a.setAlignmentX(Component.LEFT_ALIGNMENT);
        reSult.setAlignmentX(Component.LEFT_ALIGNMENT);

        ERROR.setForeground(Color.RED);
        i.setPreferredSize(new Dimension(300, 20));
        a.addActionListener(this);

        frame.add(ERROR);
        frame.add(i);
        frame.add(a);
        frame.add(reSult);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ProfCalculator());
    }
}
