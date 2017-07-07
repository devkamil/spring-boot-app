package pl.devkamil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(
		name = "FirstServlet",
		urlPatterns = { 
				"/FirstServlet", 
				"/FirstServlet.do"
		})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	
	
	
    
    protected void firstServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter writer = response.getWriter();
    	try{
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		String author = request.getParameter("author");
    		Date date = new Date();
    		String currentDate = dateFormat.format(date);  		
    		
    		request.setAttribute("title", title);
    		request.setAttribute("content", content);
    		request.setAttribute("author", author);
    		request.setAttribute("date", currentDate);
    		
    		
    		request.getRequestDispatcher("/notatka.jsp").forward(request, response);
    		
    	}finally{
    		writer.close();
    	}
   }
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		firstServlet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		firstServlet(request, response);
	}

	public String getServletInfo() {
		return "Short description";
	}
}
