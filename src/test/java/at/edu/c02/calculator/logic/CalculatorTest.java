package at.edu.c02.calculator.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.CalculatorException;

@Tag("annotations")
@Tag("junit5")
@RunWith(JUnitPlatform.class)
public class CalculatorTest {

	@Test
	public void testSimpleAddOperation() throws Exception {

		// setup
		Calculator calc = new CalculatorImpl();

		// execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.add);

		// verify
		assertEquals(5, result);

	}

	@Test
	public void testSimpleMulOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.mul);

		assertEquals(6, result);

	}

	@Test
	public void testSimpleDivOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(6.0);
		calc.push(2);
		double result = calc.perform(Operation.div);

		assertEquals(3, result);

	}

	//
	@Test
	public void testPopOnEmptyStack() throws Exception {

		Assertions.assertThrows(Exception.class, () -> {
			Calculator calc = new CalculatorImpl();
			calc.pop();
		});
	}

	@Test
	public void testDivisionByZero() throws Exception {

		// Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.div);

			Assertions.fail("Exception expected");

		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}

	}
}
