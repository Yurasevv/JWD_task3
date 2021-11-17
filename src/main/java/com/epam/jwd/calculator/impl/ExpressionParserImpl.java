package com.epam.jwd.calculator.impl;

import com.epam.jwd.calculator.ExpressionParser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExpressionParserImpl implements ExpressionParser {

    public ExpressionParserImpl(){
    }

    public List<String> parse(String expression){

        List<String> charList = new ArrayList<>();

        StringTokenizer expressionTokenizer = new StringTokenizer(expression, "()*/+-", true);

        while (expressionTokenizer.hasMoreTokens()) {
            charList.add(expressionTokenizer.nextToken());
        }

        return charList;
    }
}