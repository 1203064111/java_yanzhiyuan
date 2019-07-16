package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class RenovationOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//
	private String member_id;
	private String order_no;//订单号
	private String order_type;//1:装修预约 2:设计预约
	private String order_state;//1:已预约  2:已确认 3:已支付订单  4:已支付进度款 5:已支付尾款 6:结束
	private String style_id;//风格id
	private String style_name;//风格名称
	private String style_price;//风格单价
	private String order_area;//订单面积
	private String order_price;//订单价格
	private String order_deposit_price;//定金
	private String order_progress_price;//进度款
	private String order_end_price;//尾款
	private String contact_name;//联系人姓名
	private String contact_mobile;//联系人电话
	private String address_provider;//省
	private String address_city;//市
	private String address_country;//区
	private String address_detail;//详情地址
	private String out_trade_no1;//定金支付单号
	private String out_trade_no2;//进程款支付单号
	private String out_trade_no3;//尾款支付单号
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getOrder_id(){
		return order_id;
	}
	public RenovationOrderBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public RenovationOrderBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public RenovationOrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getOrder_type(){
		return order_type;
	}
	public RenovationOrderBean setOrder_type(String order_type){
		this.order_type= order_type;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public RenovationOrderBean setOrder_state(String order_state){
		this.order_state= order_state;
		return this;
	}
	public String getStyle_id(){
		return style_id;
	}
	public RenovationOrderBean setStyle_id(String style_id){
		this.style_id= style_id;
		return this;
	}
	public String getStyle_name(){
		return style_name;
	}
	public RenovationOrderBean setStyle_name(String style_name){
		this.style_name= style_name;
		return this;
	}
	public String getStyle_price(){
		return style_price;
	}
	public RenovationOrderBean setStyle_price(String style_price){
		this.style_price= style_price;
		return this;
	}
	public String getOrder_area(){
		return order_area;
	}
	public RenovationOrderBean setOrder_area(String order_area){
		this.order_area= order_area;
		return this;
	}
	public String getOrder_price(){
		return order_price;
	}
	public RenovationOrderBean setOrder_price(String order_price){
		this.order_price= order_price;
		return this;
	}
	
	public String getOrder_deposit_price() {
		return order_deposit_price;
	}
	public RenovationOrderBean setOrder_deposit_price(String order_deposit_price) {
		this.order_deposit_price = order_deposit_price;
		return this;
	}
	public String getOrder_progress_price() {
		return order_progress_price;
	}
	public RenovationOrderBean setOrder_progress_price(String order_progress_price) {
		this.order_progress_price = order_progress_price;
		return this;
	}
	public String getOrder_end_price() {
		return order_end_price;
	}
	public RenovationOrderBean setOrder_end_price(String order_end_price) {
		this.order_end_price = order_end_price;
		return this;
	}
	public String getContact_name(){
		return contact_name;
	}
	public RenovationOrderBean setContact_name(String contact_name){
		this.contact_name= contact_name;
		return this;
	}
	public String getContact_mobile(){
		return contact_mobile;
	}
	public RenovationOrderBean setContact_mobile(String contact_mobile){
		this.contact_mobile= contact_mobile;
		return this;
	}
	public String getAddress_provider(){
		return address_provider;
	}
	public RenovationOrderBean setAddress_provider(String address_provider){
		this.address_provider= address_provider;
		return this;
	}
	public String getAddress_city(){
		return address_city;
	}
	public RenovationOrderBean setAddress_city(String address_city){
		this.address_city= address_city;
		return this;
	}
	public String getAddress_country(){
		return address_country;
	}
	public RenovationOrderBean setAddress_country(String address_country){
		this.address_country= address_country;
		return this;
	}
	public String getAddress_detail(){
		return address_detail;
	}
	public RenovationOrderBean setAddress_detail(String address_detail){
		this.address_detail= address_detail;
		return this;
	}

	public String getOut_trade_no1() {
		return out_trade_no1;
	}
	public RenovationOrderBean setOut_trade_no1(String out_trade_no1) {
		this.out_trade_no1 = out_trade_no1;
		return this;
	}
	public String getOut_trade_no2() {
		return out_trade_no2;
	}
	public RenovationOrderBean setOut_trade_no2(String out_trade_no2) {
		this.out_trade_no2 = out_trade_no2;
		return this;
	}
	public String getOut_trade_no3() {
		return out_trade_no3;
	}
	public RenovationOrderBean setOut_trade_no3(String out_trade_no3) {
		this.out_trade_no3 = out_trade_no3;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public RenovationOrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public RenovationOrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public RenovationOrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
