package edu.sau;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestPaytm {

	public static void main(String[] args) {

		System.out.println(itemsSort(new ArrayList<>(List.of(4, 5, 6, 5, 4, 3))));

		System.out.println(itemsSort(new ArrayList<>(List.of(3, 1, 2, 2, 4))));

		System.out.println(itemsSort(null));

		List<Integer> xx = new ArrayList<>();
		xx.add(3);
		xx.add(1);
		xx.add(2);
		xx.add(2);
		xx.add(null);
		xx.add(4);
		System.out.println(itemsSort(xx));
	}

	public static List<Integer> itemsSort(List<Integer> nums) {
		if (nums == null) {
			return List.of();
		}
		Map<Integer, Integer> map = new HashMap<>();

		nums.stream().filter(Objects::nonNull).forEach(num -> map.merge(num, 1, Integer::sum));

		Comparator<Integer> c = (a, b) -> Integer.compare(map.get(a), map.get(b));

		return nums.stream().filter(Objects::nonNull).sorted(c.thenComparing((a, b) -> Integer.compare(a, b)))
				.collect(Collectors.toList());
	}

}
