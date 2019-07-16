package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class GoodsClassMarketingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int marketing_id;//
	private String marketing_type;//1:推荐分类
	private String class_id;//分类id
	private String class_name;//分类名称
	private String class_img;//分类图标
	private String class_uuid;//分类的唯一标识
	private String sort;//权重排序
	private String sort_type;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMarketing_id(){
		return marketing_id;
	}
	public GoodsClassMarketingBean setMarketing_id(int marketing_id){
		this.marketing_id= marketing_id;
		return this;
	}
	public String getMarketing_type(){
		return marketing_type;
	}
	public GoodsClassMarketingBean setMarketing_type(String marketing_type){
		this.marketing_type= marketing_type;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public GoodsClassMarketingBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	public String getClass_name(){
		return class_name;
	}
	public GoodsClassMarketingBean setClass_name(String class_name){
		this.class_name= class_name;
		return this;
	}
	public String getClass_img(){
		return class_img;
	}
	public GoodsClassMarketingBean setClass_img(String class_img){
		this.class_img= class_img;
		return this;
	}
	public String getClass_uuid(){
		return class_uuid;
	}
	public GoodsClassMarketingBean setClass_uuid(String class_uuid){
		this.class_uuid= class_uuid;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsClassMarketingBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public GoodsClassMarketingBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsClassMarketingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsClassMarketingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsClassMarketingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
