package ir.maktabsharif.controller;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.impls.UserRepositoryImpl;
import ir.maktabsharif.util.SMSPanel;
import ir.maktabsharif.util.ScannerSingleton;

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

    public void authenticate() {
        System.out.println("Please enter username:");
        String username = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter password:");
        String password = ScannerSingleton.getScannerInstance().nextLine();
        Optional<User> userOptional = userRepository.findUserByUsername(username);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            SMSPanel smsPanel = new SMSPanel();
            smsPanel.sendSMS(userOptional.get().getVerificationCode().toString(), userOptional.get().getPhoneNumber());
            System.out.println("Please enter verification code sent to your phone:");
            Integer enteredVerificationCode = Integer.parseInt(ScannerSingleton.getScannerInstance().nextLine());
            Integer verificationCode = userOptional.get().getVerificationCode();
            if (verificationCode.equals(enteredVerificationCode)) {
                user = userOptional.get();
            } else {
                System.out.println("Incorrect verification code!");
            }
        } else {
            System.out.println("Username or password is incorrect!");
        }
    }

    public void register() {
        System.out.println("Please enter full name:");
        String fullName = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter username:");
        String username = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter password:");
        String password = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter phone number:");
        String phoneNumber = ScannerSingleton.getScannerInstance().nextLine();
        Integer verificationCode = (int) ((Math.random() * (9999 - 1000)) + 1000);
        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setVerificationCode(verificationCode);
        userRepository.save(user);
    }
}

