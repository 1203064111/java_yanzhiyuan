package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityShoppingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String shopping_id;//
	private String activity_id;//
	private String activity_people_num;//活动参与者达标数
	private String activity_people_win;//获奖人数
	private String activity_price;//活动价格
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public String getShopping_id(){
		return shopping_id;
	}
	public ActivityShoppingBean setShopping_id(String shopping_id){
		this.shopping_id= shopping_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ActivityShoppingBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getActivity_people_num(){
		return activity_people_num;
	}
	public ActivityShoppingBean setActivity_people_num(String activity_people_num){
		this.activity_people_num= activity_people_num;
		return this;
	}
	public String getActivity_people_win(){
		return activity_people_win;
	}
	public ActivityShoppingBean setActivity_people_win(String activity_people_win){
		this.activity_people_win= activity_people_win;
		return this;
	}
	public String getActivity_price(){
		return activity_price;
	}
	public ActivityShoppingBean setActivity_price(String activity_price){
		this.activity_price= activity_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityShoppingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityShoppingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityShoppingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
