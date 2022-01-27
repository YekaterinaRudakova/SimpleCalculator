package com.it_academy.calculator.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ParserDoubleOperatorsTest {
    private ParserDoubleOperators parserDoubleOperator;

    @BeforeEach
    void createInstance() {
        parserDoubleOperator = new ParserDoubleOperators();
    }

    @ParameterizedTest
    @CsvSource({"5,5.0", "3.0,3.0", "-1,-1.0", "-0.78,-0.78"})
    void testParseToDouble_InputSimpleNumber(String inputNumber, Double expectedResult) {

        assertEquals(parserDoubleOperator.parseToDouble(inputNumber), expectedResult,
                "ParserToDouble works incorrect for the following string " + inputNumber);
    }

    @ParameterizedTest
    @CsvSource({"   5,5.0", "3.0     ,3.0", "    -1     ,-1.0", "-0.78,-0.78"})
    void testParseToDouble_InputSimpleNumber_WithSpaces(String inputNumber, Double expectedResult) {

        assertEquals(parserDoubleOperator.parseToDouble(inputNumber), expectedResult,
                "ParserToDouble works incorrect for the following string " + inputNumber);
    }
}