package tst.project.bean.yinlong.address;

import java.io.Serializable;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年7月31日 下午3:25:28
* 小区
*/
public class CommunityBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int village_id;
	private String village_province;  //小区所属省
	private String village_city;    //小区所属市
	private String village_country;  //小区所属区
	private String village_name;   //小区名称
	private String is_guarantee;   //是否保修  0:否 1:是
	private String is_delete;    //0:未删除 1:删除
	private String create_time;
	private String update_time;
	public int getVillage_id() {
		return village_id;
	}
	public void setVillage_id(int village_id) {
		this.village_id = village_id;
	}
	public String getVillage_province() {
		return village_province;
	}
	public void setVillage_province(String village_province) {
		this.village_province = village_province;
	}
	public String getVillage_city() {
		return village_city;
	}
	public void setVillage_city(String village_city) {
		this.village_city = village_city;
	}
	public String getVillage_country() {
		return village_country;
	}
	public void setVillage_country(String village_country) {
		this.village_country = village_country;
	}
	public String getVillage_name() {
		return village_name;
	}
	public void setVillage_name(String village_name) {
		this.village_name = village_name;
	}
	public String getIs_guarantee() {
		return is_guarantee;
	}
	public void setIs_guarantee(String is_guarantee) {
		this.is_guarantee = is_guarantee;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
