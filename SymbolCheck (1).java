

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * class to check if a file has correct java syntax for brackets, braces, and
 * parens
 * 
 * @author Zach M
 *
 */
public class SymbolCheck {
	/**
	 * This is a program that will take a filename from the command line. It will
	 * then extract all the brackets, braces, and parentheses from the file. It will
	 * then proceed to check the format of said characters. It does this by using
	 * the Stack java utility and two other methods I implemented in this class
	 * called createStackWithCharacters and checkFormat
	 * 
	 * @param args
	 *            will only execute with one passed argument which should be a
	 *            filename
	 * @throws FileNotFoundException
	 *             for loading the file into a scanner
	 */
	public static void main(String[] args) throws FileNotFoundException {

		switch (args.length) {// switch statement to ensure correct usage of program

		case 1: // case one is when a file name is passed
			String filename = args[0];
			File file = new File(filename);

			if (file.isFile()) {// if statement to make sure the file exists and is readable
				Stack charStack = createStackWithCharacters(args[0]);// created stack with characters inside
				System.out.println("Scanning file for all brackets, braces, and parentheses...");// communicating with
																									// user
				System.out.println("Here are the symbols found in the passed file: ");
				System.out.println(charStack.toString());
				System.out.println("Checking format of symbols...");

				if (checkFormat(charStack)) {// checks format using external method
					System.out.println("The file had correct usage of parentheses, brackets, and braces.");
				} else
					System.out.println("The file did not have correct usage of parentheses, brackets, and braces.");
			} else {// throws filenotfound
				throw new FileNotFoundException("The file was not found");
			}

			System.out.println("Program ending...");
			break;
		default: // default case to explain usage
			System.out.println("Please pass a file name as an argument");
			System.exit(0);
		}

	}

	/**
	 * A method to return a stack filled with all the characters from the passed
	 * File name
	 * 
	 * @param filename
	 *            filename to read characters from
	 * @return a stack filled with all braces, brackets, and parentheses found in
	 *         file
	 * @throws FileNotFoundException
	 */
	public static Stack createStackWithCharacters(String filename) throws FileNotFoundException {
		File file = new File(filename);

		Scanner scan = new Scanner(file);
		Stack symbolStack = new Stack();

		scan.useDelimiter("");//forces scanner to see each character
		while (scan.hasNext()) {
			String character = scan.next();
			switch (character) {//statement to push only certain characters 
			case "[":
				symbolStack.push(character);
				break;
			case "]":
				symbolStack.push(character);
				break;
			case "(":
				symbolStack.push(character);
				break;
			case ")":
				symbolStack.push(character);
				break;
			case "{":
				symbolStack.push(character);
				break;
			case "}":
				symbolStack.push(character);
				break;

			}

		}
		return symbolStack;
	}

	/**
	 * A method to go through a stack checking the format of braces, brackets, and
	 * parens
	 * 
	 * @param stack
	 *            a stack to check
	 * @return true if the format is correct and false if the format is wrong
	 */
	public static boolean checkFormat(Stack stack) {
		if (stack.size() % 2 != 0) {// if there is an odd number of elements in the stack then there is not enough
									// elements to make correct pairs, obviously false
			return false;
		}
		Stack checkStack = new Stack();
		while (!stack.isEmpty()) {
			String test = null;
			switch (test = (String) stack.pop()) {// switch statement to perform matching of end and beginning
													// braces,brackets, and parentheses
			case "[":

				if (!checkStack.pop().equals("]")) {
					return false;
				}
				break;

			case "]":
				checkStack.push(test);
				break;

			case "(":

				if (!checkStack.pop().equals(")")) {
					return false;
				}
				break;

			case ")":

				checkStack.push(test);
				break;

			case "{":

				if (!checkStack.pop().equals("}")) {
					return false;
				}
				break;

			case "}":

				checkStack.push(test);
				break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else
			return false;
	}
}
