package ir.maktabsharif.service;

import ir.maktabsharif.domain.Post;
import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.impls.UserRepositoryImpl;
import ir.maktabsharif.util.ScannerSingleton;

import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
    public void signUp() {
        System.out.println("Please enter full name:");
        String fullName = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter username:");
        String username = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter password:");
        String password = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter phone number:");
        String phoneNumber = ScannerSingleton.getScannerInstance().nextLine();
        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        userRepositoryImpl.save(user);
    }
    public Optional<User> signIn() {
        System.out.println("Please enter username:");
        String username = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter password:");
        String password = ScannerSingleton.getScannerInstance().nextLine();
        Optional<User> userOptional = userRepositoryImpl.findUserByUsername(username);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    public void printAllPosts(Long userId) {
        List<Post> posts = userRepositoryImpl.get(userId).get().getPosts();
        for (Post post:posts) {
            System.out.println("Post id: " + posts.indexOf(post));
            System.out.println("Content: " + post.getContent());
            System.out.println("==========");
        }
    }

    public void deletePost(User user) {
        System.out.println("Please enter post id to delete:");
        Integer postIndex = Integer.parseInt(ScannerSingleton.getScannerInstance().nextLine());
        userRepositoryImpl.deletePostFromUser(user.getUserId(), postIndex);
    }
}
