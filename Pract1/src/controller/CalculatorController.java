package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private final CalculatorModel model = new CalculatorModel();
    private final CalculatorView view = new CalculatorView();

    public void run() {
        while (true) {
            view.showMenu();
            String input = view.getExpression();

            if (input.equalsIgnoreCase("выход")) break;

            try {
                double result = model.evaluate(input);
                view.showResult(result);
            } catch (Exception e) {
                view.showError(e.getMessage());
            }
        }

        System.out.println("Завершение программы.");
    }
}
