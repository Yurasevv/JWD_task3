package com.epam.jwd.calculator.validator.impl;

import java.util.List;

public interface Validator {
    boolean isValidExpression(List<String> tokens);
    boolean hasValidTokens(List<String> tokens);
    boolean hasValidParenthesis(List<String> tokens);
}
