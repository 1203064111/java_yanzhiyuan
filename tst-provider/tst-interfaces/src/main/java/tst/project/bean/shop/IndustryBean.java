package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class IndustryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int industry_id;//
	private int class_industry_id;//分类关联行业id
	private int merchants_industry_id;//商家关联行业id
	private String merchants_id;//商家id
	private String class_id;//分类
	private String industry_name;//行业名称
	private String industry_state;//状态 1：上线 0:下线
	private String sort;//权重
	private String sort_type;////desc 从大到小  asc 从小到大
	private String is_check;//是否选中
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getIndustry_id(){
		return industry_id;
	}
	public IndustryBean setIndustry_id(int industry_id){
		this.industry_id= industry_id;
		return this;
	}
	
	
	
	public int getMerchants_industry_id() {
		return merchants_industry_id;
	}
	public IndustryBean setMerchants_industry_id(int merchants_industry_id) {
		this.merchants_industry_id = merchants_industry_id;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public IndustryBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getIs_check() {
		return is_check;
	}
	public IndustryBean setIs_check(String is_check) {
		this.is_check = is_check;
		return this;
	}
	public int getClass_industry_id() {
		return class_industry_id;
	}
	public IndustryBean setClass_industry_id(int class_industry_id) {
		this.class_industry_id = class_industry_id;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public IndustryBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getIndustry_name(){
		return industry_name;
	}
	public IndustryBean setIndustry_name(String industry_name){
		this.industry_name= industry_name;
		return this;
	}
	public String getIndustry_state(){
		return industry_state;
	}
	public IndustryBean setIndustry_state(String industry_state){
		this.industry_state= industry_state;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public IndustryBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public IndustryBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public IndustryBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public IndustryBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public IndustryBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
