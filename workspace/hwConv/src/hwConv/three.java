package hwConv;
public class three 
{
	// �����
	public static double gil(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch*7.039;
		
		return a;
	}
	// �����
	public static double pin(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch*1.76;
		
		return a;
	}
	// ������
	public static double kva(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch*0.88;
		
		return a;
	}
	// ������
	public static double gal(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch*0.22;
		
		return a;
	}
	// �������
	public static double bar(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch*0.006;
		
		return a;
	}

}
