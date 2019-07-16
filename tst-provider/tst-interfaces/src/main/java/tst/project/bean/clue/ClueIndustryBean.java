package tst.project.bean.clue;

import java.io.Serializable;

/**

**

*/

public class ClueIndustryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int industry_id;//
	private String industry_name;//行业名称
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getIndustry_id(){
		return industry_id;
	}
	public ClueIndustryBean setIndustry_id(int industry_id){
		this.industry_id= industry_id;
		return this;
	}
	public String getIndustry_name(){
		return industry_name;
	}
	public ClueIndustryBean setIndustry_name(String industry_name){
		this.industry_name= industry_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ClueIndustryBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ClueIndustryBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ClueIndustryBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
