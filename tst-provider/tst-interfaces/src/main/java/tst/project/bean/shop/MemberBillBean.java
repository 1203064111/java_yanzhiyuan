package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class MemberBillBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bill_id;//
	private String member_id;//用户id
	private String member_account;//用户手机号
	private String bill_price;//账号金额
	private String bill_type;//1:购买支付  2:退款订单  3:充值  4:余额支付  5:信用额度支付 
	//6邀请返现 、7订单支付 、8订单退款、
	private String bill_type_show;//  
	private String order_merchants_id;//支付订单id
	private String order_merchants_no;//支付订单号
	private String refund_id;//退款id
	private String refund_no;//退款订单号
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getBill_id(){
		return bill_id;
	}
	public MemberBillBean setBill_id(int bill_id){
		this.bill_id= bill_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberBillBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_account() {
		return member_account;
	}
	public MemberBillBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getBill_price(){
		return bill_price;
	}
	public MemberBillBean setBill_price(String bill_price){
		this.bill_price= bill_price;
		return this;
	}
	public String getBill_type(){
		return bill_type;
	}
	public MemberBillBean setBill_type(String bill_type){
		this.bill_type= bill_type;
		this.bill_type_show = "1".equals(bill_type)?"第三方支付":
							 ("2".equals(bill_type)?"退款":
							 ("3".equals(bill_type)?"充值":
							 ("4".equals(bill_type)?"余额支付":
							 ("5".equals(bill_type)?"信用额度支付":
							 ("6".equals(bill_type)?"邀请返现":"")))));
		return this;
	}
	
	public String getBill_type_show() {
		return bill_type_show;
	}
	public MemberBillBean setBill_type_show(String bill_type_show) {
		this.bill_type_show = bill_type_show;
		return this;
	}
	public String getOrder_merchants_id() {
		return order_merchants_id;
	}
	public MemberBillBean setOrder_merchants_id(String order_merchants_id) {
		this.order_merchants_id = order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no() {
		return order_merchants_no;
	}
	public MemberBillBean setOrder_merchants_no(String order_merchants_no) {
		this.order_merchants_no = order_merchants_no;
		return this;
	}
	public String getRefund_id() {
		return refund_id;
	}
	public MemberBillBean setRefund_id(String refund_id) {
		this.refund_id = refund_id;
		return this;
	}
	public String getRefund_no() {
		return refund_no;
	}
	public MemberBillBean setRefund_no(String refund_no) {
		this.refund_no = refund_no;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberBillBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberBillBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberBillBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
