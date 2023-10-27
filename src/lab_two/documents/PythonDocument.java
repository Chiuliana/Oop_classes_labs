package lab_two.documents;

public class PythonDocument extends Document {
    private int lineCount;
    private int functionCount;

    // Constructor
    public PythonDocument(String filename, String extension, int lineCount, int functionCount) {
        super(filename, extension);
        this.lineCount = lineCount;
        this.functionCount = functionCount;
    }

    // Getters for lineCount and functionCount
    public int getLineCount() {
        return lineCount;
    }

    public int getFunctionCount() {
        return functionCount;
    }

}

