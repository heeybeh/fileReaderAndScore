package jUnitTests;

import com.backendTest.RankingArchieves;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankingArchievesTest {

    @Test
    public void rankFileTestNoWordsFound() {
        double wordEntrySize = 5.0;
        int points = 5;
        double rankValue = RankingArchieves.calcRankArchieves(wordEntrySize,points);
        assertEquals(100.00,rankValue);
    }
}