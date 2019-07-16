package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class OrderMerchantsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_merchants_id;//
	private String order_merchants_no;//订单号
	private String order_id;//
	private String order_no;//多商家下单 关联字段
	private String merchants_id;//商家id
	private String merchants_name;//商家名称
	private String member_id;//用户id
	private String order_total_price;//总价
	private String order_actual_price;//实际支付价
	private String goods_total_price;//商品的实际总价
	private String goods_num;//购买数量
	private String goods_min_time;//最远时间
	private String goods_max_time;//最近时间
	private String coupon_price;//优惠券优惠金额
	private String reduce_price;//满减活动减免金额
	private String freight_price;//邮费
	private String order_type;//订单类型 goods:正常商品下单订单
	private String order_type_show;//
	private String order_state;//订单状态  cancel:取消  wait_pay:代付款  wait_send:待发货 pay_cancel:已取消发货   wait_receive:待收货 wait_assessment:待评价 end:已完成  refund:订单所有商品都退款  close:订单已结算 关闭状态
	private String order_state_show;
	private String order_remark;//订单备注
	private String is_deduction_integral;//是否抵扣积分 0:未抵扣 1:抵扣
	private String deduction_integral_value;//抵扣积分值
	private String deduction_integral_price;//抵扣积分金额
	private String invoice_id;//发票id
	private String reconciliation_state;//对账状态  0:未对账  1:已对账
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String cancel_time;//取消订单时间
	private String receive_time;//确认收货时间
	private String pay_time;//付款时间
	private String assessment_time;//评价时间
	private String send_time;//发货时间
	private String close_time;//结算时间
	private String pay_way;//支付方式 wx:微信  alipay:支付宝 wx_pub:微信公众号  wx_lite:微信小程序
	private String refund_price;//退款金额
	private String settlement_price;//可结算金额
	private String settlement_wholesale_price;//商家批发价结算金额
	private String start_time;//开始时间
	private String end_time;//结束时间
	private String is_settlement;//是否已结算 0:未结算 1:已结算
	private String is_settlement_show;//是否已结算 0:未结算 1:已结算
	private String settlement_time;//结算时间
	private String is_commission;//是否结算佣金 0:不可结算 1:可以结算 2:已经结算
	private String is_commission_show;//是否结算佣金 0:不可结算 1:可以结算 2:已经结算
	private String commission_price;//佣金金额
	private String commission_merchants_id;//佣金商家id
	private String commission_merchants_name;//佣金商家名称
	private String commission_time;//佣金结算时间
	
	private OrderAddressBean orderAddressBean;//订单收件人地址信息
	private OrderLogisticsBean orderLogisticsBean;//订单发件人地址信息
	private List<OrderGoodsBean> orderGoodsBeans;
	private List<OrderActivityBean> orderActivityBeans;
	
	
	public int getOrder_merchants_id() {
		return order_merchants_id;
	}
	public OrderMerchantsBean setOrder_merchants_id(int order_merchants_id) {
		this.order_merchants_id = order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no() {
		return order_merchants_no;
	}
	public OrderMerchantsBean setOrder_merchants_no(String order_merchants_no) {
		this.order_merchants_no = order_merchants_no;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderMerchantsBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public OrderMerchantsBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public OrderMerchantsBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	
	public String getMerchants_name() {
		return merchants_name;
	}
	public OrderMerchantsBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	
	public String getMember_id(){
		return member_id;
	}
	public OrderMerchantsBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getOrder_total_price(){
		return order_total_price;
	}
	public OrderMerchantsBean setOrder_total_price(String order_total_price){
		this.order_total_price= order_total_price;
		return this;
	}
	public String getOrder_actual_price(){
		return order_actual_price;
	}
	public OrderMerchantsBean setOrder_actual_price(String order_actual_price){
		this.order_actual_price= order_actual_price;
		return this;
	}
	
	public String getGoods_total_price() {
		return goods_total_price;
	}
	public OrderMerchantsBean setGoods_total_price(String goods_total_price) {
		this.goods_total_price = goods_total_price;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public OrderMerchantsBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getGoods_min_time() {
		return goods_min_time;
	}
	public OrderMerchantsBean setGoods_min_time(String goods_min_time) {
		this.goods_min_time = goods_min_time;
		return this;
	}
	public String getGoods_max_time() {
		return goods_max_time;
	}
	public OrderMerchantsBean setGoods_max_time(String goods_max_time) {
		this.goods_max_time = goods_max_time;
		return this;
	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public OrderMerchantsBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;
	}
	
	public String getReduce_price() {
		return reduce_price;
	}
	public OrderMerchantsBean setReduce_price(String reduce_price) {
		this.reduce_price = reduce_price;
		return this;
	}
	
	public String getFreight_price() {
		return freight_price;
	}
	public OrderMerchantsBean setFreight_price(String freight_price) {
		this.freight_price = freight_price;
		return this;
	}
	public String getOrder_type(){
		return order_type;
	}
	public OrderMerchantsBean setOrder_type(String order_type){
		this.order_type= order_type;
		this.order_type_show="goods".equals(order_type)?"正常下单":
							"scene".equals(order_type)?"场景订单":"非正常下单";
		return this;
	}
	public String getOrder_type_show() {
		return order_type_show;
	}
	public OrderMerchantsBean setOrder_type_show(String order_type_show) {
		this.order_type_show = order_type_show;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	
	public OrderMerchantsBean setOrder_state(String order_state){
		this.order_state = order_state;
		this.order_state_show=  "cancel".equals(order_state)?"已取消":
								"pay_cancel".equals(order_state)?"已取消发货":
								"wait_pay".equals(order_state)?"待付款":
								"wait_send".equals(order_state)?"待发货":
								"wait_receive".equals(order_state)?"待收货":
								"wait_assessment".equals(order_state)?"待评价":
								"end".equals(order_state)?"已完成":
								"refund".equals(order_state)?"已完全退款":
								"close".equals(order_state)?"已结算":
								"wait_use".equals(order_state)?"未使用":
								"have_been_used".equals(order_state)?"已使用":"未知状态";
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderMerchantsBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getOrder_remark(){
		return order_remark;
	}
	public OrderMerchantsBean setOrder_remark(String order_remark){
		this.order_remark= order_remark;
		return this;
	}
	
	public String getIs_deduction_integral() {
		return is_deduction_integral;
	}
	public OrderMerchantsBean setIs_deduction_integral(String is_deduction_integral) {
		this.is_deduction_integral = is_deduction_integral;
		return this;
	}
	public String getDeduction_integral_value() {
		return deduction_integral_value;
	}
	public OrderMerchantsBean setDeduction_integral_value(String deduction_integral_value) {
		this.deduction_integral_value = deduction_integral_value;
		return this;
	}
	public String getDeduction_integral_price() {
		return deduction_integral_price;
	}
	public OrderMerchantsBean setDeduction_integral_price(String deduction_integral_price) {
		this.deduction_integral_price = deduction_integral_price;
		return this;
	}
	
	public String getInvoice_id() {
		return invoice_id;
	}
	public OrderMerchantsBean setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
		return this;
	}
	public String getReconciliation_state() {
		return reconciliation_state;
	}
	public OrderMerchantsBean setReconciliation_state(String reconciliation_state) {
		this.reconciliation_state = reconciliation_state;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderMerchantsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderMerchantsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderMerchantsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public String getCancel_time() {
		return cancel_time;
	}
	public OrderMerchantsBean setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
		return this;
	}
	public String getReceive_time() {
		return receive_time;
	}
	
	public String getPay_time() {
		return pay_time;
	}
	public OrderMerchantsBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}
	public OrderMerchantsBean setReceive_time(String receive_time) {
		this.receive_time = receive_time;
		return this;
	}
	
	public String getAssessment_time() {
		return assessment_time;
	}
	public OrderMerchantsBean setAssessment_time(String assessment_time) {
		this.assessment_time = assessment_time;
		return this;
	}
	
	public String getSend_time() {
		return send_time;
	}
	public OrderMerchantsBean setSend_time(String send_time) {
		this.send_time = send_time;
		return this;
	}
	
	
	
	public String getClose_time() {
		return close_time;
	}
	public OrderMerchantsBean setClose_time(String close_time) {
		this.close_time = close_time;
		return this;
	}
	
	
	public String getPay_way() {
		return pay_way;
	}
	public OrderMerchantsBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}
	
	
	public String getRefund_price() {
		return refund_price;
	}
	public OrderMerchantsBean setRefund_price(String refund_price) {
		this.refund_price = refund_price;
		return this;
	}
	public String getSettlement_price() {
		return settlement_price;
	}
	public OrderMerchantsBean setSettlement_price(String settlement_price) {
		this.settlement_price = settlement_price;
		return this;
	}
	
	public String getSettlement_wholesale_price() {
		return settlement_wholesale_price;
	}
	public OrderMerchantsBean setSettlement_wholesale_price(String settlement_wholesale_price) {
		this.settlement_wholesale_price = settlement_wholesale_price;
		return this;
	}
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public OrderMerchantsBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	
	public OrderLogisticsBean getOrderLogisticsBean() {
		return orderLogisticsBean;
	}
	public OrderMerchantsBean setOrderLogisticsBean(OrderLogisticsBean orderLogisticsBean) {
		this.orderLogisticsBean = orderLogisticsBean;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<OrderGoodsBean> getOrderGoodsBeans() {
		return orderGoodsBeans;
	}
	public OrderMerchantsBean setOrderGoodsBeans(List<OrderGoodsBean> orderGoodsBeans) {
		this.orderGoodsBeans = orderGoodsBeans;
		return this;
	}
	public List<OrderActivityBean> getOrderActivityBeans() {
		return orderActivityBeans;
	}
	public OrderMerchantsBean setOrderActivityBeans(List<OrderActivityBean> orderActivityBeans) {
		this.orderActivityBeans = orderActivityBeans;
		return this;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public OrderMerchantsBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public OrderMerchantsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getIs_settlement() {
		return is_settlement;
	}
	public OrderMerchantsBean setIs_settlement(String is_settlement) {
		this.is_settlement = is_settlement;
		this.is_settlement_show="1".equals(is_settlement)?"已结算":"未结算";
		return this;
	}
	public String getIs_settlement_show() {
		return is_settlement_show;
	}
	public OrderMerchantsBean setIs_settlement_show(String is_settlement_show) {
		this.is_settlement_show = is_settlement_show;
		return this;
	}
	
	public String getSettlement_time() {
		return settlement_time;
	}
	public OrderMerchantsBean setSettlement_time(String settlement_time) {
		this.settlement_time = settlement_time;
		return this;
	}
	public String getIs_commission() {
		return is_commission;
	}
	public OrderMerchantsBean setIs_commission(String is_commission) {
		this.is_commission = is_commission;
		this.is_commission_show="0".equals(is_commission)?"不可结算":
								"1".equals(is_commission)?"未结算":"已结算";
		return this;
	}
	public String getIs_commission_show() {
		return is_commission_show;
	}
	public OrderMerchantsBean setIs_commission_show(String is_commission_show) {
		this.is_commission_show = is_commission_show;
		return this;
	}
	public String getCommission_price() {
		return commission_price;
	}
	public OrderMerchantsBean setCommission_price(String commission_price) {
		this.commission_price = commission_price;
		return this;
	}
	public String getCommission_merchants_id() {
		return commission_merchants_id;
	}
	public OrderMerchantsBean setCommission_merchants_id(String commission_merchants_id) {
		this.commission_merchants_id = commission_merchants_id;
		return this;
	}
	public String getCommission_merchants_name() {
		return commission_merchants_name;
	}
	public OrderMerchantsBean setCommission_merchants_name(String commission_merchants_name) {
		this.commission_merchants_name = commission_merchants_name;
		return this;
	}
	public String getCommission_time() {
		return commission_time;
	}
	public OrderMerchantsBean setCommission_time(String commission_time) {
		this.commission_time = commission_time;
		return this;
	}
	
}
