

public class Person
{
 int id;
 String lname;
 String fname;
 int age;
 public Person() {}
 public Person(int id, String fname, String lname, int age)
 {
this.id = id;
this.lname = lname;
this.fname = fname;
this.age = age;
 }
 @Override
 public String toString()
 {
	 return ""+id+" "+fname+" "+lname+" "+age;
 }
}
