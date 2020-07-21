import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public int getFromLine() {
//        return fromLine;
//    }
//
//    public void setFromLine(int fromLine) {
//        this.fromLine = fromLine;
//    }
//
//    public int getToLine() {
//        return toLine;
//    }
//
//    public void setToLine(int toLine) {
//        this.toLine = toLine;
//    }

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath=filePath;
        this.fromLine=fromLine;
        this.toLine=toLine;
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine can't be less than 1");
        } else if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine can't be less than fromLine");
        } else {
            System.out.println("All is fine and dandy");
        }

    }

    public String read() throws FileNotFoundException {
        return new Scanner(new File(filePath)).useDelimiter("\\Z").next();
    }

    public String readLines() throws FileNotFoundException {
        String[] lines = read().split("\\r?\\n");
        if (toLine > lines.length) throw new IllegalArgumentException("toLine is past end of file");
        String[] resultLines = Arrays.copyOfRange(lines, fromLine - 1, toLine);
        return String.join("\n", resultLines);
    }

}
