package model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private final CECManager cecManager = new CECManager();

    public UserManager() {
        // Предустановленные пользователи
        users.add(new User("admin", "admin123", "Главный админ", User.Role.ADMIN));
        users.add(new User("cec1", "cec123", "ЦИК-1", User.Role.CEC));
        users.add(new User("cand1", "pass1", "Кандидат Один", User.Role.CANDIDATE));
        users.add(new User("voter1", "vote123", "Избиратель Один", User.Role.VOTER));
    }

    public User login(String login, String password) {
        for (User u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public void deleteUser(String login) {
        users.removeIf(u -> u.getLogin().equals(login));
    }

    public CECManager getCecManager() {
        return cecManager;
    }
    public List<User> getCecList() {
        List<User> cecs = new ArrayList<>();
        for (User u : users) {
            if (u.getRole() == User.Role.CEC) {
                cecs.add(u);
            }
        }
        return cecs;
    }

    public void deleteCec(String login) {
        users.removeIf(u -> u.getLogin().equals(login) && u.getRole() == User.Role.CEC);
    }

    public void createCec(String login, String password) {
        users.add(new User(login, password, "ЦИК-" + login, User.Role.CEC));
    }

}
