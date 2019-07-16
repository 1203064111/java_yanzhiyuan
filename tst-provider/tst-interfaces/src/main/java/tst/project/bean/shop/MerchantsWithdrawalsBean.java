package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class MerchantsWithdrawalsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int withdrawals_id;//
	private String merchants_id;//商家id
	private String merchants_name;//商家名称
	private String withdrawals_price;//提现金额
	private String withdrawals_state;//1:申请中 2:接受 3:拒绝 4:已打款
	private String withdrawals_state_show;//1:申请中 2:接受 3:拒绝 4:已打款
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getWithdrawals_id(){
		return withdrawals_id;
	}
	public MerchantsWithdrawalsBean setWithdrawals_id(int withdrawals_id){
		this.withdrawals_id= withdrawals_id;
		return this;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public MerchantsWithdrawalsBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	
	public String getMerchants_name() {
		return merchants_name;
	}
	public MerchantsWithdrawalsBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getWithdrawals_price(){
		return withdrawals_price;
	}
	public MerchantsWithdrawalsBean setWithdrawals_price(String withdrawals_price){
		this.withdrawals_price= withdrawals_price;
		return this;
	}
	public String getWithdrawals_state(){
		return withdrawals_state;
	}
	public MerchantsWithdrawalsBean setWithdrawals_state(String withdrawals_state){
		this.withdrawals_state= withdrawals_state;
		this.withdrawals_state_show="1".equals(withdrawals_state)?"申请中":
									"2".equals(withdrawals_state)?"已接受":
									"3".equals(withdrawals_state)?"已拒绝":"已打款";
		return this;
	}
	
	public String getWithdrawals_state_show() {
		return withdrawals_state_show;
	}
	public MerchantsWithdrawalsBean setWithdrawals_state_show(String withdrawals_state_show) {
		this.withdrawals_state_show = withdrawals_state_show;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MerchantsWithdrawalsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MerchantsWithdrawalsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MerchantsWithdrawalsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
