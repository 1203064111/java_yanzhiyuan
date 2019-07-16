package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberInvationRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	private int record_id;
	private String member_id;
	private String invation_id;
	private String red_balance;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String order_id;
	private String order_no;
	
	
	
	public String getOrder_no() {
		return order_no;
	}
	public MemberInvationRecord setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public MemberInvationRecord setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public int getRecord_id() {
		return record_id;
	}
	public MemberInvationRecord setRecord_id(int record_id) {
		this.record_id = record_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberInvationRecord setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getInvation_id() {
		return invation_id;
	}
	public MemberInvationRecord setInvation_id(String invation_id) {
		this.invation_id = invation_id;
		return this;
	}
	public String getRed_balance() {
		return red_balance;
	}
	public MemberInvationRecord setRed_balance(String red_balance) {
		this.red_balance = red_balance;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberInvationRecord setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberInvationRecord setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberInvationRecord setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
