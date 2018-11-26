public class LList2<T> implements GList<T>
{
	Node front = null;
	Node rear = null;
	
	class Node
	{
		T val;
		Node next = null;
		Node prev = null;
	
		public Node(T val)
		{
			this.val = val;
		}
	}

	@Override
	public void clear()
	{
		front = null;
		rear = null;
	}

	@Override
	public void init(T[] ini)
	{
		if(ini == null)
			ini = new int[0];
		
		clear();
		
		for(int i = 0; i < ini.length; i++)
		{
			addStart(ini[ini.length-1-i]);
		}
		Node tmp = front;
		for(int i = 1; i < size(); i++)
		{
			tmp = tmp.next;
			rear = tmp;
		}
	}

	@Override
	public Object[] toArray()
	{
		T[] res = new int[size()];
		Node tmp = front;
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
		Node tmp = front;
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
		if(size() == 0)
		{
			front = tmp;
			rear = tmp;
			return;
		}
			
		tmp.next = front;
		front.prev = tmp;
		front = tmp;
	}

	@Override
	public void addEnd(int val)
	{
		if(size() == 0)
		{
			front = new Node(val);
			rear = front;
		}
		else
		{
		Node tmp = new Node(val);
		rear.next = tmp;
		rear.next.prev = rear;
		rear = rear.next;
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		if(pos < 0 || pos > size())
			throw new IllegalArgumentException();
		
		if(pos == size())
			addEnd(val);
		else if(pos == 0)
			addStart(val);
		else if(pos < size()/2)
		{
		Node tmp = front;
		for(int i = 0; i < pos; i++)
		{
				tmp = tmp.next;
		}
		Node tmp1 = new Node(val);
		tmp1.next = tmp;
		tmp1.prev = tmp.prev;
		tmp.prev = tmp1;
		tmp = tmp.prev;
		tmp.next = tmp1;
		}
		else
		{
			Node tmp = rear;
			for(int i = pos+1; i < size(); i++)
			{
					tmp = tmp.prev;
			}
			Node tmp1 = new Node(val);
			tmp1.next = tmp;
			tmp1.prev = tmp.prev;
			tmp.prev = tmp1;
			tmp = tmp.prev;
			tmp.next = tmp1;
		}
	}

	@Override
	public int delStart()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		int res = front.val;
		front = front.next;
		front.prev = null;
		
		return res;
	}

	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		int res = rear.val;
		
		rear = rear.prev;
		rear.next = null;
		
		return res;
	}

	@Override
	public int delPos(int pos)
	{
		if(pos < 0 || pos >= size())
			throw new IllegalArgumentException();
		
		int res = front.val;
		
		if(pos == 0)
			delStart();
		else if(pos < size()/2)
		{
			Node tmp = front;
			for(int i = 0; i < pos; i++)
			{
					tmp = tmp.next;
			}
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
		}
		else
		{
			Node tmp = rear;
			for(int i = pos+1; i < size(); i++)
			{
					tmp = tmp.prev;
			}
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
		}
			
		return res;
		}

	@Override
	public int min()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		Node tmp = front;
		int min = front.val;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(tmp.val < min)
				min = tmp.val;
		}
		
		return min;
	}

	@Override
	public int max()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		Node tmp = front;
		int max = front.val;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(tmp.val > max)
				max = tmp.val;
		}
		
		return max;
	}

	@Override
	public int minPos()
	{
		if(size() == 0)
			throw new IllegalArgumentException();
		
		int min = min();
		Node tmp = front;
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
		
		int max = max();
		Node tmp = front;
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
		Node tmp = front;
		
		for(int i = size() - 1; i > 0; i--)
		{
			tmp = front;
			
			for(int j = 0; j < size()-1; j++)
			{
				if( tmp.val > tmp.next.val)
				{
					int temp = tmp.val;
					tmp.val = tmp.next.val;
					tmp.next.val = temp;
				}
			tmp = tmp.next;
			}
		}
		front.prev = null;
		tmp = front;
		for(int i = 0; i < size(); i++)
		{
			Node tmp1 = tmp;
			tmp = tmp.next;
			tmp.prev = tmp1;
			if(tmp.next == null)
				rear = tmp;
		}
	}

	@Override
	public void reverse()
	{
		for(int i = 0; i < size(); i++)
		{
		addPos(size()-i, front.val);
		delStart();
		}
	}

	@Override
	public void halfReverse()
	{
		for(int i = 0; i < size()/2; i++)
		{
		addEnd(front.val);
		delStart();
		}
		if(size()%2 != 0)
		{
			addPos(size()/2 + 1, front.val);
			delStart();
		}
	}

	@Override
	public int get(int pos)
	{
		if(pos < 0 || pos >= size())
			throw new IllegalArgumentException();
		
		Node tmp = front;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		
		return tmp.val;
	}

	@Override
	public void set(int pos, int val)
	{
		if(pos < 0 || pos > size())
			throw new IllegalArgumentException();
		
		Node tmp = front;
		
		if(pos == size())
			addEnd(val);
		else if(pos < size()/2)
		{
			for(int i = 0; i < pos; i++)
				tmp = tmp.next;
			
			tmp.val = val;
		}
		else
		{
			for(int i = size()-1; i > pos; i--)
				tmp = tmp.prev;
			
			tmp.val = val;
		}
		
		
	}
	
	@Override
	public String toString()
	{
		if (size() == 0)
			return "";

		String str = "";
		int[] ar = toArray();
		
		for (int i = 0; i < size() - 1; i++)
			str += ar[i] + " ";

		str += ar[ar.length - 1];

		return str;
	}

}
