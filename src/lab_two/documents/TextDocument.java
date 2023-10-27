package lab_two.documents;
public class TextDocument extends Document {
    private int lineCount;
    private int wordCount;
    private int charCount;

    // Constructor
    public TextDocument(String filename, String extension, int lineCount, int wordCount, int charCount) {
        super(filename, extension);
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
    }

    // Getters for lineCount, wordCount, and charCount
    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }
}