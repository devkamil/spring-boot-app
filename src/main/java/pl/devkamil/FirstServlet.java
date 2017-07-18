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
 * Servlet implementation class FirstServlet
 */
// @WebServlet(name = "FirstServlet", urlPatterns = { "/FirstServlet",
// "/index.jsp" })
@WebServlet("/index.jsp")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	WriterFile writerFile = new WriterFile();
	NoteManager noteManager = new NoteManager();

	protected void firstServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Note note = new Note();
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setAuthor(request.getParameter("author"));

		Date date = new Date();
		String currentDate = dateFormat.format(date);
		note.setDate(currentDate);

		request.setAttribute("notes", note);

		writerFile.fileWriter(note, date);

//		noteManager.setup();
		noteManager.create(note);
		noteManager.exit();

		request.getRequestDispatcher("/note.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		firstServlet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if ("show".equals(action)) {
			String id = request.getParameter("id");
			show(request, response, id);
			return;
		}

		List<Note> allNote = noteManager.getAllNotes();
		request.setAttribute("notes", allNote);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}

	public void show(HttpServletRequest request, HttpServletResponse response, String id) {
		Note n = noteManager.getById(Long.valueOf(id));

		request.setAttribute("notes", n);
		try {
			request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
