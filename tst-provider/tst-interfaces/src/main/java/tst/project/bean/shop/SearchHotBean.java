package tst.project.bean.shop;

import java.io.Serializable;

public class SearchHotBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hot_id;
	private String hot_name;//热门名称
	private String hot_count;//热门次数
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getHot_id() {
		return hot_id;
	}
	public SearchHotBean setHot_id(int hot_id) {
		this.hot_id = hot_id;
		return this;
	}
	public String getHot_name() {
		return hot_name;
	}
	public SearchHotBean setHot_name(String hot_name) {
		this.hot_name = hot_name;
		return this;
	}
	public String getHot_count() {
		return hot_count;
	}
	public SearchHotBean setHot_count(String hot_count) {
		this.hot_count = hot_count;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SearchHotBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SearchHotBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SearchHotBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	

}
