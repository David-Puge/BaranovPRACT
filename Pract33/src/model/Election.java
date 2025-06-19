package model;

import java.util.*;

public class Election {
    private String title;
    private Map<Candidate, Integer> results = new HashMap<>();

    public Election(String title) {
        this.title = title;
    }

    public void addCandidate(Candidate candidate) {
        results.put(candidate, 0);
    }

    public void vote(Candidate candidate) {
        results.put(candidate, results.get(candidate) + 1);
    }

    public Map<Candidate, Integer> getResults() {
        return results;
    }

    public String getTitle() {
        return title;
    }
}
