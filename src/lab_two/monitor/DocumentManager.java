package lab_two.monitor;

import lab_two.documents.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentManager {
    private List<Document> documents = new ArrayList<>();
    private String snapshotTime;

    public DocumentManager() {
        this.snapshotTime = getCurrentTime();
        initializeDocuments();
    }
    private void initializeDocuments() {
        File folder = new File("src/lab_two/my_local_folder");
        System.out.println("Folder Path: " + folder.getAbsolutePath());

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println("File: " + file.getAbsolutePath());
                if (file.isFile()) {
                    String fileName = file.getName();
                    String fileExtension = getFileExtension(fileName);

                    // Instead of creating new documents, add existing files to the list
                    Document existingDocument = createDocumentFromFile(file);
                    if (existingDocument != null) {
                        addDocument(existingDocument);
                    } else {
                        System.out.println("Skipping file: " + fileName);
                    }
                }
            }
        } else {
            System.out.println("No files found in the folder.");
        }
    }

    // New method to create documents from existing files
    private Document createDocumentFromFile(File file) {
        String fileName = file.getName();
        String fileExtension = getFileExtension(fileName);

        switch (fileExtension) {
            case "txt":
                return createTextDocument(file);
            case "png":
                return createImageDocument(file);
            case "java":
                return createJavaDocument(file);
            case "py":
                return createPythonDocument(file);
            case "program":
                return createProgramDocument(file);
            default:
                // For unknown extensions, create a generic Document
                return createGenericDocument(file);
        }
    }

    private Document createGenericDocument(File file) {
        return new Document(file.getName(), getFileExtension(file.getName()));
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }

    private TextDocument createTextDocument(File file) {
        int lineCount = countLines(file);
        int wordCount = countWords(file);
        int charCount = countCharacters(file);

        return new TextDocument(file.getName(), "txt", lineCount, wordCount, charCount);
    }

    private ImageDocument createImageDocument(File file) {
        try {
            BufferedImage image = ImageIO.read(file);

            if (image != null) {
                int width = image.getWidth();
                int height = image.getHeight();

                return new ImageDocument(file.getName(), "png", width, height);
            } else {
                // ImageIO.read returns null if the input file does not contain a recognized image format.
                System.out.println("Unable to read image: " + file.getName());
                return new ImageDocument(file.getName(), "png", 0, 0); // Default values
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ImageDocument(file.getName(), "png", 0, 0); // Default values
        }
    }

    private JavaDocument createJavaDocument(File file) {
        int lineCount = countLines(file);
        int classCount = countOccurrences(file, "\\bclass\\b");
        int methodCount = countOccurrences(file, "\\bdef\\s+(\\w+)\\s*\\(.*\\)\\s*:");

        return new JavaDocument(file.getName(), "java", lineCount, classCount, methodCount);
    }

    private PythonDocument createPythonDocument(File file) {
        int lineCount = countLines(file);
        int functionCount = countOccurrences(file, "\\bdef\\s+(\\w+)\\s*\\(.*\\)\\s*:");

        return new PythonDocument(file.getName(), "py", lineCount, functionCount);
    }

    private ProgramDocument createProgramDocument(File file) {
        return new ProgramDocument(file.getName());
    }

    private int countLines(File file) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) lineCount++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    private int countWords(File file) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    private int countCharacters(File file) {
        int charCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c != '\n' && c != '\r' && c != ' ') charCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charCount;
    }

    private int countOccurrences(File file, String regex) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, regex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
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

    public void addDocument(Document document) {
        documents.add(document);
        document.markChanged(); // Mark the document as changed when adding it
    }

    public void removeDocument(String filename) {
        documents.removeIf(doc -> doc.getFilename().equals(filename));
    }

    public void printFileInfo(String filename) {
        for (Document doc : documents) {
            if (doc.getFilename().equals(filename)) {
                System.out.println("Filename: " + doc.getFilename());
                System.out.println("Extension: " + doc.getExtension());
                System.out.println("Changed: " + (doc.isChanged() ? "Yes" : "No"));

                if (doc instanceof TextDocument) {
                    TextDocument textDoc = (TextDocument) doc;
                    System.out.println("Line Count: " + textDoc.getLineCount());
                    System.out.println("Word Count: " + textDoc.getWordCount());
                    System.out.println("Character Count: " + textDoc.getCharCount());
                } else if (doc instanceof ImageDocument) {
                    ImageDocument imageDoc = (ImageDocument) doc;
                    System.out.println("Width: " + imageDoc.getWidth());
                    System.out.println("Height: " + imageDoc.getHeight());
                } else if (doc instanceof JavaDocument) {
                    JavaDocument javaDoc = (JavaDocument) doc;
                    System.out.println("Line Count: " + javaDoc.getLineCount());
                    System.out.println("Class Count: " + javaDoc.getClassCount());
                    System.out.println("Method Count: " + javaDoc.getMethodCount());
                } else if (doc instanceof PythonDocument) {
                    PythonDocument pythonDoc = (PythonDocument) doc;
                    System.out.println("Line Count: " + pythonDoc.getLineCount());
                    System.out.println("Function Count: " + pythonDoc.getFunctionCount());
                } else if (doc instanceof ProgramDocument) {
                    ProgramDocument programDoc = (ProgramDocument) doc;
                    programDoc.getProgramInfo();
                }

                return;
            }
        }
        System.out.println("Document not found.");
    }

    public void printStatus() {
        System.out.println("Created a snapshot at: " + snapshotTime);
        for (Document doc : documents) {
            System.out.print(doc.getFilename() + " - ");
            if (doc.isChanged()) {
                System.out.println("Changed");
            } else {
                System.out.println("No Change");
            }
        }
    }

    public void commit() {
        snapshotTime = getCurrentTime();
        for (Document doc : documents) {
            doc.resetChanged();
        }
        System.out.println("Snapshot updated.");
    }

    private String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm:ss.SSSSSSSSS");
        return currentTime.format(formatter);
    }
    // Method to list all documents
    public void listAllDocuments() {
        for (Document doc : documents) {
            System.out.println(doc.getFilename() + " - " + doc.getExtension());
        }
    }
}
