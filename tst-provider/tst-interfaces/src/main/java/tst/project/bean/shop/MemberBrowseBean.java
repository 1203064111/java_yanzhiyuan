package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class MemberBrowseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int browse_id;//
	private String member_id;//用户id
	private String class_id;//浏览商品的分类id
	private String browse_count;//浏览次数
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getBrowse_id(){
		return browse_id;
	}
	public MemberBrowseBean setBrowse_id(int browse_id){
		this.browse_id= browse_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberBrowseBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public MemberBrowseBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	public String getBrowse_count(){
		return browse_count;
	}
	public MemberBrowseBean setBrowse_count(String browse_count){
		this.browse_count= browse_count;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberBrowseBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberBrowseBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberBrowseBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
