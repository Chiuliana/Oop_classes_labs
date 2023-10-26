package lab_two.documents;

public class ImageDocument extends Document {
    private int width;
    private int height;

    public ImageDocument(String filename, int width, int height) {
        super(filename);
        this.width = width;
        this.height = height;
    }

    @Override
    public void displayInfo() {
        System.out.println("File: " + filename + "." + extension);
        System.out.println("Image size: " + width + "x" + height);
    }
}

