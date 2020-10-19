package ir.maktabsharif;

import ir.maktabsharif.bootstrap.SiteController;
import ir.maktabsharif.util.SMSPanel;
import ir.maktabsharif.util.ScannerSingleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter url:");
        String url = ScannerSingleton.getScannerInstance().nextLine();
        while (!url.equals("0")) {
            SiteController controller = new SiteController();
            controller.index(url);
            System.out.println("Please enter url:");
            url = ScannerSingleton.getScannerInstance().nextLine();
        }

    }
}
