package com.epam.jwd.calculator.util;

import com.epam.jwd.calculator.ExpressionParser;
import com.epam.jwd.calculator.exceptions.CalculatorException;
import com.epam.jwd.calculator.validator.impl.Validator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CalculationWithTags {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String LEFT_PARENTHESIS = "(";
    public static final String RIGHT_PARENTHESIS = ")";

    public CalculationWithTags() {
    }

    public int calculate(String expression) throws CalculatorException {
        if (expression == null || expression.isEmpty()) {
            throw new CalculatorException("Expression is not instantiated");
        }

        List<String> parsedExpression = ExpressionParser.parse(expression);

        if (!Validator.isValidExpression(parsedExpression)) {
            throw new CalculatorException("Incorrect expression");
        }

        List<String> postfixNotationExpression = Converter.convertInfixToPostfix(parsedExpression);
        return calcValue(postfixNotationExpression);
    }

    private int calcValue(List<String> postfixNotationExpression) {
        Deque<String> stack = new LinkedList<>();

        for (String token : postfixNotationExpression) {
            switch (token) {
                case PLUS -> add(stack);
                case MINUS -> subtract(stack);
                case MULTIPLY -> multiply(stack);
                case DIVIDE -> divide(stack);
                default -> stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private void divide(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 / x1));
    }

    private void multiply(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 * x1));
    }

    private void subtract(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 - x1));
    }

    private void add(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 + x1));
    }
}
