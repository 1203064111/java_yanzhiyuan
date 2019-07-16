package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ShopMemberCouponBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_coupon_id;//
	private String member_id;//用户id
	
	private String member_coupon_state;//1:未使用 2:使用 3:已过期
	private String coupon_start_time;//
	private String coupon_end_time;//
	private String coupon_id;//优惠券id
	private String coupon_name;//优惠券名称
	private String coupon_desc;//优惠券描述
	private String coupon_way;//1:立减 2:折扣
	private String coupon_way_show;//1:立减 2:折扣
	private String coupon_full_price;//满足使用条件的金额
	private String coupon_price;//优惠金额
	private String percent;//折扣比例

	
	private String is_delete;//0:未删除 1:删除
	private String create_time;//
	private String update_time;//
	public int getMember_coupon_id() {
		return member_coupon_id;
	}
	public ShopMemberCouponBean setMember_coupon_id(int member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public ShopMemberCouponBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_coupon_state() {
		return member_coupon_state;
	}
	public ShopMemberCouponBean setMember_coupon_state(String member_coupon_state) {
		this.member_coupon_state = member_coupon_state;
		return this;
	}
	public String getCoupon_start_time() {
		return coupon_start_time;
	}
	public ShopMemberCouponBean setCoupon_start_time(String coupon_start_time) {
		this.coupon_start_time = coupon_start_time;
		return this;
	}
	public String getCoupon_end_time() {
		return coupon_end_time;
	}
	public ShopMemberCouponBean setCoupon_end_time(String coupon_end_time) {
		this.coupon_end_time = coupon_end_time;
		return this;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public ShopMemberCouponBean setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public ShopMemberCouponBean setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
		return this;
	}
	public String getCoupon_desc() {
		return coupon_desc;
	}
	public ShopMemberCouponBean setCoupon_desc(String coupon_desc) {
		this.coupon_desc = coupon_desc;
		return this;
	}
	public String getCoupon_way() {
		return coupon_way;
	}
	public ShopMemberCouponBean setCoupon_way(String coupon_way) {
		this.coupon_way = coupon_way;
		return this;
	}
	public String getCoupon_way_show() {
		return coupon_way_show;
	}
	public ShopMemberCouponBean setCoupon_way_show(String coupon_way_show) {
		this.coupon_way_show = coupon_way_show;
		return this;
	}
	public String getCoupon_full_price() {
		return coupon_full_price;
	}
	public ShopMemberCouponBean setCoupon_full_price(String coupon_full_price) {
		this.coupon_full_price = coupon_full_price;
		return this;
	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public ShopMemberCouponBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;
	}
	public String getPercent() {
		return percent;
	}
	public ShopMemberCouponBean setPercent(String percent) {
		this.percent = percent;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ShopMemberCouponBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ShopMemberCouponBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ShopMemberCouponBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}

}
