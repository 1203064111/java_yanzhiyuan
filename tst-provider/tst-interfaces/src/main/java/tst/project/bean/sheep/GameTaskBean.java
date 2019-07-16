package tst.project.bean.sheep;

import java.io.Serializable;

public class GameTaskBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int task_id;
	private String task_type;
	private String task_desc;
	private String task_experience;
	private String task_num;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String is_task;//是否已达成目标
	private String member_id;
	private String dynamic_time;//任务完成日期
	private String task_name;//任务名称
	
	
	
	
	public String getTask_name() {
		return task_name;
	}
	public GameTaskBean setTask_name(String task_name) {
		this.task_name = task_name;
		return this;
	}
	public String getDynamic_time() {
		return dynamic_time;
	}
	public GameTaskBean setDynamic_time(String dynamic_time) {
		this.dynamic_time = dynamic_time;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GameTaskBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getIs_task() {
		return is_task;
	}
	public GameTaskBean setIs_task(String is_task) {
		this.is_task = is_task;
		return this;
	}
	public int getTask_id() {
		return task_id;
	}
	public GameTaskBean setTask_id(int task_id) {
		this.task_id = task_id;
		return this;
	}
	public String getTask_type() {
		return task_type;
	}
	public GameTaskBean setTask_type(String task_type) {
		this.task_type = task_type;
		return this;
	}
	public String getTask_desc() {
		return task_desc;
	}
	public GameTaskBean setTask_desc(String task_desc) {
		this.task_desc = task_desc;
		return this;
	}
	public String getTask_experience() {
		return task_experience;
	}
	public GameTaskBean setTask_experience(String task_experience) {
		this.task_experience = task_experience;
		return this;
	}
	public String getTask_num() {
		return task_num;
	}
	public GameTaskBean setTask_num(String task_num) {
		this.task_num = task_num;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GameTaskBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GameTaskBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GameTaskBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
