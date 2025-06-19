package view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public void printWelcome() {
        System.out.println("=== Калькулятор 2.0 (с функциями и скобками) ===");
        System.out.println("Введите выражение или 'выход':");
    }

    public String getUserInput() {
        System.out.print(">> ");
        return scanner.nextLine();
    }

    public void showResult(String expression, double result) {
        System.out.println(expression + " = " + result);
    }

    public void showError(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }
}
