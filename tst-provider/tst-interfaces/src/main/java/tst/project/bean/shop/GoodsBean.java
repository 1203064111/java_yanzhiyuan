package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class GoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int goods_id;//
	private String goods_ids;
	private String merchants_id;//供货商id
	private String merchants_name;//供货商名称
	private String hx_account;//环信账号
	private String tag_id;//标签id
	private String class_id;//分类id
	private String class_name;//分类名称
	private String class_uuid;//商品的唯一标识
	private String class_parent_uuid;
	private String goods_sku;//商品sku和有些供货商线下对应使用
	private String goods_name;//商品名称
	private String goods_desc;//商品简介
	private String goods_url_desc;//商品图文编辑器的详情
	private String goods_state;//商品状态  0:下架 1:上架
	private String goods_img;//商品图片 多张用逗号拼接
	private String goods_img2;
	private String goods_video_url;//商品视频 多个用逗号拼接
	private String goods_video_url2;
	
	private String goods_origin_price;//商品原价
	private String goods_now_price;//商品现价
	private String goods_order_price;//商品预约价格 现价乘以比例的价格
	private String goods_arrive_price;//商品到付价格 商品现价-预约价
	private String goods_min_price;
	private String goods_max_price;
	private String goods_wholesale_price;
	private String goods_wholesale_min_price;
	private String goods_wholesale_max_price;
	private String goods_actual_sales;//商品实际销量
	private String goods_total_sales;//商品总销量
	private String goods_month_sales;//商品月销量
	private String goods_day_sales;//商品日销量
	private String goods_stock;//商品总库存
	private String goods_weight;//商品重量 用于计算邮费
	private String goods_weight_unit;//商品重量单位
	private String goods_volume;//商品体积 用于计算邮费
	private String goods_volume_unit;//商品体积单位
	private String goods_star1;
	private String goods_total_star1;
	private String goods_star2;
	private String goods_total_star2;
	private String goods_star3;
	private String goods_total_star3;
	private String assessment_count;//商品总评价数
	private String assessment_bad_percent;
	private String assessment_in_percent;
	private String assessment_good_percent;
	private String search_key;
	
	private String freight_id;
	
	private String is_group;//是否加入团购
	private String is_buy_limit;//是否限购 0:不限购 1:限购
	private String buy_limit;//限购数量
	private String sort;//权重
	private String sort_type;//
	private String is_delete;//0:未删除 1:删除
	private String create_time;//
	private String update_time;//
	private String apply_state;//0:待审核 1:通过  2:拒绝
	private String brand_id;//品牌id
	private String brand_name;//品牌名称
	private String goods_type;//1:医院商品(医院颜这块的医院 医生 海外下的商品)  2:商城商品
	private String goods_monnaie;//兑换商品所需颜值币(商城商品的颜值币)
	private String is_collection;//1:已收藏 0:未收藏 传输用
	private String goods_issue_count;//问题数量
	private String goods_comment_star;//商品平均评论星级
	private String goods_city;//所在市
	private String goods_order_num;//预约数量
	
	private String start_time;
	private String end_time;
	private GoodsIssueBean goodsIssueBean;//商品的问题
	
	private MerchantsBean merchantsBean;//医院信息 医生 海外
	private List<GoodsImgBean> goodsImgBeans;
	private List<GoodsClassTagBean> goodsClassTagBeans;
	private List<SpecificationBean> specificationBeans;
	private List<GoodsSpecificationBean> goodsSpecificationBeans;
	private List<GoodsAssessmentBean> goodsAssessmentBeans;//商品的评价列表
	private List<ActivityBean> activityBeans;
	
	
	
	
	
	
	public String getGoods_order_price() {
		return goods_order_price;
	}
	public GoodsBean setGoods_order_price(String goods_order_price) {
		this.goods_order_price = goods_order_price;
		return this;
	}
	public String getGoods_arrive_price() {
		return goods_arrive_price;
	}
	public GoodsBean setGoods_arrive_price(String goods_arrive_price) {
		this.goods_arrive_price = goods_arrive_price;
		return this;
	}
	public String getSearch_key() {
		return search_key;
	}
	public GoodsBean setSearch_key(String search_key) {
		this.search_key = search_key;
		return this;
	}
	public String getGoods_city() {
		return goods_city;
	}
	public GoodsBean setGoods_city(String goods_city) {
		this.goods_city = goods_city;
		return this;
	}
	public String getGoods_order_num() {
		return goods_order_num;
	}
	public GoodsBean setGoods_order_num(String goods_order_num) {
		this.goods_order_num = goods_order_num;
		return this;
	}
	public MerchantsBean getMerchantsBean() {
		return merchantsBean;
	}
	public GoodsBean setMerchantsBean(MerchantsBean merchantsBean) {
		this.merchantsBean = merchantsBean;
		return this;
	}
	private String member_id;//用户id 传参数用
	
	public String getMember_id() {
		return member_id;
	}
	public GoodsBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getGoods_id(){
		return goods_id;
	}
	public GoodsBean setGoods_id(int goods_id){
		this.goods_id= goods_id;
		return this;
	}
	
	
	public String getGoods_issue_count() {
		return goods_issue_count;
	}
	public GoodsBean setGoods_issue_count(String goods_issue_count) {
		this.goods_issue_count = goods_issue_count;
		return this;
	}
	
	public String getGoods_comment_star() {
		return goods_comment_star;
	}
	public GoodsBean setGoods_comment_star(String goods_comment_star) {
		this.goods_comment_star = goods_comment_star;
		return this;
	}
	public String getIs_collection() {
		return is_collection;
	}
	public GoodsBean setIs_collection(String is_collection) {
		this.is_collection = is_collection;
		return this;
	}
	public String getGoods_ids() {
		return goods_ids;
	}
	public GoodsBean setGoods_ids(String goods_ids) {
		this.goods_ids = goods_ids;
		return this;
	}
	public String getFreight_id() {
		return freight_id;
	}
	public GoodsBean setFreight_id(String freight_id) {
		this.freight_id = freight_id;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public GoodsBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public GoodsBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public GoodsBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	public String getMerchants_name(){
		return merchants_name;
	}
	public GoodsBean setMerchants_name(String merchants_name){
		this.merchants_name= merchants_name;
		return this;
	}
	
	public String getHx_account() {
		return hx_account;
	}
	public GoodsBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}
	
	public String getClass_id(){
		return class_id;
	}
	public GoodsBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	
	public String getTag_id() {
		return tag_id;
	}
	public GoodsBean setTag_id(String tag_id) {
		this.tag_id = tag_id;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public GoodsBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_uuid() {
		return class_uuid;
	}
	public GoodsBean setClass_uuid(String class_uuid) {
		this.class_uuid = class_uuid;
		return this;
	}
	public String getClass_parent_uuid() {
		return class_parent_uuid;
	}
	public GoodsBean setClass_parent_uuid(String class_parent_uuid) {
		this.class_parent_uuid = class_parent_uuid;
		return this;
	}
	public String getGoods_sku(){
		return goods_sku;
	}
	public GoodsBean setGoods_sku(String goods_sku){
		this.goods_sku= goods_sku;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public GoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getGoods_desc(){
		return goods_desc;
	}
	public GoodsBean setGoods_desc(String goods_desc){
		this.goods_desc= goods_desc;
		return this;
	}
	public String getGoods_url_desc(){
		return goods_url_desc;
	}
	public GoodsBean setGoods_url_desc(String goods_url_desc){
		this.goods_url_desc= goods_url_desc;
		return this;
	}
	public String getGoods_state(){
		return goods_state;
	}
	public GoodsBean setGoods_state(String goods_state){
		this.goods_state= goods_state;
		return this;
	}
	public String getGoods_img(){
		return goods_img;
	}
	public GoodsBean setGoods_img(String goods_img){
		this.goods_img= goods_img;
		return this;
	}
	public String getGoods_img2(){
		return goods_img2;
	}
	public GoodsBean setGoods_img2(String goods_img2){
		this.goods_img2= goods_img2;
		return this;
	}
	
	public String getGoods_video_url() {
		return goods_video_url;
	}
	public GoodsBean setGoods_video_url(String goods_video_url) {
		this.goods_video_url = goods_video_url;
		return this;
	}
	public String getGoods_video_url2() {
		return goods_video_url2;
	}
	public GoodsBean setGoods_video_url2(String goods_video_url2) {
		this.goods_video_url2 = goods_video_url2;
		return this;
	}
	public String getGoods_origin_price(){
		return goods_origin_price;
	}
	public GoodsBean setGoods_origin_price(String goods_origin_price){
		this.goods_origin_price= goods_origin_price;
		return this;
	}
	public String getGoods_now_price(){
		return goods_now_price;
	}
	public GoodsBean setGoods_now_price(String goods_now_price){
		this.goods_now_price= goods_now_price;
		return this;
	}
	public String getGoods_min_price(){
		return goods_min_price;
	}
	public GoodsBean setGoods_min_price(String goods_min_price){
		this.goods_min_price= goods_min_price;
		return this;
	}
	public String getGoods_max_price(){
		return goods_max_price;
	}
	public GoodsBean setGoods_max_price(String goods_max_price){
		this.goods_max_price= goods_max_price;
		return this;
	}
	public String getGoods_wholesale_price() {
		return goods_wholesale_price;
	}
	public GoodsBean setGoods_wholesale_price(String goods_wholesale_price) {
		this.goods_wholesale_price = goods_wholesale_price;
		return this;
	}
	public String getGoods_wholesale_min_price() {
		return goods_wholesale_min_price;
	}
	public GoodsBean setGoods_wholesale_min_price(String goods_wholesale_min_price) {
		this.goods_wholesale_min_price = goods_wholesale_min_price;
		return this;
	}
	public String getGoods_wholesale_max_price() {
		return goods_wholesale_max_price;
	}
	public GoodsBean setGoods_wholesale_max_price(String goods_wholesale_max_price) {
		this.goods_wholesale_max_price = goods_wholesale_max_price;
		return this;
	}
	public String getGoods_actual_sales(){
		return goods_actual_sales;
	}
	public GoodsBean setGoods_actual_sales(String goods_actual_sales){
		this.goods_actual_sales= goods_actual_sales;
		return this;
	}
	public String getGoods_total_sales(){
		return goods_total_sales;
	}
	public GoodsBean setGoods_total_sales(String goods_total_sales){
		this.goods_total_sales= goods_total_sales;
		return this;
	}
	public String getGoods_month_sales(){
		return goods_month_sales;
	}
	public GoodsBean setGoods_month_sales(String goods_month_sales){
		this.goods_month_sales= goods_month_sales;
		return this;
	}
	public String getGoods_day_sales(){
		return goods_day_sales;
	}
	public GoodsBean setGoods_day_sales(String goods_day_sales){
		this.goods_day_sales= goods_day_sales;
		return this;
	}
	public String getGoods_stock(){
		return goods_stock;
	}
	public GoodsBean setGoods_stock(String goods_stock){
		this.goods_stock= goods_stock;
		return this;
	}
	
	public String getGoods_weight() {
		return goods_weight;
	}
	public GoodsBean setGoods_weight(String goods_weight) {
		this.goods_weight = goods_weight;
		return this;
	}
	public String getGoods_weight_unit() {
		return goods_weight_unit;
	}
	public GoodsBean setGoods_weight_unit(String goods_weight_unit) {
		this.goods_weight_unit = goods_weight_unit;
		return this;
	}
	public String getGoods_volume() {
		return goods_volume;
	}
	public GoodsBean setGoods_volume(String goods_volume) {
		this.goods_volume = goods_volume;
		return this;
	}
	public String getGoods_volume_unit() {
		return goods_volume_unit;
	}
	public GoodsBean setGoods_volume_unit(String goods_volume_unit) {
		this.goods_volume_unit = goods_volume_unit;
		return this;
	}
	public String getGoods_star1(){
		return goods_star1;
	}
	public GoodsBean setGoods_star1(String goods_star1){
		this.goods_star1= goods_star1;
		return this;
	}
	public String getGoods_total_star1(){
		return goods_total_star1;
	}
	public GoodsBean setGoods_total_star1(String goods_total_star1){
		this.goods_total_star1= goods_total_star1;
		return this;
	}
	public String getGoods_star2(){
		return goods_star2;
	}
	public GoodsBean setGoods_star2(String goods_star2){
		this.goods_star2= goods_star2;
		return this;
	}
	public String getGoods_total_star2(){
		return goods_total_star2;
	}
	public GoodsBean setGoods_total_star2(String goods_total_star2){
		this.goods_total_star2= goods_total_star2;
		return this;
	}
	public String getGoods_star3(){
		return goods_star3;
	}
	public GoodsBean setGoods_star3(String goods_star3){
		this.goods_star3= goods_star3;
		return this;
	}
	public String getGoods_total_star3(){
		return goods_total_star3;
	}
	public GoodsBean setGoods_total_star3(String goods_total_star3){
		this.goods_total_star3= goods_total_star3;
		return this;
	}
	public String getAssessment_count(){
		return assessment_count;
	}
	public GoodsBean setAssessment_count(String assessment_count){
		this.assessment_count= assessment_count;
		return this;
	}
	public String getAssessment_bad_percent(){
		return assessment_bad_percent;
	}
	public GoodsBean setAssessment_bad_percent(String assessment_bad_percent){
		this.assessment_bad_percent= assessment_bad_percent;
		return this;
	}
	public String getAssessment_in_percent(){
		return assessment_in_percent;
	}
	public GoodsBean setAssessment_in_percent(String assessment_in_percent){
		this.assessment_in_percent= assessment_in_percent;
		return this;
	}
	public String getAssessment_good_percent(){
		return assessment_good_percent;
	}
	public GoodsBean setAssessment_good_percent(String assessment_good_percent){
		this.assessment_good_percent= assessment_good_percent;
		return this;
	}
	public String getIs_group(){
		return is_group;
	}
	public GoodsBean setIs_group(String is_group){
		this.is_group= is_group;
		return this;
	}
	public String getIs_buy_limit(){
		return is_buy_limit;
	}
	public GoodsBean setIs_buy_limit(String is_buy_limit){
		this.is_buy_limit= is_buy_limit;
		return this;
	}
	public String getBuy_limit(){
		return buy_limit;
	}
	public GoodsBean setBuy_limit(String buy_limit){
		this.buy_limit= buy_limit;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	
	public String getApply_state() {
		return apply_state;
	}
	public GoodsBean setApply_state(String apply_state) {
		this.apply_state = apply_state;
		return this;
	}
	
	
	public String getCreate_time(){
		return create_time;
	}
	public GoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	
	public String getBrand_id() {
		return brand_id;
	}
	public GoodsBean setBrand_id(String brand_id) {
		this.brand_id = brand_id;
		return this;
	}
	
	
	public String getBrand_name() {
		return brand_name;
	}
	public GoodsBean setBrand_name(String brand_name) {
		this.brand_name = brand_name;
		return this;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public GoodsBean setGoods_type(String goods_type) {
		this.goods_type = goods_type;
		return this;
	}
	public String getGoods_monnaie() {
		return goods_monnaie;
	}
	public GoodsBean setGoods_monnaie(String goods_monnaie) {
		this.goods_monnaie = goods_monnaie;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public GoodsBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public GoodsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public GoodsIssueBean getGoodsIssueBean() {
		return goodsIssueBean;
	}
	public GoodsBean setGoodsIssueBean(GoodsIssueBean goodsIssueBean) {
		this.goodsIssueBean = goodsIssueBean;
		return this;
	}
	public List<GoodsImgBean> getGoodsImgBeans() {
		return goodsImgBeans;
	}
	public GoodsBean setGoodsImgBeans(List<GoodsImgBean> goodsImgBeans) {
		this.goodsImgBeans = goodsImgBeans;
		return this;
	}
	public List<GoodsClassTagBean> getGoodsClassTagBeans() {
		return goodsClassTagBeans;
	}
	public GoodsBean setGoodsClassTagBeans(List<GoodsClassTagBean> goodsClassTagBeans) {
		this.goodsClassTagBeans = goodsClassTagBeans;
		return this;
	}
	public List<GoodsSpecificationBean> getGoodsSpecificationBeans() {
		return goodsSpecificationBeans;
	}
	public GoodsBean setGoodsSpecificationBeans(List<GoodsSpecificationBean> goodsSpecificationBeans) {
		this.goodsSpecificationBeans = goodsSpecificationBeans;
		return this;
	}
	public List<SpecificationBean> getSpecificationBeans() {
		return specificationBeans;
	}
	public GoodsBean setSpecificationBeans(List<SpecificationBean> specificationBeans) {
		this.specificationBeans = specificationBeans;
		return this;
	}
	public List<ActivityBean> getActivityBeans() {
		return activityBeans;
	}
	public GoodsBean setActivityBeans(List<ActivityBean> activityBeans) {
		this.activityBeans = activityBeans;
		return this;
	}
	public List<GoodsAssessmentBean> getGoodsAssessmentBeans() {
		return goodsAssessmentBeans;
	}
	public GoodsBean setGoodsAssessmentBeans(List<GoodsAssessmentBean> goodsAssessmentBeans) {
		this.goodsAssessmentBeans = goodsAssessmentBeans;
		return this;
	}
	
}
