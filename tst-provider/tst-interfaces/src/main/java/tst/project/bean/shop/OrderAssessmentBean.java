package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderAssessmentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int assessment_id;//
	private String member_id;//用户id
	private String member_img;//用户头像
	private String member_nick_name;//用户昵称
	private String merchants_id;//商家ID
	private String order_id;//商家订单id
	private String order_no;//商家订单号
	private String assessment_desc;//评价内容
	private String assessment_imgs;//评价图片路径 逗号相隔
	private String assessment_video;
	private String assessment_type;
	private String assessment_type_show;//
	private String assessment_star;//星级
	private String assessment_star2;
	private String assessment_star3;
	private String relation_id;
	private String goods_name;
	private String goods_img;
	private String merchants_name;
	private String merchants_img;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	
	
	public String getAssessment_video() {
		return assessment_video;
	}
	public OrderAssessmentBean setAssessment_video(String assessment_video) {
		this.assessment_video = assessment_video;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public OrderAssessmentBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public OrderAssessmentBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getAssessment_star() {
		return assessment_star;
	}
	public OrderAssessmentBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public int getAssessment_id(){
		return assessment_id;
	}
	public OrderAssessmentBean setAssessment_id(int assessment_id){
		this.assessment_id= assessment_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderAssessmentBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getMember_img() {
		return member_img;
	}
	public OrderAssessmentBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public OrderAssessmentBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public OrderAssessmentBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	
	public String getAssessment_desc(){
		return assessment_desc;
	}
	public OrderAssessmentBean setAssessment_desc(String assessment_desc){
		this.assessment_desc= assessment_desc;
		return this;
	}
	public String getAssessment_imgs(){
		return assessment_imgs;
	}
	public OrderAssessmentBean setAssessment_imgs(String assessment_imgs){
		this.assessment_imgs= assessment_imgs;
		return this;
	}
	public String getAssessment_type(){
		return assessment_type;
	}
	public OrderAssessmentBean setAssessment_type(String assessment_type){
		this.assessment_type= assessment_type;
		this.assessment_type_show = "goods".equals(assessment_type)?"商品评价":
							("merchants".equals(assessment_type)?"商家评价":"");
		return this;
	}
	public String getAssessment_type_show(){
		return assessment_type_show;
	}
	public OrderAssessmentBean setAssessment_type_show(String assessment_type_show){
		this.assessment_type_show= assessment_type_show;
		return this;
	}
	
	public String getAssessment_star2(){
		return assessment_star2;
	}
	public OrderAssessmentBean setAssessment_star2(String assessment_star2){
		this.assessment_star2= assessment_star2;
		return this;
	}
	public String getAssessment_star3(){
		return assessment_star3;
	}
	public OrderAssessmentBean setAssessment_star3(String assessment_star3){
		this.assessment_star3= assessment_star3;
		return this;
	}
	public String getRelation_id(){
		return relation_id;
	}
	public OrderAssessmentBean setRelation_id(String relation_id){
		this.relation_id= relation_id;
		return this;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public OrderAssessmentBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public OrderAssessmentBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public OrderAssessmentBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getMerchants_img() {
		return merchants_img;
	}
	public OrderAssessmentBean setMerchants_img(String merchants_img) {
		this.merchants_img = merchants_img;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderAssessmentBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderAssessmentBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderAssessmentBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	
}
