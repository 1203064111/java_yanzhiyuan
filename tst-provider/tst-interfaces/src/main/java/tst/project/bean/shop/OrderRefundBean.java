package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class OrderRefundBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int refund_id;//
	private String member_id;//
	private String merchants_id;//商家ID
	private String order_merchants_id;//
	private String order_merchants_no;//
	private String order_goods_id;//
	private String refund_type;//1:退款订单 2:退换货
	private String refund_type_show;
	private String refund_no;//退款号
	private String refund_count;//退货数量
	private String refund_desc;//退货原因描述
	private String refund_state;//cancel:取消  wait_review：等待审核  accept:接受 refuse：拒绝 refund_ing:退款中 refund_fail:退款失败 end:退款成功  distributor_accept:分销商接受 distributor_refuse:分销商拒绝
	private String refund_state_show;//
	private String refund_price;//退款金额
	private String refund_reason_id;//拒绝理由id
	private String reason_name;//拒绝理由内容
	private String refund_imgs;//退款图片
	private String specification_price;//商品单价
	private String is_read;//是否读过
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String cancel_time;//取消时间
	private String send_time;//退货订单物流发货时间
	private String logistics_no;//快递单号
	private String logistics_name;//logistics_name
	private String logistics_pinyin;//logistics_pinyin
	
	private String start_time;//搜索开始时间
	private String end_time;//搜索结束时间
	
	private OrderAddressBean orderAddressBean;
	private OrderGoodsBean orderGoodsBean;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getRefund_id(){
		return refund_id;
	}
	public OrderRefundBean setRefund_id(int refund_id){
		this.refund_id= refund_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderRefundBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public OrderRefundBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderRefundBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_merchants_no(){
		return order_merchants_no;
	}
	public OrderRefundBean setOrder_merchants_no(String order_merchants_no){
		this.order_merchants_no= order_merchants_no;
		return this;
	}
	public String getOrder_goods_id(){
		return order_goods_id;
	}
	public OrderRefundBean setOrder_goods_id(String order_goods_id){
		this.order_goods_id= order_goods_id;
		return this;
	}
	public String getRefund_type(){
		return refund_type;
	}
	public OrderRefundBean setRefund_type(String refund_type){
		this.refund_type= refund_type;
		this.refund_type_show="1".equals(refund_type)?"仅退款":
							 ("2".equals(refund_type)?"换货":
							 ("3".equals(refund_type)?"退货退款":"未知类型"));
		return this;
	}
	public String getRefund_type_show(){
		return refund_type_show;
	}
	public OrderRefundBean setRefund_type_show(String refund_type_show){
		this.refund_type_show= refund_type_show;
		return this;
	}
	public String getRefund_no(){
		return refund_no;
	}
	public OrderRefundBean setRefund_no(String refund_no){
		this.refund_no= refund_no;
		return this;
	}
	public String getRefund_count(){
		return refund_count;
	}
	public OrderRefundBean setRefund_count(String refund_count){
		this.refund_count= refund_count;
		return this;
	}
	public String getRefund_desc(){
		return refund_desc;
	}
	public OrderRefundBean setRefund_desc(String refund_desc){
		this.refund_desc= refund_desc;
		return this;
	}
	public String getRefund_state(){
		return refund_state;
	}
	
	public OrderRefundBean setRefund_state(String refund_state){
		this.refund_state = refund_state;
		this.refund_state_show="cancel".equals(refund_state)?"已取消":
							  ("wait_review".equals(refund_state)?"等待审核":
							  ("accept".equals(refund_state)?"接受退款":
							  ("refuse".equals(refund_state)?"拒绝退款":
							  ("refund_ing".equals(refund_state)?"退款中":
							  ("refund_fail".equals(refund_state)?"退款失败":
							  ("end".equals(refund_state)?"已退款":"未知状态"))))));
		return this;
	}
	public String getRefund_state_show() {
		return refund_state_show;
	}
	public OrderRefundBean setRefund_state_show(String refund_state_show) {
		this.refund_state_show = refund_state_show;
		return this;
	}
	public String getRefund_price(){
		return refund_price;
	}
	public OrderRefundBean setRefund_price(String refund_price){
		this.refund_price= refund_price;
		return this;
	}
	public String getRefund_reason_id(){
		return refund_reason_id;
	}
	public OrderRefundBean setRefund_reason_id(String refund_reason_id){
		this.refund_reason_id= refund_reason_id;
		return this;
	}
	public String getReason_name(){
		return reason_name;
	}
	public OrderRefundBean setReason_name(String reason_name){
		this.reason_name= reason_name;
		return this;
	}
	
	public String getRefund_imgs() {
		return refund_imgs;
	}
	public OrderRefundBean setRefund_imgs(String refund_imgs) {
		this.refund_imgs = refund_imgs;
		return this;
	}
	
	public String getSpecification_price() {
		return specification_price;
	}
	public OrderRefundBean setSpecification_price(String specification_price) {
		this.specification_price = specification_price;
		return this;
	}
	public String getIs_read(){
		return is_read;
	}
	public OrderRefundBean setIs_read(String is_read){
		this.is_read= is_read;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderRefundBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderRefundBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderRefundBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	
	public String getCancel_time() {
		return cancel_time;
	}
	public OrderRefundBean setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
		return this;
	}
	
	
	public String getSend_time() {
		return send_time;
	}
	public OrderRefundBean setSend_time(String send_time) {
		this.send_time = send_time;
		return this;
	}
	public String getLogistics_no() {
		return logistics_no;
	}
	public OrderRefundBean setLogistics_no(String logistics_no) {
		this.logistics_no = logistics_no;
		return this;
	}
	public String getLogistics_name() {
		return logistics_name;
	}
	public OrderRefundBean setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
		return this;
	}
	public String getLogistics_pinyin() {
		return logistics_pinyin;
	}
	public OrderRefundBean setLogistics_pinyin(String logistics_pinyin) {
		this.logistics_pinyin = logistics_pinyin;
		return this;
	}
	
	
	public String getStart_time() {
		return start_time;
	}
	public OrderRefundBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public OrderRefundBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public OrderRefundBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	public OrderGoodsBean getOrderGoodsBean() {
		return orderGoodsBean;
	}
	public OrderRefundBean setOrderGoodsBean(OrderGoodsBean orderGoodsBean) {
		this.orderGoodsBean = orderGoodsBean;
		return this;
	}
	
	
}
