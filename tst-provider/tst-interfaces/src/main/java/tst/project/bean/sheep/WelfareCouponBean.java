package tst.project.bean.sheep;

import java.io.Serializable;

import tst.project.bean.shop.ShopCouponBean;

public class WelfareCouponBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int welfare_coupon_id;
	private String shop_coupon_id;
	private String welfare_type;//1，认养合养优惠券，2集市优惠券
	private String welfare_id;
	private String coupon_id;
	private String coupon_id2;//表关联取别名时用
	private  String coupon_name;
	private String coupon_price;
	private String coupon_img;
	private String coupon_desc;
	private String start_time;
	private String end_time;
	private String start_use_time;
	private String end_use_time;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String coupon_state;  //0,1 上下架    0,1,2未使用、已使用、已过期
	private String time_type;
	private String effective_day;
	private String member_id;
	private String coupon_type;
	private String take_num;
	private String used_num;
	private String time_type_show;
	private String coupon_type_show;
	private String coupon_class;//0,认养券，1合养券
	
	private ShopCouponBean shopCouponBean;
	
	
	public ShopCouponBean getShopCouponBean() {
		return shopCouponBean;
	}
	public WelfareCouponBean setShopCouponBean(ShopCouponBean shopCouponBean) {
		this.shopCouponBean = shopCouponBean;
		return this;
	}
	public String getWelfare_type() {
		return welfare_type;
	}
	public WelfareCouponBean setWelfare_type(String welfare_type) {
		this.welfare_type = welfare_type;
		return this;
	}
	public String getShop_coupon_id() {
		return shop_coupon_id;
	}
	public WelfareCouponBean setShop_coupon_id(String shop_coupon_id) {
		this.shop_coupon_id = shop_coupon_id;
		return this;
	}
	public String getCoupon_class() {
		return coupon_class;
	}
	public WelfareCouponBean setCoupon_class(String coupon_class) {
		this.coupon_class = coupon_class;
		return this;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public WelfareCouponBean setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
		this.coupon_type_show="exchange".equals(coupon_type)?"兑换":"领取";
		return this;
	}
	public String getTake_num() {
		return take_num;
	}
	public WelfareCouponBean setTake_num(String take_num) {
		this.take_num = take_num;
		return this;
	}
	public String getUsed_num() {
		return used_num;
	}
	public WelfareCouponBean setUsed_num(String used_num) {
		this.used_num = used_num;
		return this;
	}
	public String getTime_type_show() {
		return time_type_show;
	}
	public WelfareCouponBean setTime_type_show(String time_type_show) {
		this.time_type_show = time_type_show;
		return this;
	}
	public String getCoupon_type_show() {
		return coupon_type_show;
	}
	public WelfareCouponBean setCoupon_type_show(String coupon_type_show) {
		this.coupon_type_show = coupon_type_show;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public WelfareCouponBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getCoupon_id2() {
		return coupon_id2;
	}
	public WelfareCouponBean setCoupon_id2(String coupon_id2) {
		this.coupon_id2 = coupon_id2;
		return this;
	}
	public int getWelfare_coupon_id() {
		return welfare_coupon_id;
	}
	public WelfareCouponBean setWelfare_coupon_id(int welfare_coupon_id) {
		this.welfare_coupon_id = welfare_coupon_id;
		return this;
	}
	public String getWelfare_id() {
		return welfare_id;
	}
	public WelfareCouponBean setWelfare_id(String welfare_id) {
		this.welfare_id = welfare_id;
		return this;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public WelfareCouponBean setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public WelfareCouponBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public WelfareCouponBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public WelfareCouponBean setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
		return this;
	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public WelfareCouponBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;
	}

	
	public String getCoupon_img() {
		return coupon_img;
	}
	public WelfareCouponBean setCoupon_img(String coupon_img) {
		this.coupon_img = coupon_img;
		return this;
	}
	public String getCoupon_desc() {
		return coupon_desc;
	}
	public WelfareCouponBean setCoupon_desc(String coupon_desc) {
		this.coupon_desc = coupon_desc;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public WelfareCouponBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public WelfareCouponBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getStart_use_time() {
		return start_use_time;
	}
	public WelfareCouponBean setStart_use_time(String start_use_time) {
		this.start_use_time = start_use_time;
		return this;
	}
	public String getEnd_use_time() {
		return end_use_time;
	}
	public WelfareCouponBean setEnd_use_time(String end_use_time) {
		this.end_use_time = end_use_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public WelfareCouponBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCoupon_state() {
		return coupon_state;
	}
	public WelfareCouponBean setCoupon_state(String coupon_state) {
		this.coupon_state = coupon_state;
		return this;
	}
	public String getTime_type() {
		return time_type;
	}
	public WelfareCouponBean setTime_type(String time_type) {
		this.time_type = time_type;
		this.time_type_show="0".equals(time_type)?"绝对时间":"相对时间";
		return this;
	}
	public String getEffective_day() {
		return effective_day;
	}
	public WelfareCouponBean setEffective_day(String effective_day) {
		this.effective_day = effective_day;
		return this;
	}
	
	
	

}
