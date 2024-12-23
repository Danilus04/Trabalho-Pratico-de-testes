package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AddTest {

    @Test
    void testAddTwoOneDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(1);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(2), result);
    }

    @Test
    void testAddTwoDoubleDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 5);
        List<Integer> right = Arrays.asList(1, 0);

        List<Integer> result = add.add(left, right);

        assertEquals(result, result);
    }

    @Test
    void testAddTwoThreeDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(5, 0, 0);
        List<Integer> right = Arrays.asList(2, 5, 0);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(7, 5, 0), result);
    }

    @Test
    void testLeftOrRightDontHaveNumbers() {
        Add add = new Add();

        List<Integer> result1 = add.add(Arrays.asList(), Arrays.asList(1, 2, 3));
        assertEquals(Arrays.asList(1, 2, 3), result1); // T01

        List<Integer> result2 = add.add(Arrays.asList(1, 2, 3), Arrays.asList());
        assertEquals(Arrays.asList(1, 2, 3), result2); // T02

        List<Integer> result3 = add.add(Arrays.asList(), Arrays.asList());
        assertEquals(Arrays.asList(), result3); // T03
    }

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
    void ArgumentsLimitsTest() {
        Add add = new Add();

        assertThrows(IllegalArgumentException.class, () -> {
            add.add(Arrays.asList(10, 1, 2), Arrays.asList(2, 1, 2));
        }); // T01

        assertThrows(IllegalArgumentException.class, () -> {
            add.add(Arrays.asList(-1, 1, 2), Arrays.asList(2, 1, 2));
        }); // T02
    }

    @Test
    void testAddTwoMultiDigitNumbersWithoutCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1, 5);
        List<Integer> right = Arrays.asList(1, 0);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 5), result);
    }

    @Test
    void testAddTwoMultiDigitNumbersWithCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1, 5);
        List<Integer> right = Arrays.asList(1, 5);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(3, 0), result);
    }

    @Test
    void testAddThreeDigitNumbers() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(5, 0, 0);
        List<Integer> right = Arrays.asList(2, 5, 0);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(7, 5, 0), result);
    }

    @Test
    void testAddNumbersWithDifferentLengthsNoCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1, 2);
        List<Integer> right = Arrays.asList(2, 5, 0);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 6, 2), result);
    }

    @Test
    void testAddOneDigitWithLargeNumberNoCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(2, 5, 0, 0, 0, 9);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 5, 0, 0, 1, 0), result);
    }

    @Test
    void testAddOneDigitWithLargeNumberWithCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(2, 5, 9, 9, 9, 9);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(2, 6, 0, 0, 0, 0), result);
    }

    @Test
    void testAddTwoLargeNumbersWithCarry() {
        Add add = new Add();
        List<Integer> left = Arrays.asList(9, 9, 9);
        List<Integer> right = Arrays.asList(9, 9, 9);
        List<Integer> result = add.add(left, right);
        assertEquals(Arrays.asList(9, 9, 8), result);
    }

}
