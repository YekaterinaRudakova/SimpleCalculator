package com.it_academy.calculator.scanners;

public class ScannerReal implements IScanner {
    public String doScanning() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }
}
