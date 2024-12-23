package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AddTest {

    @Test
    void testLeftOrRightIsNull() {
        Add add = new Add();

        List<Integer> result1 = add.add(null, Arrays.asList(1, 2, 3));
        assertNull(result1); // T01

        List<Integer> result2 = add.add(Arrays.asList(1, 2, 3), null);
        assertNull(result2); // T02

        List<Integer> result3 = add.add(null, null);
        assertNull(result3); // T03
    }

    @Test
    void testLeftOrRightDontHaveNumbers() {
        Add add = new Add();

        List<Integer> result1 = add.add(Arrays.asList(), Arrays.asList(1, 2, 3));
        assertEquals(Arrays.asList(1, 2, 3), result1); // T04

        List<Integer> result2 = add.add(Arrays.asList(1, 2, 3), Arrays.asList());
        assertEquals(Arrays.asList(1, 2, 3), result2); // T05

        List<Integer> result3 = add.add(Arrays.asList(), Arrays.asList());
        assertEquals(Arrays.asList(), result3); // T06
    }

    @Test
    void ArgumentsLimitsTest() {
        Add add = new Add();

        assertThrows(IllegalArgumentException.class, () -> {
            add.add(Arrays.asList(10, 1, 2), Arrays.asList(2, 1, 2));
        }); // T07

        assertThrows(IllegalArgumentException.class, () -> {
            add.add(Arrays.asList(-1, 1, 2), Arrays.asList(2, 1, 2));
        }); // T08
    }

    @Test
    void testAddTwoOneDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(1);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(2), result); // T09
    }

    @Test
    void testAddTwoDoubleDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 5);
        List<Integer> right = Arrays.asList(1, 0);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(2, 5), result); // T10
    }

    @Test
    void testAddTwoThreeDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(5, 0, 0);
        List<Integer> right = Arrays.asList(2, 5, 0);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(7, 5, 0), result); // T11
    }

    @Test
    void testAddNumbersWithDifferentLengthsNoCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1, 2);
        List<Integer> right = Arrays.asList(2, 5, 0);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 6, 2), result);
    } // T12

    @Test
    void testAddOneDigitWithLargeNumberNoCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(2, 5, 0, 0, 0, 9);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 5, 0, 0, 1, 0), result);
    } // T13

    @Test
    void testAddOneDigitWithLargeNumberWithCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(2, 5, 9, 9, 9, 9);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 6, 0, 0, 0, 0), result);
    } // T14

    @Test
    void testAddConsistencyWithLargeValues() {
        Add add = new Add();
        List<Integer> accumulator = Arrays.asList(0, 0, 0, 0); // Inicializa com 0
        List<Integer> increment = Arrays.asList(1); // Incremento unitário

        int iterations = 1000; // Número de iterações
        int i = 0;
        while (i < iterations) {
            accumulator = add.add(accumulator, increment);            
            i++;
        }       

        // O resultado esperado é uma lista de dígitos representando o número total de
        // iterações
        List<Integer> expected = Arrays.asList(1, 0, 0, 0); // 1_000 em dígitos
        assertEquals(expected, accumulator);
    } //T15

}
