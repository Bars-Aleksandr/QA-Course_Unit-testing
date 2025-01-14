import org.junit.jupiter.api.Test;
import seminars.first.Calculator.Calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
	@Test
	void evaluatesExpression() {
		Calculator calculator = new Calculator();
		assertThat(calculator.calculation(2, 3, '+')).isEqualTo(5);
	}

	@Test
	void subtractionExpression() {
		Calculator calculator = new Calculator();
		assertThat(calculator.calculation(5, 3, '-')).isEqualTo(2);
	}

	@Test
	void multiplicationExpression() {
		Calculator calculator = new Calculator();
		assertThat(calculator.calculation(5, 3, '*')).isEqualTo(15);
	}

	@Test
	void divisionExpression() {
		Calculator calculator = new Calculator();
		assertThat(calculator.calculation(6, 3, '/')).isEqualTo(2);
	}

	@Test
	void expectedIllegalStateExceptionOnInvalidOperatorSymbol() {
		Calculator calculator = new Calculator();
		assertThatThrownBy(() -> calculator.calculation(3, 3, '_'))
				.isInstanceOf(IllegalStateException.class);
	}
	@Test
	void getOperandCompletesCorrectlyWithNumbers(){
		String testedValue = "9";
		ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
		InputStream inputStream = System.in;
		System.setIn(in);

		Calculator.getOperand();

		System.out.println(testedValue);
		System.setIn(inputStream);
	}
	@Test
	void getOperandCompletesCorrectlyWithNotNumbers(){
		String testedValue = "k";
		ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream inputStream = System.in;
		System.setIn(in);
		System.setOut(new PrintStream(out));

		assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class)
				.describedAs("Ошибка в вводимых данных");
		System.setIn(inputStream);
		System.setOut(null);
	}
}