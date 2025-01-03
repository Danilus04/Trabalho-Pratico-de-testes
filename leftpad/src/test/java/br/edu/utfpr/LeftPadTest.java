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
        // T05 (Negative size)
        assertEquals("abc", LeftPad.leftPad("abc", -1, "-"));

        // T06 (Large size)
        assertEquals("-----------------abc", LeftPad.leftPad("abc", 20, "-"));
    }

    @Test
    void testPadStrParameter() {
        // T07
        assertEquals("  abc", LeftPad.leftPad("abc", 5, null));

        // T08
        assertEquals("  abc", LeftPad.leftPad("abc", 5, ""));

        // T09
        assertEquals("---abc", LeftPad.leftPad("abc", 6, "-"));

        // T10
        assertEquals("-=-abc", LeftPad.leftPad("abc", 6, "-="));
    }

    @Test
    void testParameterCombinations() {
        // T11
        assertEquals("-=-=abc", LeftPad.leftPad("abc", 7, "-="));

        // T12
        assertEquals("(O)(O)(O)(O)(O)(O)(O)(O)(O)abc", LeftPad.leftPad("abc", 30, "(O)"));

        // T13
        assertEquals("(O)(O)(O)(O)(O)(O)(O)(O)(abc", LeftPad.leftPad("abc", 28, "(O)"));
    }

    @Test
    void testNullStrParameter() {
        // T14
        assertNull(LeftPad.leftPad(null, -1, null), "T14: Quando 'str' é null, o resultado deve ser null.");

        // T15
        assertNull(LeftPad.leftPad(null, 5, ""), "T15: Quando 'str' é null, o resultado deve ser null.");

        // T16
        assertNull(LeftPad.leftPad(null, -1, "-"), "T16: Quando 'str' é null, o resultado deve ser null.");

        // T17
        assertNull(LeftPad.leftPad(null, -5, "-"), "T17: Quando 'str' é null, o resultado deve ser null.");
    }

    @Test
    void testSizeAndPaddingLength() {
        // T18
        assertEquals("abc", LeftPad.leftPad("abc", -1, null), "T18: Quando 'size' <= tamanho da string, não deve haver mudanças.");

        // T19
        assertEquals("   abc", LeftPad.leftPad("abc", 6, null), "T19: Quando 'padStr' é null ou vazio, deve preencher com espaços.");

        // T20
        assertEquals("abc", LeftPad.leftPad("abc", -1, "-"), "T20: Quando 'size' <= tamanho da string, não deve haver mudanças.");

        // T21
        assertEquals("---abc", LeftPad.leftPad("abc", 6, "-"), "T21: Quando o preenchimento é necessário, usa 'padStr'.");
    }
}