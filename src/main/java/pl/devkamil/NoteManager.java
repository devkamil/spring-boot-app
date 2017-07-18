package pl.devkamil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class NoteManager {

//	protected SessionFactory sessionFactory;
//
//	protected void setup() {
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//		try {
//			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		} catch (HibernateException ex) {
//			StandardServiceRegistryBuilder.destroy(registry);
//			ex.printStackTrace();
//		} catch (Exception exception) {
//			System.out.println("-------------------");
//			exception.printStackTrace();
//		}
//	}

	protected void create(Note note) {
		Session session = HibernateUtil.sessionFactory.openSession();
		session.beginTransaction();

		session.save(note);

		session.getTransaction().commit();
		session.close();
	}
	

	
	public List<Note> getAllNotes() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List <Note>notatkiAll = new ArrayList<Note>();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			notatkiAll = session.createQuery("from Note").list();
			
		}catch (RuntimeException ex){
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return notatkiAll;
		
	}
	
	public Note getById(long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List <Note>notatkiAll = new ArrayList<Note>();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			notatkiAll = session.createQuery("from Note where id=:abc").setParameter("abc", id).list();
			
		}catch (RuntimeException ex){
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return notatkiAll.get(0);
		
	}

	

	
	
	protected void exit() {
		HibernateUtil.sessionFactory.close();
	}

	public NoteManager() {
	}

}
