package com.gl.globalcalculator.ServiceImpl;

import com.gl.globalcalculator.service.GlobalCalculatorService;

public class GlobalCalculatorServicceImpl implements GlobalCalculatorService {

    @Override
    public Double addNumber(Double firstNumber, Double secondNubmer) {
        return (firstNumber+secondNubmer);
    }

    @Override
    public Double substractionNumber(Double firstNumber, Double secondNubmer) {
        return (firstNumber-secondNubmer);
    }

    @Override
    public Double multiplicationNumber(Double firstNumber, Double secondNubmer) {
        return (firstNumber*secondNubmer);
    }

    @Override
    public Double divisionNumber(Double firstNumber, Double secondNubmer) {
        return (firstNumber / secondNubmer);
    }

    @Override
    public double logNumber(double firstNumber) {

        firstNumber = Math.log(firstNumber);
        firstNumber = Math.round(firstNumber*100.0)/100.0;
        return firstNumber;
    }

    @Override
    public Double lognNumber(Double firstNumber) {

        firstNumber = Math.log10(firstNumber);
        firstNumber = Math.round(firstNumber*100.0)/100.0;
        return firstNumber;
    }
}
