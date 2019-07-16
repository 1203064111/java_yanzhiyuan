package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderActivityBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_activity_id;//
	private String order_id;//
	private String order_merchants_id;//
	private String activity_id;//
	private String activity_name;//
	private String activity_type;//1:满赠 2:满减 3:直降
	private String activity_type_show;//1:满赠 2:满减 3:直降
	private String reduce_full_price;//满减需要满足金额
	private String reduce_price;//满减金额
	private String activity_price;//活动价
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getOrder_activity_id(){
		return order_activity_id;
	}
	public OrderActivityBean setOrder_activity_id(int order_activity_id){
		this.order_activity_id= order_activity_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderActivityBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderActivityBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public OrderActivityBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getActivity_name(){
		return activity_name;
	}
	public OrderActivityBean setActivity_name(String activity_name){
		this.activity_name= activity_name;
		return this;
	}
	public String getActivity_type(){
		return activity_type;
	}
	public OrderActivityBean setActivity_type(String activity_type){
		this.activity_type= activity_type;
		this.activity_type_show = "1".equals(activity_type)?"满赠":
								 ("2".equals(activity_type)?"满减":
								 ("3".equals(activity_type)?"直降":"无"));
		return this;
	}
	public String getActivity_type_show() {
		return activity_type_show;
	}
	public OrderActivityBean setActivity_type_show(String activity_type_show) {
		this.activity_type_show = activity_type_show;
		return this;
	}
	public String getReduce_full_price(){
		return reduce_full_price;
	}
	public OrderActivityBean setReduce_full_price(String reduce_full_price){
		this.reduce_full_price= reduce_full_price;
		return this;
	}
	public String getReduce_price(){
		return reduce_price;
	}
	public OrderActivityBean setReduce_price(String reduce_price){
		this.reduce_price= reduce_price;
		return this;
	}
	
	public String getActivity_price() {
		return activity_price;
	}
	public OrderActivityBean setActivity_price(String activity_price) {
		this.activity_price = activity_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderActivityBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderActivityBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderActivityBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
