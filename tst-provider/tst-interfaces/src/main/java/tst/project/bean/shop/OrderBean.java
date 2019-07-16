package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

import tst.project.utils.NumberUtils;


/**

**

*/

/**
 * @author liyong
 *
 */
public class OrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//订单id
	private String order_ids;//多个订单id 传输用
	private String order_no;//订单号
	private String member_id;//用户ID
	private String member_name;//用户名称 传输用
	private String order_state;//订单状态   wait_pay:等待支付 wait_use:未使用 wait_refund:退款中 
	//  fail_refund:退款失败 have_refunded:退款成功 have_used:已使用 have_commented:已评价 cancel:已取消  
	private String order_state_show;//
	private String refund_reason;//退款原因
	private String refund_fail_reason;//退款失败原因
	private String refund_price;//退款金额
	private String merchants_id;//医院id/医生id
	private String merchants_name;//医院名称
	private String merchants_img;//医院图标
	
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String goods_img;//商品图
	private String goods_price;//商品单价
	private String goods_num;//商品数量
	private String order_price;//订单原价格
	private String goods_order_price;//订单预约价格
	private String goods_arrive_price;//订单到付价格
	private String order_actual_price;//订单预约后实际支付价格
	private String freight_price;
	private String car_ids;
	private String member_coupon_id;//用户优惠卷id
	private String coupon_id;//优惠券id
	private String coupon_name;//优惠券名称
	private String coupon_price;//优惠券优惠价格
	private String address_id;
	
	private String is_deduction_integral;//是否抵扣积分 0:未抵扣 1:抵扣
	private String deduction_integral_value;//抵扣积分值
	private String deduction_integral_price;//抵扣积分金额
	
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String cancel_time;//取消时间
	private String pay_end_time;//等待付款结束时间
	private String pay_time;//付款时间
	private String order_mobile;//订单手机号
	
	private String pay_way;//支付方式 wx:微信  alipay:支付宝
	private String pay_way_show;
	private String pay_charge;//支付凭证
	private String out_trade_no;//支付单号
	
	private String time_num;//待支付时间倒计数
	private String order_remark;//订单备注
	
	private String start_time;//传输用
	private String end_time;//传输用
	
	
	private String last_record_time;//日记时间
	private String record_count;//日记次数
	
	private OrderAddressBean orderAddressBean;
	private List<OrderMerchantsBean> orderMerchantsBeans;
	
	
	
	
	
	public String getGoods_order_price() {
		return goods_order_price;
	}
	public OrderBean setGoods_order_price(String goods_order_price) {
		this.goods_order_price = goods_order_price;
		return this;
	}
	public String getGoods_arrive_price() {
		return goods_arrive_price;
	}
	public OrderBean setGoods_arrive_price(String goods_arrive_price) {
		this.goods_arrive_price = goods_arrive_price;
		return this;
	}
	public String getOrder_actual_price() {
		return order_actual_price;
	}
	public OrderBean setOrder_actual_price(String order_actual_price) {
		this.order_actual_price = order_actual_price;
		return this;
	}
	public String getOrder_remark() {
		return order_remark;
	}
	public OrderBean setOrder_remark(String order_remark) {
		this.order_remark = order_remark;
		return this;
	}
	public String getLast_record_time() {
		return last_record_time;
	}
	public OrderBean setLast_record_time(String last_record_time) {
		this.last_record_time = last_record_time;
		return this;
	}
	public String getRecord_count() {
		return record_count;
	}
	public OrderBean setRecord_count(String record_count) {
		this.record_count = record_count;
		return this;
	}
	public String getRefund_price() {
		return refund_price;
	}
	public OrderBean setRefund_price(String refund_price) {
		this.refund_price = refund_price;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public OrderBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public OrderBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public OrderBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getOrder_ids() {
		return order_ids;
	}
	public OrderBean setOrder_ids(String order_ids) {
		this.order_ids = order_ids;
		return this;
	}
	public String getTime_num() {
		return time_num;
	}
	public OrderBean setTime_num(String time_num) {
		this.time_num = time_num;
		return this;
	}
	public String getOrder_mobile() {
		return order_mobile;
	}
	public OrderBean setOrder_mobile(String order_mobile) {
		this.order_mobile = order_mobile;
		return this;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public OrderBean setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
		return this;
	}
	public String getRefund_fail_reason() {
		return refund_fail_reason;
	}
	public OrderBean setRefund_fail_reason(String refund_fail_reason) {
		this.refund_fail_reason = refund_fail_reason;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public OrderBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public OrderBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getMerchants_img() {
		return merchants_img;
	}
	public OrderBean setMerchants_img(String merchants_img) {
		this.merchants_img = merchants_img;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public OrderBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public OrderBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public OrderBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public OrderBean setGoods_price(String goods_price) {
		this.goods_price = goods_price;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public OrderBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	private String is_red;
	
	public String getIs_red() {
		return is_red;
	}
	public OrderBean setIs_red(String is_red) {
		this.is_red = is_red;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public OrderBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getOrder_id(){
		return order_id;
	}
	public OrderBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public OrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public OrderBean setOrder_state(String order_state){
		this.order_state = order_state;
		this.order_state_show="cancel".equals(order_state)?"已取消":
							  "wait_pay".equals(order_state)?"待付款":
							  "wait_refund".equals(order_state)?"退款中":
							  "fail_refund".equals(order_state)?"退款失败":
							  "have_refunded".equals(order_state)?"退款成功":
							  "have_commented".equals(order_state)?"已评价":
							  "wait_use".equals(order_state)?"未使用":
							  "have_used".equals(order_state)?"已使用":"未知状态";
		
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	
	public String getOrder_price() {
		return order_price;
	}
	public OrderBean setOrder_price(String order_price) {
		this.order_price = NumberUtils.subZeroAndDot(order_price);
		return this;
	}
	public String getCar_ids(){
		return car_ids;
	}
	public OrderBean setCar_ids(String car_ids){
		this.car_ids= car_ids;
		return this;
	}
	
	public String getFreight_price() {
		return freight_price;
	}
	public OrderBean setFreight_price(String freight_price) {
		this.freight_price = freight_price;
		return this;
	}
	public String getMember_coupon_id(){
		return member_coupon_id;
	}
	public OrderBean setMember_coupon_id(String member_coupon_id){
		this.member_coupon_id= member_coupon_id;
		return this;
	}
	public String getCoupon_id(){
		return coupon_id;
	}
	public OrderBean setCoupon_id(String coupon_id){
		this.coupon_id= coupon_id;
		return this;
	}
	public String getCoupon_name(){
		return coupon_name;
	}
	public OrderBean setCoupon_name(String coupon_name){
		this.coupon_name= coupon_name;
		return this;
	}
	public String getCoupon_price(){
		return coupon_price;
	}
	public OrderBean setCoupon_price(String coupon_price){
		this.coupon_price= coupon_price;
		return this;
	}
	
	public String getAddress_id() {
		return address_id;
	}
	public OrderBean setAddress_id(String address_id) {
		this.address_id = address_id;
		return this;
	}
	
	
	
	public String getIs_deduction_integral() {
		return is_deduction_integral;
	}
	public OrderBean setIs_deduction_integral(String is_deduction_integral) {
		this.is_deduction_integral = is_deduction_integral;
		return this;
	}
	public String getDeduction_integral_value() {
		return deduction_integral_value;
	}
	public OrderBean setDeduction_integral_value(String deduction_integral_value) {
		this.deduction_integral_value = deduction_integral_value;
		return this;
	}
	public String getDeduction_integral_price() {
		return deduction_integral_price;
	}
	public OrderBean setDeduction_integral_price(String deduction_integral_price) {
		this.deduction_integral_price = deduction_integral_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	
	public String getCancel_time() {
		return cancel_time;
	}
	public OrderBean setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
		return this;
	}
	public String getPay_end_time() {
		return pay_end_time;
	}
	public OrderBean setPay_end_time(String pay_end_time) {
		this.pay_end_time = pay_end_time;
		return this;
	}
	
	public String getPay_time() {
		return pay_time;
	}
	public OrderBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}
	
	public String getPay_way() {
		return pay_way;
	}
	public OrderBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		this.pay_way_show="wx".equals(pay_way)?"微信":
			  "alipay".equals(pay_way)?"支付宝":"未知";
		return this;
	}
	
	
	
	public String getPay_way_show() {
		return pay_way_show;
	}
	public OrderBean setPay_way_show(String pay_way_show) {
		this.pay_way_show = pay_way_show;
		return this;
	}
	public String getPay_charge() {
		return pay_charge;
	}
	public OrderBean setPay_charge(String pay_charge) {
		this.pay_charge = pay_charge;
		return this;
	}
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public OrderBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public OrderBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	public List<OrderMerchantsBean> getOrderMerchantsBeans() {
		return orderMerchantsBeans;
	}
	public OrderBean setOrderMerchantsBeans(List<OrderMerchantsBean> orderMerchantsBeans) {
		this.orderMerchantsBeans = orderMerchantsBeans;
		return this;
	}	
}
