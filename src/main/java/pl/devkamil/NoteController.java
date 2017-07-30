package pl.devkamil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet implementation class FirstServlet, main application servlet
 */

@Controller
public class NoteController {
//extends HttpServlet {
	
//	private static final long serialVersionUID = 1L;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	@Autowired
	private WriterFile writerFile;
	
	@Autowired
	private NoteService noteService;

	
	
	/**
	 * This is starting method, main page of application
	 * @return Main page of application
	 */
	@RequestMapping("/")
	public String index (Model model) {
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	
	/**
	 * This method print blank form to add Note
	 * @return Blank form 'addNote'
	 */
	@RequestMapping(value = "add-note-page")
	public String noteAddPage () {
		return "addNote";
	}
	
	
	/**
	 * This method is creating Note object from index.jsp form and saving Note in database
	 * @return Main page of application
	 */
	@RequestMapping(value="save-note", method = RequestMethod.POST)
	public String saveNote(Model model, HttpServletRequest request){

		Note note = new Note();
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setAuthor(request.getParameter("author"));

		Date date = new Date();
		String currentDate = DATE_FORMAT.format(date);
		note.setDate(currentDate);

		writerFile.fileWriter(note, date);

		noteService.create(note);
		
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	
	/**
	 * This method shows a Note
	 * @param id Number 'id' of Note
	 * @return Page with full content of Note
	 */
	@RequestMapping("/show-page/{id}")
	public String showNotePage(Model model, @PathVariable("id") String id){		
		Note noteById = noteService.readById(id);		
		model.addAttribute("notes", noteById);		
		return "note";		
	}
	
	
	/**
	 * This method display a page to edit a Note
	 * @param id Number 'id' of Note
	 * @return Page to edit a Note
	 */
	@RequestMapping("/edit-page/{id}")
	public String editNotePage(Model model, @PathVariable("id") String id) {		
		Note noteById = noteService.readById(id);
		model.addAttribute("notes", noteById);
		return "edit";
	}
	
	
	/**
	 * This method is saving an edited Note and updating it in database
	 * @param id Number 'id' of Note
	 * @return Main page of application
	 */
	@RequestMapping(value="edited/{id}", method = RequestMethod.POST)
	public String editNote (Model model, @PathVariable("id") String id, HttpServletRequest request) {		

		Note note = noteService.readById(id);
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setAuthor(request.getParameter("author"));

		noteService.update(note);
		
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	
	/**
	 * This method print deleted Note
	 * @param id Number 'id' of Note
	 * @return Page with "Back" or "Remove" buttons
	 */
	@RequestMapping("/delete-page/{id}")
	public String deleteNotePage(Model model, @PathVariable("id") String id){
		Note noteById = noteService.readById(id);
		model.addAttribute("notesDelete", noteById);
		return "delete";
	}
	
	/**
	 * This method is deleting Note
	 * @param id Number 'id' of Note
	 * @return Main page of application
	 */
	@RequestMapping("/remove-note/{id}")
	public String removeNote(Model model, @PathVariable("id") String id) {
		noteService.delete(id);
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}

}
