package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ShopBannerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int banner_id;//
	private String banner_title;//标题
	private String banner_img;//图片路径
	private String banner_type;//1:商品 2:资讯  3:职位 4百科 5医院
	private String banner_type_show;
	private String goods_id;//
	private String information_site;//资讯路径
	private String sort;//排序
	private String sort_type;//
	private String is_delete;//1:删除
	private String create_time;//
	private String update_time;//
	private String position_id;
	private String baike_id;
	private String merchants_id;
	
	
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public ShopBannerBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getBaike_id() {
		return baike_id;
	}
	public ShopBannerBean setBaike_id(String baike_id) {
		this.baike_id = baike_id;
		return this;
	}
	public String getPosition_id() {
		return position_id;
	}
	public ShopBannerBean setPosition_id(String position_id) {
		this.position_id = position_id;
		return this;
	}
	public int getBanner_id(){
		return banner_id;
	}
	public ShopBannerBean setBanner_id(int banner_id){
		this.banner_id= banner_id;
		return this;
	}
	
	public String getBanner_title(){
		return banner_title;
	}
	public ShopBannerBean setBanner_title(String banner_title){
		this.banner_title= banner_title;
		return this;
	}
	public String getBanner_img(){
		return banner_img;
	}
	public ShopBannerBean setBanner_img(String banner_img){
		this.banner_img= banner_img;
		return this;
	}
	public String getBanner_type() {
		return banner_type;
	}
	public ShopBannerBean setBanner_type(String banner_type) {
		this.banner_type = banner_type;
		this.banner_type_show = 
							   "1".equals(banner_type)?"商品":
							   "2".equals(banner_type)?"资讯":
								"3".equals(banner_type)?"职位":
								"4".equals(banner_type)?"百科":
									"5".equals(banner_type)?"医院":"未知";
		return this;
	}
	public String getBanner_type_show() {
		return banner_type_show;
	}
	public ShopBannerBean setBanner_type_show(String banner_type_show) {
		this.banner_type_show = banner_type_show;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public ShopBannerBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getInformation_site() {
		return information_site;
	}
	public ShopBannerBean setInformation_site(String information_site) {
		this.information_site = information_site;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public ShopBannerBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public ShopBannerBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ShopBannerBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ShopBannerBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ShopBannerBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
