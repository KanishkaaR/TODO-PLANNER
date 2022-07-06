package manager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.CustomTask;
import dao.CustomTaskDAO;




public class CustomTaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1;
    private CustomTaskDAO customTaskDAO;

    public void init() {
        customTaskDAO = new CustomTaskDAO();
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
            	case "/getAll":
            		 try {
            			 listCustomTask(request, response);
     				} catch (IOException e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     				} 
                         break;
                case "/insert":
                	System.out.print("Inserting\n");				
                try {
					insertCustomTask(request, response);
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

    private void listCustomTask(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
        System.out.println("user_id:"+user_id);
        List < CustomTask > listTask = customTaskDAO.getAllTasks(user_id);
        String json = new Gson().toJson(listTask);
        System.out.println("\n"+json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    private void CompleteTask(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	 int custom_task_id = Integer.parseInt(request.getParameter("custom_task_id"));
    	 CustomTaskDAO.complete(custom_task_id);
    }
    private void DeleteTask(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	 int custom_task_id = Integer.parseInt(request.getParameter("custom_task_id"));
    	 CustomTaskDAO.delete(custom_task_id);
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

    private void insertCustomTask(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ParseException {
    	HttpSession session=request.getSession(false);
    	int user_id=0;
        if(session!=null){  
        user_id=(int)session.getAttribute("user_id");  
        }
        String task_name = request.getParameter("task_name");
        String desc = request.getParameter("task_desc");
        //SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-DD HH:mm");  
        //Date deadline = fo.parse(request.getParameter("deadline"));
        
        CustomTask newTask = new CustomTask();
        newTask.setUser_id(user_id);
        newTask.setTask_name(task_name);
        newTask.setDesc(desc);
        //String priority = request.getParameter("priority");
        //if(priority.equals("null")==false) {
        	//newTask.setPriority(priority);
        //}
        
        customTaskDAO.addCustomTask(newTask);
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
