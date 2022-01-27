package com.it_academy.calculator;

import com.it_academy.calculator.scanners.ScannerReal;

public class CalculatorRunner {
    public Manager manager;

    public CalculatorRunner() {
        ScannerReal scanner = new ScannerReal();

        manager = new Manager(scanner);
    }

    public void RunCalculator() {
        runLoopOperators();
        runLoopFirstDouble();
        runLoopSecondDouble();
        manager.calculate();
        manager.showResult();
    }

    public void runLoopOperators() {
        while (true) {
            if (manager.getMathOperator()) {
                break;
            }
        }
    }

    public void runLoopFirstDouble() {
        while (true) {
            if (manager.getFirstDouble()) {
                break;
            }
        }
    }

    public void runLoopSecondDouble() {
        while (true) {
            if (manager.getSecondDouble()) {
                break;
            }
        }
    }
}
