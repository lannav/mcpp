package DAL;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import blogic.Person;

public class PersonDAO_MySQL_Hibernate implements PersonDAO
{

	ArrayList<Person> pp = null;
	
	@Override
	public void create(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Person> read() 
	{
//		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		  Session session = new Configuration().configure().addAnnotatedClass(blogic.Person.class).buildSessionFactory().getCurrentSession();
		  session.beginTransaction();
	//	  Query query = session.createQuery("FROM  Person");//HQL
		  Query query = session.createQuery("FROM person");
		  pp = (ArrayList<Person>) query.getResultList();
		  session.close();
		  
		  return pp;
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person p) {
		// TODO Auto-generated method stub
		
	}

}
