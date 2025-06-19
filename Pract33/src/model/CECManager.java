package model;

import java.util.ArrayList;
import java.util.List;

public class CECManager {
    private final List<CEC> cecList = new ArrayList<>();

    public List<CEC> getCecList() {
        return cecList;
    }

    public void addCec(String login, String password) {
        cecList.add(new CEC(login, password));
    }

    public boolean deleteCec(String login) {
        return cecList.removeIf(cec -> cec.getLogin().equals(login));
    }
}
