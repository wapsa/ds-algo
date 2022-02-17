package edu.sau.algo.recursion;

import java.util.Arrays;

import edu.sau.algo.RandomGenerator;

public class SudokuProblem {

	public static void main(String[] args) {
		testSolveSudoku();
	}

	private static void testSolveSudoku() {
		int[][] noSolution = { //
				{ 2, 0, 0, 9, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 6, 0 }, //
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0 }, //
				{ 5, 0, 2, 6, 0, 0, 4, 0, 7 }, //
				{ 0, 0, 0, 0, 0, 4, 1, 0, 0 }, //
				{ 0, 0, 0, 0, 9, 8, 0, 2, 3 }, //
				{ 0, 0, 0, 0, 0, 3, 0, 8, 0 }, //
				{ 0, 0, 5, 0, 1, 0, 0, 0, 0 }, //
				{ 0, 0, 7, 0, 0, 0, 0, 0, 0 } //
		};
		solveSudoku(noSolution);

		int[][] puzzle = generateSudokuPuzzle(27);
		for (int[] x : puzzle)
			System.out.println(Arrays.toString(x));
		System.out.println("---------------");

		solveSudoku(puzzle);
	}

	public static void solveSudoku(int[][] puzzle) {
		solveSudoku(puzzle, 0);
	}

	private static void solveSudoku(int[][] puzzle, int posToFix) {
		if (posToFix == 9 * 9) {
			for (int[] x : puzzle)
				System.out.println(Arrays.toString(x));
			System.out.println("---------------");
			return;
		}

		int row = posToFix / 9; // sudoku puzzle is always 9 x 9, so puzzle[0].length = 9;
		int col = posToFix % 9;

		posToFix = posToFix + 1;

		if (puzzle[row][col] != 0) {
			// do nothing, move on to next posToFix
			solveSudoku(puzzle, posToFix);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isValidPlacement(puzzle, row, col, i)) {
					puzzle[row][col] = i;
					solveSudoku(puzzle, posToFix);
					puzzle[row][col] = 0;
				}
			}
		}
	}

	/**
	 * <pre>
	 * 			0	1	2		3	4	5		6	7	8
	 *							
	 *	0		0	1	2		3	4	5		6	7	8
	 *	1		9	10	11		12	13	14		15	16	17
	 *	2		18	19	20		21	22	23		24	25	26
	 *				
	 *	3		27	28	29		30	31	32		33	34	35	
	 *	4		36	37	38		39	40	41		42	43	44	
	 *	5		45	46	47		48	49	50		51	52	53
	 *				
	 *	6		54	55	56		57	58	59		60	61	62
	 *	7		63	64	65		66	67	68		69	70	71
	 *	8		72	73	74		75	76	77		78	79	80
	 * 
	 * </pre>
	 */
	private static boolean isValidPlacement(int[][] puzzle, int row, int col, int i) {
		// checking entire row
		for (int c = 0; c < 9; c++)
			if (puzzle[row][c] == i)
				return false;

		// checking entire column
		for (int r = 0; r < 9; r++)
			if (puzzle[r][col] == i)
				return false;

		// checking 3x3 sudoku block relative to puzzle[row][col] location.
		int blockStartingRowIdx = (row / 3) * 3;
		int blockStartingColIdx = (col / 3) * 3;

		for (int r = blockStartingRowIdx; r < blockStartingRowIdx + 3; r++)
			for (int c = blockStartingColIdx; c < blockStartingColIdx + 3; c++)
				if (puzzle[r][c] == i)
					return false;

		return true;
	}

	public static int[][] generateSudokuPuzzle(int countOfMissingElements) {
		int[][] puzzle = new int[9][9];
		// First we will fill the diagonal blocks randomly. diagonal blocks starting
		// points are [0,0], [3,3], [6,6]
		for (int i = 0; i <= 6; i += 3)
			fillSudokuDiagonalBlocksWithRandomNumbers(puzzle, i, i);

		// Getting solution of sudoku.
		getSudokuSolution(puzzle, 0);

		// Setting countOfMissingElements random positions to 0.
		Arrays.stream(RandomGenerator.getDistinctRandomNumbersInRange(0, 9 * 9, countOfMissingElements))
				.forEach(i -> puzzle[i / 9][i % 9] = 0);

		return puzzle;
	}

	private static void fillSudokuDiagonalBlocksWithRandomNumbers(int[][] puzzle, int r, int c) {
		int[] numbers = RandomGenerator.getDistinctRandomNumbersInRange(1, 10, 9);
		int idx = 0;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				puzzle[i][j] = numbers[idx++];
			}
		}
	}

	private static boolean getSudokuSolution(int[][] puzzle, int posToFix) {
		if (posToFix == 9 * 9) {
			return true;
		}

		int row = posToFix / 9; // sudoku puzzle is always 9 x 9, so puzzle[0].length = 9;
		int col = posToFix % 9;

		posToFix = posToFix + 1;

		if (puzzle[row][col] != 0) {
			// do nothing, move on to next posToFix
			return getSudokuSolution(puzzle, posToFix);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isValidPlacement(puzzle, row, col, i)) {
					puzzle[row][col] = i;
					boolean solutionFound = getSudokuSolution(puzzle, posToFix);
					if (solutionFound) {
						return solutionFound;
					} else {
						puzzle[row][col] = 0;
					}
				}
			}
		}
		return false;
	}
}
