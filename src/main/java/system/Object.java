package system;

import java.io.File;

public class Object{
    private File file;
    private int label;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public File getFile() {

        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Object{" +
                "file=" + file +
                ", label=" + label +
                '}';
    }
}
