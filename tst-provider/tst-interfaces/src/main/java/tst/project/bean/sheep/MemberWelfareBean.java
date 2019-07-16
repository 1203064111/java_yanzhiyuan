package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberWelfareBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int member_welfare_id;
	private String member_id;
	private String coupon_state; //0,1,2,过期，已使用
	private String welfare_time;//体验天数
	private String coupon_name;
	private String vaild_day;//优惠券有效时间
	private String end_time;//有效结束时间
	private String is_delete;
	private String create_time;
	private String update_time;
	private String welfare_id;//体验券id
	
	
	public String getWelfare_id() {
		return welfare_id;
	}
	public MemberWelfareBean setWelfare_id(String welfare_id) {
		this.welfare_id = welfare_id;
		return this;
	}
	public int getMember_welfare_id() {
		return member_welfare_id;
	}
	public MemberWelfareBean setMember_welfare_id(int member_welfare_id) {
		this.member_welfare_id = member_welfare_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberWelfareBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getCoupon_state() {
		return coupon_state;
	}
	public MemberWelfareBean setCoupon_state(String coupon_state) {
		this.coupon_state = coupon_state;
		return this;
	}
	public String getWelfare_time() {
		return welfare_time;
	}
	public MemberWelfareBean setWelfare_time(String welfare_time) {
		this.welfare_time = welfare_time;
		return this;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public MemberWelfareBean setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
		return this;
	}
	public String getVaild_day() {
		return vaild_day;
	}
	public MemberWelfareBean setVaild_day(String vaild_day) {
		this.vaild_day = vaild_day;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MemberWelfareBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberWelfareBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberWelfareBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberWelfareBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
