package ir.maktabsharif.view;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.service.PostService;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.util.ScannerSingleton;

public class Profile {
    private static final PostService POST_SERVICE = new PostService();
    private static final UserService USER_SERVICE = new UserService();
    public static void index(User user) {
        USER_SERVICE.printAllPosts(user.getUserId());
        System.out.println("Please select one below:");
        System.out.println("1:Add new post\n2:Edit post\n3:Delete post");
        int choice = Integer.parseInt(ScannerSingleton.getScannerInstance().nextLine());
        switch (choice) {
            case 1:
                POST_SERVICE.addPost(user);
                break;
            case 2:
                break;
            case 3:
                USER_SERVICE.deletePost(user);
                break;
        }
    }
}
