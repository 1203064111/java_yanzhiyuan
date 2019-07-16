package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class SpecificationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int specification_id;//
	private String specification_value;//型号名称
	private String parent_id;//父id
	private String sort;//权重
	private String create_time;//
	private String update_time;//
	private String is_delete;//
	private String goods_id;//
	
	private int class_specification_id;
	private String class_id;//分类id	
	private String is_check;//是否选中 1:选中 0:未选中
	private List<SpecificationBean> specificationBeans;//规格列表  --> 两级规格 
	/**
	 * specificationBeans 是一个数组,如果想取字段,只能通过下标
	 * SpecificationBean 是一个对象
	 */

	
	public String getIs_check() {
		return is_check;
	}
	public SpecificationBean setIs_check(String is_check) {
		this.is_check = is_check;
		return this;
	}
	public int getClass_specification_id() {
		return class_specification_id;
	}
	public SpecificationBean setClass_specification_id(int class_specification_id) {
		this.class_specification_id = class_specification_id;
		return this;
	}
	public String getClass_id() {
		return class_id;
	}
	public SpecificationBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public int getSpecification_id(){
		return specification_id;
	}
	public SpecificationBean setSpecification_id(int specification_id){
		this.specification_id= specification_id;
		return this;
	}
	
	
	public String getSpecification_value(){
		return specification_value;
	}
	public SpecificationBean setSpecification_value(String specification_value){
		this.specification_value= specification_value;
		return this;
	}
	public String getParent_id(){
		return parent_id;
	}
	public SpecificationBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public SpecificationBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SpecificationBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SpecificationBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SpecificationBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public SpecificationBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public List<SpecificationBean> getSpecificationBeans() {
		return specificationBeans;
	}
	public SpecificationBean setSpecificationBeans(List<SpecificationBean> specificationBeans) {
		this.specificationBeans = specificationBeans;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
