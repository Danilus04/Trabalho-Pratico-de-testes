package br.edu.utfpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeftPadTest {

    @Test
    void testStrParameter() {
        // T01
        assertNull(LeftPad.leftPad(null, 5, "-"));

        // T02
        assertEquals("-----", LeftPad.leftPad("", 5, "-"));

        // T03
        assertEquals("abc", LeftPad.leftPad("abc", 2, "-"));

        // T04
        assertEquals("--abc", LeftPad.leftPad("abc", 5, "-"));
    }

    @Test
    void testSizeParameter() {
        // T08 (Negative size)
        assertEquals("abc", LeftPad.leftPad("abc", -1, "-"));

        // T08 (Large size)
        assertEquals("-----------------abc", LeftPad.leftPad("abc", 20, "-"));
    }

    @Test
    void testPadStrParameter() {
        // T05
        assertEquals("  abc", LeftPad.leftPad("abc", 5, null));

        // T06
        assertEquals("  abc", LeftPad.leftPad("abc", 5, ""));

        // T07
        assertEquals("---abc", LeftPad.leftPad("abc", 6, "-"));

        // T08
        assertEquals("-=-abc", LeftPad.leftPad("abc", 6, "-="));
    }

    @Test
    void testParameterCombinations() {
        // T09
        assertEquals("-=-=abc", LeftPad.leftPad("abc", 7, "-="));

        // T10
        assertEquals("(O)(O)(O)(O)(O)(O)(O)(O)(O)abc", LeftPad.leftPad("abc", 30, "(O)"));

        // T11
        assertEquals("(O)(O)(O)(O)(O)(O)(O)(O)(abc", LeftPad.leftPad("abc", 28, "(O)"));
    }
}