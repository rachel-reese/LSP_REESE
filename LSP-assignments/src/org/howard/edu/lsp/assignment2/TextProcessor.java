package org.howard.edu.lsp.assignment2;
import java.util.Scanner;
/**
 * This class takes a string input by the user and divides it into tokens.
 * prints the tokens back to the user along with the sum and product of the tokens
 * @author Rachel
 *
 */
public class TextProcessor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		
		while (keepGoing){
			
			int lastSpaceIndex = -1;
			int token = 0;
			int sum = 0;
			int product = 1;
			
			System.out.println("String?");
			String tokenString = scanner.nextLine();
			if (tokenString.equals("Goodbye")) {
				break;
			}
			System.out.println("Tokens:");
			
			for (int i = 0; i < tokenString.length(); i++) {
				if(tokenString.charAt(i) == ' ') {
					String newToken = tokenString.substring((lastSpaceIndex + 1), i);
					lastSpaceIndex = i;
					token = Integer.parseInt(newToken);
					System.out.println(token);
					sum += token;
					product *= token;
					
				}
				else if (i == (tokenString.length() - 1)) {
					String newToken = tokenString.substring((lastSpaceIndex + 1), tokenString.length());
					token = Integer.parseInt(newToken);
					System.out.println(newToken);
					sum += token;
					product *= token;
				}
			}
			System.out.println("Sum: "+ sum);
			System.out.println("Product: " + product);
			
		}
		scanner.close();
	}

}
