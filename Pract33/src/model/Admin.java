package model;

import java.util.List;

public class Admin {
    private final UserManager userManager;

    public Admin(UserManager userManager) {
        this.userManager = userManager;
    }

    public List<User> getAllUsers() {
        return userManager.getUsers();
    }

    public void deleteUser(String login) {
        userManager.deleteUser(login);
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
}
