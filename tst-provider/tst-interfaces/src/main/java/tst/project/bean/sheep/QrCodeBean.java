package tst.project.bean.sheep;

import java.io.Serializable;

public class QrCodeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private  int code_id;
	private String code_value;
	private String code_name;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String code_img;
	public int getCode_id() {
		return code_id;
	}
	public QrCodeBean setCode_id(int code_id) {
		this.code_id = code_id;
		return this;
	}
	public String getCode_value() {
		return code_value;
	}
	public QrCodeBean setCode_value(String code_value) {
		this.code_value = code_value;
		return this;
	}
	public String getCode_name() {
		return code_name;
	}
	public QrCodeBean setCode_name(String code_name) {
		this.code_name = code_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public QrCodeBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public QrCodeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public QrCodeBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCode_img() {
		return code_img;
	}
	public QrCodeBean setCode_img(String code_img) {
		this.code_img = code_img;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
