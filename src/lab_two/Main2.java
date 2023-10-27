package lab_two;

import lab_two.documents.ImageDocument;
import lab_two.documents.TextDocument;
import lab_two.monitor.DocumentManager;
import lab_two.monitor.DocumentManagerCLI;

public class Main2 {
    public static void main(String[] args) {
        DocumentManager documentManager = new DocumentManager();

        // Initialize documents (example)
        TextDocument textDoc = new TextDocument("test.txt", "txt", 10, 50, 300);
        ImageDocument imageDoc = new ImageDocument("image.png", "png", 1024, 860);

        documentManager.addDocument(textDoc);
        documentManager.addDocument(imageDoc);

        DocumentManagerCLI cli = new DocumentManagerCLI(documentManager);
        cli.start();
    }
}
