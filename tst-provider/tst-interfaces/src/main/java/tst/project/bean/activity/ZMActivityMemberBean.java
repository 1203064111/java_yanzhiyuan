package tst.project.bean.activity;

import java.io.Serializable;

/**

**

*/

public class ZMActivityMemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String member_id;//
	private String is_order;//旗帜：用户下单后改变状态 0：未下单  1：已下单
	private String is_delete;//
	public String getMember_id(){
		return member_id;
	}
	public ZMActivityMemberBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getIs_order(){
		return is_order;
	}
	public ZMActivityMemberBean setIs_order(String is_order){
		this.is_order= is_order;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ZMActivityMemberBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
}
