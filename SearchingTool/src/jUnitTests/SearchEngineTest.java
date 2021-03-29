package jUnitTests;
import com.backendTest.Archieve;
import com.backendTest.SearchEngine;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchEngineTest {
    private final SearchEngine searchEngine = new SearchEngine();

    Path resourceDirectory = Paths.get("tests","resources", "scanDirectoryTestScenario");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    @Test
    void scanDirectoryTest() {
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

    @Test
    public void openAndReadFileTest() {
        String path = absolutePath + "/test-0.txt";
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve(path, 0, ""));
        searchEngine.openAndReadFile(testResult);
        assert(testResult.get(0).getFileContent().equals("test"));
    }

    @Test
    public void rankFileTestAllWordsFound() {
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve(absolutePath, 0, "test one two"));
        String[] testArray = {"test"};
        searchEngine.rankFile(testArray, testResult);
        assert(testResult.get(0).getScore() == 100.00);
    }

    @Test
    public void rankFileTestNoWordsFound() {
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve(absolutePath, 0, "test one two"));
        String[] testArray = {"seven"};
        searchEngine.rankFile(testArray, testResult);
        assert(testResult.get(0).getScore() == 00.00);
    }
}