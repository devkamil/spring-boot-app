package pl.devkamil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * NoteManager is a class contains methods which operating on SQL database
 */

@Repository
public class NoteManager {

	/**
	 * This method is getting all notes from database
	 */

	public List<Note> getAllNotes() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Note> notesAll = new ArrayList<Note>();
		try {
			session.beginTransaction();
			notesAll = session.createQuery("from Note").list();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return notesAll;

	}

	/**
	 * This method is getting one note from database based on 'id' number
	 * 
	 * @param id
	 *            This is 'id' number from database
	 * @return One note with a given 'id' number
	 */

	public Note getById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Note> noteAll = new ArrayList<Note>();
		try {
			session.beginTransaction();
			noteAll = session.createQuery("from Note where id=:abc").setParameter("abc", id).list();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		return noteAll.get(0);
	}
	
	/**
	 * This method receives one note and saved it in database
	 * 
	 * @param note Note Object with filled fields         
	 */
	public void create(Note note) {
		Session session = HibernateUtil.sessionFactory.openSession();
		session.beginTransaction();

		session.save(note);

		session.getTransaction().commit();
		session.close();
	}
	
	
	/**
	 * This method insert Note object to database
	 * 
	 * @param note Note ready to insert in database           
	 */
	public void update(Note note) {
		Session session = HibernateUtil.sessionFactory.openSession();
		session.beginTransaction();

		session.update(note);

		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * This method is deleting Note object from database
	 * @param note Note ready to delete from database
	 */
	public void delete (Note note) {
		Session session = HibernateUtil.sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(note);
		
		session.getTransaction().commit();
		session.close();
	}
	
	

	public NoteManager() {
	}

	
	
}
