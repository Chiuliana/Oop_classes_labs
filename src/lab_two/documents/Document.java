package lab_two.documents;
public abstract class Document {
    protected String filename;
    protected String extension;
    protected boolean changed;

    public Document(String filename) {
        this.filename = filename;
        this.extension = getExtension(filename);
        this.changed = false;
    }

    // Getter methods for filename, extension, and changed

    private String getExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1);
        }
        return "";
    }

    public abstract void displayInfo();

    public void displayStatus() {
        System.out.println(filename + " - " + (changed ? "Changed" : "No Change"));
    }
}
