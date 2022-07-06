package manager;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.CalenderEvent;
import dao.CalenderEventDAO;

public class CalenderEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
    private CalenderEventDAO eventDAO;

    public void init() {
        eventDAO = new CalenderEventDAO();
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
            	case "/getAllByDate":
            		listEventsByDate(request,response);
            		break;
            	case "/getAll":
            		try {
            			listEvents(request,response);
            		}
            		catch(Exception e) {
            			e.printStackTrace();
            		}
            		break;
                case "/insert":
                	System.out.print("Inserting\n");				
                try {
					insertEvent(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case "/delete":
                    DeleteEvent(request, response);
                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
                default:
                    //listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEvents(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
        List < CalenderEvent > listTask = CalenderEventDAO.getAllTasks(user_id);
        request.setAttribute("listTasks", listTask);
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    private void listEventsByDate(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    			String s = request.getParameter("deadline");
    	        List < CalenderEvent > listTask = CalenderEventDAO.getAllTasksByDate(user_id,s);
    	        request.setAttribute("listTasks", listTask);
    	        String json = new Gson().toJson(listTask);
    	        System.out.println("\n"+json);
    	        response.setContentType("application/json");
    	        response.setCharacterEncoding("UTF-8");
    	        response.getWriter().write(json);
    	    }
    
    
    private void DeleteEvent(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	 int event_id = Integer.parseInt(request.getParameter("event_id"));
    	 CalenderEventDAO.delete(event_id);
    }

  

//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userDAO.selectUser(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
//
//    }

    private void insertEvent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ParseException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
        String task_name = request.getParameter("event_name");
        SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd");  
        Date deadline = fo.parse(request.getParameter("event_date"));
        //Date d = request.getParameter("event_date");
        //SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-DD HH:mm");  
        //Date deadline = fo.parse(request.getParameter("deadline"));
        
        CalenderEvent newTask = new CalenderEvent();
        newTask.setUser_id(user_id);
        newTask.setEvent_name(task_name);
        newTask.setEvent_date(deadline);
        //String priority = request.getParameter("priority");
        //if(priority.equals("null")==false) {
        	//newTask.setPriority(priority);
        //}
        
        CalenderEventDAO.addTask(newTask);
        //response.sendRedirect("list");
    }

//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        User book = new User(id, name, email, country);
//        userDAO.updateUser(book);
//        response.sendRedirect("list");
//    }

//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userDAO.deleteUser(id);
//        response.sendRedirect("list");
//
//    }
}
