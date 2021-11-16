package com.epam.jwd.calculator.validator;

import java.util.List;

public class Validator {

    public static final String NUMBER = "^[0-9]+$";
    public static final String OPERATION = "[+-/*]";
    public static final String PARENTHESIS = "[()]";

    public Validator() {
    }
    public static boolean isValidExpression(List<String> tokens) {
        return hasValidTokens(tokens)
                && hasValidParenthesis(tokens);
    }

    public static boolean hasValidTokens(List<String> tokens) {
        return tokens.stream().allMatch(t -> t.matches(NUMBER) || t.matches(OPERATION) || t.matches(PARENTHESIS));
    }

    private static boolean hasValidParenthesis(List<String> tokens) {
        return tokens.stream().filter(t -> t.equals("(")).count() ==
                tokens.stream().filter(t -> t.equals(")")).count();

    }
}
