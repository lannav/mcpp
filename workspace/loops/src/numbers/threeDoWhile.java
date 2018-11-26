package numbers;

public class threeDoWhile 
{
	public static void main(String[] args)
	{
	int a = 0;
	 do 
	 {  
		System.out.print(a+" ");
		a++;
	}while(a < 11);
	 
	System.out.print('\n');
	
	int b = -10;
	 do
	{
		System.out.print(b+" ");
		b++;
	}while(b < 21);
	 
	System.out.print('\n');
	
	int c = -30;
	 do
	{
		System.out.print(c+" ");
		c++;
	}while(c < 12);
	 
	System.out.print('\n');
	
	int d = 0;
	 do
	{
		if(d%3 == 0)System.out.print(d+" ");
		d++;
	}while(d < 51);
	
	System.out.print('\n');
	
	int e = 0;
	 do
	{
		if(e%5 == 0 && e%7 == 0)System.out.print(e+" ");
		e++;
	}while(e < 101);
}
}
