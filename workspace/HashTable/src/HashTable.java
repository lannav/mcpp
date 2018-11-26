import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class HashTable 
{
	int size;
	Node[] ht;
	int[] prime = new int[8];
	int k = 0;
	ArrayList<Person> alpp = new ArrayList<Person>();
	
	public HashTable()
	{
		size = 0;
	}
	
	public HashTable(int size)
	{
		this.size = size;
		
		while( size > (30*k + 29) )
			k++;
		
		prime[0] = 30*k + 1;
		prime[1] = 30*k + 7;
		prime[2] = 30*k + 11;
		prime[3] = 30*k + 13;
		prime[4] = 30*k + 17;
		prime[5] = 30*k + 19;
		prime[6] = 30*k + 23;
		prime[7] = 30*k + 29;
		
		for (int i = 0; i < prime.length; i++) 
		{
			if (prime[i] % 7 == 0 || prime[i] % 11 == 0 || prime[i] % 13 == 0 || prime[i] % 17 == 0
					|| prime[i] % 19 == 0 || prime[i] % 23 == 0 || prime[i] % 29 == 0 || prime[i] == 1)
				prime[i] = 0;
			
			if (size * 3 / 2 < prime[i])
			{
				ht = new Node[prime[i]];
				return;
			}
		}
	}
	
	class Node
	{
		Person val = null;
		Node next = null;
		
		public Node(Person val)
		{
			this.val = val;
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public void init(Node[] pp)
	{
		clear();
		for(int i = 0; i < pp.length; i++)
		{
			if(pp[i] != null)
				if(pp[i].next == null)
					add(pp[i].val);
				else
					initNode(pp[i]);
		}
	}
	
	public void initNode(Node n)
	{
		if(n == null)
			return;
		
		add(n.val);
		initNode(n.next);
	}

	public void add(Person p) 
	{
		if(ht == null)
			ht = new Node[7];	
		
		if(capacity() > 70)
		{
			HashTable newHT = new HashTable(size);
			newHT.init(ht);
			ht = newHT.ht;
		}
		
		if(ht[p.hashCode()%ht.length] == null)
			ht[p.hashCode()%ht.length] = new Node(p);
		else
			addNode(p, ht[p.hashCode()%ht.length].next);
		size++;
	}
	
	private void addNode(Person p, Node n)
	{
		if(n.next == null)
		{
			n.next = new Node(p);
			return;
		}
		else
		{
			addNode(p, n.next);
		}
	}
	public void clear()
	{
		size = 0;
	}
	
	public Person get(int hash)
	{
		return ht[hash%ht.length].val;
	}
	
	public void del(int hash)
	{
		if(ht[hash%ht.length] != null)
		{
			if(ht[hash%ht.length].next == null)
			{
			ht[hash%ht.length] = null;
			size--;
			}
			else 
			{
				delNode(ht[hash%ht.length].next);
				JOptionPane.showInputDialog(alpp);
			}
		}
	}
	
	public void delNode(Node p)
	{
		if(p == null)
			return;
		
		alpp.add(p.val);
		delNode(p.next);
		
	}
	
	public int capacity()
	{
		return size*100/ht.length;
	}
}
