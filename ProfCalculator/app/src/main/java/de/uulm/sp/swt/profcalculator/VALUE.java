package de.uulm.sp.swt.profcalculator;

public class VALUE {

        Integer value;

        public VALUE(int value)
        {
    this.value = value;
    }

        public String toString()
    {
            return value.toString();
        }

    public int getValue() { return value.intValue(); }}