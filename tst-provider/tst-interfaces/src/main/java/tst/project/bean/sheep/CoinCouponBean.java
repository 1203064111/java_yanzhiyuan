package tst.project.bean.sheep;

import java.io.Serializable;

public class CoinCouponBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int shop_coupon_id;
	private String coupon_id;
	private String coupon_need_price;
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getShop_coupon_id() {
		return shop_coupon_id;
	}
	public CoinCouponBean setShop_coupon_id(int shop_coupon_id) {
		this.shop_coupon_id = shop_coupon_id;
		return this;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public CoinCouponBean setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}
	public String getCoupon_need_price() {
		return coupon_need_price;
	}
	public CoinCouponBean setCoupon_need_price(String coupon_need_price) {
		this.coupon_need_price = coupon_need_price;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CoinCouponBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CoinCouponBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public CoinCouponBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
