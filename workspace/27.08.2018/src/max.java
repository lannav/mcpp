
public class max 
{
	public static int maxd (int a, int b, int c)
	{
		int m = -222222;
		if(a >= b && a >= c)
		m = a;
		if(b >= a && b >= c)
			m = b;
		if(c >= a && c >= b)
			m = c;
		
		return m;
	}
	public static void main(String[] args) 
	{
   int m = maxd(8,0,3);
   System.out.println(m);
	}

}
