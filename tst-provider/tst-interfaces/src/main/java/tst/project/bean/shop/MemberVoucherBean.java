package tst.project.bean.shop;

import java.io.Serializable;

public class MemberVoucherBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int voucher_id;
	private String member_id;//用户ID
	private String member_account;//用户账号
	private String voucher_price;//代金券
	private String voucher_state;//0：未激活   1：已激活
	private String voucher_state_show;
	private String order_merchants_id;//订单ID
	private String order_merchants_no;//订单号
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public int getVoucher_id() {
		return voucher_id;
	}
	public MemberVoucherBean setVoucher_id(int voucher_id) {
		this.voucher_id = voucher_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberVoucherBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_account() {
		return member_account;
	}
	public MemberVoucherBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getVoucher_price() {
		return voucher_price;
	}
	public MemberVoucherBean setVoucher_price(String voucher_price) {
		this.voucher_price = voucher_price;
		return this;
	}
	public String getVoucher_state() {
		return voucher_state;
	}
	public MemberVoucherBean setVoucher_state(String voucher_state) {
		this.voucher_state = voucher_state;
		this.voucher_state_show = "0".equals(voucher_state)?"未激活":"已激活";
		return this;
	}
	public String getVoucher_state_show() {
		return voucher_state_show;
	}
	public MemberVoucherBean setVoucher_state_show(String voucher_state_show) {
		this.voucher_state_show = voucher_state_show;
		return this;
	}
	public String getOrder_merchants_id() {
		return order_merchants_id;
	}
	public MemberVoucherBean setOrder_merchants_id(String order_merchants_id) {
		this.order_merchants_id = order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no() {
		return order_merchants_no;
	}
	public MemberVoucherBean setOrder_merchants_no(String order_merchants_no) {
		this.order_merchants_no = order_merchants_no;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberVoucherBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberVoucherBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberVoucherBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	
}
