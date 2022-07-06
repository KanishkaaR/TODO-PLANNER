package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.CustomTask;
import bean.SubTask;
import bean.Task;

public class CustomTaskDAO {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_planner","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int addCustomTask(CustomTask u){  
        int status=0;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement(  
    "insert into custom_tasks(user_id,task_name,`desc`) values(?,?,?)");
            ps.setInt(1, u.getUser_id());
            ps.setString(2,u.getTask_name());  
            ps.setString(3,u.getDesc());
           // java.sql.Timestamp sqlDate = new java.sql.Timestamp(u.getDeadline().getTime());
            //System.out.print(u.getDeadline());
            //System.out.print(sqlDate.toString());
            //ps.setTimestamp(3,sqlDate);    
            status=ps.executeUpdate();  
        }catch(Exception e){System.out.println(e);}  
        return status;  
    }
    public static int complete(int custom_task_id) {
    	 int status=0;  
       try{  
           Connection con=getConnection();  
           PreparedStatement ps=con.prepareStatement(  
   "update custom_tasks set completed=1 where custom_task_id=?");  
           ps.setInt(1,custom_task_id);  
           status=ps.executeUpdate(); 
           
           ps=con.prepareStatement(  
        "update sub_tasks set completed=1 where custom_task_id=?");  
           ps.setInt(1,custom_task_id);  
           status=ps.executeUpdate(); 
       }catch(Exception e){System.out.println(e);}  
       return status;  
    	
    }
//    public static int update(Task u){  
//        int status=0;  
//        try{  
//            Connection con=getConnection();  
//            PreparedStatement ps=con.prepareStatement(  
//    "update register set name=?,password=?,email=?,sex=?,country=? where id=?");  
//            ps.setString(1,u.getName());  
//            ps.setString(2,u.getPassword());  
//            ps.setString(3,u.getEmail());  
//            ps.setString(4,u.getSex());  
//            ps.setString(5,u.getCountry());  
//            ps.setInt(6,u.getId());  
//            status=ps.executeUpdate();  
//        }catch(Exception e){System.out.println(e);}  
//        return status;  
//    }  
    public static int delete(int custom_task_id){  
        int status=0;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from custom_tasks where custom_task_id=?");
            SubTaskDAO.deleteByCustom(custom_task_id);
            ps.setInt(1,custom_task_id);  
            status=ps.executeUpdate();  
        }catch(Exception e){System.out.println(e);}  
      
        return status;  
    }  
    public static ArrayList<CustomTask> getAllTasks(int user_id){  
        ArrayList<CustomTask> list=new ArrayList<>();  
          
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from custom_tasks where user_id=?");
            ps.setInt(1, user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                CustomTask u=new CustomTask();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setCustom_task_id(rs.getInt("custom_task_id"));  
                u.setTask_name(rs.getString("task_name"));
                u.setDesc(rs.getString("desc"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u); 
            }  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
    // public static User getRecordById(int id){  
    //     User u=null;  
    //     try{  
    //         Connection con=getConnection();  
    //         PreparedStatement ps=con.prepareStatement("select * from register where id=?");  
    //         ps.setInt(1,id);  
    //         ResultSet rs=ps.executeQuery();  
    //         while(rs.next()){  
    //             u=new User();  
    //             u.setId(rs.getInt("id"));  
    //             u.setName(rs.getString("name"));  
    //             u.setPassword(rs.getString("password"));  
    //             u.setEmail(rs.getString("email"));  
    //             u.setSex(rs.getString("sex"));  
    //             u.setCountry(rs.getString("country"));  
    //         }  
    //     }catch(Exception e){System.out.println(e);}  
    //     return u;  
    // }  
}
