package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class MaintailPartsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int parts_id;//
	private String parts_name;//零部件名称
	private String parts_img;//零部件图标
	private String parts_state;//0:关闭 1:开启
	private String parent_id;//父id  -1代表第一层
	private String is_hava;//是否拥有下级 0:没有  其他有
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getParts_id(){
		return parts_id;
	}
	public MaintailPartsBean setParts_id(int parts_id){
		this.parts_id= parts_id;
		return this;
	}
	public String getParts_name(){
		return parts_name;
	}
	public MaintailPartsBean setParts_name(String parts_name){
		this.parts_name= parts_name;
		return this;
	}
	public String getParts_img(){
		return parts_img;
	}
	public MaintailPartsBean setParts_img(String parts_img){
		this.parts_img= parts_img;
		return this;
	}
	public String getParts_state(){
		return parts_state;
	}
	public MaintailPartsBean setParts_state(String parts_state){
		this.parts_state= parts_state;
		return this;
	}
	public String getParent_id(){
		return parent_id;
	}
	public MaintailPartsBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	
	public String getIs_hava() {
		return is_hava;
	}
	public MaintailPartsBean setIs_hava(String is_hava) {
		this.is_hava = is_hava;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailPartsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailPartsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailPartsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
