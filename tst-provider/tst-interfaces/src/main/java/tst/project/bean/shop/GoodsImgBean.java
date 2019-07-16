package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class GoodsImgBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int goods_img_id;//
	private String goods_id;//商品id
	private String goods_img;//商品图片路径
	private String sort;//权重
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getGoods_img_id(){
		return goods_img_id;
	}
	public GoodsImgBean setGoods_img_id(int goods_img_id){
		this.goods_img_id= goods_img_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public GoodsImgBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_img(){
		return goods_img;
	}
	public GoodsImgBean setGoods_img(String goods_img){
		this.goods_img= goods_img;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public GoodsImgBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsImgBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsImgBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsImgBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
