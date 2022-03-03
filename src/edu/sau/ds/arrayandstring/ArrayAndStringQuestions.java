package edu.sau.ds.arrayandstring;

import java.util.List;

import edu.sau.ds.arrayandstring.ArrayAndStringSolutions.Pair;

public interface ArrayAndStringQuestions {

	ArrayAndStringQuestions INSTANCE = new ArrayAndStringSolutions();

	void reverseArrayInPLace(int[] array);

	/**
	 * Example :
	 * 
	 * even-number: mid of 6 is 3
	 * 
	 * odd number : mid of 7 is 4
	 * 
	 */
	int getMidValueUsingSingleIntegerDivision(int number);

	/**
	 * 1. Your friend is typing his name into a faulty keyboard.
	 * 
	 * 2. Sometimes, when typing a character 'c', the key might get long pressed,
	 * and the character will be typed 1 or more times.
	 * 
	 * 3. You examine the typed characters of the keyboard. Return 'True' if it is
	 * possible that it was your friends name, with some characters (possibly none)
	 * being long pressed.
	 */
	boolean isWordCorrectlyTypedOnFaultyKeyboard(String typedWord, String actualWord);

	/**
	 * 1. Assume you have an array of length 'n' initialized with all 0's and are
	 * given 'q' queries to update.
	 * 
	 * 2. Each query is represented as a triplet: [startIndex, endIndex, inc] which
	 * increments each element of subarray A[startIndex ... endIndex] (startIndex
	 * and endIndex inclusive) with inc.
	 * 
	 * 3. Return the modified array after all 'q' queries were executed.
	 */
	int[] rangeAddition(int[] input, int[][] updateQueries);

	/**
	 * 1. Given n non-negative integers a1, a2, ..., an.
	 * 
	 * 2. Each represents a point at coordinate (i, ai).
	 * 
	 * 3. 'n' vertical lines are drawn such that the two endpoints of the line i is
	 * at (i, ai) and (i, 0).
	 * 
	 * 4. Find two lines, which, together with the x-axis forms a container, such
	 * that the container contains the most water.
	 * 
	 * 5. (Not volume because we are working with 2D so amount of water is basically
	 * Area).
	 */
	int calculateMaxAreaBetweenLines(int[] lines);

	/**
	 * 1. Given an integer array 'nums' sorted in non-decreasing order.
	 * 
	 * 2. Return an array of the squares of each number sorted in non-decreasing
	 * order.
	 * 
	 * Note: array can contain -ve values
	 */
	int[] squaresOfSortedArray(int[] nums);

	/**
	 * 1. Give an array of size 'n'.
	 * 
	 * 2. Find Majority element and print it(if exist), otherwise print "No Majority
	 * Element exist".
	 * 
	 * 3. Majority element-> if frequency of an element is more than n/2, then that
	 * element is majority element.
	 * 
	 * 3. Note : solve the problem in linear time and in O(1) space.
	 */
	void findNBy2MajorityElementUsingBoyerMooreVotingAlgo(int[] input);

	/**
	 * 1. Give an array of size 'n'.
	 * 
	 * 2. Find Majority element and print it(if exist), otherwise print "No Majority
	 * Element exist".
	 * 
	 * 3. Majority element-> if frequency of an element is more than n/3, then that
	 * element is majority element.
	 * 
	 * 3. Note : solve the problem in linear time and in O(1) space.
	 */
	void findNBy3MajorityElementUsingBoyerMooreVotingAlgo(int[] input);

	/**
	 * To use BoyerMooreVoting algorithm, we need to pick variable pairs for
	 * majority element and its vote. If the size of k in "n/k"-majority is large
	 * then we need to assign large number of variables to hold majority_element and
	 * its vote, so space complexity is dependent on k. Thus. space complexity for
	 * "n/k" majority element = O(2k = O(k)
	 * 
	 * So, better approach would be to use hash-map to keep the frequencies where k
	 * is large.
	 */
	default void majorityElementGeneralApproachUsingHashMap(int[] input) {
	}

	/**
	 * 1. Given an integer array of size 'n'.
	 * 
	 * 2. Return an array answer such that answer[i] is equal to the product of all
	 * the elements of arr except arr[i].
	 * 
	 * 3. Special thoughts should be given to indexes having zero value as we are
	 * using division.
	 */
	int[] productOfElementsExceptSelfUsingDivision(int[] input);

