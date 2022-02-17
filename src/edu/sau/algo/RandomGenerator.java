package edu.sau.algo;

import java.time.Duration;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

	public static int getRandomNumber() {
		// includes -ve integers also.
		return ThreadLocalRandom.current().nextInt();
	}

	public static int getRandomNumber1() {
		// includes -ve integers also.
		return new Random().nextInt();
	}

	// having range
	public static int getRandomNumberFromRange(int lowerInclusiveBound, int upperExclusiveBound) {
		return ThreadLocalRandom.current().nextInt(lowerInclusiveBound, upperExclusiveBound);
	}

	public static int getRandomNumberFromRange1(int lowerInclusiveBound, int upperExclusiveBound) {
		// Math.random gives double between 0 and 1.
		return (int) (Math.random() * (upperExclusiveBound - lowerInclusiveBound)) + lowerInclusiveBound;
	}

	public static int[] getDistinctRandomNumbersInRange(int lowerInclusiveBound, int upperExclusiveBound, int limit) {
		return ThreadLocalRandom.current().ints(lowerInclusiveBound, upperExclusiveBound).distinct().limit(limit)
				.toArray();
	}

	public static int[] getDistinctRandomNumbersInRange1(int lowerInclusiveBound, int upperExclusiveBound, int limit) {
		return new SplittableRandom().ints(lowerInclusiveBound, upperExclusiveBound).distinct().limit(limit).toArray();
	}

	public static int[] getDistinctRandomNumbersInRange2(int lowerInclusiveBound, int upperExclusiveBound, int limit) {
		int[] res = new int[limit];
		BitSet distinctSet = new BitSet(upperExclusiveBound);
		for (int i = 0; i < limit; i++) {
			int val;
			while (true) {
				val = getRandomNumberFromRange(lowerInclusiveBound, upperExclusiveBound);
				if (!distinctSet.get(val)) {
					// mark the generated random value so as to not return same value again.
					distinctSet.set(val);
					break;
				}
			}
			res[i] = val;
		}
		return res;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();

		for (int i = 0; i < 10000000; i++) {
			getDistinctRandomNumbersInRange(10, 50, 5);
		}
		long end = System.nanoTime();
		System.out.println("Time:" + Duration.ofNanos(end - start).toMillis() + " ms");

		start = System.nanoTime();
		for (int i = 0; i < 10000000; i++) {
			getDistinctRandomNumbersInRange1(10, 50, 5);
		}
		end = System.nanoTime();
		System.out.println("Time:" + Duration.ofNanos(end - start).toMillis() + " ms");

		start = System.nanoTime();
		for (int i = 0; i < 10000000; i++) {
			getDistinctRandomNumbersInRange2(10, 50, 5);
		}
		end = System.nanoTime();
		System.out.println("Time:" + Duration.ofNanos(end - start).toMillis() + " ms");

	}

}
