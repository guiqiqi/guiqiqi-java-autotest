package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AddLongTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(longs = { 0, -1, 1, 12345, -12345 })
    void testAdditionWithZero(long input) {
        assertEquals(input, calculator.sum(input, 0));
    }

    @ParameterizedTest
    @ValueSource(longs = { 0, -1, 1, 12345, -12345 })
    void testAdditionWithSelf(long input) {
        assertEquals(input * 2, calculator.sum(input, input));
    }

    @ParameterizedTest
    @CsvSource({ "5, 2, 3", "-2, -1, -1", "0, -5, 5" })
    void testGeneralCorrectness(long expected, long a, long b) {
        assertEquals(expected, calculator.sum(a, b));
    }
}
