package tst.project.bean.sheep;

import java.io.Serializable;

import tst.project.bean.member.MemberBean;

public class MemberInvationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int member_invation_id;
	private String member_id;
	private String invation_id;
	private String is_order;
	private String red_balance;//个人红包统计
	private String create_time;
	private String update_time;
	private String  is_delete;
	private MemberBean memberBean;
	private String total_balance;//已获得总红包
	private String member_nick_name;
	private String member_img;
	private String total_member;//总人数
	
	
	
	
	public String getTotal_member() {
		return total_member;
	}
	public MemberInvationBean setTotal_member(String total_member) {
		this.total_member = total_member;
		return this;
	}
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public MemberInvationBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public MemberInvationBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public MemberInvationBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public String getTotal_balance() {
		return total_balance;
	}
	public MemberInvationBean setTotal_balance(String total_balance) {
		this.total_balance = total_balance;
		return this;
	}
	public int getMember_invation_id() {
		return member_invation_id;
	}
	public MemberInvationBean setMember_invation_id(int member_invation_id) {
		this.member_invation_id = member_invation_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberInvationBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getInvation_id() {
		return invation_id;
	}
	public MemberInvationBean setInvation_id(String invation_id) {
		this.invation_id = invation_id;
		return this;
	}
	public String getIs_order() {
		return is_order;
	}
	public MemberInvationBean setIs_order(String is_order) {
		this.is_order = is_order;
		return this;
	}
	public String getRed_balance() {
		return red_balance;
	}
	public MemberInvationBean setRed_balance(String red_balance) {
		this.red_balance = red_balance;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberInvationBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberInvationBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberInvationBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
