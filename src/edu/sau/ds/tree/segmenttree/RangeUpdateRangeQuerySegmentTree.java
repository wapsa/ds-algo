package edu.sau.ds.tree.segmenttree;

public interface RangeUpdateRangeQuerySegmentTree<T> {

	T query(int left, int right);

	void update(T data, int left, int right);

}
