import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
    }

//    @Test
//    public void checkFilePath() {
//        assertEquals("", filePartReader.getFilePath());
//    }
//
//    @Test
//    public void checkFromLineSet() {
//        assertEquals(0, filePartReader.getFromLine());
//    }
//
//    @Test
//    public void checkToLineSet() {
//        assertEquals(0, filePartReader.getToLine());
//    }

    @Test
    public void throwArgumentException() {
//        filePartReader.setup();
        assertDoesNotThrow(() -> filePartReader);
    }

    @Test
    public void throwFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> filePartReader.readLines());
    }

    @Test
    public void checkFirstLine() throws FileNotFoundException {

//        filePartReader.setFromLine(1);
//        filePartReader.setToLine(1);
//        filePartReader.setFilePath("test_data.txt");
        filePartReader.setup("test_data.txt",1,1);
        String result = filePartReader.readLines();
        assertEquals("1a 1b", result);
    }

    @Test
    public void checkTwoLinesReturned() throws FileNotFoundException {
//        filePartReader.setFromLine(1);
//        filePartReader.setToLine(2);
//        filePartReader.setFilePath("test_data.txt");
        filePartReader.setup("test_data.txt",1,2);
        String result = filePartReader.readLines();
        assertEquals("1a 1b\n2a 2b 2c", result);
    }

    @Test
    public void checkLinesTwoFourReturned() throws FileNotFoundException {
//        filePartReader.setFromLine(2);
//        filePartReader.setToLine(4);
//        filePartReader.setFilePath("test_data.txt");
        filePartReader.setup("test_data.txt",2,4);
        String result = filePartReader.readLines();
        assertEquals("2a 2b 2c\n3a 3b 3c 3d\n4a 4b 4c 4d 4e", result);
    }

    @Test
    public void checkAllLinesReturned() throws FileNotFoundException {
//        filePartReader.setFromLine(1);
//        filePartReader.setToLine(6);
//        filePartReader.setFilePath("test_data.txt");
        filePartReader.setup("test_data.txt",1,6);
        String result = filePartReader.readLines();
        assertEquals("1a 1b\n2a 2b 2c\n3a 3b 3c 3d\n4a 4b 4c 4d 4e\n" +
                "5a 5b 5c 5d 5e 5f\n6a 6b 6c 6d 6e 6f 6g6", result);
    }

    @Test
    public void throwExceededLimitException() {
//        filePartReader.setFromLine(1);
//        filePartReader.setToLine(7);
//        filePartReader.setFilePath("test_data.txt");
        filePartReader.setup("test_data.txt",1,7);
        assertThrows(IllegalArgumentException.class, () -> filePartReader.readLines());
    }
}
