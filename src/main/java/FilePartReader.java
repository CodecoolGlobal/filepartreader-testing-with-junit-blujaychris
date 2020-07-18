public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getFromLine() {
        return fromLine;
    }

    public void setFromLine(int fromLine) {
        this.fromLine = fromLine;
    }

    public int getToLine() {
        return toLine;
    }

    public void setToLine(int toLine) {
        this.toLine = toLine;
    }

}
