package lab_two.monitor;

import lab_two.documents.Document;
import lab_two.documents.ImageDocument;
import lab_two.documents.TextDocument;

import java.util.ArrayList;
import java.util.List;

public class DocumentManager {
    private List<Document> documents = new ArrayList<>();
    private String snapshotTime;

    // Constructor
    public DocumentManager() {
        this.snapshotTime = getCurrentTime(); // Implement getCurrentTime method
    }

    // Method to add documents to the list
    public void addDocument(Document document) {
        documents.add(document);
    }

    // Method to remove documents from the list
    public void removeDocument(String filename) {
        documents.removeIf(doc -> doc.getFilename().equals(filename));
    }

    // Method to get document info
    public void printFileInfo(String filename) {
        for (Document doc : documents) {
            if (doc.getFilename().equals(filename)) {
                System.out.println("Filename: " + doc.getFilename());
                System.out.println("Extension: " + doc.getExtension());
                System.out.println("Changed: " + (doc.isChanged() ? "Yes" : "No"));

                if (doc instanceof TextDocument) {
                    TextDocument textDoc = (TextDocument) doc;
                    System.out.println("Line Count: " + textDoc.getLineCount());
                    System.out.println("Word Count: " + textDoc.getWordCount());
                    System.out.println("Character Count: " + textDoc.getCharCount());
                } else if (doc instanceof ImageDocument) {
                    ImageDocument imageDoc = (ImageDocument) doc;
                    System.out.println("Width: " + imageDoc.getWidth());
                    System.out.println("Height: " + imageDoc.getHeight());
                } // Add similar blocks for other document types

                return;
            }
        }
        System.out.println("Document not found.");
    }

    // Method to print status
    public void printStatus() {
        System.out.println("Created a snapshot at: " + snapshotTime);
        for (Document doc : documents) {
            System.out.print(doc.getFilename() + " - ");
            if (doc.isChanged()) {
                System.out.println("Changed");
            } else {
                System.out.println("No Change");
            }
        }
    }

    // Method to update snapshot time (commit)
    public void commit() {
        snapshotTime = getCurrentTime(); // Implement getCurrentTime method
        for (Document doc : documents) {
            doc.resetChanged();
        }
        System.out.println("Snapshot updated.");
    }

    // Helper method to get current time (You'll need to implement this)
    private String getCurrentTime() {
        // Implement this to return the current time in the desired format
        return "";
    }
}


