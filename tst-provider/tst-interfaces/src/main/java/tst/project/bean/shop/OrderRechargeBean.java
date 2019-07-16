package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderRechargeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//
	private String order_no;//订单号
	private String member_id;//用户id
	private String member_account;//用户手机号
	private String member_balance;//用户实际应该得到的余额
	private String order_price;//支付价格
	private String activity_give_price;//活动赠送的余额
	private String order_state;//支付状态  cancel:取消 wait_pay:等待支付  end:支付完成
	private String pay_way;//支付方式
	private String pay_charge;//支付凭证
	private String sign;//签名
	private String transaction_id;//支付交易号
	private String out_trade_no;//支付单号
	private String cash_fee;//微信回调支付的钱
	private String pay_time;//支付时间
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	public int getOrder_id(){
		return order_id;
	}
	public OrderRechargeBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public OrderRechargeBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderRechargeBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_account() {
		return member_account;
	}
	public OrderRechargeBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	
	public String getMember_balance() {
		return member_balance;
	}
	public OrderRechargeBean setMember_balance(String member_balance) {
		this.member_balance = member_balance;
		return this;
	}
	public String getOrder_price() {
		return order_price;
	}
	public OrderRechargeBean setOrder_price(String order_price) {
		this.order_price = order_price;
		return this;
	}
	public String getActivity_give_price() {
		return activity_give_price;
	}
	public OrderRechargeBean setActivity_give_price(String activity_give_price) {
		this.activity_give_price = activity_give_price;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public OrderRechargeBean setOrder_state(String order_state){
		this.order_state= order_state;
		return this;
	}
	public String getPay_way(){
		return pay_way;
	}
	public OrderRechargeBean setPay_way(String pay_way){
		this.pay_way= pay_way;
		return this;
	}
	public String getPay_charge(){
		return pay_charge;
	}
	public OrderRechargeBean setPay_charge(String pay_charge){
		this.pay_charge= pay_charge;
		return this;
	}
	public String getSign(){
		return sign;
	}
	public OrderRechargeBean setSign(String sign){
		this.sign= sign;
		return this;
	}
	public String getTransaction_id(){
		return transaction_id;
	}
	public OrderRechargeBean setTransaction_id(String transaction_id){
		this.transaction_id= transaction_id;
		return this;
	}
	public String getOut_trade_no(){
		return out_trade_no;
	}
	public OrderRechargeBean setOut_trade_no(String out_trade_no){
		this.out_trade_no= out_trade_no;
		return this;
	}
	public String getCash_fee(){
		return cash_fee;
	}
	public OrderRechargeBean setCash_fee(String cash_fee){
		this.cash_fee= cash_fee;
		return this;
	}
	public String getPay_time(){
		return pay_time;
	}
	public OrderRechargeBean setPay_time(String pay_time){
		this.pay_time= pay_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderRechargeBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderRechargeBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderRechargeBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
