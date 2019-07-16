package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class CustomizedHuxingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int huxing_id;//
	private String customized_id;//定制id
	private String huxing_name;//户型名称
	private String huxing_img;//户型图标
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getHuxing_id(){
		return huxing_id;
	}
	public CustomizedHuxingBean setHuxing_id(int huxing_id){
		this.huxing_id= huxing_id;
		return this;
	}
	public String getCustomized_id(){
		return customized_id;
	}
	public CustomizedHuxingBean setCustomized_id(String customized_id){
		this.customized_id= customized_id;
		return this;
	}
	public String getHuxing_name(){
		return huxing_name;
	}
	public CustomizedHuxingBean setHuxing_name(String huxing_name){
		this.huxing_name= huxing_name;
		return this;
	}
	public String getHuxing_img(){
		return huxing_img;
	}
	public CustomizedHuxingBean setHuxing_img(String huxing_img){
		this.huxing_img= huxing_img;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public CustomizedHuxingBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public CustomizedHuxingBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public CustomizedHuxingBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public CustomizedHuxingBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
