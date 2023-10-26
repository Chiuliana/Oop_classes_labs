package lab_two.documents;

public abstract class ProgramDocument extends Document {
    public ProgramDocument(String filename) {
        super(filename);
    }

    public abstract int getLineCount();
    public abstract int getClassCount();
    public abstract int getMethodCount();
}
