package edu.sau.ds.stack;

public interface KarumanchiQuestions<T extends Comparable<T>> {

	public final static String USE_STACK = "array";

	public default <P extends Comparable<P>> Stack<P> createEmptyStack() {
		if (USE_STACK.equals("array")) {
			return new ArrayBackedStack<P>();
		} else {
			return new LinkedListStack<P>();
		}
	}

	/**
	 * Q1 - Discuss how stacks can be used for checking balancing of symbols.
	 *
	 * Solution: Stacks can be used to check whether the given expression has
	 * balanced symbols. This algorithm is very useful in compilers. Each time the
	 * parser reads one character at a time. If the character is an opening
	 * delimiter such as (, {, or [- then it is written to the stack. When a closing
	 * delimiter is encountered like ), }, or ]-the stack is popped. The opening and
	 * closing delimiters are then compared. If they match, the parsing of the
	 * string continues. If they do not match, the parser indicates that there is an
	 * error on the line.
	 */
	boolean areSymbolsBalanced(String expression);

	/**
	 * Q2 - infix to postfix conversion algorithm using stack.
	 * 
	 * Notes:
	 * 
	 * Let us consider the infix expression 2 + 3*4 and its postfix equivalent
	 * 234*+. Notice that between infix and postfix the order of the numbers (or
	 * operands) is unchanged. It is 2 3 4 in both cases. But the order of the
	 * operators * and + is affected in the two expressions.
	 * 
	 * Only one stack is enough to convert an infix expression to postfix
	 * expression. The stack that we use in the algorithm will be used to change the
	 * order of operators from infix to postfix. The stack we use will only contain
	 * operators and the open parentheses symbol ‘(‘.
	 * 
	 * Algorithm:
	 * 
	 * a) Create a stack
	 * 
	 * b) for each character 't' in the input string <br>
	 * 
	 * ... b1) if 't' is an opening parenthesis <br>
	 * ............ push onto the stack <br>
	 * 
	 * ... b2) else if 't' is closing parenthesis<br>
	 * ............ pop and append the popped operands until opening parenthesis is
	 * ............ popped. Don't append parenthesis. <br>
	 * 
	 * ... b3) else if 't' is an operator <br>
	 * ............ pop and append operators until one of lower precedence than 't'
	 * ............ is encountered or the stack is empty. Push 't' onto the stack.
	 * 
	 * ... b4) else (-----if input is clean, only operands will come to else) <br>
	 * ............ append the operands to the output string.
	 * 
	 * c) pop and append operands until the stack is empty.
	 * 
	 */
	String convertInfixToPostfix(String infixExpression);

	/**
	 * Q3 - Evaluate postfix expression.
	 * 
	 * Algorithm:
	 * 
	 * 1 Scan the Postfix string from left to right. <br>
	 * 
	 * 2 Initialize an empty stack.<br>
	 * 
	 * 3 Repeat steps 4 and 5 till all the characters are scanned.<br>
	 * 
	 * 4 If the scanned character is an operand, push it onto the stack.<br>
	 * 
	 * 5 If the scanned character is an operator, and if the operator is a unary
	 * operator, then pop an element from the stack. If the operator is a binary
	 * operator, then pop two elements from the stack. After popping the elements,
	 * apply the operator to those popped elements. Let the result of this operation
	 * be retVal onto the stack.<br>
	 * 
	 * 6 After all characters are scanned, we will have only one element in the
	 * stack.<br>
	 * 
	 * 7 Return top of the stack as result.<br>
	 * 
	 */
	double evaluatePostfixExpression(String infixExpression);

	/**
	 * Q4 - Evaluate the infix expression with stacks in one pass.
	 * 
	 * Algorithm: Dijkstra's Shunting Yard Algorithm
	 * 
	 * a) for each character 't' in the input string <br>
	 * 
	 * b) If character is operand push on the operand stack, if character is opening
	 * bracket, push on the operator stack. <br>
	 * 
	 * c) Else if character is operator <br>
	 * 
	 * c1) While the top of the operator stack is not of smaller precedence than
	 * this character.<br>
	 * c2) Pop operator from operator stack. <br>
	 * c3) Pop two operands (op1 and op2) from operand stack. <br>
	 * c4) Store op1 <operation> op2 on the operand stack back to c1. <br>
	 * 
	 * d) Else if character is ), do the same as c2 - c4 till you encounter (.
	 * 
	 * e) Else (no more character left to read):
	 * 
	 * e1) Pop operators until operator stack is not empty. <br>
	 * e2) Pop top 2 operands and push op1 <operation> op2 on the operand stack.
	 * <br>
	 * 
	 * f) return the top value from operand stack.
	 */
	double evaluateInfixExpression(String infixExpression);

