package edu.sau.algo.numbertheory.permutation;

import java.util.ArrayList;
import java.util.List;

public class DoubleCounting1 {

	private static final List<List<Integer>> FINAL = new ArrayList<>();

	public static void main(String[] args) {

		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);

		getAll2Combinations(input, new ArrayList<>());

		//System.out.println(FINAL);
	}

	/**
	 * Total no. of method invocation is equal to total no. of nodes in the tree
	 * formed. 2^0 + 2^1 + 2^2 + ---+2^n = 2^(n+1) - 1 . i.e O(2^n)
	 */
	private static void getAllCombinations(List<Integer> input, List<Integer> tempOutput) {
		if (input.isEmpty()) {
			FINAL.add(tempOutput);
			System.out.println(tempOutput);
			return;
		}

		Integer includeExcludeCandidate = input.remove(0);
		List<Integer> copyOfTempOutput = new ArrayList<>(tempOutput);

		// by including the candidate
		tempOutput.add(includeExcludeCandidate);
		getAllCombinations(new ArrayList<>(input), new ArrayList<>(tempOutput));

		// by excluding the candidate
		getAllCombinations(new ArrayList<>(input), copyOfTempOutput);
	}

	private static void getAll2Combinations(List<Integer> input, List<Integer> tempOutput) {
		if (tempOutput.size() == 2) {
			FINAL.add(tempOutput);
			System.out.println(tempOutput);
			return;
		}

		if (input.isEmpty() || (input.size() + tempOutput.size() < 2)) {
			return;
		}

		Integer includeExcludeCandidate = input.remove(0);
		List<Integer> copyOfTempOutput = new ArrayList<>(tempOutput);

		// by including the candidate
		tempOutput.add(includeExcludeCandidate);
		getAll2Combinations(new ArrayList<>(input), new ArrayList<>(tempOutput));

		// by excluding the candidate
		getAll2Combinations(new ArrayList<>(input), copyOfTempOutput);
	}

	/**
	 * Time complexity: nC0 + nC1 + nC2 + ...nCi
	 * 
	 * where n = no. of input elements and i = combination length
	 */
	private static void getAll5Combinations(List<Integer> input, List<Integer> tempOutput) {
		if (tempOutput.size() == 5) {
			FINAL.add(tempOutput);
			System.out.println(tempOutput);
			return;
		}

		if (input.isEmpty() || (input.size() + tempOutput.size() < 5)) {
			return;
		}

		Integer includeExcludeCandidate = input.remove(0);
		List<Integer> copyOfTempOutput = new ArrayList<>(tempOutput);

		// by including the candidate
		tempOutput.add(includeExcludeCandidate);
		getAll5Combinations(new ArrayList<>(input), new ArrayList<>(tempOutput));

		// by excluding the candidate
		getAll5Combinations(new ArrayList<>(input), copyOfTempOutput);
	}

}
