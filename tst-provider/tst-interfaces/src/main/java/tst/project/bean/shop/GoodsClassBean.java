package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class GoodsClassBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int class_id;//
	private String class_name;//商品分类名称
	private String class_img;//分类图标
	private String class_state;//分类状态 1：上架 0：下架
	private String parent_id;//父id  -1第一级
	private String class_uuid;//分类的唯一标识
	private String class_parent_uuid;//分类的唯一标识路径  比如一级分类的uuid是1  二级的是2  三级的是3 则第三级的parent_uuid就是1#2#3
	private String sort;//权重 排序
	private String sort_type;//desc 从大到小  asc 从小到大
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	private String brand_id;//品牌id
	private int class_brand_id;
	private String merchants_id;//商家id
	private String is_check;//0:未选择 1:选中
	
	private String class_desc;//分类描述
			
	private List<GoodsClassTagBean> goodsClassTagBeans;//标签列表
	private List<IndustryBean> industryBeans;//行业列表
	private List<SpecificationBean> specificationBeans;//规格列表
	private List<GoodsClassBean> goodsClassBeans;//分类列表

	
	
	public String getIs_check() {
		return is_check;
	}
	public GoodsClassBean setIs_check(String is_check) {
		this.is_check = is_check;
		return this;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public GoodsClassBean setBrand_id(String brand_id) {
		this.brand_id = brand_id;
		return this;
	}
	public int getClass_brand_id() {
		return class_brand_id;
	}
	public GoodsClassBean setClass_brand_id(int class_brand_id) {
		this.class_brand_id = class_brand_id;
		return this;
	}
	public List<SpecificationBean> getSpecificationBeans() {
		return specificationBeans;
	}
	public GoodsClassBean setSpecificationBeans(List<SpecificationBean> specificationBeans) {
		this.specificationBeans = specificationBeans;
		return this;
	}
	public List<IndustryBean> getIndustryBeans() {
		return industryBeans;
	}
	public GoodsClassBean setIndustryBeans(List<IndustryBean> industryBeans) {
		this.industryBeans = industryBeans;
		return this;
	}
	public String getClass_img() {
		return class_img;
	}
	public GoodsClassBean setClass_img(String class_img) {
		this.class_img = class_img;
		return this;
	}
	public List<GoodsClassTagBean> getGoodsClassTagBeans() {
		return goodsClassTagBeans;
	}
	public GoodsClassBean setGoodsClassTagBeans(List<GoodsClassTagBean> goodsClassTagBeans) {
		this.goodsClassTagBeans = goodsClassTagBeans;
		return this;
	}
	public int getClass_id(){
		return class_id;
	}
	public GoodsClassBean setClass_id(int class_id){
		this.class_id= class_id;
		return this;
	}
	public String getClass_name(){
		return class_name;
	}
	public GoodsClassBean setClass_name(String class_name){
		this.class_name= class_name;
		return this;
	}
	
	
	public String getClass_state() {
		return class_state;
	}
	public GoodsClassBean setClass_state(String class_state) {
		this.class_state = class_state;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getParent_id(){
		return parent_id;
	}
	public GoodsClassBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	public String getClass_uuid(){
		return class_uuid;
	}
	public GoodsClassBean setClass_uuid(String class_uuid){
		this.class_uuid= class_uuid;
		return this;
	}
	public String getClass_parent_uuid(){
		return class_parent_uuid;
	}
	public GoodsClassBean setClass_parent_uuid(String class_parent_uuid){
		this.class_parent_uuid= class_parent_uuid;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsClassBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public GoodsClassBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsClassBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsClassBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsClassBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public GoodsClassBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getClass_desc() {
		return class_desc;
	}
	public GoodsClassBean setClass_desc(String class_desc) {
		this.class_desc = class_desc;
		return this;
	}
	public List<GoodsClassBean> getGoodsClassBeans() {
		return goodsClassBeans;
	}
	public GoodsClassBean setGoodsClassBeans(List<GoodsClassBean> goodsClassBeans) {
		this.goodsClassBeans = goodsClassBeans;
		return this;
	}
	
	
}
