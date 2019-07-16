package tst.project.bean.member;

import java.io.Serializable;

public class CityHotBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hot_city_id;
	private int city_id;
	private String city_name;
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public int getHot_city_id() {
		return hot_city_id;
	}
	public CityHotBean setHot_city_id(int hot_city_id) {
		this.hot_city_id = hot_city_id;
		return this;
	}
	public int getCity_id() {
		return city_id;
	}
	public CityHotBean setCity_id(int city_id) {
		this.city_id = city_id;
		return this;
	}
	public String getCity_name() {
		return city_name;
	}
	public CityHotBean setCity_name(String city_name) {
		this.city_name = city_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CityHotBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CityHotBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public CityHotBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	
	
	

}
