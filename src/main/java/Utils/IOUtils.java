package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IOUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATA_PATH = System.getProperty("user.dir") + "/";

    public static Scanner getScanner() {
        return scanner;
    }

    public static int nextInt() {
        while (true) {
            if (scanner.hasNext("[0-9]+")) {
                return scanner.nextInt();
            }
            scanner.next();
            System.out.print("It's not number! Please enter number: ");
        }
    }





}
