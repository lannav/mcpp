import java.util.Iterator;

public class AList1<T> implements GList<T> 
{
	public T[] ar = (T[]) new Comparable[15];
	public int index;

	@Override
	public void clear() {
		index = 0;
	}

	@Override
	public void init(T[] ini) {
		if (ini == null)
			ini = (T[]) new Comparable[0];

		clear();

		for (int i = 0; i < ini.length; i++) {
			ar[i] = ini[i];
			index++;
		}
	}

	@Override
	public Object[] toArray() {
		T[] arr = (T[]) new Comparable[index];

		for (int i = 0; i < index; i++)
			arr[i] = ar[i];

		return arr;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public void addStart(T val) {
		index++;

		for (int i = 1; i < index; i++)
			ar[index - i] = ar[index - 1 - i];

		ar[0] = val;
	}

	@Override
	public void addEnd(T val) {
		ar[index] = val;
		index++;
	}

	@Override
	public void addPos(int pos, T val) {
		if (pos > index || pos < 0)
			throw new IllegalArgumentException();

		for (int i = 0; i < index; i++) {
			if (i >= pos)
				ar[index + pos - i] = ar[index + pos - i - 1];
		}

		ar[pos] = val;
		index++;
	}

	@Override
	public T delStart() {
		if (size() == 0)
			throw new IllegalArgumentException();

		T tp = ar[0];

		for (int i = 0; i < index; i++) {
			ar[i] = ar[i + 1];
		}
		index--;

		return tp;
	}

	@Override
	public T delEnd() {
		if (size() == 0)
			throw new IllegalArgumentException();

		return ar[--index];
	}

	@Override
	public T delPos(int pos) {
		if (pos >= index || pos < 0)
			throw new IllegalArgumentException();

		T tp = ar[pos];

		for (int i = 0; i < index - 1; i++) {
			if (i >= pos)
				ar[i] = ar[i + 1];
		}
		index--;

		return tp;
	}

	@Override
	public T min() {
		if (size() == 0)
			throw new IllegalArgumentException();

		T min = ar[0];

		for (int i = 0; i < index; i++) {
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

		for (int i = 0; i < index; i++) {
			if (((Comparable<T>)ar[i]).compareTo(max) == 1)
				max = ar[i];
		}

		return max;
	}

	@Override
	public int minPos() {
		int pos = 0;
		T min = min();

		for (int i = 0; i < index; i++) {
			if (ar[i] == min)
				pos = i;
		}
		return pos;
	}

	@Override
	public int maxPos() {
		int pos = 0;
		T max = max();

		for (int i = 0; i < index; i++) {
			if (ar[i] == max)
				pos = i;
		}
		return pos;
	}

	@Override
	public void sort() 
	{
		int j;
		T temp;
		for (int i = 0; i < ar.length - 1; i++) 
		{
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
		for (int i = 0; i < index / 2; i++) {
			T tmp = ar[i];
			ar[i] = ar[index - 1 - i];
			ar[index - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() {
		for (int i = 0; i < index / 2; i++) {
			if (index % 2 == 0) {
				T tmp = ar[i];
				ar[i] = ar[index / 2 + i];
				ar[index / 2 + i] = tmp;
			} else {
				T tmp = ar[i];
				ar[i] = ar[index / 2 + 1 + i];
				ar[index / 2 + 1 + i] = tmp;
			}
		}
	}

	@Override
	public T get(int pos) {
		if (pos >= index || pos < 0)
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public void set(int pos, T val) {
		if (pos > index || pos < 0)
			throw new IllegalArgumentException();

		if (index == 0 || pos == size())
			index++;
		ar[pos] = val;
	}

	@Override
	public String toString() {
		if (size() == 0)
			return "";

		String str = "";

		for (int i = 0; i < index - 1; i++)
			str += ar[i] + " ";

		str += ar[index - 1];

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
		// код который сравнивает два объекта AList0
		return 0;
	}
}
