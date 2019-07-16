package tst.project.bean.information;

import java.io.Serializable;

public class PositionClassBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int position_class_id;//
	private String position_class_name;//职位分类名
	private String sort; // 权重
	private String is_delete; //
	private String create_time; //
	private String update_time;//
	public int getPosition_class_id() {
		return position_class_id;
	}
	public PositionClassBean setPosition_class_id(int position_class_id) {
		this.position_class_id = position_class_id;
		return this;
	}
	public String getPosition_class_name() {
		return position_class_name;
	}
	public PositionClassBean setPosition_class_name(String position_class_name) {
		this.position_class_name = position_class_name;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public PositionClassBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PositionClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PositionClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public PositionClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
