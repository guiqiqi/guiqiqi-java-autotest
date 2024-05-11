package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AddDoubleTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(doubles = { 0.0, -1.0, 1.0, 12345.67, -12345.67 })
    void testAdditionWithZero(double input) {
        assertEquals(input, calculator.sum(input, 0.0), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { -1.0, 1.0, 12345.67, -12345.67 })
    void testAdditionWithSelf(double input) {
        assertEquals(input * 2, calculator.sum(input, input), DELTA);
    }

    @ParameterizedTest
    @CsvSource({ "5.7, 2.3, 3.4", "-2.5, -1.2, -1.3", "0.0, -5.5, 5.5" })
    void testGeneralCorrectness(double expected, double a, double b) {
        assertEquals(expected, calculator.sum(a, b), DELTA);
    }
}
