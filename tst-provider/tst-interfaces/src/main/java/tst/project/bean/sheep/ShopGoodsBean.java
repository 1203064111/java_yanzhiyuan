package tst.project.bean.sheep;

import java.io.Serializable;

import tst.project.bean.shop.GoodsBean;

public class ShopGoodsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int shop_id;
	private String  goods_id;
	private String goods_ids;
	private String goods_name;
	private String goods_img;
	private String shop_state;
	private String goods_need_coin;
	private String goods_need_price;
	private String is_delete;
	private String create_time;
	private String update_time;
	private GoodsBean goodsBean;
	private String sort;
	private String sort_type;
	private String shop_type;//1为兑换，2为换购
	private String shop_type_show;
	private String take_num;
	private String shop_desc;//购买须知
	
	
	
	
	
	public String getGoods_ids() {
		return goods_ids;
	}
	public ShopGoodsBean setGoods_ids(String goods_ids) {
		this.goods_ids = goods_ids;
		return this;
	}
	public String getTake_num() {
		return take_num;
	}
	public ShopGoodsBean setTake_num(String take_num) {
		this.take_num = take_num;
		return this;
	}
	public String getShop_desc() {
		return shop_desc;
	}
	public ShopGoodsBean setShop_desc(String shop_desc) {
		this.shop_desc = shop_desc;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public ShopGoodsBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public ShopGoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public ShopGoodsBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getShop_type_show() {
		return shop_type_show;
	}
	public ShopGoodsBean setShop_type_show(String shop_type_show) {
		this.shop_type_show = shop_type_show;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public ShopGoodsBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getShop_type() {
		return shop_type;
	}
	public ShopGoodsBean setShop_type(String shop_type) {
		
		this.shop_type = shop_type;
		this.shop_type_show="1".equals(shop_type)?"兑换":"换购";
		return this;
	}
	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public ShopGoodsBean setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
		return this;
	}
	public int getShop_id() {
		return shop_id;
	}
	public ShopGoodsBean setShop_id(int shop_id) {
		this.shop_id = shop_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public ShopGoodsBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getShop_state() {
		return shop_state;
	}
	public ShopGoodsBean setShop_state(String shop_state) {
		this.shop_state = shop_state;
		return this;
	}
	public String getGoods_need_coin() {
		return goods_need_coin;
	}
	public ShopGoodsBean setGoods_need_coin(String goods_need_coin) {
		this.goods_need_coin = goods_need_coin;
		return this;
	}
	public String getGoods_need_price() {
		return goods_need_price;
	}
	public ShopGoodsBean setGoods_need_price(String goods_need_price) {
		this.goods_need_price = goods_need_price;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public ShopGoodsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ShopGoodsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ShopGoodsBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
