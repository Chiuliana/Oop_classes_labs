package lab_two;

import lab_two.documents.ImageDocument;
import lab_two.documents.JavaDocument;
import lab_two.documents.TextDocument;
import lab_two.monitor.FileMonitor;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        FileMonitor fileMonitor = new FileMonitor();
        Scanner scanner = new Scanner(System.in);

        // Add documents to the file monitor
        fileMonitor.addDocument(new TextDocument("test.txt", 100, 500, 3000));
        fileMonitor.addDocument(new ImageDocument("image.png", 1024, 860));
        fileMonitor.addDocument(new JavaDocument("program.java", 200, 4, 15));

        // Add other document types as needed

        boolean exit = false;

        while (!exit) {
            System.out.println("Enter action (commit/info <filename>/status/exit): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            switch (parts[0]) {
                case "commit":
                    fileMonitor.commitSnapshot();
                    break;
                case "info":
                    if (parts.length > 1) {
                        fileMonitor.displayInfo(parts[1]);
                    } else {
                        System.out.println("Invalid input. Usage: info <filename>");
                    }
                    break;
                case "status":
                    fileMonitor.displayStatus();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}
