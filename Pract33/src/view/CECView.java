package view;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class CECView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=== Меню ЦИК ===");
        System.out.println("1. Создать голосование");
        System.out.println("2. Экспорт результатов");
        System.out.println("0. Выход");
    }

    public int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String askCandidateLogin() {
        System.out.print("Логин кандидата: ");
        return scanner.nextLine().trim();
    }

    public String askVoteNameForResult() {
        System.out.print("Название голосования для просмотра результатов: ");
        return scanner.nextLine().trim();
    }


    public String readLine() {
        return scanner.nextLine();
    }

    public String askVoteName() {
        System.out.print("Название голосования: ");
        return scanner.nextLine().trim();
    }

    public LocalDate askEndDate() {
        System.out.print("Дата окончания (yyyy-mm-dd): ");
        return LocalDate.parse(scanner.nextLine().trim());
    }

    public String askExportFolder() {
        System.out.print("Папка для сохранения (ENTER — текущая): ");
        return scanner.nextLine().trim();
    }

    public boolean askSingleFileExport() {
        System.out.print("Сохранить всё в один файл? (y/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    public String askFilename() {
        System.out.print("Имя файла (ENTER — авто): ");
        return scanner.nextLine().trim();
    }
}
