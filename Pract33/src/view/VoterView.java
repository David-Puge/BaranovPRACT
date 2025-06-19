package view;

import java.util.List;
import java.util.Scanner;

public class VoterView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=== Меню избирателя ===");
        System.out.println("1. Регистрация");
        System.out.println("2. Голосование");
        System.out.println("3. Просмотр списка кандидатов");
        System.out.println("0. Выход");
    }

    public int getChoice() {
        System.out.print("Выбор: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String askFullName() {
        System.out.print("Введите ФИО: ");
        return scanner.nextLine().trim();
    }

    public String askDateOfBirth() {
        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        return scanner.nextLine().trim();
    }

    public String selectVote(List<String> votes) {
        System.out.println("Доступные голосования:");
        for (int i = 0; i < votes.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, votes.get(i));
        }
        System.out.print("Выберите голосование: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        return votes.get(choice - 1);
    }

    public String selectCandidate(List<String> candidates) {
        System.out.println("Кандидаты:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, candidates.get(i));
        }
        System.out.print("Выберите кандидата: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        return candidates.get(choice - 1);
    }

    public void showCandidates(List<String> candidates) {
        System.out.println("Список кандидатов:");
        for (String candidate : candidates) {
            System.out.println("- " + candidate);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
