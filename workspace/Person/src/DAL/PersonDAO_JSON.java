package DAL;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import blogic.Person;

public class PersonDAO_JSON implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	@Override
	public void create(Person p) 
	{
		try (JsonWriter writer = new JsonWriter(new FileWriter("E:\\PersonData\\PersonJSON.json",true))) 
		{
            // Начало объекта -> "{"
            writer.beginObject();
            writer.name("id").value(p.id);
            writer.name("fname").value(p.fname);
            writer.name("lname").value(p.lname);
            writer.name("age").value(p.age);
            // Конец объекта -> "}"
            writer.endObject();
        } catch (IOException ex) {
            Logger.getLogger(PersonDAO_JSON.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public ArrayList<Person> read() 
	{
		pp = new ArrayList<Person>();
		try {
            JsonReader reader = new JsonReader(new FileReader("E:\\PersonData\\PersonJSON.json"));
            reader.setLenient(true);
            int id = 0;
        	String fname = "";
        	String lname = "";
        	int age = 0;
            while (true) 
            {
                JsonToken token = reader.peek();
                switch (token) {
                case BEGIN_OBJECT:
                    reader.beginObject();
                    while(reader.hasNext()) 
                    {
                        String name = reader.nextName();
                        switch(name) 
                        {
                            case "id":
                                id = Integer.parseInt(reader.nextString());
                                break;
                            case "fname":
                            	fname = reader.nextString();
                                break;
                            case "lname":
                            	lname = reader.nextString();
                                break;
                            case "age":
                                age = Integer.parseInt(reader.nextString());
                                Person p = new Person(id,fname,lname,age);
                                pp.add(p);
                                break;
                            default:
                                reader.skipValue();
                                break;  
                        }
                    }
                    break;
                case END_OBJECT:
                    reader.endObject();
                    break;
                case END_DOCUMENT:
                	sort_id(pp);
                    return pp;
				default:
					break;
                }
            }
        } catch (FileNotFoundException ex) 
		{
            Logger.getLogger(PersonDAO_JSON.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
		{
            Logger.getLogger(PersonDAO_JSON.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		for(Person i : pp)
			if(p.id == i.id) 
			{
				i.fname = p.fname;
				i.lname = p.lname;
				i.age   = p.age;
			}
		try
		{
			JsonWriter writer = new JsonWriter(new FileWriter("E:\\PersonData\\PersonJSON.json"));
			for(int i = 0; i < pp.size(); i++)
			{
			Person pr = pp.get(i);
			writer.beginObject();
            writer.name("id").value(pr.id);
            writer.name("fname").value(pr.fname);
            writer.name("lname").value(pr.lname);
            writer.name("age").value(pr.age);
            writer.endObject();
            writer.close();
            writer = new JsonWriter(new FileWriter("E:\\PersonData\\PersonJSON.json",true));
			}
        } catch (IOException ex) {
            Logger.getLogger(PersonDAO_JSON.class.getName())
                    .log(Level.SEVERE, null, ex);
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
		try
		{
			JsonWriter writer = new JsonWriter(new FileWriter("E:\\PersonData\\PersonJSON.json"));
			for(int i = 0; i < pp.size(); i++)
			{
			Person pr = pp.get(i);
			writer.beginObject();
            writer.name("id").value(pr.id);
            writer.name("fname").value(pr.fname);
            writer.name("lname").value(pr.lname);
            writer.name("age").value(pr.age);
            writer.endObject();
            writer.close();
            writer = new JsonWriter(new FileWriter("E:\\PersonData\\PersonJSON.json",true));
			}
        } catch (IOException ex) {
            Logger.getLogger(PersonDAO_JSON.class.getName())
                    .log(Level.SEVERE, null, ex);
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
