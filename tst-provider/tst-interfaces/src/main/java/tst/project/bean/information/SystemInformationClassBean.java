package tst.project.bean.information;

import java.io.Serializable;

/**

**

*/

public class SystemInformationClassBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int class_id;//
	private String class_name;//资讯分类名称
	private String class_code;//编码
	private String class_state;//状态 0有效 1无效 
	private String class_type;//Y颜 Z职
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	public String getClass_code() {
		return class_code;
	}
	public SystemInformationClassBean setClass_code(String class_code) {
		this.class_code = class_code;
		return this;
	}
	public String getClass_type() {
		return class_type;
	}
	public SystemInformationClassBean setClass_type(String class_type) {
		this.class_type = class_type;
		return this;
	}
	public int getClass_id(){
		return class_id;
	}
	public SystemInformationClassBean setClass_id(int class_id){
		this.class_id= class_id;
		return this;
	}
	public String getClass_name(){
		return class_name;
	}
	public SystemInformationClassBean setClass_name(String class_name){
		this.class_name= class_name;
		return this;
	}
	public String getClass_state(){
		return class_state;
	}
	public SystemInformationClassBean setClass_state(String class_state){
		this.class_state= class_state;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public SystemInformationClassBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SystemInformationClassBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SystemInformationClassBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SystemInformationClassBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
