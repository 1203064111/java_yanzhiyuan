package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityGiveBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int give_id;//
	private String activity_id;//活动id
	private String give_full_price;//满足赠送金额值
	private String give_type;//1:赠送商品 2:赠送积分
	private String give_integral_value;//赠送积分值
	private String is_delete;//0:未删除 1:删除
	private String create_time;//创建时间
	private String update_time;//修改时间
	public int getGive_id(){
		return give_id;
	}
	public ActivityGiveBean setGive_id(int give_id){
		this.give_id= give_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ActivityGiveBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getGive_full_price(){
		return give_full_price;
	}
	public ActivityGiveBean setGive_full_price(String give_full_price){
		this.give_full_price= give_full_price;
		return this;
	}
	public String getGive_type(){
		return give_type;
	}
	public ActivityGiveBean setGive_type(String give_type){
		this.give_type= give_type;
		return this;
	}
	public String getGive_integral_value(){
		return give_integral_value;
	}
	public ActivityGiveBean setGive_integral_value(String give_integral_value){
		this.give_integral_value= give_integral_value;
		return this;
	}
	
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityGiveBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityGiveBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityGiveBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
