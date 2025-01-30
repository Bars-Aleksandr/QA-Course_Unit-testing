package lessons.second;

import lessons.first.Calculator.Calculator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTestLessonHW {
    @Test
    void validateMaxValueInt() {
        assertThat(Calculator.calculation(Integer.MAX_VALUE - 1, 1, '+'))
                .isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void validateMinValueInt() {
        assertThat(Calculator.calculation(Integer.MIN_VALUE + 1, 1, '-'))
                .isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    void additionOverflowCompletesCorrectly() {
        assertThatThrownBy(() -> Calculator.calculation(Integer.MAX_VALUE, 1, '+'))
                .isInstanceOf(ArithmeticException.class).describedAs("Произошел выход результата из допустимых значений");
    }

    @Test
    void subtractionOverflowCompletesCorrectly() {
        assertThatThrownBy(() -> Calculator.calculation(Integer.MIN_VALUE, 1, '-'))
                .isInstanceOf(ArithmeticException.class).describedAs("Произошел выход результата из допустимых значений");
    }
    @Test
    void multiplicationOverflowCompletesCorrectlyHighLimit() {
        assertThatThrownBy(() -> Calculator.calculation(Integer.MAX_VALUE, 2, '*'))
                .isInstanceOf(ArithmeticException.class).describedAs("Произошел выход результата из допустимых значений");
    }

    @Test
    void multiplicationOverflowCompletesCorrectlyWithNegativeNumberHighLimit() {
        assertThatThrownBy(() -> Calculator.calculation(Integer.MIN_VALUE, -2, '*'))
                .isInstanceOf(ArithmeticException.class).describedAs("Произошел выход результата из допустимых значений");
    }
    @Test
    void multiplicationOverflowWithFirstNegativeNumberLowerLimit() {
        assertThatThrownBy(() -> Calculator.calculation(Integer.MIN_VALUE, 2, '*'))
                .isInstanceOf(ArithmeticException.class).describedAs("Произошел выход результата из допустимых значений");
    }
    @Test
    void multiplicationOverflowWithSecondNegativeNumberLowerLimit() {
        assertThatThrownBy(() -> Calculator.calculation(2, Integer.MIN_VALUE, '*'))
                .isInstanceOf(ArithmeticException.class).describedAs("Произошел выход результата из допустимых значений");
    }
    @Test
    void divisionByZeroCompletesCorrectly() {
        assertThatThrownBy(() -> Calculator.calculation(2, 0, '/'))
                .isInstanceOf(ArithmeticException.class).describedAs("Division by zero is not possible");
    }
    @Test
    void powTestPositiveBasePositiveExponent(){
        assertThat(Calculator.calculation(2,3,'^')).isEqualTo(8);
    }
    @Test
    void powTestPositiveBaseZeroExponent(){
        assertThat(Calculator.calculation(2,0,'^')).isEqualTo(1);
    }
    @Test
    void powTestZeroBaseZeroExponent(){
        assertThat(Calculator.calculation(0,0,'^')).isEqualTo(1);
    }
    @Test
    void powTestExceptionPositiveBaseNegativeExponent(){
        assertThatThrownBy(()->Calculator.calculation(5, -2, '^'))
                .isInstanceOf(ArithmeticException.class).describedAs("Возводим только в положительную степень");
    }
    @Test
    void powTestNegativeBaseEvenExponent(){
        assertThat(Calculator.calculation(-5,2,'^')).isEqualTo(25);
    }
    @Test
    void powTestNegativeBaseOddExponent(){
        assertThat(Calculator.calculation(-5,3,'^')).isEqualTo(-125);
    }
    @Test
    void powTestExceedingUpperLimitInt(){
        assertThatThrownBy(()->Calculator.calculation(2, 31, '^'))
                .isInstanceOf(ArithmeticException.class).describedAs("Результат превышает максимально допустимое значение");
    }
    @Test
    void powTestBelowLowerLimitInt(){
        assertThatThrownBy(()->Calculator.calculation(-3, 31, '^'))
                .isInstanceOf(ArithmeticException.class).hasMessage("Результат меньше минимально допустимого значения");
    }

}
