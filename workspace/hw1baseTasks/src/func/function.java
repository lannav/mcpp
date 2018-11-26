package func;

public class function 
{
	// �������� ��������� �������� ��� ������ �� ������ ���.
	
	public static String week(int a)
	{
		if(a < 1 || a > 7)
			throw new IllegalArgumentException();
		
		String[] b = {"","�����������", "�������","�����","�������","�������","�������","�����������"};
		
		return b[a];
	}
	// ������ �����(0-999 ����������), �������� ������ � �������� �����
	
	public static String func(long ch)
	{
		if(ch < 0)
			ch = -1*ch;
	String [] ed = {""," ����"," ���"," ���"," ������"," ����"," �����"," ����"," ������"," ������"};
	String [] ds = {""," ������"," ��������"," ��������"," �����"," ���������"," ����������"," ���������"," �����������"," ���������"};
	String [] st = {""," ���"," ������"," ������"," ���������"," �������"," ��������"," �������"," ���������"," ���������"};
	String [] ot = {" ����������"," ����������"};
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
	String [] ed = {""," ����"," ���"," ���"," ������"," ����"," �����"," ����"," ������"," ������"};
	String [] ds = {""," ������"," ��������"," ��������"," �����"," ���������"," ����������"," ���������"," �����������"," ���������"};
	String [] st = {""," ���"," ������"," ������"," ���������"," �������"," ��������"," �������"," ���������"," ���������"};
	String [] ot = {" ����������"," ����������"};
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
		String [] mas = {"����"," ��������"," ����������"," ��������a"," �������"," ���������"," ��������"," ������"," �����"," ������","�����"};
		
		//-------------------------------------------------------------
		
		if(ch < 0 || ch > 999999999999L)
			throw new IllegalArgumentException();
		//	res += mas[10];
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
	// ����� ���������� ����� ����� ������� � ��������� ���������� ������������
	
	public static double rast(int[] a, int[] b)
	{
		double c = Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]));
		return c;
	}
	// ������ ������, ������� �������� �����, ���������� �������� (0-999). �������� ���� �����
	
	public static long stroka(String ch)
	{
		String [] ed = {"","����","���","���","������","����","�����","����","������","������","","����������","����������"};
		String [] ds = {"","������","��������","��������","�����","���������","����������","���������","�����������","���������"};
		String [] st = {"","���","������","������","���������","�������","��������","�������","���������","���������"};
		
		long rez = 0;
		String[] parts = ch.split(" ");
		
		for(int i = 0; i < parts.length; i++)
		{	
			if(parts[i].equals("����"))
				rez += 1;
			if(parts[i].equals("���"))
				rez += 2;
			
			for(int j = 0; j < ed.length; j++ )
				if(parts[i].equals(ed[j]))
					rez += j;
			
			for(int j = 0; j < ds.length; j++ )
				if(parts[i].equals(ds[j]))
					rez += j*10;
			
			for(int j = 0; j < st.length; j++ )
				if(parts[i].equals(st[j]))
					rez += j*100;
			
			if(parts[i].equals("��������") || parts[i].equals("����������") || parts[i].equals("���������"))
			{
				if(parts.length <= 4)
					rez *= 1000000000;
				rez *=1000;
			}
			
			if(parts[i].equals("�������") || parts[i].equals("���������") || parts[i].equals("��������"))
			{
				if(parts.length <= 4)
					rez *= 1000000;
				rez *=1000;
			}
			
			if(parts[i].equals("������") || parts[i].equals("�����") || parts[i].equals("������"))
						rez *=1000;
		}
		
				return rez;
	}
}
