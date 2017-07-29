package pl.devkamil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	@Autowired
	WriterFile writerFile;
	
	@Autowired
	private NoteService noteService;

	
	/**
	 * This method print blank form to add Note
	 * @return Blank form 'addNote'
	 */
	@RequestMapping(value = "addNote")
	public String noteAdd () {
		return "addNote";
	}
	
	/**
	 * This method is saving Note
	 * @return Main page of application
	 */
	@RequestMapping(value="saveNote", method = RequestMethod.POST)
	public String saveNote(Model model, HttpServletRequest request, HttpServletResponse response){
		addNote(request, response);
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	/**
	 * This method is saving an edited Note
	 * @param id Number 'id' of Note
	 * @return Main page of application
	 */
	@RequestMapping(value="edited/{id}", method = RequestMethod.POST)
	public String editButton (Model model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {		
		updateNote(request, response, id);
		System.out.println(request + "   +++    " +response);
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
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
	 * This method shows a Note
	 * @param id Number 'id' of Note
	 * @return Page with full content of Note
	 */
	@RequestMapping("/show/{id}")
	public String show(Model model, @PathVariable("id") String id){		
		Note noteById = noteService.readById(id);		
		model.addAttribute("notes", noteById);		
		return "note";		
	}
	
	/**
	 * This method display a page to edit a Note
	 * @param id Number 'id' of Note
	 * @return Page to edit a Note
	 */
	@RequestMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {		
		Note noteById = noteService.readById(id);
		model.addAttribute("notes", noteById);
		return "edit";
	}
	
	/**
	 * This method print deleted Note
	 * @param id Number 'id' of Note
	 * @return Page with "Back" or "Remove" buttons
	 */
	@RequestMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") String id){
		Note noteById = noteService.readById(id);
		model.addAttribute("notesDelete", noteById);
		return "delete";
	}
	
	/**
	 * This method is deleting Note
	 * @param id Number 'id' of Note
	 * @return Main page of application
	 */
	@RequestMapping("/remove/{id}")
	public String remove(Model model, @PathVariable("id") String id) {
		noteService.delete(id);
		List<Note> allNote = noteService.readAllNote();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	
	/**
	 * This method is creating Note object from index.jsp form
	 */
	protected void addNote(HttpServletRequest request, HttpServletResponse response){
		Note note = new Note();
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setAuthor(request.getParameter("author"));

		Date date = new Date();
		String currentDate = DATE_FORMAT.format(date);
		note.setDate(currentDate);

		request.setAttribute("notes", note);

		writerFile.fileWriter(note, date);

		noteService.create(note);
	}
	
	/**
	 * This method is updating note in database
	 * @param id  Note 'id' number
	 */
	
	protected void updateNote(HttpServletRequest request, HttpServletResponse response, String id){

		Note note = noteService.readById(id);
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setAuthor(request.getParameter("author"));

		Date date = new Date();
		String currentDate = DATE_FORMAT.format(date);
		note.setDate(currentDate);

		request.setAttribute("notes", note);

		noteService.update(note);
	}


	@Override
	public void init() {
		HibernateUtil.buildSessionFactory();
	}

	@Override
	public void destroy() {
		HibernateUtil.sessionFactory.close();
	}

}
