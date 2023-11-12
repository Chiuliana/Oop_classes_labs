package lab_two;

import lab_two.monitor.DocumentManager;
import lab_two.monitor.DocumentManagerCLI;

public class Main2 {
    public static void main(String[] args) {
        // Create an instance of DocumentManager
        DocumentManager documentManager = new DocumentManager();

        // Create a DocumentManagerCLI and start the command-line interface
        DocumentManagerCLI cli = new DocumentManagerCLI(documentManager);
        cli.start();
    }
}

