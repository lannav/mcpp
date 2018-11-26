package arrayList;

class Person
{
 public int id = 1;
 public String lname = "Vasia";
 public String fname = "Pupkin";
 public int age = 5;
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
