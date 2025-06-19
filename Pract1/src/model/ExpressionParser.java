package model;

import java.util.*;

public class ExpressionParser {

    private static final Map<String, Integer> precedence = Map.of(
            "DIV_INT", 2,
            "^", 3,
            "*", 2,
            "/", 2,
            "+", 1,
            "-", 1
    );

    public static String toPostfix(String expr) {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    output.add(number.toString());
                    number.setLength(0);
                }

                if (ch == '/') {
                    if (i + 1 < expr.length() && expr.charAt(i + 1) == '/') {
                        stackPush(stack, output, "DIV_INT");
                        i++; // пропустить второй слэш
                        continue;
                    }
                }

                String op = String.valueOf(ch);
                stackPush(stack, output, op);
            }
        }

        if (number.length() > 0) output.add(number.toString());
        while (!stack.isEmpty()) output.add(stack.pop());

        return String.join(" ", output);
    }

    private static void stackPush(Stack<String> stack, List<String> output, String op) {
        while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.getOrDefault(op, 0)) {
            output.add(stack.pop());
        }
        stack.push(op);
    }

    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (precedence.containsKey(token)) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                    case "^": stack.push(Math.pow(a, b)); break;
                    case "DIV_INT": stack.push((double)((int)(a / b))); break;
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }
}
