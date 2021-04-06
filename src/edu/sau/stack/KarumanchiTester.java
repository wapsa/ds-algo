package com.saurabh.stack;

import java.util.Arrays;

public class KarumanchiTester {

	KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

	public static void main(String[] args) {

		// areSymbolsBalanced();

		// convertInfixToPostfix();

		// evaluatePostfixExpression();

		// evaluateInfixExpression();

		// infixToPrefixUsingStacks();

		// evaluatePrefixExpression();

		// reverseStackUsingRecursion();

		// findImmediateGreaterInRightBruteForce();

		// findImmediateSmallerInRightBruteForce();

		// findImmediateGreaterInRightUsingStack();

		// findImmediateGreaterInLeftBruteForce();

		// findImmediateSmallerInLeftBruteForce();

		// findImmediateGreaterInLeftUsingStack();

		// findingSpanProblemBruteForce();

		// findingSpanProblemUsingStack();

		// maxRectangleAreaInHistogramUsingBruteForce();

		findImmediateSmallerInLeftAndRightSingleLoop();

		// maxRectangleAreaInHistogramJudgeAlgo();

		// maxRectangleAreaInHistogramUsingImmediateSmallerInLeftAndRight();

		// removeAdjacentDuplicates();

	}

	private static void removeAdjacentDuplicates() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

//		System.out.println(questions.removeAdjacentDuplicates1("careermonk"));
//		System.out.println(questions.removeAdjacentDuplicates1("mississippi"));
//		System.out.println(questions.removeAdjacentDuplicates1("maissiassippi"));
//		System.out.println(questions.removeAdjacentDuplicates1("maissakkaippi"));
//
//		System.out.println(questions.removeAdjacentDuplicates2("careermonk"));
//		System.out.println(questions.removeAdjacentDuplicates2("mississippi"));
//		System.out.println(questions.removeAdjacentDuplicates2("maissiassippi"));
//		System.out.println(questions.removeAdjacentDuplicates2("maissakkaippi"));

