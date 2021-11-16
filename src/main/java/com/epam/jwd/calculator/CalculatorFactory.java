package com.epam.jwd.calculator;

import com.epam.jwd.calculator.impl.CalculatorImpl;

public class CalculatorFactory {

    private static final CalculatorFactory instance = new CalculatorFactory();
    private final Calculator calculator = new CalculatorImpl();

    private CalculatorFactory(){

    }

    public CalculatorFactory getInstance(){
        return instance;
    }

    public Calculator getCalculator() {
        return calculator;
    }

}
