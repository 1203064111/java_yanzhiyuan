package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class MemberIntegralOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String order_id;//
	private String order_no;//订单号
	private String member_id;//
	private String order_integral;//充值积分
	private String order_price;//支付价格
	private String order_state;//支付状态  cancel:取消 wait_pay:等待支付  end:支付完成
	private String pay_way;//支付方式
	private String pay_charge;//支付凭证
	private String pay_time;//支付时间
	private String out_trade_no;//支付单号
	private String transaction_id;//支付交易号
	private String sign;//签名
	private String cash_fee;//微信回调支付的钱
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public MemberIntegralOrderBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public MemberIntegralOrderBean setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
		return this;
	}
	public String getSign() {
		return sign;
	}
	public MemberIntegralOrderBean setSign(String sign) {
		this.sign = sign;
		return this;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public MemberIntegralOrderBean setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOrder_id(){
		return order_id;
	}
	public MemberIntegralOrderBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public MemberIntegralOrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberIntegralOrderBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getOrder_integral(){
		return order_integral;
	}
	public MemberIntegralOrderBean setOrder_integral(String order_integral){
		this.order_integral= order_integral;
		return this;
	}
	public String getOrder_price(){
		return order_price;
	}
	public MemberIntegralOrderBean setOrder_price(String order_price){
		this.order_price= order_price;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public MemberIntegralOrderBean setOrder_state(String order_state){
		this.order_state= order_state;
		return this;
	}
	public String getPay_way(){
		return pay_way;
	}
	public MemberIntegralOrderBean setPay_way(String pay_way){
		this.pay_way= pay_way;
		return this;
	}
	public String getPay_charge(){
		return pay_charge;
	}
	public MemberIntegralOrderBean setPay_charge(String pay_charge){
		this.pay_charge= pay_charge;
		return this;
	}
	public String getPay_time(){
		return pay_time;
	}
	public MemberIntegralOrderBean setPay_time(String pay_time){
		this.pay_time= pay_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberIntegralOrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberIntegralOrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberIntegralOrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
