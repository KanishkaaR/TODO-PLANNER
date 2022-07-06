package bean;
import java.util.Date;
public class Task {
	    int task_id;
	    int user_id;
	    String task_name;
	    Date deadline;
	    String priority;
	    boolean completed;
	    public void setTask_id(int s){
	        task_id = s;
	    }
	    public void setUser_id(int s){
	        user_id = s;
	    }
	    public void setTask_name(String s){
	        task_name = s;
	    }
	    public void setDeadline(Date s){
	        deadline = s;
	    }
	    public void setPriority(String s){priority = s;}
	    public void setCompleted(boolean s){completed = s;}
	    public int getTask_id(){
	        return task_id;
	    }
	    public int getuser_id(){
	        return  user_id;
	    }
	    public String getTask_name(){
	        return  task_name;
	    }
	    public Date getDeadline(){
	        return  deadline;
	    }
	    public String getPriority(){
	        return  priority;
	    }
	    public boolean getCompleted(){
	        return  completed;
	    }
	}

