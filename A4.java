import java.util.*; 

/**
 * @author Qurrat-al-Ain Siddiqui
 * @instructor Laura Marik
 * @date November 4, 2018
 * 
 * COMP 2503-001 Assignment 4: Expression Tree
 * 
 * 
 *  A4 is a processor class that blah blah blah...
 *
 */
public class A4 {

	/**
	 * @param args
	 * 
	 * Main method that instantiates A4 object & calls upon run(); 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A4 a4 = new A4();
		a4.run();
	}

	
	/*
	 * Reads userinput of a postfix expression and validates the expression. User interface.
	 */
	
	public void run() {
		Scanner input = new Scanner (System.in);
		String postfixExp;
		
		
		System.out.println("Enter the equation in POSTFIX form: ");
		postfixExp = input.nextLine();
		postfixExp.toLowerCase();
		
		if(validateString(postfixExp)) {
			ExpressionTree tree = new ExpressionTree(postfixExp);
			System.out.println(tree.getInfixExp());
			System.out.println(tree.translateToPostfix("(0&1)"));
		}
		else {
			System.out.println("ERROR: Invalid postfix expression entered.");
		}
	}
	
	private boolean validateString(String userInput) {
		int counter = 0;
		boolean validString = false;
		boolean belowZero = false;
		char currentChar;
		userInput.replaceAll("\\s", ""); //this gets rid of any whitespace!
		
		for (int i=0; i < userInput.length(); i++) {
			currentChar = userInput.charAt(i);
			if (Character.isLetter(currentChar) || currentChar == '0' || currentChar == '1') {
				counter++;
			}
			else if(currentChar == '!') {
				counter--;
				if(counter < 0) {
					belowZero = true;
				}
				counter++;
			}
			else if(currentChar == '&' || currentChar == '!' || currentChar == '^') {
				counter -= 2;
				if (counter < 0) {
					belowZero = true;
				}
				counter++;
			}
			else { //if anything else
				validString = false;
			}
		} //end of if statement 
		if (counter == 1 && !belowZero) {
			validString = true;
		}
		return(validString);
	} //end of the method. 
} //end of class.