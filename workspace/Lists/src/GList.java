public interface GList<T> extends Iterable<T>, Comparable<T> 
{
	void clear();

	void init(T[] ini);

	Object[] toArray();

	int size();

	void addStart(T val);

	void addEnd(T val);

	void addPos(int pos, T val);

	T delStart();

	T delEnd();

	T delPos(int pos);

	T min();

	T max();

	int minPos();

	int maxPos();

	void sort();

	void reverse();

	void halfReverse();

	T get(int pos);

	void set(int pos, T val);

	String toString();
}
