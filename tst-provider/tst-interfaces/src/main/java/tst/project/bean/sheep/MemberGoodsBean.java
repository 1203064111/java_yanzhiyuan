package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberGoodsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int member_goods_id;
	private int shop_id;
	private String  goods_id;
	private String goods_need_coin;
	private String goods_name;
	private String goods_img;
	private String goods_num;
	private String goods_price;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String specification_id;
	private String member_id;
	private String order_id;
	private String shop_type;
	
	
	
	
	
	
	public String getShop_type() {
		return shop_type;
	}
	public MemberGoodsBean setShop_type(String shop_type) {
		this.shop_type = shop_type;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public MemberGoodsBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getGoods_need_coin() {
		return goods_need_coin;
	}
	public MemberGoodsBean setGoods_need_coin(String goods_need_coin) {
		this.goods_need_coin = goods_need_coin;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberGoodsBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getMember_goods_id() {
		return member_goods_id;
	}
	public MemberGoodsBean setMember_goods_id(int member_goods_id) {
		this.member_goods_id = member_goods_id;
		return this;
	}
	public int getShop_id() {
		return shop_id;
	}
	public MemberGoodsBean setShop_id(int shop_id) {
		this.shop_id = shop_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public MemberGoodsBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public MemberGoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public MemberGoodsBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public MemberGoodsBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public MemberGoodsBean setGoods_price(String goods_price) {
		this.goods_price = goods_price;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberGoodsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberGoodsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberGoodsBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getSpecification_id() {
		return specification_id;
	}
	public MemberGoodsBean setSpecification_id(String specification_id) {
		this.specification_id = specification_id;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
