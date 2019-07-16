package tst.project.bean.information;

import java.io.Serializable;

public class PositionClassesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int position_classes_id;
	private int position_id;//发布的职位id
	private int require_position_id;//求职id
	private int position_class_id;//岗位id
	private String type;//0求职 1发职
	private String position_class_name;//岗位名称 作显示用
	private String is_delete;//
	private String create_time; //
	private String update_time; //
	private String is_remark;//标记 0未标记 1已标记
	public int getPosition_classes_id() {
		return position_classes_id;
	}
	public PositionClassesBean setPosition_classes_id(int position_classes_id) {
		this.position_classes_id = position_classes_id;
		return this;
	}
	public int getPosition_id() {
		return position_id;
	}
	public PositionClassesBean setPosition_id(int position_id) {
		this.position_id = position_id;
		return this;
	}
	public int getRequire_position_id() {
		return require_position_id;
	}
	public PositionClassesBean setRequire_position_id(int require_position_id) {
		this.require_position_id = require_position_id;
		return this;
	}
	public int getPosition_class_id() {
		return position_class_id;
	}
	public PositionClassesBean setPosition_class_id(int position_class_id) {
		this.position_class_id = position_class_id;
		return this;
	}
	
	public String getType() {
		return type;
	}
	public PositionClassesBean setType(String type) {
		this.type = type;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PositionClassesBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PositionClassesBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public PositionClassesBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getPosition_class_name() {
		return position_class_name;
	}
	public PositionClassesBean setPosition_class_name(String position_class_name) {
		this.position_class_name = position_class_name;
		return this;
	}
	public String getIs_remark() {
		return is_remark;
	}
	public PositionClassesBean setIs_remark(String is_remark) {
		this.is_remark = is_remark;
		return this;
	}
	
	
}
