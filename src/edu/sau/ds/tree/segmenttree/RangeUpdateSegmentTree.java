package edu.sau.ds.tree.segmenttree;

public interface RangeUpdateSegmentTree<T> {

	T query(int index);

	void update(T data, int left, int right);

}
