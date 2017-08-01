package pl.devkamil;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface delivers "CRUD" methods to operation in database
 */
public interface NoteRepository extends CrudRepository<Note, Long> {

	
	public List<Note> findByTitle (String title);
	
	public List<Note> findByContent (String content);
	

}
