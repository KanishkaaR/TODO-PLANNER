package manager;
import java.io.IOException;
import java.util.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.Task;
import dao.TaskDAO;


class DateProb{
	public Date d;
	public Integer g;
	DateProb(Date d,Integer g){
		this.d = d;
		this.g = g;
	}
}

class DateProb2{
	public String d;
	public Integer g;
	DateProb2(String d,Integer g){
		this.d = d;
		this.g = g;
	}
}

public class TaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1;
    private TaskDAO taskDAO;

    public void init() {
        taskDAO = new TaskDAO();
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
	            case "/getAllLast15":
	        		try{
	        			System.out.println("Getting all 15");
	        			listTaskLast15(request,response);
	        		}
	        		catch(Exception e) {
	        			e.getStackTrace();
	        		}
	        		break;
            	case "/getAllToday":
            		listTaskToday(request,response);
            		break;
            	case "/getAllWeekly":
            		listTaskWeekly(request,response);
            		break;
            	case "/getAllMonthly":
            		listTaskMonthly(request,response);
            		break;
            	case "/getAllOthers":
            		listTaskOthers(request,response);
            		break;
            	case "/getAllByDate":
            		listTaskByDate(request, response);
            		break;
                case "/getAll":
                    listUser(request, response);
                    break;
                case "/insert":
                	System.out.print("Inserting\n");				
                try {
					insertUser(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case "/delete":
                    DeleteTask(request, response);
                    break;
                case "/complete":
                    CompleteTask(request, response);
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

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	//int user_id = Integer.parseInt(request.getParameter("user_id"));
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
        List < Task > listTask = taskDAO.getAllTasks(user_id);
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    public void listTaskByDate(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    	String s = request.getParameter("deadline");
        ArrayList < Task > listTask = taskDAO.getAllTasksByDate(user_id,s);
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public void listTaskToday(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    	String s = request.getParameter("deadline");
        ArrayList < Task > listTask = taskDAO.getAllTasksToday(user_id,s);
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public void listTaskWeekly(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    	String s = request.getParameter("deadline");
        ArrayList < Task > listTask = taskDAO.getAllTasksWeekly(user_id,s);
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public void listTaskMonthly(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    	String s = request.getParameter("deadline");
        ArrayList < Task > listTask = taskDAO.getAllTasksMonthly(user_id,s);
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public void listTaskLast15(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException, ParseException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    	System.out.println("hello brooo");
    	ArrayList <Task> listTask = taskDAO.getAllLast15(user_id);
    	Collections.sort(listTask, 
                (o1, o2) -> o1.getDeadline().compareTo(o2.getDeadline()));
       
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public void listTaskOthers(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
    	String s = request.getParameter("deadline");
        ArrayList < Task > listTask = taskDAO.getAllTasksOthers(user_id,s);
        request.setAttribute("listTasks", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    
    private void CompleteTask(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	 int task_id = Integer.parseInt(request.getParameter("task_id"));
    	 TaskDAO.complete(task_id);
    }
    private void DeleteTask(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	 int task_id = Integer.parseInt(request.getParameter("task_id"));
    	 TaskDAO.delete(task_id);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
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

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ParseException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
        String task_name = request.getParameter("task_name");
        SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        Date deadline = fo.parse(request.getParameter("deadline"));
        System.out.println(deadline);
        
        System.out.println(request.getParameter("deadline"));
        Task newTask = new Task();
        newTask.setUser_id(user_id);
        newTask.setTask_name(task_name);
        newTask.setDeadline(deadline);
        String priority = request.getParameter("priority");
        if(priority.equals("null")==false) {
        	newTask.setPriority(priority);
        }
        
        taskDAO.addTask(newTask);
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
