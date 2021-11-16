package com.epam.jwd.calculator.impl;

import com.epam.jwd.calculator.Calculator;
import com.epam.jwd.calculator.exceptions.CalculatorException;
import com.epam.jwd.calculator.util.CalculationWithTags;

public class CalculatorImpl implements Calculator {

    private CalculationWithTags tagCalculator;

    {
        tagCalculator = new CalculationWithTags();
    }

    public CalculatorImpl() {
    }

    @Override
    public double calculate(String expression) throws CalculatorException {
        return tagCalculator.calculate(expression);
    }
}
