package model;

public class CEC {
    private String login;
    private String password;

    public CEC(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() { return login; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "CEC{" + "login='" + login + '\'' + '}';
    }
}
