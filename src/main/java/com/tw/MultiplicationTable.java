package com.tw;

public class MultiplicationTable {
    public String create(int startNumber, int endNumber) {
        boolean isValid = isValid(startNumber, endNumber);
        if (!isValid) {
            return null;
        }

        String multiplicationTable = generateMultiplicationTable(startNumber, endNumber);

        return multiplicationTable;
    }

    private boolean isValid(int startNumber, int endNumber) {
        boolean isStartNumberInRange = isNumberInRange(startNumber);
        boolean isEndNumberInRange = isNumberInRange(endNumber);
        boolean isEndBiggerThanStart = isEndBiggerThanStart(startNumber, endNumber);

        return isStartNumberInRange && isEndNumberInRange && isEndBiggerThanStart;
    }

    private boolean isNumberInRange(int number) {
        return 1 <= number && number <= 1000;
    }

    private boolean isEndBiggerThanStart(int startNumber, int endNumber) {
        return endNumber >= startNumber;
    }

    private String generateMultiplicationTable(int startNumber, int endNumber) {
        // logic
        String multiplicationTable = "";

        for (int row = startNumber; row <= endNumber; row++) {
            String multiplicationLine = generateMultiplicationLine(startNumber, row);
            multiplicationTable += multiplicationLine;
            if (row != endNumber) {
                multiplicationTable += "\r\n";
            }
        }

        return multiplicationTable;
    }

    private String generateMultiplicationLine(int startNumber, int endNumber) {
        String multiplicationLine = "";
        for (int multiplier = startNumber; multiplier <= endNumber; multiplier++) {
            multiplicationLine += generateMultiplicationExpression(multiplier, endNumber);
            if (multiplier != endNumber) {
                multiplicationLine += "  ";
            }
        }

        return multiplicationLine;
    }

    private String generateMultiplicationExpression(int multiplier, int multiplicand) {
        return String.format("%d*%d=%d", multiplier, multiplicand, multiplier*multiplicand);
    }
}
