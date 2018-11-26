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
			return pp;
}
//возраст от 20 до 65
public static void age_20_to_65(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.age >= 20 && p.age <= 65)
			System.out.println(p);
	}
}
//первая и последняя буквы имени и фамилии совпадают
public static void first_and_last(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.toLowerCase().charAt(p.lname.length()-1) == p.lname.toLowerCase().charAt(0))
			if(p.fname.toLowerCase().charAt(p.fname.length()-1) == p.fname.toLowerCase().charAt(0))
			System.out.println(p);
	}
}
//первая буква имени и фамилии малого регистра
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
//фамилия заканчивается на -ин
public static void lname_in(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.endsWith("ин"))
			System.out.println(p);
	}
}
//в середине имени есть буква с
public static void liter_s_in_mid(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.fname.contains("с"))
			System.out.println(p);
	}
}
//длинна фамилии составляет 10 символов
public static void char_10(ArrayList<Person> pp)
{
	for(Person p : pp)
	{
		if(p.lname.length() == 10)
			System.out.println(p);
	}
}
//сортировка по фамилиям в алфавитном порядке
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
//сортировка по возрасту
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
//сортировка по убыванию id
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
