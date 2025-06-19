package model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class CalculatorModel {

    private boolean checkBrackets(String expression) {
        int balance = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    private int countOperands(String expression) {
        return expression.split("[+\\-*/%^!]+").length;
    }

    public double evaluate(String input) throws IllegalArgumentException {
        if (!checkBrackets(input)) {
            throw new IllegalArgumentException("Неправильное количество скобок.");
        }

        if (countOperands(input) > 15) {
            throw new IllegalArgumentException("Превышено количество слагаемых (макс. 15).");
        }

        // Заменить ** на ^
        input = input.replace("**", "^");

        // Заменить a! на fact(a)
        input = input.replaceAll("(\\d+)!", "fact($1)");

        // Заменить // на intDiv(a, b)
        input = input.replaceAll("(\\d+)\\s*//\\s*(\\d+)", "intDiv($1,$2)");

        // Функция факториала
        Function factorial = new Function("fact", 1) {
            @Override
            public double apply(double... args) {
                int n = (int) args[0];
                if (n < 0) throw new IllegalArgumentException("Факториал отрицательного числа не определён");
                int result = 1;
                for (int i = 2; i <= n; i++) result *= i;
                return result;
            }
        };

        // Функция логарифма по основанию 2
        Function log2 = new Function("log", 1) {
            @Override
            public double apply(double... args) {
                return Math.log(args[0]) / Math.log(2);
            }
        };

        // Функция экспоненты
        Function exp = new Function("exp", 1) {
            @Override
            public double apply(double... args) {
                return Math.exp(args[0]);
            }
        };

        // Целочисленное деление
        Function intDiv = new Function("intDiv", 2) {
            @Override
            public double apply(double... args) {
                return (int) args[0] / (int) args[1];
            }
        };

        Expression expression = new ExpressionBuilder(input)
                .functions(factorial, log2, exp, intDiv)
                .build();

        return expression.evaluate();
    }
}
