package tst.project.bean.information;

import java.io.Serializable;

/**

**

*/

public class SystemInformationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int information_id;//
	private String class_id;//分类id
	private String information_title;//资讯标题
	private String information_desc;//简介
	private String information_img;//
	private String information_url_desc;//详情描述
	private String information_author;//作者
	private String information_resource;//来源
	private String information_state;//是否发布
	private String read_num;//阅读量
	
	private String information_video;//视频
	private int member_id;//创建人id（公司id）
	private String member_img;//头像
	private String member_name;//名称
	private int well_num;//点赞数
	private int send_num;//转发数
	private int comment_num;//评论数
	private String create_member_id;//创建者id
	
	private String total_grade;//总评分
	private String hx_account;//环信账号
	
	private String is_good;//是否点赞 0没有 1有
	private String setting_bottom;//是否置底 0 没有 1有
	private String order_id;//订单id
	private String sort;//订单第几期日志
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	
	
	public String getCreate_member_id() {
		return create_member_id;
	}
	public SystemInformationBean setCreate_member_id(String create_member_id) {
		this.create_member_id = create_member_id;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public SystemInformationBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public SystemInformationBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getSetting_bottom() {
		return setting_bottom;
	}
	public SystemInformationBean setSetting_bottom(String setting_bottom) {
		this.setting_bottom = setting_bottom;
		return this;
	}
	public String getTotal_grade() {
		return total_grade;
	}
	public SystemInformationBean setTotal_grade(String total_grade) {
		this.total_grade = total_grade;
		return this;
	}
	public String getHx_account() {
		return hx_account;
	}
	public SystemInformationBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}
	public String getIs_good() {
		return is_good;
	}
	public SystemInformationBean setIs_good(String is_good) {
		this.is_good = is_good;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public SystemInformationBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public SystemInformationBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getInformation_video() {
		return information_video;
	}
	public SystemInformationBean setInformation_video(String information_video) {
		this.information_video = information_video;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public SystemInformationBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getWell_num() {
		return well_num;
	}
	public SystemInformationBean setWell_num(int well_num) {
		this.well_num = well_num;
		return this;
	}
	public int getSend_num() {
		return send_num;
	}
	public SystemInformationBean setSend_num(int send_num) {
		this.send_num = send_num;
		return this;
	}
	public int getComment_num() {
		return comment_num;
	}
	public SystemInformationBean setComment_num(int comment_num) {
		this.comment_num = comment_num;
		return this;
	}
	public int getInformation_id(){
		return information_id;
	}
	public SystemInformationBean setInformation_id(int information_id){
		this.information_id= information_id;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public SystemInformationBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	public String getInformation_title(){
		return information_title;
	}
	public SystemInformationBean setInformation_title(String information_title){
		this.information_title= information_title;
		return this;
	}
	public String getInformation_desc(){
		return information_desc;
	}
	public SystemInformationBean setInformation_desc(String information_desc){
		this.information_desc= information_desc;
		return this;
	}
	public String getInformation_img(){
		return information_img;
	}
	public SystemInformationBean setInformation_img(String information_img){
		this.information_img= information_img;
		return this;
	}
	public String getInformation_url_desc(){
		return information_url_desc;
	}
	public SystemInformationBean setInformation_url_desc(String information_url_desc){
		this.information_url_desc= information_url_desc;
		return this;
	}
	public String getInformation_author(){
		return information_author;
	}
	public SystemInformationBean setInformation_author(String information_author){
		this.information_author= information_author;
		return this;
	}
	public String getInformation_resource(){
		return information_resource;
	}
	public SystemInformationBean setInformation_resource(String information_resource){
		this.information_resource= information_resource;
		return this;
	}
	public String getInformation_state(){
		return information_state;
	}
	public SystemInformationBean setInformation_state(String information_state){
		this.information_state= information_state;
		return this;
	}
	public String getRead_num(){
		return read_num;
	}
	public SystemInformationBean setRead_num(String read_num){
		this.read_num= read_num;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SystemInformationBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SystemInformationBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SystemInformationBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
