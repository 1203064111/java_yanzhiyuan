package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

public class GoodsChangerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int changer_id;
	private String changer_no;//兑换单号
	private String member_id;//
	private String changer_state;//0:兑换中 1:兑换成功 2:兑换失败
	private String changer_state_show;//
	private String changer_monnaie;//兑换价格
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String pay_time;//
	private String address_id;
	private String changer_type;//1:未结算 2:已结算
	private String changer_type_show;
	private List<GoodsChangerNoterBean> goodsChangerNoterBeans;
	
	private OrderAddressBean orderAddressBean;
	
	
	
	
	public OrderAddressBean getOrderAddressBean() {
		return orderAddressBean;
	}
	public GoodsChangerBean setOrderAddressBean(OrderAddressBean orderAddressBean) {
		this.orderAddressBean = orderAddressBean;
		return this;
	}
	public int getChanger_id() {
		return changer_id;
	}
	public GoodsChangerBean setChanger_id(int changer_id) {
		this.changer_id = changer_id;
		return this;
	}
	public String getChanger_no() {
		return changer_no;
	}
	public GoodsChangerBean setChanger_no(String changer_no) {
		this.changer_no = changer_no;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GoodsChangerBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getChanger_state() {
		return changer_state;
	}
	public GoodsChangerBean setChanger_state(String changer_state) {
		this.changer_state = changer_state;
		this.changer_state_show = "0".equals(changer_state)?"兑换中":
								  "1".equals(changer_state)?"兑换成功":
								  "2".equals(changer_state)?"兑换失败":"未知";
		return this;
	}
	public String getChanger_state_show() {
		return changer_state_show;
	}
	public GoodsChangerBean setChanger_state_show(String changer_state_show) {
		this.changer_state_show = changer_state_show;
		return this;
	}
	public String getChanger_monnaie() {
		return changer_monnaie;
	}
	public GoodsChangerBean setChanger_monnaie(String changer_monnaie) {
		this.changer_monnaie = changer_monnaie;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsChangerBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsChangerBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GoodsChangerBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getPay_time() {
		return pay_time;
	}
	public GoodsChangerBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}
	public String getAddress_id() {
		return address_id;
	}
	public GoodsChangerBean setAddress_id(String address_id) {
		this.address_id = address_id;
		return this;
	}
	public String getChanger_type() {
		return changer_type;
	}
	public GoodsChangerBean setChanger_type(String changer_type) {
		this.changer_type = changer_type;
		this.changer_type_show = "1".equals(changer_type)?"未结算":
								 "2".equals(changer_type)?"已结算":"";
		return this;
	}
	public String getChanger_type_show() {
		return changer_type_show;
	}
	public GoodsChangerBean setChanger_type_show(String changer_type_show) {
		this.changer_type_show = changer_type_show;
		return this;
	}
	public List<GoodsChangerNoterBean> getGoodsChangerNoterBeans() {
		return goodsChangerNoterBeans;
	}
	public GoodsChangerBean setGoodsChangerNoterBeans(List<GoodsChangerNoterBean> goodsChangerNoterBeans) {
		this.goodsChangerNoterBeans = goodsChangerNoterBeans;
		return this;
	}
	

}
