package lab_two.documents;
// Document.java

import java.util.Date;

public class Document {
    protected String filename;
    protected String extension;
    protected boolean changed;

    public Document(String filename, String extension) {
        this.filename = filename;
        this.extension = extension;
        this.changed = false;
    }

    public void getInfo() {
        // To be implemented in subclasses
    }
}
