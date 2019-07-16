package tst.project.bean.shop;

import java.io.Serializable;

public class ShopCarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int car_id;//购物车ID
	private String car_ids;//购物车ID组合
	private String member_id;//用户ID
	private String goods_id;//商品ID
	private String goods_name;//商品名称
	private String goods_img;//商品图片
	private String merchants_id;//医院ID/医生ID
	private String merchants_name;//医院名称 传输用
	private String merchants_img;//医院头像 传输用
	private int specification_id;
	private String specification_ids;
	private String specification_names;
	private String specification_price;//现价
	private String specification_wholesale_price;//会员价
	private String goods_num;//购买数量
	private String create_time;//
	private String update_time;
	private String is_delete;//是否删除，0：未删除	1：已删除
	private String start_time;
	private String end_time;
	private String mobile;//用户结算的手机号 传输用
	
	
	
	
	public String getMerchants_img() {
		return merchants_img;
	}
	public ShopCarBean setMerchants_img(String merchants_img) {
		this.merchants_img = merchants_img;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public ShopCarBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public ShopCarBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public int getCar_id() {
		return car_id;
	}
	public ShopCarBean setCar_id(int car_id) {
		this.car_id = car_id;
		return this;
	}

	public String getCar_ids() {
		return car_ids;
	}
	public ShopCarBean setCar_ids(String car_ids) {
		this.car_ids = car_ids;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public ShopCarBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public ShopCarBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public ShopCarBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public ShopCarBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public ShopCarBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public int getSpecification_id() {
		return specification_id;
	}
	public ShopCarBean setSpecification_id(int specification_id) {
		this.specification_id = specification_id;
		return this;
	}
	public String getSpecification_ids() {
		return specification_ids;
	}
	public ShopCarBean setSpecification_ids(String specification_ids) {
		this.specification_ids = specification_ids;
		return this;
	}
	
	public String getSpecification_price() {
		return specification_price;
	}
	public ShopCarBean setSpecification_price(String specification_price) {
		this.specification_price = specification_price;
		return this;
	}
	public String getSpecification_wholesale_price() {
		return specification_wholesale_price;
	}
	public ShopCarBean setSpecification_wholesale_price(String specification_wholesale_price) {
		this.specification_wholesale_price = specification_wholesale_price;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSpecification_names() {
		return specification_names;
	}
	public ShopCarBean setSpecification_names(String specification_names) {
		this.specification_names = specification_names;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public ShopCarBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ShopCarBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ShopCarBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ShopCarBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public ShopCarBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public ShopCarBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	
	
}
