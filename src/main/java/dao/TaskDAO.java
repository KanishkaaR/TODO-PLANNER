package dao;
import java.sql.*;  
import java.util.*;
import bean.Task;

public class TaskDAO {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_planner","root","");  
        }catch(Exception e){System.out.println(e);}
        
        return con;  
    }  
    public static int addTask(Task u) throws SQLException{  
        int status=0;
        Connection con = null;
        try{  
            con = getConnection();  
            PreparedStatement ps=con.prepareStatement(  
    "insert into todo_tasks(user_id,task_name,priority,deadline) values(?,?,?,?)");  
            ps.setString(2,u.getTask_name());
            ps.setInt(1,u.getuser_id());
            ps.setString(3,u.getPriority());
            System.out.println(u.getDeadline());
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(u.getDeadline().getTime());
            System.out.print(u.getDeadline());
            System.out.print(sqlDate.toString());
            ps.setTimestamp(4,sqlDate);    
            status=ps.executeUpdate();  
        }
        catch(SQLException E) {
        	E.getStackTrace();
        }
        catch(Exception e){System.out.println(e);}  
        finally {
        	if(con!=null)
        		con.close();
        }
        return status;  
    }
    public static int complete(int task_id) throws SQLException {
    	 int status=0; 
    	 Connection con=null;
       try{  
           con=getConnection();  
           PreparedStatement ps=con.prepareStatement(  
   "update todo_tasks set completed=1 where task_id=?");  
           ps.setInt(1,task_id);  
           status=ps.executeUpdate();  
       }catch(Exception e){System.out.println(e);}
       finally {
       	if(con!=null)
       		con.close();
       }
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
    public static int delete(int task_id) throws SQLException{  
        int status=0; 
        Connection con=null;
        try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from todo_tasks where task_id=?");  
            ps.setInt(1,task_id);  
            status=ps.executeUpdate();  
        }catch(Exception e){System.out.println(e);}
        finally {
           	if(con!=null)
           		con.close();
           }
        
      
        return status;  
    }  
    public static List<Task> getAllTasks(int user_id) throws SQLException{  
        List<Task> list=new ArrayList<Task>();  
        Connection con=null;
        try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from todo_tasks where completed=0 and user_id=?");
            ps.setInt(1, user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);} 
        finally {
           	if(con!=null)
           		con.close();
           }
        return list;  
    }
    public static ArrayList getAllTasksByDate(int user_id,String deadline) throws SQLException {
    	ArrayList<Task> list = new ArrayList<Task>();
    	Connection con=null;
    	try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from todo_tasks where user_id=? and DATE(deadline) = ?");
            
            ps.setInt(1, user_id);
            ps.setString(2, deadline);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);}
    	finally {
           	if(con!=null)
           		con.close();
           }
        return list;  
    	
    }
    
    
    public static ArrayList getAllTasksToday(int user_id,String deadline) throws SQLException {
    	ArrayList<Task> list = new ArrayList<Task>();
    	Connection con = null;
    	try{  
    		con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from todo_tasks where user_id=? and DATE(deadline) = ? and completed=0");
            
            ps.setInt(1, user_id);
            ps.setString(2, deadline);
            System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);}
    	finally {
           	if(con!=null)
           		con.close();
           }
        return list;  
    	
    }
    
    public static ArrayList getAllTasksWeekly(int user_id,String deadline) throws SQLException {
    	ArrayList<Task> list = new ArrayList<Task>();
    	Connection con=null;
    	try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT * FROM `todo_tasks` where user_id=? and completed=0 and deadline >= DATE_ADD(CURRENT_DATE, INTERVAL 1 DAY) and deadline <= DATE_ADD(CURRENT_DATE, INTERVAL 7 DAY)");
            
            ps.setInt(1, user_id);
//            ps.setString(2, deadline);
            System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);} 
    	finally {
           	if(con!=null)
           		con.close();
           }
        return list;  
    	
    }
    
    public static ArrayList getAllTasksMonthly(int user_id,String deadline) throws SQLException {
    	ArrayList<Task> list = new ArrayList<Task>();
    	Connection con=null;
    	try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT * FROM `todo_tasks` where user_id=? and completed=0 and deadline >= DATE_ADD(CURRENT_DATE, INTERVAL 8 DAY) and deadline <= DATE_ADD(CURRENT_DATE,INTERVAL 30 DAY)");
            
            ps.setInt(1, user_id);
//            ps.setString(2, deadline);
            System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);} 
    	finally {
           	if(con!=null)
           		con.close();
           }
        return list;  
    	
    }
    public static ArrayList getAllTasksOthers(int user_id,String deadline) throws SQLException {
    	ArrayList<Task> list = new ArrayList<Task>();
    	Connection con=null;
    	try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT * FROM `todo_tasks` where user_id=? and completed=0 and (deadline < DATE(CURRENT_DATE) or deadline > DATE_ADD(CURRENT_DATE,INTERVAL 30 DAY))");
            
            ps.setInt(1, user_id);
//            ps.setString(2, deadline);
            System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);}  
    	finally {
           	if(con!=null)
           		con.close();
           }
        return list;  
    	
    }
    
    public static ArrayList getAllLast15(int user_id) throws SQLException {
    	ArrayList<Task> list = new ArrayList<Task>();
    	Connection con=null;
    	try{  
            con=getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT * FROM `todo_tasks` WHERE user_id=? and (deadline <= date(current_date) and deadline >= date_sub(CURRENT_DATE,INTERVAL 15 DAY))");
            
            ps.setInt(1, user_id);
//            ps.setString(2, deadline);
            //System.out.println("\n" +deadline+user_id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task u=new Task();  
                u.setUser_id(rs.getInt("user_id"));  
                u.setTask_id(rs.getInt("task_id"));  
                u.setTask_name(rs.getString("task_name"));
                //java.sql.Timestamp tm = new java.sql.Timestamp(rs.getTimestamp("deadline"));
                u.setDeadline(rs.getTimestamp("deadline"));  
                u.setPriority(rs.getString("priority"));  
                u.setCompleted(rs.getBoolean("completed"));  
                list.add(u);  
            }  
        }catch(Exception e){System.out.println(e);}  
    	finally {
           	if(con!=null)
           		con.close();
           }
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
