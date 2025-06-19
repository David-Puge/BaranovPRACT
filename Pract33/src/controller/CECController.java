package controller;

import model.Candidate;
import model.Vote;
import model.VoteManager;
import view.CECView;

import java.util.Map;

public class CECController {
    private final VoteManager voteManager;
    private final CECView view;

    public CECController(VoteManager voteManager, CECView view) {
        this.voteManager = voteManager;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.getChoice();
            if (choice == -1) {
                System.out.println("❌ Неверный ввод.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    String name = view.askVoteName();
                    var endDate = view.askEndDate();
                    voteManager.createVote(name, endDate);
                    System.out.println("✅ Голосование создано.");
                }
                case 2 -> {
                    String voteName = view.askVoteName();
                    Vote vote = voteManager.findVoteByName(voteName);
                    if (vote == null) {
                        System.out.println("❌ Голосование не найдено.");
                        break;
                    }
                    String candidateLogin = view.askCandidateLogin();
                    // TODO: Добавить проверку роли кандидата из UserManager
                    vote.addCandidate(new Candidate(candidateLogin, "", candidateLogin));
                    System.out.println("✅ Кандидат добавлен.");
                }
                case 3 -> {
                    String voteName = view.askVoteNameForResult();
                    Vote vote = voteManager.findVoteByName(voteName);
                    if (vote == null) {
                        System.out.println("❌ Голосование не найдено.");
                        break;
                    }
                    Map<String, Integer> results = vote.countResults();
                    System.out.println("=== Результаты голосования: " + vote.getName() + " ===");
                    for (var entry : results.entrySet()) {
                        System.out.println("Кандидат " + entry.getKey() + ": " + entry.getValue() + " голосов");
                    }
                }
                case 0 -> running = false;
                default -> System.out.println("❌ Неверный выбор.");
            }
        }
    }
}
