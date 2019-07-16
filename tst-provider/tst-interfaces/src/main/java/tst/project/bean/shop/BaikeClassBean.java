package tst.project.bean.shop;

import java.io.Serializable;

public class BaikeClassBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int baike_class_id;//
	private String class_name;//分类名称
	private String class_img;//分类图标
	private String class_state;//分类状态 1：上架 0：下架
	private String parent_id;//父id 
	private String sort;//权重 排序
	private String class_desc;//分类简介
	private String class_special;//分类特色
	private String is_delete;//
	private String create_time;//
	private String update_time;//	
	
	public int getBaike_class_id() {
		return baike_class_id;
	}
	public BaikeClassBean setBaike_class_id(int baike_class_id) {
		this.baike_class_id = baike_class_id;
		return this;
	}
	
	
	public String getClass_special() {
		return class_special;
	}
	public BaikeClassBean setClass_special(String class_special) {
		this.class_special = class_special;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public BaikeClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_img() {
		return class_img;
	}
	public BaikeClassBean setClass_img(String class_img) {
		this.class_img = class_img;
		return this;
	}
	public String getClass_state() {
		return class_state;
	}
	public BaikeClassBean setClass_state(String class_state) {
		this.class_state = class_state;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public BaikeClassBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public BaikeClassBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getClass_desc() {
		return class_desc;
	}
	public BaikeClassBean setClass_desc(String class_desc) {
		this.class_desc = class_desc;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public BaikeClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public BaikeClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public BaikeClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
