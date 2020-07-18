import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public FilePartReader getFilePartReader() {
        return filePartReader;
    }

    public List getWordsOrderedAlphabetically() throws FileNotFoundException {
        String[] words = filePartReader.readLines().split("\\W+");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        wordsList.sort(String::compareTo);
        return wordsList;
    }

    public List getWordsContainingSubstring() {
        filePartReader.readLines();
    }

    public List getStringsWithPalindromes() {
        filePartReader.readLines();
    }

}
