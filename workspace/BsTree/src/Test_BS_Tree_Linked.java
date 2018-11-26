

public class Test_BS_Tree_Linked 
{
	public static void main(String[] args)
	{
		BS_Tree_Linked tr = new BS_Tree_Linked();
		int[] ini = {5,3,4,1,2,6,8,7,9,0};
		int[] ini1 = {5,3,4,1,2,6,8,7,9,0};
		tr.init(ini);
//		tr.del(4);
		BS_Tree_Linked tr1 = new BS_Tree_Linked();
		tr1.init(ini1);
//		System.out.println(tr.equals(tr1));
		System.out.println(tr.hashCode());
		System.out.println(tr1.hashCode());
	}
}
