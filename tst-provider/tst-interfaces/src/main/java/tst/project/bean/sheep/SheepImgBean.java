package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepImgBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sheep_img_id;
	private String sheep_id;
	private String sheep_img;
	private String is_delete;
	private String update_time;
	private String create_time;
	private String sort;
	
	
	
	public String getSort() {
		return sort;
	}
	public SheepImgBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public int getSheep_img_id() {
		return sheep_img_id;
	}
	public SheepImgBean setSheep_img_id(int sheep_img_id) {
		this.sheep_img_id = sheep_img_id;
		return this;
	}
	public String getSheep_id() {
		return sheep_id;
	}
	public SheepImgBean setSheep_id(String sheep_id) {
		this.sheep_id = sheep_id;
		return this;
	}
	public String getSheep_img() {
		return sheep_img;
	}
	public SheepImgBean setSheep_img(String sheep_img) {
		this.sheep_img = sheep_img;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepImgBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepImgBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepImgBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
