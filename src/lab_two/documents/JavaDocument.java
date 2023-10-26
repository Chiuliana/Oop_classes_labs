package lab_two.documents;

public class JavaDocument extends ProgramDocument {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public JavaDocument(String filename, int lineCount, int classCount, int methodCount) {
        super(filename);
        this.lineCount = lineCount;
        this.classCount = classCount;
        this.methodCount = methodCount;
    }

    @Override
    public int getLineCount() {
        return lineCount;
    }

    @Override
    public int getClassCount() {
        return classCount;
    }

    @Override
    public int getMethodCount() {
        return methodCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("File: " + filename + "." + extension);
        System.out.println("Line count: " + lineCount);
        System.out.println("Class count: " + classCount);
        System.out.println("Method count: " + methodCount);
    }
}
