package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String activity_goods_id;//
	private String activity_id;//活动id
	private String merchants_id;//商家id
	private String goods_id;//参加活动的商品id
	private String goods_name;//商品名称
	private String class_name;//分类名称
	private String specification_id;//规格id
	private String specification_names;//规格名称组合
	private String activity_stock;//活动库存
	private String activity_price;//活动价格
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public String getActivity_goods_id(){
		return activity_goods_id;
	}
	public ActivityGoodsBean setActivity_goods_id(String activity_goods_id){
		this.activity_goods_id= activity_goods_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ActivityGoodsBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public ActivityGoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public ActivityGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public ActivityGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	
	public String getClass_name() {
		return class_name;
	}
	public ActivityGoodsBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public ActivityGoodsBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getSpecification_names(){
		return specification_names;
	}
	public ActivityGoodsBean setSpecification_names(String specification_names){
		this.specification_names= specification_names;
		return this;
	}

	public String getActivity_stock() {
		return activity_stock;
	}
	public ActivityGoodsBean setActivity_stock(String activity_stock) {
		this.activity_stock = activity_stock;
		return this;
	}
	public String getActivity_price() {
		return activity_price;
	}
	public ActivityGoodsBean setActivity_price(String activity_price) {
		this.activity_price = activity_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
