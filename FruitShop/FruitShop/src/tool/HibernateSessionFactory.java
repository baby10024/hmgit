package tool;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {

	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	
	private static final ThreadLocal<Session> sessionThreadLocal = 
			new ThreadLocal<Session>();
	
	private static Configuration configuration = new Configuration();

	private static SessionFactory sessionFactory;
	
	private static String configFile = CONFIG_FILE_LOCATION;
	
	static {
		try {
			configuration.configure();
			ServiceRegistry serviceRegistry = 
					new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	private HibernateSessionFactory() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
