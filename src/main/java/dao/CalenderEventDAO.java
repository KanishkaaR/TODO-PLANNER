package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bean.CalenderEvent;
  

public class CalenderEventDAO {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_planner","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int addTask(CalenderEvent u){  
        int status=0;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement(  
    "insert into calender_events(user_id,event_name,event_date) values(?,?,?)");  
            ps.setString(2,u.getEvent_name()); 
            ps.setInt(1, u.getUser_id());
            System.out.println(u.getEvent_date());
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(u.getEvent_date().getTime());
            System.out.print(u.getEvent_date());
            System.out.print(sqlDate.toString());
            ps.setTimestamp(3,sqlDate);    
            status=ps.executeUpdate();  
        }catch(Exception e){System.out.println(e);}  
        return status;  
    }
    public static int delete(int event_id){  
        int status=0;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from calender_events where event_id=?");  
            ps.setInt(1,event_id);  
            status=ps.executeUpdate();  
        }catch(Exception e){System.out.println(e);}  
      
        return status;  
    }  
    public static List<CalenderEvent> getAllTasks(int user_id){  
        List<CalenderEvent> list=new ArrayList<CalenderEvent>();  
          
        try{  
            Connection con=getConnection();
            //String s = d.toString();
            
            PreparedStatement ps=con.prepareStatement("select * from calender_events user_id=?");
            ps.setInt(1, user_id);
            //ps.setString(1, s);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                CalenderEvent u=new CalenderEvent();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setEvent_id(rs.getInt("event_id"));  
                u.setEvent_name(rs.getString("event_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setEvent_date(rs.getTimestamp("event_date"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
    public static List<CalenderEvent> getAllTasksByDate(int user_id,String s){  
        List<CalenderEvent> list=new ArrayList<CalenderEvent>();  
          
        try{  
            Connection con=getConnection();
            //String s = d.toString();
            
            PreparedStatement ps=con.prepareStatement("select * from calender_events where user_id=? and DATE(event_date) = ?");
            ps.setInt(1, user_id);
            ps.setString(2, s);
            //ps.setString(1, s);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                CalenderEvent u=new CalenderEvent();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setEvent_id(rs.getInt("event_id"));  
                u.setEvent_name(rs.getString("event_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setEvent_date(rs.getTimestamp("event_date"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
    
}
