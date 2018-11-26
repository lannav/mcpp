package charAndString;

public class block2 
{
	//целое число в строку
public static String int_to_str(int a)
{
	String rez = "";
	char ch = 48;
if(a == 0)
	rez += ch;

	while(a > 0)
	{
		for(int i = 0; i < a%10; i++)
	ch++;
		
	rez += ch; 
	ch = 48;
	a /= 10;
	}
	char[] mas = rez.toCharArray();
	for(int i = 0; i < mas.length/2; i++)
	{
		char temp = mas[i];
		mas[i] = mas[mas.length - 1 - i];
		mas[mas.length - 1 - i] = temp;
	}
	rez = "";
	for(int i = 0; i < mas.length; i++)
		rez += mas[i];
	return rez;
}
//вещественное число в строку
public static String double_to_str(double a)
{
	if(a == 0)
		return "0";
	int cel = (int)a;
	double drob = a - cel;
	String rez = "";
	char ch = 48;

	while(cel > 0)
	{
		for(int i = 0; i < cel%10; i++)
	ch++;
		
	rez += ch; 
	ch = 48;
	cel /= 10;
	}
	char[] mas = rez.toCharArray();
	for(int i = 0; i < mas.length/2; i++)
	{
		char temp = mas[i];
		mas[i] = mas[mas.length - 1 - i];
		mas[mas.length - 1 - i] = temp;
	}
rez = "";
	
	for(int i = 0; i < mas.length; i++)
		rez += mas[i];
	 if(a < 1)
		 rez = "0";
	
	
	while(drob%1 > 0.0000001)
	{
		drob *= 10;
	}
	String res = "";
	ch = 48;
	
	int dro = (int)drob;
	while(dro > 0)
	{
		for(int i = 0; i < dro%10; i++)
	ch++;
		
	res += ch; 
	ch = 48;
	dro /= 10;
	}
	char[] masDr = res.toCharArray();
	for(int i = 0; i < masDr.length/2; i++)
	{
		char temp = masDr[i];
		masDr[i] = masDr[masDr.length - 1 - i];
		masDr[masDr.length - 1 - i] = temp;
	}
res = "";
	
	for(int i = 0; i < masDr.length; i++)
		res += masDr[i];
	
	String ret = rez+"."+res;
	
	return ret;
}
//строка в целое число
public static int str_to_int (String a)
{
	int res = 0;
	
	char[] mas = a.toCharArray();
	for(int i = 0; i < mas.length; i++)
	{
		res *= 10;
		res += mas[i] - 48;
	}
	
	return res;
}
//строка в вещественное число
public static double str_to_double(String a)
{
	if(a == "0")
		return 0;
	
	double res = 0;
	double rez = 0;
	String[] ar = a.split("\\.");
	char[] mas = ar[0].toCharArray();
	for(int i = 0; i < mas.length; i++)
	{
		res *= 10;
		res += mas[i] - 48;
	}
	mas = ar[1].toCharArray();
	for(int i = mas.length-1; i >= 0; i--)
	{
		rez += mas[i] - 48;
		rez /= 10;
	}
	
	return res+rez;
}

}
