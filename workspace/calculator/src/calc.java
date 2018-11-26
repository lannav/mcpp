
public class calc 
{ 
	public static int clc(int a, int b, char c)
	{
		int res = 0;
		/*if(c == '/' && b == 0)
			throw new IllegalArgumentException("div 0");
		if(c == '+')
			res = a + b;
		else if(c == '-')
			res = a - b;
		else if(c == '*')
			res = a * b;
		else if(c == '/')
			res = a / b;
		else throw new IllegalArgumentException();*/
		switch(c)
		{
		case '+': res = a + b; break;
		case '-': res = a - b; break;
		case '*': res = a * b; break;
		case '/': 
			if(b == 0)
				throw new IllegalArgumentException();
			else res = a / b; break;
			default: throw new IllegalArgumentException();
		}
		return res;
	}

}
