package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class MerchantsBalanceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int balance_id;//
	private String merchants_id;//
	private String total_balance;//总余额
	private String withdrawals_already_balance;//已经提现金额
	private String withdrawals_can_balance;//可提现金额
	private String withdrawals_not_balance;//未结算金额
	private String withdrawals_ing_balance;//正在体现中金额
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getBalance_id(){
		return balance_id;
	}
	public MerchantsBalanceBean setBalance_id(int balance_id){
		this.balance_id= balance_id;
		return this;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public MerchantsBalanceBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	public String getTotal_balance(){
		return total_balance;
	}
	public MerchantsBalanceBean setTotal_balance(String total_balance){
		this.total_balance= total_balance;
		return this;
	}
	public String getWithdrawals_already_balance(){
		return withdrawals_already_balance;
	}
	public MerchantsBalanceBean setWithdrawals_already_balance(String withdrawals_already_balance){
		this.withdrawals_already_balance= withdrawals_already_balance;
		return this;
	}
	public String getWithdrawals_can_balance(){
		return withdrawals_can_balance;
	}
	public MerchantsBalanceBean setWithdrawals_can_balance(String withdrawals_can_balance){
		this.withdrawals_can_balance= withdrawals_can_balance;
		return this;
	}
	public String getWithdrawals_not_balance(){
		return withdrawals_not_balance;
	}
	public MerchantsBalanceBean setWithdrawals_not_balance(String withdrawals_not_balance){
		this.withdrawals_not_balance= withdrawals_not_balance;
		return this;
	}
	public String getWithdrawals_ing_balance(){
		return withdrawals_ing_balance;
	}
	public MerchantsBalanceBean setWithdrawals_ing_balance(String withdrawals_ing_balance){
		this.withdrawals_ing_balance= withdrawals_ing_balance;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MerchantsBalanceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MerchantsBalanceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MerchantsBalanceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
