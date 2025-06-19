package view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=== Простой калькулятор ===");
        System.out.println("Введите уравнение или 'выход' для завершения:");
    }

    public String getExpression() {
        System.out.print(">> ");
        return scanner.nextLine();
    }

    public void showResult(double result) {
        System.out.println("Результат: " + result);
    }

    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }
}
