package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DivLongTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(longs = {0, -1, 1, 12345, -12345})
    void testDivisionByZero(long input) {
        assertThrows(NumberFormatException.class, () -> calculator.div(input, 0));
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1, 1, 12345, -12345})
    void testDivisionByOne(long input) {
        assertEquals(input, calculator.div(input, 1));
    }

    @ParameterizedTest
    @CsvSource({"4, 20, 5", "-6, 36, -6", "-9, -72, 8"})
    void testGeneralCorrectness(long expected, long a, long b) {
        assertEquals(expected, calculator.div(a, b));
    }
}
