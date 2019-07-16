package tst.project.bean.sheep;

import java.io.Serializable;

public class BroadBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String broad_id;
	private String broad_url;
	private String broad_title;
	private String broad_img;
	private String broad_desc;
	private String sort;
	private String sort_type;//0无跳转，1商品详情，2养只详情，3资讯详情
	private String is_delete;
	private String create_time;
	private String update_time;
	private String goods_id;
	private String bitch_sheep_id;
	private String information_id;
	private String broad_type;
	private String broad_type_show;
	
	
	
	
	
	
	public String getBroad_type_show() {
		return broad_type_show;
	}
	public BroadBean setBroad_type_show(String broad_type_show) {
		this.broad_type_show = broad_type_show;
		return this;
	}
	public String getBroad_type() {
		return broad_type;
	}
	public BroadBean setBroad_type(String broad_type) {
		this.broad_type = broad_type;
		this.broad_type_show="0".equals(broad_type)?"无跳转":
            "1".equals(broad_type)?"商品详情":
         	   "2".equals(broad_type)?"羊只详情":
         		   "3".equals(broad_type)?"资讯详情":"其他";
return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public BroadBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}
	public BroadBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}
	public String getInformation_id() {
		return information_id;
	}
	public BroadBean setInformation_id(String information_id) {
		this.information_id = information_id;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public BroadBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getBroad_id() {
		return broad_id;
	}
	public BroadBean setBroad_id(String broad_id) {
		this.broad_id = broad_id;
		return this;
	}
	public String getBroad_url() {
		return broad_url;
	}
	public BroadBean setBroad_url(String broad_url) {
		this.broad_url = broad_url;
		return this;
	}
	public String getBroad_title() {
		return broad_title;
	}
	public BroadBean setBroad_title(String broad_title) {
		this.broad_title = broad_title;
		return this;
	}
	public String getBroad_img() {
		return broad_img;
	}
	public BroadBean setBroad_img(String broad_img) {
		this.broad_img = broad_img;
		return this;
	}
	public String getBroad_desc() {
		return broad_desc;
	}
	public BroadBean setBroad_desc(String broad_desc) {
		this.broad_desc = broad_desc;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public BroadBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public BroadBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public BroadBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public BroadBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
