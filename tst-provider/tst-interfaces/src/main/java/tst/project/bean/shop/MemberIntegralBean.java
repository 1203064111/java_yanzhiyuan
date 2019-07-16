package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class MemberIntegralBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int integral_id;//
	private String member_id;//用户id
	private String integral_type;//1:购买商品赠送  2:买商品消耗积分  3:取消订单 返还积分 4:充值赠送
	private String integral_value;//积分值
	private String order_id;//订单总id
	private String order_no;//订单总订单号
	private String order_merchants_id;//商家订单id
	private String order_merchants_no;//商家订单号
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getIntegral_id(){
		return integral_id;
	}
	public MemberIntegralBean setIntegral_id(int integral_id){
		this.integral_id= integral_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MemberIntegralBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getIntegral_type(){
		return integral_type;
	}
	public MemberIntegralBean setIntegral_type(String integral_type){
		this.integral_type= integral_type;
		return this;
	}
	public String getIntegral_value(){
		return integral_value;
	}
	public MemberIntegralBean setIntegral_value(String integral_value){
		this.integral_value= integral_value;
		return this;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public MemberIntegralBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public MemberIntegralBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public MemberIntegralBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no(){
		return order_merchants_no;
	}
	public MemberIntegralBean setOrder_merchants_no(String order_merchants_no){
		this.order_merchants_no= order_merchants_no;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberIntegralBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberIntegralBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberIntegralBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
