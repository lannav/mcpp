
public class MyClass 
{
public static String rotate(String a)
{
	a = a.replace('\\','/');
	return a;
}
public static void check(String a)
{
	String[] mas = {"#","%","&","*","|","<",">","?","nul","aux","con","com1","lpt1"};
	for(int i = 0; i < mas.length; i++)
	if(a.contains(mas[i]))
		throw new IllegalArgumentException();
	if(a.indexOf(":", 2) != -1)
		throw new IllegalArgumentException();
}
public static String fname(String fpath)
{
	
	fpath = rotate(fpath);
	check(fpath);
	int pos = fpath.lastIndexOf('/');
	String res = fpath.substring(pos+1);
	return res;
}
public static String path(String fpath)
{
	
	fpath = rotate(fpath);
	check(fpath);
	int pos = fpath.lastIndexOf('/');
	if(pos < 0)
		return "";
	String res = fpath.substring(0, pos);
	return res;
}
public static String drive(String fpath)
{
	
	fpath = rotate(fpath);
	check(fpath);
	int pos = fpath.indexOf('/');
	if(pos < 0)
		return "";
	String res = fpath.substring(0, pos-1);
	return res;
}
public static int depth(String fpath)
{
	if(fpath.contains("/"))
	{
	fpath = rotate(fpath);
	check(fpath);
	String[] mas = fpath.split("/");
	if(mas.length < 2)
		return 0;
	return mas.length - 2;
	}
	else 
		throw new IllegalArgumentException();
	
	
}
}
