package edu.sau.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class KarumanchiSolutions<T extends Comparable<T>> implements KarumanchiQuestions<T> {

	public static final Pattern UNICODE_MULTI_SPACE = Pattern.compile("(?U)\s+", Pattern.UNICODE_CHARACTER_CLASS);

	// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
	// http://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html
	public enum Operator {

		MULTIPLICATION("*", OperatorType.BINARY, 12) {
			@Override
			public double evaluate(double... operand) {
				return operand[0] * operand[1];
			}
		},

		DIVISION("/", OperatorType.BINARY, 12) {
			@Override
			public double evaluate(double... operand) {
				return operand[1] / operand[0];
			}
		},

		MODULUS("%", OperatorType.BINARY, 12) {
			@Override
			public double evaluate(double... operand) {
				return operand[1] % operand[0];
			}
		},

		ADDITION("+", OperatorType.BINARY, 11) {
			@Override
			public double evaluate(double... operand) {
				return operand[1] + operand[0];
			}
		},

		SUBTRACTION("-", OperatorType.BINARY, 11) {
			@Override
			public double evaluate(double... operand) {
				return operand[1] - operand[0];
			}
		},

		;

		private final String operator;
		private final OperatorType type;
		private final int precedence; // higher value = higher precedence

		private static final Map<String, Operator> OPERATOR_SYMBOLS = new HashMap<>();

		static {
			for (Operator symbol : values()) {
				OPERATOR_SYMBOLS.put(symbol.getOperator(), symbol);
			}
		}

		private Operator(String operator, OperatorType type, int precedence) {
			this.operator = operator;
			this.type = type;
			this.precedence = precedence;
		}

		public static boolean isOperatorSymbol(String operatorSymbol) {
			return OPERATOR_SYMBOLS.keySet().contains(operatorSymbol);
		}

		public static Operator fromOperatorString(String operatorSymbol) {
			return OPERATOR_SYMBOLS.get(operatorSymbol);
		}

		public String getOperator() {
			return operator;
		}

		public OperatorType getType() {
			return type;
		}

		public int getPrecedence() {
			return precedence;
		}

		public abstract double evaluate(double... operand);

	}

	private static enum OperatorType {

		UNARY, BINARY, TERNARY;
	}

	public enum Parenthesis {

		CURLY_BRACKET("{", "}"),

		SQUARE_BRACKET("[", "]"),

		ROUND_BRACKET("(", ")"),

		ANGULAR_BRACKET("<", ">"),

		;

		private final String openingSymbol;
		private final String closingSymbol;

		private static final Set<String> OPENING_SYMBOLS_SET = new HashSet<>();
		private static final Set<String> CLOSING_SYMBOLS_SET = new HashSet<>();
		private static final Set<String> SYMBOLS_SET = populateSymbols();

		private static final Map<String, Parenthesis> FROM_SYMBOLS = new HashMap<>();
		private static final Map<String, Parenthesis> FROM_CLOSING_SYMBOLS = new HashMap<>();
		private static final Map<String, Parenthesis> FROM_OPENING_SYMBOLS = new HashMap<>();

		static {
			for (Parenthesis symbol : values()) {
				FROM_OPENING_SYMBOLS.put(symbol.getOpeningSymbol(), symbol);
				FROM_CLOSING_SYMBOLS.put(symbol.getClosingSymbol(), symbol);
				FROM_SYMBOLS.put(symbol.getOpeningSymbol(), symbol);
				FROM_SYMBOLS.put(symbol.getClosingSymbol(), symbol);
			}

		}

		static Set<String> populateSymbols() {
			Set<String> temp = new HashSet<>();
			for (Parenthesis sym : values()) {
				temp.add(sym.getOpeningSymbol());
				OPENING_SYMBOLS_SET.add(sym.getOpeningSymbol());
				temp.add(sym.getClosingSymbol());
				CLOSING_SYMBOLS_SET.add(sym.getClosingSymbol());
			}
			return temp;
		}

		private Parenthesis(String openingSymbol, String closingSymbol) {
			this.openingSymbol = openingSymbol;
			this.closingSymbol = closingSymbol;
		}

		public static boolean isParenthesisSymbol(String symbol) {
			return SYMBOLS_SET.contains(symbol);
		}

		public static boolean isOpeningSymbol(String symbol) {
			return OPENING_SYMBOLS_SET.contains(symbol);
		}

		public static boolean isClosingSymbol(String symbol) {
			return CLOSING_SYMBOLS_SET.contains(symbol);
		}

		public String getOpeningSymbol() {
			return openingSymbol;
		}

		public String getClosingSymbol() {
			return closingSymbol;
		}

		public static Parenthesis fromSymbol(String symbol) {
			Parenthesis parenthesis = FROM_OPENING_SYMBOLS.get(symbol);
			if (parenthesis == null) {
				throw new IllegalArgumentException("symbol is not a valid parenthesis Symbol.");
			}
			return parenthesis;
		}

		public static Parenthesis fromClosingSymbol(String closingSymbol) {
			Parenthesis symbol = FROM_CLOSING_SYMBOLS.get(closingSymbol);
			if (symbol == null) {
				throw new IllegalArgumentException("symbol is not a valid Closing Symbol.");
			}
			return symbol;
		}

		public static Parenthesis fromOpeningSymbol(String openingSymbol) {
			Parenthesis symbol = FROM_OPENING_SYMBOLS.get(openingSymbol);
			if (symbol == null) {
				throw new IllegalArgumentException("symbol is not a valid Opening Symbol.");
			}
			return symbol;
		}

	}

	/**
	 * * Algorithm: a) Create a stack.
	 * 
	 * b) while (end of input is not reached) {
	 * 
	 * 1) If the character read is not a symbol to be balanced, ignore it.
	 * 
	 * 2) If the character is an opening symbol like (, [, {, push it onto the stack
	 * 
	 * 3) If it is a closing symbol like ),],}, then if the stack is empty report an
	 * error. Otherwise pop the stack.
	 * 
	 * 4) If the symbol popped is not the corresponding opening symbol, report an
	 * error. }
	 * 
	 * c) At end of input, if the stack is not empty report an error
	 */
	@Override
	public boolean areSymbolsBalanced(String expression) {
		Stack<String> stack = createEmptyStack();
		String[] expressionArray = UNICODE_MULTI_SPACE.split(expression);

		for (int i = 0, n = expressionArray.length; i < n; i++) {
			String chara = String.valueOf(expressionArray[i]);

			if (Parenthesis.isOpeningSymbol(chara)) {
				stack.push(chara);

			} else if (Parenthesis.isClosingSymbol(chara)) {

				if (stack.isEmpty() || !Parenthesis.fromOpeningSymbol(stack.pop()).getClosingSymbol().equals(chara)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String convertInfixToPostfix(String infixExpression) {
		Stack<String> stack = createEmptyStack();
		String[] expressionArray = UNICODE_MULTI_SPACE.split(infixExpression);

		StringBuilder postfixExpression = new StringBuilder();

		for (int i = 0, n = expressionArray.length; i < n; i++) {
			String token = String.valueOf(expressionArray[i]);

			if (Parenthesis.isParenthesisSymbol(token)) {

				if (Parenthesis.isOpeningSymbol(token)) {
					stack.push(token);

				} else {
					Parenthesis parenthesis = Parenthesis.fromClosingSymbol(token);

					while (!stack.isEmpty()) {
						String poppedValue = stack.pop();
						if (poppedValue.equals(parenthesis.getOpeningSymbol())) {
							break;
						}
						postfixExpression.append(poppedValue);
						postfixExpression.append(" ");
					}
				}

			} else if (Operator.isOperatorSymbol(token)) {
				Operator symbol = Operator.fromOperatorString(token);

				while (!stack.isEmpty()) {

					// until lower precedence operator arrives in the stack.
					if (!Operator.isOperatorSymbol(stack.peek())
							|| Operator.fromOperatorString(stack.peek()).getPrecedence() < symbol.getPrecedence()) {
						break;
					}
					postfixExpression.append(stack.pop());
					postfixExpression.append(" ");
				}
				stack.push(token);

			} else {
				// directly appending operands to output string.
				postfixExpression.append(token);
				postfixExpression.append(" ");
			}
		}
		while (!stack.isEmpty()) {
			postfixExpression.append(stack.pop());
			postfixExpression.append(" ");
		}
		return postfixExpression.toString().trim();
	}

	@Override
	public double evaluatePostfixExpression(String infixExpression) {

		String postfixExpression = convertInfixToPostfix(infixExpression);

		System.out.println("Postfix Operation: " + postfixExpression);

		Stack<Double> stack = createEmptyStack();
		String[] expressionArray = UNICODE_MULTI_SPACE.split(postfixExpression);

		for (int i = 0, n = expressionArray.length; i < n; i++) {
			String token = String.valueOf(expressionArray[i]);

			if (Operator.isOperatorSymbol(token)) {
				Operator operator = Operator.fromOperatorString(token);

				stack.push(evalForPostfix(stack, operator));

			} else {
				// directly appending operands to output string.
				stack.push(Double.valueOf(token));
			}
		}
		return stack.pop();
	}

	@Override
	public double evaluateInfixExpression(String infixExpression) {

		Stack<String> operatorStack = createEmptyStack();
		Stack<Double> operandStack = createEmptyStack();

		String[] expressionArray = UNICODE_MULTI_SPACE.split(infixExpression);

		for (int i = 0, n = expressionArray.length; i < n; i++) {
			String token = String.valueOf(expressionArray[i]);

			if (Parenthesis.isOpeningSymbol(token)) {
				operatorStack.push(token);

			} else if (Parenthesis.isClosingSymbol(token)) {
				Parenthesis parenthesis = Parenthesis.fromClosingSymbol(token);

				while (!operatorStack.isEmpty()) {
					String poppedValue = operatorStack.pop();
					if (poppedValue.equals(parenthesis.getOpeningSymbol())) {
						break;
					}
					Operator operator = Operator.fromOperatorString(poppedValue);
					operandStack.push(evalForPostfix(operandStack, operator));
				}

			} else if (Operator.isOperatorSymbol(token)) {
				Operator operator = Operator.fromOperatorString(token);

				while (!operatorStack.isEmpty()) {
					// until lower precedence operator arrives in the stack.
					if (!Operator.isOperatorSymbol(operatorStack.peek()) || Operator
							.fromOperatorString(operatorStack.peek()).getPrecedence() < operator.getPrecedence()) {
						break;
					}
					Operator higherPrecedenceOperator = Operator.fromOperatorString(operatorStack.pop());
					operandStack.push(evalForPostfix(operandStack, higherPrecedenceOperator));
				}
				operatorStack.push(token);

			} else {
				operandStack.push(Double.valueOf(token));

			}
		}

		while (!operatorStack.isEmpty()) {
			Operator operator = Operator.fromOperatorString(operatorStack.pop());
			operandStack.push(evalForPostfix(operandStack, operator));
		}
		return operandStack.pop();

	}

	private double evalForPostfix(Stack<Double> operandStack, Operator operator) {
		return switch (operator.getType()) {
		case UNARY -> {
			yield operator.evaluate(operandStack.pop());
		}
		case BINARY -> {
			yield operator.evaluate(operandStack.pop(), operandStack.pop());
		}
		case TERNARY -> {
			yield operator.evaluate(operandStack.pop(), operandStack.pop(), operandStack.pop());
		}
		};
	}

	@Override
	public String infixToPrefixUsingPostfix(String infixExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String infixToPrefixUsingStacks(String infixExpression) {
		Stack<String> operatorStack = createEmptyStack();
		Stack<String> operandStack = createEmptyStack();

		String[] expressionArray = UNICODE_MULTI_SPACE.split(infixExpression);

		for (int i = 0, n = expressionArray.length; i < n; i++) {
			String token = String.valueOf(expressionArray[i]);

			if (Parenthesis.isParenthesisSymbol(token)) {

				if (Parenthesis.isOpeningSymbol(token)) {
					operatorStack.push(token);

				} else {
					Parenthesis parenthesis = Parenthesis.fromClosingSymbol(token);

					while (!operatorStack.isEmpty()) {
						String poppedValue = operatorStack.pop();
						if (poppedValue.equals(parenthesis.getOpeningSymbol())) {
							break;
						}
						operandStack.push(preparePrefixPart(operandStack, Operator.fromOperatorString(poppedValue)));
					}
				}

			} else if (Operator.isOperatorSymbol(token)) {
				Operator symbol = Operator.fromOperatorString(token);

				while (!operatorStack.isEmpty()) {

					// until lower precedence operator arrives in the stack.
					if (!Operator.isOperatorSymbol(operatorStack.peek()) || Operator
							.fromOperatorString(operatorStack.peek()).getPrecedence() < symbol.getPrecedence()) {
						break;
					}
					operandStack
							.push(preparePrefixPart(operandStack, Operator.fromOperatorString(operatorStack.pop())));
				}
				operatorStack.push(token);

			} else {
				operandStack.push(token);
			}
		}
		while (!operatorStack.isEmpty()) {
			Operator operator = Operator.fromOperatorString(operatorStack.pop());
			operandStack.push(preparePrefixPart(operandStack, operator));
		}
		return operandStack.pop();
	}

	private String preparePrefixPart(Stack<String> operandStack, Operator operator) {
		return switch (operator.getType()) {
		case UNARY -> {
			yield operator.getOperator() + " " + operandStack.pop();
		}
		case BINARY -> {
			String operand2 = operandStack.pop();
			String operand1 = operandStack.pop();
			yield operator.getOperator() + " " + operand1 + " " + operand2;
		}
		case TERNARY -> {
			String operand3 = operandStack.pop();
			String operand2 = operandStack.pop();
			String operand1 = operandStack.pop();
			yield operator.getOperator() + " " + operand1 + " " + operand2 + " " + operand3;
		}
		};
	}

	@Override
	public double evaluatePrefixExpression(String infixExpression) {

		String postfixExpression = infixToPrefixUsingStacks(infixExpression);

		System.out.println("prefix Operation: " + postfixExpression);

		Stack<Double> stack = createEmptyStack();
		String[] expressionArray = UNICODE_MULTI_SPACE.split(postfixExpression);

		for (int i = expressionArray.length - 1, n = 0; i >= n; i--) {
			String token = String.valueOf(expressionArray[i]);

			if (Operator.isOperatorSymbol(token)) {
				Operator operator = Operator.fromOperatorString(token);

				stack.push(evalForPrefix(stack, operator));

			} else {
				// directly appending operands to output string.
				stack.push(Double.valueOf(token));
			}
		}
		return stack.pop();
	}

	private double evalForPrefix(Stack<Double> operandStack, Operator operator) {
		return switch (operator.getType()) {
		case UNARY -> {
			yield operator.evaluate(operandStack.pop());
		}
		case BINARY -> {
			Double operand2 = operandStack.pop();
			Double operand1 = operandStack.pop();
			yield operator.evaluate(operand1, operand2);
		}
		case TERNARY -> {
			Double operand3 = operandStack.pop();
			Double operand2 = operandStack.pop();
			Double operand1 = operandStack.pop();
			yield operator.evaluate(operand1, operand2, operand3);
		}
		};
	}

	@Override
	public String convertPostfixToInfix(String postfixExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convertPostfixToPrefix(String postfixExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIfStringIsPalindromeUsingStack() {
		// TODO Auto-generated method stub
		return false;
	}

//	STACK: push(A),		push(B),	push(C)
//
//
//	 reverse 1: 
//		data = pop(D)
//		addToBottom 1
//
//	 reverse 2: 
//		data = pop(C)
//		addToBottom 2
//
//	 reverse 3: 
//		data = pop(B)
//		addToBottom 1
//
//		 addToBottom 1: input = A from reverse 3
//								stack is empty so push(A)
//								return to reverse 3
//		
//		 addToBottom 2: input = B from reverse 2
//								temp = pop(A)
//									addToBottom 2.1: input = B from addToBottom 2
//									stack is empty so push(B)
//									return to addToBottom 2
//								push temp(A)
//								return to reverse 2
//		
//		 addToBottom 3: input = C from reverse 1
//								temp = pop(A)
//									addToBottom 3.1: input = C from addToBottom 3
//									temp = pop(B)
//										addToBottom 3.1.1: input = C from addToBottom 3.1
//										stack is empty so push(C)
//										return to addToBottom 3.1
//									push temp(B)
//									return to addToBottom 3
//								push temp(A)
//								return to reverse 1
	@Override
	public Stack<T> reverseStackUsingRecursion(Stack<T> stack) {
		recursiveReverse(stack);
		return stack;
	}

// recursiveReverse(a b c d) 			Pop element and keep aside. 'd'
// recursiveReverse(a b c) 				Pop element and keep aside. 'c'
// recursiveReverse(a b) 				Pop element and keep aside. 'b'
// recursiveReverse(a) 					Pop element and keep aside. 'a'
// insertAtBottom(empty, a) 			Stack becomes a
// insertAtBottom(a, b)					Stack becomes b a
// insertAtBottom(b a, c)				Stack becomes c b a
// insertAtBottom(c b a, d)				Stack becomes d c b a
	private void recursiveReverse(Stack<T> stack) {

		// base case
		if (stack.isEmpty()) {
			return;
		}

		T data = stack.pop();
		recursiveReverse(stack);
		insertAtBottom(stack, data);
	}

	private void insertAtBottom(Stack<T> stack, T data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}

		T temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}

	// O(n^2)
	@Override
	public int[] findImmediateGreaterInRightBruteForce(int[] inputArray) {

		int[] solutionArray = new int[inputArray.length];
		Arrays.fill(solutionArray, -1);

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] > inputArray[i]) {
					solutionArray[i] = inputArray[j];
					break;
				}
			}
		}
		return solutionArray;
	}

	@Override
	public int[] findImmediateSmallerInRightBruteForce(int[] inputArray) {

		int[] solutionArray = new int[inputArray.length];
		Arrays.fill(solutionArray, -1);

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] < inputArray[i]) {
					solutionArray[i] = inputArray[j];
					break;
				}
			}
		}
		return solutionArray;
	}

	@Override
	public int[] findImmediateGreaterInRightUsingStack(int[] inputArray) {
		Stack<Integer> stack = createEmptyStack();

		int[] solutionArray = new int[inputArray.length];

		for (int i = inputArray.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && stack.peek().intValue() <= inputArray[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				solutionArray[i] = -1;
			} else {
				solutionArray[i] = stack.peek();
			}
			stack.push(inputArray[i]);
		}
		return solutionArray;
	}

	@Override
	public int[] findImmediateGreaterInLeftBruteForce(int[] inputArray) {

		int[] solutionArray = new int[inputArray.length];
		Arrays.fill(solutionArray, -1);

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (inputArray[j] > inputArray[i]) {
					solutionArray[i] = inputArray[j];
					break;
				}
			}
		}
		return solutionArray;
	}

	@Override
	public int[] findImmediateSmallerInLeftBruteForce(int[] inputArray) {

		int[] solutionArray = new int[inputArray.length];
		Arrays.fill(solutionArray, -1);

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (inputArray[j] < inputArray[i]) {
					solutionArray[i] = inputArray[j];
					break;
				}
			}
		}
		return solutionArray;
	}

	@Override
	public int[] findImmediateGreaterInLeftUsingStack(int[] inputArray) {
		Stack<Integer> stack = createEmptyStack();

		int[] solutionArray = new int[inputArray.length];

		for (int i = 0; i <= inputArray.length - 1; i++) {

			while (!stack.isEmpty() && stack.peek().intValue() <= inputArray[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				solutionArray[i] = -1;
			} else {
				solutionArray[i] = stack.peek();
			}
			stack.push(inputArray[i]);
		}
		return solutionArray;
	}

	private int[] findImmediateSmallerIndexInRight(int[] inputArray) {
		Stack<Integer> stack = createEmptyStack();

		int[] solutionArray = new int[inputArray.length];

		for (int i = inputArray.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && inputArray[stack.peek().intValue()] >= inputArray[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				solutionArray[i] = inputArray.length;
			} else {
				solutionArray[i] = stack.peek();
			}
			stack.push(i);
		}
		return solutionArray;
	}

	private int[] findImmediateSmallerIndexInLeft(int[] inputArray) {
		Stack<Integer> stack = createEmptyStack();

		int[] solutionArray = new int[inputArray.length];

		for (int i = 0; i <= inputArray.length - 1; i++) {

			while (!stack.isEmpty() && inputArray[stack.peek().intValue()] >= inputArray[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				solutionArray[i] = -1;
			} else {
				solutionArray[i] = stack.peek();
			}
			stack.push(i);
		}
		return solutionArray;
	}

	@Override
	public int[][] findImmediateSmallerInLeftAndRightSingleLoopForNonDuplicateElements(int[] input) {

		System.out.println("NSL -->" + Arrays.toString(findImmediateSmallerIndexInLeft(input)));

		System.out.println("NSR -->" + Arrays.toString(findImmediateSmallerIndexInRight(input)));

		Stack<Integer> stack = createEmptyStack();

		// smaller left at 0 and smaller right at 1
		int[][] immediateSmallerInLeftAndRight = new int[2][input.length];

		for (int i = 0; i < input.length; i++) {
			while (!stack.isEmpty() && input[stack.peek().intValue()] > input[i]) {
				int poppedIndex = stack.pop();
				immediateSmallerInLeftAndRight[0][poppedIndex] = stack.isEmpty() ? -1 : stack.peek();
				immediateSmallerInLeftAndRight[1][poppedIndex] = i;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int poppedIndex = stack.pop();
			immediateSmallerInLeftAndRight[0][poppedIndex] = stack.isEmpty() ? -1 : stack.peek();
			immediateSmallerInLeftAndRight[1][poppedIndex] = input.length;
		}

		return immediateSmallerInLeftAndRight;
	}

	@Override
	public int[] findingSpanProblemBruteForce(int[] inputArray) {

		int[] solutionArray = new int[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			int spanCounter = 1;

			// Keep checking previous elements than inputArray[i] until greater one is
			// found.
			while (spanCounter <= i && inputArray[i] > inputArray[i - spanCounter]) {
				spanCounter++;
			}
			solutionArray[i] = spanCounter;
		}
		return solutionArray;
	}

	// 5, 0, 0, 4, 3, 7, 6, 9
	@Override
	public int[] findingSpanProblemUsingStack(int[] inputArray) {
		Stack<Integer> stack = createEmptyStack();

		int[] solutionArray = new int[inputArray.length];

		for (int i = 0; i <= inputArray.length - 1; i++) {

			while (!stack.isEmpty() && inputArray[stack.peek().intValue()] <= inputArray[i]) {
				stack.pop();
			}
			int peekIndex = stack.isEmpty() ? -1 : stack.peek().intValue();
			solutionArray[i] = i - peekIndex;

			stack.push(i);
		}
		return solutionArray;
	}

	@Override
	public int maxRectangleAreaInHistogramUsingBruteForce(int[] hist) {
		int maxArea = 0;
		for (int i = 0; i < hist.length; i++) {
			// Need to reinitialize minHeight for each bar as its own height.
			int minHeight = hist[i];

			for (int j = i; j >= 0; j--) {
				minHeight = Math.min(minHeight, hist[j]);
				maxArea = Math.max(maxArea, ((i - j + 1) * minHeight));
			}
		}
		return maxArea;

	}

	/**
	 * 1) Create a stack to store indexes of array.<br>
	 * 
	 * 2) for each element in histogram array <br>
	 * 
	 * 2.1) If stack is empty or current value is greater than or equal to element
	 * at stack.top index, then push current index to stack. <br>
	 * 
	 * else <br>
	 * 
	 * 2.2) Pop the stack until either the stack becomes empty or element for top of
	 * stack index is greater than current element. <br>
	 * 2.2.1) For each popped element calculate the area considering the popped
	 * element as the minimum bar. <br>
	 * 
	 * maxAreaForCurrentBar = height[popIndex] * (smallerRight - smallerLeft - 1);
	 * maxArea = Math.max(maxArea, maxAreaForCurrentBar); <br>
	 * 
	 * 2.2.2 After finishing above steps push the current index into the stack.
	 * 
	 * 3) Now, for remaining indexes in the stack, perform step no 2.2 until stack
	 * becomes empty.
	 */
	@Override
	public int maxRectangleAreaInHistogramJudgeAlgo(int[] hist) {
		Stack<Integer> stack = createEmptyStack();
		int maxArea = 0;
		int i = 0;

		for (; i < hist.length; i++) {
			if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && hist[stack.peek()] > hist[i]) {
					int currentBar = stack.pop();
					int smallerBarAtRight = i;
					int smallerBarAtLeft = stack.isEmpty() ? -1 : stack.peek();
					int maxAreaForCurrentBar = hist[currentBar] * (smallerBarAtRight - smallerBarAtLeft - 1);
					maxArea = Math.max(maxArea, maxAreaForCurrentBar);
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			int currentBar = stack.pop();
			int smallerBarAtRight = i;
			int smallerBarAtLeft = stack.isEmpty() ? -1 : stack.peek();
			int maxAreaForCurrentBar = hist[currentBar] * (smallerBarAtRight - smallerBarAtLeft - 1);
			maxArea = Math.max(maxArea, maxAreaForCurrentBar);
		}

		return maxArea;
	}

	@Override
	public int maxRectangleAreaInHistogramJudgeAlgo1(int[] hist) {
		Stack<Integer> stack = createEmptyStack();
		int maxArea = 0;
		int i = 0;

		for (; i < hist.length; i++) {
			if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i);
			} else {
				int currentBar = stack.pop();
				int smallerBarAtRight = i;
				int smallerBarAtLeft = stack.isEmpty() ? -1 : stack.peek();
				int maxAreaForCurrentBar = hist[currentBar] * (smallerBarAtRight - smallerBarAtLeft - 1);
				maxArea = Math.max(maxArea, maxAreaForCurrentBar);
				i--;
			}
		}

		while (!stack.isEmpty()) {
			int currentBar = stack.pop();
			int smallerBarAtRight = i;
			int smallerBarAtLeft = stack.isEmpty() ? -1 : stack.peek();
			int maxAreaForCurrentBar = hist[currentBar] * (smallerBarAtRight - smallerBarAtLeft - 1);
			maxArea = Math.max(maxArea, maxAreaForCurrentBar);
		}

		return maxArea;
	}

	@Override
	public int maxRectangleAreaInHistogramUsingImmediateSmallerInLeftAndRight(int[] histogramArray) {

		// nearest smaller left
		int[] nsl = findImmediateSmallerIndexInLeft(histogramArray);
		// nearest smaller right
		int[] nsr = findImmediateSmallerIndexInRight(histogramArray);

		int maxArea = 0;

		for (int i = 0; i < histogramArray.length; i++) {
			maxArea = Math.max(maxArea, histogramArray[i] * (nsr[i] - nsl[i] - 1));
		}

		return maxArea;
	}

	// Logic: compare i and i-1
	@Override
	public String removeAdjacentDuplicates1(String inputString) {
		int i = 1;
		while (i < inputString.length()) {
			if (inputString.charAt(i) == inputString.charAt(i - 1)) {
				inputString = inputString.substring(0, i - 1) + inputString.substring(i + 1);
				i--;
			} else {
				i++;
			}
		}

		return inputString;
	}

	@Override
	public String removeAdjacentDuplicates2(String input) {
		final char DUMMY_CHAR = '\0';
		char[] chars = input.toCharArray();
		int consecutiveDuplicateCount = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - consecutiveDuplicateCount]) {
				chars[i] = DUMMY_CHAR;
				chars[i - consecutiveDuplicateCount] = DUMMY_CHAR;
				consecutiveDuplicateCount += 2;
				continue;
			}
			consecutiveDuplicateCount = 1;
		}
		return String.valueOf(chars).replace(String.valueOf(DUMMY_CHAR), "");
	}

	// mississippi

	@Override
	public String removeAdjacentDuplicates3(String input) {
		char[] chars = input.toCharArray();
		int stackPointer = -1;
		int i = 0;
		int len = chars.length;

		while (i < len) {

			// if inplace stack is not empty and peek is == current character, then skip the
			// current character.
			if (stackPointer != -1 && chars[stackPointer] == chars[i]) {
				while (i < len && chars[stackPointer] == chars[i]) {
					i++;
				}
				stackPointer--;
			}
			// push onto the inplace stack.
			else {
				stackPointer++;
				chars[stackPointer] = chars[i];
				i++;
			}

		}
		return String.valueOf(chars, 0, stackPointer + 1);
	}

	@Override
	public String removeAdjacentDuplicatesUsingStack(String input) {
		Stack<String> stack = createEmptyStack();
		String[] inputStringArray = input.split("");

		for (int i = 0, n = inputStringArray.length; i < n; i++) {
			String chara = String.valueOf(inputStringArray[i]);
			if (!stack.isEmpty() && stack.peek().equals(chara)) {
				stack.pop();
			} else {
				stack.push(chara);
			}
		}

		StringBuilder solution = new StringBuilder();
		while (!stack.isEmpty()) {
			solution.insert(0, stack.pop());
		}
		return solution.toString();
	}

	/**
	 * Refer Karumanchi Algo book : Page 507 : 6.53 Maximum size sub-matrix with
	 * all1's
	 *
	 * Let's go through the calculations for row:
	 *
	 * If given matrix is 1X1 : total sub-grid=1
	 *
	 * If given matrix is 2X1 : total sub-grids= 2*(1X1) + 1(1X2)) = 3
	 *
	 * If given matrix is 3X1 : total sub-grids= 3*(1X1) + 2(1X2)) + 1(1X3)= 6
	 *
	 * Similarly, for mX1, we have m + (m-1) + (m-2) + ...+2+1 = m(m+1)/2 sub-grids
	 *
	 * Let's follow the same calculations for columns: <br>
	 * If given matrix in 1X1 :total sub-grid=1 <br>
	 * If given matrix is 1X2 : total sub-grids= 2*(1X1) + 1(2X1)) = 3 <br>
	 * Similarly, for 1Xn, we have n + (n-1) + (n-2) + ...+2+1 = n(n+1)/2 sub-grids
	 * <br>
	 *
	 * So for mXn matrix we will have total sub-grids = [m(m+1)/2]*[n(n+1)/2] =
	 * m(m+1)*n(n+1)/4
	 *
	 *
	 * How to proceed with counting: Let's say we have 4X1 matrix(i.e. column
	 * vector), start at index 0 as first-grid-> A1; 2nd-grid-> A1,B1; 3rd-grid->
	 * A1,B1,C1; 4th-grid-> A1,B1,C1,D1; 5th-grid-> B1; 6th-gird->B1,C1;
	 * 7th-grid->B1,C1,D1; 8th-grid->C1; 9th-grid->C1,D1; 10th-grid->D1<br>
	 * Now let's say two new columns are introduced.: we do the above row-wise
	 * activity for the two new columns,<br>
	 * 2nd column first-grid-> A2; 2nd-grid-> A2,B2; 3rd-grid-> A2,B2,C2; 4th-grid->
	 * A2,B2,C2,D2; 5th-grid-> B2; 6th-gird->B2,C2; 7th-grid->B2,C2,D2;
	 * 8th-grid->C2; 9th-grid->C2,D2; 10th-grid->D2 <br>
	 * 3rd column first-grid-> A3; 2nd-grid-> A3,B3; 3rd-grid-> A3,B3,C3; 4th-grid->
	 * A3,B3,C3,D3; 5th-grid-> B3; 6th-gird->B3,C3; 7th-grid->B3,C3,D3;
	 * 8th-grid->C3; 9th-grid->C3,D3; 10th-grid->D3<br>
	 *
	 * Now Grid formation using columns: 1s-grid ->col1; 2nd-Grid -> col1,col2;
	 * 3rd-Grid ->col1,col2,col3 ; 4th-Grid-> col2; 5th-Grid->col2,col3;
	 * 6th-Grid->col3;
	 *
	 * Since already we have considered columns as individually, so now we need to
	 * consider the 2-columns and 3-columns at a time for grid formation:<br>
	 * e.g. of 2 grids at a time: 2nd-Grid -> col1,col2;<br>
	 *
	 * first-grid-> A1A2; 2nd-grid-> A1A2,B1B2; 3rd-grid-> A1A2,B1B2,C1C2;
	 * 4th-grid-> A1A2,B1B2,C1C2,D1D2; 5th-grid-> B1B2; 6th-gird->B1B2,C1C2;
	 * 7th-grid->B1B2,C1C2,D1D2; 8th-grid->C1C2; 9th-grid->C1C2,D1D2;
	 * 10th-grid->D1D2 <br>
	 *
	 */
	@Override
	public void printAllPossibleSubGridBlocksInMatrix(String[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		System.out.println("No. of sub grid blocks possible are: " + (n * (n + 1) * m * (m + 1)) / 4);
		System.out.println();

		int counter = 1;
		for (int mFrom = 0; mFrom < m; mFrom++) {
			for (int mTo = mFrom; mTo < m; mTo++) {

				for (int nFrom = 0; nFrom < n; nFrom++) {
					for (int nTo = nFrom; nTo < n; nTo++) {
						System.out.print("Block " + counter + ": ");

						for (int temp1 = mFrom; temp1 <= mTo; temp1++) {
							System.out.println();
							System.out.print("[");
							for (int temp2 = nFrom; temp2 <= nTo; temp2++) {
								System.out.print(matrix[temp1][temp2] + ", ");
							}
							System.out.print("]");
						}
						counter++;
						System.out.println("\n----------");
					}
				}
			}
		}
	}

	@Override
	public int findMaxAreaInBinaryMatrixBruteForce(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		int maxArea = 0;

		for (int mFrom = 0; mFrom < m; mFrom++) {
			for (int mTo = mFrom; mTo < m; mTo++) {

				for (int nFrom = 0; nFrom < n; nFrom++) {
					for (int nTo = nFrom; nTo < n; nTo++) {

						if (isValid(matrix, nFrom, nTo, mFrom, mTo)) {
							int subGridArea = (nTo - nFrom + 1) * (mTo - mFrom + 1);
							maxArea = Math.max(maxArea, subGridArea);
						}
					}
				}
			}
		}
		return maxArea;
	}

	private boolean isValid(int[][] matrix, int nFrom, int nTo, int mFrom, int mTo) {
		for (int i = mFrom; i <= mTo; i++) {
			for (int j = nFrom; j <= nTo; j++) {
				if (matrix[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * To change back to original matrix two approaches are as follows:
	 * 
	 * 1) Wherever in matrix you have number greater than 1, replace it with 1.
	 * 
	 * 2) Loop from last row to first row and subtract upper row number from current
	 * row number.
	 */
	@Override
	public int findMaxAreaInBinaryMatrixUsingMAH(int[][] binaryMatrix) {
		int m = binaryMatrix.length;
		int n = binaryMatrix[0].length;

		// First row heights will remain same so initializing maxArea for first row.
		int maxArea = maxRectangleAreaInHistogramJudgeAlgo1(binaryMatrix[0]);

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (binaryMatrix[i][j] != 0) {
					binaryMatrix[i][j] = binaryMatrix[i][j] + binaryMatrix[i - 1][j];
				}
			}
			maxArea = Math.max(maxArea, maxRectangleAreaInHistogramJudgeAlgo1(binaryMatrix[i]));
		}
		return maxArea;
	}

	@Override
	public int findTotalRainWaterTrappableInHistogram(int[] hist) {

		int maxToLeft[] = new int[hist.length];
		int maxToRight[] = new int[hist.length];
		for (int i = 0, j = hist.length - 1; i < hist.length; i++, j--) {
			maxToLeft[i] = i == 0 ? hist[i] : Math.max(hist[i], maxToLeft[i - 1]);
			maxToRight[j] = j == hist.length - 1 ? hist[j] : Math.max(hist[j], maxToRight[j + 1]);
		}

		int totalWater = 0;
		for (int i = 0; i < hist.length; i++) {
			totalWater = totalWater + Math.min(maxToLeft[i], maxToRight[i]) - hist[i];
		}
		return totalWater;
	}

	/**
	 * 1. Loop through the indices of bars array.
	 * 
	 * 2. For each bar, we can do the following:
	 * 
	 * - While the Stack is not empty and current bar has a height greater than the
	 * top bar of stack,
	 * 
	 * - Store the index of top bar in pop_height and pop it from the Stack.
	 * 
	 * - Find the distance between left bar(current top) of the popped bar and
	 * current bar.
	 * 
	 * - Find the minimum height between the top bar and current bar.
	 * 
	 * - The maximum water that can be trapped is distance * min_height.
	 * 
	 * - The water trapped including the popped bar is (distance * min_height) –
	 * height[pop_height].
	 * 
	 * - Add that to the answer.
	 */
	@Override
	public int findTotalRainWaterTrappableInHistogramUsingJudgeAlgo(int[] hist) {

		Stack<Integer> stack = createEmptyStack();
		int totalWater = 0;

		for (int i = 0; i < hist.length; i++) {

			while (!stack.isEmpty() && hist[stack.peek()] <= hist[i]) {

				int poppedBarHeight = hist[stack.pop()];

				// If the stack does not have any bars or the the popped bar has no left
				// boundary
				if (stack.isEmpty())
					break;

				int width = i - stack.peek() - 1;

				int minHeight = Math.min(hist[i], hist[stack.peek()]) - poppedBarHeight;

				totalWater = totalWater + width * minHeight;
			}

			stack.push(i);
		}

		return totalWater;
	}

}
