package tst.project.bean.shop;

import java.io.Serializable;

public class GoodsCollectionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int collection_id;//
	private String collection_ids;//
	private String member_id;//用户id
	private String member_name;
	private String goods_id;//商品id
	private String is_delete;//
	private String create_time;
	private String update_time;
	
	
	
	public String getCollection_ids() {
		return collection_ids;
	}
	public GoodsCollectionBean setCollection_ids(String collection_ids) {
		this.collection_ids = collection_ids;
		return this;
	}
	public int getCollection_id() {
		return collection_id;
	}
	public GoodsCollectionBean setCollection_id(int collection_id) {
		this.collection_id = collection_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GoodsCollectionBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public GoodsCollectionBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsCollectionBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsCollectionBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsCollectionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GoodsCollectionBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
