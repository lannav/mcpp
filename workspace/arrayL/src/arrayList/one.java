package arrayList;
import java.util.ArrayList;
public class one 
{
public static void main(String[] args)
{
//	ArrayList<Person> pp = init();
	
//	print( pp );
	//age_20_to_65(pp);
	//first_and_last(pp);
	//first_and_last_mal(pp);
	//id_equal_age(pp);
	//lname_in(pp);
	//liter_s_in_mid(pp);
	//char_10(pp);
	//sort_lname(pp);
	//sort_age(pp);
	//sort_id(pp);
	//sort_lname(pp);
	
}
public static void print(ArrayList<Person> pp)
{
for(Person p : pp)
{
	System.out.println( p );
}
}
/*public static ArrayList<Person> init()
{
	ArrayList<Person> pp = new ArrayList<Person>();
			pp.add( new Person(9, "�������", "����",52 ));
			pp.add( new Person(8, "������", "�������",36 ));
			pp.add( new Person(5, "������", "��������",35 ));
			pp.add( new Person(19, "��������", "�������",21 ));
			pp.add( new Person(7, "����������", "�������",20 ));
			pp.add( new Person(25, "�������", "��������",15 ));
			pp.add( new Person(6, "������", "��������",40 ));
			pp.add( new Person(3, "�����", "��������",41 ));
			pp.add( new Person(2, "�������", "����������",31 ));
			pp.add( new Person(1, "���������", "�����",32 ));
			pp.add( new Person(11, "����������", "�������",29 ));
			pp.add( new Person(13, "��������", "�����",27 ));
			pp.add( new Person(16, "���������", "�����",26 ));
			pp.add( new Person(75, "����������", "�������",55 ));
			pp.add( new Person(86, "������", "������",11 ));
			pp.add( new Person(50, "��������", "����",50 ));
			pp.add( new Person(63, "���������", "����������",48 ));
			pp.add( new Person(36, "��������", "������",18 ));
			pp.add( new Person(75, "��������", "�����",19 ));
			pp.add( new Person(25, "�������", "������",33 ));
			pp.add( new Person(72, "������", "������",32 ));
			pp.add( new Person(44, "������", "�����",31 ));
			pp.add( new Person(32, "������", "������",34 ));
			pp.add( new Person(33, "���������", "���������",35 ));
			pp.add( new Person(21, "�������", "������",36 ));
			pp.add( new Person(17, "��������", "�����",38 ));
			pp.add( new Person(10, "��������", "�����",39 ));
			pp.add( new Person(26, "��������", "���������",59 ));
			pp.add( new Person(28, "����������", "�����",58 ));
			pp.add( new Person(34, "����������", "����",57 ));
			pp.add( new Person(38, "�������", "��������",56 ));
			pp.add( new Person(55, "���������", "�����",55 ));
			pp.add( new Person(46, "�����������", "��������",54 ));
			pp.add( new Person(45, "���������", "��������",42 ));
			pp.add( new Person(40, "���������", "����",43 ));
			pp.add( new Person(60, "���������", "������",44 ));
			pp.add( new Person(66, "�������", "������",47 ));
			pp.add( new Person(63, "�����", "�����",49 ));
			pp.add( new Person(78, "�������", "����",31 ));
			pp.add( new Person(99, "�������", "������",30 ));
			return pp;
}
//������� �� 20 �� 65
public static void age_20_to_65(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.age >= 20 && p.age <= 65)
			System.out.println(p);
	}
}
//������ � ��������� ����� ����� � ������� ���������
public static void first_and_last(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.toLowerCase().charAt(p.lname.length()-1) == p.lname.toLowerCase().charAt(0))
			if(p.fname.toLowerCase().charAt(p.fname.length()-1) == p.fname.toLowerCase().charAt(0))
			System.out.println(p);
	}
}
//������ ����� ����� � ������� ������ ��������
public static void first_and_last_mal(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.toLowerCase().charAt(0) == p.lname.charAt(0))
			if(p.fname.toLowerCase().charAt(0) == p.fname.charAt(0))
			System.out.println(p);
	}
}
//id=age
public static void id_equal_age(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.age == p.id)
			System.out.println(p);
	}
}
//������� ������������� �� -��
public static void lname_in(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.endsWith("��"))
			System.out.println(p);
	}
}
//� �������� ����� ���� ����� �
public static void liter_s_in_mid(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.fname.contains("�"))
			System.out.println(p);
	}
}
//������ ������� ���������� 10 ��������
public static void char_10(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.length() == 10)
			System.out.println(p);
	}
}
//���������� �� �������� � ���������� �������
public static void sort_lname(ArrayList<Person> pp)
{
	Person temp = new Person();
	
	for(int i = pp.size() - 1; i > 0; i--)
		for(int j = 0; j < i; j++)
			if( pp.get(j).lname.toLowerCase().charAt(0) > pp.get(j + 1).lname.toLowerCase().charAt(0))
			{
				temp = pp.get(j);
				pp.set(j, pp.get(j+1));
				pp.set(j+1, temp);
			}
	
	int mLen = pp.get(0).lname.length();
	
	for(int i = pp.size() - 1; i > 0; i--)
			if( pp.get(i).lname.length() < mLen)
				mLen = pp.get(i).lname.length();

			for(int z = 0; z < mLen - 1; z++)
	for(int i = pp.size() - 1; i > 0; i--)
		for(int j = 0; j < i; j++)
			if( pp.get(j).lname.toLowerCase().charAt(z) == pp.get(j + 1).lname.toLowerCase().charAt(z))
				if( pp.get(j).lname.toLowerCase().charAt(z+1) > pp.get(j + 1).lname.toLowerCase().charAt(z+1))
				{
					temp = pp.get(j);
					pp.set(j, pp.get(j+1));
					pp.set(j+1, temp);
				}
	
	for(Person p:pp)
		System.out.println(p);
}
//���������� �� ��������
public static void sort_age(ArrayList<Person> pp)
{
	Person temp = new Person();
	for(int i = pp.size() - 1; i > 0; i--)
		for(int j = 0; j < i; j++)
			if( pp.get(j).age > pp.get(j + 1).age)
			{
				temp = pp.get(j);
				pp.set(j, pp.get(j+1));
				pp.set(j+1, temp);
			}
	for(Person p:pp)
		System.out.println(p);
	
}
//���������� �� �������� id
public static void sort_id(ArrayList<Person> pp)
{
	Person temp = new Person();
	for(int i = pp.size() - 1; i > 0; i--)
		for(int j = 0; j < i; j++)
			if( pp.get(j).id < pp.get(j + 1).id)
			{
				temp = pp.get(j);
				pp.set(j, pp.get(j+1));
				pp.set(j+1, temp);
			}
	for(Person p:pp)
		System.out.println(p);
}*/
}
