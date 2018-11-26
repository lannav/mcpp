import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MyClass 
{
public static void main(String[] args)
{
//	int a = 01000;
//	long b = 0x20000000001FFFL;
//	int c = 0b1001;
//	System.out.println(a+"\n"+b+"\n"+c);
//	for(int i = 0; i < 20; i++)
//	{
//	System.out.print(Integer.hashCode(i)+" ");
//	}
	ArrayList<Person> pp = new ArrayList<Person>();
	Person p = new Person(1,"Vasia","Pupkin",14);
	Person p1 = new Person(2,"Masia","Pupkin",19);
	Person p2 = new Person(3,"Sasia","Pupkin",22);
	pp.add(p);
	pp.add(p1);
	pp.add(p2);
	JTable jt = new JTable();
	JOptionPane.showInputDialog(pp);
}
}
