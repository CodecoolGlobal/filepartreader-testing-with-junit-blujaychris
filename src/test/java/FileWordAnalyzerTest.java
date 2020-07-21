import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileWordAnalyzerTest {

    private FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void setUp() {
        fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.getFilePartReader().setup("test_data.txt",1,6);
    }

    @Test
    public void checkFileReaderSet() {
        assertNotNull(fileWordAnalyzer.getFilePartReader());
    }
    @Test
    public void checkAlphabeticalSort() throws FileNotFoundException {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1a", "1b", "2a", "2b", "2c","3a", "3b", "3c",
                "3d","4a", "4b", "4c", "4d", "4e", "5a", "5b", "5c", "5d", "5e","5f", "6a", "6b", "6c", "6d",
                "6e", "6f", "6g6"));
        ArrayList<String> result = fileWordAnalyzer.getWordsOrderedAlphabetically();
        assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void checkForWordsContainingSubstring() throws FileNotFoundException {
        String subString = "e";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("4e", "5e","6e"));
        ArrayList<String> result = fileWordAnalyzer.getWordsContainingSubstring(subString);
        assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void checkForPalindromes() throws FileNotFoundException {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("6g6"));
        ArrayList<String> result = fileWordAnalyzer.getStringsWithPalindromes();
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}