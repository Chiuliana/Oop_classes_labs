package lab_two.monitor;

import lab_two.documents.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FolderMonitor {
    private String folderPath;
    private List<Document> documents;
    private Date snapshotTime;

    public FolderMonitor(String folderPath) {
        this.folderPath = folderPath;
        this.documents = new ArrayList<>();
        this.snapshotTime = null;
    }

    public void commit() {
        this.snapshotTime = new Date();
        for (Document document : documents) {
            document.changed = false;
        }
    }

    public void scanFolder() {
        System.out.println("Scanning folder: " + folderPath);
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    updateFileInfo(file.getAbsolutePath());
                }
            }
        }
    }

    private void updateFileInfo(String filePath) {
        // Implement logic to update file information
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
    }

    public void getDocumentInfo(String filename) {
        for (Document document : documents) {
            if (document.filename.equals(filename)) {
                document.getInfo();
                return;
            }
        }
        System.out.println("Document not found.");
    }

    public void printStatus() {
        for (Document document : documents) {
            String status = document.changed ? "Changed" : "No Change";
            System.out.println(document.filename + " - " + status);
        }
    }
}

