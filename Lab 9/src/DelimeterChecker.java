/*
 *
 *
 *CS 2003 Lab 9
 *@author Kasey Mills
 *@since 10/24/2017
 *
 * */



import java.util.Scanner;
import java.util.Stack;

public class DelimeterChecker {


	public boolean check(String inputS) {
		String input;
		Stack<Character> stack1 = new Stack<Character>();
		input = inputS;
		
		
		for (int i = 0; i < input.length(); i++) {
			char firstC = input.charAt(i);
			
			//Opening delims
			if ((firstC == '(') || (firstC == '{') || (firstC == '[')) {
				stack1.push(firstC);
			}
			
			//Closing delims
			if (firstC == ')' || firstC == '}' || firstC == ']') {
				if (stack1.isEmpty()) {
					return false;
				} 
				else {	
					//Checking for opposite delim
					switch (firstC) {
					case ')':
						if (stack1.peek() == '(') {
							stack1.pop();
							continue;
						} else {
							System.out.println("Error: Mismatch delimeter ')'");
							return false;
						}
					case '}':
						if (stack1.peek() == '{') {
							stack1.pop();
							continue;
						} else {
							System.out.println("Error: Mismatch delimeter '}'");
							return false;
						}
					case ']':
						if (stack1.peek() == '[') {
							stack1.pop();
							continue;
						} else {
							System.out.println("Error: Mismatch delimeter ']'");
							return false;
						}

					}
				}

			}
		}
		if (!stack1.isEmpty() ) {
			return false;
		} else
			return true;
	}


	public static void main(String[] args) {
		DelimeterChecker delimCheck = new DelimeterChecker();
		Scanner scan = new Scanner(System.in);
		System.out.println("Test string: ");
		System.out.print("> ");
		String input = scan.next();

		if (delimCheck.check(input))
			System.out.println("Correct: Matching delims");
		else
			System.out.println("Incorrect: Check delims");
		

	}

}