	/**
	 * 1. Given an integer array of size 'n'.
	 * 
	 * 2. Return an array answer such that answer[i] is equal to the product of all
	 * the elements of arr except arr[i].
	 * 
	 */
	int[] productOfElementsExceptSelfWithoutUsingDivision(int[] input);

	/**
	 * 1. A string 's' of lowercase English letters is given.
	 * 
	 * 2. We want to partition this string into as many parts as possible so that
	 * each letter appears in at most one part.
	 * 
	 * 3. Return a list of integers representing the size of these parts.
	 * 
	 * Explanation: input = "ababcbacadefegdehijhklij"
	 * 
	 * The partition is "ababcbaca", "defegde", "hijhklij".
	 * 
	 * This is a partition so that each letter appears in at most one part.
	 * 
	 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
	 * splits s into less parts.
	 */
	List<String> getPartitionLabels(String input);

	/**
	 * You are given an integer array arr that is a permutation of [0, 1, ...,
	 * arr.length - 1]. You have to split the array into some number of "chunks"
	 * (partitions) in such a way that if we individually sort each chunk and
	 * concatenate them, the result will be a sorted array. Your task is to get the
	 * most number of chunks that could have been made.
	 * 
	 * Note: Shuffling of chunks is not allowed.
	 */
	List<String> getMaxSortablePartitionsOn0ToNMinus1Elements(List<Integer> input);

	/**
	 * Question: You are given an integer array array (not necessarily distinct).
	 * You have to split the array into some number of "chunks" (partitions) in such
	 * a way that if we individually sort each chunk and concatenate them, the
	 * result will be a sorted array. Your task is to list the most number of chunks
	 * that could have been made.
	 */
	List<String> getMaxSortablePartitionsBruteForce(List<Integer> input);

	List<String> getMaxSortablePartitions(List<Integer> input);

	/**
	 * 1. Given an integer array nums.
	 * 
	 * 2. Partition it into two (contiguous) subarrays left and right so that:
	 * 
	 * -----a. Every element in left is less than or equal to every element in
	 * right.
	 * 
	 * -----b. Left and right are non-empty.
	 * 
	 * -----c. Left has the smallest possible size.
	 * 
	 * 3. Return the length of left after such a partitioning.
	 */
	int getFirstSortablePartitionIntervalIndex(int[] input);

	/**
	 * 1. Given an unsorted array 'arr'.
	 * 
	 * 2. Reorder it in-place such that : arr[0] <= arr[1] >= arr[2] <= arr[3] . . .
	 * 
	 * 3. Please sort the array in place and do not define additional arrays.
	 * 
	 * 4. Allowed Time Complexity : O(n)
	 */
	void wiggleSort_1(int[] arr);

	/**
	 * <pre>
	 * 1. Given an unsorted array 'arr'.
	 * 2. Reorder it in-place such that : arr[0] <= arr[1] >= arr[2] <= arr[3] . . .
	 * 3. Please sort the array in place and do not define additional arrays.
	 * 4. Allowed Time Complexity : nlogn
	 * 5. Allowed Space Complexity: n
	 * 
	 * Algo Strategy: 
	 * Step1: sort the array in nlogn
	 * Step2: take two pointer first and last, place first on 0th index and last on 1th index
	 *           and do first++, last--
	 * </pre>
	 * 
	 */
	default void wiggleSort_2(int[] input) {

	}

	/**
	 * 1. Given an integer array 'arr'
	 * 
	 * 2. Find three numbers whose product is maximum and return the maximum
	 * product.
	 */
	void maxProductOfAnyThreeNumbers(int[] arr);

	/**
	 * 1. Given an integers X.
	 * 
	 * 2. The task is to find the minimum number of jumps to reach a point X in the
	 * number line starting from zero.
	 * 
	 * 3. The first jump made can be of length one unit and each successive jump
	 * will be exactly one unit longer than the previous jump in length.
	 * 
	 * 4. It is allowed to go either left or right in each jump.
	 */
	int getMinJumpsToReachAPointOnXAxis_1(int p);

	int getMinJumpsToReachAPointOnXAxis_2(int p);

	/**
	 * 1. We have an array 'arr' of positive integers, and two positive integers
	 * left and right (left is smaller than right).
	 * 
	 * 2. Return the number of (contiguous, non-empty) subarrays such that the value
	 * of the maximum array element in that subarray is at least left and at most
	 * right.
	 */
	int countOfSubArraysWithBoundedMax(int[] arr, int left, int right);

	void transposeMatrix(int[][] input);

