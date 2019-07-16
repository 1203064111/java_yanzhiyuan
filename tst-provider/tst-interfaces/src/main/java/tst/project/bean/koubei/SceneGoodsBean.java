package tst.project.bean.koubei;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.shop.GoodsBean;

/**

**

*/

public class SceneGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int scene_goods_id;//
	private String scene_goods_type;//类型 1:本身就有的  2:赠送的
	private String scene_id;//
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String merchants_id;//商家id
	private String merchants_name;//商家名称
	private String goods_now_price;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getScene_goods_id(){
		return scene_goods_id;
	}
	public SceneGoodsBean setScene_goods_id(int scene_goods_id){
		this.scene_goods_id= scene_goods_id;
		return this;
	}
	public String getScene_goods_type(){
		return scene_goods_type;
	}
	public SceneGoodsBean setScene_goods_type(String scene_goods_type){
		this.scene_goods_type= scene_goods_type;
		return this;
	}
	public String getScene_id(){
		return scene_id;
	}
	public SceneGoodsBean setScene_id(String scene_id){
		this.scene_id= scene_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public SceneGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public SceneGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public SceneGoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public SceneGoodsBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	
	public String getGoods_now_price() {
		return goods_now_price;
	}
	public SceneGoodsBean setGoods_now_price(String goods_now_price) {
		this.goods_now_price = goods_now_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SceneGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SceneGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SceneGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
