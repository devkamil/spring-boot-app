package pl.devkamil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NoteService is a class which contains CRUD model
 */

@Service
public class NoteService {

	@Autowired
	private NoteManager noteManager;




	/**
	 * This method is taking one note with given 'id' numbers
	 */
	public Note readById(String id) {
		Note noteById = noteManager.getById(Long.valueOf(id));
		return noteById;
	}

	/**
	 * This method is getting all notes
	 */
	public List<Note> readAllNote() {
		List<Note> listAllNote = noteManager.getAllNotes();
		return listAllNote;
	}

	/**
	 * This method receives one note and saved it in database
	 * 
	 * @param note Note Object with filled fields         
	 */
	public void create(Note note) {
		noteManager.create(note);		
	}
	
	/**
	 * This method insert Note object to database
	 * 
	 * @param note Note ready to insert in database           
	 */
	public void update(Note note) {
		noteManager.update(note);		
	}

	/**
	 * This method is deleting Note object from database
	 * @param note Note ready to delete from database
	 */
	public void delete(Note note) {
		noteManager.delete(note);		
	}

	

}