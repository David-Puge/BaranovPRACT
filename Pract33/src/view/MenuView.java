package view;

import java.util.Scanner;
import java.util.List;
import model.User;


public class MenuView {
    private final Scanner scanner = new Scanner(System.in);

    public String askLogin() {
        System.out.print("Логин: ");
        return scanner.nextLine().trim();
    }

    public String askPassword() {
        System.out.print("Пароль: ");
        return scanner.nextLine().trim();
    }

    public void showAdminMenu() {
        System.out.println("=== Админ-меню ===");
        System.out.println("1. Просмотр пользователей");
        System.out.println("2. Удаление пользователя");
        System.out.println("3. Просмотр ЦИК");
        System.out.println("4. Удаление ЦИК");
        System.out.println("5. Создание ЦИК");
        System.out.println("0. Выход");
    }

    public void showCECMenu() {
        System.out.println("=== Меню ЦИК ===");
        System.out.println("1. Создать голосование");
        System.out.println("2. Экспорт результатов");
        System.out.println("0. Выход");
    }

    public void showVoterMenu() {
        System.out.println("=== Меню избирателя ===");
        System.out.println("1. Проголосовать");
        System.out.println("0. Выход");
    }

    public int getUserChoice() {
        System.out.print("Выбор: ");
        return scanner.nextInt();
    }

    public void printUsers(List<User> users) {
        for (User u : users) {
            System.out.println(u.getLogin() + " - " + u.getFullName() + " [" + u.getRole() + "]");
        }
    }


    public String promptLoginForDeletion() {
        scanner.nextLine(); // очистка
        System.out.print("Введите логин для удаления: ");
        return scanner.nextLine().trim();
    }

    public String promptCecLogin() {
        scanner.nextLine(); // очистка буфера
        System.out.print("Введите логин ЦИК: ");
        return scanner.nextLine().trim();
    }

    public String promptCecPassword() {
        System.out.print("Введите пароль ЦИК: ");
        return scanner.nextLine().trim();
    }
}
