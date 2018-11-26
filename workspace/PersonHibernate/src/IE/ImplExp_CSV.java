package IE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import blogic.Person;

public class ImplExp_CSV implements ImplExp
{
	File file = null;
	ArrayList<Person> pp = null;
	
	public ImplExp_CSV(File file, ArrayList<Person> pp)
	{
		this.file = file;
		this.pp = pp;
	}

	@Override
	public void save() 
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
		 String rs = "";
			for(Person p:pp)
			{
				rs += p.id+","+p.fname+","+p.lname+","+p.age+"\n";
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
			    String[] persons = res.split("\n");
			    for(int i = 0; i < persons.length; i++)
			    {
			    	String[] actualPerson = persons[i].split(",");
			    	int id = Integer.parseInt(actualPerson[0]);
		    		String fname = actualPerson[1];
		    		String lname = actualPerson[2];
		    		int age = Integer.parseInt(actualPerson[3]);
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
