package cycles;

public class cycle 
{
	// Найти сумму четных чисел и их количество в диапазоне от 1 до 99
	
	public static String sumNum() 
	{
		String res = "";
		int sum = 0;
		int num = 0;
		for(int i = 1; i < 100; i++)
		{
			if(i%2 == 0) 
				num++;
			
			if(i%2 == 0) 
				sum += i;
		}
		res = Integer.toString(num) + " " + Integer.toString(sum);
		
		return res;
	}
	// Проверить простое ли число
	
	public static char simple(int a) 
	{
		int b = 0;
		char c = ' ';
		if(a < 0)
			throw new IllegalArgumentException();
		if(a >= 0 && a <= 1)
			c = '-';
		
		for(int i = 2; i <= a; i++) 
		{
			if(a%i == 0)
				b++;
		}
		if(b == 1)
			c = '+';
		else 
			c = '-';
		
		return c;
	}
	// Найти корень натурального числа
	
	public static int sqrt(int a)
	{
		if(a < 0)
			throw new IllegalArgumentException();
		int b = 0;
		while(b * b <= a)
			b++;
		b--;
		return b;
	}
	// Найти корень натурального числа методом бинарного поиска
	
	public static int bins(int ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = 0;
		double b = ch;
		double c = (a + b) / 2;
		
		while(c*c - ch > 1 || c*c - ch < 0)
		{
			if(c*c < ch)
				a = c;
			else if(c*c > ch) 
				b = c;
					
			c = (a + b) / 2;
		}
		return (int)c;
	}
	// Вычислить факториал числа
	
	public static int fact(int a)
	{
		if(a < 0)
			throw new IllegalArgumentException();
		if(a == 0)
			return 0;
		int n = 1;
		for(int i = 1; i <= a; i++)
			n *= i;
		return n;
	}
	// Посчитать сумму цифр заданного числа
	
	public static int sum(int a)
	{
		int sum = 0;
		int c = 0;
		while(a != 0)
		{
			c = a % 10;
			sum += c;
			a /= 10;
		}
		return sum;
	}
	// Вывести число, которое является зеркальным отображением
	
	public static int revers(int a)
	{
		int b = 0;
		while(a != 0)
		{
			b = b * 10 + a % 10;
			a /= 10;
		}
		return b;
	}
	
}
