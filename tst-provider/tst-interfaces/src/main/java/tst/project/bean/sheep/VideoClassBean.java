package tst.project.bean.sheep;

import java.io.Serializable;

public class VideoClassBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int class_id;
	private String class_name;
	private String class_desc;
	private String class_value;
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getClass_id() {
		return class_id;
	}
	public VideoClassBean setClass_id(int class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public VideoClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_desc() {
		return class_desc;
	}
	public VideoClassBean setClass_desc(String class_desc) {
		this.class_desc = class_desc;
		return this;
	}
	public String getClass_value() {
		return class_value;
	}
	public VideoClassBean setClass_value(String class_value) {
		this.class_value = class_value;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public VideoClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public VideoClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public VideoClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
