package hwConv;

public class one 
{
	// Фаренгейт
	public static double far(double ch)
	{
		if(ch < -273.0)
			throw new IllegalArgumentException();
		double a = ch*9/5 + 32;
		
		return a;
	}
	// Кельвин
	public static double kel(double ch)
	{
		if(ch < -273.0)
			throw new IllegalArgumentException();
		double a = ch + 273;
		
		return a;
	}
	// Делиль
	public static double delil(double ch)
	{
		if(ch < -273.0)
			throw new IllegalArgumentException();
		double a = -(ch - 100)*3/2;
		
		return a;
	}
	// Реомюр
	public static double reomur(double ch)
	{
		if(ch < -273.0)
			throw new IllegalArgumentException();
		double a = ch*4/5;
		
		return a;
	}
	
}
