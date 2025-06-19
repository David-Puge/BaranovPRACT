package controller;

import model.VoteManager;
import view.CandidateView;
import model.Candidate;

public class CandidateController {
    private final Candidate candidate; // обязательно Candidate, чтобы был setInfo
    private final VoteManager voteManager;
    private final CandidateView view;

    public CandidateController(Candidate candidate, VoteManager voteManager, CandidateView view) {
        this.candidate = candidate;
        this.voteManager = voteManager;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1 -> {
                    // Заполнение данных о кандидате
                    String info = view.askCandidateInfo();
                    candidate.setInfo(info);
                    view.showMessage("Данные сохранены.");
                }
                case 2 -> {
                    // Просмотр результатов предыдущего голосования
                    var results = voteManager.getResultsByCandidate(candidate.getLogin());
                    view.showResults(results);
                }
                case 0 -> running = false;
                default -> view.showMessage("Неверный выбор.");
            }
        }
    }
}
