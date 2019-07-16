package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class GoodsSpecificationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int specification_id;//
	private String goods_id;//
	private String specification_state;//0:下架 1:上架
	private String specification_sku;//规格sku
	private String specification_ids;//规格组合
	private String specification_names;//规格名称组合
	private String specification_sales;//销量
	private String specification_stock;//库存
	private String specification_img;//图片
	private String specification_price;//价格
	private String specification_cost_price;//成本价
	private String specification_wholesale_price;//批发价
	private String sort;//权重
	private String is_delete;//
	private String parent_id;//
	private String create_time;//
	private String update_time;//
	public int getSpecification_id(){
		return specification_id;
	}
	public GoodsSpecificationBean setSpecification_id(int specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public GoodsSpecificationBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getSpecification_state(){
		return specification_state;
	}
	public GoodsSpecificationBean setSpecification_state(String specification_state){
		this.specification_state= specification_state;
		return this;
	}
	public String getSpecification_sku(){
		return specification_sku;
	}
	public GoodsSpecificationBean setSpecification_sku(String specification_sku){
		this.specification_sku= specification_sku;
		return this;
	}
	public String getSpecification_ids(){
		return specification_ids;
	}
	public GoodsSpecificationBean setSpecification_ids(String specification_ids){
		this.specification_ids= specification_ids;
		return this;
	}
	public String getSpecification_names(){
		return specification_names;
	}
	public GoodsSpecificationBean setSpecification_names(String specification_names){
		this.specification_names= specification_names;
		return this;
	}
	public String getSpecification_sales(){
		return specification_sales;
	}
	public GoodsSpecificationBean setSpecification_sales(String specification_sales){
		this.specification_sales= specification_sales;
		return this;
	}
	public String getSpecification_stock(){
		return specification_stock;
	}
	public GoodsSpecificationBean setSpecification_stock(String specification_stock){
		this.specification_stock= specification_stock;
		return this;
	}
	public String getSpecification_img(){
		return specification_img;
	}
	public GoodsSpecificationBean setSpecification_img(String specification_img){
		this.specification_img= specification_img;
		return this;
	}
	public String getSpecification_price(){
		return specification_price;
	}
	public GoodsSpecificationBean setSpecification_price(String specification_price){
		this.specification_price= specification_price;
		return this;
	}
	public String getSpecification_cost_price(){
		return specification_cost_price;
	}
	public GoodsSpecificationBean setSpecification_cost_price(String specification_cost_price){
		this.specification_cost_price= specification_cost_price;
		return this;
	}
	public String getSpecification_wholesale_price(){
		return specification_wholesale_price;
	}
	public GoodsSpecificationBean setSpecification_wholesale_price(String specification_wholesale_price){
		this.specification_wholesale_price= specification_wholesale_price;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsSpecificationBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsSpecificationBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getParent_id(){
		return parent_id;
	}
	public GoodsSpecificationBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsSpecificationBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsSpecificationBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
