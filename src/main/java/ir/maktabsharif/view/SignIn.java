package ir.maktabsharif.view;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.service.UserService;

import java.util.Optional;

public class SignIn {
    public static void index() {
        UserService userService = new UserService();
        Optional<User> userOptional = userService.signIn();
        if (userOptional.isPresent()) {
            Profile.index(userOptional.get());
        } else {
            Home.index();
        }
    }
}
