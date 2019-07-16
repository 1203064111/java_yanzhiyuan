package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class CustomizedHuxingProgrammeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int programme_id;//
	private String huxing_id;//户型id
	private String programme_name;//方案名称
	private String programme_img;//方案图标
	private String programme_imgs;//方案多张图标 逗号隔开
	private String programme_price;//方案报价
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getProgramme_id(){
		return programme_id;
	}
	public CustomizedHuxingProgrammeBean setProgramme_id(int programme_id){
		this.programme_id= programme_id;
		return this;
	}
	public String getHuxing_id(){
		return huxing_id;
	}
	public CustomizedHuxingProgrammeBean setHuxing_id(String huxing_id){
		this.huxing_id= huxing_id;
		return this;
	}
	public String getProgramme_name(){
		return programme_name;
	}
	public CustomizedHuxingProgrammeBean setProgramme_name(String programme_name){
		this.programme_name= programme_name;
		return this;
	}
	public String getProgramme_img(){
		return programme_img;
	}
	public CustomizedHuxingProgrammeBean setProgramme_img(String programme_img){
		this.programme_img= programme_img;
		return this;
	}
	public String getProgramme_imgs(){
		return programme_imgs;
	}
	public CustomizedHuxingProgrammeBean setProgramme_imgs(String programme_imgs){
		this.programme_imgs= programme_imgs;
		return this;
	}
	
	public String getProgramme_price() {
		return programme_price;
	}
	public CustomizedHuxingProgrammeBean setProgramme_price(String programme_price) {
		this.programme_price = programme_price;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public CustomizedHuxingProgrammeBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public CustomizedHuxingProgrammeBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public CustomizedHuxingProgrammeBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public CustomizedHuxingProgrammeBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
