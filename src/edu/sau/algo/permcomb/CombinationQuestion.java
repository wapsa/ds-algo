package edu.sau.algo.permcomb;

import java.util.List;

public interface CombinationQuestion {

	public static final CombinationSolution INSTANCE = new CombinationSolution();

	/**
	 * Get all possible combinations that can be formed by picking one character
	 * from each group.
	 * 
	 * e.g. Input: ["abc", "def"], Then possible combinations will include ad, ae,
	 * af, bd, be, bf, cd, ce, cf
	 */
	void printGroupCombination(String[] groups);

}
