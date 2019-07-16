package tst.project.bean.activity;

import java.io.Serializable;

import tst.project.bean.shop.OrderAddressBean;

/**

**

*/

/**
 * @author liyong
 *
 */
public class ZMAyOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String order_id;//
	private String order_no;//
	private String goods_id;//
	private String goods_img;
	private String goods_name;//
	private String member_id;//
	private String order_state;//订单状态   cancel:取消 wait_pay:等待支付  end:已支付
	private String fright_order_state; //邮费的订单状态
	private String is_win;//是否中奖: 0:未中奖 1:中奖
	private String order_price;//订单支付价格
	private String freight_total_price; //商品总邮费
	private String cancel_time;//订单取消时间
	private String pay_end_time;//等待付款结束时间
	private String pay_time;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String goods_now_price;//商品原价
	private String prompt_time;
	
	private String order_ids; //旗帜:中奖用户  前端将参数变成了字符串,后端用String类型接收
	
	private String is_refund; //是否已退款:	0:未退款  1:已退款
	
	private String pay_way;
	private String pay_charge;
	private String out_trade_no;	
	
	private String freight_out_trade_no;
	
	private String receive_time;//确认收货时间
	
	private String merchants_id;
	private String goods_weight;
	private String goods_volume;
	private String specification_id;
	private String specification_ids;
	private String specification_names;
	private String freight_id;
	private String freight_type;
	private String freight_way;
	private String freight_range;
	private String freight_price;
	private String freight_add_range;
	private String freight_add_price;
	private String free_range;
	private String goods_num;
	
	private String address_id;
	private String activity_id;
	
	private String is_flag;
	
	private String refund_price;
	
	private String is_red;
	
	private OrderAddressBean orderAddressBean;
	
	private String address_mobile;//收货人手机号
	private String address_name;//收货人姓名
	private String address_province;//收货人省
	private String address_city;//收货市
	private String address_country;//收货区
	private String address_detailed;//收货详情地址
	
	public String getGoods_now_price() {
		return goods_now_price;
	}
	public ZMAyOrderBean setGoods_now_price(String goods_now_price) {
		this.goods_now_price = goods_now_price;
		return this;
	}
	public String getPrompt_time() {
		return prompt_time;
	}
	public ZMAyOrderBean setPrompt_time(String prompt_time) {
		this.prompt_time = prompt_time;
		return this;
	}
	
	public String getAddress_mobile() {
		return address_mobile;
	}
	public ZMAyOrderBean setAddress_mobile(String address_mobile) {
		this.address_mobile = address_mobile;
		return this;
	}
	public String getAddress_name() {
		return address_name;
	}
	public ZMAyOrderBean setAddress_name(String address_name) {
		this.address_name = address_name;
		return this;
	}
	public String getAddress_province() {
		return address_province;
	}
	public ZMAyOrderBean setAddress_province(String address_province) {
		this.address_province = address_province;
		return this;
	}
	public String getAddress_city() {
		return address_city;
	}
	public ZMAyOrderBean setAddress_city(String address_city) {
		this.address_city = address_city;
		return this;
	}
	public String getAddress_country() {
		return address_country;
	}
	public ZMAyOrderBean setAddress_country(String address_country) {
		this.address_country = address_country;
		return this;
	}
	public String getAddress_detailed() {
		return address_detailed;
	}
	public ZMAyOrderBean setAddress_detailed(String address_detailed) {
		this.address_detailed = address_detailed;
		return this;
	}
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public ZMAyOrderBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	
	public String getIs_red() {
		return is_red;
	}
	public ZMAyOrderBean setIs_red(String is_red) {
		this.is_red = is_red;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public ZMAyOrderBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getFreight_out_trade_no() {
		return freight_out_trade_no;
	}
	public ZMAyOrderBean setFreight_out_trade_no(String freight_out_trade_no) {
		this.freight_out_trade_no = freight_out_trade_no;
		return this;
	}
	
	public String getRefund_price() {
		return refund_price;
	}
	public ZMAyOrderBean setRefund_price(String refund_price) {
		this.refund_price = refund_price;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public ZMAyOrderBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getGoods_weight() {
		return goods_weight;
	}
	public ZMAyOrderBean setGoods_weight(String goods_weight) {
		this.goods_weight = goods_weight;
		return this;
	}
	public String getGoods_volume() {
		return goods_volume;
	}
	public ZMAyOrderBean setGoods_volume(String goods_volume) {
		this.goods_volume = goods_volume;
		return this;
	}
	public String getSpecification_id() {
		return specification_id;
	}
	public ZMAyOrderBean setSpecification_id(String specification_id) {
		this.specification_id = specification_id;
		return this;
	}
	public String getSpecification_ids() {
		return specification_ids;
	}
	public ZMAyOrderBean setSpecification_ids(String specification_ids) {
		this.specification_ids = specification_ids;
		return this;
	}
	public String getSpecification_names() {
		return specification_names;
	}
	public ZMAyOrderBean setSpecification_names(String specification_names) {
		this.specification_names = specification_names;
		return this;
	}
	
	public String getFreight_id() {
		return freight_id;
	}
	public ZMAyOrderBean setFreight_id(String freight_id) {
		this.freight_id = freight_id;
		return this;
	}
	
	public String getFreight_type() {
		return freight_type;
	}
	public ZMAyOrderBean setFreight_type(String freight_type) {
		this.freight_type = freight_type;
		return this;
	}
	public String getFreight_way() {
		return freight_way;
	}
	public ZMAyOrderBean setFreight_way(String freight_way) {
		this.freight_way = freight_way;
		return this;
	}
	public String getFreight_range() {
		return freight_range;
	}
	public ZMAyOrderBean setFreight_range(String freight_range) {
		this.freight_range = freight_range;
		return this;
	}
	public String getFreight_price() {
		return freight_price;
	}
	public ZMAyOrderBean setFreight_price(String freight_price) {
		this.freight_price = freight_price;
		return this;
	}
	public String getFreight_add_range() {
		return freight_add_range;
	}
	public ZMAyOrderBean setFreight_add_range(String freight_add_range) {
		this.freight_add_range = freight_add_range;
		return this;
	}
	public String getFreight_add_price() {
		return freight_add_price;
	}
	public ZMAyOrderBean setFreight_add_price(String freight_add_price) {
		this.freight_add_price = freight_add_price;
		return this;
	}
	
	public String getFreight_total_price() {
		return freight_total_price;
	}
	public ZMAyOrderBean setFreight_total_price(String freight_total_price) {
		this.freight_total_price = freight_total_price;
		return this;
	}
	
	public String getFree_range() {
		return free_range;
	}
	public ZMAyOrderBean setFree_range(String free_range) {
		this.free_range = free_range;
		return this;
	}
	
	public String getGoods_num() {
		return goods_num;
	}
	public ZMAyOrderBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getReceive_time() {
		return receive_time;
	}
	public ZMAyOrderBean setReceive_time(String receive_time) {
		this.receive_time = receive_time;
		return this;
	}
	public String getPay_way() {
		return pay_way;
	}
	public ZMAyOrderBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}
	public String getPay_charge() {
		return pay_charge;
	}
	public ZMAyOrderBean setPay_charge(String pay_charge) {
		this.pay_charge = pay_charge;
		return this;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public ZMAyOrderBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	public String getOrder_ids() {
		return order_ids;
	}
	public ZMAyOrderBean setOrder_ids(String order_ids) {
		this.order_ids = order_ids;
		return this;
	}
	
		
	public String getIs_refund() {
		return is_refund;
	}
	public ZMAyOrderBean setIs_refund(String is_refund) {
		this.is_refund = is_refund;
		return this;
	}
		
	public String getIs_flag() {
		return is_flag;
	}
	public ZMAyOrderBean setIs_flag(String is_flag) {
		this.is_flag = is_flag;
		return this;
	}
	
	public String getActivity_id() {
		return activity_id;
	}
	public ZMAyOrderBean setActivity_id(String activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public String getAddress_id() {
		return address_id;
	}
	public ZMAyOrderBean setAddress_id(String address_id) {
		this.address_id = address_id;
		return this;
	}
	
	public String getOrder_id(){
		return order_id;
	}
	public ZMAyOrderBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public ZMAyOrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public ZMAyOrderBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public ZMAyOrderBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	
	public String getMember_id(){
		return member_id;
	}
	public ZMAyOrderBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getFright_order_state() {
		return fright_order_state;
	}
	public ZMAyOrderBean setFright_order_state(String fright_order_state) {
		this.fright_order_state = fright_order_state;
		return this;
	}
	
	public String getOrder_state(){
		return order_state;
	}
	public ZMAyOrderBean setOrder_state(String order_state){
		this.order_state= order_state;
		return this;
	}
	public String getIs_win(){
		return is_win;
	}
	public ZMAyOrderBean setIs_win(String is_win){
		this.is_win= is_win;
		return this;
	}
	public String getOrder_price(){
		return order_price;
	}
	public ZMAyOrderBean setOrder_price(String order_price){
		this.order_price= order_price;
		return this;
	}
	public String getCancel_time(){
		return cancel_time;
	}
	public ZMAyOrderBean setCancel_time(String cancel_time){
		this.cancel_time= cancel_time;
		return this;
	}
	public String getPay_end_time(){
		return pay_end_time;
	}
	public ZMAyOrderBean setPay_end_time(String pay_end_time){
		this.pay_end_time= pay_end_time;
		return this;
	}
	public String getPay_time(){
		return pay_time;
	}
	public ZMAyOrderBean setPay_time(String pay_time){
		this.pay_time= pay_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ZMAyOrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ZMAyOrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ZMAyOrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
