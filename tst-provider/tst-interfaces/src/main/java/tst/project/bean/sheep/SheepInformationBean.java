package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepInformationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String information_id;
	private String class_id;
	private String information_title;
	private String information_img;
	private String information_url;
	private String information_url_desc;
	private String information_author;
	private String information_resource;//信息来源
	private String is_delete;
	private String create_time;
	private String update_time;
	private String read_num;
	private String information_state;
	
	
	public String getInformation_state() {
		return information_state;
	}
	public SheepInformationBean setInformation_state(String information_state) {
		this.information_state = information_state;
		return this;
	}
	public String getRead_num() {
		return read_num;
	}
	public SheepInformationBean setRead_num(String read_num) {
		this.read_num = read_num;
		return this;
	}
	public String getInformation_id() {
		return information_id;
	}
	public SheepInformationBean setInformation_id(String information_id) {
		this.information_id = information_id;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public SheepInformationBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getInformation_title() {
		return information_title;
	}
	public SheepInformationBean setInformation_title(String information_title) {
		this.information_title = information_title;
		return this;
	}
	public String getInformation_img() {
		return information_img;
	}
	public SheepInformationBean setInformation_img(String information_img) {
		this.information_img = information_img;
		return this;
	}
	public String getInformation_url() {
		return information_url;
	}
	public SheepInformationBean setInformation_url(String information_url) {
		this.information_url = information_url;
		return this;
	}
	public String getInformation_url_desc() {
		return information_url_desc;
	}
	public SheepInformationBean setInformation_url_desc(String information_url_desc) {
		this.information_url_desc = information_url_desc;
		return this;
	}
	public String getInformation_author() {
		return information_author;
	}
	public SheepInformationBean setInformation_author(String information_author) {
		this.information_author = information_author;
		return this;
	}
	public String getInformation_resource() {
		return information_resource;
	}
	public SheepInformationBean setInformation_resource(String information_resource) {
		this.information_resource = information_resource;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepInformationBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepInformationBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepInformationBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
