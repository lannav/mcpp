public class Test 
{
	private String[] mas;
	
	public Test(String str)
	{
		mas = str.split(" ");
		AList0<String> lst = new AList0<String>();
		boolean[] v = new boolean[mas.length];
		visit(v, lst);
	}
	
	private void visit(boolean[] v, AList0<String> lst)
	{
		if(lst.size() == mas.length)
		{
			lst.print();
			return;
		}
		
		for(int i = 0; i < v.length; i++)
		{	
			if(v[i] == false)
			{
			lst.addEnd(mas[i]);
			v[i] = true;
			visit(v,lst);
			v[i] = false;
			lst.delEnd();
			}
		}
	}
}
