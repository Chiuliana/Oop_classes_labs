package lab_two.monitor;

import lab_two.documents.Document;

import java.util.ArrayList;
import java.util.List;

public class FileMonitor {
    private List<Document> documents = new ArrayList<>();
    private Snapshot snapshot = new Snapshot();

    // Add documents to the list
    public void addDocument(Document document) {
        documents.add(document);
    }

    public void displayInfo(String part) {
    }

    // Other methods as before
}
