package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_SQL implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	String str = "jdbc:mysql://192.168.1.106:3306/edu";
	String root = "root";
	String pass = "ArmandBasi32165487";
	//46.98.37.85
	//192.168.1.106
	//ArmandBasi32165487
	@Override
	public void create(Person p) 
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

	@Override
	public ArrayList<Person> read() 
	{
		pp = new ArrayList<Person>();
		
		try
		{
			Connection con = DriverManager.getConnection(str,root,pass);
			Statement stmn = (Statement) con.createStatement();
			ResultSet rs = stmn.executeQuery("select * from person");

			while(rs.next())
			{
				pp.add(new Person(rs.getInt(1), rs.getString("fname"), rs.getString("lname"), rs.getInt(4)));
			}
			rs.close();
			stmn.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		String arg = "UPDATE person SET fname='"+p.fname+"', lname='"+p.lname+"', age="+p.age+" WHERE person.id="+p.id+";";

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

	@Override
	public void delete(Person p) 
	{
		String arg = "DELETE FROM person WHERE person.id="+p.id+";";

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
