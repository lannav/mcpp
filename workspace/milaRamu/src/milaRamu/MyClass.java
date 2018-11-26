package milaRamu;

import java.io.*;
import java.util.Arrays;

public class MyClass {
    /*public static void main(String[] args) throws IOException {
        File f = new File("E:\\eclipse\\PersonCSV.csv");
        FileReader in = new FileReader(f);
        char[] arr = new char[(int)f.length()];
        in.close();
        System.out.println(arr);
    }*/
    public static void main(String[] args) 
    {
    	try {
	         File PersonCSV = new File("E:\\eclipse\\PersonCSV.csv");
	         FileReader fileR = new FileReader(PersonCSV);
	         char[] mas = new char[(int)PersonCSV.length()];
	         fileR.read(mas);
	          fileR.close();
	          String res = mas.toString();
		         String[] tb = res.split("\n");
		         System.out.print(Arrays.toString(mas));
    	}catch(IOException e)
    	{
    		System.out.println("Exception");
    	}
	         /*String res = "";
		         for(int j = 0; j < size; j++) 
		         {
		            res += (char)input.read();
		         }
		         input.close();
		         String[] tb = res.split("\n");
		         
		         String[] row = tb[1].split(",");
		         int id = Integer.parseInt(row[0]);
		         String fname = row[1];
		         String lname = row[2];
		         int age = Integer.parseInt(row[3].substring(0, row[3].length() - 1));
		         
		        
		         System.out.print(id+"\n"+fname+"\n"+lname+"\n"+age);
		    
	      }catch(IOException e) 
			  {
		         System.out.print("Exception");
		      }*/
    }
}