	/**
	 * 1. You have a matrix of M*N Dimension.
	 * 
	 * 2. You have to return a Transpose matrix, where The transpose of a matrix is
	 * the matrix flipped over its main diagonal.
	 */
	void transposeMatrixInPlaceNxN(int[][] input);

	/**
	 * Given an integer array nums, you need to find one continuous subarray that if
	 * you only sort this subarray in ascending order, then the whole array will be
	 * sorted in ascending order.
	 * 
	 * Return the shortest such subarray and output its length.
	 * 
	 * Example:
	 * 
	 * Input: nums = [2,6,4,8,10,9,15] Output: 5
	 * 
	 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
	 * whole array sorted in ascending order.
	 * 
	 */
	default void shortestUnsortedContinousSubArray1(int[] nums) {
		// solution: sort the array, and compare with original array
		// get the first diff position as startPoint while scanning from left to right
		// get the first diff position as endPoint while scanning from right to left
	}

	/**
	 * Given an integer array nums, you need to find one continuous subarray that if
	 * you only sort this subarray in ascending order, then the whole array will be
	 * sorted in ascending order.
	 * 
	 * Return the shortest such subarray and output its length.
	 * 
	 * <pre>
	 * Example: Input: nums = [2,6,4,8,10,9,15] 
	 * Output: 5 
	 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
	 * whole array sorted in ascending order.
	 * 
	 * </pre>
	 */
	int shortestUnsortedContinousSubArray2(int[] input);

	int shortestUnsortedContinousSubArray3(int[] input);

	/**
	 * 1. You are given an n x n 2D matrix representing an image.
	 * 
	 * 2. rotate the image by 90 degrees (clockwise).
	 * 
	 * 3. You have to rotate the image in-place, which means you have to modify the
	 * input 2D matrix directly.
	 * 
	 * 4. DO NOT allocate another 2D matrix and do the rotation.
	 */
	void rotateMatrixBy90DegreeClockwise(int[][] matrix);

	/**
	 * 1. Given a string 's'.
	 * 
	 * 2. Reverse only all the vowels in the string and return it.
	 * 
	 * 3. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
	 * cases.
	 */
	String reverseVowelsOfAString(String input);

	/**
	 * <pre>
	 * 1. A group of two or more people wants to meet and minimize the total travel
	 * distance.
	 * 
	 * 2. You are given a 2D grid of values 0 or 1, where each 1 marks the home of
	 * someone in the group.
	 * 
	 * 3. Return min distance where distance is calculated using 'Manhattan
	 * Distance', where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
	 * 
	 * Example: Input
	 *
	 *  [
	 *    [1,0,0,0,1],
	 *    [0,0,0,0,0],
	 *    [0,0,1,0,0]
	 *  ]
	 *
	 * Output: 6
	 * 
	 * Explanation:
	 * The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 
	 * is minimal. So return 6.
	 * </pre>
	 */
	int getTotalDistanceTravelledToReachBestMeetingPoint(int[][] friends);

	/**
	 * 1. Given two non-negative integers, num1 and num2 represented as string.
	 * 
	 * 2. Return the sum of num1 and num2 as a string.
	 * 
	 * 3. You must solve the problem without using any built-in library for handling
	 * large integers (such as BigInteger).
	 * 
	 * 4. You must also not convert the inputs to integers directly.
	 * 
	 * @see edu.sau.ds.linkedlist.KarumanchiQuestions#addTwoLists(edu.sau.ds.linkedlist.List,
	 *      edu.sau.ds.linkedlist.List)
	 */
	String getSummationOfTwoStrings(String s1, String s2);

	/**
	 * 1. Given two non-negative integers num1 and num2 represented as strings.
	 * 
	 * 2. Return the product of num1 and num2, also represented as a string.
	 * 
	 * 3. Note: You must not use any built-in BigInteger library or convert the
	 * inputs to integer directly.
	 */
	String getProductOfTwoStrings(String s1, String s2);

	/**
	 * 1. Given an array nums of non-negative integers.
	 * 
	 * 2. Arrange elements of array in specific order, all even elements followed by
	 * odd elements. [even -> odd]
	 * 
	 * 3. Preserve the order of Even elements without using extra space.
	 * 
	 * 4. Hence question is order specific so you have to match your output in order
	 * of given output.
	 */
	void sortArrayByParity(int[] arr);

