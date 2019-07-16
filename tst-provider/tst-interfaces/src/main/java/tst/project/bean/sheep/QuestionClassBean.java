package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class QuestionClassBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int Class_id;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String class_name;
	private  List<QuestionBean> questionBeans;
	
	
	
	public List<QuestionBean> getQuestionBeans() {
		return questionBeans;
	}
	public QuestionClassBean setQuestionBeans(List<QuestionBean> questionBeans) {
		this.questionBeans = questionBeans;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public QuestionClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public int getClass_id() {
		return Class_id;
	}
	public QuestionClassBean setClass_id(int class_id) {
		Class_id = class_id;
		return this;
	}
	
	public String getIs_delete() {
		return is_delete;
	}
	public QuestionClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public QuestionClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public QuestionClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
