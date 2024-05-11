package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MulLongTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(longs = { 0, -1, 1, 12345, -12345 })
    void testMultiplicationWithZero(long input) {
        assertEquals(0, calculator.mult(input, 0));
    }

    @ParameterizedTest
    @ValueSource(longs = { -1, 1, 12345, -12345 })
    void testMultiplicationWithOne(long input) {
        assertEquals(input, calculator.mult(input, 1));
    }

    @ParameterizedTest
    @CsvSource({ "6, 2, 3", "1, -1, -1", "0, -5, 0" })
    void testGeneralCorrectness(long expected, long a, long b) {
        assertEquals(expected, calculator.mult(a, b));
    }
}
