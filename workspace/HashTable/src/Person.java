
public class Person implements Comparable<Person>
{
	public int id;
	public String fname;
	public String lname;
	public int age;

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
		return id + " " + fname + " " + lname + " " + age;
	}

	@Override
	public int compareTo(Person p) 
	{
		return 0;
	}

	@Override
	public int hashCode()
	{
		return id * id + 1415926535;
	}
	
	public int hashCode(int hash)
	{
		return (int) Math.sqrt(hash - 1415926535);
	}
}
