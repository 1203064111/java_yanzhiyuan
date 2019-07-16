package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class MaintailOrderMaterialBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_material_id;//
	private String order_id;//订单id
	private String material_name;//材料名称
	private String material_count;//材料数量
	private String material_price;//材料价格 0代表保修
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	public int getOrder_material_id() {
		return order_material_id;
	}
	public MaintailOrderMaterialBean setOrder_material_id(int order_material_id) {
		this.order_material_id = order_material_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public MaintailOrderMaterialBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getMaterial_name(){
		return material_name;
	}
	public MaintailOrderMaterialBean setMaterial_name(String material_name){
		this.material_name= material_name;
		return this;
	}
	
	public String getMaterial_count() {
		return material_count;
	}
	public MaintailOrderMaterialBean setMaterial_count(String material_count) {
		this.material_count = material_count;
		return this;
	}
	public String getMaterial_price(){
		return material_price;
	}
	public MaintailOrderMaterialBean setMaterial_price(String material_price){
		this.material_price= material_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailOrderMaterialBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailOrderMaterialBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailOrderMaterialBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
