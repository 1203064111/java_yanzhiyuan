package tst.project.bean.shop;

import java.io.Serializable;

public class MerchantsGoodsClassBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int merchants_goods_class_id;//
	private String merchants_id;//
	private String goods_class_id;//分类id
	private String goods_class_name;//分类名称
	private String merchants_name;//医院名称
	private String merchants_type;//1：医院 2医生 3海外
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public String getIs_delete() {
		return is_delete;
	}
	public MerchantsGoodsClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MerchantsGoodsClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MerchantsGoodsClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getGoods_class_name() {
		return goods_class_name;
	}
	public MerchantsGoodsClassBean setGoods_class_name(String goods_class_name) {
		this.goods_class_name = goods_class_name;
		return this;
	}
	public int getMerchants_goods_class_id() {
		return merchants_goods_class_id;
	}
	public MerchantsGoodsClassBean setMerchants_goods_class_id(int merchants_goods_class_id) {
		this.merchants_goods_class_id = merchants_goods_class_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public MerchantsGoodsClassBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getGoods_class_id() {
		return goods_class_id;
	}
	public MerchantsGoodsClassBean setGoods_class_id(String goods_class_id) {
		this.goods_class_id = goods_class_id;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public MerchantsGoodsClassBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getMerchants_type() {
		return merchants_type;
	}
	public MerchantsGoodsClassBean setMerchants_type(String merchants_type) {
		this.merchants_type = merchants_type;
		return this;
	}
	
	
}
