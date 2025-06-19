package view;

import java.util.Scanner;
import java.util.Map;

public class CandidateView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=== Меню кандидата ===");
        System.out.println("1. Заполнить данные о себе");
        System.out.println("2. Просмотреть результаты предыдущего голосования");
        System.out.println("0. Выход");
    }

    public int getChoice() {
        System.out.print("Выбор: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String askCandidateInfo() {
        System.out.print("Введите информацию о себе: ");
        return scanner.nextLine().trim();
    }

    public void showResults(Map<String, Integer> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("Результаты отсутствуют.");
            return;
        }
        System.out.println("Результаты голосования:");
        results.forEach((candidateLogin, votes) ->
                System.out.println(candidateLogin + ": " + votes + " голосов"));
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
