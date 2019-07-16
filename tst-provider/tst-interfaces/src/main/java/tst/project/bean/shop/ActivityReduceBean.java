package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityReduceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int reduce_id;//
	private String activity_id;//活动id
	private String reduce_full_price;//满足金额
	private String reduce_price;//减免金额
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getReduce_id(){
		return reduce_id;
	}
	public ActivityReduceBean setReduce_id(int reduce_id){
		this.reduce_id= reduce_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ActivityReduceBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getReduce_full_price(){
		return reduce_full_price;
	}
	public ActivityReduceBean setReduce_full_price(String reduce_full_price){
		this.reduce_full_price= reduce_full_price;
		return this;
	}
	public String getReduce_price(){
		return reduce_price;
	}
	public ActivityReduceBean setReduce_price(String reduce_price){
		this.reduce_price= reduce_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityReduceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityReduceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityReduceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
