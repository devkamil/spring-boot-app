package pl.devkamil;

import java.io.IOException;
import java.io.PrintWriter;

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

    /**
     * Default constructor. 
     */
//    public FirstServlet() {
//        // TODO Auto-generated constructor stub
//    }

    
    protected void firstServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter writer = response.getWriter();
    	try{
    		String text = request.getParameter("emptyText");
    		writer.println("<html>");
    		writer.println("<head>");
    		writer.println("<title>My First Servlet-Servlet-Servlet!</title>");
    		writer.println("</head>");
    		writer.println("<body>");
    		writer.println("<h1>This is my first servlet! " + text + ", " + text +  "</h1>");
    		writer.println("</body>");
    		writer.println("</html>");
    		
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
