package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class VoteManager {
    private List<Vote> votes = new ArrayList<>();

    // Храним результаты: голосование -> (кандидат -> количество голосов)
    private Map<Vote, Map<String, Integer>> results = new HashMap<>();

    public void createVote(String name, LocalDate endDate) {
        Vote vote = new Vote(name, endDate);
        votes.add(vote);
        results.put(vote, new HashMap<>()); // Инициализируем пустые результаты для нового голосования
    }

    public List<Vote> getAllVotes() {
        return votes;
    }

    public Vote findVoteByName(String name) {
        for (Vote v : votes) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public List<Vote> getActiveVotes() {
        List<Vote> activeVotes = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Vote v : votes) {
            if (v.getEndDate().isAfter(now) || v.getEndDate().isEqual(now)) {
                activeVotes.add(v);
            }
        }
        return activeVotes;
    }

    // Добавляем голос за кандидата
    public void castVote(Vote vote, User voter, String candidateLogin) {
        Map<String, Integer> voteResults = results.get(vote);
        if (voteResults == null) {
            voteResults = new HashMap<>();
            results.put(vote, voteResults);
        }
        voteResults.put(candidateLogin, voteResults.getOrDefault(candidateLogin, 0) + 1);
    }

    // Получаем результаты по кандидату (всего голосов, которые получил кандидат во всех голосованиях)
    public Map<String, Integer> getResultsByCandidate(String candidateLogin) {
        Map<String, Integer> candidateResults = new HashMap<>();
        for (Map.Entry<Vote, Map<String, Integer>> entry : results.entrySet()) {
            Integer count = entry.getValue().get(candidateLogin);
            if (count != null) {
                candidateResults.put(entry.getKey().getName(), count);
            }
        }
        return candidateResults;
    }
}
