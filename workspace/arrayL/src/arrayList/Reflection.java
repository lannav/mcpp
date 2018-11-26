package arrayList;

import java.lang.reflect.Field;

public class Reflection 
{
	public static void main(String[] args) throws Exception 
	{
	Person p = new Person();
//	System.out.println(p);
	Field[] fields = p.getClass().getDeclaredFields();
	for(int i = 0; i < fields.length; i++)
	{
		fields[i].setAccessible(true);
		if(i == 0 || i == 3)
		System.out.print(fields[i].getType().getName()+" "+fields[i].getName()+" = "+fields[i].getInt(p)+"\n");
		if(i == 1 || i == 2)
			System.out.print(fields[i].getType().getName()+" "+fields[i].getName()+" = "+(String)fields[i].get(p)+"\n");
	}
//	String a = fields[0].getName();
//	String b = fields[0].getType().getName();
//	System.out.println(a+"\n"+b);
//	fields[1].setAccessible(true);
//	fields[1].set(p, "lol");
//	System.out.println(p);
	}
}
