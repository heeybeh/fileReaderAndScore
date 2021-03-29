package jUnitTests;
import com.backendTest.Archieve;
import com.backendTest.SearchEngine;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchEngineTest {
    private final SearchEngine searchEngine = new SearchEngine();

    Path resourceDirectory = Paths.get("tests","resources", "scanDirectoryTestScenario");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    /**
     *  mocklist comparing to returned scan path
     * */
    @Test
    void scanDirectoryTestIfIsInsertingRightlyIntoArchieve() {
        List<String> expectedArchiveNames = new ArrayList<>();
        expectedArchiveNames.add(absolutePath + "/test-0.txt");
        expectedArchiveNames.add(absolutePath + "/test-1.txt");
        expectedArchiveNames.add(absolutePath + "/test-2.txt");
        expectedArchiveNames.add(absolutePath + "/test-3.txt");
        expectedArchiveNames.add(absolutePath + "/test-4.txt");
        expectedArchiveNames.add(absolutePath + "/test-5.txt");
        expectedArchiveNames.add(absolutePath + "/test-6.txt");
        expectedArchiveNames.add(absolutePath + "/test-7.txt");
        expectedArchiveNames.add(absolutePath + "/test-8.txt");

        List<Archieve> testResult = searchEngine.scanDirectory(absolutePath);

        for (Archieve archieve : testResult) {
            assert (expectedArchiveNames.contains(archieve.getFile()));
        }
    }

    /**
     *  reading file content and inserting into Archieve file content
     * */
    @Test
    public void openingAndReadingFileAndInsertingRightIntoArchieveFileContent() {
        String path = absolutePath + "/test-0.txt";
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve(path, 0, ""));
        searchEngine.openAndReadFile(testResult);
        assertEquals("test", testResult.get(0).getFileContent());
    }

    /**
     *  all words searched were found
     * */
    @Test
    public void rankFileFindAllWordsFoundInsertedInFileContent() {
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve(absolutePath, 0, "test one two"));
        String[] testArray = {"test"};
        searchEngine.rankFile(testArray, testResult);
        assertEquals(100.00,testResult.get(0).getScore());
    }

    /**
     *  no words searched were found
     * */
    @Test
    public void rankFileFindNoWordsFoundInsertedInFileContent() {
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve(absolutePath, 0, "test one two"));
        String[] testArray = {"seven"};
        searchEngine.rankFile(testArray, testResult);
        assertEquals(00.00, testResult.get(0).getScore());
    }
}