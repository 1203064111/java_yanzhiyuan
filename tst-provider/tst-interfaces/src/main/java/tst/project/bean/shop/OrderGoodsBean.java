package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_goods_id;//
	private String order_id;//订单ID
	private String order_merchants_id;//订单详情ID
	private String merchants_id;//商家ID
	private String goods_id;//商品id
	private String goods_num;//购买数量
	private String goods_name;//商品名称
	private String goods_img;//商品图片连接
	private String goods_weight;//商品重量值
	private String goods_volume;//商品体积值
	
	private String brand_id;//品牌id
	private String brand_name;//品牌名称
	
	private String specification_id;//规格id
	private String specification_ids;//规格组合id
	private String specification_names;//规格组合名称
	private String specification_stock;//规格库存
	private String specification_img;//规格图片
	private String specification_price;//
	private String specification_cost_price;//成本价
	private String specification_wholesale_price;//批发价
	private String goods_actual_price;//用户实际支付计算出来的价格
	private String freight_id;//邮费id
	private String freight_type;//1:买家承担运费 2:卖家承担运费
	private String freight_way;//1:按件 2:按重 3:按体积
	private String freight_range;//默认范围 如果按件 就是默认多少件  如果按体重 就是默认多少kg  如果按体积 就是默认多少平方米
	private String freight_price;//默认运费价格
	private String freight_add_range;//增加运费范围 如果按件 就是每增加多少件  如果按体重 就是每增加多少kg  如果按体积 就是每增加多少平方米
	private String freight_add_price;//增加运费价格
	private String free_range;//免邮的设置范围 （件/重量/体积）

	private String refund_price;//此商品分配的可退款金额
	private String refund_end_price;//此商品已退款金额
	private String refund_count;//退款数量
	private String refund_state;//0还未申请 cancel:取消  wait_review：等待审核  accept:接受 refuse：拒绝 refund_ing:退款中 refund_fail:退款失败 end:退款成功  
	private String refund_state_show;
	private String is_descending;//0:参加直降活动了  1:未参加直降活动
	private String is_descending_show;//0:参加直降活动了  1:未参加直降活动
	private String activity_price;//活动价
	private String is_delete;//
	private String goods_min_time;//最远时间
	private String goods_max_time;//最近时间
	private String create_time;//
	private String update_time;//
	
	
	public int getOrder_goods_id(){
		return order_goods_id;
	}
	public OrderGoodsBean setOrder_goods_id(int order_goods_id){
		this.order_goods_id= order_goods_id;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public OrderGoodsBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getOrder_merchants_id() {
		return order_merchants_id;
	}
	public OrderGoodsBean setOrder_merchants_id(String order_merchants_id) {
		this.order_merchants_id = order_merchants_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public OrderGoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public OrderGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_num(){
		return goods_num;
	}
	public OrderGoodsBean setGoods_num(String goods_num){
		this.goods_num= goods_num;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public OrderGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getGoods_img(){
		return goods_img;
	}
	public OrderGoodsBean setGoods_img(String goods_img){
		this.goods_img= goods_img;
		return this;
	}
	
	public String getGoods_weight() {
		return goods_weight;
	}
	public OrderGoodsBean setGoods_weight(String goods_weight) {
		this.goods_weight = goods_weight;
		return this;
	}
	public String getGoods_volume() {
		return goods_volume;
	}
	public OrderGoodsBean setGoods_volume(String goods_volume) {
		this.goods_volume = goods_volume;
		return this;
	}
	
	
	
	
	public String getBrand_id() {
		return brand_id;
	}
	public OrderGoodsBean setBrand_id(String brand_id) {
		this.brand_id = brand_id;
		return this;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public OrderGoodsBean setBrand_name(String brand_name) {
		this.brand_name = brand_name;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public OrderGoodsBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getSpecification_ids(){
		return specification_ids;
	}
	public OrderGoodsBean setSpecification_ids(String specification_ids){
		this.specification_ids= specification_ids;
		return this;
	}
	public String getSpecification_names(){
		return specification_names;
	}
	public OrderGoodsBean setSpecification_names(String specification_names){
		this.specification_names= specification_names;
		return this;
	}
	public String getSpecification_stock(){
		return specification_stock;
	}
	public OrderGoodsBean setSpecification_stock(String specification_stock){
		this.specification_stock= specification_stock;
		return this;
	}
	public String getSpecification_img(){
		return specification_img;
	}
	public OrderGoodsBean setSpecification_img(String specification_img){
		this.specification_img= specification_img;
		return this;
	}
	public String getSpecification_price(){
		return specification_price;
	}
	public OrderGoodsBean setSpecification_price(String specification_price){
		this.specification_price= specification_price;
		return this;
	}
	public String getSpecification_cost_price(){
		return specification_cost_price;
	}
	public OrderGoodsBean setSpecification_cost_price(String specification_cost_price){
		this.specification_cost_price= specification_cost_price;
		return this;
	}
	public String getSpecification_wholesale_price(){
		return specification_wholesale_price;
	}
	public OrderGoodsBean setSpecification_wholesale_price(String specification_wholesale_price){
		this.specification_wholesale_price= specification_wholesale_price;
		return this;
	}
	
	public String getGoods_actual_price() {
		return goods_actual_price;
	}
	public OrderGoodsBean setGoods_actual_price(String goods_actual_price) {
		this.goods_actual_price = goods_actual_price;
		return this;
	}
	
	public String getFreight_id() {
		return freight_id;
	}
	public OrderGoodsBean setFreight_id(String freight_id) {
		this.freight_id = freight_id;
		return this;
	}
	
	public String getFreight_type() {
		return freight_type;
	}
	public OrderGoodsBean setFreight_type(String freight_type) {
		this.freight_type = freight_type;
		return this;
	}
	public String getFreight_way() {
		return freight_way;
	}
	public OrderGoodsBean setFreight_way(String freight_way) {
		this.freight_way = freight_way;
		return this;
	}
	public String getFreight_range() {
		return freight_range;
	}
	public OrderGoodsBean setFreight_range(String freight_range) {
		this.freight_range = freight_range;
		return this;
	}
	public String getFreight_price() {
		return freight_price;
	}
	public OrderGoodsBean setFreight_price(String freight_price) {
		this.freight_price = freight_price;
		return this;
	}
	public String getFreight_add_range() {
		return freight_add_range;
	}
	public OrderGoodsBean setFreight_add_range(String freight_add_range) {
		this.freight_add_range = freight_add_range;
		return this;
	}
	public String getFreight_add_price() {
		return freight_add_price;
	}
	public OrderGoodsBean setFreight_add_price(String freight_add_price) {
		this.freight_add_price = freight_add_price;
		return this;
	}
	public String getFree_range() {
		return free_range;
	}
	public OrderGoodsBean setFree_range(String free_range) {
		this.free_range = free_range;
		return this;
	}
	public String getRefund_price() {
		return refund_price;
	}
	public OrderGoodsBean setRefund_price(String refund_price) {
		this.refund_price = refund_price;
		return this;
	}
	public String getRefund_end_price() {
		return refund_end_price;
	}
	public OrderGoodsBean setRefund_end_price(String refund_end_price) {
		this.refund_end_price = refund_end_price;
		return this;
	}
	public String getRefund_count() {
		return refund_count;
	}
	public OrderGoodsBean setRefund_count(String refund_count) {
		this.refund_count = refund_count;
		return this;
	}
	public String getRefund_state() {
		return refund_state;
	}
	public OrderGoodsBean setRefund_state(String refund_state) {
		this.refund_state = refund_state;
		this.refund_state_show = "0".equals(refund_state)?"未申请":
								("cancel".equals(refund_state)?"已取消":
								("wait_review".equals(refund_state)?"等待审核":
								("accept".equals(refund_state)?"接受退款":
								("refuse".equals(refund_state)?"拒绝退款":
								("refund_ing".equals(refund_state)?"退款中":
								("refund_fail".equals(refund_state)?"退款失败":
								("end".equals(refund_state)?"退款成功":"未知状态")))))));
		return this;
	}
	
	public String getRefund_state_show() {
		return refund_state_show;
	}
	public OrderGoodsBean setRefund_state_show(String refund_state_show) {
		this.refund_state_show = refund_state_show;
		return this;
	}
	public String getIs_descending() {
		return is_descending;
	}
	public OrderGoodsBean setIs_descending(String is_descending) {
		this.is_descending = is_descending;
		this.is_descending_show = "0".equals(is_descending)?"已参加直降":"未参加直降";
		return this;
	}
	public String getIs_descending_show() {
		return is_descending_show;
	}
	public OrderGoodsBean setIs_descending_show(String is_descending_show) {
		this.is_descending_show = is_descending_show;
		return this;
	}
	public String getActivity_price() {
		return activity_price;
	}
	public OrderGoodsBean setActivity_price(String activity_price) {
		this.activity_price = activity_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getGoods_min_time() {
		return goods_min_time;
	}
	public OrderGoodsBean setGoods_min_time(String goods_min_time) {
		this.goods_min_time = goods_min_time;
		return this;
	}
	public String getGoods_max_time() {
		return goods_max_time;
	}
	public OrderGoodsBean setGoods_max_time(String goods_max_time) {
		this.goods_max_time = goods_max_time;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	
}
