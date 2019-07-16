package tst.project.bean.sheep;

import java.io.Serializable;

/**

**

*/

public class BannerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int banner_id;//
	private String banner_title;//标题
	private String banner_img;//图片
	private String banner_url;// 链接
	private String banner_desc;//详情
	private String sort;//排序
	private String sort_type;
	private String create_time;
	private String update_time;
	private String is_delete;
	private String banner_type;////1商品详情，3羊只详情，2资讯详情
	private String banner_type_show;
	private String goods_id;//商品id
	private String information_id;//资讯id
	private String bitch_sheep_id;//跳转养只详情
	private String information_site;//资讯链接
	
	
	
	
	public String getBanner_type_show() {
		return banner_type_show;
	}
	public BannerBean setBanner_type_show(String banner_type_show) {
		this.banner_type_show = banner_type_show;
		return this;
	}
	public String getInformation_id() {
		return information_id;
	}
	public BannerBean setInformation_id(String information_id) {
		this.information_id = information_id;
		return this;
	}
	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}
	public BannerBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public BannerBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getBanner_id(){
		return banner_id;
	}
	public BannerBean setBanner_id(int banner_id){
		this.banner_id= banner_id;
		return this;
	}
	public String getBanner_title(){
		return banner_title;
	}
	public BannerBean setBanner_title(String banner_title){
		this.banner_title= banner_title;
		return this;
	}
	public String getBanner_img(){
		return banner_img;
	}
	public BannerBean setBanner_img(String banner_img){
		this.banner_img= banner_img;
		return this;
	}
	public String getBanner_url(){
		return banner_url;
	}
	public BannerBean setBanner_url(String banner_url){
		this.banner_url= banner_url;
		return this;
	}
	public String getBanner_desc(){
		return banner_desc;
	}
	public BannerBean setBanner_desc(String banner_desc){
		this.banner_desc= banner_desc;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public BannerBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public BannerBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public BannerBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public BannerBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getBanner_type(){
		return banner_type;
	}
	public BannerBean setBanner_type(String banner_type){
		this.banner_type= banner_type;
		this.banner_type_show="0".equals(banner_type)?"无跳转":
			                   "1".equals(banner_type)?"商品详情":
			                	   "2".equals(banner_type)?"羊只详情":
			                		   "3".equals(banner_type)?"资讯详情":"其他";
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public BannerBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getInformation_site(){
		return information_site;
	}
	public BannerBean setInformation_site(String information_site){
		this.information_site= information_site;
		return this;
	}
}
