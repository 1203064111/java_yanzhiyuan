package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class MaintailMaterialBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int material_id;//
	private String material_name;//材料名称
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMaterial_id(){
		return material_id;
	}
	public MaintailMaterialBean setMaterial_id(int material_id){
		this.material_id= material_id;
		return this;
	}
	public String getMaterial_name(){
		return material_name;
	}
	public MaintailMaterialBean setMaterial_name(String material_name){
		this.material_name= material_name;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public MaintailMaterialBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailMaterialBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailMaterialBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailMaterialBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
