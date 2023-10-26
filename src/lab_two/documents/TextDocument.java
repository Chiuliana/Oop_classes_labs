package lab_two.documents;
// TextDocument.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextDocument extends Document {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextDocument(String filename) {
        super(filename, "txt");
        // Initialize lineCount, wordCount, charCount here
    }

    @Override
    public void getInfo() {
        // Implement logic to get text file information
    }

    private void calculateTextStats() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += line.split("\\s+").length;
                charCount += line.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


