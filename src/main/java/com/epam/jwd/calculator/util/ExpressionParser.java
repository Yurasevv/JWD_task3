package com.epam.jwd.calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExpressionParser {

    public ExpressionParser(){
    }

    public static List<String> parse(String expression){

        List<String> charList = new ArrayList<>();

        StringTokenizer expressionTokenizer = new StringTokenizer(expression, "()*/+-", true);

        while (expressionTokenizer.hasMoreTokens()) {
            charList.add(expressionTokenizer.nextToken());
        }

        return charList;
    }
}
