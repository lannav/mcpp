import java.util.Iterator;

public class AList2<T> implements GList<T> {
	public T[] ar = (T[]) new Comparable[30];
	public int start;
	public int end;

	@Override
	public void clear() {
		start = ar.length / 2;
		end = ar.length / 2;
	}

	@Override
	public void init(T[] ini) {
		if (ini == null)
			ini = (T[]) new Comparable[0];

		clear();

		start = (ar.length - ini.length) / 2;
		end = start;
		for (int i = start; i < ini.length + start; i++) {
			ar[i] = ini[i - start];
			end++;
		}
	}

	@Override
	public Object[] toArray() {
		T[] arr = (T[]) new Comparable[end - start];

		for (int i = start; i < end; i++)
			arr[i - start] = ar[i];

		return arr;
	}

	@Override
	public int size() {
		return end - start;
	}

	public void addStart(T val) {
		ar[start - 1] = val;
		start--;
	}

	@Override
	public void addEnd(T val) {
		ar[end] = val;
		end++;
	}

	@Override
	public void addPos(int pos, T val) {
		if (pos > size() || pos < 0)
			throw new IllegalArgumentException();

		for (int i = start; i < end; i++) {
			if (i - start >= pos)
				ar[end + pos - i + start] = ar[end + pos - i + start - 1];
		}

		ar[pos + start] = val;
		end++;
	}

	@Override
	public T delStart() {
		if (size() == 0)
			throw new IllegalArgumentException();

		return ar[start++];
	}

	@Override
	public T delEnd() {
		if (size() == 0)
			throw new IllegalArgumentException();

		return ar[--end];
	}

	@Override
	public T delPos(int pos) {
		if (pos >= size() || pos < 0)
			throw new IllegalArgumentException();

		T tp = ar[pos + start];

		for (int i = start; i < end; i++) {
			if (i - start >= pos)
				ar[i] = ar[i + 1];
		}
		end--;

		return tp;
	}

	@Override
	public T min() {
		if (size() == 0)
			throw new IllegalArgumentException();

		T min = ar[start];

		for (int i = start; i < end; i++) {
			if (((Comparable<T>)ar[i]).compareTo(min) == -1)
				min = ar[i];
		}

		return min;
	}

	@Override
	public T max() {
		if (size() == 0)
			throw new IllegalArgumentException();

		T max = ar[0];

		for (int i = start; i < end; i++) {
			if (((Comparable<T>)ar[i]).compareTo(max) == 1)
				max = ar[i];
		}

		return max;
	}

	@Override
	public int minPos() {
		int pos = start;
		T min = min();

		for (int i = start; i < end; i++) {
			if (ar[i] == min)
				pos = i - start;
		}
		return pos;
	}

	@Override
	public int maxPos() {
		int pos = start;
		T max = max();

		for (int i = start; i < end; i++) {
			if (ar[i] == max)
				pos = i - start;
		}
		return pos;
	}

	@Override
	public void sort() {
		int j;
		T temp;
		for (int i = start; i < end - 1; i++) {
			if (((Comparable<T>)ar[i]).compareTo(ar[i + 1]) == 1) 
			{
				temp = ar[i + 1];
				ar[i + 1] = ar[i];
				j = i;
				while (j > 0 && ((Comparable<T>)ar[j - 1]).compareTo(temp) == 1) 
				{
					ar[j] = ar[j - 1];
					j--;
				}
				ar[j] = temp;
			}
		}
	}

	@Override
	public void reverse() {
		for (int i = 0; i < size() / 2; i++) {
			T tmp = ar[i + start];
			ar[i + start] = ar[end - 1 - i];
			ar[end - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() {
		for (int i = 0; i < size() / 2; i++) {
			if (size() % 2 == 0) {
				T tmp = ar[i + start];
				ar[i + start] = ar[size() / 2 + i + start];
				ar[size() / 2 + i + start] = tmp;
			} else {
				T tmp = ar[i + start];
				ar[i + start] = ar[size() / 2 + 1 + i + start];
				ar[size() / 2 + 1 + i + start] = tmp;
			}
		}
	}

	@Override
	public T get(int pos) {
		if (pos >= size() || pos < 0)
			throw new IllegalArgumentException();

		return ar[pos + start];
	}

	@Override
	public void set(int pos, T val) {
		if (pos > size() || pos < 0)
			throw new IllegalArgumentException();

		if (size() == 0 || pos == size())
			end++;
		ar[pos + start] = val;
	}

	@Override
	public String toString() {
		if (size() == 0)
			return "";

		String str = "";

		for (int i = start; i < end - 1; i++)
			str += ar[i] + " ";

		str += ar[end - 1];

		return str;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new MyIter(toArray());
	}

	@Override
	public int compareTo(T arg0)
	{
		return 0;
	}
}
