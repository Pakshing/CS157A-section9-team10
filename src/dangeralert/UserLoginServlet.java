package dangeralert;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		//ServletOutputStream os = response.getOutputStream();
		String page = "index_form.jsp";
		User user = authenticate(username,password);
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			page = "dangeralert.jsp";
		}
		else
		{
			String message = "Invalid username/password";
			request.setAttribute("message",message);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request,response);
		
	}
	
	public User authenticate(String username,String password)
	{
		try {
	        String jdbcURL = "jdbc:mysql://localhost:3306/cs157a_project?serverTimezone=EST5EDT";
	        String dbUser = "root";
	        String dbPassword = "9Cn99N54!";
	 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	        String sql = "SELECT * FROM Users WHERE username = ? and password = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, username);
	        statement.setString(2, password);
	 
	        ResultSet result = statement.executeQuery();
	        User user = null;
	        if(result.next())
	        {
	        	user = new User();
	        	user.setUsername(username);
	        	user.setPassword(password);
	        	user.setPhonenumber(result.getString("phonenumber"));
	        	user.setCity(result.getString("city"));
	        }
	        
	        connection.close();
	        return user;
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}