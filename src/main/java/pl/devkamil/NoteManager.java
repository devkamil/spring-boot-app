package pl.devkamil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

/**
 * NoteManager is a class contains methods which operating on SQL database
 */

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

	public NoteManager() {
	}

}
