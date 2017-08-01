package pl.devkamil;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class is a "Data Transfer Object" of Note
 */
public class NoteDTO {
	
	private long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String content;
	
	@NotEmpty
	private String author;
	
	private String date;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
