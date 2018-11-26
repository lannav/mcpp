package IE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import blogic.Person;

public class ImplExp_YAML implements ImplExp
{
	File file = null;
	ArrayList<Person> pp = null;
	
	public ImplExp_YAML(File file, ArrayList<Person> pp)
	{
		this.file = file;
		this.pp = pp;
	}

	@Override
	public void save() 
	{
		 try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
	        {
			 String rs = "persons:\n";
				for(Person p:pp)
				{
					rs += " - person:\n" + "\tid: " + p.id + "\n" + "\tfname: " + p.fname + "\n" + "\tlname: " + p.lname
							+ "\n" + "\tage: " + p.age + "\n";
				}
	          bw.write(rs);
	        }
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        } 
	}

	@Override
	public ArrayList<Person> load() 
	{
		pp = new ArrayList<Person>();
		try {
			 BufferedReader bufR = new BufferedReader(new FileReader(file.getPath()));
	         String res = "";
	         String temp = "";
	         if((res += bufR.readLine()) != null)
		         while((temp = bufR.readLine()) != null)
		         {
		        	 res += "\n" + temp;
		         }
	         	res = res.substring(9, res.length());
			    String[] persons = res.split(" - person:");
			    for(int i = 1; i < persons.length; i++)
			    {
			    	String[] actualPerson = persons[i].split("\n");
			    	int id = Integer.parseInt(actualPerson[1].substring(5,actualPerson[1].length()));
		    		String fname = actualPerson[2].substring(8,actualPerson[2].length());
		    		String lname = actualPerson[3].substring(8,actualPerson[3].length());
		    		int age = Integer.parseInt(actualPerson[4].substring(6,actualPerson[4].length()));
		    		Person p = new Person(id, fname, lname, age);
		    		pp.add(p);
			    }
       } catch (IOException ex) 
       {
           ex.printStackTrace(System.out);
       }
		return pp;
	}

}
