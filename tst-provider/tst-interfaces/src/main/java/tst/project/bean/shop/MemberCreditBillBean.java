package tst.project.bean.shop;

import java.io.Serializable;

public class MemberCreditBillBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int credit_bill_id;//
	private String member_id;//用户id
	private String credit_bill_price;//账号金额
	private String credit_bill_type;//1:平台赠送信用额度  2:用户还款信用额度 3:用户信用额度消费
	private String credit_bill_type_show;//   
	private String order_merchants_id;//支付订单id
	private String order_merchants_no;//支付订单号
	private String is_delete;//
	private String end_time;//最后还款时间
	private String create_time;//
	private String update_time;//
	public int getCredit_bill_id() {
		return credit_bill_id;
	}
	public MemberCreditBillBean setCredit_bill_id(int credit_bill_id) {
		this.credit_bill_id = credit_bill_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberCreditBillBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getCredit_bill_price() {
		return credit_bill_price;
	}
	public MemberCreditBillBean setCredit_bill_price(String credit_bill_price) {
		this.credit_bill_price = credit_bill_price;
		return this;
	}
	public String getCredit_bill_type() {
		return credit_bill_type;
	}
	public MemberCreditBillBean setCredit_bill_type(String credit_bill_type) {
		this.credit_bill_type = credit_bill_type;
		this.credit_bill_type_show = "1".equals(credit_bill_type)?"平台赠送":
									("2".equals(credit_bill_type)?"用户还款":
									("3".equals(credit_bill_type)?"用户消费":"未知"));
		return this;
	}
	public String getCredit_bill_type_show() {
		return credit_bill_type_show;
	}
	public MemberCreditBillBean setCredit_bill_type_show(String credit_bill_type_show) {
		this.credit_bill_type_show = credit_bill_type_show;
		return this;
	}
	public String getOrder_merchants_id() {
		return order_merchants_id;
	}
	public MemberCreditBillBean setOrder_merchants_id(String order_merchants_id) {
		this.order_merchants_id = order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no() {
		return order_merchants_no;
	}
	public MemberCreditBillBean setOrder_merchants_no(String order_merchants_no) {
		this.order_merchants_no = order_merchants_no;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberCreditBillBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberCreditBillBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MemberCreditBillBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public MemberCreditBillBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	
	
	

}
