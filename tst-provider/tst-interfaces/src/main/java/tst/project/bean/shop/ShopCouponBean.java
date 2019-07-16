package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ShopCouponBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int coupon_id;//
	private String coupon_ids;//传递_id
	
	private String coupon_name;//优惠券名称
	private String coupon_desc;//优惠券描述
	private String coupon_way;//1:立减 2:折扣
	private String coupon_way_show;//1:立减 2:折扣
	private String coupon_full_price;//满足使用条件的金额
	private String coupon_price;//立减金额
	private String percent;//折扣比例
	private String coupon_state;//0无效 1有效
	private String coupon_state_show;
	
	private String start_time;//优惠开始时间
	private String end_time;//优惠结束时间
	private String issue_num;//发行数量
	private String remain_num;//剩余数量
	
	private String is_delete;//0:未删除 1:删除
	private String create_time;//
	private String update_time;//
	private String people_limit;//单人领取上限
	
	
	
	public String getRemain_num() {
		return remain_num;
	}
	public ShopCouponBean setRemain_num(String remain_num) {
		this.remain_num = remain_num;
		return this;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public ShopCouponBean setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}
	public String getCoupon_ids() {
		return coupon_ids;
	}
	public ShopCouponBean setCoupon_ids(String coupon_ids) {
		this.coupon_ids = coupon_ids;
		return this;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public ShopCouponBean setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
		return this;
	}
	public String getCoupon_desc() {
		return coupon_desc;
	}
	public ShopCouponBean setCoupon_desc(String coupon_desc) {
		this.coupon_desc = coupon_desc;
		return this;
	}
	public String getCoupon_way() {
		return coupon_way;
	}
	public ShopCouponBean setCoupon_way(String coupon_way) {
		this.coupon_way = coupon_way;
		this.coupon_way_show = "1".equals(coupon_way)?"满额立减":"2".equals(coupon_way)?"满额折扣":"";
		return this;
	}
	public String getCoupon_way_show() {
		return coupon_way_show;
	}
	public ShopCouponBean setCoupon_way_show(String coupon_way_show) {
		this.coupon_way_show = coupon_way_show;
		return this;
	}
	public String getCoupon_full_price() {
		return coupon_full_price;
	}
	public ShopCouponBean setCoupon_full_price(String coupon_full_price) {
		this.coupon_full_price = coupon_full_price;
		return this;
	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public ShopCouponBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;
	}
	public String getPercent() {
		return percent;
	}
	public ShopCouponBean setPercent(String percent) {
		this.percent = percent;
		return this;
	}
	public String getCoupon_state() {
		return coupon_state;
	}
	public ShopCouponBean setCoupon_state(String coupon_state) {
		this.coupon_state = coupon_state;
		return this;
	}
	public String getCoupon_state_show() {
		return coupon_state_show;
	}
	public ShopCouponBean setCoupon_state_show(String coupon_state_show) {
		this.coupon_state_show = coupon_state_show;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public ShopCouponBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public ShopCouponBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getIssue_num() {
		return issue_num;
	}
	public ShopCouponBean setIssue_num(String issue_num) {
		this.issue_num = issue_num;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ShopCouponBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ShopCouponBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ShopCouponBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getPeople_limit() {
		return people_limit;
	}
	public ShopCouponBean setPeople_limit(String people_limit) {
		this.people_limit = people_limit;
		return this;
	}
	
	
}
