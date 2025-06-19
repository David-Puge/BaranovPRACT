package model;

public class User {
    private String login;
    private String password;
    private String fullName;
    private String dateOfBirth; // добавляем поле для даты рождения
    private Role role;

    public enum Role {
        ADMIN, CEC, CANDIDATE, VOTER
    }

    public User(String login, String password, String fullName, Role role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
