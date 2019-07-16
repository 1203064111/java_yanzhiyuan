package tst.project.bean.sheep;

import java.io.Serializable;

public class GameDynamicBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int dynamic_id;
	private String dynamic_type;//游戏动态类型  1任务中 ，2任务完成以后的,3其他
	private String member_id;
	private String member_nick_name;
	private String member_img;
	private String dynamic_desc;
	private String dynamic_time;
	private String create_time;
	private String update_time;
	private String is_delete;
	private String experience;
	private String friend_id;
	private String task_id;//任务
	private String task_now_num;//当前任务完成数；
	private String bush_num;//苜蓿数量
	
	
	
	
	
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public GameDynamicBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public GameDynamicBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getBush_num() {
		return bush_num;
	}
	public GameDynamicBean setBush_num(String bush_num) {
		this.bush_num = bush_num;
		return this;
	}
	public String getTask_now_num() {
		return task_now_num;
	}
	public GameDynamicBean setTask_now_num(String task_now_num) {
		this.task_now_num = task_now_num;
		return this;
	}
	public String getTask_id() {
		return task_id;
	}
	public GameDynamicBean setTask_id(String task_id) {
		this.task_id = task_id;
		return this;
	}
	public String getFriend_id() {
		return friend_id;
	}
	public GameDynamicBean setFriend_id(String friend_id) {
		this.friend_id = friend_id;
		return this;
	}
	public String getExperience() {
		return experience;
	}
	public GameDynamicBean setExperience(String experience) {
		this.experience = experience;
		return this;
	}
	public int getDynamic_id() {
		return dynamic_id;
	}
	public GameDynamicBean setDynamic_id(int dynamic_id) {
		this.dynamic_id = dynamic_id;
		return this;
	}
	public String getDynamic_type() {
		return dynamic_type;
	}
	public GameDynamicBean setDynamic_type(String dynamic_type) {
		this.dynamic_type = dynamic_type;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GameDynamicBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getDynamic_desc() {
		return dynamic_desc;
	}
	public GameDynamicBean setDynamic_desc(String dynamic_desc) {
		this.dynamic_desc = dynamic_desc;
		return this;
	}
	public String getDynamic_time() {
		return dynamic_time;
	}
	public GameDynamicBean setDynamic_time(String dynamic_time) {
		this.dynamic_time = dynamic_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GameDynamicBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GameDynamicBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GameDynamicBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
	
	

}
