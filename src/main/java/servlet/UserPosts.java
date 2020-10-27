package servlet;

import com.google.gson.Gson;
import ir.maktabsharif.controller.PostController;
import ir.maktabsharif.controller.UserController;
import ir.maktabsharif.domain.Post;
import ir.maktabsharif.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class UserPosts extends HttpServlet {
    UserController userController = new UserController();
    PostController postController = new PostController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String token = "";
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                break;
            }
        }
        Optional<User> userOptional = userController.authenticatedUser(token);
        List<Post> posts = postController.getUserPosts(userOptional.get().getUserId());
        String json = new Gson().toJson(posts);
        resp.setContentType("text/json");
        PrintWriter output = resp.getWriter();
        output.println(json);
    }
}
