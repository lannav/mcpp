package hwConv;

public class four 
{
	// Карат
	public static double kar(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch*5;
		
		return a;
	}
	// Гран
		public static double grn(double ch)
		{
			if(ch < 0)
				throw new IllegalArgumentException();
			double a = ch*15.43;
			
			return a;
		}
		// Драхма
		public static double drh(double ch)
		{
			if(ch < 0)
				throw new IllegalArgumentException();
			double a = ch*0.5644;
			
			return a;
		}
		// Унция
		public static double unc(double ch)
		{
			if(ch < 0)
				throw new IllegalArgumentException();
			double a = ch*0.03527;
			
			return a;
		}
		// Майт
		public static double myt(double ch)
		{
			if(ch < 0)
				throw new IllegalArgumentException();
			double a = ch*308.6;
			
			return a;
		}
	
}
