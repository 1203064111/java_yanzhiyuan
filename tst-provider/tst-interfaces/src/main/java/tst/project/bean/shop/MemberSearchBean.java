package tst.project.bean.shop;

import java.io.Serializable;

public class MemberSearchBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int search_id;
	private String search_ids;//搜索的id组合
	private String search_name;//名称
	private String member_id;//用户id
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	
	public String getSearch_ids() {
		return search_ids;
	}
	public MemberSearchBean setSearch_ids(String search_ids) {
		this.search_ids = search_ids;
		return this;
	}
	public int getSearch_id() {
		return search_id;
	}
	public MemberSearchBean setSearch_id(int search_id) {
		this.search_id = search_id;
		return this;
	}
	public String getSearch_name() {
		return search_name;
	}
	public MemberSearchBean setSearch_name(String search_name) {
		this.search_name = search_name;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberSearchBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberSearchBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberSearchBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberSearchBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	

}
