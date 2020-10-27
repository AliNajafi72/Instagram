package servlet;

import ir.maktabsharif.controller.UserController;
import ir.maktabsharif.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class Authentication extends HttpServlet {
    UserController userController = new UserController();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> userOptional = userController.authenticate(username, password);
        if (userOptional.isPresent()) {
            Cookie cookie = new Cookie("token", userOptional.get().getToken());
            resp.addCookie(cookie);
        }
        resp.sendRedirect("http://localhost:8080/Gradle___org_example___Instagram_1_0_SNAPSHOT_war");
    }
}
