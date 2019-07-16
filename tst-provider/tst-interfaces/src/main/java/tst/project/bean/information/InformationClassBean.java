package tst.project.bean.information;

import java.io.Serializable;

/**

**

*/

public class InformationClassBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int class_id;//
	private String class_name;//
	private String class_state;//
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getClass_id(){
		return class_id;
	}
	public InformationClassBean setClass_id(int class_id){
		this.class_id= class_id;
		return this;
	}
	public String getClass_name(){
		return class_name;
	}
	public InformationClassBean setClass_name(String class_name){
		this.class_name= class_name;
		return this;
	}
	public String getClass_state(){
		return class_state;
	}
	public InformationClassBean setClass_state(String class_state){
		this.class_state= class_state;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public InformationClassBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public InformationClassBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public InformationClassBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public InformationClassBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
