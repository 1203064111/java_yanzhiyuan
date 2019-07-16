package tst.project.service.interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.activity.ZMAyOrderBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.InvoiceBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.FreightCityBean;
import tst.project.bean.shop.GoodsAssessmentBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.GoodsChangerNoterBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberGoodsRecordBean;
import tst.project.bean.shop.MemberIntegralBean;
import tst.project.bean.shop.MemberVoucherBean;
import tst.project.bean.shop.MerchantsBalanceBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsBillBean;
import tst.project.bean.shop.OrderActivityBean;
import tst.project.bean.shop.OrderActivityGoodsBean;
import tst.project.bean.shop.OrderAddressBean;
import tst.project.bean.shop.OrderAssessmentBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderCreditBean;
import tst.project.bean.shop.OrderGoodsBean;
import tst.project.bean.shop.OrderInvoiceBean;
import tst.project.bean.shop.OrderLogisticsBean;
import tst.project.bean.shop.OrderLogisticsCompanyBean;
import tst.project.bean.shop.OrderLogisticsDetailBean;
import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.bean.shop.OrderRechargeActivityBean;
import tst.project.bean.shop.OrderRechargeBean;
import tst.project.bean.shop.OrderRefundBean;
import tst.project.bean.shop.OrderRefundReasonBean;
import tst.project.bean.shop.OrderSaleBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.dao.interfaces.GoodsDao;
import tst.project.dao.interfaces.MerchantsDao;
import tst.project.dao.interfaces.OrderDao;
import tst.project.dao.interfaces.ShopCarDao;
import tst.project.dao.interfaces.ShopCouponDao;
import tst.project.dao.interfaces.ShopMemberDao;
import tst.project.dao.interfaces.ShopSettingDao;
import tst.project.interfaces.IAddressService;
import tst.project.interfaces.IInvoiceService;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IOrderService;
import tst.project.utils.NumberUtils;
import tst.project.utils.PayUtils;
import tst.project.utils.StringUtils;
import tst.project.utils.UUIDUtils;
import tst.project.utils.WXUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService implements IOrderService {
	@Autowired
	OrderDao orderDao;

	@Autowired
	ShopCarDao shopCarDao;

	@Autowired
	GoodsDao goodsDao;

	@Autowired
	IAddressService addressService;

	@Autowired
	ShopCouponDao shopCouponDao;

	@Autowired
	MerchantsDao merchantsDao;

	@Autowired
	IMemberService memberService;

	@Autowired
	ShopSettingDao shopSettingDao;

	@Autowired
	IInvoiceService invoiceService;
	
	@Autowired
	ShopMemberDao shopMemberDao;
	
	@Value("${wx_lite_appid}")
	private String wx_lite_appid;

	@Value("${wx_lite_appsecret}")
	private String wx_lite_appsecret;

	@Value("${wx_lite_partnerkey}")
	private String wx_lite_partnerkey;

	@Value("${wx_lite_mch_id}")
	private String wx_lite_mch_id;

	@Value("${wx_lite_notify_url}")
	private String wx_lite_notify_url;

	@Value("${wx_pub_appid}")
	private String wx_pub_appid;

	@Value("${wx_pub_appsecret}")
	private String wx_pub_appsecret;

	@Value("${wx_pub_partnerkey}")
	private String wx_pub_partnerkey;

	@Value("${wx_pub_mch_id}")
	private String wx_pub_mch_id;

	@Value("${wx_pub_notify_url}")
	private String wx_pub_notify_url;

	@Value("${wx_appid}")
	private String wx_appid;

	@Value("${wx_appsecret}")
	private String wx_appsecret;

	@Value("${wx_partnerkey}")
	private String wx_partnerkey;

	@Value("${wx_mch_id}")
	private String wx_mch_id;

	@Value("${wx_notify_url}")
	private String wx_notify_url;

	@Value("${alipay_app_id}")
	private String alipay_app_id;

	@Value("${alipay_private_key}")
	private String alipay_private_key;

	@Value("${alipay_public_key}")
	private String alipay_public_key;

	@Value("${alipay_notify_url}")
	private String alipay_notify_url;

	@Value("${is_real_pay}")
	private String is_real_pay;

	@Value("${is_give_integral}")
	private String is_give_integral;

	@Value("${is_assessment}")
	private String is_assessment;

	@Value("${is_give_voucher}")
	private String is_give_voucher;

	@Value("${is_accumulation}")
	private String is_accumulation;

	@Value("${img_path}")
	private String img_path;
	
	@Value("${pay_template}")
	private String pay_template;

	@Override
	public Object timeingReceiveOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		List<OrderMerchantsBean> orderMerchantsBeans = orderDao.timeingReceiveOrder(orderMerchantsBean);
		if(orderMerchantsBeans != null) {
			for (int i = 0; i < orderMerchantsBeans.size(); i++) {
				OrderMerchantsBean orderMerchantsBean2 = orderMerchantsBeans.get(i);
				int num = orderDao.receiveOrder(orderMerchantsBean2);
				if(num <= 0) {
					throw new AppException("收货失败");
				}
			}
		}
		
		return 1;
	}
	@Override
	public Object timeingPayNoticeOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps=orderDao.getNoPayNoticeOrder(orderMerchantsBean);
		if(maps!=null){
			for (int i = 0; i < maps.size(); i++) {
				Map<String, Object> map=maps.get(i);

				MemberBean memberBean=memberService
						.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(map.get("member_id")+"")));
				if(memberBean!=null){
					String access_token=WXUtils.getAccess_token(wx_pub_appid, wx_pub_appsecret);
					
					String result=WXUtils.sendTemplet(access_token,pay_template
							.replace("open_id", memberBean.getWeixin_open_id()+"")
							.replace("order_merchants_id",map.get("order_merchants_id")+"")
							.replace("order_merchants_no",map.get("order_merchants_no")+"")
							.replace("time", map.get("pay_time")+"")
							.replace("goods_name",map.get("goods_name")+"")
							.replace("order_actual_price",map.get("order_actual_price")+"")
							.replace("address_name",map.get("address_name")+""));
				}
			}
			
			orderDao.timeingPayNoticeOrder(orderMerchantsBean);
		}
		return 1;
	}
	
	
	@Override
	public Object timeingCommissionOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		int num = 0;

		List<OrderMerchantsBean> orderMerchantsBeans = orderDao.getCommissionOrders(orderMerchantsBean);
		if (orderMerchantsBeans == null||orderMerchantsBeans.size()<=0) {
			throw new AppException("暂无订单");
		}
		for (int i = 0; i < orderMerchantsBeans.size(); i++) {
			OrderMerchantsBean orderMerchantsBean2 = orderMerchantsBeans.get(i);
			MemberBean memberBean = memberService.getMemberDetail(
					new MemberBean().setMember_id(NumberUtils.Integer(orderMerchantsBean2.getMember_id())));
			if (!StringUtils.isNull(memberBean.getFill_invitation_code())) {
				MerchantsBean merchantsBean = merchantsDao.getMerchantsDetail(
						new MerchantsBean().setMerchants_id(NumberUtils.Integer(memberBean.getFill_invitation_code())));

				num = orderDao.timeingCommissionOrder(
						orderMerchantsBean2.setCommission_merchants_id(merchantsBean.getMerchants_id() + "")
								.setCommission_merchants_name(merchantsBean.getMerchants_name()));
				if (num <= 0) {
					throw new AppException("佣金分配失败");
				}
			}else{
				num = orderDao.timeingCommissionOrder(
						orderMerchantsBean2.setCommission_merchants_id("-1")
								.setCommission_merchants_name("平台"));
				if (num <= 0) {
					throw new AppException("佣金分配失败");
				}
			}
		}

		return num;
	}

	@Override
	public Object timeingOrderSales(OrderSaleBean orderSaleBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object timeingCloseOrders(OrderBean orderBean) {
		// TODO Auto-generated method stub
		List<OrderMerchantsBean> orderMerchantsBeans = orderDao.getWaitCloseOrders(orderBean);
		if (orderMerchantsBeans != null) {
			for (int i = 0; i < orderMerchantsBeans.size(); i++) {
				OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(i);
				int num = orderDao.closeOrderMerchants(orderMerchantsBean);
				if (num <= 0) {
					throw new AppException("结算失败!");
				}

				num = orderDao.updateMerchantsBalance(
						new MerchantsBalanceBean().setMerchants_id(orderMerchantsBean.getMerchants_id())
								.setWithdrawals_can_balance(orderMerchantsBean.getOrder_actual_price())
								.setBalance_id(orderMerchantsBean.getOrder_merchants_id()));
				if (num <= 0) {
					throw new AppException("可提现余额更新失败!");
				}

				num = orderDao.insertMerchantsBill(
						new MerchantsBillBean().setMerchants_id(orderMerchantsBean.getMerchants_id()).setBill_type("1")
								.setBill_price(orderMerchantsBean.getOrder_actual_price())
								.setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id() + "")
								.setOrder_merchants_no(orderMerchantsBean.getOrder_merchants_no()));
				if (num <= 0) {
					throw new AppException("账单入库失败");
				}
			}
		}
		return null;
	}

	@Override
	public Object timingCancelOrders(OrderBean orderBean) {
		// TODO Auto-generated method stub
		List<OrderBean> orderBeans = orderDao.getWaitCancelOrders(orderBean);
		if (orderBeans != null) {
			for (int i = 0; i < orderBeans.size(); i++) {
				OrderBean orderBean2 = orderBeans.get(i);
				cancelOrder(orderBean2);
			}
		}
		return 1;
	}

	@Override
	public Object getOrderRefundLogisticsDetails(OrderLogisticsBean orderLogisticsBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sendOrderRefund(OrderRefundBean orderRefundBean) {
		// TODO Auto-generated method stub
		int num = orderDao.sendOrderRefund(orderRefundBean);
		if (num <= 0) {
			throw new AppException("填写失败!");
		}
		return num;
	}

	@Override
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		return orderDao.getOrderLogisticsCompanys(orderLogisticsCompanyBean);
	}



	/**
	 * @author gxq
	 */
	public int inSertMemberBill(MemberBillBean memberBillBean) {
		int num = orderDao.inSertMemberBill(memberBillBean);
		if (num <= 0) {
			throw new AppException("明细记录失败");
		}
		return num;
	}

	public List<MemberBillBean> getMemberBills(MemberBillBean memberBillBean, PageBean pageBean) {

		return orderDao.getMemberBills(memberBillBean, pageBean);
	}

	/**
	 * 查看余额
	 * 
	 * @author gxq
	 * 
	 */
	public ShopMemberBean getMemberBalance(ShopMemberBean shopMemberBean) {
		int num = 0;
		ShopMemberBean shopMemberBean2 = orderDao.getMemberBalance(shopMemberBean);
		if (shopMemberBean2 == null) {
			num = orderDao.createMemberBalnace(shopMemberBean);
			if (num <= 0) {
				throw new AppException("创建失败");
			}
		}
		return shopMemberBean2;
	}

	/**
	 * 更新个人余额
	 * 
	 * @author gxq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberBalnace(ShopMemberBean shopMemberBean, MemberBillBean memberBillBean) {
		int num = 0;
		ShopMemberBean shopMemberBean2 = orderDao.getMemberBalance(shopMemberBean);
		if (shopMemberBean2 == null) {
			num = orderDao.createMemberBalnace(shopMemberBean);
			if (num <= 0) {
				throw new AppException("创建失败");
			}
		} else {
			num = orderDao.updateMemberBalnace(shopMemberBean);

			if (num <= 0) {
				throw new AppException("更新失败");
			}
		}
		num = orderDao.inSertMemberBill(memberBillBean);
		if (num <= 0) {
			throw new AppException("明细记录失败");
		}

		return num;
	}

	public Object getOrderLogisticsDetails(OrderLogisticsBean orderLogisticsBean) {
		// TODO Auto-generated method stub
		OrderLogisticsBean orderLogisticsBean2 = orderDao.getOrderLogistics(orderLogisticsBean);
		if (orderLogisticsBean2 != null) {
			OrderAddressBean orderAddressBean = orderDao
					.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderLogisticsBean2.getOrder_id()));
			orderLogisticsBean2.setOrderAddressBean(orderAddressBean);

			List<OrderLogisticsDetailBean> orderLogisticsDetailBeans = orderDao.getOrderLogisticsDetails(
					new OrderLogisticsDetailBean().setLogistics_no(orderLogisticsBean2.getLogistics_no()));

			orderLogisticsBean2.setOrderLogisticsDetailBeans(orderLogisticsDetailBeans);
		}
		return orderLogisticsBean2;
	}

	public Object getMemberCreditRefund(MemberCreditBillBean memberCreditBillBean) {
		return orderDao.getMemberCreditRefund(memberCreditBillBean);
	}

	public Object insertOrderCredit(OrderCreditBean orderCreditBean) {
		UUIDUtils uuidUtils = new UUIDUtils(1);
		String order_no = uuidUtils.nextId(false, 1) + "";

		double member_credit_balance = NumberUtils.Double(orderCreditBean.getMember_credit_balance());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", order_no);
		SortedMap<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(orderCreditBean.getPay_way())) {
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(member_credit_balance * 100) : 1);
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("wx凭证生成失败!");
			}
			orderCreditBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(orderCreditBean.getPay_way())) {
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(member_credit_balance, 2) : 0.01);
			map.put("alipay_app_id", alipay_app_id);
			map.put("notify_url", alipay_notify_url);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);

			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("alipay凭证生成失败!");
			}
			orderCreditBean.setPay_charge(result);
		}

		MemberCreditBillBean memberCreditBillBean = orderDao
				.getMemberCreditRefund(new MemberCreditBillBean().setMember_id(orderCreditBean.getMember_id()));
		if (NumberUtils.Double(orderCreditBean.getMember_credit_balance()) > NumberUtils
				.Double(memberCreditBillBean.getCredit_bill_price())) {
			throw new AppException("超过应还款");
		}

		int num = orderDao.insertOrderCredit(orderCreditBean.setOrder_no(order_no));
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		if ("wx".equals(orderCreditBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(orderCreditBean.getPay_way())) {
			return result;
		}

		return null;
	}

	public Object insertOrderRecharge(OrderRechargeBean orderRechargeBean) {
		UUIDUtils uuidUtils = new UUIDUtils(1);
		String out_trade_no = uuidUtils.nextId(false, 1) + "";

		double activity_give_price = 0;
		OrderRechargeActivityBean orderRechargeActivityBean = orderDao.getOrderRechargeActivity(
				new OrderRechargeActivityBean().setActivity_need_price(orderRechargeBean.getOrder_price()));
		if (orderRechargeActivityBean != null) {
			activity_give_price = NumberUtils.Double(orderRechargeActivityBean.getActivity_give_price());
		}

		double order_price = NumberUtils.Double(orderRechargeBean.getOrder_price());
		double member_balance = order_price;
		if (!is_give_voucher.equals("0")) {
			member_balance = activity_give_price + order_price;
		}
		// int total_fee = NumberUtils.KeepDecimal(member_balance * 100);

		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(orderRechargeBean.getMember_id())));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);
		SortedMap<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(orderRechargeBean.getPay_way())) {
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);// total_fee
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}

			orderRechargeBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(orderRechargeBean.getPay_way())) {
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price, 2) : 0.01);
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);

			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			orderRechargeBean.setPay_charge(result);
		} else if ("wx_pub".equals(orderRechargeBean.getPay_way())) {
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);
			map.put("wx_pub_appid", wx_pub_appid);
			map.put("wx_pub_appsecret", wx_pub_appsecret);
			map.put("wx_pub_partnerkey", wx_pub_partnerkey);
			map.put("wx_pub_mch_id", wx_pub_mch_id);
			map.put("wx_pub_openid", memberBean.getWeibo_open_id());
			map.put("wx_pub_notify_url", wx_pub_notify_url);
			Map<String, String> resultMap = PayUtils.wxPubPay(map);
			if (resultMap == null) {
				throw new AppException("支付凭证生成失败!");
			}
		} else if ("wx_lite".equals(orderRechargeBean.getPay_way())) {
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);
			map.put("wx_lite_appid", wx_lite_appid);
			map.put("wx_lite_appsecret", wx_lite_appsecret);
			map.put("wx_lite_partnerkey", wx_lite_partnerkey);
			map.put("wx_lite_mch_id", wx_lite_mch_id);
			map.put("wx_lite_openid", memberBean.getWeixin_lite_open_id());
			map.put("wx_lite_notify_url", wx_lite_notify_url);

			Map<String, String> resultMap = PayUtils.wxLitePay(map);
			if (resultMap == null) {
				throw new AppException("支付凭证生成失败!");
			}
		}

		int num = orderDao.insertOrderRecharge(orderRechargeBean.setOrder_no(out_trade_no)
				.setMember_balance(member_balance + "").setActivity_give_price(activity_give_price + ""));
		if (num <= 0) {
			throw new AppException("充值失败");
		}

		if ("wx".equals(orderRechargeBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(orderRechargeBean.getPay_way())) {
			return result;
		}
		return null;
	}

	/**
	 * 信用额度还款支付成功回调
	 * 
	 * @param orderCreditBean
	 * @return
	 */
	public Object payCreditCallback(OrderCreditBean orderCreditBean) {
		OrderCreditBean orderCreditBean2 = orderDao.getOrderCreditDetail(orderCreditBean);

		if (orderCreditBean2 == null) {
			throw new AppException("订单不存在");
		}
		if (!"1".equals(orderCreditBean2.getOrder_state())) {
			throw new AppException("非待付款订单");
		}

		int num = orderDao.payOrderCredit(new OrderCreditBean().setOrder_id(orderCreditBean2.getOrder_id())
				.setOut_trade_no(orderCreditBean.getOut_trade_no()));
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		ShopMemberBean shopMemberBean = orderDao
				.getMemberDetail(new ShopMemberBean().setMember_id(orderCreditBean2.getMember_id()));
		if (shopMemberBean == null) {
			throw new AppException("用户异常");
		}

		num = orderDao.updateMemberOrderCredit(new OrderCreditBean().setMember_id(orderCreditBean2.getMember_id())
				.setOrder_id(orderCreditBean2.getOrder_id()));
		if (num <= 0) {
			throw new AppException("信用额度更新失败");
		}

		num = orderDao.insertMemberCreditBillsV2(new OrderCreditBean().setMember_id(orderCreditBean2.getMember_id())
				.setOrder_id(orderCreditBean2.getOrder_id()));
		if (num <= 0) {
			throw new AppException("信用额度明细异常");
		}

		return num;
	}

	/**
	 * 获得充值活动列表
	 * 
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public Object getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean) {
		return orderDao.getOrderRechargeActivitys(orderRechargeActivityBean);
	}

	/**
	 * 支付成功回调
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public Object payRechargeCallback(OrderRechargeBean orderRechargeBean) {
		// 设置支付宝支付单号,按照此单号退款
		OrderRechargeBean orderRechargeBean2 = orderDao.getOrderRechargeDetail(orderRechargeBean);
		if (orderRechargeBean2 == null) {
			throw new AppException("订单不存在!");
		}

		if (!"1".equals(orderRechargeBean2.getOrder_state())) {
			throw new AppException("非代付款订单!");
		}

		int num = orderDao.payOrderRecharge(new OrderRechargeBean().setOrder_id(orderRechargeBean2.getOrder_id())
				.setOrder_no(orderRechargeBean.getOrder_no()).setOut_trade_no(orderRechargeBean.getOut_trade_no()));
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		ShopMemberBean shopMemberBean = orderDao
				.getMemberDetail(new ShopMemberBean().setMember_id(orderRechargeBean2.getMember_id()));
		if (shopMemberBean == null) {
			num = orderDao.insertMemberOrderRecharge(new OrderRechargeBean()
					.setOrder_id(orderRechargeBean2.getOrder_id()).setMember_id(orderRechargeBean2.getMember_id()));
			if (num <= 0) {
				throw new AppException("余额更新失败!");
			}
		} else {
			num = orderDao.updateMemberOrderRecharge(new OrderRechargeBean()
					.setOrder_id(orderRechargeBean2.getOrder_id()).setMember_id(orderRechargeBean2.getMember_id()));
			if (num <= 0) {
				throw new AppException("余额更新失败");
			}
		}

		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(orderRechargeBean2.getMember_id())));

		num = orderDao.insertMemberRechargeBills(new OrderRechargeBean().setOrder_id(orderRechargeBean2.getOrder_id())
				.setMember_id(memberBean.getMember_id() + "").setMember_account(memberBean.getMember_account()));
		if (num <= 0) {
			throw new AppException("账单明细异常");
		}

		if (is_give_voucher.equals("0")) {
			if (NumberUtils.Integer(orderRechargeBean2.getActivity_give_price()) > 0) {
				num = orderDao.insertMemberVoucher(new MemberVoucherBean()
						.setOrder_merchants_id(orderRechargeBean2.getOrder_id() + "")
						.setOrder_merchants_no(orderRechargeBean2.getOrder_no())
						.setMember_id(memberBean.getMember_id() + "").setMember_account(memberBean.getMember_account())
						.setVoucher_price(orderRechargeBean2.getActivity_give_price()));
				if (num <= 0) {
					throw new AppException("添加代金券失败");
				}
			}

			num = orderDao.insertMemberIntegral(new MemberIntegralBean().setMember_id(memberBean.getMember_id() + "")
					.setIntegral_type("4").setIntegral_value(orderRechargeBean2.getActivity_give_price())
					.setOrder_id(orderRechargeBean2.getOrder_id() + "").setOrder_no(orderRechargeBean2.getOrder_no()));
			if (num <= 0) {
				throw new AppException("代金券明细入库失败!");
			}
		}

		return num;
	}

	public Object getMemberDetail(ShopMemberBean shopMemberBean) {
		// TODO Auto-generated method stub
		ShopMemberBean shopMemberBean2 = orderDao.getMemberDetail(shopMemberBean);
		if (shopMemberBean2 == null) {
			shopMemberBean2 = new ShopMemberBean();
		}
		return shopMemberBean2;
	}

	public int insertMemberCredit(ShopMemberBean shopMemberBean) {
		int num = orderDao.insertMemberCredit(shopMemberBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}

		return num;
	}

	public int updateMemberCreditV2(ShopMemberBean shopMemberBean) {
		int num = orderDao.updateMemberCreditV2(shopMemberBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}

		return num;
	}

	public Object getMemberIntegrals(MemberIntegralBean memberIntegralBean, String type, PageBean pageBean) {
		// TODO Auto-generated method stub
		if ("month".equals(type)) {// 按月统计
			List<Map<String, Object>> monthMaps = orderDao.getMemberIntegralsByMonth(memberIntegralBean, pageBean);
			if (monthMaps != null) {
				for (int i = 0; i < monthMaps.size(); i++) {
					Map<String, Object> monthMap = monthMaps.get(i);

					List<Map<String, Object>> dayMaps = orderDao.getMemberIntegralsByDay(
							memberIntegralBean.setCreate_time(monthMap.get("create_time") + ""));
					if (dayMaps != null) {
						for (int j = 0; j < dayMaps.size(); j++) {
							Map<String, Object> dayMap = dayMaps.get(j);
							List<MemberIntegralBean> memberIntegralBeans = orderDao.getMemberIntegrals(
									memberIntegralBean.setCreate_time(dayMap.get("create_time") + ""));
							dayMap.put("memberIntegralBeans", memberIntegralBeans);
						}
					}

					monthMap.put("memberIntegralBeans", dayMaps);
				}
			}
			pageBean.setObject(monthMaps);
		} else if ("day".equals(type)) {// 按天统计
			List<Map<String, Object>> maps = orderDao.getMemberIntegralsByDay(memberIntegralBean, pageBean);
			if (maps != null) {
				for (int i = 0; i < maps.size(); i++) {
					Map<String, Object> map = maps.get(i);
					List<MemberIntegralBean> memberIntegralBeans = orderDao
							.getMemberIntegrals(memberIntegralBean.setCreate_time(map.get("create_time") + ""));
					map.put("memberIntegralBeans", memberIntegralBeans);
				}
			}
			pageBean.setObject(maps);
		} else {
			List<MemberIntegralBean> memberIntegralBeans = orderDao.getMemberIntegrals(memberIntegralBean, pageBean);
			pageBean.setObject(memberIntegralBeans);
		}

		return pageBean;
	}

	public Object getMemberCredits(MemberCreditBillBean memberCreditBillBean, String type, PageBean pageBean) {
		if ("month".equals(type)) {
			List<Map<String, Object>> monthMaps = orderDao.getMemberCreditsByMonth(memberCreditBillBean, pageBean);
			if (monthMaps != null) {
				for (int i = 0; i < monthMaps.size(); i++) {
					Map<String, Object> monthMap = monthMaps.get(i);
					List<Map<String, Object>> dayMaps = orderDao.getMemberCreditsByDay(
							memberCreditBillBean.setCreate_time(monthMap.get("create_time") + ""));
					if (dayMaps != null) {
						for (int j = 0; j < dayMaps.size(); j++) {
							Map<String, Object> dayMap = dayMaps.get(j);
							List<MemberCreditBillBean> memberCreditBillBeans = orderDao.getMemberCredits(
									memberCreditBillBean.setCreate_time(dayMap.get("create_time") + ""));
							dayMap.put("memberCreditBillBeans", memberCreditBillBeans);
						}
					}
					monthMap.put("memberCreditBillBeans", dayMaps);

				}
			}
			pageBean.setObject(monthMaps);

		} else if ("day".equals(type)) {
			List<Map<String, Object>> maps = orderDao.getMemberCreditsByDay(memberCreditBillBean, pageBean);
			if (maps != null) {
				for (int i = 0; i < maps.size(); i++) {
					Map<String, Object> map = maps.get(i);
					List<MemberCreditBillBean> memberCreditBillBeans = orderDao
							.getMemberCredits(memberCreditBillBean.setCreate_time(map.get("create_time") + ""));
					map.put("memberCreditBillBeans", memberCreditBillBeans);
				}
			}
			pageBean.setObject(maps);

		} else {
			List<MemberCreditBillBean> memberCreditBillBeans = orderDao.getMemberCredits(memberCreditBillBean,
					pageBean);
			pageBean.setObject(memberCreditBillBeans);
		}

		return pageBean;
	}

	public Object getMemberBills(MemberBillBean memberBillBean, String type, PageBean pageBean) {
		// TODO Auto-generated method stub
		if ("month".equals(type)) {// 按月统计
			List<Map<String, Object>> monthMaps = orderDao.getMemberBillsByMonth(memberBillBean, pageBean);
			if (monthMaps != null) {
				for (int i = 0; i < monthMaps.size(); i++) {
					Map<String, Object> monthMap = monthMaps.get(i);

					List<Map<String, Object>> dayMaps = orderDao
							.getMemberBillsByDay(memberBillBean.setCreate_time(monthMap.get("create_time") + ""));
					if (dayMaps != null) {
						for (int j = 0; j < dayMaps.size(); j++) {
							Map<String, Object> dayMap = dayMaps.get(j);
							List<MemberBillBean> memberBillBeans = orderDao
									.getMemberBills(memberBillBean.setCreate_time(dayMap.get("create_time") + ""));
							dayMap.put("memberBillBeans", memberBillBeans);
						}
					}

					monthMap.put("memberBillBeans", dayMaps);
				}
			}
			pageBean.setObject(monthMaps);
		} else if ("day".equals(type)) {// 按天统计
			List<Map<String, Object>> maps = orderDao.getMemberBillsByDay(memberBillBean, pageBean);
			if (maps != null) {
				for (int i = 0; i < maps.size(); i++) {
					Map<String, Object> map = maps.get(i);
					List<MemberBillBean> memberBillBeans = orderDao
							.getMemberBills(memberBillBean.setCreate_time(map.get("create_time") + ""));
					map.put("memberBillBeans", memberBillBeans);
				}
			}
			pageBean.setObject(maps);
		} else {
			List<MemberBillBean> memberBillBeans = orderDao.getMemberBills(memberBillBean, pageBean);
			pageBean.setObject(memberBillBeans);
		}

		return pageBean;
	}

	public Object getRefundOrderDetail(OrderRefundBean orderRefundBean) {
		// TODO Auto-generated method stub
		OrderRefundBean orderRefundBean2 = orderDao.getOrderRefundDetail(orderRefundBean);
		if (orderRefundBean2 != null) {
			OrderGoodsBean orderGoodsBean = orderDao.getOrderGoodsDetail(
					new OrderGoodsBean().setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
			orderRefundBean2.setOrderGoodsBean(orderGoodsBean);
		}
		return orderRefundBean2;
	}

	public Object getRefundOrders(OrderRefundBean orderRefundBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderRefundBean> orderRefundBeans = orderDao.getRefundOrders(orderRefundBean, pageBean);
		if (orderRefundBeans != null) {
			for (int i = 0; i < orderRefundBeans.size(); i++) {
				OrderRefundBean orderRefundBean2 = orderRefundBeans.get(i);
				OrderGoodsBean orderGoodsBean = orderDao.getOrderGoodsDetail(new OrderGoodsBean()
						.setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
				orderRefundBean2.setOrderGoodsBean(orderGoodsBean);
			}
		}
		return pageBean.setObject(orderRefundBeans);
	}

	public Object getOrderRefundReasons(OrderRefundReasonBean orderRefundReasonBean) {
		// TODO Auto-generated method stub
		return orderDao.getOrderRefundReasons(orderRefundReasonBean);
	}

	@Override
	public Object cancelRefundOrder(OrderRefundBean orderRefundBean) {
		// TODO Auto-generated method stub
		OrderRefundBean orderRefundBean2 = orderDao
				.getOrderRefundDetail(new OrderRefundBean().setMember_id(orderRefundBean.getMember_id())
						.setOrder_goods_id(orderRefundBean.getOrder_goods_id()).setRefund_state("wait_review"));
		if (orderRefundBean2 == null) {
			throw new AppException("此商品没有待审核退款申请");
		}

		OrderGoodsBean orderGoodsBean = orderDao.getOrderGoodsDetail(
				new OrderGoodsBean().setOrder_goods_id(NumberUtils.Integer(orderRefundBean.getOrder_goods_id())));
		if (orderGoodsBean == null) {
			throw new AppException("商品不存在");
		}

		int refund_count = NumberUtils.Integer(orderRefundBean2.getRefund_count());
		int refund_end_count = NumberUtils.Integer(orderGoodsBean.getRefund_count());

		double refund_price = NumberUtils.Double(orderRefundBean2.getRefund_price());

		int num = orderDao.cancelOrderRefund(new OrderRefundBean().setRefund_id(orderRefundBean2.getRefund_id()));
		if (num <= 0) {
			throw new AppException("申请退款失败!");
		}

		num = orderDao.refundOrderGoods(new OrderGoodsBean().setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
				.setRefund_count((refund_end_count - refund_count) + "")
				.setRefund_end_price((NumberUtils.Float(orderGoodsBean.getRefund_end_price()) - refund_price) + ""));
		if (num <= 0) {
			throw new AppException("商品更新失败!");
		}

		return num;
	}

	public Object refundOrder(OrderRefundBean orderRefundBean) {
		// TODO Auto-generated method stub
		OrderRefundBean orderRefundBean2 = orderDao.getOrderRefundDetail(new OrderRefundBean()
				.setMember_id(orderRefundBean.getMember_id()).setOrder_goods_id(orderRefundBean.getOrder_goods_id())
				.setRefund_state("wait_review,accept,refund_ing"));
		if (orderRefundBean2 != null) {
			throw new AppException("此商品正在退款审核中!");
		}

		OrderMerchantsBean orderMerchantsBean = orderDao.getOrderMerchantsDetail(new OrderMerchantsBean()
				.setOrder_merchants_id(NumberUtils.Integer(orderRefundBean.getOrder_merchants_id())));
		if (orderMerchantsBean == null) {
			throw new AppException("此订单不存在!");
		}

		if (!("wait_receive".equals(orderMerchantsBean.getOrder_state())
				|| "wait_assessment".equals(orderMerchantsBean.getOrder_state())
				|| "end".equals(orderMerchantsBean.getOrder_state()))) {
			throw new AppException("此订单不可申请退款!");
		}

		OrderGoodsBean orderGoodsBean = orderDao.getOrderGoodsDetail(
				new OrderGoodsBean().setOrder_goods_id(NumberUtils.Integer(orderRefundBean.getOrder_goods_id())));
		if (orderGoodsBean == null) {
			throw new AppException("商品不存在");
		}
		int refund_count = NumberUtils.Integer(orderRefundBean.getRefund_count());
		int refund_end_count = NumberUtils.Integer(orderGoodsBean.getRefund_count());
		int goods_num = NumberUtils.Integer(orderGoodsBean.getGoods_num());
		if (refund_count + refund_end_count > goods_num) {
			throw new AppException("退款数量大于购买数量了");
		}

		float refund_price = 0;
		if (refund_count + refund_end_count == goods_num) {// 最后一次 全退了 用总可退款金额
															// 减去已经退金额 防止除不尽的情况
			refund_price = NumberUtils.Float(orderGoodsBean.getRefund_price())
					- NumberUtils.Float(orderGoodsBean.getRefund_end_price());// 需要返回用户金钱
		} else {
			refund_price = NumberUtils.Float(orderGoodsBean.getRefund_price()) * refund_count / goods_num;// 需要返回用户金钱
		}

		if (refund_price <= 0) {
			throw new AppException("无可退款金额了!");
		}

		UUIDUtils uuidUtils = new UUIDUtils(1);
		String refund_no = uuidUtils.nextId(false, 1) + "";

		int num = orderDao.insertOrderRefund(orderRefundBean.setRefund_price(refund_price + "")
				.setSpecification_price(orderGoodsBean.getSpecification_price()).setRefund_no(refund_no)
				.setOrder_merchants_no(orderMerchantsBean.getOrder_merchants_no()).setRefund_state("wait_review"));
		if (num <= 0) {
			throw new AppException("申请退款失败!");
		}

		num = orderDao.refundOrderGoods(new OrderGoodsBean().setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
				.setRefund_count((refund_count + refund_end_count) + "")
				.setRefund_end_price((NumberUtils.Float(orderGoodsBean.getRefund_end_price()) + refund_price) + ""));
		if (num <= 0) {
			throw new AppException("商品更新失败!");
		}

		return num;
	}

	public Object assessmentOrder(OrderMerchantsBean orderMerchantsBean,
			List<OrderAssessmentBean> orderAssessmentBeans) {
		// TODO Auto-generated method stub

		if (orderAssessmentBeans == null || orderAssessmentBeans.size() <= 0) {
			throw new AppException("请先提交评价");
		}

		OrderMerchantsBean orderMerchantsBean2 = orderDao.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!"wait_assessment".equals(orderMerchantsBean2.getOrder_state())) {
			throw new AppException("非待评价订单!");
		}

		MemberBean memberBean = memberService.getMemberDetail(
				new MemberBean().setMember_id(NumberUtils.Integer(orderMerchantsBean2.getMember_id())));
		if (memberBean == null) {
			throw new AppException("用户不存在!");
		}

//		for (int i = 0; i < orderAssessmentBeans.size(); i++) {
//			orderAssessmentBeans.get(i).setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id() + "")
//					.setOrder_merchants_no(orderMerchantsBean2.getOrder_merchants_no())
//					.setMember_id(orderMerchantsBean2.getMember_id()).setMember_img(memberBean.getMember_img())
//					.setMember_nick_name(memberBean.getMember_nick_name());
//		}

		int num = orderDao.insertOrderAssessments(orderAssessmentBeans);
		if (num <= 0) {
			throw new AppException("评价入库失败");
		}

		num = orderDao.assessmentOrder(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("评价失败");
		}

		num = orderDao.assessmentOrderGoods(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("商品评价失败");
		}

		num = orderDao.assessmentOrderMerchants(orderMerchantsBean);

		return num;
	}

	public Object getOrderAssessments(OrderAssessmentBean orderAssessmentBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderAssessmentBean> orderAssessmentBeans = orderDao.getOrderAssessments(orderAssessmentBean, pageBean);
		
		return pageBean.setObject(orderAssessmentBeans);
	}

	public Object payGoodsCallback(OrderBean orderBean, String pay_password) {
		// TODO Auto-generated method stub
		int num = 0;
		List<OrderBean> orderBeans = orderDao.getOrderDetails(orderBean);
		for(OrderBean orderBean2 : orderBeans){
			if (orderBean2 == null) {
				throw new AppException("订单不存在!");
			}

			if (!"wait_pay".equals(orderBean2.getOrder_state())) {
				throw new AppException("非待付款订单!");
			}
			num = orderDao.payOrder(
					new OrderBean().setOrder_id(orderBean2.getOrder_id()).setMember_id(orderBean2.getMember_id()));
			if (num <= 0) {
				throw new AppException("付款失败!");
			}
			//商品的销量 以及后续修改
			GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(orderBean2.getGoods_id())));
			if(goodsBean == null){
				throw new AppException("商品不存在");
			}
			int count = NumberUtils.Integer(goodsBean.getGoods_order_num());
			count++;
			num = goodsDao.updateGoods(new GoodsBean().setGoods_order_num(count+"").setGoods_id(goodsBean.getGoods_id()));
			if(num <= 0){
				throw new AppException("商品销量更新失败");
			}
		}
		

//		num = orderDao.updateGoodsSales(new OrderBean().setOrder_id(orderBean2.getOrder_id()));
//		if (num <= 0) {
//			throw new AppException("商品销量更新失败!");
//		}
//
//		ShopMemberBean shopMemberBean=orderDao.getMemberDetail(new ShopMemberBean()
//				.setMember_id(orderBean2.getMember_id()));
//		if(shopMemberBean==null){
//			shopMemberBean=new ShopMemberBean()
//					.setMember_id(orderBean2.getMember_id());
//			num=shopMemberDao.insertShopMember(shopMemberBean);
//			if(num<=0){
//				throw new AppException("添加失败!");
//			}
//		}
		
		
		
		
//		MemberBean memberBean = memberService
//				.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(orderBean2.getMember_id())));
//
//		if (memberBean == null) {
//			throw new AppException("用户不存在!");
//		}
//
//		if(!"1".equals(memberBean.getIs_buy())){
//			memberService.updateMemberDetail(new MemberBean()
//					.setMember_id(memberBean.getMember_id())
//					.setIs_buy("1"));
//		}
		
//		if ("balance".equals(orderBean.getPay_way())) {
//
//			try {
//				pay_password = MD5Util.md5Encode(pay_password);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new AppException("加密失败");
//			}
//
//			if (!pay_password.equals(memberBean.getPay_password())) {
//				throw new AppException("支付密码错误");
//			}
//
//		
//
//			double member_balance = NumberUtils.Double(shopMemberBean.getMember_balance());// 用户余额
//			double order_price = NumberUtils.Double(orderBean2.getOrder_price());// 订单支付价格
//
//			if (order_price > member_balance) {
//				throw new AppException("余额不足");
//			}
//
//			num = orderDao.payBalanceOrder(
//					new OrderBean().setMember_id(orderBean2.getMember_id()).setOrder_id(orderBean2.getOrder_id()));
//			if (num <= 0) {
//				throw new AppException("余额支付失败");
//			}
//
//			if (is_accumulation.equals("0")) {
//				OrderRechargeActivityBean orderRechargeActivityBean = orderDao.getOrderRechargeActivityDetail();
//				if (orderRechargeActivityBean != null) {
//					num = orderDao.updateAccumulateConsume(new ShopMemberBean().setMember_id(orderBean2.getMember_id())
//							.setAccumulate_consume(order_price + ""));
//					if (num <= 0) {
//						throw new AppException("消费累加失败");
//					}
//
//					double accumulate_consume = order_price
//							+ NumberUtils.Double(shopMemberBean.getAccumulate_consume());
//
//					if (accumulate_consume >= NumberUtils.Double(orderRechargeActivityBean.getActivity_need_price())) {
//						num = orderDao.updateVoucherState(new MemberVoucherBean()
//								.setVoucher_id(NumberUtils.Integer(orderRechargeActivityBean.getVoucher_id())));
//						if (num <= 0) {
//							throw new AppException("代金券激活失败");
//						}
//
//						OrderRechargeActivityBean orderRechargeActivityBean2 = orderDao
//								.getOrderRechargeActivityDetail();
//
//						if (orderRechargeActivityBean2 == null) {
//							num = orderDao.resetAccumulateConsume(
//									new ShopMemberBean().setMember_id(orderBean2.getMember_id()));
//							if (num <= 0) {
//								throw new AppException("累积消费清零失败");
//							}
//						} else {
//							num = orderDao.updateAccumulateConsumeV2(
//									new ShopMemberBean().setMember_id(orderBean2.getMember_id())
//											.setAccumulate_consume(orderRechargeActivityBean.getActivity_need_price()));
//							if (num <= 0) {
//								throw new AppException("累积消费减少失败");
//							}
//						}
//
//						num = orderDao.updateMemberVoucher(new ShopMemberBean().setMember_id(orderBean2.getMember_id())
//								.setMember_integral(orderRechargeActivityBean.getActivity_give_price()));
//						if (num <= 0) {
//							throw new AppException("代金券入账失败");
//						}
//
//					}
//				}
//
//			}
//
//		} else if ("credit".equals(orderBean.getPay_way())) {
//			try {
//				pay_password = MD5Util.md5Encode(pay_password);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new AppException("加密失败!");
//			}
//
//			if (!pay_password.equals(memberBean.getPay_password())) {
//				throw new AppException("支付密码错误");
//			}
//
//		
//			double member_credit_balance = NumberUtils.Double(shopMemberBean.getMember_credit_balance());
//			double order_price = NumberUtils.Double(orderBean2.getOrder_price());
//			if (order_price > member_credit_balance) {
//				throw new AppException("信用额度不足");
//			}
//
//			num = orderDao.updateMemberCredit(
//					new OrderBean().setOrder_id(orderBean2.getOrder_id()).setMember_id(orderBean2.getMember_id()));
//			if (num <= 0) {
//				throw new AppException("信用额度支付失败");
//			}
//		}
//
//		if ("balance".equals(orderBean.getPay_way())) {
//			num = orderDao
//					.insertMemberBalanceBills(new MemberBillBean().setOrder_merchants_id(orderBean2.getOrder_id() + "")
//							.setMember_account(memberBean.getMember_account()));
//			if (num <= 0) {
//				throw new AppException("账单明细异常");
//			}
//		} else if ("credit".equals(orderBean.getPay_way())) {
//			num = orderDao
//					.insertMemberCreditBills(new MemberBillBean().setOrder_merchants_id(orderBean2.getOrder_id() + "")
//							.setMember_account(memberBean.getMember_account()));
//			if (num <= 0) {
//				throw new AppException("信用额度明细异常");
//			}
//
//			num = orderDao.insertMemberCreditBillsV3(new MemberCreditBillBean().setMember_id(orderBean2.getMember_id())
//					.setOrder_merchants_id(orderBean2.getOrder_id() + ""));
//			if (num <= 0) {
//				throw new AppException("信用额度明细异常");
//			}
//		} else {
//			num = orderDao.insertMemberBills(new MemberBillBean().setOrder_merchants_id(orderBean2.getOrder_id() + "")
//					.setMember_account(memberBean.getMember_account()));
//			if (num <= 0) {
//				throw new AppException("账单明细异常!");
//			}
//		}

//		double consume_price = orderDao
//				.getMemberConsume(new MemberBillBean().setMember_id(memberBean.getMember_id() + ""));
//		List<MemberLevelBean> memberLevelBeans = orderDao.getMemberLevels();
//		if (memberLevelBeans != null) {
//			for (int i = 0; i < memberLevelBeans.size(); i++) {
//				MemberLevelBean memberLevelBean = memberLevelBeans.get(i);
//				if (consume_price > NumberUtils.Double(memberLevelBean.getLevel_min_price())) {
//					num = orderDao.updateMember(new ShopMemberBean().setMember_id(memberBean.getMember_id() + "")
//							.setMember_level(memberLevelBean.getLevel_name()));
//					if(num <= 0) {
//						throw new AppException("修改失败");
//					}
//					break;
//				}
//
//			}
//		}

//		if (is_give_integral.equals("1")) {
//			num = orderDao.insertMemberIntegrals(new OrderBean().setOrder_id(orderBean2.getOrder_id()));
//
//			
//			num = orderDao.giveMemberIntegral(
//					new OrderBean().setOrder_id(orderBean2.getOrder_id()).setMember_id(orderBean2.getMember_id()));
//			if (num <= 0) {
//				throw new AppException("赠送积分失败");
//			}
//			
//		}

		return num;
	}

	@Override
	public int updateMemberBalanceOfOneYuan(String member_id, String order_price, String freight_total_price) {
		// TODO Auto-generated method stub
		int num = orderDao.updateMemberBalanceOfOneYuan(member_id, order_price, freight_total_price);
		if (num <= 0) {
			throw new AppException("余额支付失败");
		}
		return num;
	}

	public Object payRealOrder(OrderBean orderBean) {
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在!");
		}

		if (!"wait_pay".equals(orderBean2.getOrder_state())) {
			throw new AppException("非代付款订单!");
		}

		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(orderBean.getMember_id())));
		double order_price = NumberUtils.Double(orderBean2.getOrder_price());
		String out_trade_no = "g" + new UUIDUtils(0).nextId(false, 10) + "";// 商品支付单号
		orderBean.setOut_trade_no(out_trade_no);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);

		Map<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(orderBean.getPay_way())) {
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);// total_fee

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(orderBean.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price, 2) : 0.01);
			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean.setPay_charge(result);
		} else if ("wx_pub".equals(orderBean.getPay_way())) {
			map.put("total_fee", 1);// total_fee
			map.put("wx_pub_appid", wx_pub_appid);
			map.put("wx_pub_appsecret", wx_pub_appsecret);
			map.put("wx_pub_partnerkey", wx_pub_partnerkey);
			map.put("wx_pub_mch_id", wx_pub_mch_id);
			map.put("wx_pub_openid", StringUtils.isNull(memberBean.getWeixin_open_id())?memberBean.getWeixin_pub_open_id():memberBean.getWeixin_open_id());
			map.put("wx_pub_notify_url", wx_pub_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);// total_fee
			wxMap = PayUtils.wxPubPay(map);
			if (wxMap == null) {
				throw new AppException("支付凭证生成失败!");
			}
			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("wx_lite".equals(orderBean.getPay_way())) {
			map.put("total_fee", 1);// total_fee
			map.put("wx_lite_appid", wx_lite_appid);
			map.put("wx_lite_appsecret", wx_lite_appsecret);
			map.put("wx_lite_partnerkey", wx_lite_partnerkey);
			map.put("wx_lite_mch_id", wx_lite_mch_id);
			map.put("wx_lite_openid", memberBean.getWeixin_lite_open_id());
			map.put("wx_lite_notify_url", wx_lite_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);// total_fee
			wxMap = PayUtils.wxLitePay(map);
			if (wxMap == null) {
				throw new AppException("支付凭证生成失败!");
			}
			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		}

		int num = orderDao.updateOrder(orderBean);
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		num = orderDao.payRealOrderMerchants(
				new OrderMerchantsBean().setOrder_id(orderBean.getOrder_id() + "").setPay_way(orderBean.getPay_way()));

		if (num <= 0) {
			throw new AppException("支付失败");
		}

		if ("wx".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("wx_pub".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("wx_lite".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(orderBean.getPay_way())) {
			return result;
		}
		return null;
	}

	public Object cancelPayOrderMerchants(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDao.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!"wait_send".equals(orderMerchantsBean2.getOrder_state())) {
			throw new AppException("此订单不可取消订单!");
		}

		int num = orderDao.cancelPayOrderMerchants(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("取消失败!");
		}

		num = orderDao.cancelGoodsStock(
				new OrderMerchantsBean().setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id()));
		if (num <= 0) {
			throw new AppException("库存更新失败");
		}

		num = orderDao.cancelGoodsSales(
				new OrderMerchantsBean().setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id()));
		if (num <= 0) {
			throw new AppException("销量更新失败");
		}

		Double refund_price=NumberUtils.Double(orderMerchantsBean2.getOrder_actual_price());
		
		OrderBean orderBean = orderDao
				.getOrderDetail(new OrderBean().setOrder_id(NumberUtils.Integer(orderMerchantsBean2.getOrder_id())));
		
		Double order_price=NumberUtils.Double(orderBean.getOrder_price());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", orderBean.getOut_trade_no());
		map.put("refund_no", NumberUtils.createRandom(false, 19));
		if ("wx".equals(orderMerchantsBean2.getPay_way())) {
			map.put("path", img_path + "apiclient_cert.p12");
			map.put("total_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(refund_price*100):1);
			map.put("refund_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(order_price*100):1);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);
			Map<String, Object> resultMap = PayUtils.wxAppRefund(map);
			if ("error".equals(resultMap.get("status"))) {
				throw new AppException(resultMap.get("error") + "");
			}
		}else if ("wx_pub".equals(orderMerchantsBean.getPay_way())) {
			map.put("path", img_path + "apiclient_cert.p12");
			map.put("refund_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(refund_price*100):1);
			map.put("total_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(order_price*100):1);
			map.put("wx_appid", wx_pub_appid);
			map.put("wx_appsecret", wx_pub_appsecret);
			map.put("wx_partnerkey", wx_pub_partnerkey);
			map.put("wx_mch_id", wx_pub_mch_id);
			Map<String, Object> resultMap = PayUtils.wxAppRefund(map);
			if ("error".equals(resultMap.get("status"))) {
				throw new AppException(resultMap.get("error") + "");
			}
		} else if ("alipay".equals(orderMerchantsBean2.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("refund_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(refund_price,2):1);
			Map<String, Object> resultMap = PayUtils.alipayRefund(map);
			if ("error".equals(resultMap.get("status"))) {
				throw new AppException(resultMap.get("error") + "");
			}
		} else if ("credit".equals(orderMerchantsBean2.getPay_way())) {

			num = orderDao.updateMemberCreditV2(new ShopMemberBean().setMember_id(orderMerchantsBean2.getMember_id())
					.setMember_credit_balance(refund_price + ""));
			if (num <= 0) {
				throw new AppException("信用额度退款失败");
			}
		} else if ("balance".equals(orderMerchantsBean2.getPay_way())) {

			num = orderDao.updateMemberBalanceV2(new ShopMemberBean()
					.setMember_id(orderMerchantsBean2.getMember_id())
					.setMember_balance(refund_price+""));
			if (num <= 0) {
				throw new AppException("余额退款失败");
			}
		}
		
		return num;
	}

	public Object cancelOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!"wait_pay".equals(orderBean2.getOrder_state())) {
			throw new AppException("非代付款订单!");
		}

		int num = orderDao.cancelOrder(orderBean);
		if (num <= 0) {
			throw new AppException("取消失败!");
		}
//
//		num = orderDao.cancelOrderMerchants(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id() + "")
//				.setMember_id(orderBean.getMember_id()));
//		if (num <= 0) {
//			throw new AppException("取消失败");
//		}
//
//		num = orderDao.cancelGoodsStock(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id() + ""));
//		if (num <= 0) {
//			throw new AppException("库存更新失败" + orderBean2.getOrder_id());
//		}
//
//		if (orderBean2.getMember_coupon_id() != null && !"".equals(orderBean2.getMember_coupon_id())) {
//			num = shopCouponDao.updateShopMemberCouponState(new ShopMemberCouponBean()
//					.setCoupon_id(orderBean2.getMember_coupon_id()).setMember_coupon_state("1"));
//			if (num <= 0) {
//				throw new AppException("优惠券返还失败!");
//			}
//		}
//
//		if ("1".equals(orderBean2.getIs_deduction_integral())) {// 使用积分抵扣了
//			int member_integral = NumberUtils.Integer(orderBean2.getDeduction_integral_value());
//			if (member_integral > 0) {// 抵扣积分了
//				num = orderDao.cancelMemberIntegral(new ShopMemberBean().setMember_id(orderBean2.getMember_id())
//						.setMember_integral(member_integral + ""));
//				if (num <= 0) {
//					throw new AppException("积分更新失败");
//				}
//
//				num = orderDao.insertCancelMemberIntegrals(new OrderBean().setOrder_id(orderBean2.getOrder_id()));
//				if (num <= 0) {
//					throw new AppException("积分明细入库失败");
//				}
//			}
//		}
		return num;
	}

	public Object receiveOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDao.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}
		
		if (!("wait_receive".equals(orderMerchantsBean2.getOrder_state()) ||
				"wait_send".equals(orderMerchantsBean2.getOrder_state()))) {
			throw new AppException("此订单不可确认收货!");
		}

		int num = 0;
		if(is_assessment.equals("1")) {
			num = orderDao.receiveOrderV2(orderMerchantsBean);
		}else {
			num = orderDao.receiveOrder(orderMerchantsBean);
		}
		
		if (num <= 0) {
			throw new AppException("确认失败!");
		}

		return num;
	}

	public Object getOrderDetail(OrderBean orderBean) {
		// TODO Auto-generated method stub
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
//		OrderAddressBean orderAddressBean2 = orderDao
//				.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderBean2.getOrder_id() + ""));
//		orderBean2.setOrderAddressBean(orderAddressBean2);

//		if (orderBean2 != null) {
//			List<OrderMerchantsBean> orderMerchantsBeans = orderDao
//					.getOrderMerchantss(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id() + ""));
//			if (orderMerchantsBeans != null) {
//				for (int i = 0; i < orderMerchantsBeans.size(); i++) {
//					OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(i);
//
//					OrderAddressBean orderAddressBean = orderDao.getOrderAddressDetail(
//							new OrderAddressBean().setOrder_id(orderMerchantsBean.getOrder_id()));
//					orderMerchantsBean.setOrderAddressBean(orderAddressBean);
//
//					List<OrderGoodsBean> orderGoodsBeans = orderDao.getOrderGoodss(new OrderGoodsBean()
//							.setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id() + ""));
//					orderMerchantsBean.setOrderGoodsBeans(orderGoodsBeans);
//				}
//			}
//			orderBean2.setOrderMerchantsBeans(orderMerchantsBeans);
//		}
		if(orderBean2 == null ){
			throw new AppException("订单不存在");
		}
		if("wait_pay".equals(orderBean2.getOrder_state())){
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(orderBean2.getPay_end_time().substring(0, 19));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long unixTimestamp = date.getTime();
			long unixTimestamp2 = System.currentTimeMillis();
			long time_num = (unixTimestamp - unixTimestamp2) / 1000;
			orderBean2.setTime_num(String.valueOf(time_num));
		}
		
		return orderBean2;
	}

	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDao.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsBean2 != null) {
			OrderAddressBean orderAddressBean = orderDao
					.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderMerchantsBean2.getOrder_id()));
			orderMerchantsBean2.setOrderAddressBean(orderAddressBean);

			List<OrderGoodsBean> orderGoodsBeans = orderDao.getOrderGoodss(
					new OrderGoodsBean().setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id() + ""));
			orderMerchantsBean2.setOrderGoodsBeans(orderGoodsBeans);
		}
		return orderMerchantsBean2;
	}

	public Object getOrders(OrderBean orderBean, PageBean pageBean) {
		// TODO Auto-generated method stub

		List<OrderBean> orderBeans = orderDao.getOrders(orderBean, pageBean);
		return pageBean.setObject(orderBeans);
	}

	public Object insertOrder(OrderBean orderBean) {
		PercentBean percentBean = shopSettingDao.getPercentDetail(new PercentBean().setPercent_type("goods_order"));// 商品预约比例
		if(percentBean == null){
			throw new AppException("商品预约比例不存在!");
		}
		
		String order_no = new UUIDUtils(0).nextId(false, 10) + "";
		String order_state = "wait_pay";
		MerchantsBean merchantsBean = merchantsDao.getMerchantsDetail(new MerchantsBean()
				.setMerchants_id(Integer.valueOf(orderBean.getMerchants_id())));
		if(merchantsBean == null){
			throw new AppException("供应商不存在!");
		}
		GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean()
				.setGoods_id(Integer.valueOf(orderBean.getGoods_id())));
		if(goodsBean == null){
			throw new AppException("商品不存在!");
		}
		int goods_num = NumberUtils.Integer(orderBean.getGoods_num());
		if (goods_num != 1) {
			throw new AppException("限制购买数量为1!");
		}
		String member_coupon_id= "";
		String coupon_id = "";
		String coupon_name= "";
		String coupon_price= "0";
		double goods_percent = NumberUtils.Double(percentBean.getPercent_value()) / 100;
		//商品预约价格
		double goods_order_price = NumberUtils.KeepDecimal(goods_percent * NumberUtils.Double(goodsBean.getGoods_now_price()), 2);
		//商品到店再付价格
		double goods_arrive_price  = NumberUtils.Double(goodsBean.getGoods_now_price()) - goods_order_price;
		//订单实际支付价格
		double order_actual_price =NumberUtils.KeepDecimal(goods_percent * NumberUtils.Double(goodsBean.getGoods_now_price()), 2);
		
		//使用优惠券 通过用户优惠券id获取优惠信息
		if(!StringUtils.isNull(orderBean.getMember_coupon_id())){
			ShopMemberCouponBean shopMemberCouponBean = shopCouponDao.getShopMemberCouponDetail(new ShopMemberCouponBean().setMember_coupon_id(
					Integer.valueOf(orderBean.getMember_coupon_id())));
			if(shopMemberCouponBean == null){
				throw new AppException("未找到用户优惠券信息!");
			}
			int number =  shopCouponDao.updateShopMemberCouponState(new ShopMemberCouponBean().setMember_coupon_id(
					Integer.valueOf(orderBean.getMember_coupon_id())).setMember_coupon_state("2"));
			if(number <= 0 ){
				throw new AppException("修改优惠信息错误!");
			}
			//立减 直接减金额
			if("1".equals(shopMemberCouponBean.getCoupon_way())){
				coupon_price = shopMemberCouponBean.getCoupon_price();
				order_actual_price = order_actual_price - NumberUtils.Double(shopMemberCouponBean.getCoupon_price());
				if(order_actual_price <=0){
					order_actual_price = 1;
				}
			}else if("2".equals(shopMemberCouponBean.getCoupon_way())){//折扣 减订单折扣金额
				order_actual_price=( (NumberUtils.Double(shopMemberCouponBean.getPercent()) /100 ) * goods_order_price);
				coupon_price =String.valueOf(goods_order_price -order_actual_price);
				if(order_actual_price <=0){
					order_actual_price = 1;
				}
			}else{
				
			}
			coupon_id = shopMemberCouponBean.getCoupon_id();
			coupon_name = shopMemberCouponBean.getCoupon_name();
			member_coupon_id = orderBean.getMember_coupon_id();
		}
		
		
		int num = orderDao.insertOrder(orderBean
				.setMerchants_img(merchantsBean.getMerchants_img())
				.setMerchants_name(merchantsBean.getMerchants_name())
				.setGoods_img(goodsBean.getGoods_img())
				.setGoods_name(goodsBean.getGoods_name())
				.setGoods_price(goodsBean.getGoods_now_price())
				.setMember_coupon_id(member_coupon_id)
				.setCoupon_id(coupon_id)
				.setCoupon_name(coupon_name)
				.setCoupon_price(coupon_price)
				.setOrder_price(goodsBean.getGoods_now_price())
				.setOrder_actual_price(String.valueOf(order_actual_price))
				.setGoods_order_price(String.valueOf(goods_order_price))
				.setGoods_arrive_price(String.valueOf(goods_arrive_price))
				.setOrder_no(order_no)
				.setOrder_state(order_state));
		if(num <= 0){
			throw new AppException("确认订单失败!");
		}
		num = orderDao.insertGoodsEmploy(new MemberGoodsRecordBean()
				.setMember_id(orderBean.getMember_id())
				.setGoods_id(orderBean.getGoods_id()+""));
		if (num <= 0) {
			throw new AppException("添加购买记录失败!");
		}
		OrderBean orderBean2 = orderDao.getOrderDetail(new OrderBean().setOrder_id(orderBean.getOrder_id()));

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(orderBean2.getPay_end_time().substring(0, 19));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long unixTimestamp = date.getTime();
		long unixTimestamp2 = System.currentTimeMillis();
		long time_num = (unixTimestamp - unixTimestamp2) / 1000;
		orderBean2.setTime_num(String.valueOf(time_num));
		return orderBean2;
		// TODO Auto-generated method stub
//		ShopMemberBean shopMemberBean = orderDao
//				.getMemberDetail(new ShopMemberBean().setMember_id(orderBean.getMember_id()));
//
//		String credit_state = "0";
//		if (shopMemberBean != null) {
//			credit_state = shopMemberBean.getCredit_state();
//		}
//
//		String order_no = new UUIDUtils(0).nextId(false, 10) + "";
//		String order_state = "wait_pay";
//
//		int num = 0;
//
//		if ("1".equals(is_summit)) {
//			if (orderBean.getCar_ids() != null && !"".equals(orderBean.getCar_ids())) {
//				num = shopCarDao.deleteShopCars(
//						new ShopCarBean().setCar_ids(orderBean.getCar_ids()).setMember_id(orderBean.getMember_id()));
//			}
//			num = orderDao.insertOrder(orderBean.setOrder_no(order_no).setOrder_state(order_state));
//			if (num <= 0) {
//				throw new AppException("添加失败!");
//			}
//
//		}
//		OrderAddressBean orderAddressBean = insertOrderAddress(orderBean.getAddress_id(), orderBean.getOrder_id() + "","-1",
//				orderBean.getMember_id(), is_summit);
//
//		Map<String, Object> orderMap = insertOrderMerchants(orderBean.getOrderMerchantsBeans(), orderBean,
//				orderAddressBean.getAddress_city(), is_summit, credit_state);
//		double order_price = NumberUtils.Double(orderMap.get("order_price").toString());
//
//		OrderBean orderBean2 = new OrderBean();
//		orderBean2.setOrder_id(orderBean.getOrder_id()).setOrder_price(order_price + "");

//		allocationCouponPrice(orderBean.getOrderMerchantsBeans(), orderBean2, orderBean.getMember_coupon_id(),
//				is_summit, order_price);// 使用优惠券 分配优惠金额
//		allocationIntegral(orderBean, orderBean2, order_price, is_summit);// 积分计算

//		if ("1".equals(is_summit)) {
//			allocationRefundPrice(orderBean.getOrderMerchantsBeans());
//
//			num = orderDao.updateOrder(orderBean2);
//			if (num <= 0) {
//				throw new AppException("修改订单失败!");
//			}
//			orderMap.put("order_id", orderBean.getOrder_id() + "");
//			orderMap.put("order_price", NumberUtils.KeepDecimal(orderBean2.getOrder_price(),2));
//			return orderMap;
//		} else {
//			orderBean.setOrder_price(orderBean2.getOrder_price() + "").
//			setCoupon_price(orderBean2.getCoupon_price());
//			return orderBean;
//		}
	}

	public Object deleteOrderClose(OrderMerchantsBean orderMerchantsBean) {
		int num = orderDao.deleteOrderClose(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}

		return num;
	}

	public Object deleteOrderCancelWaitPay(OrderMerchantsBean orderMerchantsBean) {
		int num = orderDao.deleteOrderCancelWaitPay(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}

		return num;
	}

	/**
	 * 添加订单详情
	 * 
	 * @param orderDetailBeans
	 * @param orderBean
	 * @return
	 */
	public Map<String, Object> insertOrderMerchants(List<OrderMerchantsBean> orderMerchantsBeans, OrderBean orderBean,
			String city_names, String is_summit, String credit_state) {
		if (orderMerchantsBeans == null) {
			throw new AppException("未提交任何订单");
		}

		int num = 0;
		double order_price = 0;
		for (int i = 0; i < orderMerchantsBeans.size(); i++) {
			OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(i);
			String order_type = "goods";
			String order_merchants_no = new UUIDUtils(0).nextId(false, 10) + "";

			MerchantsBean merchantsBean = merchantsDao.getMerchantsDetail(
					new MerchantsBean().setMerchants_id(NumberUtils.Integer(orderMerchantsBean.getMerchants_id())));
			if (merchantsBean == null) {
				throw new AppException("商家不存在!");
			}
			orderMerchantsBean.setMerchants_name(merchantsBean.getMerchants_name());
			if ("1".equals(is_summit)) {
				num = orderDao
						.insertOrderMerchants(orderMerchantsBean.setMerchants_name(merchantsBean.getMerchants_name())
								.setMember_id(orderBean.getMember_id()).setOrder_id(orderBean.getOrder_id() + "")
								.setOrder_no(orderBean.getOrder_no()).setOrder_merchants_no(order_merchants_no)
								.setOrder_state(orderBean.getOrder_state()).setOrder_type(order_type));
				if (num <= 0) {
					throw new AppException("添加失败!");
				}
			}

			insertOrderInvoice(orderMerchantsBean, is_summit);// 添加发票

			Map<String, Object> goodsMap = insertOrderGoods(orderMerchantsBean.getOrderGoodsBeans(),
					orderMerchantsBean.getOrder_merchants_id() + "", orderBean.getOrder_id() + "", is_summit,
					city_names, credit_state,orderMerchantsBean.getMember_id());// 添加订单商品
			double goods_total_price = NumberUtils.Double(goodsMap.get("goods_total_price").toString());// 商品总价
//			double freight_price = goodsMap.get("freight_price") == null ? 0
//					: NumberUtils.Double(goodsMap.get("freight_price").toString());// 邮费
//			double reduce_price = goodsMap.get("reduce_price") == null ? 0
//					: NumberUtils.Double(goodsMap.get("reduce_price").toString());// 满减活动优惠金额

			double order_total_price = goods_total_price ;// 订单总价
			double order_actual_price = goods_total_price ;// 订单实际支付价格
																							// 要减去满减优惠金额

			// allocationRefundPrice(orderMerchantsBean.getOrderGoodsBeans(),
			// goods_total_price, order_actual_price);// 分配订单商品的可退款金额

			if ("1".equals(is_summit)) {
				num = orderDao.updateOrderMerchants(
						new OrderMerchantsBean().setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id())
								.setOrder_actual_price(order_actual_price + "")
								.setOrder_total_price(order_total_price + "")
								.setGoods_total_price(goods_total_price + ""));
				if (num <= 0) {
					throw new AppException("修改订单详情失败!");
				}
			}

			order_price += order_actual_price;
			orderMerchantsBean.setOrder_actual_price(order_actual_price + "");
			orderMerchantsBean.setOrder_total_price(order_total_price + "");
			orderMerchantsBean.setGoods_total_price(goods_total_price + "");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("order_price", order_price);
		return map;
	}

	/**
	 * 发票详情
	 * 
	 * @param invoice_id
	 * @param is_summit
	 */
	public void insertOrderInvoice(OrderMerchantsBean orderMerchantsBean, String is_summit) {
		if (orderMerchantsBean.getInvoice_id() != null && !"".equals(orderMerchantsBean.getInvoice_id())
				&& "1".equals(is_summit)) {// 选择发票了 并且是提交订单
			InvoiceBean invoiceBean = invoiceService.getInvoiceDetail(
					new InvoiceBean().setInvoice_id(NumberUtils.Integer(orderMerchantsBean.getInvoice_id())));
			if (invoiceBean == null) {
				throw new AppException("发票不存在!");
			}
			int num = orderDao.insertOrderInvoice(new OrderInvoiceBean().setOrder_id(orderMerchantsBean.getOrder_id())
					.setOrder_no(orderMerchantsBean.getOrder_no())
					.setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id() + "")
					.setOrder_merchants_no(orderMerchantsBean.getOrder_merchants_no())
					.setInvoice_type(invoiceBean.getInvoice_type()).setInvoice_no(invoiceBean.getInvoice_no())
					.setInvoice_name(invoiceBean.getInvoice_name()).setInvoice_id(invoiceBean.getInvoice_id() + "")
					.setInvoice_company_phone(invoiceBean.getInvoice_company_phone())
					.setInvoice_company_name(invoiceBean.getInvoice_company_name())
					.setInvoice_company_address(invoiceBean.getInvoice_company_address())
					.setInvoice_bank_no(invoiceBean.getInvoice_bank_no())
					.setInvoice_bank_name(invoiceBean.getInvoice_bank_name()));
			if (num <= 0) {
				throw new AppException("发票入库失败!");
			}
		}
	}

	/**
	 * 分配用户积分
	 * 
	 * @param orderBean1
	 * @param orderBean2
	 * @param order_total_price
	 *            订单未计算优惠券等 的实际总支付价格
	 * @param is_summit
	 */
	public void allocationIntegral(OrderBean orderBean1, OrderBean orderBean2, double order_total_price,
			String is_summit) {
		String is_deduction_integral = orderBean1.getIs_deduction_integral();

		double order_price = NumberUtils.Double(orderBean2.getOrder_price());
		PercentBean percentBean = shopSettingDao.getPercentDetail(new PercentBean().setPercent_type("order_integral"));// 订单抵扣金额最大比例(%)
		double order_integral_percent = NumberUtils.Double(percentBean.getPercent_value()) / 100;
		double deduction_max_price = order_price * order_integral_percent;// 抵扣的最大金额

		PercentBean deductionPercentBean = shopSettingDao
				.getPercentDetail(new PercentBean().setPercent_type("order_integral"));// 积分换算金额比例(x/1)
		double deduction_percent = NumberUtils.Integer(deductionPercentBean.getPercent_value());
		int deduction_max_value = (int) Math.floor(deduction_max_price * deduction_percent);// 抵扣的最大积分
																							// 向下取整

		ShopMemberBean shopMemberBean = orderDao
				.getMemberDetail(new ShopMemberBean().setMember_id(orderBean1.getMember_id()));
		int member_integral = 0;
		int deduction_actual_value = 0;// 抵扣的实际值
		if (shopMemberBean == null) {
			orderBean2.setIs_deduction_integral("0");
			orderBean2.setDeduction_integral_price("0");
			orderBean2.setDeduction_integral_value("0");

			orderBean1.setIs_deduction_integral("0");
			orderBean1.setDeduction_integral_price("0");
			orderBean1.setDeduction_integral_value("0");
		} else {
			member_integral = NumberUtils.Integer(shopMemberBean.getMember_integral());
			if (member_integral >= deduction_max_value) {// 用户积分大于等于最大抵扣金额
															// 则抵扣的就是最大的积分值
				deduction_actual_value = deduction_max_value;
				member_integral = member_integral - deduction_max_value;
			} else {
				deduction_actual_value = member_integral;
				member_integral = 0;
			}
			double deduction_integral_price = deduction_actual_value / deduction_percent;// 抵扣的金额

			List<OrderMerchantsBean> orderMerchantsBeans = orderBean1.getOrderMerchantsBeans();
			double integral_total_price = 0;
			int integral_total_vaue = 0;
			for (int i = 0; i < orderMerchantsBeans.size(); i++) {
				OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(i);
				double order_actual_price = NumberUtils.Double(orderMerchantsBean.getOrder_actual_price());
				double order_deduction_integral_price = 0;// 此商家订单抵扣积分金额
				int order_deduction_actual_value = 0;// 此商家订单抵扣积分值
				if (i == orderMerchantsBeans.size() - 1) {
					order_deduction_integral_price = deduction_integral_price - integral_total_price;
					order_deduction_actual_value = deduction_actual_value - integral_total_vaue;
				} else {
					order_deduction_integral_price = deduction_integral_price * order_actual_price / order_total_price;
					order_deduction_actual_value = (int) Math
							.floor(deduction_actual_value * order_actual_price / order_total_price);

					integral_total_price += order_deduction_integral_price;
					integral_total_vaue += order_deduction_actual_value;
				}
				if ("1".equals(is_deduction_integral)) {// 用户选择了抵扣积分 才真正的计算订单金额
														// 否者只是计算可用积分值
					order_actual_price -= order_deduction_integral_price;
					orderMerchantsBean.setOrder_actual_price(order_actual_price + "");

					if ("1".equals(is_summit)) {
						int num = orderDao.updateOrderMerchants(new OrderMerchantsBean()
								.setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id())
								.setOrder_actual_price(order_actual_price + "")
								.setIs_deduction_integral(is_deduction_integral)
								.setDeduction_integral_price(order_deduction_integral_price + "")
								.setDeduction_integral_value(order_deduction_actual_value + ""));
						if (num <= 0) {
							throw new AppException("积分金额 更新失败");
						}

						if (order_deduction_actual_value > 0) {
							num = orderDao.insertMemberIntegral(new MemberIntegralBean()
									.setMember_id(shopMemberBean.getMember_id()).setIntegral_type("2")
									.setIntegral_value(order_deduction_actual_value + "")
									.setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id() + "")
									.setOrder_merchants_no(orderMerchantsBean.getOrder_merchants_no())
									.setOrder_id(orderBean1.getOrder_id() + "").setOrder_no(orderBean1.getOrder_no()));
							if (num <= 0) {
								throw new AppException("积分明细入库失败!");
							}
						}
					}

				}
				orderMerchantsBean.setIs_deduction_integral(is_deduction_integral);
				orderMerchantsBean.setDeduction_integral_price(deduction_integral_price + "");
				orderMerchantsBean.setDeduction_integral_value(deduction_actual_value + "");
			}

			if ("1".equals(is_deduction_integral)) {// 用户选择了抵扣积分 才真正的计算订单金额
													// 否者只是计算可用积分值
				order_price -= deduction_integral_price;
				orderBean2.setOrder_price(order_price + "");
				// 此处不去更新订单金额 上一个方法insertOrder更新

				int num = orderDao.updateMember(new ShopMemberBean().setMember_id(shopMemberBean.getMember_id())
						.setMember_integral(member_integral + ""));
				if (num <= 0) {
					throw new AppException("用户积分更新失败");
				}
			}
			orderBean2.setIs_deduction_integral(is_deduction_integral);
			orderBean2.setDeduction_integral_price(deduction_integral_price + "");
			orderBean2.setDeduction_integral_value(deduction_actual_value + "");

			orderBean1.setIs_deduction_integral(is_deduction_integral);
			orderBean1.setDeduction_integral_price(deduction_integral_price + "");
			orderBean1.setDeduction_integral_value(deduction_actual_value + "");
		}

	}


	/**
	 * 分配订单商品的可退款金额
	 * 
	 * @param orderGoodsBean
	 * @return
	 */
	public int allocationRefundPrice(List<OrderMerchantsBean> orderMerchantsBeans) {
		int num = 0;
		for (int j = 0; j < orderMerchantsBeans.size(); j++) {
			OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(j);
			List<OrderGoodsBean> orderGoodsBeans = orderMerchantsBean.getOrderGoodsBeans();

			double order_actual_price = NumberUtils.Double(orderMerchantsBean.getOrder_actual_price());
			double goods_total_price = NumberUtils.Double(orderMerchantsBean.getGoods_total_price());

			double refund_total_price = 0;
			for (int i = 0; i < orderGoodsBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(i);

				double refund_price = order_actual_price * NumberUtils.Integer(orderGoodsBean.getGoods_num())
						* NumberUtils.Double(orderGoodsBean.getSpecification_price()) / goods_total_price;
				if (i == orderGoodsBeans.size() - 1) {// 最后一个分配的时候 要用总付款金额
														// 减去之前已分配的
														// 防止除不尽
					refund_price = order_actual_price - refund_total_price;
				} else {
					refund_price = NumberUtils.KeepDecimal(
							order_actual_price * NumberUtils.Integer(orderGoodsBean.getGoods_num())
									* NumberUtils.Double(orderGoodsBean.getSpecification_price()) / goods_total_price,
							2);
				}
				refund_total_price += refund_price;
				num = orderDao.updateOrderGoods(new OrderGoodsBean()
						.setOrder_goods_id(orderGoodsBean.getOrder_goods_id()).setRefund_price(refund_price + ""));
			}
		}
		return num;
	}

	/**
	 * 添加订单商品
	 * 
	 * @param orderGoodsBeans
	 * @param order_detail_id
	 * @return
	 */
	public Map<String, Object> insertOrderGoods(List<OrderGoodsBean> orderGoodsBeans, String order_merchants_id,
			String order_id, String is_summit, String city_names, String credit_state, String member_id) {
		if (orderGoodsBeans == null || orderGoodsBeans.size() <= 0) {
			throw new AppException("未选择购买商品!");
		}

		int num = 0;
		float goods_total_price = 0;

		for (int j = 0; j < orderGoodsBeans.size(); j++) {
			OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);
			GoodsBean goodsBean = goodsDao
					.getGoodsDetail(new GoodsBean().setGoods_id(NumberUtils.Integer(orderGoodsBean.getGoods_id())));
			if (goodsBean == null) {
				throw new AppException("商品不存在!");
			}

//			GoodsSpecificationBean goodsSpecificationBean = goodsDao
//					.getGoodsSpecificationDetail(new GoodsSpecificationBean()
//							.setSpecification_id(NumberUtils.Integer(orderGoodsBean.getSpecification_id())));
//			if (goodsSpecificationBean == null) {
//				throw new AppException("此规格商品不存在!");
//			}

			int goods_num = NumberUtils.Integer(orderGoodsBean.getGoods_num());
			if (goods_num <= 0) {
				throw new AppException("购买数量异常!");
			}
			
			if(NumberUtils.Integer(goodsBean.getGoods_stock())< goods_num) {
				throw new AppException(goodsBean.getGoods_name() + "库存异常!");
			}

//			if (NumberUtils.Integer(goodsSpecificationBean.getSpecification_stock()) < goods_num) {
//				throw new AppException(goodsBean.getGoods_name() + "库存异常!");
//			}

//			double goods_actual_price = "1".equals(credit_state)
//					? NumberUtils.Integer(orderGoodsBean.getGoods_num())
//							* NumberUtils.Float(goodsSpecificationBean.getSpecification_wholesale_price())// 会员的实际支付价格
//					: NumberUtils.Integer(orderGoodsBean.getGoods_num())
//							* NumberUtils.Float(goodsSpecificationBean.getSpecification_price());// 游客的实际支付价格
			double goods_actual_price = NumberUtils.Float(goodsBean.getGoods_now_price())
					* 0.1 * NumberUtils.Integer(orderGoodsBean.getGoods_num());
			
//			goods_actual_price = computeDescendingGoods(orderGoodsBean,
//					goodsSpecificationBean.getSpecification_id() + "", goods_actual_price, order_id, order_merchants_id,
//					is_summit);// 计算直降活动的活动价

			goods_total_price += goods_actual_price;// 所有商品的实际支付价格

			orderGoodsBean.setBrand_id(goodsBean.getBrand_id());
			orderGoodsBean.setBrand_name(goodsBean.getBrand_name());
			
			orderGoodsBean.setFreight_id(goodsBean.getFreight_id());
			orderGoodsBean.setGoods_weight(goodsBean.getGoods_weight());
			orderGoodsBean.setGoods_volume(goodsBean.getGoods_volume());

			orderGoodsBean.setGoods_actual_price(goods_actual_price + "");
			orderGoodsBean.setGoods_img(goodsBean.getGoods_img());
			orderGoodsBean.setGoods_name(goodsBean.getGoods_name());
			orderGoodsBean.setSpecification_img(goodsBean.getGoods_img());
			orderGoodsBean.setSpecification_price(goodsBean.getGoods_now_price());
			orderGoodsBean.setSpecification_stock(goodsBean.getGoods_stock());
			orderGoodsBean.setSpecification_wholesale_price(goodsBean.getGoods_wholesale_price());

			if ("1".equals(is_summit)) {
				num = orderDao.isGoodsEmploy(new MemberGoodsRecordBean()
						.setMember_id(member_id).setGoods_id(goodsBean.getGoods_id()+""));
				if (num == 0) {
					num = orderDao.insertGoodsEmploy(new MemberGoodsRecordBean()
							.setMember_id(member_id)
							.setGoods_id(goodsBean.getGoods_id()+""));
					if (num <= 0) {
						throw new AppException("添加购买记录失败!");
					}
				}
				
				num = orderDao.insertOrderGoods(
						orderGoodsBean.setOrder_merchants_id(order_merchants_id).setOrder_id(order_id));
				if (num <= 0) {
					throw new AppException("订单商品添加失败!");
				}

				num = goodsDao.updateGoodsStock(new GoodsBean().setGoods_id(goodsBean.getGoods_id())
						.setGoods_stock(orderGoodsBean.getGoods_num()));
				if (num <= 0) {
					throw new AppException("商品库存不足!");
				}

//				num = goodsDao.updateGoodsSpecificationStock(
//						new GoodsSpecificationBean().setSpecification_id(goodsSpecificationBean.getSpecification_id())
//								.setSpecification_stock(orderGoodsBean.getGoods_num()));
//				if (num <= 0) {
//					throw new AppException("规格库存不足!");
//				}
			}
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
//		computeGiveGoods(orderGoodsBeans, resultMap, order_id, order_merchants_id, is_summit);// 计算满赠活动
//		computeReduceGoods(orderGoodsBeans, resultMap, order_id, order_merchants_id, is_summit);// 计算满减活动
//		computeFreightGoods(orderGoodsBeans, resultMap, city_names, is_summit);// 计算邮费
		resultMap.put("goods_total_price", goods_total_price);
		return resultMap;
	}

	/**
	 * 计算满赠活动
	 */
	public void computeGiveGoods(List<OrderGoodsBean> orderGoodsBeans, Map<String, Object> resultMap, String order_id,
			String order_merchants_id, String is_summit) {
		String specification_ids = "";
		for (int j = 0; j < orderGoodsBeans.size(); j++) {
			specification_ids += orderGoodsBeans.get(j).getSpecification_id() + ",";
		}
		List<Map<String, Object>> giveMaps = orderDao
				.getGoodsGiveActivitys(new ActivityGoodsBean().setSpecification_id(specification_ids));
		if (giveMaps != null) {
			for (int j = 0; j < orderGoodsBeans.size(); j++) {
				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);
				for (int i = 0; i < giveMaps.size(); i++) {
					Map<String, Object> map = giveMaps.get(i);
					String specification_ids2 = map.get("specification_ids").toString();

					String[] values = specification_ids2.split(",");
					List<String> list = Arrays.asList(values);
					if (list.contains(orderGoodsBean.getSpecification_id())) {// 如果这个活动包含这个商品
																				// 就将该商品的价格计入进去
						double goods_all_price = NumberUtils.Double(map.get("goods_all_price").toString());
						double goods_actual_price = NumberUtils.Double(orderGoodsBean.getGoods_actual_price());

						map.put("goods_all_price", goods_all_price + goods_actual_price);
					}
				}

			}

			String activity_ids = "";
			for (int i = 0; i < giveMaps.size(); i++) {
				Map<String, Object> map = giveMaps.get(i);
				double give_full_price = NumberUtils.Double(map.get("give_full_price").toString());
				String give_type = map.get("give_type").toString();
				double goods_all_price = NumberUtils.Double(map.get("goods_all_price").toString());
				if (goods_all_price >= give_full_price) {// 商品总价 满足条件 则使用优惠活动
					if ("1".equals(give_type)) {// 赠送商品
						activity_ids += map.get("activity_id").toString() + ",";
					}
				}
			}
			if ("1".equals(is_summit) && activity_ids.length() > 0) {
				int num = orderDao.insertOrderActivityGives(new OrderActivityBean().setOrder_id(order_id)
						.setOrder_merchants_id(order_merchants_id).setActivity_id(activity_ids));
				if (num <= 0) {
					throw new AppException("满赠活动添加失败!");
				}

				num = orderDao.insertOrderActivityGoodss(new OrderActivityGoodsBean().setOrder_id(order_id)
						.setOrder_merchants_id(order_merchants_id).setActivity_id(activity_ids));
				if (num <= 0) {
					throw new AppException("满赠活动商品添加失败!");
				}
			}
		}
	}

	/**
	 * 计算邮费价格
	 */
	public void computeFreightGoods(List<OrderGoodsBean> orderGoodsBeans, Map<String, Object> resultMap,
			String city_names, String is_summit) {
		double freight_price = 0;// 所有商品 计算的邮费
		double freight_max_price = 0;// 多个商品 取最大的基础邮费
		for (int j = 0; j < orderGoodsBeans.size(); j++) {
			OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);
			int goods_num = NumberUtils.Integer(orderGoodsBean.getGoods_num());
			if (city_names != null) {// 防止还未选择地址
				Map<String, Object> freightMap = orderDao.getGoodsFreightDetail(
						new FreightCityBean().setFreight_id(orderGoodsBean.getFreight_id()).setCity_names(city_names));
				if (freightMap != null) {// 商品未选择邮费 或者 设置的邮费已被删除
					orderGoodsBean.setFreight_type(freightMap.get("freight_type").toString());
					orderGoodsBean.setFreight_way(freightMap.get("freight_way").toString());
					if ("1".equals(freightMap.get("freight_way").toString())) {// 买家承担运费
						double freight_range = NumberUtils.Double(freightMap.get("freight_range").toString());
						double freight_base_price = NumberUtils.Double(freightMap.get("freight_price").toString());
						double freight_add_range = NumberUtils.Double(freightMap.get("freight_add_range").toString());
						double freight_add_price = NumberUtils.Double(freightMap.get("freight_add_price").toString());
						double free_range = freightMap.get("free_range") == null ? -1
								: NumberUtils.Double(freightMap.get("free_range").toString());

						orderGoodsBean.setFree_range(free_range + "");
						orderGoodsBean.setFreight_range(freight_range + "");
						orderGoodsBean.setFreight_price(freight_base_price + "");
						orderGoodsBean.setFreight_add_range(freight_add_range + "");
						orderGoodsBean.setFreight_add_price(freight_add_price + "");

						double freight_num = 0;// 物流的总计算的 数量/重量/一级
						if ("1".equals(freightMap.get("freight_type").toString())) {// 按件
							freight_num = goods_num;// 等于商品购买数量
						} else if ("2".equals(freightMap.get("freight_type").toString())) {// 按重量
							freight_num = goods_num * NumberUtils.Double(orderGoodsBean.getGoods_weight());
						} else if ("3".equals(freightMap.get("freight_type").toString())) {// 按体积
							freight_num = goods_num * NumberUtils.Double(orderGoodsBean.getGoods_volume());
						}

						if (free_range == -1 || freight_num < free_range) {// 未设置该城市免邮
																			// 或者
																			// 不满足免邮条件
							if (freight_base_price > freight_price) {// 如果该商品的首件邮费高于其他商品
																		// 则替换最大基础邮费
								freight_max_price = freight_base_price;
							}

							if (freight_num > freight_range) {// 超出了首件数量范围
								int freight_coefficient = (int) Math
										.ceil((freight_num - freight_range) / freight_add_range);// 计算出
																									// 超出部分的倍数
																									// 向上取整
								freight_price += freight_coefficient * freight_add_price;
							}

						}
					}
					if ("1".equals(is_summit)) {
						int num = orderDao.updateOrderGoods(orderGoodsBean);
						if (num <= 0) {
							throw new AppException("邮费更新失败!");
						}
					}
				}
			}
		}

		freight_price += freight_max_price;

		resultMap.put("freight_price", freight_price);
	}

	/**
	 * 计算满减活动
	 */
	public void computeReduceGoods(List<OrderGoodsBean> orderGoodsBeans, Map<String, Object> resultMap, String order_id,
			String order_merchants_id, String is_summit) {
		String specification_ids = "";
		for (int j = 0; j < orderGoodsBeans.size(); j++) {
			specification_ids += orderGoodsBeans.get(j).getSpecification_id() + ",";
		}
		List<Map<String, Object>> reduceMaps = orderDao
				.getGoodsReduceActivitys(new ActivityGoodsBean().setSpecification_id(specification_ids));
		if (reduceMaps != null) {
			for (int j = 0; j < orderGoodsBeans.size(); j++) {
				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(j);
				for (int i = 0; i < reduceMaps.size(); i++) {
					Map<String, Object> map = reduceMaps.get(i);
					String specification_ids2 = map.get("specification_ids").toString();

					String[] values = specification_ids2.split(",");
					List<String> list = Arrays.asList(values);
					if (list.contains(orderGoodsBean.getSpecification_id())) {// 如果这个活动包含这个商品
																				// 就将该商品的价格计入进去
						double goods_all_price = NumberUtils.Double(map.get("goods_all_price").toString());
						double goods_actual_price = NumberUtils.Double(orderGoodsBean.getGoods_actual_price());

						map.put("goods_all_price", goods_all_price + goods_actual_price);
					}
				}

			}

			for (int i = 0; i < reduceMaps.size(); i++) {
				Map<String, Object> map = reduceMaps.get(i);
				double reduce_full_price = NumberUtils.Double(map.get("reduce_full_price").toString());
				double reduce_price = NumberUtils.Double(map.get("reduce_price").toString());
				double goods_all_price = NumberUtils.Double(map.get("goods_all_price").toString());
				if (goods_all_price >= reduce_full_price) {// 商品总价 满足条件 则使用优惠活动
					// goods_total_price-=reduce_price;
					resultMap.put("reduce_price", reduce_price);
					if ("1".equals(is_summit)) {
						int num = orderDao.insertOrderActivity(
								new OrderActivityBean().setOrder_id(order_id).setOrder_merchants_id(order_merchants_id)
										.setActivity_id(map.get("activity_id").toString())
										.setActivity_name(map.get("activity_name").toString()).setActivity_type("2")
										.setReduce_full_price(map.get("reduce_full_price").toString())
										.setReduce_price(map.get("reduce_price").toString()));
						if (num <= 0) {
							throw new AppException("满减活动添加失败");
						}
					}
					break;
				}
			}
		}
	}

	/**
	 * 计算直降活动的活动价
	 * 
	 * @param orderGoodsBean
	 * @param specification_id
	 * @return
	 */
	public double computeDescendingGoods(OrderGoodsBean orderGoodsBean, String specification_id, double goods_price,
			String order_id, String order_merchants_id, String is_summit) {
		Map<String, Object> descendingMap = orderDao
				.getGoodsDescendingActivity(new ActivityGoodsBean().setSpecification_id(specification_id));
		if (descendingMap != null) {// 有正在参加直降活动的活动
			double descending_price = NumberUtils.Float(descendingMap.get("descending_price").toString());// 直降金额

			double activity_price = goods_price - NumberUtils.Integer(orderGoodsBean.getGoods_num()) * descending_price;// 活动价
			if (activity_price <= 0) {
				throw new AppException("直降活动异常");
			}
			goods_price = activity_price;

			orderGoodsBean.setIs_descending("1");
			orderGoodsBean.setActivity_price(activity_price + "");

			if ("1".equals(is_summit)) {
				int num = orderDao.insertOrderActivity(
						new OrderActivityBean().setOrder_id(order_id).setOrder_merchants_id(order_merchants_id)
								.setActivity_id(descendingMap.get("activity_id").toString())
								.setActivity_name(descendingMap.get("activity_name").toString()).setActivity_type("3")
								.setActivity_price(activity_price + ""));
				if (num <= 0) {
					throw new AppException("直降活动添加失败");
				}
			}
		} else {
			orderGoodsBean.setIs_descending("0");
		}
		return goods_price;
	}

	/**
	 * 添加订单地址
	 * 
	 * @param orderAddressBean
	 */
	public OrderAddressBean insertOrderAddress(String address_id, String order_id,String changer_id, String member_id, String is_summit) {
		if ("1".equals(is_summit)) {
			if (address_id == null || "".equals(address_id)) {
				throw new AppException("请先选择地址!");
			}
		}

		OrderAddressBean orderAddressBean = new OrderAddressBean();

		AddressBean addressBean = addressService.getAddressDetail(
				new AddressBean().setMember_id(member_id).setAddress_id(NumberUtils.Integer(address_id)));
		if ("1".equals(is_summit) && addressBean == null) {
			throw new AppException("地址不存在!");
		}

		if (addressBean != null) {
			orderAddressBean = new OrderAddressBean().setOrder_id(order_id)
					.setChanger_id(changer_id)
					.setAddress_city(addressBean.getAddress_city()).setAddress_country(addressBean.getAddress_country())
					.setAddress_detailed(addressBean.getAddress_detailed()).setAddress_id(address_id)
					.setAddress_latitude(addressBean.getAddress_latitude())
					.setAddress_longitude(addressBean.getAddress_longitude())
					.setAddress_mobile(addressBean.getAddress_mobile()).setAddress_name(addressBean.getAddress_name())
					.setAddress_province(addressBean.getAddress_province())
					.setAddress_road(addressBean.getAddress_road())
					.setAddress_zip_code(addressBean.getAddress_zip_code());
		}

		if ("1".equals(is_summit)) {
			int num = orderDao.insertOrderAddress(orderAddressBean);
			if (num <= 0) {
				throw new AppException("添加订单地址异常!");
			}
		}
		return orderAddressBean;
	}

	public int updateOrderGoods(OrderGoodsBean orderGoodsBean, String update_type) {
		int num = 0;
		// TODO Auto-generated method stub
		if ("stock".equals(update_type)) {// 更新商品库存

			num = goodsDao
					.updateGoodsStock(new GoodsBean().setGoods_id(NumberUtils.Integer(orderGoodsBean.getGoods_id()))
							.setGoods_stock(orderGoodsBean.getGoods_num()));
			if (num <= 0) {
				throw new AppException("商品库存不足!");
			}

			num = goodsDao.updateGoodsSpecificationStock(new GoodsSpecificationBean()
					.setSpecification_id(NumberUtils.Integer(orderGoodsBean.getSpecification_id()))
					.setSpecification_stock(orderGoodsBean.getGoods_num()));
			if (num <= 0) {
				throw new AppException("规格库存不足!");
			}
		} else if ("sales".equals(update_type)) {// 更新商品销量
			num = goodsDao.updateGoodsSales(new GoodsBean().setGoods_total_sales(orderGoodsBean.getGoods_num())
					.setGoods_month_sales(orderGoodsBean.getGoods_num())
					.setGoods_day_sales(orderGoodsBean.getGoods_num())
					.setGoods_actual_sales(orderGoodsBean.getGoods_num())
					.setGoods_id(NumberUtils.Integer(orderGoodsBean.getGoods_id())));
			if (num <= 0) {
				throw new AppException("商品销量更新失败!");
			}
		}

		return num;
	}

	@Override
	public Map<String, Object> getGoodsFreightDetail(ZMAyOrderBean ayOrderBean, String city_names) {
		// TODO Auto-generated method stub
		Map<String, Object> freightMap = orderDao.getGoodsFreightDetail(
				new FreightCityBean().setFreight_id(ayOrderBean.getFreight_id()).setCity_names(city_names));
		return freightMap;
	}

	@Override
	public int OneYuaninsertMemberBalanceBills(MemberBillBean memberBillBean) {
		// TODO Auto-generated method stub
		int num = orderDao.OneYuaninsertMemberBalanceBills(memberBillBean);
		if (num <= 0) {
			throw new AppException("账单明细异常");
		}
		return num;
	}

	@Override
	public Object getOrderRedState(OrderBean orderBean) {
		// TODO Auto-generated method stub
		int num = orderDao.getActivityOrderRedState(orderBean);
		return num;
	}
	
	
	@Override
	public Object insertGoodsChanger(GoodsChangerBean goodsChangerBean, String is_summit) {
		// TODO Auto-generated method stub
		String changer_no = new UUIDUtils(0).nextId(false, 10) + "";
		int num = 0;

		List<GoodsChangerNoterBean> goodsChangerNoterBeans = goodsChangerBean.getGoodsChangerNoterBeans();
		if(goodsChangerNoterBeans == null || goodsChangerNoterBeans.size() == 0) {
			throw new AppException("请选择商品");
		}
		if("1".equals(is_summit)) {
			num = orderDao.insertGoodsChanger(goodsChangerBean.setChanger_no(changer_no));
			if(num <= 0) {
				throw new AppException("添加兑换记录失败");
			}
				
		}
		double changer_monnaie = 0;
		for (int i = 0; i < goodsChangerNoterBeans.size(); i++) {
			GoodsChangerNoterBean goodsChangerNoterBean2 = goodsChangerNoterBeans.get(i);
			GoodsBean goodsBean = goodsDao
					.getGoodsDetail(new GoodsBean().setGoods_id(NumberUtils.Integer(goodsChangerNoterBean2.getGoods_id())));
			if (goodsBean == null) {
				throw new AppException("商品不存在!");
			}
			if(!"2".equals(goodsBean.getGoods_type())) {
				throw new AppException("该商品不可兑换!");
			}
			
			int goods_num = NumberUtils.Integer(goodsChangerNoterBean2.getGoods_num());
			if (goods_num <= 0) {
				throw new AppException("购买数量异常!");
			}
			
			
			double goods_actual_monnaie = goods_num * 
					NumberUtils.Double(goodsBean.getGoods_monnaie());
			
			changer_monnaie += goods_actual_monnaie;
			
			goodsChangerNoterBean2.setGoods_name(goodsBean.getGoods_name())
				.setGoods_img(goodsBean.getGoods_img()).setGoods_monnaie(goodsBean.getGoods_monnaie())
				.setGoods_actual_monnaie(goods_actual_monnaie+"").setChanger_id(goodsChangerBean.getChanger_id());
			
			if("1".equals(is_summit)) {
				
				num = orderDao.insertGoodsChangerNoter(goodsChangerNoterBean2);
				if(num <= 0) {
					throw new AppException("添加兑换商品失败");
				}
			}
			
		}
		
		insertOrderAddress(goodsChangerBean.getAddress_id(),"-1", goodsChangerBean.getChanger_id() + "",
				goodsChangerBean.getMember_id(), is_summit);
		
		if("1".equals(is_summit)) {
			
			num = orderDao.updateGoodsChanger(goodsChangerBean
					.setChanger_monnaie(changer_monnaie+""));
			
			if(num <= 0) {
				throw new AppException("修改兑换记录失败");
			}

			Map<String, Object> changerMap = new HashMap<String, Object>();
			
			changerMap.put("changer_id", goodsChangerBean.getChanger_id());
			changerMap.put("changer_monnaie", goodsChangerBean.getChanger_monnaie());
			return changerMap;
		}else {
			
			return goodsChangerBean.setChanger_monnaie(changer_monnaie + "");
		}
		
	}
	@Override
	public Object insertGoodsChangerOrder(GoodsChangerBean goodsChangerBean) {
		// TODO Auto-generated method stub
		String changer_no = new UUIDUtils(0).nextId(false, 10) + "";
		int num = 0;

		List<GoodsChangerNoterBean> goodsChangerNoterBeans = goodsChangerBean.getGoodsChangerNoterBeans();
		if(goodsChangerNoterBeans == null || goodsChangerNoterBeans.size() == 0) {
			throw new AppException("请选择商品");
		}
		num = orderDao.insertGoodsChanger(goodsChangerBean.setChanger_no(changer_no));
		if(num <= 0) {
			throw new AppException("添加兑换记录失败");
		}
		double changer_monnaie = 0;
		for (int i = 0; i < goodsChangerNoterBeans.size(); i++) {
			GoodsChangerNoterBean goodsChangerNoterBean2 = goodsChangerNoterBeans.get(i);
			GoodsBean goodsBean = goodsDao
					.getGoodsDetail(new GoodsBean().setGoods_id(NumberUtils.Integer(goodsChangerNoterBean2.getGoods_id())));
			if (goodsBean == null) {
				throw new AppException("商品不存在!");
			}
			if(!"2".equals(goodsBean.getGoods_type())) {
				throw new AppException("该商品不可兑换!");
			}
			
			int goods_num = NumberUtils.Integer(goodsChangerNoterBean2.getGoods_num());
			if (goods_num <= 0) {
				throw new AppException("购买数量异常!");
			}
			
			
			double goods_actual_monnaie = goods_num * 
					NumberUtils.Double(goodsBean.getGoods_monnaie());
			
			changer_monnaie += goods_actual_monnaie;
			
			goodsChangerNoterBean2.setGoods_name(goodsBean.getGoods_name())
				.setGoods_img(goodsBean.getGoods_img()).setGoods_monnaie(goodsBean.getGoods_monnaie())
				.setGoods_actual_monnaie(goods_actual_monnaie+"").setChanger_id(goodsChangerBean.getChanger_id());
			num = orderDao.insertGoodsChangerNoter(goodsChangerNoterBean2);
			if(num <= 0) {
				throw new AppException("添加兑换商品失败");
			}
			
			
		}
		
		insertOrderAddress(goodsChangerBean.getAddress_id(),"-1", goodsChangerBean.getChanger_id() + "",
				goodsChangerBean.getMember_id(),"1");
		num = orderDao.updateGoodsChanger(goodsChangerBean
				.setChanger_monnaie(changer_monnaie+""));
		
		if(num <= 0) {
			throw new AppException("修改兑换记录失败");
		}
		MemberBean memberBean = memberService.getMemberDetail(new MemberBean()
				.setMember_id(NumberUtils.Integer(goodsChangerBean.getMember_id())));
		double member_stock = NumberUtils.Double(memberBean.getGoods_stock());
		double result_stock = changer_monnaie + member_stock ;
		double member_monnaie =  NumberUtils.Double(memberBean.getGoods_monnaie());
		double result_monnaie = member_monnaie - changer_monnaie;
		if(result_monnaie < 0 ){
			throw new AppException("用户颜值币不足兑换失败");
		}
		num = memberService.updateMemberDetail(new MemberBean()
				.setMember_id(NumberUtils.Integer(goodsChangerBean.getMember_id()))
				.setGoods_stock(String.valueOf(result_stock))
				.setGoods_monnaie(String.valueOf(result_monnaie)));
		if(num <= 0) {
			throw new AppException("修改用户颜值币失败");
		}

		Map<String, Object> changerMap = new HashMap<String, Object>();
		
		changerMap.put("changer_id", goodsChangerBean.getChanger_id());
		changerMap.put("changer_monnaie", goodsChangerBean.getChanger_monnaie());
		return changerMap;
	}
	@Override
	public Object isHaveBeenOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDao.getOrderMerchantsDetail(orderMerchantsBean);
		
		
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}
		
		if (!("wait_use".equals(orderMerchantsBean2.getOrder_state()))) {
			throw new AppException("此订单不可修改状态!");
		}

		int num = orderDao.isHaveBeenOrder(orderMerchantsBean);
		
		
		if (num <= 0) {
			throw new AppException("确认失败!");
		}

		return num;
	}
	@Override
	public Object getGoodsChangerNotes(GoodsChangerBean goodsChangerBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return orderDao.getGoodsChangerNotes(goodsChangerBean, pageBean);
	}
	@Override
	public Object payOrder(OrderBean orderBean) {
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在!");
		}
		if (!"wait_pay".equals(orderBean2.getOrder_state())) {
			throw new AppException("非待支付订单!");
		}
		double order_actual_price = NumberUtils.Double(orderBean2.getOrder_actual_price());
		String out_trade_no = "g" + new UUIDUtils(0).nextId(false, 10) + "";// 商品支付单号
		orderBean.setOut_trade_no(out_trade_no);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);

		Map<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(orderBean.getPay_way())) {
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price * 100) : 1);// total_fee

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}
			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(orderBean.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price, 2) : 0.01);
			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean.setPay_charge(result);
		}
		int num = orderDao.updateOrder(orderBean);
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		if ("wx".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(orderBean.getPay_way())) {
			return result;
		}
		return null;
	}
	@Override
	public Object deleteOrder(OrderBean orderBean) {
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在");
		}

		int num = orderDao.deleteOrder(orderBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}
	@Override
	public Object refundOrder2(OrderBean orderBean) {
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!"wait_use".equals(orderBean2.getOrder_state())) {
			throw new AppException("非待使用订单!");
		}

		int num = orderDao.refundOrder2(orderBean);
		if (num <= 0) {
			throw new AppException("退款失败!");
		}
		
		return num;
	}
	@Override
	public Object cancelRefundOrder2(OrderBean orderBean){
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!"wait_refund".equals(orderBean2.getOrder_state())) {
			throw new AppException("非待退款订单!");
		}

		int num = orderDao.cancelRefundOrder2(orderBean);
		if (num <= 0) {
			throw new AppException("取消退款失败!");
		}
		return num;
	}
	@Override
	public Object insertOrderAssessment(OrderAssessmentBean orderAssessmentBean) {

		int num = orderDao.insertOrderAssessment(orderAssessmentBean);
		if (num <= 0) {
			throw new AppException("评价失败!");
		}
		OrderBean orderBean = orderDao.getOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(orderAssessmentBean.getOrder_id())));
		if(orderBean == null){
			throw new AppException("订单不存在");
		}

		num = goodsDao.insertGoodsAssessment(new GoodsAssessmentBean().setGoods_id(orderBean.getGoods_id())
				.setMember_id(orderAssessmentBean.getMember_id())
				.setAssessment_desc(orderAssessmentBean.getAssessment_desc())
				.setAssessment_star(orderAssessmentBean.getAssessment_star())
				.setAssessment_video(orderAssessmentBean.getAssessment_video())
				.setAssessment_imgs(orderAssessmentBean.getAssessment_imgs()));
		if(num <= 0 ){
			throw new AppException("评价失败");
		}
		num = orderDao.updateOrder(new OrderBean().setOrder_id(orderBean.getOrder_id()).setOrder_state("have_commented"));
		if (num <= 0) {
			throw new AppException("评价失败!");
		}
		//修改商品的评论数量以及评论等级
		GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(orderBean.getGoods_id())));
		if(goodsBean == null){
			throw new AppException("商品不存在");
		}
		int count = NumberUtils.Integer(goodsBean.getAssessment_count());
		int star = NumberUtils.Integer(goodsBean.getGoods_comment_star());
		int total_star = count * star;
		total_star=total_star+NumberUtils.Integer(orderAssessmentBean.getAssessment_star());
		int count_2 = count+1;
		int avg_star = total_star/count_2;
		num = goodsDao.updateGoods(new GoodsBean().setAssessment_count(count_2+"").setGoods_comment_star(avg_star+"").setGoods_id(goodsBean.getGoods_id()));
		if(num <= 0){
			throw new AppException("评价失败");
		}
		
		return num;
	}

	@Override
	public Object insertSystemInformation(SystemInformationBean systemInformationBean) {
		int num =1;
		
		//修改订单的日记时间 以及日记次数
		OrderBean orderBean = orderDao.getOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(systemInformationBean.getOrder_id())));
		if(orderBean == null){
			throw new AppException("订单不存在");
		}
		int record_count = NumberUtils.Integer(orderBean.getRecord_count())+1;
		num = orderDao.updateOrder(new OrderBean().setOrder_id(orderBean.getOrder_id())
				.setLast_record_time("201808").setRecord_count(record_count+""));
		if(num <= 0){
			throw new AppException("发布失败");
		}
		//默认是日记的分类
		SystemInformationClassBean systemInformationClassBean = orderDao.getSystemInformationClass(new SystemInformationClassBean().setClass_code("record"));
		if(systemInformationClassBean != null){
			num = orderDao.insertSystemInformation(systemInformationBean.setSort(record_count+"").setClass_id(String.valueOf(systemInformationClassBean.getClass_id())));
			if(num <= 0){
				throw new AppException("发布失败");
			}
		}
		
		return num;
	}
	@Override
	public Object payShopCars(OrderBean orderBean) {
		//通过订单id找到订单
		String[] order_ids = orderBean.getOrder_ids().split(",");
		double order_prices = 0;
		String out_trade_no = "g" + new UUIDUtils(0).nextId(false, 10) + "";// 商品支付单号
		for(String order_id2 : order_ids){
			OrderBean orderBean2 = orderDao.getOrderDetail(new OrderBean().setOrder_id(Integer.valueOf(order_id2)));
			if (orderBean2 == null) {
				throw new AppException("订单不存在!");
			}
			if (!"wait_pay".equals(orderBean2.getOrder_state())) {
				throw new AppException("非待支付订单!");
			}
			order_prices = order_prices + NumberUtils.Double(orderBean2.getOrder_price());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);
		Map<String, String> wxMap = null;
		String result = "";
		OrderBean orderBean3 = new OrderBean().setOut_trade_no(out_trade_no).setPay_way(orderBean.getPay_way());
		if ("wx".equals(orderBean.getPay_way())) {
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_prices * 100) : 1);// total_fee

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}
			orderBean3.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(orderBean.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_prices, 2) : 0.01);
			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean3.setPay_charge(result);
		}
		for(String order_id2 : order_ids){
			int num = orderDao.updateOrder(orderBean3.setOrder_id(Integer.valueOf(order_id2)));
			if (num <= 0) {
				throw new AppException("支付失败!");
			}
		}
		if ("wx".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(orderBean.getPay_way())) {
			return result;
		}
		return null;
	}

}
