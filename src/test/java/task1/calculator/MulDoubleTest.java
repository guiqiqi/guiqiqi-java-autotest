package task1.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MulDoubleTest extends AbstractCalculatorTest {
    @ParameterizedTest
    @ValueSource(doubles = { 0.0, -1.0, 1.0, 12345.67, -12345.67 })
    void testMultiplicationWithZero(double input) {
        assertEquals(0.0, calculator.mult(input, 0.0), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { -1.0, 1.0, 12345.67, -12345.67 })
    void testMultiplicationWithOne(double input) {
        assertEquals(input, calculator.mult(input, 1.0), DELTA);
    }

    @ParameterizedTest
    @CsvSource({ "6.0, 2.0, 3.0", "1.0, -1.0, -1.0", "0.0, -5.5, 0.0" })
    void testGeneralCorrectness(double expected, double a, double b) {
        assertEquals(expected, calculator.mult(a, b), DELTA);
    }
}