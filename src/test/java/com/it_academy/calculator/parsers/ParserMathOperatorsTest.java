package com.it_academy.calculator.parsers;

import com.it_academy.calculator.Operators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserMathOperatorsTest {
    private ParserMathOperators parserMathOperator;
    private Operators operator;

    @BeforeEach
    void createInstance() {
        parserMathOperator = new ParserMathOperators();
    }

    @Test
    void testCheckMathOperator_Addition() {
        operator = Operators.add;
        String inputOperator = "+";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_Subtraction() {
        operator = Operators.sub;
        String inputOperator = "-";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_Multiplication() {
        operator = Operators.mul;
        String inputOperator = "*";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_Division() {
        operator = Operators.div;
        String inputOperator = "/";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_UnknownOperator_Letters() {
        operator = Operators.unknown;
        String inputOperator = "fgghj";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_UnknownOperator_Numbers() {
        operator = Operators.unknown;
        String inputOperator = "655432";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_UnknownOperator_Spaces() {
        operator = Operators.unknown;
        String inputOperator = "        ";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }

    @Test
    void testCheckMathOperator_UnknownOperator_MixCharacters() {
        operator = Operators.unknown;
        String inputOperator = "+  hdgdgd666";
        assertEquals(operator, parserMathOperator.checkMathOperator(inputOperator));
    }
}