package calculator.data;

import java.util.*;

public class calculator extends operatorsss {
	private Scanner inputScanner = new Scanner(System.in);
	private Stack<Character> operators = new Stack<Character>();
	private Stack<Double> operands = new Stack<Double>();
	
	
	private int getOperands(String expression, int i){
        Scanner inputScanner = new Scanner(expression.substring(i));
        inputScanner.useDelimiter("[^0-9]");
        return inputScanner.nextInt();
    }
    
    public void process() throws Exception {
		
			System.out.println("Masukan perhitungan: ");
			String expression = inputScanner.nextLine();
			
			for (int i = 0; i < expression.length(); i++) {
				switch (expression.charAt(i)) {
				case '+':case '-':case'*':case'/':
					while (!operators.isEmpty() && operators.peek()!= '(')
						if (comparePrecedence(operators.peek(), expression.charAt(i))>=0) {
							Double temp = operands.pop();
							operands.push(doOperatror(operands.pop(), temp, operators.pop()));
						}
						else break;
					operators.push(expression.charAt(i));
					break;
				
				case '(':
					operators.push(expression.charAt(i));
					break;
				
				case ')':
					if (operators.peek() != '(') {
						Double temp = operands.pop();
						operands.push(doOperatror(operands.pop(), temp, operators.pop()));
					}
					operators.pop(); //Menyamakan pasangan dari tanda kurung
					break;
				
				case ' ': case '\t':
					break;
					
				default: //Jika index ke i adalah number atau digit
					if (Character.isDigit(expression.charAt(i))) {
						int num = getOperands(expression, i);
						Double temp = Double.valueOf(num);
						while (i<expression.length() && Character.isDigit(expression.charAt(i)))
							i++;
						i--;
						operands.push(temp);
					}
					else 
						throw new Exception("Error: Inputan tidak valid");
				}
			}
		}
    
    public void display() { 
		while (!operators.isEmpty()) {
			double temp = operands.pop();
			operands.push(doOperatror(operands.pop(), temp, operators.pop()));
		}
		System.out.println("Hasil penjumlahan: "+ operands.pop());
	}
}
