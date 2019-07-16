package tst.project.bean.sheep;

import java.io.Serializable;

public class TaskClassBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int class_id;
	private String class_type; //分类编码 send:发帖 share:分享 answer：回复  info:简历信息  real:实名认证
	
	private String class_name;//分类名称
	private String class_img;//分类图片
	private String class_monnaie;//任务奖励颜值币
	private String sort;
	private String task_num;//总任务进度数
	private String done_num;//已完成进度数 传输用
	private String task_state;//wait_do:未完成 have_done:已完成 have_gain:已领取 传输用
	private String member_id;//用户id 传输用
	private String task_way;//任务方式 ：day每日 month每月 year每年 one一次性任务
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public String getMember_id() {
		return member_id;
	}
	public TaskClassBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getTask_way() {
		return task_way;
	}
	public TaskClassBean setTask_way(String task_way) {
		this.task_way = task_way;
		return this;
	}
	public int getClass_id() {
		return class_id;
	}
	public TaskClassBean setClass_id(int class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getClass_type() {
		return class_type;
	}
	public TaskClassBean setClass_type(String class_type) {
		this.class_type = class_type;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public TaskClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_img() {
		return class_img;
	}
	public TaskClassBean setClass_img(String class_img) {
		this.class_img = class_img;
		return this;
	}
	public String getClass_monnaie() {
		return class_monnaie;
	}
	public TaskClassBean setClass_monnaie(String class_monnaie) {
		this.class_monnaie = class_monnaie;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public TaskClassBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getTask_num() {
		return task_num;
	}
	public TaskClassBean setTask_num(String task_num) {
		this.task_num = task_num;
		return this;
	}
	public String getDone_num() {
		return done_num;
	}
	public TaskClassBean setDone_num(String done_num) {
		this.done_num = done_num;
		return this;
	}
	public String getTask_state() {
		return task_state;
	}
	public TaskClassBean setTask_state(String task_state) {
		this.task_state = task_state;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public TaskClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public TaskClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public TaskClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	

	
	

	
}
