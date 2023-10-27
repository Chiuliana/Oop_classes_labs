package lab_two.documents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramDocument extends Document {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public ProgramDocument(String filename) {
        super(filename, "py");
        calculateProgramStats();
    }

    public void getProgramInfo() {
        System.out.println("Filename: " + getFilename());
        System.out.println("Extension: " + getExtension());
        System.out.println("Changed: " + (isChanged() ? "Yes" : "No"));
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }

    private void calculateProgramStats() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                classCount += countOccurrences(line, "\\bclass\\b");
                methodCount += countOccurrences(line, "\\bdef\\s+(\\w+)\\s*\\(.*\\)\\s*:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int countOccurrences(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}


