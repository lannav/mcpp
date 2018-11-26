package uslovnieOperatori;

// Если а – четное посчитать а*б, иначе а+б

public class operat 
{
	public static int chetNech(int a, int b) 
	{
		int c;
		if(a % 2 == 0)
			c = a * b;
		else
			c = a + b; 
		
		return c;
	} 
	// Определить какой четверти принадлежит точка с координатами (х,у)
	
	public static int quatter(int x, int y)
	{
	int res = 0;
	if(x < 0 && y > 0)
		res = 1;
	else if(x > 0 && y > 0)
		res = 2;
	else if(x > 0 && y <0)
		res = 3;
	else if(x < 0 && y < 0)
		res = 4;
	else if(x == 0 || y == 0 )
		throw new IllegalArgumentException();
	
	return res;
	}
	// Найти суммы только положительных из трех чисел
	
	public static int sumPos(int a, int b, int c)
	{
	int sum = 0;
	if(a > 0)
		sum += a;
	if(b > 0)
		sum += b;
	if(c > 0)
		sum += c;
	
	return sum;
	}
	// Посчитать выражение (макс(а*б*с, а+б+с))+3
	
	public static int max(int a, int b, int c) 
	{
		int res;
		if(a*b*c >= a+b+c)
				res = a*b*c + 3;
			else res = a+b+c+3;
		
		return res;
	}
	// Написать программу определения оценки студента по его рейтингу
	
	public static char mark(int oc)
	{
		char a = ' ';
		if(oc < 0 || oc > 100)
			throw new IllegalArgumentException();
		if(oc >= 0 && oc <= 19)
			a = 'F';
		else if(oc >= 20 && oc <= 39)
			a = 'E';
		else if(oc >= 40 && oc <= 59)
			a = 'D';
		else if(oc >= 60 && oc <= 74)
			a = 'C';
		else if(oc >= 75 && oc <= 89)
			a = 'B';
		else if(oc >= 90 && oc <= 100)
			a = 'A';
	
		return a;
	}
}
