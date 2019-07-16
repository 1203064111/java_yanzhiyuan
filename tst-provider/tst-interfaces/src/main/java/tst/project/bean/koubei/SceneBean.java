package tst.project.bean.koubei;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.shop.GoodsBean;

/**

**

*/

public class SceneBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int scene_id;//
	private String merchants_id;//商家id
	private String merchants_name;//商家名称
	private String class_id;//分类id
	private String class_name;//分类名称
	private String class_uuid;//商品的唯一标识
	private String class_parent_uuid;//分类的唯一标识路径  比如一级分类的uuid是1  二级的是2  三级的是3 则第三级的parent_uuid就是1#2#3
	private String scene_name;//场景名称
	private String scene_desc;//场景描述
	private String scene_img;//场景图标1
	private String scene_img2;//场景图标2
	private String scene_min_price;//场景内 商品最小价格
	private String scene_total_price;//场景内商品总价
	private String scene_price;//场景内商品 最小价格~商品总价
	private String scene_count;//场景内商品数量
	private String scene_coupon_desc;//优惠内容
	private String scene_type;//1:满赠  2:立减
	private String start_time;//活动开始时间
	private String end_time;//活动结束时间
	private String scene_sales;//销量
	private String add_price;//可赠送商品的最大价值
	private String sort;
	private String sort_type;
	private String apply_state;//0:待审核 1:通过  2:拒绝
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String goods_names;//场景内所有商品的名字集合
	private List<GoodsBean> goods1Beans;//场景主搭配商品列表
	private List<GoodsBean> goods2Beans;//场景赠送商品列表

	public int getScene_id(){
		return scene_id;
	}
	public SceneBean setScene_id(int scene_id){
		this.scene_id= scene_id;
		return this;
	}
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public SceneBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	
	
	public String getMerchants_name() {
		return merchants_name;
	}
	public SceneBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public SceneBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public SceneBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_uuid() {
		return class_uuid;
	}
	public SceneBean setClass_uuid(String class_uuid) {
		this.class_uuid = class_uuid;
		return this;
	}
	public String getClass_parent_uuid() {
		return class_parent_uuid;
	}
	public SceneBean setClass_parent_uuid(String class_parent_uuid) {
		this.class_parent_uuid = class_parent_uuid;
		return this;
	}
	public String getScene_name(){
		return scene_name;
	}
	public SceneBean setScene_name(String scene_name){
		this.scene_name= scene_name;
		return this;
	}
	public String getScene_desc(){
		return scene_desc;
	}
	public SceneBean setScene_desc(String scene_desc){
		this.scene_desc= scene_desc;
		return this;
	}
	public String getScene_img(){
		return scene_img;
	}
	public SceneBean setScene_img(String scene_img){
		this.scene_img= scene_img;
		return this;
	}
	public String getScene_img2(){
		return scene_img2;
	}
	public SceneBean setScene_img2(String scene_img2){
		this.scene_img2= scene_img2;
		return this;
	}
	public String getScene_min_price(){
		return scene_min_price;
	}
	public SceneBean setScene_min_price(String scene_min_price){
		this.scene_min_price= scene_min_price;
		return this;
	}
	public String getScene_total_price(){
		return scene_total_price;
	}
	public SceneBean setScene_total_price(String scene_total_price){
		this.scene_total_price= scene_total_price;
		return this;
	}
	public String getScene_price(){
		return scene_price;
	}
	public SceneBean setScene_price(String scene_price){
		this.scene_price= scene_price;
		return this;
	}
	public String getScene_count(){
		return scene_count;
	}
	public SceneBean setScene_count(String scene_count){
		this.scene_count= scene_count;
		return this;
	}
	public String getScene_coupon_desc(){
		return scene_coupon_desc;
	}
	public SceneBean setScene_coupon_desc(String scene_coupon_desc){
		this.scene_coupon_desc= scene_coupon_desc;
		return this;
	}
	public String getScene_type(){
		return scene_type;
	}
	public SceneBean setScene_type(String scene_type){
		this.scene_type= scene_type;
		return this;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public SceneBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public SceneBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	
	public String getScene_sales() {
		return scene_sales;
	}
	public SceneBean setScene_sales(String scene_sales) {
		this.scene_sales = scene_sales;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public SceneBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public SceneBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	
	public String getAdd_price() {
		return add_price;
	}
	public SceneBean setAdd_price(String add_price) {
		this.add_price = add_price;
		return this;
	}
	public String getApply_state() {
		return apply_state;
	}
	public SceneBean setApply_state(String apply_state) {
		this.apply_state = apply_state;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SceneBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SceneBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SceneBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public String getGoods_names() {
		return goods_names;
	}
	public SceneBean setGoods_names(String goods_names) {
		this.goods_names = goods_names;
		return this;
	}
	public List<GoodsBean> getGoods1Beans() {
		return goods1Beans;
	}
	public SceneBean setGoods1Beans(List<GoodsBean> goods1Beans) {
		this.goods1Beans = goods1Beans;
		return this;
	}
	public List<GoodsBean> getGoods2Beans() {
		return goods2Beans;
	}
	public SceneBean setGoods2Beans(List<GoodsBean> goods2Beans) {
		this.goods2Beans = goods2Beans;
		return this;
	}
	
	
}
