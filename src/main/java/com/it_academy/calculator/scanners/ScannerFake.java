package com.it_academy.calculator.scanners;

public class ScannerFake implements IScanner {
    public String fakeResult;

    @Override
    public String doScanning() {
        return fakeResult;
    }
}