	/**
	 * Q - infix to prefix using postfix.
	 * 
	 * Algorithm:
	 * 
	 * 1) Reverse the infix expression string. For parenthesis replace opening with
	 * closing and vice versa.
	 * 
	 * 2) Now convert the reversed string to postfix expression.
	 * 
	 * 3) Reverse the postfix expression to get prefix expression.
	 */
	String infixToPrefixUsingPostfix(String infixExpression);

	/**
	 * Algorithm:
	 * 
	 * a) Create a operator stack and an operand stack.
	 * 
	 * b) for each character 't' in the input string <br>
	 * 
	 * ... b1) if 't' is an opening parenthesis <br>
	 * ............ push onto the operator stack <br>
	 * 
	 * ... b2) else if 't' is closing parenthesis<br>
	 * ............ pop operator from operator stack and corresponding number of
	 * ............ operands from operand stack and push (operator+operands) to
	 * ............ operand stack until opening parenthesis is popped. Don't push
	 * ............ parenthesis. <br>
	 * 
	 * ... b3) else if 't' is an operator <br>
	 * ............ pop from operator stack and corresponding number of operands
	 * ............ from operand stack and push (operator+operands) to operand stack
	 * ............ until one of lower precedence than 't' is encountered or the
	 * ............ stack is empty. Push 't' onto the operator stack.
	 * 
	 * ... b4) else (-----if input is clean, only operands will come to else) <br>
	 * ............ push the operand to the operand stack.
	 * 
	 * c) pop from operator stack and corresponding number of operands from operand
	 * stack and push (operator+operands) to operand stack.
	 * 
	 * d) pop operand stack to get result.
	 */
	String infixToPrefixUsingStacks(String infixExpression);

	/**
	 * Algorithm:
	 * 
	 * 1) Scan the input string from the end.
	 * 
	 * 2) steps will remain same as postfix expression evaluation.
	 */
	double evaluatePrefixExpression(String infixExpression);

	/**
	 * Algorithm: Only one stack (operand stack) is required for postfix to infix
	 *
	 * Step 1: for each token in postfix string
	 *
	 * if token is operand push to operand stack <br>
	 *
	 * else if token is operator, form the string corresponding to the operator
	 * inside the braces()
	 *
	 * pop the result from operand stack
	 */
	String convertPostfixToInfix(String postfixExpression);

	/**
	 * Algorithm: Only one stack (operand stack) is required for postfix to prefix
	 *
	 * Step 1: for each token in postfix string
	 *
	 * if token is operand push to operand stack <br>
	 *
	 * else if token is operator, form the prefix string corresponding to the
	 * operator
	 *
	 * pop the result from operand stack
	 */
	String convertPostfixToPrefix(String postfixExpression);

	/**
	 * Q8 - Q10 - Check if string is a palindrome using stack.
	 * 
	 * Algorithm:<br>
	 * 
	 * 1) Traverse the string and push characters in stack till the middle element.
	 * 
	 * 2) During the traversal push all the elements (until X) on to the stack.
	 * 
	 * 3) For the second half of the string, compare each element’s content with top
	 * of the stack. If they are the same then pop the stack and go to the next
	 * element in the input list.
	 * 
	 * 4) If they are not the same then the given string is not a palindrome.
	 * 
	 * 5) Continue this process until the stack is empty or the string is not a
	 * palindrome.
	 * 
	 */
	boolean checkIfStringIsPalindromeUsingStack();

	/**
	 * Q11 - Given a stack, how to reverse the elements of the stack using only
	 * stack operations (push & pop)?
	 */
	Stack<T> reverseStackUsingRecursion(Stack<T> stack);

	/**
	 * Q13 - Implement one stack efficiently using two queues.
	 */
	Stack<T> implementStackUsingTwoQueues();

	/**
	 * Finding Spans Prerequisite
	 */
	int[] findImmediateGreaterInRightBruteForce(int[] inputArray);

	/**
	 * Finding Spans Prerequisite
	 */
	int[] findImmediateSmallerInRightBruteForce(int[] inputArray);

	/**
	 * Finding Spans Prerequisite
	 * 
	 * - Why do we need to scan input from the end? <br>
	 * Ans: Take for example: 5 0 0 4 3 7 6 9, lets see for '4', we need to search
	 * the immediate greater next in [3 7 6 9]. Now for stack based search '3'
	 * should be in top of the stack, then '7' and so on so we can find the
	 * immediate greater element. So elements must be pushed in order [9 6 7 3].
	 * That is why we scan the input from the end.
	 */
	int[] findImmediateGreaterInRightUsingStack(int[] inputArray);

