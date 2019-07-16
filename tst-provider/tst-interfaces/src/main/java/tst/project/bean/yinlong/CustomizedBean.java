package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class CustomizedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int customized_id;//
	private String customized_name;//定制名称
	private String sort;//权重
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getCustomized_id(){
		return customized_id;
	}
	public CustomizedBean setCustomized_id(int customized_id){
		this.customized_id= customized_id;
		return this;
	}
	public String getCustomized_name(){
		return customized_name;
	}
	public CustomizedBean setCustomized_name(String customized_name){
		this.customized_name= customized_name;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public CustomizedBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public CustomizedBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public CustomizedBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public CustomizedBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
