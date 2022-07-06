package bean;
public class CustomTask {
	private int custom_task_id;
	private int user_id;
	private String task_name;
	private String desc;
	private boolean completed;
	public int getCustom_task_id() {
		return custom_task_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public boolean getCompleted() {
		return completed;
	}
	public String getDesc() {
		return desc;
	}
	public void setCustom_task_id(int i) {
		custom_task_id=i;
	}
	public void setUser_id(int i) {
		 user_id=i;;
	}
	public void setTask_name(String i) {
		task_name = i;
	}
	public void setDesc(String i) {
		desc = i;
	}
	public void setCompleted(boolean i) {
		completed = i;
	}	
}

