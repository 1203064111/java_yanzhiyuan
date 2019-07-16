package tst.project.bean.sheep;

import java.io.Serializable;

public class QuestionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int question_id;
	private String question_title;
	private String question_desc;
	private String sort;
	private String create_time;
	private String is_delete;
	private String update_time;
	private String class_id;
	private String sort_type;
	
	
	
	public String getSort_type() {
		return sort_type;
	}
	public QuestionBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public QuestionBean setQuestion_id(int question_id) {
		this.question_id = question_id;
		return this;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public QuestionBean setQuestion_title(String question_title) {
		this.question_title = question_title;
		return this;
	}
	public String getQuestion_desc() {
		return question_desc;
	}
	public QuestionBean setQuestion_desc(String question_desc) {
		this.question_desc = question_desc;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public QuestionBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public QuestionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public QuestionBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public QuestionBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public QuestionBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
