package helper;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PatentSysSessionFactory {
	
	private static SessionFactory factory;
	
	
	public static SessionFactory getSessionFactory(){
		if(factory==null){
			try {
				Configuration configuration = new Configuration();
				
				configuration.configure().setProperty("hibernate.show_sql", "false");
				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
				factory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}

		}
		
		return factory;
	}
}
