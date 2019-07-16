package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class YinlongBannerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int banner_id;//
	private String banner_title;//标题
	private String banner_img;//图片路径
	private String banner_range;//1:用户 2:师傅
	private String banner_range_show;
	private String banner_type;//0:无跳转 1:跳转外链
	private String banner_type_show;//
	private String chain_url;//外链网址
	private String sort;//排序
	private String sort_type;//
	private String is_delete;//1:删除
	private String create_time;//
	private String update_time;//
	public int getBanner_id(){
		return banner_id;
	}
	public YinlongBannerBean setBanner_id(int banner_id){
		this.banner_id= banner_id;
		return this;
	}
	public String getBanner_title(){
		return banner_title;
	}
	public YinlongBannerBean setBanner_title(String banner_title){
		this.banner_title= banner_title;
		return this;
	}
	public String getBanner_img(){
		return banner_img;
	}
	public YinlongBannerBean setBanner_img(String banner_img){
		this.banner_img= banner_img;
		return this;
	}
	public String getBanner_range(){
		return banner_range;
	}
	public YinlongBannerBean setBanner_range(String banner_range){
		this.banner_range= banner_range;
		this.banner_range_show= "1".equals(banner_range)?"用户":
			   					("2".equals(banner_range)?"师傅":"未知");
		return this;
	}
	
	public String getBanner_range_show() {
		return banner_range_show;
	}
	public YinlongBannerBean setBanner_range_show(String banner_range_show) {
		this.banner_range_show = banner_range_show;
		return this;
	}
	public String getBanner_type(){
		return banner_type;
	}
	public YinlongBannerBean setBanner_type(String banner_type){
		this.banner_type= banner_type;
		this.banner_type_show = "0".equals(banner_type)?"无跳转":
			   					("1".equals(banner_type)?"跳转外链":"未知");
		return this;
	}
	
	public String getBanner_type_show() {
		return banner_type_show;
	}
	public YinlongBannerBean setBanner_type_show(String banner_type_show) {
		this.banner_type_show = banner_type_show;
		return this;
	}
	public String getChain_url(){
		return chain_url;
	}
	public YinlongBannerBean setChain_url(String chain_url){
		this.chain_url= chain_url;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public YinlongBannerBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public YinlongBannerBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public YinlongBannerBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public YinlongBannerBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public YinlongBannerBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
