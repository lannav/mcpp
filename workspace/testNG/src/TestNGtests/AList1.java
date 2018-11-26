package TestNGtests;
public class AList1 implements EList {
	public int[] ar = new int[15];
	public int index;

	@Override
	public void clear() {
		index = 0;
	}

	@Override
	public void init(int[] ini) {
		if (ini == null)
			ini = new int[0];

		clear();

		for (int i = 0; i < ini.length; i++) {
			ar[i] = ini[i];
			index++;
		}
	}

	@Override
	public int[] toArray() {
		int[] arr = new int[index];

		for (int i = 0; i < index; i++)
			arr[i] = ar[i];

		return arr;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public void addStart(int val) {
		index++;

		for (int i = 1; i < index; i++)
			ar[index - i] = ar[index - 1 - i];

		ar[0] = val;
	}

	@Override
	public void addEnd(int val) {
		ar[index] = val;
		index++;
	}

	@Override
	public void addPos(int pos, int val) {
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
	public int delStart() {
		if (size() == 0)
			throw new IllegalArgumentException();

		int tp = ar[0];

		for (int i = 0; i < index; i++) {
			ar[i] = ar[i + 1];
		}
		index--;

		return tp;
	}

	@Override
	public int delEnd() {
		if (size() == 0)
			throw new IllegalArgumentException();

		return ar[--index];
	}

	@Override
	public int delPos(int pos) {
		if (pos >= index || pos < 0)
			throw new IllegalArgumentException();

		int tp = ar[pos];

		for (int i = 0; i < index - 1; i++) {
			if (i >= pos)
				ar[i] = ar[i + 1];
		}
		index--;

		return tp;
	}

	@Override
	public int min() {
		if (size() == 0)
			throw new IllegalArgumentException();

		int min = ar[0];

		for (int i = 0; i < index; i++) {
			if (ar[i] < min)
				min = ar[i];
		}

		return min;
	}

	@Override
	public int max() {
		if (size() == 0)
			throw new IllegalArgumentException();

		int max = ar[0];

		for (int i = 0; i < index; i++) {
			if (ar[i] > max)
				max = ar[i];
		}

		return max;
	}

	@Override
	public int minPos() {
		int pos = 0;
		int min = min();

		for (int i = 0; i < index; i++) {
			if (ar[i] == min)
				pos = i;
		}
		return pos;
	}

	@Override
	public int maxPos() {
		int pos = 0;
		int max = max();

		for (int i = 0; i < index; i++) {
			if (ar[i] == max)
				pos = i;
		}
		return pos;
	}

	@Override
	public void sort() {
		int temp, j;
		for (int i = 0; i < index - 1; i++) {
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
	public void reverse() {
		for (int i = 0; i < index / 2; i++) {
			int tmp = ar[i];
			ar[i] = ar[index - 1 - i];
			ar[index - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() {
		for (int i = 0; i < index / 2; i++) {
			if (index % 2 == 0) {
				int tmp = ar[i];
				ar[i] = ar[index / 2 + i];
				ar[index / 2 + i] = tmp;
			} else {
				int tmp = ar[i];
				ar[i] = ar[index / 2 + 1 + i];
				ar[index / 2 + 1 + i] = tmp;
			}
		}
	}

	@Override
	public int get(int pos) {
		if (pos >= index || pos < 0)
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public void set(int pos, int val) {
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
}
