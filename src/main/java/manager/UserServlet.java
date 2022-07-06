package manager;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.Task;
import bean.User;
import dao.TaskDAO;
import dao.UserDAO;

public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1;
    private UserDAO userDAO;
    public void init() {
       userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getPathInfo();
        System.out.print(action);
        try {
            switch (action) {
                case "/signup":
                	System.out.print("Inserting\n");				
                try {
					signupUser(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case "/login":
                	System.out.print("Inserting\n");				
                try {
					loginUser(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void signupUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	    	//int user_ = Integer.parseInt(request.getParameter("user_id"));
    			HttpSession session = request.getSession();
    			
    			String user_name=request.getParameter("user_name");
    			String user_psw=request.getParameter("user_psw");
    			User u=new User();
    			u.setUser_name(user_name);
    			u.setUser_psw(user_psw);
    			int status=userDAO.addUser(u);  
    			session.setAttribute("user_id",status);
    	        session.setAttribute("user", u);
    	        System.out.println(status);
    	        if(status>0) {
    	        	status=1;
    	        }
    	        //RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
 
    	        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
    	        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
    	        response.getWriter().write(status+"");  
    	    }
    
    private void loginUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	    	//int user_ = Integer.parseInt(request.getParameter("user_id"));
    			String user_name=request.getParameter("user_name");
    			String user_psw=request.getParameter("user_psw");
    			HttpSession session = request.getSession();
    			User u=new User();
    			u.setUser_name(user_name);
    			u.setUser_psw(user_psw);
    			int status=userDAO.loginUser(u);   
    	        request.setAttribute("user", u);
    	        session.setAttribute("user_id",status);
    	        //RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
 
    	        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
    	        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
    	        response.getWriter().write(status+"");  
    	    }
    

}
