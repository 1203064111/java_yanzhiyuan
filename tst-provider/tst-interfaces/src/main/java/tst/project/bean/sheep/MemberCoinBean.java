package tst.project.bean.sheep;

import java.io.Serializable;

import tst.project.bean.shop.ShopMemberCouponBean;

public class MemberCoinBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int use_id;
	private String member_id;
	private String use_type;
	private String use_type_show;//1 认养券优惠券兑换 ,2商品兑换，3商品换购,4集市券兑换,5
	private String is_delete;
	private String create_time;
	private String update_time;
	private String shop_id;
	private String coupon_id;
	private String member_coupon_id;
	private String member_goods_id;
	private String order_id;
	private String use_coin;//用掉的数量
	private ShopGoodsBean shopBean;
	private SheepCouponBean sheepCouponBean;
	private String exchange_num;//换购数量
	private OrderSheepBean orderSheepBean;
	private ShopMemberCouponBean shopMemberCouponBean;
	
	
	
	public ShopMemberCouponBean getShopMemberCouponBean() {
		return shopMemberCouponBean;
	}
	public MemberCoinBean setShopMemberCouponBean(ShopMemberCouponBean shopMemberCouponBean) {
		this.shopMemberCouponBean = shopMemberCouponBean;
		return this;
	}
	public String getMember_coupon_id() {
		return member_coupon_id;
	}
	public MemberCoinBean setMember_coupon_id(String member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
		return this;
	}
	public String getMember_goods_id() {
		return member_goods_id;
	}
	public MemberCoinBean setMember_goods_id(String member_goods_id) {
		this.member_goods_id = member_goods_id;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public MemberCoinBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getUse_coin() {
		return use_coin;
	}
	public MemberCoinBean setUse_coin(String use_coin) {
		this.use_coin = use_coin;
		return this;
	}
	public OrderSheepBean getOrderSheepBean() {
		return orderSheepBean;
	}
	public MemberCoinBean setOrderSheepBean(OrderSheepBean orderSheepBean) {
		this.orderSheepBean = orderSheepBean;
		return this;
	}
	public String getExchange_num() {
		return exchange_num;
	}
	public MemberCoinBean setExchange_num(String exchange_num) {
		this.exchange_num = exchange_num;
		return this;
	}
	public int getUse_id() {
		return use_id;
	}
	public MemberCoinBean setUse_id(int use_id) {
		this.use_id = use_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberCoinBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getUse_type() {
		return use_type;
	}
	public MemberCoinBean setUse_type(String use_type) {
		this.use_type = use_type;
		this.use_type_show="1".equals(use_type)?"认养优惠券兑换"
			:"2".equals(use_type)?"商品兑换"
			:"3".equals(use_type)?"商品换购":"商品优惠券兑换";
		return this;
	}
	public String getUse_type_show() {
		return use_type_show;
	}
	public MemberCoinBean setUse_type_show(String use_type_show) {
		this.use_type_show = use_type_show;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberCoinBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberCoinBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberCoinBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getShop_id() {
		return shop_id;
	}
	public MemberCoinBean setShop_id(String shop_id) {
		this.shop_id = shop_id;
		return this;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public MemberCoinBean setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}
	public ShopGoodsBean getShopBean() {
		return shopBean;
	}
	public MemberCoinBean setShopBean(ShopGoodsBean shopBean) {
		this.shopBean = shopBean;
		return this;
	}
	public SheepCouponBean getSheepCouponBean() {
		return sheepCouponBean;
	}
	public MemberCoinBean setSheepCouponBean(SheepCouponBean sheepCouponBean) {
		this.sheepCouponBean = sheepCouponBean;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
