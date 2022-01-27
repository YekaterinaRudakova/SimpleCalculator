package com.it_academy.calculator.parsers;

import com.it_academy.calculator.Operators;

public class ParserMathOperators {
    public Operators checkMathOperator(String mathOperator) {
        return switch (mathOperator) {
            case "+" -> Operators.add;
            case "-" -> Operators.sub;
            case "*" -> Operators.mul;
            case "/" -> Operators.div;
            default -> Operators.unknown;
        };
    }
}
