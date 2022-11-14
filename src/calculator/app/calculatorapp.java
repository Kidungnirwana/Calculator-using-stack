package calculator.app;

import calculator.data.calculator;

public class calculatorapp {

	public static void main(String[] args)  throws Exception {
		
		calculator calculator = new calculator();
		calculator.process();
		calculator.display();

	}

}
