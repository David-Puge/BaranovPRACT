package controller;

import model.UserManager;
import view.MenuView;

public class AdminController {
    private final UserManager userManager;
    private final MenuView view;

    public AdminController(UserManager userManager, MenuView view) {
        this.userManager = userManager;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showAdminMenu();
            int choice = view.getUserChoice();
            switch (choice) {
                case 1 -> view.printUsers(userManager.getUsers());
                case 2 -> {
                    String loginToDelete = view.promptLoginForDeletion();
                    userManager.deleteUser(loginToDelete);
                }
                case 3 -> view.printUsers(userManager.getCecList());
                case 4 -> {
                    String login = view.promptCecLogin();
                    userManager.deleteCec(login);
                }
                case 5 -> {
                    String login = view.promptCecLogin();
                    String password = view.promptCecPassword();
                    userManager.createCec(login, password);
                }
                case 0 -> running = false;
                default -> System.out.println("Неверный выбор.");
            }
        }
    }
}
