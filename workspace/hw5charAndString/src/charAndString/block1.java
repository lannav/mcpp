package charAndString;

public class block1 
{
public static void main(String[] args)
{
	char a = 'A';
	for(int i = 0; i < 26; i++)
	{
		System.out.print(a+" ");
		a += 1;
	}
	System.out.println();
	char b = 'z';
	for(int i = 0; i < 26; i++)
	{
		System.out.print(b+" ");
		b -= 1;
	}
	System.out.println();
	char c = 'à';
	for(int i = 0; i < 32; i++)
	{
		System.out.print(c+" ");
		c += 1;
	}
	System.out.println();
	char d = '0';
	for(int i = 0; i < 10; i++)
	{
		System.out.print(d+" ");
		d += 1;
	}
	System.out.println();
	char e = 32;
	for(int i = 0; i < 95; i++)
	{
		System.out.print(e+" ");
		e += 1;
	}
}
}
