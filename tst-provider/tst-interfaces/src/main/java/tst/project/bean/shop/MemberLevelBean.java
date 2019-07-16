package tst.project.bean.shop;

import java.io.Serializable;

public class MemberLevelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int level_id;
	private String level_name;//会员名称
	private String level_min_price;//会员满足金额
	private String is_delete;//
	private String create_time;
	private String update_time;
	
	
	public int getLevel_id() {
		return level_id;
	}
	public MemberLevelBean setLevel_id(int level_id) {
		this.level_id = level_id;
		return this;
	}
	public String getLevel_name() {
		return level_name;
	}
	public MemberLevelBean setLevel_name(String level_name) {
		this.level_name = level_name;
		return this;
	}
	public String getLevel_min_price() {
		return level_min_price;
	}
	public MemberLevelBean setLevel_min_price(String level_min_price) {
		this.level_min_price = level_min_price;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberLevelBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberLevelBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberLevelBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	
	

}
