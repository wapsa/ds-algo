package edu.sau.ds.disjointset;

/**
 * <pre>
 * Applications: Disjoint sets ADT have many applications and a few of them are:
 * 
 *	-	To represent network connectivity
 *	-	Image processing
 *	-	To find least common ancestor
 *	-	To define equivalence of finite state automata
 *	-	Kruskal's minimum spanning tree algorithm (graph theory)
 *	-	In game algorithms
 * 
 * 
 * 
 * Tradeoffs in Implementing Disjoint Sets ADT:
 * 
 * - Fast FIND implementation (also called Quick FIND)
 * 
 * - Fast UNION operation implementation (also called Quick UNION)
 * 		i) 		Fast UNION implementations (Slow FIND)
 * 		ii) 	Fast UNION implementations (Quick FIND)
 * 		iii)	Fast UNION implementations with path compression
 *
 * 
 * </pre>
 */
public interface DisjointSet<T extends Comparable<T>> {

	void makeset(int size);

	/**
	 * Returns the representative (also called leader) of the set that contains the
	 * given element.
	 */
	T find(T element);

	/**
	 * Merges the two specified sets (the set in which the element a is located, and
	 * the set in which the element b is located)
	 */
	void union(T a, T b);

}
