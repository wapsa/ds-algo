package edu.sau.other.bitwise;

public class App {

	public static void main(String[] args) {

		int x = Integer.MIN_VALUE >> 31;
		System.out.println(Integer.MIN_VALUE >> 31);
		System.out.println(Integer.toBinaryString(x));

		int y = 1 << 31;
		
		System.out.println(Integer.toBinaryString(-0));
		
		System.out.println(Integer.signum(-3232));
		
		System.out.println(BitwiseUtils.bitCountUsingKernighans(16));
		System.out.println(Integer.bitCount(16));
	}

}
