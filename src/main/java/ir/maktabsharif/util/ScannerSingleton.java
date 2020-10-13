package ir.maktabsharif.util;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner scanner;

    private ScannerSingleton() {
    }

    public static Scanner getScannerInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
