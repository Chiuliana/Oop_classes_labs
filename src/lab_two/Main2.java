package lab_two;

import lab_two.documents.ImageDocument;
import lab_two.documents.JavaDocument;
import lab_two.documents.PythonDocument;
import lab_two.documents.TextDocument;
import lab_two.monitor.DocumentManager;
import lab_two.monitor.DocumentManagerCLI;

public class Main2 {
    public static void main(String[] args) {
        DocumentManager documentManager = new DocumentManager();

        TextDocument textDoc = new TextDocument("test.txt", "txt", 10, 50, 300);
        ImageDocument imageDoc = new ImageDocument("image.png", "png", 1024, 860);
        JavaDocument javaDoc = new JavaDocument("MyJava.java", "java", 500, 15, 50);
        PythonDocument pythonDoc = new PythonDocument("MyPython.py", "py", 200, 10);
        PythonDocument pythonCopyDoc = new PythonDocument("MyPython_copy.py", "py", 200, 10);

        documentManager.addDocument(textDoc);
        documentManager.addDocument(imageDoc);
        documentManager.addDocument(javaDoc);
        documentManager.addDocument(pythonDoc);
        documentManager.addDocument(pythonCopyDoc);

        DocumentManagerCLI cli = new DocumentManagerCLI(documentManager);
        cli.start();
    }
}
