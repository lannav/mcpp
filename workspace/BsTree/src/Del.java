
public class Del 
{
	Node root = null;
	
	class Node
	{
		int val;
		Node left = null;
		Node right = null;
	
		public Node(int val)
		{
			this.val = val;
		}
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
			else    // в этом блоке выбираем реализацию ПОВОРОТОМ или подъемом ; когда есть и левый и правый потомок
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
}
