package bean;
import java.util.*;
public class SubTask {
	private int sub_task_id;
	private int custom_task_id;
	private Date deadline;
	private boolean completed;
	private String task_name;
	private String desc;
	public int getCustom_task_id() {
		return custom_task_id;
	}
	public int getSub_task_id() {
		return sub_task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public String getDesc() {
		return desc;
	}
	public Date getDeadline() {
		return deadline;
	}
	public boolean getCompleted() {
		return completed;
	}
	public void setCustom_task_id(int i) {
		custom_task_id=i;
	}
	public void setSub_task_id(int i) {
		 sub_task_id=i;
	}
	public void setTask_name(String i) {task_name = i;}
	public void setDesc(String i) {	desc = i;}
	public void setDeadline(Date d) {deadline = d;}
	public void setCompleted(boolean i) {completed  = i;}	
}