	/**
	 * Finding Spans Prerequisite
	 */
	int[] findImmediateGreaterInLeftBruteForce(int[] inputArray);

	/**
	 * Finding Spans Prerequisite
	 */
	int[] findImmediateSmallerInLeftBruteForce(int[] inputArray);

	/**
	 * Finding Spans Prerequisite
	 */
	int[] findImmediateGreaterInLeftUsingStack(int[] inputArray);

	/**
	 * Q 22 - Finding Spans: Given an array A, the span S[i] of A[i] is the maximum
	 * number of consecutive elements A[j] immediately preceding A[i] and such that
	 * A[j] < A[i]?
	 * 
	 * Other way of asking: Given an array A of integers, find the maximum of j – i
	 * subjected to the constraint of A[i] < A[j].
	 * 
	 * This is a very common problem in stock markets to find the peaks. Spans are
	 * used in financial analysis (E.g., stock at 52-week high). The span of a stock
	 * price on a certain day, i, is the maximum number of consecutive days (up to
	 * the current day) the price of the stock has been less than or equal to its
	 * price on i.
	 * 
	 * As an example, let us consider the table and the corresponding spans diagram.
	 * In the figure the arrows indicate the length of the spans. Now, let us
	 * concentrate on the algorithm for finding the spans. One simple way is, each
	 * day, check how many contiguous days have a stock price that is less than the
	 * current price.
	 */
	int[] findingSpanProblemBruteForce(int[] inputArray);

	/**
	 * Q 23 - Finding Spans Using Stack
	 */
	int[] findingSpanProblemUsingStack(int[] inputArray);

	/**
	 * This works for non duplicate elements *** (effectively consecutive
	 * duplicates)
	 * 
	 * If between two same elements, there exists no smaller element then they can
	 * be called effectively consecutive elements because in stack they will appear
	 * one after the other at some point in the calculations.
	 * 
	 * [2,4,5,2] -> will not work as stack progression will be: [2] > [2,4] >
	 * [2,4,5] > [2,4] > [2,2] > effectively consecutive '2'
	 * 
	 * [2, 4, 5, 3, 2] -> will not work as stack progression will be: [2] > [2,4] >
	 * [2,4,5] > [2,4] > [2,3] > [2,2] > effectively consecutive '2'
	 * 
	 * [2, 4, 5, 3, 1, 2] -> will work as stack progression will be: [2] > [2,4] >
	 * [2,4,5] > [2,4] > [2] > [2,3] > [2] > [] > [1] > [1, 2]
	 * 
	 */
	int[][] findImmediateSmallerInLeftAndRightSingleLoopForNonDuplicateElements(int[] inputArray);

	/**
	 * Q 24 - Largest histogram problem
	 */
	int maxRectangleAreaInHistogramUsingBruteForce(int[] histogramArray);

	/**
	 * Q 24 - Largest histogram problem
	 */
	int maxRectangleAreaInHistogramJudgeAlgo(int[] histogramArray);

	/**
	 * Q 24 - Largest histogram problem
	 */
	int maxRectangleAreaInHistogramJudgeAlgo1(int[] histogramArray);

	/**
	 * Q 24 - Largest histogram problem
	 */
	int maxRectangleAreaInHistogramUsingImmediateSmallerInLeftAndRight(int[] histogramArray);

	/**
	 * Q26 - Recursively remove all adjacent duplicates: Given a string of
	 * characters, recursively remove adjacent duplicate characters from string. The
	 * output string should not have any adjacent duplicates.
	 * 
	 * Input: careermonk Output: camonk <br>
	 * Input: mississippi Output: m
	 */
	String removeAdjacentDuplicates1(String input);

	/**
	 * Q26
	 */
	String removeAdjacentDuplicates2(String input);

	/**
	 * Q26
	 */
	String removeAdjacentDuplicates3(String input);

	/**
	 * Q26
	 */
	String removeAdjacentDuplicatesUsingStack(String input);

	/**
	 * 
	 * */
	void printAllPossibleSubGridBlocksInMatrix(String[][] matrix);

	int findMaxAreaInBinaryMatrixBruteForce(int[][] binaryMatrix);

	int findMaxAreaInBinaryMatrixUsingMAH(int[][] binaryMatrix);

	int findTotalRainWaterTrappableInHistogram(int[] hist);

	int findTotalRainWaterTrappableInHistogramUsingJudgeAlgo(int[] hist);

	int findTotalRainWaterTrappableInHistogramUsingNGRAndNGL(int[] hist);

	int findTotalRainWaterTrappableInHistogram1(int[] hist);

	Long findMinStackElementUsingExtraSpace(Stack<Long> stack);

	Long findMinStackElementUsingO1Space(Stack<Long> stack);

}
