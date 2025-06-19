package model;

public class CalculatorModel {

    public double evaluate(String input) throws IllegalArgumentException {
        input = input.trim().replaceAll("\\s+", "");

        if (!input.matches("^-?\\d.*\\d$")) {
            throw new IllegalArgumentException("Уравнение должно начинаться и заканчиваться числом.");
        }

        // Проверка на количество слагаемых
        int operandsCount = input.split("[+\\-*/^]+").length;
        if (operandsCount > 100) {
            throw new IllegalArgumentException("Превышено количество слагаемых (максимум 100).");
        }

        // Заменим // на уникальный маркер
        input = input.replaceAll("//", "DIV_INT");

        // Возведение в степень — заменим ^ на Math.pow в виде токенов
        String postfix = ExpressionParser.toPostfix(input);
        return ExpressionParser.evaluatePostfix(postfix);
    }
}
