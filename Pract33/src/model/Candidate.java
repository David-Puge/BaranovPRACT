package model;

public class Candidate extends User {
    private String info; // информация о кандидате

    public Candidate(String login, String password, String fullName) {
        super(login, password, fullName, Role.CANDIDATE);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
