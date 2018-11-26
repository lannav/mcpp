package hwConv;
public class two 
{
	// Плетр
	public static double pletr(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/31;
		
		return a;
	}
	// Морская миля
	public static double mrMile(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/1852;
		
		return a;
	}
	// Стадий птолемеевский
	public static double stad(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/185;
		
		return a;
	}
	// Фурлонг
	public static double furl(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/201.16;
		
		return a;
	}
	//Чейн
	public static double cheyn(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/20.1168;
		
		return a;
	}

}
