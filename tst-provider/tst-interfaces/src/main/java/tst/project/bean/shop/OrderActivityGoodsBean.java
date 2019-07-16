package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderActivityGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String activity_goods_id;//
	private String order_id;//订单总id
	private String order_merchants_id;//订单商家详情id
	private String activity_id;//活动id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String specification_id;//规格id
	private String specification_names;//规格名称组合
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public String getActivity_goods_id(){
		return activity_goods_id;
	}
	public OrderActivityGoodsBean setActivity_goods_id(String activity_goods_id){
		this.activity_goods_id= activity_goods_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public OrderActivityGoodsBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderActivityGoodsBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public OrderActivityGoodsBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public OrderActivityGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public OrderActivityGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public OrderActivityGoodsBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getSpecification_names(){
		return specification_names;
	}
	public OrderActivityGoodsBean setSpecification_names(String specification_names){
		this.specification_names= specification_names;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderActivityGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderActivityGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderActivityGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
