
public class BS_Tree_Linked implements Tree
{
	Link root = new Link();
	int size = 0;
	
	class Link
	{
		Node node = null;
	}
	
	class Node
	{
		Link left = null;
		Link right = null;
		Link link = null;
		int val;
		int height;
		
		public Node(int val) 
		{
			this.val = val;
		}
	}

	@Override
	public void init(int[] ini) 
	{
		if(ini == null)
			ini = new int[0];
		
		clear();
		if(ini.length == 0 || ini == null)
			return;

			for(int i = 0; i < ini.length; i++)
				add(ini[i]);
		
	}

	@Override
	public void add(int val) 
	{
		size++;
		addNode(root, val);
		
	}

	private void addNode(Link p, int val) 
	{
		if(p.node == null)
		{
			p.node = new Node(val);
			p.node.link = p;
			p.node.left = new Link();
			p.node.right = new Link();
		}
		else if(val < p.node.val)
			addNode(p.node.left, val);
		else
			addNode(p.node.right, val);
	}

	@Override
	public int size() 
	{
		return size;
	}
	
	private int sizeNode(Link p)
	{
		if(p.node == null)
			return 0;
		
		return sizeNode(p.node.left) + sizeNode(p.node.right) + 1;
	}

	@Override
	public int nodes() 
	{
		return nodesNode(root.node);
	}

	private int nodesNode(Node p) 
	{
		if(p == null)
			return 0;
		
		int rs = 0;
		if(p.left.node != null || p.right.node != null)
			rs++;
		
			return nodesNode(p.left.node) + nodesNode(p.right.node) + rs;
	}

	@Override
	public int leaves() 
	{
		return leavesNode(root.node);
	}

	private int leavesNode(Node p)
	{
		if(p == null)
			return 0;
		
		if(p.left.node == null && p.right.node == null)
			return 1;
		
			return leavesNode(p.left.node) + leavesNode(p.right.node);
	}

	@Override
	public int height() 
	{
		return hightNode(root.node);
	}

	private int hightNode(Node p) 
	{
		if(p == null)
		return 0;
		
		return Math.max(hightNode(p.left.node), hightNode(p.right.node)) + 1;
	}

	@Override
	public int[] toArray() 
	{
		int[] ar = new int[size()];
		return toArrayNode(root.node, ar, new Count());
	}
	
	class Count
	{
		int i = 0;
	}
	
	private int[] toArrayNode(Node p, int[] ar, Count co)
	{
		if(p == null)
			return ar;

		toArrayNode(p.left.node, ar, co);
		ar[co.i++] = p.val;
		toArrayNode(p.right.node, ar, co);
		
		return ar;
	}

	@Override
	public void del(int val) 
	{
		size--;
		delNode(val, root.node, root.node);
	}

	private void delNode(int val, Node cur, Node par) 
	{
		if(cur == null)
			throw new IllegalArgumentException();
		
		if(val < cur.val)
			delNode(val, cur.left.node, cur);
			else if(val > cur.val)
				delNode(val, cur.right.node, cur);
			else if(cur.left.node == null && cur.right.node == null)  // ��� �� ������ �������
			{
				if(cur == root.node)
					root.node = null;
				else if(cur == par.left.node)
					par.left.node = null;
				else 
					par.right.node = null;
			}
			else if(cur.right.node == null)    // ���� ������� �����
			{
				if(cur == root.node)
					root.node = cur.left.node;
				else if(cur == par.left.node)
					par.left.node = cur.left.node;
				else if(cur == par.right.node)
					par.right.node = cur.left.node;
			}
			else if(cur.left.node == null)        // ���� ������� ������
			{
				if(cur == root.node)
					root.node = cur.right.node;
				else if(cur == par.left.node)
					par.left.node = cur.right.node;
				else
					par.right.node = cur.right.node;
			}
			else    // � ���� ����� �������� ���������� ��������� ��� �������� ; ���� ���� � ����� � ������ �������
			{
				Node tmp = searchNode(cur.left.node);  // ��� ������ ���������� ����� �� ����� ���������� ����� ����� ������(������� �������) �������
				tmp.right.node = cur.right.node;
				if(cur == root.node)
					root.node = cur.left.node;
				else if(cur == par.left.node)
					par.left.node = cur.left.node;
				else
					par.right.node = cur.left.node;
			}
	}
	
	private Node searchNode(Node p) 
	{
		if(p.right.node == null)
			return p;
		else
			return searchNode(p.right.node);
	}

	@Override
	public int width() 
	{
		int[] ar = new int[height()];
		 widthNode(root.node, ar, 0);
		 return max(ar);
	}
	
	private void widthNode(Node p, int[] ar, int lvl) 
	{
		if(p == null)
			return;
		
		widthNode(p.left.node, ar, lvl+1);
		ar[lvl]++;
		widthNode(p.right.node, ar, lvl+1);
	}
	
	public int max(int[] ar)
	{
		if(ar.length == 0)
			return 0;
		int tmp = ar[0];
		for(int i = 1; i < ar.length; i++)
		{
			if(ar[i] > tmp)
				tmp = ar[i];
		}
		return tmp;
	}

	@Override
	public void reverse() 
	{
	//	int[] rs = toArray();
		
		
	}

	@Override
	public void clear() 
	{
		root = new Link();
		size = 0;
	}
	
	public boolean check()
	 {
	  return checkNode(root);
	 }

	 private boolean checkNode(Link p) 
	 {
	  if ( p.node == null )
	   return true;
	  
	   return checkNode(p.node.left) && p.node.link == p && checkNode(p.node.right);
	 }

	public boolean equals(BS_Tree_Linked tr)
	{
		return equalsNode(tr.root, root);
	}

	private boolean equalsNode(Link get, Link act) 
	{
		if(get.node == null && act.node == null)
			return true;
		
		if((get.node == null && act.node != null) || (get.node != null && act.node == null) || get.node.link != get || act.node.link != act)
			return false;
		
			return equalsNode(get.node.left, act.node.left) && equalsNode(get.node.right, act.node.right) && get.node.val == act.node.val;
	}	
}
