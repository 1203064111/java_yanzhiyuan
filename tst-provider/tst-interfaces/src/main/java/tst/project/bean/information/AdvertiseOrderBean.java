package tst.project.bean.information;

import java.io.Serializable;
import java.util.List;

public class AdvertiseOrderBean implements Serializable{
	/**
	 * 职位订单表
	 */
	private static final long serialVersionUID = 1L;
	private int advertise_order_id;//职位订单id
	private int material_id;//认证资料id
	private int position_id;//职位信息表id
	private int member_id;//用户id
	private String advertise_order_total;//订单总额
	private String order_pay_first;//订单首款
	private String order_pay_second;//订单尾款
	private String order_fee;//手续费
	private String mobile;//手机号
	private String order_type;//订单类型 1定金订单 2 支付订单
	private String order_type_show;
	private String order_state;//订单状态 0待支付 1已支付
	private String order_state_show;
	private String order_remit;//是否打款 0否 1是 
	private String order_remit_show;
	private String order_close;//打款状态 0未完成 1已完成
	private String order_close_show;//打款状态 0未完成 1已完成
	private String order_no;//订单号
	private String pay_type;//支付方式 0线上 1线下
	private String pay_type_show;
	private String pay_way;//支付 wx微信 alipay支付宝
	private String pay_charge;//支付凭证
	private String out_trade_no;//支付单号
	private String sort; // 权重
	private String is_delete; //
	private String create_time; //
	private String update_time;//
	private String cancel_time;//取消时间
	private String pay_end_time;//等待付款结束时间
	private String pay_time;//支付时间
	private MaterialBean materialBean;
	private PositionBean positionBean;
	private List<PayDetailBean> payDetailBeans;//支付明细
	private String time_num;
	private String order_remark;//订单备注
	
	
	
	
	
	public String getOrder_remark() {
		return order_remark;
	}
	public AdvertiseOrderBean setOrder_remark(String order_remark) {
		this.order_remark = order_remark;
		return this;
	}
	public String getOrder_type_show() {
		return order_type_show;
	}
	public AdvertiseOrderBean setOrder_type_show(String order_type_show) {
		this.order_type_show = order_type_show;
		return this;
	}
	public String getOrder_close_show() {
		return order_close_show;
	}
	public AdvertiseOrderBean setOrder_close_show(String order_close_show) {
		this.order_close_show = order_close_show;
		return this;
	}
	public String getOrder_close() {
		return order_close;
	}
	public AdvertiseOrderBean setOrder_close(String order_close) {
		this.order_close = order_close;
		this.order_close_show = "0".equals(order_close)?"未完成":
			"1".equals(order_close)?"已完成":"其他";
		return this;
	}
	public String getTime_num() {
		return time_num;
	}
	public AdvertiseOrderBean setTime_num(String time_num) {
		this.time_num = time_num;
		return this;
	}
	public String getOrder_remit() {
		return order_remit;
	}
	public AdvertiseOrderBean setOrder_remit(String order_remit) {
		this.order_remit = order_remit;
		this.order_remit_show = "0".equals(order_remit)?"否":
			"1".equals(order_remit)?"是":"其他";
		return this;
	}
	
	public String getOrder_remit_show() {
		return order_remit_show;
	}
	public AdvertiseOrderBean setOrder_remit_show(String order_remit_show) {
		this.order_remit_show = order_remit_show;
		return this;
	}
	public String getPay_type_show() {
		return pay_type_show;
	}
	public AdvertiseOrderBean setPay_type_show(String pay_type_show) {
		this.pay_type_show = pay_type_show;
		return this;
	}
	public String getOrder_type() {
		return order_type;
	}
	public AdvertiseOrderBean setOrder_type(String order_type) {
		this.order_type = order_type;
		this.order_type_show = "1".equals(order_remit)?"定金订单":
			"2".equals(order_remit)?"支付订单":"未知订单";
		return this;
	}
	public List<PayDetailBean> getPayDetailBeans() {
		return payDetailBeans;
	}
	public AdvertiseOrderBean setPayDetailBeans(List<PayDetailBean> payDetailBeans) {
		this.payDetailBeans = payDetailBeans;
		return this;
	}
	public MaterialBean getMaterialBean() {
		return materialBean;
	}
	public AdvertiseOrderBean setMaterialBean(MaterialBean materialBean) {
		this.materialBean = materialBean;
		return this;
	}
	public PositionBean getPositionBean() {
		return positionBean;
	}
	public AdvertiseOrderBean setPositionBean(PositionBean positionBean) {
		this.positionBean = positionBean;
		return this;
	}
	public int getAdvertise_order_id() {
		return advertise_order_id;
	}
	public AdvertiseOrderBean setAdvertise_order_id(int advertise_order_id) {
		this.advertise_order_id = advertise_order_id;
		return this;
	}
	
	public int getMaterial_id() {
		return material_id;
	}
	public AdvertiseOrderBean setMaterial_id(int material_id) {
		this.material_id = material_id;
		return this;
	}
	public int getPosition_id() {
		return position_id;
	}
	public AdvertiseOrderBean setPosition_id(int position_id) {
		this.position_id = position_id;
		return this;
	}
	public String getAdvertise_order_total() {
		return advertise_order_total;
	}
	public AdvertiseOrderBean setAdvertise_order_total(String advertise_order_total) {
		this.advertise_order_total = advertise_order_total;
		return this;
	}
	public String getOrder_pay_first() {
		return order_pay_first;
	}
	public AdvertiseOrderBean setOrder_pay_first(String order_pay_first) {
		this.order_pay_first = order_pay_first;
		return this;
	}
	public String getOrder_pay_second() {
		return order_pay_second;
	}
	public AdvertiseOrderBean setOrder_pay_second(String order_pay_second) {
		this.order_pay_second = order_pay_second;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public AdvertiseOrderBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getOrder_state() {
		return order_state;
	}
	public AdvertiseOrderBean setOrder_state(String order_state) {
		this.order_state = order_state;
		this.order_state_show = "0".equals(order_state)?"待支付":
			"1".equals(order_state)?"已支付":"其他";
		return this;
	}
	
	public String getOrder_state_show() {
		return order_state_show;
	}
	public AdvertiseOrderBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public AdvertiseOrderBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getPay_type() {
		return pay_type;
	}
	public AdvertiseOrderBean setPay_type(String pay_type) {
		this.pay_type = pay_type;
		this.pay_type_show = "0".equals(pay_type)?"线上":
			"1".equals(pay_type)?"线下":"其他";
		return this;
	}
	public String getSort() {
		return sort;
	}
	public AdvertiseOrderBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public AdvertiseOrderBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public AdvertiseOrderBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public AdvertiseOrderBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getPay_time() {
		return pay_time;
	}
	public AdvertiseOrderBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}
	public String getOrder_fee() {
		return order_fee;
	}
	public AdvertiseOrderBean setOrder_fee(String order_fee) {
		this.order_fee = order_fee;
		return this;
	}
	public String getPay_way() {
		return pay_way;
	}
	public AdvertiseOrderBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}
	public String getPay_charge() {
		return pay_charge;
	}
	public AdvertiseOrderBean setPay_charge(String pay_charge) {
		this.pay_charge = pay_charge;
		return this;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public AdvertiseOrderBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public AdvertiseOrderBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getCancel_time() {
		return cancel_time;
	}
	public AdvertiseOrderBean setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
		return this;
	}
	public String getPay_end_time() {
		return pay_end_time;
	}
	public AdvertiseOrderBean setPay_end_time(String pay_end_time) {
		this.pay_end_time = pay_end_time;
		return this;
	}
	

}
