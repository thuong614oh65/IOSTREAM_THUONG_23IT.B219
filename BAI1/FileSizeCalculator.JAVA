package bai1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileSizeCalculator {
    public static void main(String[] args) {
        String filePath;
        if (args.length > 0) {
            filePath = args[0];
        } else {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Nhập đường dẫn của file: ");
            filePath = scanner.nextLine();
            scanner.close();
        }
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File không tồn tại.");
            return;
        }
        long fileSize = file.length();
        System.out.println("Kích thước của file là: " + fileSize + " bytes");
    }
}
