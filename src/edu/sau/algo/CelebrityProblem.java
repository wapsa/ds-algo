package edu.sau.algo;

/**
 * Problem Statement: Among n people {0, 1, 2, . . . , n − 1}, a celebrity is
 * defined as someone who is known to everyone, but who knows no one. The
 * celebrity problem is to identify the celebrity, if one exists, by asking only
 * questions of the following form: “Excuse me, do you know person X?”
 * 
 * How do you represent the relations?
 * 
 * There are 􀝊 people and each of them can have relation with the remaining n −
 * 1 persons. Hence, the simple data structure to represent this information is
 * a two-dimensional matrix. The entry M[i][j] of M[0. . n − 1][0. . 􀝊 − 1] is
 * 1 when person i knows person j and 0 otherwise. We assume that M[i][i] = 1
 * for every i.
 */
public class CelebrityProblem {

	/**
	 * Time complexity is n(n-1). Why n-1?? Because we are ignoring the diagonal
	 * element as we don't need to check if the celebrity knows her/him self or not.
	 * 
	 * Time Complexity: O(n^2)
	 * 
	 * Space Complexity: O(1)
	 */
	static void celebrityProblem(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			boolean eliminated = false;
			innerLoop: for (int j = 0; j < matrix.length; j++) {

				// skip the diagonal elements.
				if (i == j) {
					continue;
				}

				// eliminate if column has any 0(meaning not everyone knows the celebrity) or
				// row has any 1 ( meaning the celebrity knows some one)
				if (matrix[j][i] == 0 || matrix[i][j] == 1) {
					eliminated = true;
					break innerLoop;
				}
			}
			if (!eliminated) {
				System.out.println(i + " is a celebrity.");
			}
		}

	}

	/**
	 * The elimination phase requires exactly n − 1 checks, since each check reduces
	 * the size of the list by 1. In the verification phase, we perform n − 1 checks
	 * for the person n, and also check remaining n − 1 persons once.
	 * 
	 * This phase requires at the most 2(n − 1) checks, possibly fewer if n is not a
	 * celebrity. So the total number of checks is 3(n − 1).
	 * 
	 * Time Complexity: O(n).
	 * 
	 * Space Complexity: O(1).
	 * 
	 * we show how to do this with at the most 3(􀝊 - 1) checks. This algorithm
	 * consists of two phases:
	 * 
	 * 1) Elimination
	 * 
	 * 2) Verification
	 * 
	 * In the elimination phase, we eliminate all but one person from being the
	 * celebrity; in the verification phase we check whether this remaining person
	 * is indeed a celebrity. The elimination phase maintains a list of possible
	 * celebrities. Initially, it contains all n people. In each iteration, we
	 * delete one person from the list. We exploit the following key observation:
	 * 
	 * If person 1 knows person 2, then person 1 is not a celebrity; if person 1
	 * does not know person 2, then person 2 is not a celebrity.
	 * 
	 * 
	 */
	static void optimizedCelebrityProblem(int[][] matrix) {

		int celebCandidate = findCelebrityCandidateByElimination(matrix);

		boolean eliminated = false;
		for (int i = 0; i < matrix.length; i++) {
			if (i == celebCandidate) {
				continue;
			}
			if (matrix[celebCandidate][i] == 1 || matrix[i][celebCandidate] == 0) {
				eliminated = true;
			}
		}

		if (!eliminated) {
			System.out.println(celebCandidate + " is a celebrity.");
		}
	}

	private static int findCelebrityCandidateByElimination(int[][] matrix) {
		int u = 0;
		int v = 1;

		for (int i = 2; i < matrix.length; i++) {
			if (matrix[u][v] == 1) {
				u = i;
			} else {
				v = i;
			}
		}
		return u == matrix.length ? v : u;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 1, 0, 1, 1, 0 },
				{ 1, 0, 1, 0, 1 } };

		optimizedCelebrityProblem(matrix);
	}

}
