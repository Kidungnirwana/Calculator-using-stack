package calculator.data;

import java.util.Scanner;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "5+5+5-5*2/2";
		int i = 7;
		
		System.out.println(a.charAt(0));
		System.out.println(testing(a, i));
		
	}
	static int testing (String abc, int i) {
		Scanner inpuScanner = new Scanner(abc.substring(i));
		inpuScanner.useDelimiter("[^0-9]");
		return inpuScanner.nextInt();
	}

}
