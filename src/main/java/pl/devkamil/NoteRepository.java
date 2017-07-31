package pl.devkamil;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {


	
	public List<Note> findByTitle (String title);
	
	public List<Note> findByContent (String content);
	

}
