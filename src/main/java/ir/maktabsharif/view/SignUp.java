package ir.maktabsharif.view;

import ir.maktabsharif.service.UserService;

public class SignUp {
    public static void index() {
        UserService userService = new UserService();
        userService.signUp();
    }
}
