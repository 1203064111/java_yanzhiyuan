package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

import sun.security.x509.PrivateKeyUsageExtension;
import tst.project.bean.member.MemberBean;

/**

**

*/

public class MerchantsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int merchants_id;//
	private String merchants_ids;//
	private String member_id;//用户id
	private String merchants_name;//医院名称 医生名称
	private String merchants_img;//医院照片 医生头像
	
	private String merchants_contact_name;//医院联系人姓名
	private String merchants_contact_mobile;//医院联系人手机号
	private String merchants_province;//医院所在省
	private String merchants_city;//医院所在市
	private String merchants_country;//医院所在区
	private String merchants_detail_address;//医院详细地址
	private String merchants_certificate_no;//从业资格证编号
	private String merchants_imgs;//医院图片(简介照片) 医生介绍照片  多张用逗号拼接
	private String merchants_desc;//医院简介
	private String business_start_time;//医院营业开始时间
	private String business_end_time;//医院营业结束时间
	private String merchants_state;//商家状态 0:下线 1:上线
	private String merchants_state_show;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String company_name;//公司名称
	private String company_type;//公司类型
	private String company_type_name;//公司类型名称
	private String company_province;//
	private String company_city;//
	private String company_country;//
	private String company_detail_address;//
	private String company_legal_name;
	private String company_legal_no;
	private String company_legal_start_time;//
	private String company_legal_end_time;//
	
	private String company_business_img;//医院营业执照
	private String certificate_imgs;//医院医疗许可证书照片 多张用逗号拼接 医生的从业资格证正面
	private String merchants_certificate_img;//医院的医生资格证照片  医生的从业资格证反面
	private String company_house_rental_img;//医院房屋租赁合同照片
	private String merchants_price_img;//医院的价目表
	private String company_legal_img;//医院法人身份证正面
	private String company_legal_hold_img;//医院经办人手持身份证照
	private String company_legal_positive_img;//医院经办人正面照  医生的身份证正面
	private String company_legal_opposite_img;//医院经办人反面照  医生的身份证反面
	
	private String company_register_capital;//公司注册资本
	private String company_register_time;//公司注册时间
	private String company_business_range;//公司经营范围
	private String qrcode_img;//二维码图片路径
	private String start_time;
	private String end_time;
	private String search_key;
	private String sort;//排序
	
	private String order_num;//预约人数
	private String case_num;//案例数
	private String certificate_num;//医疗证书数量
	
	private String comment_num;//评价数量
	private String comment_star;//评价星级
	
	
	private String merchants_type;//商家标签 1:医院 2:医生 3:海外
	private String merchants_type_show;
	private String apply_state;//0:待审核 1:通过 2:拒绝
	
	private String merchants_hospital;//医院
	private String merchants_dept;//部门
	
	private String distance;//距离 传输用
	private String longitude;//经度
	private String latitude;//纬度
	
	private MemberBean memberBean;
	private List<GoodsBean> goodsBeans;//商品列表
	private List<GoodsMarketingBean> goodsMarketingBeans;//推荐商品列表
	
	private List<IndustryBean> industryBeans;
	
	
	
	
	public String getSort() {
		return sort;
	}
	public MerchantsBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getMerchants_state_show() {
		return merchants_state_show;
	}
	public MerchantsBean setMerchants_state_show(String merchants_state_show) {
		this.merchants_state_show = merchants_state_show;
		return this;
	}
	public String getDistance() {
		return distance;
	}
	public MerchantsBean setDistance(String distance) {
		this.distance = distance;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public MerchantsBean setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public MerchantsBean setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
	public String getMerchants_hospital() {
		return merchants_hospital;
	}
	public MerchantsBean setMerchants_hospital(String merchants_hospital) {
		this.merchants_hospital = merchants_hospital;
		return this;
	}
	public String getMerchants_dept() {
		return merchants_dept;
	}
	public MerchantsBean setMerchants_dept(String merchants_dept) {
		this.merchants_dept = merchants_dept;
		return this;
	}
	public String getMerchants_type_show() {
		return merchants_type_show;
	}
	public MerchantsBean setMerchants_type_show(String merchants_type_show) {
		this.merchants_type_show = merchants_type_show;
		return this;
	}
	public String getMerchants_certificate_img() {
		return merchants_certificate_img;
	}
	public MerchantsBean setMerchants_certificate_img(String merchants_certificate_img) {
		this.merchants_certificate_img = merchants_certificate_img;
		return this;
	}
	public String getCompany_house_rental_img() {
		return company_house_rental_img;
	}
	public MerchantsBean setCompany_house_rental_img(String company_house_rental_img) {
		this.company_house_rental_img = company_house_rental_img;
		return this;
	}
	
	public String getCompany_legal_img() {
		return company_legal_img;
	}
	public MerchantsBean setCompany_legal_img(String company_legal_img) {
		this.company_legal_img = company_legal_img;
		return this;
	}
	public String getMerchants_certificate_no() {
		return merchants_certificate_no;
	}
	public MerchantsBean setMerchants_certificate_no(String merchants_certificate_no) {
		this.merchants_certificate_no = merchants_certificate_no;
		return this;
	}
	public String getSearch_key() {
		return search_key;
	}
	public MerchantsBean setSearch_key(String search_key) {
		this.search_key = search_key;
		return this;
	}
	public int getMerchants_id(){
		return merchants_id;
	}
	public MerchantsBean setMerchants_id(int merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	public String getMerchants_ids() {
		return merchants_ids;
	}
	public MerchantsBean setMerchants_ids(String merchants_ids) {
		this.merchants_ids = merchants_ids;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MerchantsBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMerchants_name(){
		return merchants_name;
	}
	public MerchantsBean setMerchants_name(String merchants_name){
		this.merchants_name= merchants_name;
		return this;
	}
	public String getMerchants_img(){
		return merchants_img;
	}
	public MerchantsBean setMerchants_img(String merchants_img){
		this.merchants_img= merchants_img;
		return this;
	}
	public String getMerchants_contact_name(){
		return merchants_contact_name;
	}
	public MerchantsBean setMerchants_contact_name(String merchants_contact_name){
		this.merchants_contact_name= merchants_contact_name;
		return this;
	}
	public String getMerchants_contact_mobile(){
		return merchants_contact_mobile;
	}
	public MerchantsBean setMerchants_contact_mobile(String merchants_contact_mobile){
		this.merchants_contact_mobile= merchants_contact_mobile;
		return this;
	}
	public String getMerchants_province(){
		return merchants_province;
	}
	public MerchantsBean setMerchants_province(String merchants_province){
		this.merchants_province= merchants_province;
		return this;
	}
	public String getMerchants_city(){
		return merchants_city;
	}
	public MerchantsBean setMerchants_city(String merchants_city){
		this.merchants_city= merchants_city;
		return this;
	}
	public String getMerchants_country(){
		return merchants_country;
	}
	public MerchantsBean setMerchants_country(String merchants_country){
		this.merchants_country= merchants_country;
		return this;
	}
	public String getMerchants_detail_address(){
		return merchants_detail_address;
	}
	public MerchantsBean setMerchants_detail_address(String merchants_detail_address){
		this.merchants_detail_address= merchants_detail_address;
		return this;
	}
	public String getMerchants_desc(){
		return merchants_desc;
	}
	public MerchantsBean setMerchants_desc(String merchants_desc){
		this.merchants_desc= merchants_desc;
		return this;
	}
	public String getBusiness_start_time(){
		return business_start_time;
	}
	public MerchantsBean setBusiness_start_time(String business_start_time){
		this.business_start_time= business_start_time;
		return this;
	}
	public String getBusiness_end_time(){
		return business_end_time;
	}
	public MerchantsBean setBusiness_end_time(String business_end_time){
		this.business_end_time= business_end_time;
		return this;
	}
	public String getMerchants_state(){
		return merchants_state;
	}
	public MerchantsBean setMerchants_state(String merchants_state){
		this.merchants_state= merchants_state;
		this.merchants_state_show = "0".equals(merchants_state)?"下线":
			"1".equals(merchants_state)?"上线":"未知";
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MerchantsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MerchantsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MerchantsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getCompany_name(){
		return company_name;
	}
	public MerchantsBean setCompany_name(String company_name){
		this.company_name= company_name;
		return this;
	}
	public String getCompany_type(){
		return company_type;
	}
	public MerchantsBean setCompany_type(String company_type){
		this.company_type= company_type;
		return this;
	}
	public String getCompany_type_name(){
		return company_type_name;
	}
	public MerchantsBean setCompany_type_name(String company_type_name){
		this.company_type_name= company_type_name;
		return this;
	}
	public String getCompany_province(){
		return company_province;
	}
	public MerchantsBean setCompany_province(String company_province){
		this.company_province= company_province;
		return this;
	}
	public String getCompany_city(){
		return company_city;
	}
	public MerchantsBean setCompany_city(String company_city){
		this.company_city= company_city;
		return this;
	}
	public String getCompany_country(){
		return company_country;
	}
	public MerchantsBean setCompany_country(String company_country){
		this.company_country= company_country;
		return this;
	}
	public String getCompany_detail_address(){
		return company_detail_address;
	}
	public MerchantsBean setCompany_detail_address(String company_detail_address){
		this.company_detail_address= company_detail_address;
		return this;
	}
	public String getCompany_legal_name(){
		return company_legal_name;
	}
	public MerchantsBean setCompany_legal_name(String company_legal_name){
		this.company_legal_name= company_legal_name;
		return this;
	}
	public String getCompany_legal_no(){
		return company_legal_no;
	}
	public MerchantsBean setCompany_legal_no(String company_legal_no){
		this.company_legal_no= company_legal_no;
		return this;
	}
	public String getCompany_legal_start_time(){
		return company_legal_start_time;
	}
	public MerchantsBean setCompany_legal_start_time(String company_legal_start_time){
		this.company_legal_start_time= company_legal_start_time;
		return this;
	}
	public String getCompany_legal_end_time(){
		return company_legal_end_time;
	}
	public MerchantsBean setCompany_legal_end_time(String company_legal_end_time){
		this.company_legal_end_time= company_legal_end_time;
		return this;
	}
	public String getCompany_legal_positive_img(){
		return company_legal_positive_img;
	}
	public MerchantsBean setCompany_legal_positive_img(String company_legal_positive_img){
		this.company_legal_positive_img= company_legal_positive_img;
		return this;
	}
	public String getCompany_legal_opposite_img(){
		return company_legal_opposite_img;
	}
	public MerchantsBean setCompany_legal_opposite_img(String company_legal_opposite_img){
		this.company_legal_opposite_img= company_legal_opposite_img;
		return this;
	}
	public String getCompany_legal_hold_img(){
		return company_legal_hold_img;
	}
	public MerchantsBean setCompany_legal_hold_img(String company_legal_hold_img){
		this.company_legal_hold_img= company_legal_hold_img;
		return this;
	}
	public String getCompany_business_img(){
		return company_business_img;
	}
	public MerchantsBean setCompany_business_img(String company_business_img){
		this.company_business_img= company_business_img;
		return this;
	}
	public String getCompany_register_capital(){
		return company_register_capital;
	}
	public MerchantsBean setCompany_register_capital(String company_register_capital){
		this.company_register_capital= company_register_capital;
		return this;
	}
	public String getCompany_register_time(){
		return company_register_time;
	}
	public MerchantsBean setCompany_register_time(String company_register_time){
		this.company_register_time= company_register_time;
		return this;
	}
	public String getCompany_business_range(){
		return company_business_range;
	}
	public MerchantsBean setCompany_business_range(String company_business_range){
		this.company_business_range= company_business_range;
		return this;
	}
	
	public String getQrcode_img() {
		return qrcode_img;
	}
	public MerchantsBean setQrcode_img(String qrcode_img) {
		this.qrcode_img = qrcode_img;
		return this;
	}
	
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public MerchantsBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public List<GoodsBean> getGoodsBeans() {
		return goodsBeans;
	}
	public MerchantsBean setGoodsBeans(List<GoodsBean> goodsBeans) {
		this.goodsBeans = goodsBeans;
		return this;
	}
	public List<GoodsMarketingBean> getGoodsMarketingBeans() {
		return goodsMarketingBeans;
	}
	public MerchantsBean setGoodsMarketingBeans(List<GoodsMarketingBean> goodsMarketingBeans) {
		this.goodsMarketingBeans = goodsMarketingBeans;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public MerchantsBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MerchantsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getMerchants_type() {
		return merchants_type;
	}
	public MerchantsBean setMerchants_type(String merchants_type) {
		this.merchants_type = merchants_type;
		this.merchants_type_show = "1".equals(merchants_type)?"医院":
			"2".equals(merchants_type)?"名师":
			"3".equals(merchants_type)?"海外":"未知";
		return this;
	}
	public String getApply_state() {
		return apply_state;
	}
	public MerchantsBean setApply_state(String apply_state) {
		this.apply_state = apply_state;
		return this;
	}
	public String getMerchants_imgs() {
		return merchants_imgs;
	}
	public MerchantsBean setMerchants_imgs(String merchants_imgs) {
		this.merchants_imgs = merchants_imgs;
		return this;
	}
	public String getOrder_num() {
		return order_num;
	}
	public MerchantsBean setOrder_num(String order_num) {
		this.order_num = order_num;
		return this;
	}
	public String getCase_num() {
		return case_num;
	}
	public MerchantsBean setCase_num(String case_num) {
		this.case_num = case_num;
		return this;
	}
	public String getCertificate_num() {
		return certificate_num;
	}
	public MerchantsBean setCertificate_num(String certificate_num) {
		this.certificate_num = certificate_num;
		return this;
	}
	public String getCertificate_imgs() {
		return certificate_imgs;
	}
	public MerchantsBean setCertificate_imgs(String certificate_imgs) {
		this.certificate_imgs = certificate_imgs;
		return this;
	}
	public String getComment_num() {
		return comment_num;
	}
	public MerchantsBean setComment_num(String comment_num) {
		this.comment_num = comment_num;
		return this;
	}
	public String getComment_star() {
		return comment_star;
	}
	public MerchantsBean setComment_star(String comment_star) {
		this.comment_star = comment_star;
		return this;
	}
	public List<IndustryBean> getIndustryBeans() {
		return industryBeans;
	}
	public MerchantsBean setIndustryBeans(List<IndustryBean> industryBeans) {
		this.industryBeans = industryBeans;
		return this;
	}
	public String getMerchants_price_img() {
		return merchants_price_img;
	}
	public MerchantsBean setMerchants_price_img(String merchants_price_img) {
		this.merchants_price_img = merchants_price_img;
		return this;
	}
	
	
	
}
