package ir.maktabsharif.controller;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.impls.UserRepositoryImpl;
import ir.maktabsharif.util.SMSPanel;
import ir.maktabsharif.util.ScannerSingleton;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class UserController implements Controller {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public static User user;

    @Override
    public void index() {
        if (user == null) {
            System.out.println("Please login to see you profile or sign up to use this app!");
        }
    }

    public Optional<User> authenticate(
            String username,
            String password
    ) {
        Optional<User> userOptional = userRepository.findUserByUsername(username);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            int randomNumber = (int) ((Math.random() * (9999 - 1000)) + 1000);
            userOptional.get().setToken(Integer.toString(randomNumber));
            userRepository.update(userOptional.get());
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    public void register(
            String phoneNumber,
            String fullName,
            String username,
            String password
    ) {
        Integer verificationCode = (int) ((Math.random() * (9999 - 1000)) + 1000);
        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setVerificationCode(verificationCode);
//        SMSPanel smsPanel = new SMSPanel();
//        smsPanel.sendSMS(phoneNumber, verificationCode.toString());
        userRepository.save(user);
    }

    public void searchUser() {
        System.out.println("Please enter user name to search:");
        String keyWord = ScannerSingleton.getScannerInstance().nextLine();
        List<User> users = userRepository.searchUser(keyWord);
        for (User user : users) {
            System.out.println("User id: " + user.getUserId() + "\n" + "User name: " + user.getUsername() + "\n");
        }
    }

    public void follow() {
        if (!(UserController.user == null)) {
            System.out.println("Please enter user's id to follow:");
            long userIdToFollow = Long.parseLong(ScannerSingleton.getScannerInstance().nextLine());
            Optional<User> userOptional = userRepository.get(userIdToFollow);
            if(userOptional.isPresent()) {
                UserController.user.addFollower(userOptional.get());
            }
            userRepository.update(UserController.user);
        } else {
            System.out.println("Please login to proceed!");
        }
    }

    public void unFollow() {
        if (!(UserController.user == null)) {
            System.out.println("Please enter user's id to follow:");
            long userIdToFollow = Long.parseLong(ScannerSingleton.getScannerInstance().nextLine());
            Optional<User> userOptional = userRepository.get(userIdToFollow);
            List<User> followedUsers = UserController.user.getFollowers();
            User userToUnfollow = new User();
            if(userOptional.isPresent()) {
                long userIdToUnfollow = userOptional.get().getUserId();
                for (User user:followedUsers) {
                    if (user.getUserId() == userIdToUnfollow) {
                        userToUnfollow = user;
                        break;
                    }
                }
                followedUsers.remove(userToUnfollow);
            }
            UserController.user.setFollowers(followedUsers);
            userRepository.update(UserController.user);
        } else {
            System.out.println("Please login to proceed!");
        }
    }

    public Optional<User> authenticatedUser(String token) {
        return userRepository.get(token);
    }
}

