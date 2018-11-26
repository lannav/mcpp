import java.util.Iterator;

public class LList1<T> implements GList<T> 
{
	Node root = null;
	
	class Node
	{
		T val;
		Node next = null;
		
		public Node(T val)
		{
			this.val = val;
		}
	}

	@Override
	public void clear()
	{
		root = null;
	}

	@Override
	public void init(T[] ini)
	{
		if(ini == null)
			ini = (T[]) new Comparable[0];
		
		clear();
		
		for(int i = 0; i < ini.length; i++)
		{
			addStart(ini[ini.length-1-i]);
		}
	}

	@Override
	public Object[] toArray()
	{
		T[] res = (T[]) new Comparable[size()];
		Node tmp = root;
		for(int i = 0; i < size(); i++)
		{
			res[i] = tmp.val;
			tmp = tmp.next;
		}
			
		return res;
	}

	@Override
	public int size()
	{
		Node tmp = root;
		int count = 0;
		
		while(tmp != null)
		{
			tmp = tmp.next;
			count++;
		}
		
		return count;
	}

	@Override
	public void addStart(T val)
	{
		Node tmp = new Node(val);
		tmp.next = root;
		root = tmp;
	}

	@Override
	public void addEnd(T val)
	{
		if(root == null)
		{
			root = new Node(val);
		}
		else
		{
		Node tmp = root;
		
		while(tmp.next != null)
		{
			tmp = tmp.next;
		}
		tmp.next = new Node(val);
		}
	}

	@Override
	public void addPos(int pos, T val)
	{
		if(pos < 0 || pos > size())
			throw new IllegalArgumentException();
		
		if(pos == size())
			addEnd(val);
		else if(pos == 0)
			addStart(val);
		else
		{
		Node tmp = root;
		for(int i = 0; i < size(); i++)
		{
			if(i < pos)
				tmp = tmp.next;
		}
		Node tmp1 = new Node(val);
		tmp1.next = tmp;
		tmp = root;
		for(int i = 0; i < size(); i++)
		{
			if(i < pos-1)
				tmp = tmp.next;
		}
		tmp.next = tmp1;
		}
	}

	@Override
	public T delStart()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		T res = root.val;
		root = root.next;
		return res;
	}

	@Override
	public T delEnd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		T res;
		
		if(size() == 1)
		{
			res = root.val;
			root = null;
		}
		else
		{
		Node tmp = root;
		
		for(int i = 0; i < size()-2; i++)
		{
			tmp = tmp.next;
		}
		res = tmp.next.val;
		tmp.next = null;
		}
		
		return res;
	}

	@Override
	public T delPos(int pos)
	{
		if(pos < 0 || pos >= size())
			throw new IllegalArgumentException();
		T res = root.val;
		
		if(pos == 0)
		{
			root = root.next;
			return res;
		}
		else
		{
		Node tmp = root;
		
		for(int i = 0; i < pos-1; i++)
		{
			tmp = tmp.next;
		}
		res = tmp.next.val;
		tmp.next = tmp.next.next;
			
		return res;
		}
	}

	@Override
	public T min()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		Node tmp = root;
		T min = root.val;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(((Comparable<T>)tmp.val).compareTo(min) == -1)
				min = tmp.val;
		}
		
		return min;
	}

	@Override
	public T max()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		Node tmp = root;
		T max = root.val;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(((Comparable<T>)tmp.val).compareTo(max) == 1)
				max = tmp.val;
		}
		
		return max;
	}

	@Override
	public int minPos()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		T min = min();
		Node tmp = root;
		int iMin = 0;
		
		for(int i = 0; i < size(); i++)
		{
			if(tmp.val == min)
				iMin = i;
			tmp = tmp.next;
		}
		
		return iMin;
	}

	@Override
	public int maxPos()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		T max = max();
		Node tmp = root;
		int iMax = 0;
		
		for(int i = 0; i < size(); i++)
		{
			if(tmp.val == max)
				iMax = i;
			tmp = tmp.next;
		}
		
		return iMax;
	}

	@Override
	public void sort()
	{
		Node tmp = root;
		
		for(int i = size() - 1; i > 0; i--)
		{
			tmp = root;
			
			for(int j = 0; j < size()-1; j++)
			{
				if(((Comparable<T>)tmp.val).compareTo(tmp.next.val) == 1)
				{
					T temp = tmp.val;
					tmp.val = tmp.next.val;
					tmp.next.val = temp;
				}
			tmp = tmp.next;
			}
		}
	}

	@Override
	public void reverse()
	{
		for(int i = 0; i < size(); i++)
		{
		addPos(size()-i, root.val);
		delStart();
		}
	}

	@Override
	public void halfReverse()
	{
		for(int i = 0; i < size()/2; i++)
		{
		addEnd(root.val);
		delStart();
		}
		if(size()%2 != 0)
		{
			addPos(size()/2 + 1, root.val);
			delStart();
		}
	}

	@Override
	public T get(int pos)
	{
		if(pos < 0 || pos >= size())
			throw new IllegalArgumentException();
		
		Node tmp = root;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		
		return tmp.val;
	}

	@Override
	public void set(int pos, T val)
	{
		if(pos < 0 || pos > size())
			throw new IllegalArgumentException();
		
		Node tmp = root;
		
		if(pos == size())
			addEnd(val);
		else 
		{
			for(int i = 0; i < pos; i++)
				tmp = tmp.next;
			
			tmp.val = val;
		}
		
		
	}
	
	@Override
	public String toString()
	{
		if (size() == 0)
			return "";

		String str = "";
		T[] ar = (T[]) toArray();
		
		for (int i = 0; i < size() - 1; i++)
			str += ar[i] + " ";

		str += ar[ar.length - 1];

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
