
public class xFile 
{
	public static String znach = "C:/win/tmp/x.exe";
public static String fname(String put)
{
	String[] mas = put.split("/");
	return mas[3];
}

public static String path(String put)
{
	String[] mas = put.split("/");
	return mas[0]+"/" + mas[1]+"/" + mas[2];
}

public static String drive(String put)
{
	String[] mas = put.split("/");
	return " "+mas[0].charAt(0);
}

public static int depth(String put)
{
	String[] mas = put.split("/");
	return mas.length - 2;
}
/*public static void main(String[] args)
{
	System.out.println(depth(znach));
}*/
}
