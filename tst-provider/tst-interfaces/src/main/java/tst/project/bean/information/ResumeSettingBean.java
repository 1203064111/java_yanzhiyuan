package tst.project.bean.information;

import java.io.Serializable;

public class ResumeSettingBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int resume_setting_id;
	private String percent_name;//名称
	private String percent_type;//类型
	private String percent_value;//分数
	private String is_delete;//
	private String create_time;
	private String update_time;
	public int getResume_setting_id() {
		return resume_setting_id;
	}
	public ResumeSettingBean setResume_setting_id(int resume_setting_id) {
		this.resume_setting_id = resume_setting_id;
		return this;
	}
	public String getPercent_name() {
		return percent_name;
	}
	public ResumeSettingBean setPercent_name(String percent_name) {
		this.percent_name = percent_name;
		return this;
	}
	public String getPercent_type() {
		return percent_type;
	}
	public ResumeSettingBean setPercent_type(String percent_type) {
		this.percent_type = percent_type;
		return this;
	}
	public String getPercent_value() {
		return percent_value;
	}
	public ResumeSettingBean setPercent_value(String percent_value) {
		this.percent_value = percent_value;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ResumeSettingBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ResumeSettingBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ResumeSettingBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}





