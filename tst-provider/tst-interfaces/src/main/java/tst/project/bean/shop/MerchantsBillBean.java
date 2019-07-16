package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class MerchantsBillBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bill_id;//
	private String merchants_id;//
	private String bill_type;//1:订单结算 2:提现申请 3:提现被拒 4:提现打款
	private String bill_type_show;//1:订单结算 2:提现申请 3:提现被拒 4:提现打款
	private String bill_price;//
	private String order_merchants_id;//
	private String order_merchants_no;//
	private String withdrawals_id;//提现id
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getBill_id(){
		return bill_id;
	}
	public MerchantsBillBean setBill_id(int bill_id){
		this.bill_id= bill_id;
		return this;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public MerchantsBillBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	public String getBill_type(){
		return bill_type;
	}
	public MerchantsBillBean setBill_type(String bill_type){
		this.bill_type= bill_type;
		this.bill_type_show="1".equals(bill_type)?"订单结算":
							"2".equals(bill_type)?"提现申请":
							"3".equals(bill_type)?"提现被拒":"提现打款";
		return this;
	}
	
	public String getBill_type_show() {
		return bill_type_show;
	}
	public MerchantsBillBean setBill_type_show(String bill_type_show) {
		this.bill_type_show = bill_type_show;
		return this;
	}
	public String getBill_price(){
		return bill_price;
	}
	public MerchantsBillBean setBill_price(String bill_price){
		this.bill_price= bill_price;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public MerchantsBillBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no(){
		return order_merchants_no;
	}
	public MerchantsBillBean setOrder_merchants_no(String order_merchants_no){
		this.order_merchants_no= order_merchants_no;
		return this;
	}
	
	public String getWithdrawals_id() {
		return withdrawals_id;
	}
	public MerchantsBillBean setWithdrawals_id(String withdrawals_id) {
		this.withdrawals_id = withdrawals_id;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MerchantsBillBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MerchantsBillBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MerchantsBillBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
