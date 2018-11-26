package arrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBPerson
{

	public static void main(String[] args)
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		pp.add( new Person(1, "Naveen", "Andrews",52 ));
		pp.add( new Person(2, "Emilie", "Ravin",36 ));
		pp.add( new Person(3, "Matthew", "Fox",35 ));
		pp.add( new Person(4, "Jorge", "Garcia",21 ));
		pp.add( new Person(5, "Maggie ", "Grace",20 ));
		pp.add( new Person(6, "Josh", "Holloway",15 ));
		pp.add( new Person(7, "Malcolm ", "Kelley",40 ));
		pp.add( new Person(8, "Daniel", "Kim",41 ));
		pp.add( new Person(9, "Yunjin", "Kim",31 ));
		pp.add( new Person(10, "Evangeline", "Lilly",32 ));
		pp.add( new Person(11, "Dominic", "Monaghan",29 ));
		pp.add( new Person(12, "Terry", "Quinn",27 ));
		pp.add( new Person(13, "Harold", "Perrineau",26 ));
		pp.add( new Person(14, "Ian", "Somerhalder",55 ));
		pp.add( new Person(15, "Michelle", "Rodriguez",11 ));
		pp.add( new Person(16, "Adewale", "Agbaje",50 ));
		pp.add( new Person(17, "Cynthia", "Watros",48 ));
		pp.add( new Person(18, "Henry", "Cusick",18 ));
		pp.add( new Person(19, "Michael", "Emerson",19 ));
		pp.add( new Person(20, "Elizabeth", "Mitchell",33 ));
		pp.add( new Person(21, "Kiele", "Sanchez",32 ));
		pp.add( new Person(22, "Rodrigo", "Santoro",31 ));
		pp.add( new Person(23, "Nestor", "Carbonell",34 ));
		pp.add( new Person(24, "Jeremy", "Davies",35 ));
		pp.add( new Person(25, "Ken", "Leung",36 ));
		pp.add( new Person(26, "Rebecca", "Mader",38 ));
		pp.add( new Person(27, "Jeff", "Fahey",39 ));
		pp.add( new Person(28, "Zuleikha", "Robinson",59 ));
		pp.add( new Person(29, "Michelle", "Arthur",58 ));
		pp.add( new Person(30, "Ron", "Bottitta",57 ));
		pp.add( new Person(31, "William", "Blanchette",56 ));
		pp.add( new Person(32, "Julie", "Bowen",55 ));
		pp.add( new Person(33, "Wendy", "Braun",54 ));
		pp.add( new Person(34, "Beth", "Broderick",42 ));
		pp.add( new Person(35, "Scott", "Caldwell",43 ));
		pp.add( new Person(36, "Byron", "Chung",44 ));
		pp.add( new Person(37, "Jon", "Dixon",47 ));
		pp.add( new Person(38, "Mira", "Furlan",49 ));
		pp.add( new Person(39, "Robert", "Frederick",31 ));
		pp.add( new Person(40, "Andrea", "Gabriel",30 ));
		
		
		print(pp);
	}
	
	public static ArrayList<Person> initFromDB()
	{
		ArrayList<Person> pp = new ArrayList<Person>();

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu", "root", "");
			Statement stmn = (Statement) con.createStatement();
			ResultSet rs = stmn.executeQuery("select * from person");

			while(rs.next())
			{
				pp.add(new Person(rs.getInt(1), rs.getString("fname"), rs.getString("lname"), rs.getInt(4)));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
		return pp;
	}
	
	public static void create(Person p) 
	{
		String arg = "INSERT INTO person (id, fname, lname, age) \n" +
	               " VALUES ("+p.id+", '"+p.fname+"', '"+p.lname+"', "+p.age+");";

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(arg);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void print(ArrayList<Person> pp)
	{
		String str = "jdbc:mysql://192.168.1.106:3306/edu";
		String root = "root";
		String pass = "ArmandBasi32165487";
		
		for(Person p:pp)
		{
			String arg = "INSERT INTO person (id, fname, lname, age) \n" +
		               " VALUES ("+p.id+", '"+p.fname+"', '"+p.lname+"', "+p.age+");";

			try
			{
				Connection con = DriverManager.getConnection(str,root,pass);
				Statement stmt = con.createStatement();
				stmt.executeUpdate(arg);
				stmt.close();
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}