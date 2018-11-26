import java.util.Iterator;

public class AList0<T> implements GList<T> 
{
	public T[] ar = (T[]) new Comparable[0];

	@Override
	public Iterator<T> iterator()
	{
		return new MyIter(toArray());
	}

	@Override
	public void clear() 
	{
		ar = (T[]) new Comparable[0];
	}

	@Override
	public void init(T[] ini) 
	{
		if (ini == null)
			ini = (T[]) new Comparable[0];

		ar = (T[]) new Comparable[ini.length];

		for (int i = 0; i < ar.length; i++)
			ar[i] = ini[i];
	}

	@Override
	public Object[] toArray() 
	{
		T[] arr = (T[]) new Comparable[ar.length];

		for (int i = 0; i < ar.length; i++)
			arr[i] = ar[i];

		return arr;
	}

	@Override
	public int size() 
	{
		return ar.length;
	}

	@Override
	public void addStart(T val) 
	{
		T[] tmp = (T[]) new Comparable[ar.length+1];

		for (int i = 0; i < ar.length; i++)
			tmp[i + 1] = ar[i];

		tmp[0] = val;
		ar = tmp;
	}

	@Override
	public void addEnd(T val) 
	{
		T[] tmp = (T[]) new Comparable[ar.length+1];

		for (int i = 0; i < ar.length; i++)
			tmp[i] = ar[i];

		tmp[ar.length] = val;
		ar = tmp;
	}

	@Override
	public void addPos(int pos, T val) 
	{
		if (pos > ar.length || pos < 0)
			throw new IllegalArgumentException();

		T[] tmp = (T[]) new Comparable[ar.length+1];

		for (int i = 0; i < ar.length; i++) {
			if (i < pos)
				tmp[i] = ar[i];
			else
				tmp[i + 1] = ar[i];
		}

		tmp[pos] = val;
		ar = tmp;
	}

	@Override
	public T delStart() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		T[] tmp = (T[]) new Comparable[ar.length-1];
		T tp = ar[0];

		for (int i = 0; i < ar.length - 1; i++) {
			tmp[i] = ar[i + 1];
		}
		ar = tmp;

		return tp;
	}

	@Override
	public T delEnd() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		T[] tmp = (T[]) new Comparable[ar.length-1];
		T tp = ar[ar.length - 1];

		for (int i = 0; i < ar.length - 1; i++) {
			tmp[i] = ar[i];
		}
		ar = tmp;

		return tp;
	}

	@Override
	public T delPos(int pos) 
	{
		if (pos >= ar.length || pos < 0)
			throw new IllegalArgumentException();

		T[] tmp = (T[]) new Comparable[ar.length-1];
		T tp = ar[pos];

		for (int i = 0; i < ar.length - 1; i++) {
			if (i < pos)
				tmp[i] = ar[i];
			else
				tmp[i] = ar[i + 1];
		}
		ar = tmp;

		return tp;
	}

	@Override
	public T min() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		T min = ar[0];

		for (int i = 0; i < ar.length; i++) {
			if (((Comparable<T>)ar[i]).compareTo(min) == -1)
				min = ar[i];
		}

		return min;
	}

	@Override
	public T max() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		T max = ar[0];

		for (int i = 0; i < ar.length; i++) {
			if (((Comparable<T>)ar[i]).compareTo(max) == 1)
				max = ar[i];
		}

		return max;
	}

	@Override
	public int minPos() 
	{
		int pos = 0;
		T min = min();

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == min)
				pos = i;
		}
		return pos;
	}

	@Override
	public int maxPos() 
	{
		int pos = 0;
		T max = max();

		for (int i = 0; i < ar.length; i++) {
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
	public void reverse() 
	{
		for (int i = 0; i < ar.length / 2; i++) {
			T tmp = ar[i];
			ar[i] = ar[ar.length - 1 - i];
			ar[ar.length - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() 
	{
		for (int i = 0; i < ar.length / 2; i++) {
			if (ar.length % 2 == 0) {
				T tmp = ar[i];
				ar[i] = ar[ar.length / 2 + i];
				ar[ar.length / 2 + i] = tmp;
			} else {
				T tmp = ar[i];
				ar[i] = ar[ar.length / 2 + 1 + i];
				ar[ar.length / 2 + 1 + i] = tmp;
			}
		}
	}

	@Override
	public T get(int pos) 
	{
		if (pos >= ar.length || pos < 0)
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public void set(int pos, T val) 
	{
		if (pos > ar.length || pos < 0)
			throw new IllegalArgumentException();

		if (ar.length == 0)
			ar = (T[]) new Comparable[1];

		if (pos == size()) {
			T[] tmp = (T[]) new Comparable[ar.length + 1];
			for (int i = 0; i < ar.length; i++)
				tmp[i] = ar[i];
			tmp[ar.length] = val;
			ar = tmp;
		} else {
			ar[pos] = val;
		}
	}

	@Override
	public String toString() 
	{
		if (size() == 0)
			return "";

		String str = "";

		for (int i = 0; i < ar.length - 1; i++)
			str += ar[i] + " ";

		str += ar[ar.length - 1];

		return str;
	}


	@Override
	public int compareTo(T arg0)
	{
		// код который сравнивает два объекта AList0
		return 0;
	}
	
	public void print()
	{
		for(int i = 0; i < size(); i++)
		{
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
}
