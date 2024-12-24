package br.edu.utfpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeftPadTest {

    @Test
    void testLeftPadWithPadding() {
        assertEquals("--abc", LeftPad.leftPad("abc", 5, "-"));
    }

    @Test
    void testLeftPadWithoutPadding() {
        assertEquals("abc", LeftPad.leftPad("abc", 3, "-"));
    }

    @Test
    void testLeftPadWithNullString() {
        assertNull(LeftPad.leftPad(null, 5, "-"));
    }

    @Test
    void testLeftPadWithEmptyPadString() {
        assertEquals("   abc", LeftPad.leftPad("abc", 6, ""));
    }

    @Test
    void testLeftPadWithLargerSize() {
        assertEquals("***abc", LeftPad.leftPad("abc", 6, "*"));
    }
}
