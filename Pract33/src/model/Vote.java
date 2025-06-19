package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vote {
    private String name;
    private LocalDate endDate;
    private List<Candidate> candidates = new ArrayList<>();
    private Map<String, String> votes = new HashMap<>(); // ключ - логин избирателя, значение - логин кандидата

    public Vote(String name, LocalDate endDate) {
        this.name = name;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void vote(String voterLogin, String candidateLogin) {
        votes.put(voterLogin, candidateLogin);
    }

    public Map<String, Integer> countResults() {
        Map<String, Integer> results = new HashMap<>();
        for (Candidate c : candidates) {
            results.put(c.getLogin(), 0);
        }
        for (String candidateLogin : votes.values()) {
            results.put(candidateLogin, results.getOrDefault(candidateLogin, 0) + 1);
        }
        return results;
    }
}
