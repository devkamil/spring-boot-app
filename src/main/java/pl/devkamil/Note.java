package pl.devkamil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class defines a Note object
 */

@Entity
@Table(name = "note")

public class Note {

	private long id;
	private String title;
	private String content;
	private String author;
	private String date;

	@Id
	@Column(name = "note_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Note() {
	}

	public Note(String title, String content, String author, String date) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Tytuł: " + title + "  " + '\n' + "Treść notatki: " + content + "  " + '\n' + "Autor: " + author + "  "
				+ '\n' + "Data: " + date;
	}

}
