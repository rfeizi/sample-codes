package expertise;

// Generated Jul 30, 2012 5:40:02 AM by Hibernate Tools 4.0.0

import helper.PatentSysSessionFactory;
import invention.Invention;
import invention.InventionFile;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import expertise.NewExpertiseDomainRequest.Status;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ExpertiseDomain.
 * @see db.ExpertiseDomain
 * @author Hibernate Tools
 */
public class ExpertiseHome {

	private static final Log log = LogFactory.getLog(ExpertiseHome.class);

	private static ExpertiseHome instance;

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return PatentSysSessionFactory.getSessionFactory();
	}

	public void persist(ExpertiseDomain transientInstance) {
		log.debug("persisting ExpertiseDomain instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExpertiseDomain instance) {
		log.debug("attaching dirty ExpertiseDomain instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		}
		catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExpertiseDomain instance) {
		log.debug("attaching clean ExpertiseDomain instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExpertiseDomain persistentInstance) {
		log.debug("deleting ExpertiseDomain instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExpertiseDomain merge(ExpertiseDomain detachedInstance) {
		log.debug("merging ExpertiseDomain instance");
		try {
			ExpertiseDomain result = (ExpertiseDomain) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExpertiseDomain findById(java.lang.Integer id) {
		log.debug("getting ExpertiseDomain instance with id: " + id);
		try {
			ExpertiseDomain instance = (ExpertiseDomain) sessionFactory
					.getCurrentSession().get("db.ExpertiseDomain", id);
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

	public List<ExpertiseDomain> findByExample(ExpertiseDomain instance) {
		log.debug("finding ExpertiseDomain instance by example");
		try {
			Session se=getSessionFactory().getCurrentSession();
			Transaction tx=se.beginTransaction();
			List<ExpertiseDomain> results = (List<ExpertiseDomain>) sessionFactory
					.getCurrentSession().createCriteria("expertise.ExpertiseDomain")
					.add(create(instance)).list();
			tx.commit();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<ExpertiseDomain> findAll() {
		log.debug("finding all ExpertiseDomains");
		try {
			Session se=getSessionFactory().getCurrentSession();
			Transaction tx=se.beginTransaction();
			List<ExpertiseDomain> results = (List<ExpertiseDomain>) sessionFactory
					.getCurrentSession().createQuery("from ExpertiseDomain").list();
			
			tx.commit();
			log.debug("find all successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	
	
	public static ExpertiseHome getInstance() {
		if(instance==null)
			instance=new ExpertiseHome();
		return instance;
	}

	public Collection<ExpertiseDomain> getAllDomains() {
		return findAll();
	}
	
	
	public ExpertiseDomain AcceptNewDomain(NewExpertiseDomainRequest nedr){

		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		ExpertiseDomain ed;
		try {

			tx = se.beginTransaction();
			ed=new ExpertiseDomain(nedr.getDomainName());
			InventionFile ifile=nedr.getInventionFile();
			ifile.getExpertiseDomain().getInventionFiles().remove(ifile);
			
			ifile.setExpertiseDomain(ed);
			ed.getInventionFiles().add(ifile);
			
			nedr.setStatus(Status.accepted);
			
			se.update(ifile);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return ed;
	}
	
	
	public NewExpertiseDomainRequest RejectNewDomain(NewExpertiseDomainRequest nedr){

		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;

		try {

			tx = se.beginTransaction();
			
			nedr.setStatus(Status.rejected);
			
			se.update(nedr);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return nedr;
	}

	public List<NewExpertiseDomainRequest> getAllNewDomains() {
		log.debug("finding all ");
		try {
			Session se=getSessionFactory().getCurrentSession();
			Transaction tx=se.beginTransaction();
			List<NewExpertiseDomainRequest> results = (List<NewExpertiseDomainRequest>) sessionFactory
					.getCurrentSession().createQuery("from NewExpertiseDomainRequest").list();
			
			tx.commit();
			log.debug("find all successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	
}
