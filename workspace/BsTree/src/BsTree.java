public class BsTree implements Tree
{
	Node root = null;
	
	class Node
	{
		int val;
		Node left = null;
		Node right = null;
		int height;
	
		public Node(int val)
		{
			this.val = val;
		}
	}
	
	public void init(int[] ini)
	{
		if(ini == null)
			ini = new int[0];
		clear();
		for(int i = 0; i < ini.length; i++)
		{
			add(ini[i]);
		}
	}
	
	public void add(int val)
	{
		if(root == null)
		{
			root = new Node(val);
			return;
		}
		
		addNode(root, val);
	}
	
	private void addNode(Node p, int val)
	{
		if(val < p.val)
		{
			if(p.left == null)
				p.left = new Node(val);
			else
			addNode(p.left, val);
		}
		else
		{
			if(p.right == null)
				p.right = new Node(val);
			else
			addNode(p.right, val);
		}
	}
	
	public void print()
	{
		printNode(root);
	}
	
	private void printNode(Node p)
	{
		if(p == null)
			return;
		
		printNode(p.left);
		System.out.print(p.val + ", ");
		printNode(p.right);
	}
	
	public int size()
	{
		int res = 0;
		res += sizeNode(root);
		return res;
	}

	private int sizeNode(Node p) 
	{
		if(p == null)
			return 0;
		
		return sizeNode(p.left) + sizeNode(p.right) + 1;
	}
	
	public int nodes()
	{
		return nodesNode(root);
	}
	
	private int nodesNode(Node p)
	{
		if(p == null)
			return 0;
		
		if(p.left != null || p.right != null)
		return 1 + nodesNode(p.left) + nodesNode(p.right);
		
		return 0;
	}
	
	public int leaves()
	{
		int res = 0;
		
		res += leavesNode(root);
		
		return res;
	}
	
	private int leavesNode(Node p)
	{
		if(p == null)
			return 0;
		int res = 0;
		res += leavesNode(p.left) + leavesNode(p.right);
		
		if(p.left == null && p.right == null)
			return 1;
		
		return res;
	}
	
	public int height()
	{
		return hightNode(root);
	}
	
	private int hightNode(Node p)
	{
		if(p == null)
			return 0;
		
		return Math.max(hightNode(p.left), hightNode(p.right)) + 1;  
	}
	
	public int[] toArray()
	{
		int[] ar = new int[size()];
		return toArrayNode(root, ar, new Count());
	}
		
	class Count
	{
		int i = 0;
	}
	
	private int[] toArrayNode(Node p, int[] ar, Count co)
	{
		if(p == null)
			return ar;

		toArrayNode(p.left, ar, co);
		ar[co.i++] = p.val;
		toArrayNode(p.right, ar, co);
		
		return ar;
	}
	
	public void del(int val)
	{
		delNode(val, root, root);
	}

	private void delNode(int val, Node cur, Node par) 
	{
		if(cur == null)
			throw new IllegalArgumentException();
		
		if(val < cur.val)
			delNode(val, cur.left, cur);
			else if(val > cur.val)
				delNode(val, cur.right, cur);
			else if(cur.left == null && cur.right == null)  // нет ни одного потомка
			{
				if(cur == root)
					root = null;
				else if(cur == par.left)
					par.left = null;
				else 
					par.right = null;
			}
			else if(cur.right == null)    // один потомок слева
			{
				if(cur == root)
					root = cur.left;
				else if(cur == par.left)
					par.left = cur.left;
				else if(cur == par.right)
					par.right = cur.left;
			}
			else if(cur.left == null)        // один потомок справа
			{
				if(cur == root)
					root = cur.right;
				else if(cur == par.left)
					par.left = cur.right;
				else
					par.right = cur.right;
			}
			else    // в этом блоке выбираем реализацию ПОВОРОТОМ или подъемом ; когд есть и левый и правый потомок
			{
				Node tmp = searchNode(cur.left);  // для левого приоритета когда на место удаляемого стает самый правый(большой элемент) потомка
				tmp.right = cur.right;
				if(cur == root)
					root = cur.left;
				else if(cur == par.left)
					par.left = cur.left;
				else
					par.right = cur.left;
			}		
	}

	private Node searchNode(Node p) 
	{
		if(p.right == null)
			return p;
		else
			return searchNode(p.right);
	}
	
	 public int width()
	 {
	  return getMaxWidth(root);
	 }

	 int getMaxWidth(Node p) 
	 {
	  int maxWidth = 0;
	  int width;
	  int h = hightNode(p);
	  int i;

	  for (i = 1; i <= h; i++) 
	  {
	   width = getWidth(p, i);
	   if (width > maxWidth)
	    maxWidth = width;
	  }
	  return maxWidth;
	 }

	 int getWidth(Node p, int level) 
	 {
	  if (p == null)
	   return 0;

	  if (level == 1)
	   return 1;
	  else 
	   return getWidth(p.left, level - 1) + getWidth(p.right, level - 1);
	 }
	 
	 @Override
	 public String toString()
	 {
		 String res = "";
		 int [] ar = toArray();
		 for(int i = 0; i < size(); i++)
			 res += ar[i] + ", ";
				 
		 return res;
	 } 
	 
	 public int width1()
	 {
		 int[] ar = new int[height()];
		 width1Node(root, ar, 0);
		 return max(ar);
	 }

	private void width1Node(Node p, int[] ar, int lvl) 
	{
		if(p == null)
			return;
		
		width1Node(p.left, ar, lvl+1);
		ar[lvl]++;
		width1Node(p.right, ar, lvl+1);
	}
	
	public int max(int[] ar)
	{
		int tmp = ar[0];
		for(int i = 1; i < ar.length; i++)
		{
			if(ar[i] > tmp)
				tmp = ar[i];
		}
		return tmp;
	}

	@Override
	public void clear() 
	{
		root = null;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}
	
	public int bfactor(Node p)
	{
		return hightNode(p.right) - hightNode(p.left);
	}
	
	public Node rotateRight(Node p)
	{
		Node tmp = p.left;
		p.left = tmp.right;
		tmp.right = p;
		fixheight(tmp);
		fixheight(p);
		return tmp;
	}
	
	public Node rotateLeft(Node p)
	{
		Node tmp = p.right;
		p.right = tmp.left;
		tmp.left = p;
		fixheight(tmp);
		fixheight(p);
		return tmp;
	}

	private void fixheight(Node p) 
	{
		
	}

	@Override
	public boolean equals(BS_Tree_Linked tr) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return true;
	}
}
