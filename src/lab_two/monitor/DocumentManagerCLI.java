package lab_two.monitor;

import java.util.Scanner;

public class DocumentManagerCLI {

    private DocumentManager documentManager;

    public DocumentManagerCLI(DocumentManager documentManager) {
        this.documentManager = documentManager;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("commit")) {
                documentManager.commit();
            } else if (command.startsWith("info")) {
                String[] parts = command.split(" ");
                if (parts.length != 2) {
                    System.out.println("Invalid command. Usage: info <filename>");
                } else {
                    String filename = parts[1];
                    documentManager.printFileInfo(filename);
                }
            } else if (command.equals("status")) {
                documentManager.printStatus();
            } else if (command.equals("list")) {
                documentManager.listAllDocuments();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Available commands: commit, info <filename>, status, list, exit");
            }
        }
    }
}
