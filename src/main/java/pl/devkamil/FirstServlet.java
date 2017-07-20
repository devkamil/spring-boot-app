package pl.devkamil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name = "FirstServlet", urlPatterns = { "/FirstServlet", "/FirstServlet.do", "/index.jsp" })

public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String ADD_NOTE_INDEX_BUTTON = "addNote";

	NoteManager noteManager = new NoteManager();
	AddNote addNote = new AddNote();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String addNoteName = request.getParameter(ADD_NOTE_INDEX_BUTTON);
		System.out.println("addNoteName: " + addNoteName);
		if ("addNote".equals(addNoteName)) {
			request.getRequestDispatcher("/WEB-INF/addNote.jsp").forward(request, response);
			return;
		}

		addNote.firstServlet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("show".equals(action)) {
			String id = request.getParameter("id");
			noteManager.read(request, response, id);
			return;
		}

		List<Note> allNote = noteManager.getAllNotes();
		request.setAttribute("notes", allNote);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

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
