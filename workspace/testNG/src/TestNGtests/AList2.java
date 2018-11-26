package TestNGtests;
public class AList2 implements EList {
	public int[] ar = new int[30];
	public int start;
	public int end;

	@Override
	public void clear() {
		start = ar.length / 2;
		end = ar.length / 2;
	}

	@Override
	public void init(int[] ini) {
		if (ini == null)
			ini = new int[0];

		clear();

		start = (ar.length - ini.length) / 2;
		end = start;
		for (int i = start; i < ini.length + start; i++) {
			ar[i] = ini[i - start];
			end++;
		}
	}

	@Override
	public int[] toArray() {
		int[] arr = new int[end - start];

		for (int i = start; i < end; i++)
			arr[i - start] = ar[i];

		return arr;
	}

	@Override
	public int size() {
		return end - start;
	}

	public void addStart(int val) {
		ar[start - 1] = val;
		start--;
	}

	@Override
	public void addEnd(int val) {
		ar[end] = val;
		end++;
	}

	@Override
	public void addPos(int pos, int val) {
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
	public int delStart() {
		if (size() == 0)
			throw new IllegalArgumentException();

		return ar[start++];
	}

	@Override
	public int delEnd() {
		if (size() == 0)
			throw new IllegalArgumentException();

		return ar[--end];
	}

	@Override
	public int delPos(int pos) {
		if (pos >= size() || pos < 0)
			throw new IllegalArgumentException();

		int tp = ar[pos + start];

		for (int i = start; i < end; i++) {
			if (i - start >= pos)
				ar[i] = ar[i + 1];
		}
		end--;

		return tp;
	}

	@Override
	public int min() {
		if (size() == 0)
			throw new IllegalArgumentException();

		int min = ar[start];

		for (int i = start; i < end; i++) {
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

		for (int i = start; i < end; i++) {
			if (ar[i] > max)
				max = ar[i];
		}

		return max;
	}

	@Override
	public int minPos() {
		int pos = start;
		int min = min();

		for (int i = start; i < end; i++) {
			if (ar[i] == min)
				pos = i - start;
		}
		return pos;
	}

	@Override
	public int maxPos() {
		int pos = start;
		int max = max();

		for (int i = start; i < end; i++) {
			if (ar[i] == max)
				pos = i - start;
		}
		return pos;
	}

	@Override
	public void sort() {
		int temp, j;
		for (int i = start; i < end - 1; i++) {
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
		for (int i = 0; i < size() / 2; i++) {
			int tmp = ar[i + start];
			ar[i + start] = ar[end - 1 - i];
			ar[end - 1 - i] = tmp;
		}
	}

	@Override
	public void halfReverse() {
		for (int i = 0; i < size() / 2; i++) {
			if (size() % 2 == 0) {
				int tmp = ar[i + start];
				ar[i + start] = ar[size() / 2 + i + start];
				ar[size() / 2 + i + start] = tmp;
			} else {
				int tmp = ar[i + start];
				ar[i + start] = ar[size() / 2 + 1 + i + start];
				ar[size() / 2 + 1 + i + start] = tmp;
			}
		}
	}

	@Override
	public int get(int pos) {
		if (pos >= size() || pos < 0)
			throw new IllegalArgumentException();

		return ar[pos + start];
	}

	@Override
	public void set(int pos, int val) {
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
}
