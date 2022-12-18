package model;

public class UserMsg {
	private int userId;
	private String timestamp;
	private String msg;
	
	public UserMsg(int userId, String timestamp, String msg) {
		super();
		this.userId = userId;
		this.timestamp = timestamp;
		this.msg = msg;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
