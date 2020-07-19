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
        fileWordAnalyzer.getFilePartReader().setFilePath("test_data.txt");
        fileWordAnalyzer.getFilePartReader().setFromLine(1);
        fileWordAnalyzer.getFilePartReader().setToLine(6);
    }

    @Test
    public void checkFileReaderSet() {
        assertNotNull(fileWordAnalyzer.getFilePartReader());
    }
    @Test
    public void checkAlphabeticalSort() throws FileNotFoundException {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1a", "1b", "2a", "2b", "2c","3a", "3b", "3c",
                "3d","4a", "4b", "4c", "4d", "4e", "5a", "5b", "5c", "5d", "5e","5f", "6a", "6b", "6c", "6d",
                "6e", "6f", "6g"));
        ArrayList<String> result = fileWordAnalyzer.getWordsOrderedAlphabetically();
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}