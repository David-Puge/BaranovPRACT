import controller.AdminController;
import model.UserManager;
import view.MenuView;
import model.User;


public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        MenuView view = new MenuView();

        String login = view.askLogin();
        String password = view.askPassword();
        User user = userManager.login(login, password);

        if (user == null) {
            System.out.println("Неверные данные.");
            return;
        }

        switch (user.getRole()) {
            case ADMIN -> {
                AdminController adminController = new AdminController(userManager, view);
                adminController.run();
            }
            // здесь позже добавим другие контроллеры
            default -> System.out.println("Поддержка этой роли пока не реализована.");
        }

    }

}
