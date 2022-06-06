package by.tms.spring.service.scanner;

import java.util.Scanner;

public class ItsMyScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }

    public static void close() {
        scanner.close();
    }

}
