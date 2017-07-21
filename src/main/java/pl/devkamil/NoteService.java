package pl.devkamil;

import java.util.List;

import org.hibernate.Session;

/**
 * NoteService is a class which contains CRUD model
 */

public class NoteService {

	NoteManager noteManager = new NoteManager();
	
	/**
	 * This method receives one note and saved it in database
	 * @param note Note Object with filled fields
	 */
	protected void create(Note note) {
		Session session = HibernateUtil.sessionFactory.openSession();
		session.beginTransaction();

		session.save(note);

		session.getTransaction().commit();
		session.close();
	}	
	
	/**
	 * This method is taking one note with given 'id' numbers
	 */
	protected Note readById(String id) {
		Note noteById = noteManager.getById(Long.valueOf(id));
		return noteById;
	}
	
	/**
	 * This method is getting all notes
	 */
	protected List<Note> readAllNote() {
		List<Note> listAllNote = noteManager.getAllNotes();
		return listAllNote;
	}
	
	
}