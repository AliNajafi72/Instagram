package ir.maktabsharif;

import ir.maktabsharif.bootstrap.SiteController;
import ir.maktabsharif.util.ScannerSingleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter url:");
        String url = ScannerSingleton.getScannerInstance().nextLine();
        SiteController controller = new SiteController();
        controller.index(url);

    }
}
