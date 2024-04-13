package bai2;

import java.io.File;

public class DeleteFileOrDirectory {
    public static void main(String[] args) {
        String path;
        if (args.length > 0) {
            path = args[0];
        } else {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Nhập đường dẫn của thư mục hoặc file: ");
            path = scanner.nextLine();
            scanner.close();
        }
        File fileOrDirectory = new File(path);
        if (!fileOrDirectory.exists()) {
            System.out.println("File hoặc thư mục không tồn tại.");
            return;
        }
        if (fileOrDirectory.isDirectory()) {
            deleteDirectory(fileOrDirectory);
        } else {
            if (fileOrDirectory.delete()) {
                System.out.println("File đã được xoá thành công.");
            } else {
                System.out.println("Không thể xoá file.");
            }
        }
    }
    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    if (file.delete()) {
                        System.out.println("Đã xoá: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Không thể xoá: " + file.getAbsolutePath());
                    }
                }
            }
        }

        if (directory.delete()) {
            System.out.println("Thư mục đã được xoá thành công: " + directory.getAbsolutePath());
        } else {
            System.out.println("Không thể xoá thư mục: " + directory.getAbsolutePath());
        }
    }
}
