package numbers;

public class TwoWhile 
{
	public static void main(String[] args) 
	{
		int a = 0;
		while(a < 11) 
		{
			System.out.print(a+" ");
			a++;
		}
		System.out.print('\n');
		int b = -10;
		while(b < 21) 
		{
			System.out.print(b+" ");
			b++;
		}
		System.out.print('\n');
		int c = -30;
		while(c < 12) 
		{
			System.out.print(c+" ");
			c++;
		}
		System.out.print('\n');
		int d = 0;
		while(d < 51) 
		{
			if(d%3 == 0)System.out.print(d+" ");
			d++;
		}
		System.out.print('\n');
		int e = 0;
		while(e < 101) 
		{
			if(e%5 == 0 && e%7 == 0)System.out.print(e+" ");
			e++;
		}
	}
}
