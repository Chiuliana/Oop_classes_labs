package lab_two.documents;

public class JavaDocument extends Document {
    private int lineCount;
    private int classCount;
    private int methodCount;

    // Constructor
    public JavaDocument(String filename, String extension, int lineCount, int classCount, int methodCount) {
        super(filename, extension);
        this.lineCount = lineCount;
        this.classCount = classCount;
        this.methodCount = methodCount;
    }

    // Getters for lineCount, classCount, and methodCount
    public int getLineCount() {
        return lineCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public int getMethodCount() {
        return methodCount;
    }

}