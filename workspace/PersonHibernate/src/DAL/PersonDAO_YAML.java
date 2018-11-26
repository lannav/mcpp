package DAL;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;

import blogic.Person;

public class PersonDAO_YAML implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	@Override
	public void create(Person p) 
	{
		Yaml yaml = new Yaml();
		pp = new ArrayList<Person>();
		pp.add(p);
		try {
			FileWriter output = new FileWriter("E:\\PersonData\\PersonYAML.yaml",true);

			// пишу свой объект в файл
			yaml.dump(pp, output);
			output.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		pp = new ArrayList<Person>();
		Yaml yaml = new Yaml();
		try {
			FileReader reader = new FileReader("E:\\PersonData\\PersonYAML.yaml");
            pp = (ArrayList<Person>) yaml.load(reader);
			reader.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
		sort_id(pp);
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		pp = new ArrayList<Person>();
		Yaml yaml = new Yaml();
		try {
			FileReader reader = new FileReader("E:\\PersonData\\PersonYAML.yaml");
            pp = (ArrayList<Person>) yaml.load(reader);
			reader.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
		for(Person i : pp)
		{
			if(p.id == i.id)
			{
				i.fname = p.fname;
				i.lname = p.lname;
				i.age   = p.age;
			}
		}
		try {
			FileWriter output = new FileWriter("E:\\PersonData\\PersonYAML.yaml");

			// пишу свой объект в файл
			yaml.dump(pp, output);
			output.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) 
	{
		pp = new ArrayList<Person>();
		Yaml yaml = new Yaml();
		try {
			FileReader reader = new FileReader("E:\\PersonData\\PersonYAML.yaml");
            pp = (ArrayList<Person>) yaml.load(reader);
			reader.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
		Person del = null;
		for(Person i : pp)
			if(p.id == i.id)
				del = i;
				pp.remove(del);
		try {
			FileWriter output = new FileWriter("E:\\PersonData\\PersonYAML.yaml");

			// пишу свой объект в файл
			yaml.dump(pp, output);
			output.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
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
