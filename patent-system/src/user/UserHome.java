package user;

// Generated Jul 30, 2012 5:40:02 AM by Hibernate Tools 4.0.0

import helper.PatentSysSessionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class User.
 * 
 * @see db.User
 * @author Hibernate Tools
 */
public class UserHome {

	private static UserHome instance;

	private static final Log log = LogFactory.getLog(UserHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return PatentSysSessionFactory.getSessionFactory();
	}

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(int id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) sessionFactory.getCurrentSession().get(
					"db.User", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	

	
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			Session se=sessionFactory.getCurrentSession();
			Transaction tx=se.beginTransaction();
			Criteria cr=se.createCriteria("user.User").add(create(instance));
			List<User> results = (List<User>) cr.list();
			tx.commit();
			
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	public User createUser(String username, String passwdmd5, String firstname,
			String lastname) {
		User user = new User(username, passwdmd5, firstname, lastname,
				0);
		System.err.println(firstname);
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.saveOrUpdate(user);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}

		return user;
	}

	public static UserHome getInstance() {
		if (instance == null)
			instance = new UserHome();
		return instance;
	}

	public User loginPost(String uname, String passmd5) {
		User user=new User(uname,passmd5);
		List<User> users=findByExample(user);
		if(users.isEmpty())
			return null;
		else
			return users.get(0);
	}

	public List<User> getAllInventors() {
		log.debug("finding User instance by example");
		try {
			Session se=sessionFactory.getCurrentSession();
			Transaction tx=se.beginTransaction();
			Query cr=se.createQuery(" from User");
			List<User> results = (List<User>) cr.list();
			tx.commit();
			
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	
	
	public User updateUser(User user) {
		Session se=getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.update(user);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return user;

	}

	public List<User> getAllUsers() {
		log.debug("finding User instance by example");
		try {
			Session se=sessionFactory.getCurrentSession();
			Transaction tx=se.beginTransaction();
			Query cr=se.createQuery(" from User");
			List<User> results = (List<User>) cr.list();
			tx.commit();
			
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Collection<Company> getAllCompanies() {
		log.debug("finding User instance by example");
		try {
			Session se=sessionFactory.getCurrentSession();
			Transaction tx=se.beginTransaction();
			Query cr=se.createQuery(" from Company");
			List<Company> results = (List<Company>) cr.list();
			tx.commit();
			
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void removeUser(User user) {
		Session se=getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.delete(user);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		
	}
	
}
