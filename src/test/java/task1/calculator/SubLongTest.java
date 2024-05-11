package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SubLongTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(longs = { 0, -1, 1, 12345, -12345 })
    void testSubtractionWithZero(long input) {
        assertEquals(input, calculator.sub(input, 0));
    }

    @ParameterizedTest
    @ValueSource(longs = { 0, -1, 1, 12345, -12345 })
    void testSubtractionWithSelf(long input) {
        assertEquals(0, calculator.sub(input, input));
    }

    @ParameterizedTest
    @CsvSource({ "1, 3, 2", "0, -1, -1", "-10, -5, 5" })
    void testGeneralCorrectness(long expected, long a, long b) {
        assertEquals(expected, calculator.sub(a, b));
    }
}