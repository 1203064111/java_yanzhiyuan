package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class GoodsGroupBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int goods_group_id;//
	private String goods_id;//商品id
	private String group_name;//团购名称
	private String group_price;//团购价
	private String group_need_time;//团购等待时间（单位分钟）
	private String group_need_count;//团购需要人数
	private String sort;//权重
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getGoods_group_id(){
		return goods_group_id;
	}
	public GoodsGroupBean setGoods_group_id(int goods_group_id){
		this.goods_group_id= goods_group_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public GoodsGroupBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGroup_name(){
		return group_name;
	}
	public GoodsGroupBean setGroup_name(String group_name){
		this.group_name= group_name;
		return this;
	}
	public String getGroup_price(){
		return group_price;
	}
	public GoodsGroupBean setGroup_price(String group_price){
		this.group_price= group_price;
		return this;
	}
	public String getGroup_need_time(){
		return group_need_time;
	}
	public GoodsGroupBean setGroup_need_time(String group_need_time){
		this.group_need_time= group_need_time;
		return this;
	}
	public String getGroup_need_count(){
		return group_need_count;
	}
	public GoodsGroupBean setGroup_need_count(String group_need_count){
		this.group_need_count= group_need_count;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsGroupBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsGroupBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsGroupBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsGroupBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
