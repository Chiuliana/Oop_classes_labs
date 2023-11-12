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

    // Additional method that modifies the document, e.g., updating line, word, and char counts
    public void modifyDocument(int newLineCount, int newWordCount, int newCharCount) {
        this.lineCount = newLineCount;
        this.wordCount = newWordCount;
        this.charCount = newCharCount;

        // Mark the document as changed after making modifications
        markChanged("Updated line count, word count, and character count");
    }
}