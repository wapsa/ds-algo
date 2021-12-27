package edu.sau.algo.recursion;

import java.util.Arrays;

public class RecursionSolutionLevel2 implements RecursionQuestionL2 {

	public static void main(String[] args) {
		// INSTANCE.printAbbreviations1("abc");
		INSTANCE.printAbbreviations2("abc");
	}

	@Override
	public void printAbbreviations1(String input) {
		char[] output = new char[input.length()];
		Arrays.fill(output, '_');
		printAbbreviationsUsingPascalIdentityExpansion1(input.toCharArray(), 0, output);
	}

	private void printAbbreviationsUsingPascalIdentityExpansion1(char[] input, int posToFix, char[] output) {
		String print = "";
		int emptyCounter = 0;
		for (char ch : output) {
			if (ch == '_') {
				emptyCounter++;
			} else {
				print = emptyCounter == 0 ? print + ch : print + emptyCounter + ch;
				emptyCounter = 0;
			}
		}
		print = emptyCounter == 0 ? print : print + emptyCounter;
		System.out.println(print);

		while (posToFix < input.length) {
			int currentPos = posToFix;
			output[currentPos] = input[currentPos];
			posToFix = posToFix + 1;
			printAbbreviationsUsingPascalIdentityExpansion1(input, posToFix, output);
			output[currentPos] = '_';
		}
	}

	@Override
	public void printAbbreviations2(String input) {
		printAbbreviationsUsingPascalIdentityExpansion2(input.toCharArray(), 0, "");
	}

	private void printAbbreviationsUsingPascalIdentityExpansion2(char[] input, int posToFix, String output) {
		System.out.println((input.length - posToFix) == 0 ? output : output + (input.length - posToFix));
		
		int currentPosToFix = posToFix;
		while (posToFix < input.length) {

			String newOutput = output;
			if (posToFix - currentPosToFix != 0)
				newOutput = newOutput + (posToFix - currentPosToFix);
			newOutput = newOutput + input[posToFix];

			posToFix = posToFix + 1;
			printAbbreviationsUsingPascalIdentityExpansion2(input, posToFix, newOutput);
		}
	}

}
