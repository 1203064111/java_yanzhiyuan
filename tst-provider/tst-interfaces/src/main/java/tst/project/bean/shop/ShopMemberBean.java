package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ShopMemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String member_id;//用户id
	private String member_integral;//用户积分值(可用代金券)
	private String voucher_price;//用户未激活代金券
	private String member_balance;//用户余额
	private String accumulate_consume;//用户累积消费
	private String member_level;//用户会员等级
	private String credit_state;//0:未认证  1:已认证
	private String credit_state_show;//
	private String credit_grades;//授信等级
	private String member_credit_balance;//用户可用额度
	private String credit_balance;//用户总额度
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String is_buy;//是否已经购买 0:未购买 1:已购买
	
	public String getMember_id(){
		return member_id;
	}
	public ShopMemberBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_integral(){
		return member_integral;
	}
	public ShopMemberBean setMember_integral(String member_integral){
		this.member_integral= member_integral;
		return this;
	}
	
	public String getVoucher_price() {
		return voucher_price;
	}
	public ShopMemberBean setVoucher_price(String voucher_price) {
		this.voucher_price = voucher_price;
		return this;
	}
	public String getMember_balance() {
		return member_balance;
	}
	public ShopMemberBean setMember_balance(String member_balance) {
		this.member_balance = member_balance;
		return this;
	}
	public String getAccumulate_consume() {
		return accumulate_consume;
	}
	public ShopMemberBean setAccumulate_consume(String accumulate_consume) {
		this.accumulate_consume = accumulate_consume;
		return this;
	}
	public String getMember_level() {
		return member_level;
	}
	public ShopMemberBean setMember_level(String member_level) {
		this.member_level = member_level;
		return this;
	}
	public String getCredit_state() {
		return credit_state;
	}
	public ShopMemberBean setCredit_state(String credit_state) {
		this.credit_state = credit_state;
		this.credit_state_show = "0".equals(credit_state)?"未认证":
								("1".equals(credit_state)?"已认证":"未知");
		return this;
	}
	public String getCredit_state_show() {
		return credit_state_show;
	}
	public ShopMemberBean setCredit_state_show(String credit_state_show) {
		this.credit_state_show = credit_state_show;
		return this;
	}
	public String getCredit_grades() {
		return credit_grades;
	}
	public ShopMemberBean setCredit_grades(String credit_grades) {
		this.credit_grades = credit_grades;
		return this;
	}
	public String getMember_credit_balance() {
		return member_credit_balance;
	}
	public ShopMemberBean setMember_credit_balance(String member_credit_balance) {
		this.member_credit_balance = member_credit_balance;
		return this;
	}
	public String getCredit_balance() {
		return credit_balance;
	}
	public ShopMemberBean setCredit_balance(String credit_balance) {
		this.credit_balance = credit_balance;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ShopMemberBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ShopMemberBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ShopMemberBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getIs_buy() {
		return is_buy;
	}
	public ShopMemberBean setIs_buy(String is_buy) {
		this.is_buy = is_buy;
		return this;
	}
	
}
