package de.uulm.sp.swt.profcalculator.expressions;

import de.uulm.sp.swt.profcalculator.ProfCalculator;

import javax.swing.*;

public class CounterValue extends Value implements Runnable {

    private ProfCalculator calc;
    public CounterValue(ProfCalculator calc) {
        super(0);
        this.calc = calc;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (value < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            value++;
            SwingUtilities.invokeLater(() -> {
                calc.updateGUI();
            });

        }
    }
}
