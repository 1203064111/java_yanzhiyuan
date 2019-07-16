package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class RenovationStyleBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int style_id;//
	private String style_name;//风格名称
	private String style_price;//风格单价
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getStyle_id(){
		return style_id;
	}
	public RenovationStyleBean setStyle_id(int style_id){
		this.style_id= style_id;
		return this;
	}
	public String getStyle_name(){
		return style_name;
	}
	public RenovationStyleBean setStyle_name(String style_name){
		this.style_name= style_name;
		return this;
	}
	public String getStyle_price(){
		return style_price;
	}
	public RenovationStyleBean setStyle_price(String style_price){
		this.style_price= style_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public RenovationStyleBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public RenovationStyleBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public RenovationStyleBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
