package pl.devkamil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNote {

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

		noteManager.create(note);

		request.getRequestDispatcher("/WEB-INF/note.jsp").forward(request, response);
	}
}
