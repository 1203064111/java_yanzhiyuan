package tst.project.bean.koubei;

import java.io.Serializable;

/**

**

*/

public class SceneClassMarketingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int marketing_id;//
	private String marketing_type;//1:推荐分类
	private String class_id;//
	private String class_name;//分类名称
	private String sort;
	private String sort_type;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMarketing_id(){
		return marketing_id;
	}
	public SceneClassMarketingBean setMarketing_id(int marketing_id){
		this.marketing_id= marketing_id;
		return this;
	}
	public String getMarketing_type(){
		return marketing_type;
	}
	public SceneClassMarketingBean setMarketing_type(String marketing_type){
		this.marketing_type= marketing_type;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public SceneClassMarketingBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	
	public String getClass_name() {
		return class_name;
	}
	public SceneClassMarketingBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	
	public String getSort() {
		return sort;
	}
	public SceneClassMarketingBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public SceneClassMarketingBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SceneClassMarketingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SceneClassMarketingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SceneClassMarketingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
