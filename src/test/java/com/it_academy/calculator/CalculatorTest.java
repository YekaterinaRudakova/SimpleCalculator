
package com.it_academy.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void createInstance() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"3.0,5.0,8.0", "0.0,-1.0,-1.0", "0.0,0.0,0.0", "-3.0,-2.0,-5.0", "-4.0,5.0,1.0"})
    public void testAdditional_Mix_PositiveAndNegative_Numbers(double firstDouble, double secondDouble, double expectedResult) {
        Assertions.assertEquals(
                calculator.add(firstDouble, secondDouble), expectedResult,
                "Addition works incorrect for the following values "
                        + firstDouble + " and " + secondDouble);
    }

    @ParameterizedTest
    @CsvSource({"3.0,5.0,-2.0", "0.0,-1.0,1.0", "0.0,0.0,0.0", "-3.0,-2.0,-1.0", "-4.0,5.0,-9.0"})
    public void testSubtraction_Mix_PositiveAndNegative_Numbers(double firstDouble, double secondDouble, double expectedResult) {
        Assertions.assertEquals(
                calculator.subtract(firstDouble, secondDouble), expectedResult,
                "Subtraction works incorrect for the following values "
                        + firstDouble + " and " + secondDouble);
    }

    @ParameterizedTest
    @CsvSource({"3.0,5.0,15.0", "5,-1.0,-5.0", "0.0,0.0,0.0", "-3.0,-2.0,6.0", "-4.0,5.0,-20.0"})
    public void testMultiplication_Mix_PositiveAndNegative_Numbers(double firstDouble, double secondDouble, double expectedResult) {
        Assertions.assertEquals(
                calculator.multiply(firstDouble, secondDouble), expectedResult,
                "Multiplication works incorrect for the following values "
                        + firstDouble + " and " + secondDouble);
    }

    @ParameterizedTest
    @CsvSource({"3.0,5.0,0.6", "8,-1.0,-8.0", "-3.0,-2.0,1.5", "-4.0,5.0,-0.8"})
    public void testDivision_Mix_PositiveAndNegative_Numbers(double firstDouble, double secondDouble, double expectedResult) {
        Assertions.assertEquals(
                calculator.divide(firstDouble, secondDouble), expectedResult,
                "Division works incorrect for the following values "
                        + firstDouble + " and " + secondDouble);
    }
}

