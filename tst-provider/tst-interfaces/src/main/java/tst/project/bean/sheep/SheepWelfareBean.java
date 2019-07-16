package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.shop.ShopCouponBean;

public class SheepWelfareBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String welfare_id;
	private String create_time;
	private String update_time;
	private String is_delete;
	private String welfare_time;//体验时间
	private String vaild_day;//有效天数
	private String coupon_name;
	private List<WelfareCouponBean> welfareCouponBeans;
	private List<ShopCouponBean> shopCouponBeans;
	
	
	
	
	
	
	public List<ShopCouponBean> getShopCouponBeans() {
		return shopCouponBeans;
	}
	public SheepWelfareBean setShopCouponBeans(List<ShopCouponBean> shopCouponBeans) {
		this.shopCouponBeans = shopCouponBeans;
		return this;
	}
	public String getVaild_day() {
		return vaild_day;
	}
	public SheepWelfareBean setVaild_day(String vaild_day) {
		this.vaild_day = vaild_day;
		return this;
	}
	public List<WelfareCouponBean> getWelfareCouponBeans() {
		return welfareCouponBeans;
	}
	public SheepWelfareBean setWelfareCouponBeans(List<WelfareCouponBean> welfareCouponBeans) {
		this.welfareCouponBeans = welfareCouponBeans;
		return this;
	}
	
	public String getWelfare_id() {
		return welfare_id;
	}
	public SheepWelfareBean setWelfare_id(String welfare_id) {
		this.welfare_id = welfare_id;
		return this;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public SheepWelfareBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepWelfareBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepWelfareBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getWelfare_time() {
		return welfare_time;
	}
	public SheepWelfareBean setWelfare_time(String welfare_time) {
		this.welfare_time = welfare_time;
		return this;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public SheepWelfareBean setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
		return this;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
