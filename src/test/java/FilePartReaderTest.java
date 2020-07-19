import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
    }

    @Test
    public void checkFilePath(){
        assertEquals("",filePartReader.getFilePath());
    }

    @Test
    public void checkFromLineSet(){
        assertEquals(0,filePartReader.getFromLine());
    }

    @Test
    public void checkToLineSet(){
        assertEquals(0,filePartReader.getToLine());
    }

    @Test
    public void throwArgumentException() {
        filePartReader.setFromLine(1);
        filePartReader.setToLine(2);
        assertDoesNotThrow(() -> filePartReader.setup(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine()));
    }

    @AfterEach
    void tearDown() {
    }
}