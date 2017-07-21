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

/**
 * Servlet implementation class FirstServlet, main application servlet
 */
@WebServlet(name = "FirstServlet", urlPatterns = { "/FirstServlet", "/FirstServlet.do", "/index.jsp" })

public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String ADD_NOTE_INDEX_BUTTON = "addNote";
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	WriterFile writerFile = new WriterFile();
	NoteService noteService = new NoteService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String addNoteName = request.getParameter(ADD_NOTE_INDEX_BUTTON);
		System.out.println("addNoteName: " + addNoteName);
		if ("addNote".equals(addNoteName)) {
			request.getRequestDispatcher("/WEB-INF/addNote.jsp").forward(request, response);
			return;
		}

		addNoteToDb(request, response);
		request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if ("show".equals(action)) {
			String id = request.getParameter("id");
			Note noteById = noteService.readById(id);
			request.setAttribute("notes", noteById);
			request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
			return;
		}

		List<Note> allNote = noteService.readAllNote();
		request.setAttribute("notes", allNote);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}
	
	protected void addNoteToDb(HttpServletRequest request, HttpServletResponse response){
		Note note = new Note();
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setAuthor(request.getParameter("author"));

		Date date = new Date();
		String currentDate = dateFormat.format(date);
		note.setDate(currentDate);

		request.setAttribute("notes", note);

		writerFile.fileWriter(note, date);

		noteService.create(note);
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
