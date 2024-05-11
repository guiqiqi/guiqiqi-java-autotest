package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SubDoubleTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(doubles = { 0.0, -1.0, 1.0, 12345.67, -12345.67 })
    void testSubtractionWithZero(double input) {
        assertEquals(input, calculator.sub(input, 0.0), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { -1.0, 1.0, 12345.67, -12345.67 })
    void testSubtractionWithSelf(double input) {
        assertEquals(0.0, calculator.sub(input, input), DELTA);
    }

    @ParameterizedTest
    @CsvSource({ "1.1, 3.2, 2.1", "0.0, -1.1, -1.1", "-10.5, -5.5, 5.0" })
    void testGeneralCorrectness(double expected, double a, double b) {
        assertEquals(expected, calculator.sub(a, b), DELTA);
    }
}