package task1.calculator;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

class AbstractCalculatorTest {
    protected static Calculator calculator;
    protected static final double DELTA = 0.1;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }
}
