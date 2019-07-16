package tst.project.bean.sheep;

import java.io.Serializable;

public class GameConfigBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int conf_id;
	private String conf_name;
	private String conf_type;
	private String conf_value;
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getConf_id() {
		return conf_id;
	}
	public GameConfigBean setConf_id(int conf_id) {
		this.conf_id = conf_id;
		return this;
	}
	public String getConf_name() {
		return conf_name;
	}
	public GameConfigBean setConf_name(String conf_name) {
		this.conf_name = conf_name;
		return this;
	}
	public String getConf_type() {
		return conf_type;
	}
	public GameConfigBean setConf_type(String conf_type) {
		this.conf_type = conf_type;
		return this;
	}
	public String getConf_value() {
		return conf_value;
	}
	public GameConfigBean setConf_value(String conf_value) {
		this.conf_value = conf_value;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GameConfigBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GameConfigBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GameConfigBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
