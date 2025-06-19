package controller;

import model.*;
import view.MenuView;

public class MainController {
    private final MenuView view = new MenuView();
    private final UserManager userManager = new UserManager();
    private User currentUser;

    public void start() {
        System.out.println("=== Вход в систему ===");
        String login = view.askLogin();
        String password = view.askPassword();

        currentUser = userManager.login(login, password);

        if (currentUser == null) {
            System.out.println("❌ Неверный логин или пароль.");
            return;
        }

        switch (currentUser.getRole()) {
            case ADMIN:
                adminMenu();
                break;
            case CEC:
                cecMenu();
                break;
            case CANDIDATE:
                System.out.println("⚠️ Меню кандидата пока не реализовано.");
                break;
            case VOTER:
                voterMenu();
                break;
            default:
                System.out.println("⚠️ Неизвестная роль.");
        }
    }

    private void adminMenu() {
        while (true) {
            view.showAdminMenu();
            int choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    view.printUsers(userManager.getUsers());
                    break;
                case 2:
                    String loginToDelete = view.promptLoginForDeletion();
                    userManager.deleteUser(loginToDelete);
                    System.out.println("✅ Пользователь удалён.");
                    break;
                case 3:
                    System.out.println("=== Список ЦИК ===");
                    for (CEC cec : userManager.getCecManager().getCecList()) {
                        System.out.println("- " + cec.getLogin());
                    }
                    break;
                case 4:
                    String cecToDelete = view.promptCecLogin();
                    boolean removed = userManager.getCecManager().deleteCec(cecToDelete);
                    System.out.println(removed ? "✅ ЦИК удалён." : "❌ ЦИК не найден.");
                    break;
                case 5:
                    String newCecLogin = view.promptCecLogin();
                    String newCecPass = view.promptCecPassword();
                    userManager.getCecManager().addCec(newCecLogin, newCecPass);
                    System.out.println("✅ ЦИК создан.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Неверный выбор.");
            }
        }
    }

    private void cecMenu() {
        while (true) {
            view.showCECMenu();
            int choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    System.out.println("⚙️ Создание голосования пока не реализовано.");
                    break;
                case 2:
                    System.out.println("⚙️ Экспорт результатов пока не реализован.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Неверный выбор.");
            }
        }
    }

    private void voterMenu() {
        while (true) {
            view.showVoterMenu();
            int choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    System.out.println("⚙️ Голосование пока не реализовано.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Неверный выбор.");
            }
        }
    }
}
