package tst.project.bean.shop;

import java.io.Serializable;

public class OrderCreditBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order_id;
	private String order_no;//
	private String member_id;//用户ID
	private String credit_state;//
	private String credit_state_show;
	private String credit_id;//授信等级ID
	private String member_credit_balance;//信用额度
	private String order_state;//支付状态  1:等待支付  2:支付完成
	private String order_state_show;
	private String pay_way;//支付方式
	private String pay_charge;//支付凭证
	private String sign;//签名
	private String transaction_id;//支付交易号
	private String out_trade_no;//支付单号
	private String cash_fee;//微信回调支付的钱
	private String pay_time;//支付时间
	
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getOrder_id() {
		return order_id;
	}
	public OrderCreditBean setOrder_id(int order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public OrderCreditBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getCredit_state() {
		return credit_state;
	}
	public OrderCreditBean setCredit_state(String credit_state) {
		this.credit_state = credit_state;
		this.credit_state_show = "1".equals(credit_state)?"后台赠送":
								("2".equals(credit_state)?"用户还款":"未知");
		return this;
	}
	public String getCredit_state_show() {
		return credit_state_show;
	}
	public OrderCreditBean setCredit_state_show(String credit_state_show) {
		this.credit_state_show = credit_state_show;
		return this;
	}
	public String getCredit_id() {
		return credit_id;
	}
	public OrderCreditBean setCredit_id(String credit_id) {
		this.credit_id = credit_id;
		return this;
	}
	public String getMember_credit_balance() {
		return member_credit_balance;
	}
	public OrderCreditBean setMember_credit_balance(String member_credit_balance) {
		this.member_credit_balance = member_credit_balance;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public OrderCreditBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public OrderCreditBean setOrder_state(String order_state) {
		this.order_state = order_state;
		this.order_state_show = "1".equals(order_state)?"等待支付":
							   ("2".equals(order_state)?"支付完成":"未知");
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderCreditBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getPay_way() {
		return pay_way;
	}
	public OrderCreditBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}
	public String getPay_charge() {
		return pay_charge;
	}
	public OrderCreditBean setPay_charge(String pay_charge) {
		this.pay_charge = pay_charge;
		return this;
	}
	public String getSign() {
		return sign;
	}
	public OrderCreditBean setSign(String sign) {
		this.sign = sign;
		return this;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public OrderCreditBean setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
		return this;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public OrderCreditBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public OrderCreditBean setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
		return this;
	}
	public String getPay_time() {
		return pay_time;
	}
	public OrderCreditBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public OrderCreditBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderCreditBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public OrderCreditBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	

}
