package edu.sau.ds.array;

import java.util.Arrays;

public class Array {

	public static final ArrayQuestions QUESTIONS = new ArraySolutions();

	public static void main(String[] args) {
		transposeMatrix();
	}

	private static void transposeMatrix() {
		int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		print2dArray(input);
		int[][] output = QUESTIONS.transposeMatrix(input);
		print2dArray(output);
	}

	private static void print2dArray(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.println(Arrays.toString(input[i]));
		}

	}

}
