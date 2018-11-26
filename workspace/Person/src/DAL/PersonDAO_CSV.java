package DAL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_CSV implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	File file = new File("E:\\PersonData\\PersonCSV.csv");

	@Override
	public void create(Person p)
	{
		try {
			String res = "";
			if(read().size() == 0)
				res = p.id+","+p.fname+","+p.lname+","+p.age;
			else
				res = "\n"+p.id+","+p.fname+","+p.lname+","+p.age;
			
		FileWriter writer = new FileWriter(file,true); 
	      writer.write(res); 
	      writer.flush();
	      writer.close();
		}catch(IOException e)
		{
			System.out.print("Exception");
		}
	}

	@SuppressWarnings("resource")
	@Override
	public ArrayList<Person> read() 
	{
		pp = new ArrayList<Person>();
		
		try {
	         InputStream input = new FileInputStream(file);
	         int size = input.available();
	         if(size == 0)
	        	 return pp;
	         String res = "";
		         for(int j = 0; j < size; j++) 
		         {
		            res += (char)input.read();
		         }
		         input.close();
		         String[] tb = res.split("\n");
		         for(int i = 0; i < tb.length; i++)
		         {
		        	String[] row = tb[i].split(",");
		        		Person p = new Person(Integer.parseInt(row[0]),row[1],row[2],Integer.parseInt(row[3]));
			        	pp.add(p);
		         }
		         sort_id(pp);
			}catch(IOException e) 
			  {
		         System.out.print("Exception");
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
			
					try {
						FileWriter writer = new FileWriter(file); 
						
						for(int i = 0; i < pp.size(); i++)
						{
							Person pr = pp.get(i);
							
						String res = "";
						if(i == 0)
							res = pr.id+","+pr.fname+","+pr.lname+","+pr.age;
						else
							res = "\n"+pr.id+","+pr.fname+","+pr.lname+","+pr.age;
					
				      writer.write(res); 
						}
						 writer.flush();
					      writer.close();
					}catch(IOException e)
					{
						System.out.print("Exception");
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
				
				try {
					FileWriter writer = new FileWriter(file); 
					
					for(int i = 0; i < pp.size(); i++)
					{
						Person pr = pp.get(i);
						
					String res = "";
					if(i == 0)
						res = pr.id+","+pr.fname+","+pr.lname+","+pr.age;
					else
						res = "\n"+pr.id+","+pr.fname+","+pr.lname+","+pr.age;
				
			      writer.write(res); 
					}
					 writer.flush();
				      writer.close();
				}catch(IOException e)
				{
					System.out.print("Exception");
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
