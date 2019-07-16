package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityGiveGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int give_goods_id;//
	private String activity_id;//活动id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String specification_id;//规格id
	private String specification_names;//规格名称组合
	private String merchants_id;
	private String class_name;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	private String goods_ids;
	public String getGoods_ids() {
		return goods_ids;
	}
	public ActivityGiveGoodsBean setGoods_ids(String goods_ids) {
		this.goods_ids = goods_ids;
		return this;
	}
	
	public int getGive_goods_id(){
		return give_goods_id;
	}
	public ActivityGiveGoodsBean setGive_goods_id(int give_goods_id){
		this.give_goods_id= give_goods_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ActivityGiveGoodsBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	
	public String getGoods_id(){
		return goods_id;
	}
	public ActivityGiveGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public ActivityGiveGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public ActivityGiveGoodsBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getSpecification_names(){
		return specification_names;
	}
	public ActivityGiveGoodsBean setSpecification_names(String specification_names){
		this.specification_names= specification_names;
		return this;
	}
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public ActivityGiveGoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public ActivityGiveGoodsBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityGiveGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityGiveGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityGiveGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
