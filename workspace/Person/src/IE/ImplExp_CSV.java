package IE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import blogic.Person;

public class ImplExp_CSV implements ImplExp
{
	File file = null;
	ArrayList pp = null;
	
	public ImplExp_CSV(File file, ArrayList pp)
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
			for(Object p:pp)
			{
				Field[] fields = p.getClass().getFields();
				for(int i = 0; i < fields.length; i++)
				{
					String type = fields[i].getType().getSimpleName();
					if(type == "int")
						try {
								rs += fields[i].getInt(p) + ",";
							} catch (IllegalArgumentException | IllegalAccessException e) 
								{
									e.printStackTrace();
								}
					else
						try {
							rs += (String)fields[i].get(p) + ",";
						} catch (IllegalArgumentException | IllegalAccessException e) 
							{
								e.printStackTrace();
							}
				}
				rs = rs.substring(0, rs.length()-1);
				rs += "\n";
			}
          bw.write(rs);
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
	}

	@Override
	public ArrayList load() 
	{
		pp = new ArrayList();
		try {
			 BufferedReader bufR = new BufferedReader(new FileReader(file.getPath()));
	         String res = "";
	         String temp = "";
	         if((res += bufR.readLine()) != null)
		         while((temp = bufR.readLine()) != null)
		         {
		        	 res += "\n" + temp;
		         }
			    String[] objects = res.split("\n");
			    for(int i = 0; i < objects.length; i++)
			    {
			    	String[] actualObject = objects[i].split(",");
			    	if(actualObject.length == 4)
			    	{
			    	int id = Integer.parseInt(actualObject[0]);
		    		String fname = actualObject[1];
		    		String lname = actualObject[2];
		    		int age = Integer.parseInt(actualObject[3]);
		    		Person p = new Person(id, fname, lname, age);
		    		pp.add(p);
			    	} else
			    	{
			    		int x = Integer.parseInt(actualObject[1]);
			    		int y = Integer.parseInt(actualObject[2]);
			    		int x2 = Integer.parseInt(actualObject[3]);
			    		int y2 = Integer.parseInt(actualObject[4]);
			    		int color = Integer.parseInt(actualObject[5]);
			    		int width = Integer.parseInt(actualObject[6]);
			    		/*switch(actualObject[0])
				    	{
				    	case "curve": 
				    		PCurve cur = new PCurve(x,y,x2,y2,color,width);
				    		pp.add(cur);
				    		break;
				    	case "line": 
				    		PLine lin = new PLine(x,y,x2,y2,color,width); 
				    		pp.add(lin);
				    		break;         
						case "rectangle": 
							PRect rec = new PRect(x,y,x2,y2,color,width); 
							pp.add(rec);
							break;   
						case "roundRectangle": 
							PRoundRect rre = new PRoundRect(x,y,x2,y2,color,width);
							pp.add(rre);
							break;
						case "oval": 
							POval ova = new POval(x,y,x2,y2,color,width);
							pp.add(ova);
							break;
						default : break;
				    	}*/
			    	}
			    }
       } catch (IOException ex) 
       {
           ex.printStackTrace(System.out);
       }
		return pp;
	}


}
