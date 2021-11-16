package com.epam.jwd.calculator;

import com.epam.jwd.calculator.exceptions.CalculatorException;

public interface Calculator {
    public double calculate(String expression) throws CalculatorException;
}
