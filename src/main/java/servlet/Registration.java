package servlet;

import ir.maktabsharif.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {
    UserController userController = new UserController();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber = req.getParameter("phone-number");
        String fullName = req.getParameter("full-name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userController.register(phoneNumber, fullName, username, password);
        resp.sendRedirect("http://localhost:8080/Gradle___org_example___Instagram_1_0_SNAPSHOT_war/login.html");
    }
}
