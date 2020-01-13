package com.example.demo.demo.advanced.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Date;

public class SpElDemo {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression helloWord = parser.parseExpression("'hello word'");
        Object value = helloWord.getValue();
        assert value.equals("hello word");

        DemoObject demoObject = new DemoObject("taishicheng", 12, new Date());

        Expression name = parser.parseExpression("name");
        Object nameValue = name.getValue(demoObject);
        assert nameValue.getClass().getSimpleName().equals("String");

        Expression age = parser.parseExpression("age");
        Object ageValue = age.getValue(demoObject);
        assert ageValue.equals(12);

        Expression date = parser.parseExpression("date");
        Object dateValue = date.getValue(demoObject);
        assert dateValue.getClass().getSimpleName().equals("Date");

        Expression expression = parser.parseExpression("'2'.equals(age)");
        Object value1 = expression.getValue(demoObject);
        assert value1 instanceof Boolean;
        assert Boolean.FALSE.equals(value1);

        Object[] arr = {1, 2, 3, 4, 5, 6};
        Expression expression1 = parser.parseExpression("[0]");
        Object value2 = expression1.getValue(arr);
        assert value2.equals(1);

    }
}
