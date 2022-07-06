package dao;
import bean.SubTask;
import bean.Task;
import bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_planner","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int addUser(User u) throws SQLException{  
        int status=0; 
        Connection con=null;
        int user_id=0;
        try{  
            con=getConnection();  
 PreparedStatement ps=con.prepareStatement("SELECT * FROM `user` WHERE user_name=?");
            
            ps.setString(1, u.getUser_name());
//            ps.setString(2, deadline);
            //System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            int present=0;
            while(rs.next()){  
               present =1;
            }  
            if(present==1) {
            	return 0;
            }
            ps=con.prepareStatement("insert into user(user_name,user_psw) values(?,?)");  
            ps.setString(1,u.getUser_name());
            ps.setString(2,u.getUser_psw());  
            status=ps.executeUpdate(); 
            ps=con.prepareStatement("select * from user where user_name=? and user_psw=?");  
            ps.setString(1,u.getUser_name());
            ps.setString(2,u.getUser_psw());  
            rs=ps.executeQuery();
            //int present=0;
            
            while(rs.next()){  
               present =1;
            	user_id=rs.getInt("user_id");
            }
            
        }catch(Exception e){System.out.println(e);} 
        finally {
           	if(con!=null)
           		con.close();
           }
        return user_id;  
    }
    
    public static int loginUser(User u) throws SQLException{  
        int status=0; 
        Connection con=null;
        try{  
            con=getConnection();  
 PreparedStatement ps=con.prepareStatement("SELECT * FROM `user` WHERE user_name=? and user_psw=?");
            
            ps.setString(1, u.getUser_name());
            ps.setString(2, u.getUser_psw());
//            ps.setString(2, deadline);
            //System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            int present=0;
            int user_id=0;
            while(rs.next()){
            	user_id=rs.getInt("user_id");
               present =1;
            }  
            return user_id;
        }catch(Exception e){System.out.println(e);}  
        finally {
           	if(con!=null)
           		con.close();
           }
        return status;  
    }
}
