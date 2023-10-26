package lab_two.documents;

public class ImageDocument extends Document {
    private String imageSize;

    public ImageDocument(String filename) {
        super(filename, "png");
        // Initialize imageSize here
    }

    @Override
    public void getInfo() {
        // Implement logic to get image file information
    }
}

