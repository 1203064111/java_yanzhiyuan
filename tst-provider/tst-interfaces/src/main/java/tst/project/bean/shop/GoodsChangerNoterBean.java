package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

public class GoodsChangerNoterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int changer_noter_id;
	private int changer_id;
	private String goods_id;//兑换单号
	private String goods_name;//
	private String goods_img;
	private String charge_state;//
	private String charge_state_show;//0:未发货 1已发货 
	private String goods_num;//
	private String goods_monnaie;//兑换价格
	private String goods_actual_monnaie;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private List<OrderAddressBean> orderAddressBeans;
	
	
	
	
	public List<OrderAddressBean> getOrderAddressBeans() {
		return orderAddressBeans;
	}
	public GoodsChangerNoterBean setOrderAddressBeans(List<OrderAddressBean> orderAddressBeans) {
		this.orderAddressBeans = orderAddressBeans;
		return this;
	}
	public String getCharge_state() {
		return charge_state;
	}
	public GoodsChangerNoterBean setCharge_state(String charge_state) {
		this.charge_state = charge_state;
		return this;
	}
	public String getCharge_state_show() {
		return charge_state_show;
	}
	public GoodsChangerNoterBean setCharge_state_show(String charge_state_show) {
		this.charge_state_show = charge_state_show;
		return this;
	}
	public int getChanger_noter_id() {
		return changer_noter_id;
	}
	public GoodsChangerNoterBean setChanger_noter_id(int changer_noter_id) {
		this.changer_noter_id = changer_noter_id;
		return this;
	}
	public int getChanger_id() {
		return changer_id;
	}
	public GoodsChangerNoterBean setChanger_id(int changer_id) {
		this.changer_id = changer_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsChangerNoterBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public GoodsChangerNoterBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public GoodsChangerNoterBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public GoodsChangerNoterBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}
	public String getGoods_monnaie() {
		return goods_monnaie;
	}
	public GoodsChangerNoterBean setGoods_monnaie(String goods_monnaie) {
		this.goods_monnaie = goods_monnaie;
		return this;
	}
	public String getGoods_actual_monnaie() {
		return goods_actual_monnaie;
	}
	public GoodsChangerNoterBean setGoods_actual_monnaie(String goods_actual_monnaie) {
		this.goods_actual_monnaie = goods_actual_monnaie;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsChangerNoterBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsChangerNoterBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GoodsChangerNoterBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	

}
