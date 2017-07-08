package pl.devkamil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name = "FirstServlet", urlPatterns = { "/FirstServlet", "/FirstServlet.do" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private static final DateFormat dateWriter = new SimpleDateFormat("yyyy-MM-dd-HHmm");

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

		fileWriter(note);

		request.getRequestDispatcher("/note.jsp").forward(request, response);
	}

	public void fileWriter(Note note) {
		Date date = new Date();
		String fileName = dateWriter.format(date);

		File file = new File("C:\\Users\\DOM\\Desktop\\note_" + fileName + ".txt");

		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {

			writer.write(note.toString());
			writer.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public String getServletInfo() {
		return "Short description";
	}
}
