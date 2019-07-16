package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class BankCardBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int card_id;//
	private String member_id;//
	private String member_name;//用户名
	private String member_mobile;//银行手机号/支付宝账号
	private String bank_name;//银行名称
	private String bank_card_number;//银行卡号
	private String bank_card_type;//0:储蓄卡 1:信用卡 2 :支付宝
	private String bank_card_type_show;
	private String create_time;//
	private String update_time;//
	private String is_delete;//是否删除 0:否 1:是
	private String role_type;//shop商家版 member用户版
	
	public String getRole_type() {
		return role_type;
	}
	public BankCardBean setRole_type(String role_type) {
		this.role_type = role_type;
		return this;
	}
	public int getCard_id(){
		return card_id;
	}
	public BankCardBean setCard_id(int card_id){
		this.card_id= card_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public BankCardBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_name(){
		return member_name;
	}
	public BankCardBean setMember_name(String member_name){
		this.member_name= member_name;
		return this;
	}
	public String getMember_mobile(){
		return member_mobile;
	}
	public BankCardBean setMember_mobile(String member_mobile){
		this.member_mobile= member_mobile;
		return this;
	}
	public String getBank_name(){
		return bank_name;
	}
	public BankCardBean setBank_name(String bank_name){
		this.bank_name= bank_name;
		return this;
	}
	public String getBank_card_number(){
		return bank_card_number;
	}
	public BankCardBean setBank_card_number(String bank_card_number){
		this.bank_card_number= bank_card_number;
		return this;
	}
	public String getBank_card_type(){
		return bank_card_type;
	}
	public BankCardBean setBank_card_type(String bank_card_type){
		this.bank_card_type= bank_card_type;
		this.bank_card_type_show = "0".equals(bank_card_type)?"储蓄卡":
									"1".equals(bank_card_type)?"信用卡":
								  ("2".equals(bank_card_type)?"支付宝":"未知");
		return this;
	}
	public String getBank_card_type_show() {
		return bank_card_type_show;
	}
	public BankCardBean setBank_card_type_show(String bank_card_type_show) {
		this.bank_card_type_show = bank_card_type_show;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public BankCardBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public BankCardBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public BankCardBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
}
