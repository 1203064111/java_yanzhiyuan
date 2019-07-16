package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class BrandBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int brand_id;//品牌id
	private int goods_brand_id;
	private String goods_id;
	private String class_id;
	
	private String brand_name;//品牌名称
	private String brand_img;//品牌图标
	private String sort;//权重 排序
	private String sort_type;//desc 从大到小  asc 从小到大
	private String brand_state;//品牌状态
	private String is_delete;//0:未删除 1:删除
	private String create_time;//
	private String update_time;//
	
	private String is_check;//是否选中 1:选中 0:未选中
	
	private List<GoodsClassBean> goodsClassBeans;//分类列表
	
	public List<GoodsClassBean> getGoodsClassBeans() {
		return goodsClassBeans;
	}
	public BrandBean setGoodsClassBeans(List<GoodsClassBean> goodsClassBeans) {
		this.goodsClassBeans = goodsClassBeans;
		return this;
	}
	
	public int getBrand_id(){
		return brand_id;
	}
	public BrandBean setBrand_id(int brand_id){
		this.brand_id= brand_id;
		return this;
	}
	
	public String getIs_check() {
		return is_check;
	}
	public BrandBean setIs_check(String is_check) {
		this.is_check = is_check;
		return this;
	}
	public int getGoods_brand_id() {
		return goods_brand_id;
	}
	public BrandBean setGoods_brand_id(int goods_brand_id) {
		this.goods_brand_id = goods_brand_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public BrandBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public BrandBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getBrand_name(){
		return brand_name;
	}
	public BrandBean setBrand_name(String brand_name){
		this.brand_name= brand_name;
		return this;
	}
	public String getBrand_img(){
		return brand_img;
	}
	public BrandBean setBrand_img(String brand_img){
		this.brand_img= brand_img;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public BrandBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public BrandBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getBrand_state() {
		return brand_state;
	}
	public BrandBean setBrand_state(String brand_state) {
		this.brand_state = brand_state;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public BrandBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public BrandBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public BrandBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
