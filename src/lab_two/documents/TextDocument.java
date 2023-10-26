package lab_two.documents;
public class TextDocument extends Document {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextDocument(String filename, int lineCount, int wordCount, int charCount) {
        super(filename);
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("File: " + filename + "." + extension);
        System.out.println("Line count: " + lineCount);
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count: " + charCount);
    }
}
