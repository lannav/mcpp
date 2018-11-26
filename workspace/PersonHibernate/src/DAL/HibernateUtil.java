package DAL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	static private SessionFactory sf = null;
	
	public static SessionFactory getSessionFactory()
	{
		System.out.println("123");
		if(sf == null)
			sf = new Configuration().configure().addAnnotatedClass(blogic.Person.class).buildSessionFactory();
//		.addAnnotatedClass(blogic.Person.class)
		
		System.out.println(sf);
		return sf;
	}
}
