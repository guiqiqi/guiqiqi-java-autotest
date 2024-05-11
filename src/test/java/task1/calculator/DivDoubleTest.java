package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DivDoubleTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(doubles = { 0.0, -1.0, 1.0, 12345.67, -12345.67 })
    void testDivisionByZero(double input) {
        assertThrows(NumberFormatException.class, () -> calculator.div(input, 0.0));
    }

    @ParameterizedTest
    @ValueSource(doubles = { -1.0, 1.0, 12345.67, -12345.67 })
    void testDivisionByOne(double input) {
        assertEquals(input, calculator.div(input, 1.0), DELTA);
    }

    @ParameterizedTest
    @CsvSource({ "4.0, 20.0, 5.0", "-6.0, 36.0, -6.0", "-9.0, -72.0, 8.0" })
    void testGeneralCorrectness(double expected, double a, double b) {
        assertEquals(expected, calculator.div(a, b), DELTA);
    }
}