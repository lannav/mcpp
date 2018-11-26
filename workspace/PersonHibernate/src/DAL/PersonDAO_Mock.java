package DAL;
import java.util.ArrayList;

import blogic.Person;

 public class PersonDAO_Mock implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	public PersonDAO_Mock()
	{
		pp.add( new Person(9, "Сонникс", "Анна",52 ));
		pp.add( new Person(8, "Гужова", "Людмила",36 ));
		pp.add( new Person(5, "Ивашко", "Анатолий",35 ));
		pp.add( new Person(19, "Бродский", "Василий",21 ));
		pp.add( new Person(7, "булочников", "евгений",20 ));
		pp.add( new Person(25, "Голиков", "Владимир",15 ));
		pp.add( new Person(6, "Осипов", "Геннадий",40 ));
		pp.add( new Person(3, "Санин", "Валентин",41 ));
		pp.add( new Person(2, "Майоров", "Константин",31 ));
		pp.add( new Person(1, "Буряченко", "Борис",32 ));
		pp.add( new Person(11, "Бабовников", "Дмитрий",29 ));
		pp.add( new Person(13, "Баздырев", "Антон",27 ));
		pp.add( new Person(16, "Белоножко", "Давид",26 ));
		pp.add( new Person(75, "Бесчастнов", "Дмитрий",55 ));
		pp.add( new Person(86, "Васина", "Марина",11 ));
		pp.add( new Person(50, "Георгиян", "Олег",50 ));
		pp.add( new Person(63, "Давиденко", "Константин",48 ));
		pp.add( new Person(36, "Денискин", "Сергей",18 ));
		pp.add( new Person(75, "Журавлев", "Павел",19 ));
		pp.add( new Person(25, "Закиров", "Руслан",33 ));
		pp.add( new Person(72, "Иванов", "Михаил",32 ));
		pp.add( new Person(44, "Иванов", "Антон",31 ));
		pp.add( new Person(32, "Котляр", "Сергей",34 ));
		pp.add( new Person(33, "Кочемасов", "Александр",35 ));
		pp.add( new Person(21, "Кривцов", "Андрей",36 ));
		pp.add( new Person(17, "Литвяков", "Денис",38 ));
		pp.add( new Person(10, "Мокриков", "Артем",39 ));
		pp.add( new Person(26, "Моргунов", "Александр",59 ));
		pp.add( new Person(28, "Насибулина", "Жанна",58 ));
		pp.add( new Person(34, "Новокшанов", "Юрий",57 ));
		pp.add( new Person(38, "Поляков", "Владимир",56 ));
		pp.add( new Person(55, "Савельева", "Алена",55 ));
		pp.add( new Person(46, "Соколовский", "Анатолий",54 ));
		pp.add( new Person(45, "Тарасенко", "Антонина",42 ));
		pp.add( new Person(40, "Трофимова", "Анна",43 ));
		pp.add( new Person(60, "Узловский", "Андрей",44 ));
		pp.add( new Person(66, "Халимон", "Виктор",47 ));
		pp.add( new Person(63, "Штуко", "Антон",49 ));
		pp.add( new Person(78, "Крючков", "Иван",31 ));
		pp.add( new Person(99, "Ермолин", "Виктор",30 ));
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