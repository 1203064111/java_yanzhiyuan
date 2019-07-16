package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderRechargeActivityBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int activity_id;//
	private String voucher_id;//代金券ID
	private String activity_need_price;//充值满足金额
	private String activity_give_price;//充值赠送金额
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getActivity_id(){
		return activity_id;
	}
	public OrderRechargeActivityBean setActivity_id(int activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getVoucher_id() {
		return voucher_id;
	}
	public OrderRechargeActivityBean setVoucher_id(String voucher_id) {
		this.voucher_id = voucher_id;
		return this;
	}
	public String getActivity_need_price(){
		return activity_need_price;
	}
	public OrderRechargeActivityBean setActivity_need_price(String activity_need_price){
		this.activity_need_price= activity_need_price;
		return this;
	}
	public String getActivity_give_price(){
		return activity_give_price;
	}
	public OrderRechargeActivityBean setActivity_give_price(String activity_give_price){
		this.activity_give_price= activity_give_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderRechargeActivityBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderRechargeActivityBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderRechargeActivityBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
