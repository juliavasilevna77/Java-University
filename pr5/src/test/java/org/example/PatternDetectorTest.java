package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PatternDetectorTest {

    @ParameterizedTest
    @CsvSource({
            "'T', P1",
            "'TE', P2",
            "'TES', P3",
            "'TEST', F",
            "'abcTESabc', S",
            "'TESTING', F",
            "'TESST', P1",
            "'123T456E789S', S",
            "'SOMERANDOMTEXT', P1",
            "'TESTER', F",
            "'TESTXYZTEST', F",
            "'TESTABCTES', F",
            "'abTESTcdTESTef', F",
            "'TEXES', S",
            "'TTETST', P1",
            "'TES123TEST', F",
            "'TTTESTE', F",
            "'TESTTT', F",
            "'', S"
    })
    void testPatternDetector(String input, String expectedPhase) {
        PatternDetector detector = new PatternDetector();

        for (char symbol : input.toCharArray()) {
            detector.evaluateCharacter(symbol);
        }

        assertEquals(PatternDetector.Phase.valueOf(expectedPhase), detector.getCurrentState());
    }
}
