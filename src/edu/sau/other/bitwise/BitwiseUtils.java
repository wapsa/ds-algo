package edu.sau.other.bitwise;

public final class BitwiseUtils {

	public static boolean isEvenNumber(int num) {
		return (num & 1) == 0;
	}

	public static boolean isEvenNumber1(int num) {
		return (num & -num) != 1;
	}

	public static void swap(int p, int q) {

	}

	public static int min(int p, int q) {

		return 0;
	}

	public static int max(int p, int q) {

		return 0;
	}

	public static boolean numsHavingOppositeSign(int p, int q) {

		return true;
	}

	public static int multiplyBy2(int num) {
		return num << 1;
	}

	public static int divideBy2(int num) {
		return num >> 1;
	}

	public static int powerOf2(int power) {
		return 1 << power;
	}

	/**
	 * x & (x – 1): use to turn off the rightmost 1-bit in a word, producing 0 if
	 * none (e.g., input: 01011000 output: 01010000).
	 *
	 * This can be used to determine if an unsigned integer is a power of 2 or is 0:
	 * apply the formula followed by a 0-test on the result.
	 *
	 * is_2_toThePowerOf_N<br>
	 * Let's say i is 2^n, then i has only HighestOneBit set. And (i-1) i.e. (2^n
	 * -1) has all bits set except of highestOneBit position.
	 */
	public static boolean is_2_toThePowerOf_N(int num) {
		if (num <= 0)
			return false;

		return (num & (num - 1)) == 0;
	}

	/**
	 * x & (x + 1) : use to turn off the trailing 1’s in a word, producing x if none
	 * (e.g., input: 10100111 output:10100000) This can be used to determine if an
	 * unsigned integer is of the form 2^n – 1, 0, or all 1’s: apply the formula
	 * followed by a 0-test on the result.
	 *
	 * -1 will have all 1's
	 *
	 */
	public static boolean is_2_tothePowerOf_N_Minus_1(int num) {
		if (num <= 0)
			return false;

		return (num & (num + 1)) == 0;
	}

	/**
	 * 
	 * There is no leading zeros in negative number as it's sign bit is 1.
	 *
	 * There is full size of leading zeros for x==0.
	 *
	 * 2^n can be written as 1<<n
	 *
	 * This solution is binarySearch based. O(n) = base 2 log of 32 = 5
	 *
	 */
	public static int numberOfLeadingZeros(int num) {
		if (num <= 0)
			return num == 0 ? 0 : 32;

		int noOfLeadingZeroes = 31;

		if (num >= (1 << 16)) {
			noOfLeadingZeroes -= 16;
			// zero fill right shifting starting 16 bits to the end as we have already
			// ascertained that the number representation occupies bits 2^0 to 2^15
			num = num >>> 16;
		}
		if (num >= (1 << 8)) {
			noOfLeadingZeroes -= 8;
			num = num >>> 8;
		}
		if (num >= (1 << 4)) {
			noOfLeadingZeroes -= 4;
			num = num >>> 4;
		}
		if (num >= (1 << 2)) {
			noOfLeadingZeroes -= 2;
			num = num >>> 2;
		}

		// If num has not entered any above ifs, then it can be either 1 or 2. If it has
		// entered above ifs, then it can be either 0, 1 or 2
		return noOfLeadingZeroes - (num >>> 1);
	}

	/**
	 * # Aim of the formulas is to get 1's at all the trailing zeroes and 0's at all
	 * preceding bits.
	 * 
	 * e.g. 1010100011000 => 0000000000111
	 */
	public static int numberOfTrailingZeros(int num) {
		final int formula = ~num & (num - 1);
		// final int formula = (num & -num) - 1;
		// final int formula = ~(num | -num);

		/**
		 * below if is same as these two ifs
		 * 
		 * if (formula == 0) return 0;
		 * 
		 * if (formula == -1) return 32;
		 */
		if (formula <= 0)
			return formula & 32;

		return 32 - numberOfLeadingZeros(formula);
	}

	public static int numberOfTrailingZerosJava(int num) {
		num = ~num & (num - 1);
		if (num <= 0)
			return num & 32;

		int n = 1;
		if (num > 1 << 16) {
			n += 16;
			num >>>= 16;
		}
		if (num > 1 << 8) {
			n += 8;
			num >>>= 8;
		}
		if (num > 1 << 4) {
			n += 4;
			num >>>= 4;
		}
		if (num > 1 << 2) {
			n += 2;
			num >>>= 2;
		}
		return n + (num >>> 1);
	}

	/**
	 * 
	 * */
	public static int lowestOneBit(int num) {
		return num & -num;
	}

	public static int highestOneBit(int num) {
		return 1 << 31 - numberOfLeadingZeros(num);
	}

	/**
	 * Integer.MIN_VALUE = Integer.MAX_VALUE + 1;
	 *
	 * Integer.MAX_VALUE = 0111111..30 times
	 *
	 * Integer.MIN_VALUE = 0111111..30 times + 1 = 1000000..30 times
	 *
	 */
	public static int highestOneBitJava(int num) {
		return num & (Integer.MIN_VALUE >>> numberOfLeadingZeros(num));
	}

	public static boolean isNum_2PowerOfJ_Minus_2PowerOfK(int num) {
		return false;
	}

	public static int bitCount(int num) {
		return 0;
	}

	public static int reverseBits(int num) {
		return 0;
	}

	public static int reverseBytes(int num) {
		return 0;
	}

	/**
	 * Returns the signum function of the specified {@code int} value. (The return
	 * value is -1 if the specified value is negative; 0 if the specified value is
	 * zero; and 1 if the specified value is positive.)
	 */
	public static int signum(int i) {
		return (i >> 31) | (-i >>> 31);
	}

}
