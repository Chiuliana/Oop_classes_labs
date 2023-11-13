package lab_two.documents;

import java.util.Date;

public class Document {
    protected String filename;
    protected String extension;
    protected boolean changed;
    protected String changeDetails; // New field to store details of changes
    private long lastCheckedTime;     // New field to store the last checked time

    // Constructor
    public Document(String filename, String extension) {
        this.filename = filename;
        this.extension = extension;
        this.changed = false;
        this.changeDetails = "";
        this.lastCheckedTime = System.currentTimeMillis();
    }

    // Getter for filename
    public String getFilename() {
        return filename;
    }

    // Getter for extension
    public String getExtension() {
        return extension;
    }

    // Getter for changed flag
    public boolean isChanged() {
        return changed;
    }

    // Method to mark the document as changed with details about the changes
    public void markChanged(String details) {
        this.changed = true;
        this.changeDetails = details;
    }

    // Overloaded method to mark the document as changed without details
    public void markChanged() {
        markChanged("No details provided");
    }

    // Method to reset the changed status of the document
    public void resetChanged() {
        this.changed = false;
        this.changeDetails = null;
    }

    // Method to get details of changes
//    public String getChangeDetails() {
//        return changeDetails;
//    }

    // Method to update the last checked time
    public void updateLastCheckedTime() {
        this.lastCheckedTime = System.currentTimeMillis();
    }

    // Getter for last checked time
    public long getLastCheckedTime() {
        return lastCheckedTime;
    }
}