	/**
	 * 1. Question will be provided with "n" Intervals. An Interval is defined as
	 * (sp,ep) i.e. sp --> starting point & ep --> ending point of an Interval
	 * (sp/ep are inclusive). Some Intervals may or maynot overlap eachother.
	 * 
	 * 2. Intervals[i] = [startingPoint,endingPoint] Task is to "Merge all
	 * Overlapping Intervals".
	 */
	void mergeIntervals(int[][] array);

	/**
	 * 1. Given an Integer 'n'.
	 * 
	 * 2. Print all primes from 2 to 'n'.
	 * 
	 * 3. Portal is not forced you, but try to submit the problem in less than
	 * n.root(n) complexity.
	 */
	int[] getSieveOfEratosthenes(int n);

	/**
	 * 1. Generate all primes between 'start' and 'end'(both are included).
	 * 
	 * 2. Print every number in new line.
	 * 
	 * 3. Allowed time Complexity : O(nlog(log n)), where n = end - start.
	 * 
	 * 4. Allowed Space Complexity : O(n), where n = end - start;
	 */
	int[] printSieveOfEratosthenesInRange(int start, int end);

	/**
	 * 1. A complex number can be represented as a string on the form "Real +
	 * Imaginary i" where:
	 * 
	 * 1.1 Real is the real part and is an integer in the range [-100, 100].
	 * 
	 * 1.2 Imaginary is the imaginary part and is an integer in the range [-100,
	 * 100].
	 * 
	 * 1.3 i^2 == -1.
	 * 
	 * 2. Given two complex numbers num1 and num2 as strings, return a string of the
	 * complex number that represents their multiplications.
	 */
	void printProductOfTwoComplexNumbers(String num1, String num2);

	/**
	 * 1. Given a string s.
	 * 
	 * 2. Return true if the s can be palindrome after deleting at most one
	 * character from it.
	 */
	void printIsPalindromeRemovingAtmost1Char(String input);

	/**
	 * There are n cars going to the same destination along a one-lane road. The
	 * destination is target miles away.
	 * 
	 * You are given two integer array position and speed, both of length n, where
	 * position[i] is the position of the ith car and speed[i] is the speed of the
	 * ith car (in miles per hour).
	 * 
	 * A car can never pass another car ahead of it, but it can catch up to it and
	 * drive bumper to bumper at the same speed. The faster car will slow down to
	 * match the slower car's speed. The distance between these two cars is ignored
	 * (i.e., they are assumed to have the same position).
	 * 
	 * A car fleet is some non-empty set of cars driving at the same position and
	 * same speed. Note that a single car is also a car fleet.
	 * 
	 * If a car catches up to a car fleet right at the destination point, it will
	 * still be considered as one car fleet.
	 * 
	 * Return the number of car fleets that will arrive at the destination.
	 * 
	 * Example:
	 * 
	 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
	 * 
	 * Output: 3
	 * 
	 * Explanation: The cars starting at 10 (speed 2) and 8 (speed 4) become a
	 * fleet, meeting each other at 12. The car starting at 0 does not catch up to
	 * any other car, so it is a fleet by itself. The cars starting at 5 (speed 1)
	 * and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at
	 * speed 1 until it reaches target. Note that no other cars meet these fleets
	 * before the destination, so the answer is 3.
	 * 
	 */
	void carFleetProblem(int[] startingPosition, int[] speed, int target);

	/**
	 * 1. You are given a number in form of String.
	 * 
	 * 2. You can swap two digits at most once to get the maximum valued number in
	 * that string.
	 * 
	 * 3. Return the maximum valued number you can get in form of string.
	 */
	void maxNumberFromOneSwap1(String number);

	void maxNumberFromOneSwap2(String number);

	/**
	 * You have k lists of sorted integers in non-decreasing order. Find the
	 * smallest range that includes at least one number from each of the k lists.
	 * 
	 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a
	 * < c if b - a == d - c.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
	 * 
	 * Output: [20,24]
	 * 
	 * Explanation:
	 * 
	 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
	 * 
	 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
	 * 
	 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
	 */
	void smallestRangeCoveringElementsFromKLists1(List<List<Integer>> kLists);

	void smallestRangeCoveringElementsFromKLists2(List<List<Integer>> kLists);

	/**
	 * 1. In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom
	 * halves of the ith domino.
	 * 
	 * 2. A domino(Dice Structured) is a tile with two numbers from 1 to 6 - one on
	 * each half of the tile.
	 * 
	 * 3. We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
	 * 
	 * 4. Return the minimum number of rotations so that all the values in tops are
	 * the same, or all the values in bottoms are the same.
	 * 
	 * 5. If it cannot be done, return -1.
	 */
	void minDominoRotations(int[] tops, int[] bottoms);

