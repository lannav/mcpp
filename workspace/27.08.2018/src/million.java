import javax.swing.*;
public class million 
{
	public static String func(long ch)
	{
		if(ch < 0)
			ch = -1*ch;
	String [] ed = {""," один"," два"," три"," четыре"," пять"," шесть"," семь"," восемь"," девять"};
	String [] ds = {""," десять"," двадцать"," тридцать"," сорок"," пятьдесят"," шестьдесят"," семьдесят"," восемьдесят"," девяносто"};
	String [] st = {""," сто"," двести"," триста"," четыреста"," пятьсот"," шестьсот"," семьсот"," восемьсот"," девятьсот"};
	String [] ot = {" одинадцать"," двенадцать"};
	String res = "";
	long a = ch/100;
	long b = ch%100/10;
	long c = ch%10;
	if(ch%100 == 11)
	res = st[(int)a]+ot[0];
	else if(ch%100 == 12)
	res = st[(int)a]+ot[1];
	else if(ch == 0)
	res = "";
	else
	res = st[(int)a]+ds[(int)b]+ed[(int)c];
	
	return res;
	}
	public static String funcTus(long ch)
	{
		if(ch < 0)
			ch = -1*ch;
	String [] ed = {""," одна"," две"," три"," четыре"," пять"," шесть"," семь"," восемь"," девять"};
	String [] ds = {""," десять"," двадцать"," тридцать"," сорок"," пятьдесят"," шестьдесят"," семьдесят"," восемьдесят"," девяносто"};
	String [] st = {""," сто"," двести"," триста"," четыреста"," пятьсот"," шестьсот"," семьсот"," восемьсот"," девятьсот"};
	String [] ot = {" одинадцать"," двенадцать"};
	String res = "";
	long a = ch/100;
	long b = ch%100/10;
	long c = ch%10;
	if(ch%100 == 11)
	res = st[(int)a]+ot[0];
	else if(ch%100 == 12)
	res = st[(int)a]+ot[1];
	else if(ch == 0)
	res = "";
	else
	res = st[(int)a]+ds[(int)b]+ed[(int)c];
	
	return res;
	}
	public static String fxz(long ch)
	{
		String res = "";
		long mrd = ch/1000000000;
		long mil = ch%1000000000/1000000;
		long tus = ch%1000000/1000;
		String [] mas = {"ноль"," миллиард"," миллиардов"," миллиардa"," миллион"," миллионов"," миллиона"," тысяча"," тысяч"," тысячи","минус"};
		
		//-------------------------------------------------------------
		
		if(ch < 0)
			res += mas[10];
		if(ch == 0)
			res = mas[0];
		else
		{
		if(mrd == 0)
			res += "";
		else if(mrd%100 == 11 || mrd%100 == 12)
			res += func(ch/1000000000) + mas[2];
		else if(mrd%10 == 1)
			res += func(ch/1000000000) + mas[1];
		else if(mrd%10 > 1 && mrd%10 < 5)
			res += func(ch/1000000000) + mas[3];
		else res += func(ch/1000000000) + mas[2];
		
		//----------------------------------------------------------------
		
		if(mil == 0)
			res += "";
		else if(mil%100 == 11 || mil%100 == 12)
			res += func(ch%1000000000/1000000) + mas[5];
		else if(mil%10 == 1)
			res += func(ch%1000000000/1000000) + mas[4];
		else if(mil%10 > 1 && mil%10 < 5)
			res += func(ch%1000000000/1000000) + mas[6];
		else res += func(ch%1000000000/1000000) + mas[5];
		
		//----------------------------------------------------------------
		
		if(tus == 0)
			res += "";
		else if(tus%100 == 11 || tus%100 == 12)
			res += funcTus(ch%1000000/1000) + mas[8];
		else if(tus%10 == 1)
			res += funcTus(ch%1000000/1000) + mas[7];
		else if(tus%10 > 1 && tus%10 < 5)
			res += funcTus(ch%1000000/1000) + mas[9];
		else res += funcTus(ch%1000000/1000) + mas[8];
		
		//----------------------------------------------------------------
		
		res += func(ch%1000);
		}
		return res;
	}
	public static void main(String[] args) 
	{
		String a = JOptionPane.showInputDialog("Введите число");
		long b = Long.parseLong(a);
		String res = fxz(b);
		JOptionPane.showMessageDialog(null, "Вы ввели "+res);
	}
}
