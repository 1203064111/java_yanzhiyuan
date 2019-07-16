package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepClassBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String class_id;
	private String class_sign;
	private String class_name;
	private String class_state;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String class_desc;
	public String getClass_id() {
		return class_id;
	}
	public SheepClassBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getClass_sign() {
		return class_sign;
	}
	public SheepClassBean setClass_sign(String class_sign) {
		this.class_sign = class_sign;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public SheepClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_state() {
		return class_state;
	}
	public SheepClassBean setClass_state(String class_state) {
		this.class_state = class_state;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getClass_desc() {
		return class_desc;
	}
	public SheepClassBean setClass_desc(String class_desc) {
		this.class_desc = class_desc;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
