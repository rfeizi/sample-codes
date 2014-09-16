package invention;

// Generated Jul 30, 2012 5:40:02 AM by Hibernate Tools 4.0.0

import helper.PatentSysSessionFactory;
import invention.Invention.Status;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import UI.InventionSearchResult;

import expertise.ExpertiseDomain;

import user.User;
import user.UserHome;
import util.Attachment;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Invention.
 * 
 * @see db.Invention
 * @author Hibernate Tools
 */
public class InventionHome {
	private static InventionHome instance;

	private static final Log log = LogFactory.getLog(InventionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return PatentSysSessionFactory.getSessionFactory();
	}

	public void persist(Invention transientInstance) {
		log.debug("persisting Invention instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Invention instance) {
		log.debug("attaching dirty Invention instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Invention instance) {
		log.debug("attaching clean Invention instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Invention persistentInstance) {
		log.debug("deleting Invention instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Invention merge(Invention detachedInstance) {
		log.debug("merging Invention instance");
		try {
			Invention result = (Invention) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Invention findById(int id) {
		log.debug("getting Invention instance with id: " + id);
		try {
			Invention instance = (Invention) sessionFactory.getCurrentSession()
					.get("db.Invention", id);
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

	public List<Invention> findByExample(Invention instance) {
		log.debug("finding Invention instance by example");
		try {

			Session se = getSessionFactory().getCurrentSession();
			Transaction tx = se.beginTransaction();
			List<Invention> results = (List<Invention>) sessionFactory
					.getCurrentSession().createCriteria("invention.Invention")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			tx.commit();

			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void addCollaboration(InventionFile inventionFile, User inventor) {

		InventorCollaboration ic = new InventorCollaboration(inventor,
				inventionFile, 0, 0);
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.saveOrUpdate(ic);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}

	}

	public static InventionHome getInstance() {
		if (instance == null)
			instance = new InventionHome();
		return instance;
	}

	public List<Invention> getAllInventions() {
		log.debug("finding Invention instance by example");
		try {

			Session se = getSessionFactory().getCurrentSession();
			Transaction tx = se.beginTransaction();

			Query cr = se.createQuery(" from Invention");
			List<Invention> results = (List<Invention>) cr.list();

			log.debug("find by example successful, result size: "
					+ results.size());
			tx.commit();

			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public Collection<Invention> getCollaboratedInventions(User user) {
		InventorCollaboration invColIns = new InventorCollaboration();
		invColIns.setInventor(user);
		Session se = getSessionFactory().getCurrentSession();
		Transaction tx = se.beginTransaction();
		List<InventorCollaboration> userColabs = (List<InventorCollaboration>) sessionFactory
				.getCurrentSession()
				.createCriteria("invention.InventorCollaboration")
				.add(create(invColIns)).list();
		log.debug("find by example successful, result size: "
				+ userColabs.size());
		tx.commit();
		ArrayList<Invention> userInventions = new ArrayList<Invention>();
		for (InventorCollaboration colab : userColabs) {
			userInventions.add(colab.getInventionFile().getInvention());
		}
		return userInventions;

	}

	public InventionFile saveInventionFile(InventionFile inventionFile) {

		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			if(inventionFile.getCreationTime()==null)
				inventionFile.setCreationTime(new Date());
			for(InventorCollaboration ic:inventionFile.getInventorCollaborations())
				ic.getInventor().getInventorCollaborations().add(ic);
			se.saveOrUpdate(inventionFile);
			
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}

		System.out.println(inventionFile.getCreationTime());
		return inventionFile;

	}

	public InventionFileEdition saveInventionFileEdition(
			InventionFileEdition ife, InventionFile iFile, User editor) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			ife.setEditor(editor);
			ife.setInventionFile(iFile);
			iFile.addInventionFileEdition(ife);
			ife.setEditionTime(new Date());

			updateAttachments(iFile);

			se.saveOrUpdate(iFile);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}

		return ife;

	}

	public void updateAttachments(InventionFile iFile) {
		ArrayList<Attachment> atts=new ArrayList<Attachment>(iFile.getAttachments());
		for (Attachment att : atts) {
			if (att.getStatus()==Attachment.Status.added) {
				try {

					InputStream in = new FileInputStream(att.getFile());
					int dot = att.getFile().getName().lastIndexOf('.');
					String ext = "";
					if (dot != -1)
						ext = att.getFile().getName().substring(dot+1);

					att.setExtension(ext);
					getSessionFactory().getCurrentSession().saveOrUpdate(att);

					OutputStream out = new FileOutputStream("attachments/att_"
							+ att.getId());

					byte[] buf = new byte[1024];
					int len;
					int size=0;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
						size++;
					}
					in.close();
					out.close();
					System.out.println("File copied.");
					att.setSize(size);
					att.setStatus(Attachment.Status.saved);
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(att.getStatus()==Attachment.Status.removed){
				System.out.println("this should be removed");
				System.out.println("removing:"+iFile.getAttachments().remove(att));
				getSessionFactory().getCurrentSession().delete(att);
				File f=new File("attachments/"+att.getId());
				f.delete();
			}
		}
	}

	public Invention saveFinalInventionFileEdition(InventionFileEdition ife,
			InventionFile iFile, User editor, Status status) {

		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		Invention invention;
		try {

			tx = se.beginTransaction();
			ife.setEditor(editor);
			ife.setInventionFile(iFile);
			ife.setEditionTime(new Date());
			iFile.addInventionFileEdition(ife);
			updateAttachments(iFile);
			invention = iFile.getInvention();
			if (invention == null) {
				invention = new Invention();
				invention.setInventionFile(iFile);
				iFile.setInvention(invention);
			}
			invention.setStatus(status);

			se.saveOrUpdate(invention);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return invention;

	}

	public InventionFileAssesment saveInventionFileAssesment(
			Invention invention, User expert) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		InventionFileAssesment ifa;
		try {
			tx = se.beginTransaction();

			ifa = new InventionFileAssesment();
			ifa.setInvention(invention);
			ifa.setExpert(expert);
			ifa.setAssignTime(new Date());
			invention.getInventionFileAssesments().add(ifa);
			expert.getInventionFileAssesments().add(ifa);
			se.saveOrUpdate(invention);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return ifa;

	}

	public InventionFile refreshInventionFile(InventionFile inventionFile) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			if (inventionFile.getInvention() != null)
				se.refresh(inventionFile.getInvention());
			else
				se.refresh(inventionFile);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return inventionFile;

	}

	public InventionFileAssesment updateAssesment(InventionFileAssesment ifa) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			ifa.setFinishTime(new Date());
			se.update(ifa);
			se.update(ifa.getInvention());

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return ifa;

	}

	public InventionFileAssesment refreshAssesment(InventionFileAssesment ifa) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.refresh(ifa);
			se.refresh(ifa.getInvention());

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return ifa;

	}

	public List<InventionSearchResult> getSearchResults(String key,
			boolean inventors, boolean title, boolean history,
			boolean abstract_, boolean indictment, boolean explan) {

		List<Invention> allInventions = getAllInventions();
		ArrayList<InventionSearchResult> results = new ArrayList<InventionSearchResult>();

		for (Invention inv : allInventions) {

			InventionSearchResult isr = new InventionSearchResult(inv, key);

			InventionFileEdition ife = inv.getInventionFile().getLastEdition();

			if (inventors)
				for (InventorCollaboration ic : inv.getInventionFile()
						.getInventorCollaborations()) {
					if (ic.getInventor().getFullName().contains(key))
						isr.setFoundInInventors(true);
				}

			if (title)
				if (inv.getInventionFile().getTitle().contains(key))
					isr.setFoundInTitle(true);

			if (history)
				if (ife.getHistory().contains(key))
					isr.setFoundInHisotry(true);

			if (abstract_)
				if (ife.getAbstract_().contains(key))
					isr.setFoundInAbstract(true);

			if (indictment)
				if (ife.getIndictment().contains(key))
					isr.setFoundInIndictment(true);

			if (explan)
				if (ife.getExplan().contains(key))
					isr.setFoundInExplan(true);

			if (isr.isFound())
				results.add(isr);

		}

		return results;

	}

	public Invention updateInvention(Invention inv) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.update(inv);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return inv;

	}

	public Attachment updateAttachment(Attachment att) {
		Session se = getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {

			tx = se.beginTransaction();
			se.update(att);

			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return att;

	}

	public ArrayList<Invention> getAuthorizingInventions() {
		ArrayList<Invention> authorizingInventions=new ArrayList<Invention>(); 
		for(Invention inv:getAllInventions())
			if(inv.getStatus()==Status.authorizing)
				authorizingInventions.add(inv);
		
		return authorizingInventions;
	}

}
