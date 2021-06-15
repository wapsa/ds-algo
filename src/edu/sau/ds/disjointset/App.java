package edu.sau.ds.disjointset;

public class App {

	public static void main(String[] args) {
		DisjointSet<Integer> set = new FastUnionRankAndPathCompression5();
		set.makeset(10);

		System.out.println(set);
		set.union(3, 7);
		set.union(4, 6);
		System.out.println(set);

		set.union(3, 4);
		System.out.println(set);

		set.find(3);
		System.out.println(set);

	}

}
