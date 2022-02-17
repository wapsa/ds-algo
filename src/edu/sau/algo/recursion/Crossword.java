package edu.sau.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum Crossword {

	FIXING_INPUT {
		@Override
		void solve(char[][] puzzle, List<String> words) {
			solveCrosswordByFixingInput(puzzle, words.toArray(new String[0]), 0);
		}
	},
	FIND_START_AND_FIXING_INPUT {
		@Override
		void solve(char[][] puzzle, List<String> input) {
			solveCrosswordByFindingStartAndFixingInput(puzzle, input);
		}
	},
	FIXING_POS {
		@Override
		void solve(char[][] puzzle, List<String> words) {
			solveCrosswordByFixingPos(puzzle, words, 0, new HashMap<>(), new HashMap<>());
		}
	},
	FIND_START_AND_FIXING_POS {
		@Override
		void solve(char[][] puzzle, List<String> input) {
			solveCrosswordByFindingStartAndFixingPos(puzzle, input);
		}
	};

	abstract void solve(char[][] puzzle, List<String> words);

	static final char[][] PUZZLE1 = { //
			{ '+', '_', '+' }, //
			{ '_', '_', '_' }, //
			{ '+', '_', '+' }, //
	};
	static final char[][] PUZZLE2 = { //
			{ '_', '_', '_' }, //
			{ '_', '+', '+' }, //
			{ '_', '+', '+' },//
	};
	static final char[][] PUZZLE3 = { //
			{ '+', '_', '+', '+', '+', '+', '+', '+', '+' }, //
			{ '+', '_', '+', '+', '+', '+', '+', '+', '+' }, //
			{ '+', '_', '+', '+', '+', '+', '+', '+', '+' }, //
			{ '+', '_', '_', '_', '_', '_', '+', '+', '_' }, //
			{ '+', '_', '+', '+', '+', '+', '+', '+', '_' }, //
			{ '+', '_', '+', '+', '+', '+', '+', '+', '_' }, //
			{ '+', '+', '+', '+', '+', '+', '+', '+', '_' }, //
			{ '+', '+', '+', '+', '+', '+', '+', '+', '_' }, //
			{ '+', '+', '+', '+', '+', '+', '+', '+', '_' }//
	};//
	static final char[][] PUZZLE4 = { //
			{ 's', '+', '+', '_', '+', '+' }, //
			{ '_', '+', '_', '_', '_', '+' }, //
			{ '_', '_', 'o', 'h', 'o', '_' }, //
			{ '_', '+', '+', '_', '+', '+' }, //
			{ '_', '+', '+', '_', '+', '+' },//

	};//
	static final char[][] PUZZLE5 = { //
			{ '_', '_', '_' }, //
			{ '_', '_', '_' }, //
			{ '_', '_', '_' }, //
	};

	public static void main(String[] args) {
		// testFixingInput();
		// testFindStartAndFixingInput();

		// testFixingPos();
		testFindStartAndFixingPos();
	}

	private static void testFindStartAndFixingInput() {
		FIND_START_AND_FIXING_INPUT.solve(PUZZLE1, new ArrayList<>(List.of("ant", "and")));
		FIND_START_AND_FIXING_INPUT.solve(PUZZLE2, new ArrayList<>(List.of("man", "mad")));
		FIND_START_AND_FIXING_INPUT.solve(PUZZLE3, new ArrayList<>(List.of("delhi", "london", "mumbai")));
		FIND_START_AND_FIXING_INPUT.solve(PUZZLE4,
				new ArrayList<>(List.of("ashes", "snack", "aoohoe", "to", "so", "sst")));
		FIND_START_AND_FIXING_INPUT.solve(PUZZLE5, new ArrayList<>(List.of("abc", "tom", "box", "axe")));
	}

	private static void testFixingPos() {
		FIXING_POS.solve(PUZZLE1, new ArrayList<>(List.of("ant", "and")));
		FIXING_POS.solve(PUZZLE2, new ArrayList<>(List.of("man", "mad")));
		FIXING_POS.solve(PUZZLE3, new ArrayList<>(List.of("delhi", "london", "mumbai")));
		FIXING_POS.solve(PUZZLE4, new ArrayList<>(List.of("ashes", "snack", "aoohoe", "to", "so", "sst")));
		FIXING_POS.solve(PUZZLE5, new ArrayList<>(List.of("abc", "tom", "box", "axe")));
	}

	private static void testFindStartAndFixingPos() {
		FIND_START_AND_FIXING_POS.solve(PUZZLE1, new ArrayList<>(List.of("ant", "and")));
		FIND_START_AND_FIXING_POS.solve(PUZZLE2, new ArrayList<>(List.of("man", "mad")));
		FIND_START_AND_FIXING_POS.solve(PUZZLE3, new ArrayList<>(List.of("delhi", "london", "mumbai")));
		FIND_START_AND_FIXING_POS.solve(PUZZLE4,
				new ArrayList<>(List.of("ashes", "snack", "aoohoe", "to", "so", "sst")));
		FIND_START_AND_FIXING_POS.solve(PUZZLE5, new ArrayList<>(List.of("abc", "tom", "box", "axe")));
	}

	private static void testFixingInput() {
		FIXING_INPUT.solve(PUZZLE1, new ArrayList<>(List.of("ant", "and")));
		FIXING_INPUT.solve(PUZZLE2, new ArrayList<>(List.of("man", "mad")));
		FIXING_INPUT.solve(PUZZLE3, new ArrayList<>(List.of("delhi", "london", "mumbai")));
		FIXING_INPUT.solve(PUZZLE4, new ArrayList<>(List.of("ashes", "snack", "aoohoe", "to", "so", "sst")));
		FIXING_INPUT.solve(PUZZLE5, new ArrayList<>(List.of("abc", "tom", "box", "axe")));
	}

	private static void solveCrosswordByFixingInput(char[][] puzzle, String[] words, int idx) {
		if (idx == words.length) {
			for (char[] x : puzzle)
				System.out.println(Arrays.toString(x));
			System.out.println("---------------");
			return;
		}
		BitSet occupiedCharsInRow = new BitSet(puzzle[0].length);
		BitSet occupiedCharsInCol = new BitSet(puzzle.length);

		for (int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle[0].length; col++) {

				if (puzzle[row][col] != '+') {

					if (canPlaceWordHorizontally(puzzle, row, col, words[idx])) {
						placeWordHorizontally(puzzle, row, col, words[idx], occupiedCharsInRow);
						solveCrosswordByFixingInput(puzzle, words, idx + 1);
						removeHorizontallyPlacedWord(puzzle, row, col, words[idx], occupiedCharsInRow);
					}
					if (canPlaceWordVertically(puzzle, row, col, words[idx])) {
						placeWordVertically(puzzle, row, col, words[idx], occupiedCharsInCol);
						solveCrosswordByFixingInput(puzzle, words, idx + 1);
						removeVerticallyPlacedWord(puzzle, row, col, words[idx], occupiedCharsInCol);
					}
				}
			}
		}
	}

	/**
	 * Strategy: fixing position and trying all the words horizontally and
	 * vertically as options.
	 * 
	 * Why are we getting duplicate solutions ?
	 * 
	 * Because at a given posToFix, we are just not trying to place the words from
	 * the posToFix and ahead rather we are also trying to place the words on
	 * previous positions by finding the origin. And we know any combinatorics which
	 * place the element on previous_position than the posToFix may generate
	 * duplicates.
	 * 
	 * Why there is no need to clear the currentSolution, if we don't invoke the
	 * currentSolution.clear() still the solution be correct ?
	 * 
	 * Because recursion follows the euler_path, so when the control reaches the tip
	 * and backtrack and moves to second branch it just overrides the requisite
	 * words. Since we are printing only when the input.isEmpty() so there will not
	 * be any stale state.
	 * 
	 * But if we clear the currentSolution, it will have better performance as
	 * number of comparison will be reduced for duplicate_check.
	 * 
	 */
	private static void solveCrosswordByFixingPos(char[][] puzzle, List<String> words, int posToFix,
			Map<String, Set<Integer>> solutionCache, Map<String, Integer> currentSolution) {
		if (words.isEmpty() || posToFix == puzzle.length * puzzle[0].length) {
			if (words.isEmpty() && !checkForDuplicateSolutionAndStoreIfAbsent(solutionCache, currentSolution)) {
				for (char[] x : puzzle)
					System.out.println(Arrays.toString(x));
				System.out.println("---------------");
				currentSolution.clear();
			}
			return;
		}

		int row = posToFix / puzzle[0].length;
		int col = posToFix % puzzle[0].length;
		posToFix = posToFix + 1;

		if (puzzle[row][col] == '+')
			solveCrosswordByFixingPos(puzzle, words, posToFix, solutionCache, currentSolution);
		else {
			BitSet horizontallySetCharPos = new BitSet();
			BitSet verticallySetCharPos = new BitSet();

			int horizontalOrigin = getHorizontalStartingPos(puzzle, row, col);
			int verticalOrigin = getVerticalStartingPos(puzzle, row, col);

			// originPos is used to save the current solution, so that duplicate solutions
			// can be avoided to print
			int horizontalOriginPos = row * puzzle[0].length + horizontalOrigin;
			int verticalOriginPos = verticalOrigin * puzzle[0].length + col;

			boolean success = false;
			for (int i = 0; i < words.size(); i++) {
				String currentWord = words.get(i);
				if (canPlaceWordHorizontally(puzzle, row, horizontalOrigin, currentWord)) {
					success = true;

					// horizontal position is stored in cache as positive value.
					currentSolution.put(currentWord, +horizontalOriginPos);
					placeWordHorizontally(puzzle, row, horizontalOrigin, currentWord, horizontallySetCharPos);
					words.remove(currentWord);
					solveCrosswordByFixingPos(puzzle, words, posToFix, solutionCache, currentSolution);
					removeHorizontallyPlacedWord(puzzle, row, horizontalOrigin, currentWord, horizontallySetCharPos);
					words.add(i, currentWord);

				}
				if (canPlaceWordVertically(puzzle, verticalOrigin, col, currentWord)) {
					success = true;
					// vertical position is stored in cache as negative value, and -0 is stored as
					// Integer.MIN_VALUE
					currentSolution.put(currentWord, verticalOriginPos == 0 ? Integer.MIN_VALUE : -verticalOriginPos);
					placeWordVertically(puzzle, verticalOrigin, col, currentWord, verticallySetCharPos);
					words.remove(currentWord);
					solveCrosswordByFixingPos(puzzle, words, posToFix, solutionCache, currentSolution);
					removeVerticallyPlacedWord(puzzle, verticalOrigin, col, currentWord, verticallySetCharPos);
					words.add(i, currentWord);
				}
			}

			if (!success)
				solveCrosswordByFixingPos(puzzle, words, posToFix, solutionCache, currentSolution);

		}
	}

	private static int getVerticalStartingPos(char[][] puzzle, int row, int col) {
		while (row >= 0) {
			if (puzzle[row][col] == '+')
				break;
			row--;
		}
		return row + 1;
	}

	private static int getHorizontalStartingPos(char[][] puzzle, int row, int col) {
		while (col >= 0) {
			if (puzzle[row][col] == '+')
				break;
			col--;
		}
		return col + 1;
	}

	private static boolean canPlaceWordHorizontally(char[][] puzzle, int row, int col, String currentWord) {
		if (currentWord.length() > (puzzle[0].length - col))
			return false;

		// right check
		int i = 0;
		for (; i < currentWord.length(); i++)
			if (puzzle[row][col + i] == '+'
					|| (puzzle[row][col + i] != '_' && puzzle[row][col + i] != currentWord.charAt(i)))
				return false;

		// even after placing word if empty places are there it means this word is not
		// meant for this location.
		if (col + i < puzzle[0].length && puzzle[row][col + i] != '+')
			return false;

		return true;
	}

	private static void placeWordHorizontally(char[][] puzzle, int row, int col, String currentWord,
			BitSet horizontallySetCharPos) {
		for (int i = 0; i < currentWord.length(); i++, col++) {
			if (puzzle[row][col] == '_') {
				puzzle[row][col] = currentWord.charAt(i);
				horizontallySetCharPos.set(i);
			}
		}
	}

	private static void removeHorizontallyPlacedWord(char[][] puzzle, int row, int col, String currentWord,
			BitSet horizontallySetCharPos) {
		for (int i = 0; i < currentWord.length(); i++, col++)
			if (horizontallySetCharPos.get(i))
				puzzle[row][col] = '_';
		horizontallySetCharPos.clear();
	}

	private static boolean canPlaceWordVertically(char[][] puzzle, int row, int col, String currentWord) {
		if (currentWord.length() > (puzzle.length - row))
			return false;

		// downward check
		int i = 0;
		for (; i < currentWord.length(); i++)
			if (puzzle[row + i][col] == '+'
					|| (puzzle[row + i][col] != '_' && puzzle[row + i][col] != currentWord.charAt(i)))
				return false;

		// even after placing word if empty places are there it means this word is not
		// meant for this location.
		if (row + i < puzzle.length && puzzle[row + i][col] != '+')
			return false;

		return true;
	}

	private static void placeWordVertically(char[][] puzzle, int row, int col, String currentWord,
			BitSet verticallySetCharPos) {
		for (int i = 0; i < currentWord.length(); i++, row++) {
			if (puzzle[row][col] == '_') {
				puzzle[row][col] = currentWord.charAt(i);
				verticallySetCharPos.set(i);
			}
		}
	}

	private static void removeVerticallyPlacedWord(char[][] puzzle, int row, int col, String currentWord,
			BitSet verticallySetCharPos) {
		for (int i = 0; i < currentWord.length(); i++, row++)
			if (verticallySetCharPos.get(i))
				puzzle[row][col] = '_';
		verticallySetCharPos.clear();
	}

	private static boolean checkForDuplicateSolutionAndStoreIfAbsent(Map<String, Set<Integer>> solutionCache,
			Map<String, Integer> currentSolution) {
		boolean isSolutionPresent = true;
		for (Map.Entry<String, Integer> sol : currentSolution.entrySet()) {

			String word = sol.getKey();
			Integer originPos = sol.getValue();

			if (!solutionCache.containsKey(word) || !solutionCache.get(word).contains(originPos)) {
				isSolutionPresent = false;
			}
		}
		// if solution is absent then place the current solution in cache
		if (!isSolutionPresent) {
			currentSolution.forEach((word, originPos) -> {
				solutionCache.computeIfPresent(word, (k, v) -> {
					v.add(originPos);
					return v;
				});
				solutionCache.computeIfAbsent(word, k -> {
					Set<Integer> solutions = new HashSet<>();
					solutions.add(originPos);
					return solutions;

				});
			});
		}
		return isSolutionPresent;
	}

	private static void solveCrosswordByFindingStartAndFixingInput(char[][] crossWordPuzzle, List<String> input) {
		List<Integer> candidateHorizontalStartPosList = new ArrayList<>();
		List<Integer> candidateVerticalStartPosList = new ArrayList<>();

		for (int i = 0; i < crossWordPuzzle.length; i++) {
			for (int j = 0; j < crossWordPuzzle[0].length; j++) {
				if (crossWordPuzzle[i][j] != '+') {
					if (isValidHorizontalStart(crossWordPuzzle, i, j))
						candidateHorizontalStartPosList.add(i * crossWordPuzzle[0].length + j);
					if (isValidVerticalStart(crossWordPuzzle, i, j))
						candidateVerticalStartPosList.add(i * crossWordPuzzle[0].length + j);
				}
			}
		}
		solveCrossWordByFixingInput(crossWordPuzzle, input.toArray(new String[0]), 0, candidateHorizontalStartPosList,
				candidateVerticalStartPosList);
	}

	private static void solveCrossWordByFixingInput(char[][] puzzle, String[] input, int inIdx,
			List<Integer> candidateHorizontalStartPosList, List<Integer> candidateVerticalStartPosList) {

		if (inIdx == input.length) {
			for (char[] x : puzzle)
				System.out.println(Arrays.toString(x));
			System.out.println("---------------");
			return;
		}

		BitSet occupiedCharsInRow = new BitSet(puzzle[0].length);
		BitSet occupiedCharsInCol = new BitSet(puzzle.length);
		for (int i = 0; i < candidateHorizontalStartPosList.size(); i++) {
			int row = candidateHorizontalStartPosList.get(i) / puzzle[0].length;
			int col = candidateHorizontalStartPosList.get(i) % puzzle[0].length;
			if (canPlaceWordHorizontally(puzzle, row, col, input[inIdx])) {

				placeWordHorizontally(puzzle, row, col, input[inIdx], occupiedCharsInRow);
				solveCrossWordByFixingInput(puzzle, input, inIdx + 1, candidateHorizontalStartPosList,
						candidateVerticalStartPosList);
				removeHorizontallyPlacedWord(puzzle, row, col, input[inIdx], occupiedCharsInRow);
			}

		}

		for (int i = 0; i < candidateVerticalStartPosList.size(); i++) {
			int row = candidateVerticalStartPosList.get(i) / puzzle[0].length;
			int col = candidateVerticalStartPosList.get(i) % puzzle[0].length;

			if (canPlaceWordVertically(puzzle, row, col, input[inIdx])) {
				placeWordVertically(puzzle, row, col, input[inIdx], occupiedCharsInCol);
				solveCrossWordByFixingInput(puzzle, input, inIdx + 1, candidateHorizontalStartPosList,
						candidateVerticalStartPosList);
				removeVerticallyPlacedWord(puzzle, row, col, input[inIdx], occupiedCharsInCol);
			}
		}
	}

	private static boolean isValidHorizontalStart(char[][] puzzle, int row, int col) {
		// checking previous position of current col
		if (col != 0 && puzzle[row][col - 1] != '+') {
			return false;
		}
		// checking postion after the current col
		if (col + 1 == puzzle[0].length || puzzle[row][col + 1] == '+') {
			return false;
		}
		return true;
	}

	private static boolean isValidVerticalStart(char[][] puzzle, int row, int col) {
		// checking above position of current row
		if (row != 0 && puzzle[row - 1][col] != '+') {
			return false;
		}
		// checking postion below the current col
		if (row + 1 == puzzle[0].length || puzzle[row + 1][col] == '+') {
			return false;
		}
		return true;
	}

	private static void solveCrosswordByFindingStartAndFixingPos(char[][] puzzle, List<String> input) {
		List<Integer> candidateHorizontalStartPosList = new ArrayList<>();
		List<Integer> candidateVerticalStartPosList = new ArrayList<>();

		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++) {
				if (puzzle[i][j] != '+') {
					if (isValidHorizontalStart(puzzle, i, j))
						candidateHorizontalStartPosList.add(i * puzzle[0].length + j);
					if (isValidVerticalStart(puzzle, i, j))
						candidateVerticalStartPosList.add(i * puzzle[0].length + j);
				}
			}
		}
		solveCrossWordByFixingPos(puzzle, input, candidateHorizontalStartPosList, 0, candidateVerticalStartPosList, 0);
	}

	private static void solveCrossWordByFixingPos(char[][] puzzle, List<String> words,
			List<Integer> candidateHorizontalStartPosList, int horizontalPos,
			List<Integer> candidateVerticalStartPosList, int verticalPos) {

		if (horizontalPos == candidateHorizontalStartPosList.size()
				&& verticalPos == candidateVerticalStartPosList.size()) {
			for (char[] x : puzzle)
				System.out.println(Arrays.toString(x));
			System.out.println("---------------");
			return;
		}

		BitSet occupiedCharsInRow = null;
		BitSet occupiedCharsInCol = null;

		int horizontalRow = -1;
		int horizontalCol = -1;
		if (horizontalPos < candidateHorizontalStartPosList.size()) {
			occupiedCharsInRow = new BitSet(puzzle[0].length);
			horizontalRow = candidateHorizontalStartPosList.get(horizontalPos) / puzzle[0].length;
			horizontalCol = candidateHorizontalStartPosList.get(horizontalPos) % puzzle[0].length;
		}
		int verticalRow = -1;
		int verticalCol = -1;
		if (verticalPos < candidateVerticalStartPosList.size()) {
			occupiedCharsInCol = new BitSet(puzzle.length);
			verticalRow = candidateVerticalStartPosList.get(verticalPos) / puzzle[0].length;
			verticalCol = candidateVerticalStartPosList.get(verticalPos) % puzzle[0].length;
		}
		for (int i = 0; i < words.size(); i++) {
			String currentWord = words.get(i);
			if (horizontalRow != -1 && horizontalCol != -1
					&& canPlaceWordHorizontally(puzzle, horizontalRow, horizontalCol, currentWord)) {
				placeWordHorizontally(puzzle, horizontalRow, horizontalCol, currentWord, occupiedCharsInRow);
				words.remove(currentWord);
				solveCrossWordByFixingPos(puzzle, words, candidateHorizontalStartPosList, horizontalPos + 1,
						candidateVerticalStartPosList, verticalPos);
				// backtrack
				removeHorizontallyPlacedWord(puzzle, horizontalRow, horizontalCol, currentWord, occupiedCharsInRow);
				words.add(i, currentWord);
			}
			if (verticalRow != -1 && verticalCol != -1
					&& canPlaceWordVertically(puzzle, verticalRow, verticalCol, currentWord)) {
				placeWordVertically(puzzle, verticalRow, verticalCol, currentWord, occupiedCharsInCol);
				words.remove(currentWord);
				solveCrossWordByFixingPos(puzzle, words, candidateHorizontalStartPosList, horizontalPos,
						candidateVerticalStartPosList, verticalPos + 1);
				// backtrack
				removeVerticallyPlacedWord(puzzle, verticalRow, verticalCol, currentWord, occupiedCharsInCol);
				words.add(i, currentWord);
			}
		}
	}
}
