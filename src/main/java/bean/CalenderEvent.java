package bean;
import java.util.*;

public class CalenderEvent {
	private int user_id;
	private int event_id;
	private String event_name;
	private Date event_date;
	public int getUser_id() {
		return user_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_id(int i) {
		event_id = i;
	}
	public void setUser_id(int i) {
		user_id = i;
	}
	public void setEvent_name(String s) {
		event_name = s;
	}
	public void setEvent_date(Date d) {
		event_date = d;
	}
	
}
