package tst.project.bean.koubei;

import java.io.Serializable;

/**

**

*/

public class SceneMarketingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int marketing_id;//
	private String marketing_type;//1:推荐场景
	private String merchants_id;//商家id
	private String scene_id;//
	private String scene_name;//场景名称
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public SceneMarketingBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getScene_name() {
		return scene_name;
	}
	public SceneMarketingBean setScene_name(String scene_name) {
		this.scene_name = scene_name;
		return this;
	}
	public int getMarketing_id(){
		return marketing_id;
	}
	public SceneMarketingBean setMarketing_id(int marketing_id){
		this.marketing_id= marketing_id;
		return this;
	}
	public String getMarketing_type(){
		return marketing_type;
	}
	public SceneMarketingBean setMarketing_type(String marketing_type){
		this.marketing_type= marketing_type;
		return this;
	}
	public String getScene_id(){
		return scene_id;
	}
	public SceneMarketingBean setScene_id(String scene_id){
		this.scene_id= scene_id;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SceneMarketingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SceneMarketingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SceneMarketingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
