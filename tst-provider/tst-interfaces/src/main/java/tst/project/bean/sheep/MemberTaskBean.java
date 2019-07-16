package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberTaskBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int task_id;
	private String task_type; //send:发帖 share:分享 answer：回复  info:简历信息  real:实名认证
	private String task_state;//wait_do:未完成 have_done:已完成 have_gain:已领取
	private String last_modify_time;//最近领取日期
	private String count;//任务进度数 传输用
	private String member_id;
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getTask_id() {
		return task_id;
	}
	public MemberTaskBean setTask_id(int task_id) {
		this.task_id = task_id;
		return this;
	}
	public String getTask_type() {
		return task_type;
	}
	public MemberTaskBean setTask_type(String task_type) {
		this.task_type = task_type;
		return this;
	}
	public String getTask_state() {
		return task_state;
	}
	public MemberTaskBean setTask_state(String task_state) {
		this.task_state = task_state;
		return this;
	}
	public String getLast_modify_time() {
		return last_modify_time;
	}
	public MemberTaskBean setLast_modify_time(String last_modify_time) {
		this.last_modify_time = last_modify_time;
		return this;
	}
	public String getCount() {
		return count;
	}
	public MemberTaskBean setCount(String count) {
		this.count = count;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberTaskBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberTaskBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberTaskBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberTaskBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

	
	

	
}