		System.out.println(questions.removeAdjacentDuplicates3("careermonk"));
		System.out.println(questions.removeAdjacentDuplicates3("mississippi"));
		System.out.println(questions.removeAdjacentDuplicates3("maissiassippi"));
		System.out.println(questions.removeAdjacentDuplicates3("maissakkaippi"));

//		 System.out.println(questions.removeAdjacentDuplicatesUsingStack("careermonk"));
//		 System.out.println(questions.removeAdjacentDuplicatesUsingStack("mississippi"));
//		 System.out.println(questions.removeAdjacentDuplicatesUsingStack("maissiassippi"));
//		 System.out.println(questions.removeAdjacentDuplicatesUsingStack("maissakkaippi"));
	}

	private static void maxRectangleAreaInHistogramUsingImmediateSmallerInLeftAndRight() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		// int[] inputArray = new int[] { 3, 2, 5, 6, 1, 4, 4 };
		// int[] inputArray = new int[] { 1, 2, 2, 3, 3, 3, 2, 3, 1, 4, 4 };
		// int[] inputArray = new int[] { 5, 5, 4, 2, 3, 2 };
		// int[] inputArray = new int[] { 4, 3, 2, 1, 4, 3, 2 };
		int[] inputArray = new int[] { 2, 4, 3, 4, 1, 1 };

		int solution = questions.maxRectangleAreaInHistogramUsingImmediateSmallerInLeftAndRight(inputArray);

		System.out.println(solution);
	}

	private static void maxRectangleAreaInHistogramJudgeAlgo() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		// int[] inputArray = new int[] { 3, 2, 5, 5, 6, 1, 4, 4 };
		// int[] inputArray = new int[] { 1, 2, 2, 3, 3, 3, 2, 1, 4, 4, 1, 3, 2 };
		// int[] inputArray = new int[] { 5, 5, 4, 2, 3, 2 };
		// int[] inputArray = new int[] { 4, 3, 2, 1, 4, 3, 2 };
		int[] inputArray = new int[] { 2, 4, 3, 4, 1, 1 };

		int solution = questions.maxRectangleAreaInHistogramJudgeAlgo1(inputArray);

		System.out.println(solution);
	}

	private static void findImmediateSmallerInLeftAndRightSingleLoop() {

		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[][] inputArray = new int[][] { { 3, 2, 5, 6, 1, 4 }, { 1, 2, 3, 2, 1, 4, 1, 3, 2 }, { 4, 3, 2, 1, 4, 3, 2 },
				{ 2, 4, 5, 3, 1, 2 } };

		for (int i = 0; i < inputArray.length; i++) {
			int[][] solution = questions
					.findImmediateSmallerInLeftAndRightSingleLoopForNonDuplicateElements(inputArray[i]);

			System.out.println("NSL: " + Arrays.toString(solution[0]));
			System.out.println("NSR: " + Arrays.toString(solution[1]));
			System.out.println("--------------------------------------------");
		}

	}

	private static void maxRectangleAreaInHistogramUsingBruteForce() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		// int[] inputArray = new int[] { 3, 2, 5, 6, 1, 4, 4 };
		// int[] inputArray = new int[] { 4, 3, 2, 1, 4, 3, 2 };
		int[] inputArray = new int[] { 2, 4, 3, 4, 1, 1 };

		int solution = questions.maxRectangleAreaInHistogramUsingBruteForce(inputArray);

		System.out.println(solution);
	}

	private static void findingSpanProblemUsingStack() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		// [1, 1, 1, 3, 1, 6, 1, 8]
		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		// Expected: [1, 1, 2, 3, 1]
		// int[] inputArray = new int[] { 6, 3, 4, 5, 2 };

		int[] solution = questions.findingSpanProblemUsingStack(inputArray);

		System.out.println(Arrays.toString(solution));
	}

	private static void findingSpanProblemBruteForce() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		// [1, 1, 1, 3, 1, 6, 1, 8]
		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		// Expected: [1, 1, 2, 3, 1]
		// int[] inputArray = new int[] { 6, 3, 4, 5, 2 };

		int[] solution = questions.findingSpanProblemBruteForce(inputArray);

		System.out.println(Arrays.toString(solution));
	}

	private static void findImmediateGreaterInLeftUsingStack() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		int[] solution = questions.findImmediateGreaterInLeftUsingStack(inputArray);

		System.out.println(Arrays.toString(solution));

	}

	private static void findImmediateSmallerInLeftBruteForce() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		int[] solution = questions.findImmediateSmallerInLeftBruteForce(inputArray);

		System.out.println(Arrays.toString(solution));

	}

	private static void findImmediateGreaterInLeftBruteForce() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		int[] solution = questions.findImmediateGreaterInLeftBruteForce(inputArray);

		System.out.println(Arrays.toString(solution));

	}

	private static void findImmediateGreaterInRightUsingStack() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		// Expected Output: [7, 4, 4, 7, 7, 9, 9, -1]
		int[] solution = questions.findImmediateGreaterInRightUsingStack(inputArray);

		System.out.println(Arrays.toString(solution));

	}

	private static void findImmediateSmallerInRightBruteForce() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		int[] solution = questions.findImmediateSmallerInRightBruteForce(inputArray);

		System.out.println(Arrays.toString(solution));

	}

	private static void findImmediateGreaterInRightBruteForce() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		int[] inputArray = new int[] { 5, 0, 0, 4, 3, 7, 6, 9 };

		// Expected Output: [7, 4, 4, 7, 7, 9, 9, -1]
		int[] solution = questions.findImmediateGreaterInRightBruteForce(inputArray);

		System.out.println(Arrays.toString(solution));

	}

	private static void reverseStackUsingRecursion() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		Stack<Integer> stack = questions.createEmptyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println(stack);

		stack = questions.reverseStackUsingRecursion(stack);

		System.out.println("Reversed " + stack);

	}

	private static void evaluatePrefixExpression() {
		KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

		System.out.println(questions.evaluatePrefixExpression("5 * 3 - ( 2 + 2 ) + 10"));

		System.out.println(questions.evaluatePrefixExpression("15 / 5"));

		System.out.println(questions.evaluatePrefixExpression("100 * 2 - 40 / 4 * ( 9 - 3 ) - 7 * ( 0 - 9  / 3 )"));

	}

	private static void infixToPrefixUsingStacks() {
		KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

		System.out.println(questions.infixToPrefixUsingStacks("( A - B / C ) * ( A / K - L )"));
		System.out.println(questions.infixToPrefixUsingStacks("( ( A * B ) + ( C / D ) )"));
		System.out.println(questions.infixToPrefixUsingStacks("( ( A * ( B + C ) ) / D )"));
		System.out.println(questions.infixToPrefixUsingStacks("( A * ( B + ( C / D ) ) )"));

	}

	private static void evaluateInfixExpression() {
		KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

		System.out.println(questions.evaluateInfixExpression("5 * 3 - ( 2 + 2 ) + 10"));

		System.out.println(questions.evaluateInfixExpression("15 / 5"));

		System.out.println(questions.evaluateInfixExpression("100 * 2 - 40 / 4 * ( 9 - 3 ) - 7 * ( 0 - 9  / 3 )"));

	}

	private static void evaluatePostfixExpression() {
		KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

		System.out.println(questions.evaluatePostfixExpression("5 * 3 - ( 2 + 2 ) + 10"));

		System.out.println(questions.evaluatePostfixExpression("15 / 5"));

		System.out.println(questions.evaluatePostfixExpression("100 * 2 - 40 / 4 * ( 9 - 3 ) - 7 * ( 0 - 9  / 3 )"));

	}

	private static void convertInfixToPostfix() {
		KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

		System.out.println(questions.convertInfixToPostfix("A * B - ( C + D ) + E"));
		System.out.println(questions.convertInfixToPostfix("( A + B * C ) * P - Q"));
		System.out.println(questions.convertInfixToPostfix("( ( A * ( B + C ) ) / D )"));
		System.out.println(questions.convertInfixToPostfix("( A * ( B + ( C / D ) ) )"));

		System.out.println(questions.convertInfixToPostfix("- ( ( A ) * B - ( C + D * ( ( x - y ) + 3 - 2 ) ) + E )"));

	}

	private static void areSymbolsBalanced() {
		KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

		System.out.println(questions.areSymbolsBalanced("( 1 + 2 ) + { 9 - 5 } + [ 2 + 3 ]"));
	}

}
