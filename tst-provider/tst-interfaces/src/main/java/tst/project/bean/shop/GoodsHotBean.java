package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class GoodsHotBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int hot_id;//
	private String hot_name;//搜索名称
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getHot_id(){
		return hot_id;
	}
	public GoodsHotBean setHot_id(int hot_id){
		this.hot_id= hot_id;
		return this;
	}
	public String getHot_name(){
		return hot_name;
	}
	public GoodsHotBean setHot_name(String hot_name){
		this.hot_name= hot_name;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsHotBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsHotBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsHotBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsHotBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
