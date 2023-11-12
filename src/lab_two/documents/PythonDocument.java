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

    // Additional method that modifies the document, e.g., updating line and function counts
    public void modifyDocument(int newLineCount, int newFunctionCount) {
        this.lineCount = newLineCount;
        this.functionCount = newFunctionCount;

        // Mark the document as changed after making modifications
        markChanged("Updated line count and function count");
    }

}

