package tst.project.bean.information;

import java.io.Serializable;

/**

**

*/

public class InformationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int information_id;//
	private String class_id;//分类id
	private String information_title;//
	private String information_desc;//简介
	private String information_img;//
	private String information_url_desc;//详情描述
	private String information_author;//作者
	private String information_resource;//来源
	private String information_state;//是否发布
	private String read_num;//阅读量
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getInformation_id(){
		return information_id;
	}
	public InformationBean setInformation_id(int information_id){
		this.information_id= information_id;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public InformationBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	public String getInformation_title(){
		return information_title;
	}
	public InformationBean setInformation_title(String information_title){
		this.information_title= information_title;
		return this;
	}
	public String getInformation_desc(){
		return information_desc;
	}
	public InformationBean setInformation_desc(String information_desc){
		this.information_desc= information_desc;
		return this;
	}
	public String getInformation_img(){
		return information_img;
	}
	public InformationBean setInformation_img(String information_img){
		this.information_img= information_img;
		return this;
	}
	public String getInformation_url_desc(){
		return information_url_desc;
	}
	public InformationBean setInformation_url_desc(String information_url_desc){
		this.information_url_desc= information_url_desc;
		return this;
	}
	public String getInformation_author(){
		return information_author;
	}
	public InformationBean setInformation_author(String information_author){
		this.information_author= information_author;
		return this;
	}
	public String getInformation_resource(){
		return information_resource;
	}
	public InformationBean setInformation_resource(String information_resource){
		this.information_resource= information_resource;
		return this;
	}
	public String getInformation_state(){
		return information_state;
	}
	public InformationBean setInformation_state(String information_state){
		this.information_state= information_state;
		return this;
	}
	public String getRead_num(){
		return read_num;
	}
	public InformationBean setRead_num(String read_num){
		this.read_num= read_num;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public InformationBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public InformationBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public InformationBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
