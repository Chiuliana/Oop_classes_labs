package lab_two.documents;

import java.util.Date;

public class Document {
    protected String filename;
    protected String extension;
    protected boolean changed;
    protected String changeDetails; // New field to store details of changes

    // Constructor
    public Document(String filename, String extension) {
        this.filename = filename;
        this.extension = extension;
        this.changed = false;
        this.changeDetails = "";
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
        System.out.println("Document marked as changed: " + details);
    }

    // Overloaded method to mark the document as changed without details
    public void markChanged() {
        markChanged("No details provided");
    }

    // Method to reset the changed flag
    public void resetChanged() {
        this.changed = false;
        this.changeDetails = "";
    }

    // Method to get details of changes
    public String getChangeDetails() {
        return changeDetails;
    }
}
