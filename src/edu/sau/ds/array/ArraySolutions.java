package edu.sau.ds.array;

public class ArraySolutions implements ArrayQuestions {

	@Override
	public int[][] transposeMatrix(int[][] input) {
		int[][] output = new int[input[0].length][input.length];
		for (int i = 0; i < input.length; i++)
			for (int j = 0; j < input[0].length; j++)
				output[j][i] = input[i][j];
		return output;
	}

}
