package lab_two.documents;

import java.util.Date;
public class Document {
    protected String filename;
    protected String extension;
    protected boolean changed;

    // Constructor
    public Document(String filename, String extension) {
        this.filename = filename;
        this.extension = extension;
        this.changed = false;
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

    // Method to mark the document as changed
    public void markChanged() {
        this.changed = true;
    }

    // Method to reset the changed flag
    public void resetChanged() {
        this.changed = false;
    }
}
