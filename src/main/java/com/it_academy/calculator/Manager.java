package com.it_academy.calculator;

import com.it_academy.calculator.parsers.ParserDoubleOperators;
import com.it_academy.calculator.parsers.ParserMathOperators;
import com.it_academy.calculator.scanners.IScanner;

public class Manager {
    private final IScanner scanner;

    public double result;
    public double firstDouble;
    public double secondDouble;
    public Operators operator;

    public Manager(IScanner scanner){
        this.scanner = scanner;
    }

    public boolean getMathOperator() {
        System.out.print("Please input a sign of operation: ");
        String mathOperator = scanner.doScanning().trim();
        ParserMathOperators parserMathOperator = new ParserMathOperators();
        operator = parserMathOperator.checkMathOperator(mathOperator);
        if(operator==Operators.unknown){
            System.out.println("You have input the incorrect sign of math operation!");
            return false;
        }
        return true;
    }

    public boolean getFirstDouble() {
        System.out.print("Please input the first number: ");
        String firstNumber = scanner.doScanning();
        try {
            ParserDoubleOperators parser = new ParserDoubleOperators();
            firstDouble = parser.parseToDouble(firstNumber);
        } catch (NumberFormatException e) {
            System.out.println("You have input incorrect data!");
            return false;
        }
        return true;
    }

    public boolean getSecondDouble() {
        System.out.print("Please input the second number: ");
        String secondNumber = scanner.doScanning();
        try {
            ParserDoubleOperators parser = new ParserDoubleOperators();
            secondDouble = parser.parseToDouble(secondNumber);
            Checker checker = new Checker();
            return checker.checkSecondDouble(operator, secondDouble);
        } catch (NumberFormatException e) {
            System.out.println("You have input incorrect data!");
            return false;
        }
    }

    public void calculate() {
        Calculator calculator=new Calculator();
        if (operator==Operators.add) {
            result = calculator.add(firstDouble, secondDouble);
        }
        if (operator==Operators.sub) {
            result = calculator.subtract(firstDouble, secondDouble);
        }
        if (operator==Operators.mul) {
            result = calculator.multiply(firstDouble, secondDouble);
        }
        if (operator==Operators.div) {
            result = calculator.divide(firstDouble, secondDouble);
        }
    }

    public void showResult() {
        if (operator==Operators.add) {
            ShowerResult.showAdditionResult(result);
        }
        if (operator==Operators.sub) {
            ShowerResult.showSubtractionResult(result);
        }
        if (operator==Operators.mul) {
            ShowerResult.showMultiplicationResult(result);
        }
        if (operator==Operators.div) {
            ShowerResult.showDivisionResult(result);
        }
    }
}
