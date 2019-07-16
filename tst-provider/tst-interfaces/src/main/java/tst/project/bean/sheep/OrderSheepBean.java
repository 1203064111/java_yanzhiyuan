package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.member.AddressBean;

public class OrderSheepBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int order_id;
	private String bitch_sheep_id;// 分期羊id
	private String member_id;
	private String member_account;// 用户账户
	private String member_nick_name;
	private String member_img;
	private String order_type;// 合养、认养
	private String order_type_show;//
	private String group_type;// 2、3、5人合养
	private String group_type_show;//
	private String is_collage;// 是否拼单
	private String member_group_id;//个人团购id
	private String sheep_group_id;//团购id
	private String is_join;//0开团，1参团
	private String order_no;// 订单号
	private String pay_no; // 付款号
	private String order_total_price;
	private String order_actual_price;// fu
	private String order_refund_price;
	private String order_state;// 订单状态 wait_group待团购
	private String order_state_show;
	private String Order_state2;// 删除订单
	private String pay_time;// 支付时间
	private String cancel_end_time;// 取消订单时间
	private String wait_order_time;// 合养等待时间
	private String sheep_breed_time;// 养殖时间（时间戳）
	private String sheep_end_time;// 养殖时间
	private String cancel_time;// 订单取消时间
	private String pay_way;// 支付方式
	private String address_id;// 地址id
	private String address_name;// 收货人
	private String address_mobile;// 手机号
	private String address_province;// 省
	private String address_city;// 市
	private String address_country;// 区
	private String address_detail;// 详细地址
	private String is_delete;
	private String update_time;
	private String create_time;
	private String send_price;// 配送费
	private String send_way;// 配送方式
	private String sheep_num;// 羊数量
	private String ear_signs;// 耳标号
	private String ear_ids;// 耳标id
	private String sheep_kg;// 重量
	private String is_insurance;// 是否保险
	private String insurance_price;// 保险费用
	private String is_cut;// 是否切割
	private String cut_price;// 切割费用
	private String is_invoice;//是否开发票
	private String invoice_class;// 发票类型1,2,3 纸质发票、电子发票、增值税发票
	private String invoice_class_show;
	private String invoice_type;// 发票类型 1，2 1个人，2公司
	private String invoice_type_show;
	
	private String invoice_name;// 发票收货人
	private String invoice_mobile;// 发票手机号
	private String invoice_address;// 发票地址
	private String is_coupon;// 0,1是否使用优惠券
	private String invoice_member_name;// 个人姓名
	private String invoice_company_name;// 公司名称
	private String invoice_company_no;// 公司识别号
	private String invoice_email;// email地址
	private String member_coupon_id;// 个人优惠券
	private String coupon_price;// 优惠券价格
	private String coupon_id;//优惠券
	private AddressBean addressBean;
	private String logistics_no;
	private String logistics_name;
	private String logistics_pinyin;
	private String send_company;
	private String send_name;
	private String send_mobile;
	private String send_province;
	private String send_city;
	private String send_country;
	private String send_address;
	private String send_zip_code;
	private String logistics_state;
	private String logistics_state_show;
	private String out_trade_no;//支付号
	private String pay_charge;//支付参数
	private String order_use_coin;//订单使用的金币数
	private String shop_id;//商城shop_id;
	private String goods_num;//商品数量
	private String cut_factory;
	private String cut_time;
	private String group_state;//0,1,2、  正常拼团，超时拼团成功，超时拼团失败
	
	

	
	
	private SheepBean bitchsheepBean;
	private List<SheepOrderBean> sheepOrderBeans;
	
	private SheepCouponBean memberCouponBean;
	
	
	
	public String getGroup_state() {
		return group_state;
	}


	public OrderSheepBean setGroup_state(String group_state) {
		this.group_state = group_state;
		return this;
	}

	private  List<MemberGoodsBean> memberGoodsBeans;
	private MemberGroupBean memberGroupBean;
	
	
	
	public List<MemberGoodsBean> getMemberGoodsBeans() {
		return memberGoodsBeans;
	}

	
	public MemberGroupBean getMemberGroupBean() {
		return memberGroupBean;
	}


	public OrderSheepBean setMemberGroupBean(MemberGroupBean memberGroupBean) {
		this.memberGroupBean = memberGroupBean;
		return this;
	}


	public OrderSheepBean setMemberGoodsBeans(List<MemberGoodsBean> memberGoodsBeans) {
		this.memberGoodsBeans = memberGoodsBeans;
		return this;
	}

	public String getGoods_num() {
		return goods_num;
	}

	public OrderSheepBean setGoods_num(String goods_num) {
		this.goods_num = goods_num;
		return this;
	}

	

	public String getOrder_use_coin() {
		return order_use_coin;
	}

	public OrderSheepBean setOrder_use_coin(String order_use_coin) {
		this.order_use_coin = order_use_coin;
		return this;
	}

	public String getShop_id() {
		return shop_id;
	}

	public OrderSheepBean setShop_id(String shop_id) {
		this.shop_id = shop_id;
		return this;
	}

	
	
	

	public String getOrder_total_price() {
		return order_total_price;
	}

	public OrderSheepBean setOrder_total_price(String order_total_price) {
		this.order_total_price = order_total_price;
		return this;
	}

	public String getPay_charge() {
		return pay_charge;
	}

	public OrderSheepBean setPay_charge(String pay_charge) {
		this.pay_charge = pay_charge;
		return this;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public OrderSheepBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}

	public SheepCouponBean getMemberCouponBean() {
		return memberCouponBean;
	}

	public OrderSheepBean setMemberCouponBean(SheepCouponBean memberCouponBean) {
		this.memberCouponBean = memberCouponBean;
		return this;
	}

	public String getInvoice_class_show() {
		return invoice_class_show;
	}

	public OrderSheepBean setInvoice_class_show(String invoice_class_show) {
		this.invoice_class_show = invoice_class_show;
		return this;
	}

	public String getInvoice_type_show() {
		return invoice_type_show;
	}

	public OrderSheepBean setInvoice_type_show(String invoice_type_show) {
		this.invoice_type_show = invoice_type_show;
		return this;
	}

	public List<SheepOrderBean> getSheepOrderBeans() {
		return sheepOrderBeans;
	}

	public OrderSheepBean setSheepOrderBeans(List<SheepOrderBean> sheepOrderBeans) {
		this.sheepOrderBeans = sheepOrderBeans;
		return this;
	}

	public String getOrder_type_show() {
		return order_type_show;
	}

	public OrderSheepBean setOrder_type_show(String order_type_show) {
		this.order_type_show = order_type_show;
		return this;
	}

	public String getGroup_type_show() {
		return group_type_show;
	}

	public OrderSheepBean setGroup_type_show(String group_type_show) {
		this.group_type_show = group_type_show;
		return this;
	}

	public String getOrder_state_show() {
		return order_state_show;
	}

	public OrderSheepBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}

	

	public String getCut_factory() {
		return cut_factory;
	}

	public OrderSheepBean setCut_factory(String cut_factory) {
		this.cut_factory = cut_factory;
		return this;
	}

	public String getCut_time() {
		return cut_time;
	}

	public OrderSheepBean setCut_time(String cut_time) {
		this.cut_time = cut_time;
		return this;
	}

	public SheepBean getBitchsheepBean() {
		return bitchsheepBean;
	}

	public OrderSheepBean setBitchsheepBean(SheepBean bitchsheepBean) {
		this.bitchsheepBean = bitchsheepBean;
		return this;
	}

	public String getLogistics_no() {
		return logistics_no;
	}

	public OrderSheepBean setLogistics_no(String logistics_no) {
		this.logistics_no = logistics_no;
		return this;
	}

	public String getLogistics_name() {
		return logistics_name;
	}

	public OrderSheepBean setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
		return this;
	}

	public String getLogistics_pinyin() {
		return logistics_pinyin;
	}

	public OrderSheepBean setLogistics_pinyin(String logistics_pinyin) {
		this.logistics_pinyin = logistics_pinyin;
		return this;
	}

	public String getSend_company() {
		return send_company;
	}

	public OrderSheepBean setSend_company(String send_company) {
		this.send_company = send_company;
		return this;
	}

	public String getSend_name() {
		return send_name;
	}

	public OrderSheepBean setSend_name(String send_name) {
		this.send_name = send_name;
		return this;
	}

	public String getSend_mobile() {
		return send_mobile;
	}

	public OrderSheepBean setSend_mobile(String send_mobile) {
		this.send_mobile = send_mobile;
		return this;
	}

	public String getSend_province() {
		return send_province;
	}

	public OrderSheepBean setSend_province(String send_province) {
		this.send_province = send_province;
		return this;
	}

	public String getSend_city() {
		return send_city;
	}

	public OrderSheepBean setSend_city(String send_city) {
		this.send_city = send_city;
		return this;
	}

	public String getSend_country() {
		return send_country;
	}

	public OrderSheepBean setSend_country(String send_country) {
		this.send_country = send_country;
		return this;
	}

	public String getSend_address() {
		return send_address;
	}

	public OrderSheepBean setSend_address(String send_address) {
		this.send_address = send_address;
		return this;
	}

	public String getSend_zip_code() {
		return send_zip_code;
	}

	public OrderSheepBean setSend_zip_code(String send_zip_code) {
		this.send_zip_code = send_zip_code;
		return this;
	}

	public String getLogistics_state() {
		return logistics_state;
	}

	public OrderSheepBean setLogistics_state(String logistics_state) {
		this.logistics_state = logistics_state;
		this.logistics_state_show="0".equals(logistics_state)?"等待发货":
			                      "1".equals(logistics_state)?"在途中":
			                      "2".equals(logistics_state)?"已送达":"无轨迹" ;
		return this;
	}

	public String getLogistics_state_show() {
		return logistics_state_show;
	}

	public OrderSheepBean setLogistics_state_show(String logistics_state_show) {
		this.logistics_state_show = logistics_state_show;
		return this;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public OrderSheepBean setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
		return this;
	}

	public String getIs_join() {
		return is_join;
	}

	public OrderSheepBean setIs_join(String is_join) {
		this.is_join = is_join;
		return this;
	}

	public String getSheep_group_id() {
		return sheep_group_id;
	}

	public OrderSheepBean setSheep_group_id(String sheep_group_id) {
		this.sheep_group_id = sheep_group_id;
		return this;
	}

	public String getIs_invoice() {
		return is_invoice;
	}

	public OrderSheepBean setIs_invoice(String is_invoice) {
		this.is_invoice = is_invoice;
		return this;
	}

	public String getInvoice_member_name() {
		return invoice_member_name;
	}

	public OrderSheepBean setInvoice_member_name(String invoice_member_name) {
		this.invoice_member_name = invoice_member_name;
		return this;
	}

	public String getInvoice_company_name() {
		return invoice_company_name;
	}

	public OrderSheepBean setInvoice_company_name(String invoice_company_name) {
		this.invoice_company_name = invoice_company_name;
		return this;
	}

	public String getInvoice_company_no() {
		return invoice_company_no;
	}

	public OrderSheepBean setInvoice_company_no(String invoice_company_no) {
		this.invoice_company_no = invoice_company_no;
		return this;
	}

	public String getInvoice_email() {
		return invoice_email;
	}

	public OrderSheepBean setInvoice_email(String invoice_email) {
		this.invoice_email = invoice_email;
		return this;
	}

	public String getInsurance_price() {
		return insurance_price;
	}

	public OrderSheepBean setInsurance_price(String insurance_price) {
		this.insurance_price = insurance_price;
		return this;
	}

	public String getCut_price() {
		return cut_price;
	}

	public OrderSheepBean setCut_price(String cut_price) {
		this.cut_price = cut_price;
		return this;
	}

	public String getMember_account() {
		return member_account;
	}

	public OrderSheepBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}

	public String getIs_insurance() {
		return is_insurance;
	}

	public OrderSheepBean setIs_insurance(String is_insurance) {
		this.is_insurance = is_insurance;
		return this;
	}

	public String getIs_cut() {
		return is_cut;
	}

	public OrderSheepBean setIs_cut(String is_cut) {
		this.is_cut = is_cut;
		return this;
	}

	public String getInvoice_class() {
		return invoice_class;
	}

	public OrderSheepBean setInvoice_class(String invoice_class) {
		this.invoice_class = invoice_class;
		this.invoice_class_show="1".equals(invoice_class)?"纸质发票":
			"2".equals(invoice_class)?"电子发票":"增值税发票";
		return this;
	}

	public String getInvoice_type() {
		return invoice_type;
	}

	public OrderSheepBean setInvoice_type(String invoice_type) {
		this.invoice_type = invoice_type;
		this.invoice_type_show="1".equals(invoice_type)?"个人":"公司";
		return this;
	}

	public String getInvoice_name() {
		return invoice_name;
	}

	public OrderSheepBean setInvoice_name(String invoice_name) {
		this.invoice_name = invoice_name;
		return this;
	}

	public String getInvoice_mobile() {
		return invoice_mobile;
	}

	public OrderSheepBean setInvoice_mobile(String invoice_mobile) {
		this.invoice_mobile = invoice_mobile;
		return this;
	}

	public String getInvoice_address() {
		return invoice_address;
	}

	public OrderSheepBean setInvoice_address(String invoice_address) {
		this.invoice_address = invoice_address;
		return this;
	}

	public String getIs_coupon() {
		return is_coupon;
	}

	public OrderSheepBean setIs_coupon(String is_coupon) {
		this.is_coupon = is_coupon;
		return this;
	}

	public String getMember_coupon_id() {
		return member_coupon_id;
	}

	public OrderSheepBean setMember_coupon_id(String member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
		return this;
	}

	public String getCoupon_price() {
		return coupon_price;
	}

	public OrderSheepBean setCoupon_price(String coupon_price) {
		this.coupon_price = coupon_price;
		return this;
	}

	public String getSheep_end_time() {
		return sheep_end_time;
	}

	public OrderSheepBean setSheep_end_time(String sheep_end_time) {
		this.sheep_end_time = sheep_end_time;
		return this;
	}

	public String getMember_nick_name() {
		return member_nick_name;
	}

	public OrderSheepBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}

	public String getMember_img() {
		return member_img;
	}

	public OrderSheepBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}

	public String getIs_collage() {
		return is_collage;
	}

	public OrderSheepBean setIs_collage(String is_collage) {
		this.is_collage = is_collage;
		return this;
	}

	public String getAddress_country() {
		return address_country;
	}

	public OrderSheepBean setAddress_country(String address_country) {
		this.address_country = address_country;
		return this;

	}

	public AddressBean getAddressBean() {
		return addressBean;
	}

	public OrderSheepBean setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}

	public OrderSheepBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}

	public int getOrder_id() {
		return order_id;
	}

	public OrderSheepBean setOrder_id(int order_id) {
		this.order_id = order_id;
		return this;
	}

	public String getMember_id() {
		return member_id;
	}

	public OrderSheepBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}

	public String getOrder_type() {
		return order_type;
	}

	public OrderSheepBean setOrder_type(String order_type) {
		this.order_type = order_type;
		this.order_type_show="1".equals(order_type)?"合养":"认养";
		return this;
	}

	public String getGroup_type() {
		return group_type;
	}

	public OrderSheepBean setGroup_type(String group_type) {
		this.group_type = group_type;
		this.group_type_show="2".equals(group_type)?"双人合养":
			                "3".equals(group_type)?"三人合养":
			                	 "4".equals(group_type)?"四人合养":
			                		 "5".equals(group_type)?"五人合养":"其他";
		return this;
	}

	public String getMember_group_id() {
		return member_group_id;
	}

	public OrderSheepBean setMember_group_id(String member_group_id) {
		this.member_group_id = member_group_id;
		return this;
	}

	public String getOrder_no() {
		return order_no;
	}

	public OrderSheepBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}

	public String getPay_no() {
		return pay_no;
	}

	public OrderSheepBean setPay_no(String pay_no) {
		this.pay_no = pay_no;
		return this;
	}

	public String getOrder_actual_price() {
		return order_actual_price;
	}

	public OrderSheepBean setOrder_actual_price(String order_actual_price) {
		this.order_actual_price = order_actual_price;
		return this;
	}

	public String getOrder_refund_price() {
		return order_refund_price;
	}

	public OrderSheepBean setOrder_refund_price(String order_refund_price) {
		this.order_refund_price = order_refund_price;
		return this;
	}

	public String getOrder_state() {
		return order_state;
	}

	public OrderSheepBean setOrder_state(String order_state) {
		this.order_state = order_state;
		this.order_state_show="wait_pay".equals(order_state)?"待付款":
			"cancel".equals(order_state)?"已取消":
			"group_fail".equals(order_state)?"合养超时":
			"wait_group".equals(order_state)?"待合养":
				"wait_breed".equals(order_state)?"养殖中":
				"wait_send".equals(order_state)?"待发货":
					"wait_receive".equals(order_state)?"待收货":
						"wait_assessment".equals(order_state)?"待评价":
							"end".equals(order_state)?"已完成":"已关闭";
			                
		return this;
	}

	public String getOrder_state2() {
		return Order_state2;
	}

	public OrderSheepBean setOrder_state2(String order_state2) {
		Order_state2 = order_state2;
		return this;
	}

	public String getPay_time() {
		return pay_time;
	}

	public OrderSheepBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}

	public String getCancel_end_time() {
		return cancel_end_time;
	}

	public OrderSheepBean setCancel_end_time(String cancel_end_time) {
		this.cancel_end_time = cancel_end_time;
		return this;
	}

	public String getWait_order_time() {
		return wait_order_time;
	}

	public OrderSheepBean setWait_order_time(String wait_order_time) {
		this.wait_order_time = wait_order_time;
		return this;
	}

	public String getSheep_breed_time() {
		return sheep_breed_time;
	}

	public OrderSheepBean setSheep_breed_time(String sheep_breed_time) {
		this.sheep_breed_time = sheep_breed_time;
		return this;
	}

	public String getCancel_time() {
		return cancel_time;
	}

	public OrderSheepBean setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
		return this;
	}

	public String getPay_way() {
		return pay_way;
	}

	public OrderSheepBean setPay_way(String pay_way) {
		this.pay_way = pay_way;
		return this;
	}

	public String getAddress_id() {
		return address_id;
	}

	public OrderSheepBean setAddress_id(String address_id) {
		this.address_id = address_id;
		return this;
	}

	public String getAddress_name() {
		return address_name;
	}

	public OrderSheepBean setAddress_name(String address_name) {
		this.address_name = address_name;
		return this;
	}

	public String getAddress_mobile() {
		return address_mobile;
	}

	public OrderSheepBean setAddress_mobile(String address_mobile) {
		this.address_mobile = address_mobile;
		return this;
	}

	public String getAddress_province() {
		return address_province;
	}

	public OrderSheepBean setAddress_province(String address_province) {
		this.address_province = address_province;
		return this;
	}

	public String getAddress_city() {
		return address_city;
	}

	public OrderSheepBean setAddress_city(String address_city) {
		this.address_city = address_city;
		return this;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public OrderSheepBean setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
		return this;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public OrderSheepBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public OrderSheepBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}

	public String getCreate_time() {
		return create_time;
	}

	public OrderSheepBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

	public String getSend_price() {
		return send_price;
	}

	public OrderSheepBean setSend_price(String send_price) {
		this.send_price = send_price;
		return this;
	}

	public String getSend_way() {
		return send_way;
	}

	public OrderSheepBean setSend_way(String send_way) {
		this.send_way = send_way;
		return this;
	}

	public String getSheep_num() {
		return sheep_num;
	}

	public OrderSheepBean setSheep_num(String sheep_num) {
		this.sheep_num = sheep_num;
		return this;
	}

	public String getEar_signs() {
		return ear_signs;
	}

	public OrderSheepBean setEar_signs(String ear_signs) {
		this.ear_signs = ear_signs;
		return this;
	}

	public String getEar_ids() {
		return ear_ids;
	}

	public OrderSheepBean setEar_ids(String ear_ids) {
		this.ear_ids = ear_ids;
		return this;
	}

	public String getSheep_kg() {
		return sheep_kg;
	}

	public OrderSheepBean setSheep_kg(String sheep_kg) {
		this.sheep_kg = sheep_kg;
		return this;
	}

}
