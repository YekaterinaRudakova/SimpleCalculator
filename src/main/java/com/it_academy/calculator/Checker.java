package com.it_academy.calculator;

public class Checker {
    public boolean checkSecondDouble(Operators operator, double secondDouble) {
        if (operator == Operators.div & secondDouble == 0) {
            System.out.println("It is forbidden to divide by zero!");
            return false;
        }
        return true;
    }
}
