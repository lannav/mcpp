package TestNGtests;
public class AList0 implements EList 
{
	public int[] ar = new int[0];

	@Override
	public void clear() 
	{
		ar = new int[0];
	}

	@Override
	public void init(int[] ini) 
	{
		if (ini == null)
			ini = new int[0];

		ar = new int[ini.length];

		for (int i = 0; i < ar.length; i++)
			ar[i] = ini[i];
	}

	@Override
	public int[] toArray() 
	{
		int[] arr = new int[ar.length];

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
	public void addStart(int val) 
	{
		int[] tmp = new int[ar.length + 1];

		for (int i = 0; i < ar.length; i++)
			tmp[i + 1] = ar[i];

		tmp[0] = val;
		ar = tmp;
	}

	@Override
	public void addEnd(int val) 
	{
		int[] tmp = new int[ar.length + 1];

		for (int i = 0; i < ar.length; i++)
			tmp[i] = ar[i];

		tmp[ar.length] = val;
		ar = tmp;
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if (pos > ar.length || pos < 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[ar.length + 1];

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
	public int delStart() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[ar.length - 1];
		int tp = ar[0];

		for (int i = 0; i < ar.length - 1; i++) {
			tmp[i] = ar[i + 1];
		}
		ar = tmp;

		return tp;
	}

	@Override
	public int delEnd() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[ar.length - 1];
		int tp = ar[ar.length - 1];

		for (int i = 0; i < ar.length - 1; i++) {
			tmp[i] = ar[i];
		}
		ar = tmp;

		return tp;
	}

	@Override
	public int delPos(int pos) 
	{
		if (pos >= ar.length || pos < 0)
			throw new IllegalArgumentException();

		int[] tmp = new int[ar.length - 1];
		int tp = ar[pos];

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
	public int min() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int min = ar[0];

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] < min)
				min = ar[i];
		}

		return min;
	}

	@Override
	public int max() 
	{
		if (size() == 0)
			throw new IllegalArgumentException();

		int max = ar[0];

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > max)
				max = ar[i];
		}

		return max;
	}

	@Override
	public int minPos() 
	{
		int pos = 0;
		int min = min();

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
		int max = max();

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == max)
				pos = i;
		}
		return pos;
	}

	@Override
	public void sort() 
	{
		int temp, j;
		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] > ar[i + 1]) {
				temp = ar[i + 1];
				ar[i + 1] = ar[i];
				j = i;
				while (j > 0 && temp < ar[j - 1]) {
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
			int tmp = ar[i];
			ar[i] = ar[ar.length - 1 - i];
			ar[ar.length - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() 
	{
		for (int i = 0; i < ar.length / 2; i++) {
			if (ar.length % 2 == 0) {
				int tmp = ar[i];
				ar[i] = ar[ar.length / 2 + i];
				ar[ar.length / 2 + i] = tmp;
			} else {
				int tmp = ar[i];
				ar[i] = ar[ar.length / 2 + 1 + i];
				ar[ar.length / 2 + 1 + i] = tmp;
			}
		}
	}

	@Override
	public int get(int pos) 
	{
		if (pos >= ar.length || pos < 0)
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public void set(int pos, int val) 
	{
		if (pos > ar.length || pos < 0)
			throw new IllegalArgumentException();

		if (ar.length == 0)
			ar = new int[1];

		if (pos == size()) {
			int[] tmp = new int[ar.length + 1];
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
}
