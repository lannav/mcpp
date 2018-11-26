package libraryMath;
public class function 
{
	public static double rastRad(double a, double b)
	{
		a = a*10/36;
		if(a < 0 || b > 3.1415926535/2 || b < 0)
			throw new IllegalArgumentException();
		double s = (a*a*Math.sin(2*b))/9.81;
		return s;
	}
	public static double rastGrad(double a, double b)
	{
		a = a*10/36;
		b = b*3.1415926535/180;
		if(a < 0 || b > 3.1415926535/2 || b < 0)
			throw new IllegalArgumentException();
		double s = (a*a*Math.sin(2*b))/9.81;
		return s;
	}
	public static int rast(int v1, int v2, int s, int t)
	{
		if(v1 < 0 || v2 < 0 || s < 0 || t < 0)
			throw new IllegalArgumentException();
		
		int res = s + v1*t + v2*t;
		return res;
	}
	public static double uravn(double x)
	{
		double z = (6*Math.log(Math.sqrt(Math.exp(x+1)+2*Math.exp(x)*Math.cos(Math.toRadians(x)))))/(Math.log(x-Math.exp(x+1)*Math.sin(Math.toRadians(x))))+Math.abs(Math.cos(Math.toRadians(x))/Math.exp(Math.sin(Math.toRadians(x))));
		return z;
	}
	public static void main(String[] args)
	{
		double a = uravn(0);
		System.out.println(a);
	}
}
