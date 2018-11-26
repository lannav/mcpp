
package DAL;
import java.util.ArrayList;

import blogic.Person;

 public class PersonDAO_Mock implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	public PersonDAO_Mock()
	{
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
	}
	
	public PersonDAO_Mock(ArrayList<Person> pp) 
	{
		this.pp = pp;
	}
	
	@Override
	public void create(Person p) 
	{
		pp.add(p);
	}
	@Override
	public ArrayList<Person> read() 
	{ 
		sort_id(pp);
		return pp;
	}
	@Override
	public void update(Person p) 
	{
		for(Person i : pp)
		{
			if(p.id == i.id)
			{
				i.fname = p.fname;
				i.lname = p.lname;
				i.age   = p.age;
			}
		}
	}
	
	@Override
	public void delete(Person p) 
	{
		Person del = null;
		for(Person i : pp)
			if(p.id == i.id)
				del = i;
				pp.remove(del);
	}
	
	public static void sort_id(ArrayList<Person> pp)
	{
		Person temp = new Person();
		for(int i = pp.size() - 1; i > 0; i--)
			for(int j = 0; j < i; j++)
				if( pp.get(j).id > pp.get(j + 1).id)
				{
					temp = pp.get(j);
					pp.set(j, pp.get(j+1));
					pp.set(j+1, temp);
				}
	}
}
