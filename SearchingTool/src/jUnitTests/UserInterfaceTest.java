package jUnitTests;

import com.backend.Archieve;
import com.backend.UserInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInterfaceTest {

    private final UserInterface userInterface = new UserInterface();

    /**
     *  mocking system.in Scanner
     * */
    @Test
    void wordEntryByConsoleMockedReceivingTwoWords() {
        System.setIn(new ByteArrayInputStream("testIn testOut".getBytes()));
        String word = userInterface.wordEntry();
        assertEquals(word, "testIn testOut");
    }

    /**
     *  setUp mock system.out
     * */
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printMessageGivenSystemOutRedirection() {
        UserInterface.printMessage("Test");

        assertEquals("Test", outputStreamCaptor.toString()
                .trim());
    }

    /**
     *  testing formating string
     * */
    @Test
    void givingAdisorderlyListAndCheckingTheOrderedReturn() {
        List<Archieve> testResult = new ArrayList<>();
        testResult.add(new Archieve("/src/test", 0, "file content"));
        testResult.add(new Archieve("/src/test1", 10, "file content"));
        testResult.add(new Archieve("/src/test2", 100, "file content"));
        userInterface.printAllFilesAndScore(testResult);

        assertEquals("test2 : 100 %\ntest1 : 10 %\ntest : 0 %", outputStreamCaptor.toString()
                .trim());
    }


    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }
    /**
     *  testing formating string
     * */
    @Test
    void verifyingIfFormatingStringIsReturningExpectedStringFormat() {
        Archieve archieve = new Archieve("/src/test", 10, "test and test");
        String formatFunc = UserInterface.formatArchiveWithScore(archieve);
        String expectedString = "test : 10 %";
        assertEquals(expectedString, formatFunc);
    }
}