	void minDominoRotations1(int[] tops, int[] bottoms);

	/**
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * You can return the answer in any order.
	 * 
	 * <pre>
	 * 
	 *  Input: nums = [2,7,11,15], target = 9
	 *	Output: [0,1]
	 *	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	 *
	 *	Input: nums = [3,2,4], target = 6
	 *	Output: [1,2]
	 *
	 *	Input: nums = [3,3], target = 6
	 *	Output: [0,1]
	 *
	 * </pre>
	 */
	Pair print2SumSinglePair(int[] nums, int target);

	List<Pair> print2SumAllPairs(int[] nums, int target);

	List<Pair> print2SumAllUniquePairs(int[] nums, int target);

	/**
	 * You are given an array people where people[i] is the weight of the ith
	 * person, and an infinite number of boats where each boat can carry a maximum
	 * weight of limit. Each boat carries at most two people at the same time,
	 * provided the sum of the weight of those people is at most limit.
	 * 
	 * Return the minimum number of boats to carry every given person.
	 * 
	 * Constraints:
	 * 
	 * 1 <= people.length <= 5 * 10^4, 1 <= people[i] <= limit <= 3 * 10^4
	 * 
	 * Input: people = [3,5,3,4], limit = 5
	 * 
	 * Output: 4
	 * 
	 * Explanation: 4 boats (3), (3), (4), (5)
	 */
	void minRescueBoats(int[] people, int limit);

	/**
	 * 1. Given an integer array 'nums', and a 'target', return all the triplets
	 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k.
	 * 
	 * 2. Another thing is nums[i] + nums[j] + nums[k] == target.
	 * 
	 * 3. Notice that the solution set must not contain duplicate triplets.
	 * 
	 */
	void print3SumAllUniquePairs(int[] nums, int target);

	void printKSumAllUniquePairs1(int[] nums, int target, int k);

	void printKSumAllUniquePairs2(int[] nums, int target, int k);

	/**
	 * Given an unsorted integer array nums, return the smallest missing positive
	 * integer.
	 * 
	 * You must implement an algorithm that runs in O(n) time and uses constant
	 * extra space.
	 * 
	 * <pre>
	 * 
	 * Example 1:
	 * Input: nums = [1,2,0]
	 * Output: 3
	 * 
	 * Example 2:
	 * Input: nums = [3,4,-1,1] 
	 * Output: 2
	 * 
	 * Example 3:
	 * Input: nums = [7,8,9,11,12] 
	 * Output: 1
	 * 
	 * </pre>
	 */
	void printFirstMissingPositiveInteger(int[] nums);

	void printFirstMissingPositiveInteger1(int[] nums);

	/**
	 * https://leetcode.com/problems/pascals-triangle-ii/
	 */
	void printPascalTriangleRow(int row);

	/**
	 * Given an integer array nums of length n where all the integers of nums are in
	 * the range [1, n] and each integer appears once or twice, return an array of
	 * all the integers that appears twice.
	 * 
	 * You must write an algorithm that runs in O(n) time and uses only constant
	 * extra space.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,1,2] Output: [1]
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [1] Output: []
	 */
	void findAllDuplicatesInAnArray(int[] nums);

	/**
	 * Given a list of strings words and a string pattern, return a list of words[i]
	 * that match pattern. You may return the answer in any order.
	 * 
	 * A word matches the pattern if there exists a permutation of letters p so that
	 * after replacing every letter x in the pattern with p(x), we get the desired
	 * word.
	 * 
	 * Recall that a permutation of letters is a bijection from letters to letters:
	 * every letter maps to another letter, and no two letters map to the same
	 * letter.
	 * 
	 * Example 1:
	 * 
	 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
	 * 
	 * Output: ["mee","aqq"]
	 * 
	 * Explanation: "mee" matches the pattern because there is a permutation {a ->
	 * m, b -> e, ...}. "ccc" does not match the pattern because {a -> c, b -> c,
	 * ...} is not a permutation, since a and b map to the same letter.
	 * 
	 * Example 2:
	 * 
	 * Input: words = ["a","b","c"], pattern = "a"
	 * 
	 * Output: ["a","b","c"]
	 */
	List<String> findAndReplacePattern(String[] words, String pattern);

}
