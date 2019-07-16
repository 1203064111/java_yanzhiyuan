package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class CustomizedOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//
	private String member_id;//用户id
	private String order_no;//订单号
	private String order_state;//1:已预约  2:已确认 3:已支付定金   4:已支付尾款 5:结束
	private String customized_id;//项目id
	private String customized_name;//项目名称
	private String huxing_id;//户型id
	private String huxing_name;//户型名称
	private String programme_id;//方案id
	private String programme_name;//方案名称
	private String programme_price;//方案报价
	private String order_price;//
	private String order_deposit_price;//定金
	private String order_end_price;//尾款
	private String contact_name;//联系人姓名
	private String contact_mobile;//联系人电话
	private String address_provider;//省
	private String address_city;//市
	private String address_country;//区
	private String address_detail;//详情地址
	private String out_trade_no1;//定金支付单号
	private String out_trade_no2;//尾款支付单号
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String pay_time1;//定金支付时间
	private String pay_time2;//尾款支付时间
	public int getOrder_id(){
		return order_id;
	}
	public CustomizedOrderBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public CustomizedOrderBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public CustomizedOrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public CustomizedOrderBean setOrder_state(String order_state){
		this.order_state= order_state;
		return this;
	}
	public String getCustomized_id(){
		return customized_id;
	}
	public CustomizedOrderBean setCustomized_id(String customized_id){
		this.customized_id= customized_id;
		return this;
	}
	public String getCustomized_name(){
		return customized_name;
	}
	public CustomizedOrderBean setCustomized_name(String customized_name){
		this.customized_name= customized_name;
		return this;
	}
	public String getHuxing_id(){
		return huxing_id;
	}
	public CustomizedOrderBean setHuxing_id(String huxing_id){
		this.huxing_id= huxing_id;
		return this;
	}
	public String getHuxing_name(){
		return huxing_name;
	}
	public CustomizedOrderBean setHuxing_name(String huxing_name){
		this.huxing_name= huxing_name;
		return this;
	}
	public String getProgramme_id(){
		return programme_id;
	}
	public CustomizedOrderBean setProgramme_id(String programme_id){
		this.programme_id= programme_id;
		return this;
	}
	public String getProgramme_name(){
		return programme_name;
	}
	public CustomizedOrderBean setProgramme_name(String programme_name){
		this.programme_name= programme_name;
		return this;
	}
	public String getProgramme_price(){
		return programme_price;
	}
	public CustomizedOrderBean setProgramme_price(String programme_price){
		this.programme_price= programme_price;
		return this;
	}
	public String getOrder_price(){
		return order_price;
	}
	public CustomizedOrderBean setOrder_price(String order_price){
		this.order_price= order_price;
		return this;
	}
	public String getOrder_deposit_price(){
		return order_deposit_price;
	}
	public CustomizedOrderBean setOrder_deposit_price(String order_deposit_price){
		this.order_deposit_price= order_deposit_price;
		return this;
	}
	public String getOrder_end_price(){
		return order_end_price;
	}
	public CustomizedOrderBean setOrder_end_price(String order_end_price){
		this.order_end_price= order_end_price;
		return this;
	}
	public String getContact_name(){
		return contact_name;
	}
	public CustomizedOrderBean setContact_name(String contact_name){
		this.contact_name= contact_name;
		return this;
	}
	public String getContact_mobile(){
		return contact_mobile;
	}
	public CustomizedOrderBean setContact_mobile(String contact_mobile){
		this.contact_mobile= contact_mobile;
		return this;
	}
	public String getAddress_provider(){
		return address_provider;
	}
	public CustomizedOrderBean setAddress_provider(String address_provider){
		this.address_provider= address_provider;
		return this;
	}
	public String getAddress_city(){
		return address_city;
	}
	public CustomizedOrderBean setAddress_city(String address_city){
		this.address_city= address_city;
		return this;
	}
	public String getAddress_country(){
		return address_country;
	}
	public CustomizedOrderBean setAddress_country(String address_country){
		this.address_country= address_country;
		return this;
	}
	public String getAddress_detail(){
		return address_detail;
	}
	public CustomizedOrderBean setAddress_detail(String address_detail){
		this.address_detail= address_detail;
		return this;
	}
	public String getOut_trade_no1(){
		return out_trade_no1;
	}
	public CustomizedOrderBean setOut_trade_no1(String out_trade_no1){
		this.out_trade_no1= out_trade_no1;
		return this;
	}
	public String getOut_trade_no2(){
		return out_trade_no2;
	}
	public CustomizedOrderBean setOut_trade_no2(String out_trade_no2){
		this.out_trade_no2= out_trade_no2;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public CustomizedOrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public CustomizedOrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public CustomizedOrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getPay_time1(){
		return pay_time1;
	}
	public CustomizedOrderBean setPay_time1(String pay_time1){
		this.pay_time1= pay_time1;
		return this;
	}
	public String getPay_time2(){
		return pay_time2;
	}
	public CustomizedOrderBean setPay_time2(String pay_time2){
		this.pay_time2= pay_time2;
		return this;
	}
}
