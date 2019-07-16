package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ShopCouponSignBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sign_id;//
	private String member_id;//用户id
	private String coupon_id;//优惠券id
	private String sign_time;//签到时间
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getSign_id(){
		return sign_id;
	}
	public ShopCouponSignBean setSign_id(int sign_id){
		this.sign_id= sign_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public ShopCouponSignBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getCoupon_id(){
		return coupon_id;
	}
	public ShopCouponSignBean setCoupon_id(String coupon_id){
		this.coupon_id= coupon_id;
		return this;
	}
	public String getSign_time(){
		return sign_time;
	}
	public ShopCouponSignBean setSign_time(String sign_time){
		this.sign_time= sign_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ShopCouponSignBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ShopCouponSignBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ShopCouponSignBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
