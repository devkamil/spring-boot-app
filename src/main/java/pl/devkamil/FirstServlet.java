package pl.devkamil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Servlet implementation class FirstServlet, main application servlet
 */
@WebServlet(name = "FirstServlet", urlPatterns = { "/FirstServlet", "/FirstServlet.do", "/index.jsp" })

@Controller
public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String ADD_NOTE_INDEX_BUTTON = "addNote";
	private static final String EDIT_BUTTON_VALUE = "editButton";
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	@Autowired
	WriterFile writerFile;
	
	@Autowired
	private NoteService noteService;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String addNoteName = request.getParameter(ADD_NOTE_INDEX_BUTTON);
		String editButton = request.getParameter(EDIT_BUTTON_VALUE);
		
		if ("addNote".equals(addNoteName)) {
			request.getRequestDispatcher("/WEB-INF/addNote.jsp").forward(request, response);
			return;
		}

		if("OK".equals(editButton)){
			String id = request.getParameter("id");
			updateNote(request, response, id);			
			request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
			return;
		}
		
		addNote(request, response);
		request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String id = request.getParameter("id");

		System.out.println("action:  " +action);
		

		if ("show".equals(action)) {			
			Note noteById = noteService.readById(id);
			request.setAttribute("notes", noteById);
			request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
			return;
		}
		
		if ("edit".equals(action)){
			Note noteById = noteService.readById(id);
			request.setAttribute("notes", noteById);
			request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
			return;
		}
		
		if("delete".equals(action)){
			Note noteById = noteService.readById(id);
			request.setAttribute("notesDelete", noteById);
			request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
			return;			
		}
		
		if("remove".equals(action)){
			deleteNote(id);
//			List<Note> allNote = noteService.readAllNote();
//			request.setAttribute("notes", allNote);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			return;			
		}

		List<Note> allNote = noteService.readAllNote();
		request.setAttribute("notes", allNote);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);


	
	
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
	/**
	 * This method is deleting note
	 * @param id Note 'id' number
	 */
	protected void deleteNote(String id){
		Note note = noteService.readById(id);
		noteService.delete(note);
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
