package calculator.data;



public abstract class operatorsss {
	
	
	public double doOperatror (Double operator1, Double operator2, Character operator) {
		switch (operator) {
		case '+': 
			return operator1 + operator2;
			
		case '-': 
			return operator1 - operator2;
			
		case '*': 
			return operator1 * operator2;
			
		case '/': 
			return operator1 / operator2;
			
		default:
			return 0;
		}
	}
	
	public int comparePrecedence(char operator1, char operator2) {
		if(operator1 == '+' || operator1 == '-')
            if(operator2 == '+' || operator2 == '-')
                return 0;
            else
                return -1;
        else if(operator2 == '+' || operator2 == '-')
            return 1;
        else
            return 0;

	}
}