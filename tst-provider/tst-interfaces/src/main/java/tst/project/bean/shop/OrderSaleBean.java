package tst.project.bean.shop;

import java.io.Serializable;

public class OrderSaleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order_sale_id;
	private String order_state;//订单状态:cancel:取消 wait_pay:代付款 wait_send:待发货 pay_cancel:已取消发货 wait_receive:待收货 wait_assessment:待评价 end:已完成 refund:订单所有商品都退款 close:订单已结算 关闭状态
	private String order_price;//销售额
	private String order_state_show;
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public int getOrder_sale_id() {
		return order_sale_id;
	}
	public OrderSaleBean setOrder_sale_id(int order_sale_id) {
		this.order_sale_id = order_sale_id;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public OrderSaleBean setOrder_state(String order_state) {
		this.order_state = order_state;
		this.order_state_show=  "cancel".equals(order_state)?"已取消":
								"pay_cancel".equals(order_state)?"已取消发货":
								"wait_pay".equals(order_state)?"待付款":
								"wait_send".equals(order_state)?"待发货":
								"wait_receive".equals(order_state)?"待收货":
								"wait_assessment".equals(order_state)?"待评价":
								"end".equals(order_state)?"已完成":
								"refund".equals(order_state)?"已退款":
								"close".equals(order_state)?"已结算":
								"all".equals(order_state)?"总销售额":"未知状态";
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public OrderSaleBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getOrder_price() {
		return order_price;
	}
	public OrderSaleBean setOrder_price(String order_price) {
		this.order_price = order_price;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public OrderSaleBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderSaleBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public OrderSaleBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	
	
	

}
