package com.it_academy.calculator;


import com.it_academy.calculator.scanners.ScannerFake;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void testGetMathOperator_CheckOutputInformation_inConsole_IfOperatorIsAddition() {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "+";
        Manager manager = new Manager(scannerFake);
        manager.getMathOperator();
        assertEquals("Please input a sign of operation: ", output.toString());
    }

    @Test
    void testGetFirstDouble_CheckOutputInformation_inConsole_IfInputNumberIsCorrect() {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "25";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.add;
        manager.getFirstDouble();
        assertEquals("Please input the first number: ", output.toString());

    }

    @Test
    void testGetSecondDouble_CheckOutputInformation_inConsole_IfInputNumberIsCorrect() {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "234";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.add;
        manager.getSecondDouble();
        assertEquals("Please input the second number: ", output.toString());
    }

    @Test
    void testGetMathOperator_CheckCatchBlockInformation_InConsole_IfInputLetters() {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "dtdgd";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.add;
        manager.getMathOperator();
        assertEquals("Please input a sign of operation: You have input the incorrect sign of math operation!\n", output.toString());

    }

    @Test
    void testGetFirstDouble_checkCatchBlockInformation_InConsole_IfInputLetters() {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "gghhjk";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.add;
        manager.getFirstDouble();
        assertEquals("Please input the first number: You have input incorrect data!\n", output.toString());
    }

    @Test
    void testGetSecondDouble_CheckCatchBlockInformation_InConsole_IfInputMixLettersAndNumbers() {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "6nsh7";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.add;
        manager.getSecondDouble();
        assertEquals("Please input the second number: You have input incorrect data!\n", output.toString());

    }

    @ParameterizedTest
    @CsvSource({"5,8,13.0", "-4,6,2.0", "-3,-3,-6.0", "7,-8,-1.0", "0,0,0.0"})
    void testCalculate_CheckResult_IfOperatorIsAddition(double firstDouble, double secondDouble, double expectedResult) {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "234";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.add;
        manager.firstDouble = firstDouble;
        manager.secondDouble = secondDouble;
        manager.calculate();
        assertEquals(expectedResult, manager.result,
                "Method works incorrect for the following values " + firstDouble + "and" + secondDouble);
    }

    @ParameterizedTest
    @CsvSource({"5,8,-3.0", "-4,6,-10.0", "-3,-3,0.0", "7,-8,15.0", "0,0,0.0"})
    void testCalculate_CheckResult_IfOperatorIsSubtraction(double firstDouble, double secondDouble, double expectedResult) {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "234";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.sub;
        manager.firstDouble = firstDouble;
        manager.secondDouble = secondDouble;
        manager.calculate();
        assertEquals(expectedResult, manager.result,
                "Method works incorrect for the following values " + firstDouble + "and" + secondDouble);
    }

    @ParameterizedTest
    @CsvSource({"5,8,40.0", "-4,6,-24.0", "-3,-3,9.0", "7,-8,-56.0", "0,0,0.0"})
    void testCalculate_CheckResult_IfOperatorIsMultiplication(double firstDouble, double secondDouble, double expectedResult) {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "234";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.mul;
        manager.firstDouble = firstDouble;
        manager.secondDouble = secondDouble;
        manager.calculate();
        assertEquals(expectedResult, manager.result,
                "Method works incorrect for the following values " + firstDouble + "and" + secondDouble);
    }

    @ParameterizedTest
    @CsvSource({"5,8,0.625", "-6,4,-1.5", "-3,-3,1.0", "7,-8,-0.875"})
    void testCalculate_CheckResult_IfOperatorIsDivision(double firstDouble, double secondDouble, double expectedResult) {
        ScannerFake scannerFake = new ScannerFake();
        scannerFake.fakeResult = "234";
        Manager manager = new Manager(scannerFake);
        manager.operator = Operators.div;
        manager.firstDouble = firstDouble;
        manager.secondDouble = secondDouble;
        manager.calculate();
        assertEquals(expectedResult, manager.result,
                "Method works incorrect for the following values " + firstDouble + "and" + secondDouble);
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
