package com.it_academy.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    private Checker checker;
    private Operators operator;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    void createInstance() {
        checker = new Checker();
    }

    @Test
    void testCheckSecondDouble_OperatorDivision_SecondDoubleIsZero() {
        operator = Operators.div;
        double secondDouble = 0;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertFalse(result);
    }

    @Test
    void testCheckSecondDouble_OperatorAddition_SecondDoubleIsZero() {
        operator = Operators.add;
        double secondDouble = 0;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @Test
    void testCheckSecondDouble_OperatorSubtraction_SecondDoubleIsZero() {
        operator = Operators.sub;
        double secondDouble = 0;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @Test
    void testCheckSecondDouble_OperatorMultiplication_SecondDoubleIsZero() {
        operator = Operators.mul;
        double secondDouble = 0;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @Test
    void testCheckSecondDouble_OperatorDivision_SecondDoubleIsNotZero() {
        operator = Operators.div;
        double secondDouble = 5;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @Test
    void testCheckSecondDouble_OperatorAddition_SecondDoubleIsNotZero() {
        operator = Operators.add;
        double secondDouble = 3;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @Test
    void testCheckSecondDouble_OperatorSubtraction_SecondDoubleIsNotZero() {
        operator = Operators.sub;
        double secondDouble = 9.04;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @Test
    void testCheckSecondDouble_OperatorMultiplication_SecondDoubleIsNotZero() {
        operator = Operators.mul;
        double secondDouble = -3.085;
        boolean result = checker.checkSecondDouble(operator, secondDouble);
        assertTrue(result);
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}