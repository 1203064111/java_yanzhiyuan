package tst.project.bean.shop;

import java.io.Serializable;

public class MemberGoodsRecordBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int member_goods_id;
	private String member_id;
	private String goods_id;
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public int getMember_goods_id() {
		return member_goods_id;
	}
	public MemberGoodsRecordBean setMember_goods_id(int member_goods_id) {
		this.member_goods_id = member_goods_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberGoodsRecordBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public MemberGoodsRecordBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberGoodsRecordBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberGoodsRecordBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberGoodsRecordBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	

}
