package lab_two.documents;

public class ImageDocument extends Document {
    private int width;
    private int height;

    // Constructor
    public ImageDocument(String filename, String extension, int width, int height) {
        super(filename, extension);
        this.width = width;
        this.height = height;
    }

    // Getters for width and height
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Additional method that modifies the document, e.g., updating width and height
    public void modifyDocument(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;

        // Mark the document as changed after making modifications
        markChanged("Updated width and height");
    }
}
