package ds.stack.regular;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println( "( Use single white space after each input )" + "\n Enter an expression: ");

		String userInput = scanner.nextLine();
		    evaluateAndPrint(userInput);
		}
		
	
	
	public static void evaluateAndPrint(String s) {
	    // split uses regular exp to split parts of the string
		// \\s represents white space
		String[] str = s.split("\\s+");
	    Queue<String> queue = new LinkedList<>();
	    
	    queue.addAll(Arrays.asList(str));
	    
	    Stack<String> operators  = new Stack<>();
	    Stack<Double> values = new Stack<>();
	    
	    while (!queue.isEmpty()) { 
	        String token = queue.poll();
	        switch (token) {
	            case "(":
	           // ignoring "(" 	
	                break;
	            case "+":
	            case "-":
	            case "*":
	            case "/":
	            case "sqrt":
	            	operators .push(token);
	                break;
	            case ")":
	            	values.push(evaluate(operators , values));
	                break;
	            default:
	            
	            	values.push(Double.parseDouble(token));
	                break;
	        }
	    }
	    System.out.println("Result of the expression is: " + evaluate(operators , values));
	}

	private static Double evaluate(Stack<String> operators , Stack<Double> values) {
	    
	    double v = values.pop();
	    
	    if (!operators.isEmpty()) {
	        String op = operators.pop();
	        switch (op) {
	            case "+":
	                v = values.pop() + v;
	                break;
	            case "-":
	                v = values.pop() - v;
	                break;
	            case "*":
	                v = values.pop() * v;
	                break;
	            case "/":
	                v = values.pop() / v;
	                break;
	            case "sqrt":
	                v = Math.sqrt(v);
	                break;
	            default:
	                break;
	        }
	    }
	    // v represents the end value ( result ) of the expression
	    return v;
	}
	
	
	
}

