package hwConv;
public class two 
{
	// �����
	public static double pletr(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/31;
		
		return a;
	}
	// ������� ����
	public static double mrMile(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/1852;
		
		return a;
	}
	// ������ �������������
	public static double stad(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/185;
		
		return a;
	}
	// �������
	public static double furl(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/201.16;
		
		return a;
	}
	//����
	public static double cheyn(double ch)
	{
		if(ch < 0)
			throw new IllegalArgumentException();
		double a = ch/20.1168;
		
		return a;
	}

}
