package tst.project.bean.member;

import java.io.Serializable;

public class TypeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int type_id;
	private String type_name;//工种
	private String sort;//权重
	private String sort_type;//
	private String is_delete;//0：未删除 1：已删除
	private String create_time;//
	private String update_time;//
	
	public int getType_id() {
		return type_id;
	}
	public TypeBean setType_id(int type_id) {
		this.type_id = type_id;
		return this;
	}
	public String getType_name() {
		return type_name;
	}
	public TypeBean setType_name(String type_name) {
		this.type_name = type_name;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public TypeBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public TypeBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public TypeBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public TypeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public TypeBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	

}
