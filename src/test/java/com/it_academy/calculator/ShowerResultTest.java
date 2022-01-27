package com.it_academy.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShowerResultTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void testShowAdditionResult_CheckOutPutInformation_PositiveDouble() {
        double result = 5.98;
        ShowerResult.showAdditionResult(result);
        assertEquals("The result of addition is 5.98000\n", output.toString());
    }

    @Test
    void testShowAdditionResult_CheckOutPutInformation_NegativeDouble() {
        double result = -8;
        ShowerResult.showAdditionResult(result);
        assertEquals("The result of addition is -8.00000\n", output.toString());
    }

    @Test
    void testShowSubtractionResult_CheckOutPutInformation_PositiveDouble() {
        double result = 5;
        ShowerResult.showSubtractionResult(result);
        assertEquals("The result of subtraction is  5.00000\n", output.toString());
    }

    @Test
    void testShowSubtractionResult_CheckOutPutInformation_NegativeDouble() {
        double result = -9.09;
        ShowerResult.showSubtractionResult(result);
        assertEquals("The result of subtraction is  -9.09000\n", output.toString());
    }

    @Test
    void testShowMultiplicationResult_CheckOutPutInformation_PositiveDouble() {
        double result = 9.03;
        ShowerResult.showMultiplicationResult(result);
        assertEquals("The result of multiplication is 9.03000\n", output.toString());
    }

    @Test
    void testShowMultiplicationResult_CheckOutPutInformation_NegativeDouble() {
        double result = -1;
        ShowerResult.showMultiplicationResult(result);
        assertEquals("The result of multiplication is -1.00000\n", output.toString());
    }

    @Test
    void testShowDivisionResult_CheckOutPutInformation_PositiveDouble() {
        double result = 0.00001;
        ShowerResult.showDivisionResult(result);
        assertEquals("The result of division is  0.00001\n", output.toString());
    }

    @Test
    void testShowDivisionResult_CheckOutPutInformation_NegativeDouble() {
        double result = -34.002;
        ShowerResult.showDivisionResult(result);
        assertEquals("The result of division is  -34.00200\n", output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}