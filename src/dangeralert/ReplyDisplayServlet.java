package dangeralert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReplyDisplayServlet
 */
@WebServlet("/ReplyDisplayServlet")
public class ReplyDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status = Integer.parseInt(request.getParameter("s"));
		if(status == 1) {
	        String message = "Successfully Replied";
			request.setAttribute("message",message);
		}
		else {
			String message = "Failed to Reply";
			request.setAttribute("message",message);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("Reply.jsp");
		view.forward(request,response);
	}

}
