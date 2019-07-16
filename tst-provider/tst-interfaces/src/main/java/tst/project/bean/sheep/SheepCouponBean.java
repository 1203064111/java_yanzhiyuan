package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepCouponBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int coupon_id;
	private int member_id;
	private int member_coupon_id;
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
	private String coupon_need_coin;
	private String coupon_state;  //0,1 上下架    0,1,2未使用、已使用、已过期
	private String time_type;//0绝对时间，1相对时间
	private String time_type_show;//绝对时间，相对时间
	private String effective_day;
	private String take_num;//领取量
	private String used_num;//使用量
	private String coupon_type;//领取券、和兑换券  exchange ,get 兑换和领取
	private String coupon_type_show;//
	private String coupon_class;//0认养券、1合养券、2集市券
	private String coupon_class_show;
	
	
	
	
	
	
	
	
	
	public String getCoupon_class() {
		return coupon_class;
	}
	public SheepCouponBean setCoupon_class(String coupon_class) {
		this.coupon_class = coupon_class;
		this.coupon_class_show="1".equals(coupon_class)?"合养券":"认养券";
		return this;
	}
	public String getCoupon_class_show() {
		return coupon_class_show;
	}
	public SheepCouponBean setCoupon_class_show(String coupon_class_show) {
		this.coupon_class_show = coupon_class_show;
		return this;
	}
	public String getTime_type_show() {
		return time_type_show;
	}
	public SheepCouponBean setTime_type_show(String time_type_show) {
		this.time_type_show = time_type_show;
		return this;
	}
	public String getCoupon_type_show() {
		return coupon_type_show;
	}
	public SheepCouponBean setCoupon_type_show(String coupon_type_show) {
		this.coupon_type_show = coupon_type_show;
		return this;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public SheepCouponBean setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
		this.coupon_type_show="exchange".equals(coupon_type)?"兑换":"领取";
		return this;
	}
	public String getTake_num() {
		return take_num;
	}
	public SheepCouponBean setTake_num(String take_num) {
		this.take_num = take_num;
		return this;
	}
	public String getUsed_num() {
		return used_num;
	}
	public SheepCouponBean setUsed_num(String used_num) {
		this.used_num = used_num;
		return this;
	}
	public String getCoupon_img() {
		return coupon_img;
	}
	public SheepCouponBean setCoupon_img(String coupon_img) {
		this.coupon_img = coupon_img;
		return this;
	}
	
	public String getEffective_day() {
		return effective_day;
	}
	public SheepCouponBean setEffective_day(String effective_day) {
		this.effective_day = effective_day;
		return this;
	}
	public String getTime_type() {
		return time_type;
	}
	public SheepCouponBean setTime_type(String time_type) {
		this.time_type = time_type;
		this.time_type_show="0".equals(time_type)?"绝对时间":"相对时间";
		return this;
	}
	
	public int getCoupon_id() {
		return coupon_id;
	}
	public SheepCouponBean setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public SheepCouponBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;

	}
	public int getMember_coupon_id() {
		return member_coupon_id;
	}
	public SheepCouponBean setMember_coupon_id(int member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
		return this;

	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public SheepCouponBean setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
		return this;

	}
	public String getCoupon_price() {
		return coupon_price;
	}
	public SheepCouponBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;

	}
	public String getCoupon_desc() {
		return coupon_desc;
	}
	public SheepCouponBean setCoupon_desc(String coupon_desc) {
		this.coupon_desc = coupon_desc;
		return this;

	}
	public String getStart_time() {
		return start_time;
	}
	public SheepCouponBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;

	}
	public String getEnd_time() {
		return end_time;
	}
	public SheepCouponBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;

	}
	public String getStart_use_time() {
		return start_use_time;
	}
	public SheepCouponBean setStart_use_time(String start_use_time) {
		this.start_use_time = start_use_time;
		return this;

	}
	public String getEnd_use_time() {
		return end_use_time;
	}
	public SheepCouponBean setEnd_use_time(String end_use_time) {
		this.end_use_time = end_use_time;
		return this;

	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepCouponBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;

	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepCouponBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;

	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepCouponBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;

	}
	public String getCoupon_need_coin() {
		return coupon_need_coin;
	}
	public SheepCouponBean setCoupon_need_coin(String coupon_need_coin) {
		this.coupon_need_coin = coupon_need_coin;
		return this;

	}
	public String getCoupon_state() {
		return coupon_state;
	}
	public SheepCouponBean setCoupon_state(String coupon_state) {
		this.coupon_state = coupon_state;
		return this;

	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
