package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class MaintailVillageBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int village_id;//
	private String village_province;//小区所属省
	private String village_city;//小区所属市
	private String village_country;//小区所属区
	private String village_address;//小区详情地址
	private String village_name;//小区名称
	private String is_guarantee;//是否保修
	private String is_recommed;//置顶推荐
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	public int getVillage_id(){
		return village_id;
	}
	public MaintailVillageBean setVillage_id(int village_id){
		this.village_id= village_id;
		return this;
	}
	
	public String getIs_recommed() {
		return is_recommed;
	}
	public MaintailVillageBean setIs_recommed(String is_recommed) {
		this.is_recommed = is_recommed;
		return this;
	}
	public String getVillage_province(){
		return village_province;
	}
	public MaintailVillageBean setVillage_province(String village_province){
		this.village_province= village_province;
		return this;
	}
	public String getVillage_city(){
		return village_city;
	}
	public MaintailVillageBean setVillage_city(String village_city){
		this.village_city= village_city;
		return this;
	}
	public String getVillage_country(){
		return village_country;
	}
	public MaintailVillageBean setVillage_country(String village_country){
		this.village_country= village_country;
		return this;
	}
	
	public String getVillage_address() {
		return village_address;
	}
	public MaintailVillageBean setVillage_address(String village_address) {
		this.village_address = village_address;
		return this;
	}
	public String getVillage_name(){
		return village_name;
	}
	public MaintailVillageBean setVillage_name(String village_name){
		this.village_name= village_name;
		return this;
	}
	public String getIs_guarantee(){
		return is_guarantee;
	}
	public MaintailVillageBean setIs_guarantee(String is_guarantee){
		this.is_guarantee= is_guarantee;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailVillageBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailVillageBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailVillageBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
