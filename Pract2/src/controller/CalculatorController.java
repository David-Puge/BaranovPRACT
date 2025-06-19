package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.printWelcome();

        while (true) {
            String input = view.getUserInput().trim();

            if (input.equalsIgnoreCase("выход")) {
                System.out.println("До свидания!");
                break;
            }

            try {
                double result = model.evaluate(input);
                view.showResult(input, result);
            } catch (Exception e) {
                view.showError(e.getMessage());
            }
        }
    }
}
