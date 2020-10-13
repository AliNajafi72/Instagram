package ir.maktabsharif.view;

import ir.maktabsharif.util.ScannerSingleton;

public class Home {
    public static void index() {
        System.out.println("Please select one below:");
        System.out.println("1:Sign up\n2:Sign in");
        int choice = Integer.parseInt(ScannerSingleton.getScannerInstance().nextLine());
        switch (choice){
            case 1:
                SignUp.index();
                break;
            case 2:
                SignIn.index();
                break;
        }
    }
}
