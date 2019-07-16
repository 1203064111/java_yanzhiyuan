package tst.project.bean.yinlong;

import java.io.Serializable;
import java.util.List;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年8月3日 上午10:53:29
* 维修区域分类
*/
public class PartsClassBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int parts_id; 
	private String parts_name;   //零部件名称
	private String parts_img;    //分类图标
	private String parts_state;  //分类状态 1：上架 0：下架
	private String parent_id;   //父id  -1第一级
	private String is_delete; 
	private String sort;
	private String sort_type;
	private String create_time;
	private String update_time;
	private List<PartsClassBean> partsClassBeans;
	public int getParts_id() {
		return parts_id;
	}
	public PartsClassBean setParts_id(int parts_id) {
		this.parts_id = parts_id;
		return this;
	}
	public String getParts_name() {
		return parts_name;
	}
	public void setParts_name(String parts_name) {
		this.parts_name = parts_name;
	}
	public String getParts_img() {
		return parts_img;
	}
	public void setParts_img(String parts_img) {
		this.parts_img = parts_img;
	}
	public String getParts_state() {
		return parts_state;
	}
	public void setParts_state(String parts_state) {
		this.parts_state = parts_state;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	public String getSort() {
		return sort;
	}
	public PartsClassBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public PartsClassBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<PartsClassBean> getPartsClassBeans() {
		return partsClassBeans;
	}
	public PartsClassBean setPartsClassBeans(List<PartsClassBean> partsClassBeans) {
		this.partsClassBeans = partsClassBeans;
		return this;
	}
	
	
}
