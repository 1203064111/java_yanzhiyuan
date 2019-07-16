package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class GoodsClassTagBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int tag_id;//
	private int goods_tag_id;//商品关联标签主键id
	private String goods_id;//商品id
	private String tag_name;//标签名称
	private String class_id;//分类id
	private String parent_id;//父ID  -1第一级
	private String tag_uuid;//标签唯一标识
	private String tag_parent_uuid;//标签的唯一标识路径  比如一级分类的uuid是1  二级的是2  三级的是3 则第三级的parent_uuid就是1#2#3
	private String sort;//
	private String is_check;//是否选中 1:选中 0:未选中
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private List<GoodsClassTagBean> goodsClassTagBeans;
	
	public int getGoods_tag_id() {
		return goods_tag_id;
	}
	public GoodsClassTagBean setGoods_tag_id(int goods_tag_id) {
		this.goods_tag_id = goods_tag_id;
		return this;
	}
	
	
	public String getIs_check() {
		return is_check;
	}
	public GoodsClassTagBean setIs_check(String is_check) {
		this.is_check = is_check;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsClassTagBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public List<GoodsClassTagBean> getGoodsClassTagBeans() {
		return goodsClassTagBeans;
	}
	public GoodsClassTagBean setGoodsClassTagBeans(List<GoodsClassTagBean> goodsClassTagBeans) {
		this.goodsClassTagBeans = goodsClassTagBeans;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getTag_id(){
		return tag_id;
	}
	public GoodsClassTagBean setTag_id(int tag_id){
		this.tag_id= tag_id;
		return this;
	}
	public String getTag_name(){
		return tag_name;
	}
	public GoodsClassTagBean setTag_name(String tag_name){
		this.tag_name= tag_name;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public GoodsClassTagBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	public String getParent_id(){
		return parent_id;
	}
	public GoodsClassTagBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	public String getTag_uuid(){
		return tag_uuid;
	}
	public GoodsClassTagBean setTag_uuid(String tag_uuid){
		this.tag_uuid= tag_uuid;
		return this;
	}
	public String getTag_parent_uuid(){
		return tag_parent_uuid;
	}
	public GoodsClassTagBean setTag_parent_uuid(String tag_parent_uuid){
		this.tag_parent_uuid= tag_parent_uuid;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsClassTagBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsClassTagBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsClassTagBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsClassTagBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
