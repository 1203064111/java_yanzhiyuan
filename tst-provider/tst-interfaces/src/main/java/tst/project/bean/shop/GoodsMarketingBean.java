package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class GoodsMarketingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int marketing_id;//
	private String marketing_type;//营销类型 1:热销商品 2:推荐商品
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String goods_now_price;//商品名称
	private String class_name;
	private String merchants_name;
	private String merchants_id;
	private String sort;//权重排序
	private String sort_type;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	public int getMarketing_id(){
		return marketing_id;
	}
	public GoodsMarketingBean setMarketing_id(int marketing_id){
		this.marketing_id= marketing_id;
		return this;
	}
	public String getMarketing_type(){
		return marketing_type;
	}
	public GoodsMarketingBean setMarketing_type(String marketing_type){
		this.marketing_type= marketing_type;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public GoodsMarketingBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public GoodsMarketingBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	
	public String getGoods_now_price() {
		return goods_now_price;
	}
	public GoodsMarketingBean setGoods_now_price(String goods_now_price) {
		this.goods_now_price = goods_now_price;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public GoodsMarketingBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public GoodsMarketingBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public GoodsMarketingBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsMarketingBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public GoodsMarketingBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsMarketingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsMarketingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsMarketingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
