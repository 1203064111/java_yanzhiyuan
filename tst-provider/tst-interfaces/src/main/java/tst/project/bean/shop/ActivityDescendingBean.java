package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityDescendingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int descending_id;//
	private String activity_id;//活动id
	private String descending_price;//直降价格
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getDescending_id(){
		return descending_id;
	}
	public ActivityDescendingBean setDescending_id(int descending_id){
		this.descending_id= descending_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ActivityDescendingBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getDescending_price(){
		return descending_price;
	}
	public ActivityDescendingBean setDescending_price(String descending_price){
		this.descending_price= descending_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityDescendingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityDescendingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityDescendingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
