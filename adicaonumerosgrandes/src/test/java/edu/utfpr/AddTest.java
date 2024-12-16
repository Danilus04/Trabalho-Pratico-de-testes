package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

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
    void LeftOrRightDontHaveNumbers() {
        Add add = new Add();

        assertThat(add.add(Arrays.asList(), Arrays.asList(1, 2, 3)))
                .isEqualTo(Arrays.asList(1, 2, 3)); // T01
        assertThat(add.add(Arrays.asList(1, 2, 3), Arrays.asList()))
                .isEqualTo(Arrays.asList(1, 2, 3)); // T02
        assertThat(add.add(Arrays.asList(), Arrays.asList()))
                .isEqualTo(Arrays.asList()); // T03
    }

    @Test
    void LeftOrRightIsNull() {
        Add add = new Add();

        assertThat(add.add(null, Arrays.asList(1, 2, 3)))
                .isNull(); // T01
        assertThat(add.add(Arrays.asList(1, 2, 3), null))
                .isNull(); // T02
        assertThat(add.add(null, null))
                .isNull(); // T03
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
    void randomTest() {
        Add add = new Add();

        assertThat(add.add(Arrays.asList(1), Arrays.asList(1)))
                .isEqualTo(Arrays.asList(2)); // T01

        assertThat(add.add(Arrays.asList(1, 5), Arrays.asList(1, 0)))
                .isEqualTo(Arrays.asList(2, 5)); // T02

        assertThat(add.add(Arrays.asList(1, 5), Arrays.asList(1, 5)))
                .isEqualTo(Arrays.asList(3, 0)); // T03

        assertThat(add.add(Arrays.asList(5, 0, 0), Arrays.asList(2, 5, 0)))
                .isEqualTo(Arrays.asList(7, 5, 0)); // T04

        assertThat(add.add(Arrays.asList(1, 2), Arrays.asList(2, 5, 0)))
                .isEqualTo(Arrays.asList(2, 6, 2)); // T05

        assertThat(add.add(Arrays.asList(1), Arrays.asList(2, 5, 0, 0, 0, 9)))
                .isEqualTo(Arrays.asList(2, 5, 0, 0, 1, 0)); // T06

        assertThat(add.add(Arrays.asList(1), Arrays.asList(2, 5, 9, 9, 9, 9)))
                .isEqualTo(Arrays.asList(2, 6, 0, 0, 0, 0)); // T07

        // MÁ ESPECIFICAÇÃO
        assertThat(add.add(Arrays.asList(9, 9, 9), Arrays.asList(9, 9, 9)))
                .isEqualTo(Arrays.asList(9, 9, 8)); // T08
    }
}
