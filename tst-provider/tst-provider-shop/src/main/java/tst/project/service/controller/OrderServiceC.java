package tst.project.service.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.GoodsChangerNoterBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.MemberVoucherBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.OrderActivityBean;
import tst.project.bean.shop.OrderAddressBean;
import tst.project.bean.shop.OrderAssessmentBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderCreditBean;
import tst.project.bean.shop.OrderGoodsBean;
import tst.project.bean.shop.OrderLogisticsBean;
import tst.project.bean.shop.OrderLogisticsCompanyBean;
import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.bean.shop.OrderRechargeActivityBean;
import tst.project.bean.shop.OrderRefundBean;
import tst.project.bean.shop.OrderRefundReasonBean;
import tst.project.bean.shop.OrderSaleBean;
import tst.project.bean.shop.ShopCarBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.controller.IMemberServiceC;
import tst.project.controller.ISettingServiceC;
import tst.project.dao.controller.CreditGradesDaoC;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.controller.MerchantsDaoC;
import tst.project.dao.controller.OrderDaoC;
import tst.project.dao.controller.ShopCouponDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IOrderServiceC;
import tst.project.utils.NumberUtils;
import tst.project.utils.PayUtils;
import tst.project.utils.StringUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.WXUtils;

@Service
@Transactional
public class OrderServiceC implements IOrderServiceC {

	@Autowired
	OrderDaoC orderDaoC;

	@Autowired
	GoodsDaoC goodsDaoC;
	

	@Autowired
	ShopCouponDaoC shopCouponDaoC;

	@Autowired
	MerchantsDaoC merchantsDaoC;

	@Autowired
	CreditGradesDaoC creditGradesDaoC;

	@Autowired
	ISettingServiceC settingServiceC;
	
	@Autowired
	IMemberServiceC memberServiceC;

	@Value("${img_path}")
	private String img_path;

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

	@Value("${is_send_template}")
	private String is_send_template;
	
	@Value("${send_template}")
	private String send_template;
	
	
	
	@Value("${is_refund_template}")
	private String is_refund_template;
	
	
	@Value("${refund_accept_template}")
	private String refund_accept_template;
	
	@Value("${refund_refuse_template}")
	private String refund_refuse_template;
	
	@Value("${refund_end_template}")
	private String refund_end_template;
	
	@Override
	public Map<String, Object> getShopCarStatistics(ShopCarBean shopCarBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getShopCarStatistics(shopCarBean);
	}
	
	@Override
	public Map<String, Object> getRefundStatistics(OrderRefundBean orderRefundBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getRefundStatistics(orderRefundBean);
	}
	
	@Override
	public  Map<String,Object> getTotalOrderPrice(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getTotalOrderPrice(orderMerchantsBean);
	}
	
	@Override
	public Object commissionOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		int num=orderDaoC.commissionOrder(orderMerchantsBean);
		if(num<=0){
			throw new AppException("操作失败!");
		}
		return num;
	}
	
	@Override
	public Object getCommissionPrices(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getCommissionPrices(orderMerchantsBean);
	}
	
	@Override
	public Object getCommissionOrders(OrderMerchantsBean orderMerchantsBean,PageBean pageBean){
		List<OrderMerchantsBean> orderMerchantsBeans=orderDaoC.getCommissionOrders(orderMerchantsBean, pageBean);
		return pageBean.setObject(orderMerchantsBeans);
	}
	
	@Override
	public Object getSettlementPrices(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getSettlementPrices(orderMerchantsBean);
	}
	
	@Override
	public Object settlementOrders(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		int num=orderDaoC.settlementOrders(orderMerchantsBean);
		if(num<=0){
			throw new AppException("结算失败!");
		}
		return num;
	}
	
	public Object insertOrderCredit(OrderCreditBean orderCreditBean) {
		// TODO Auto-generated method stub
		// UUIDUtils uuidUtils = new UUIDUtils(1);
		// String order_no = uuidUtils.nextId(false, 1) + "";
		//
		// CreditGradesBean creditGradesBean2 =
		// creditGradesDaoC.getCreditGradesDetail(
		// new CreditGradesBean().setCredit_id(
		// NumberUtils.Integer(orderCreditBean.getCredit_id())));

		// int
		// num=orderDaoC.insertOrderCredit(orderCreditBean.setOrder_no(order_no)
		// .setMember_credit_balance(creditGradesBean2.getCredit_balance()));
		//
		// if(num<=0){
		// throw new AppException("赠送失败");
		// }
		int num = orderDaoC.updateMemberCredit(orderCreditBean);
		if (num <= 0) {
			throw new AppException("赠送失败");
		}

		// OrderCreditBean orderCreditBean2 =
		// orderDaoC.getOrderCreditDetail(orderCreditBean);

		// num = orderDaoC.insertMemberCreditBills(new OrderCreditBean()
		// .setOrder_id(orderCreditBean2.getOrder_id())
		// .setMember_id(orderCreditBean2.getMember_id()));
		// if (num <= 0) {
		// throw new AppException("信用额度明细异常");
		// }

		return num;
	}

	
	
	public Object refundOrder(OrderRefundBean orderRefundBean) {
		// TODO Auto-generated method stub
		OrderRefundBean orderRefundBean2 = orderDaoC.getOrderRefundDetail(orderRefundBean);
		if ("accept".equals(orderRefundBean.getRefund_state())
				&& !"wait_review".equals(orderRefundBean2.getRefund_state())) {
			throw new AppException("非待审核退款订单!");
		}

		if ("refuse".equals(orderRefundBean.getRefund_state())
				&& !"wait_review".equals(orderRefundBean2.getRefund_state())) {
			throw new AppException("非待审核退款订单!");
		}

		if ("end".equals(orderRefundBean.getRefund_state()) && !"accept".equals(orderRefundBean2.getRefund_state())) {
			throw new AppException("非已接受退款订单!");
		}

		int num = orderDaoC.updateOrderRefund(orderRefundBean);
		if (num <= 0) {
			throw new AppException("退款状态更新失败!");
		}

		OrderMerchantsBean orderMerchantsBean = orderDaoC.getOrderMerchantsDetail(new OrderMerchantsBean()
				.setOrder_merchants_id(NumberUtils.Integer(orderRefundBean.getOrder_merchants_id())));
		if (orderMerchantsBean == null) {
			throw new AppException("订单不存在");
		}

		if ("end".equals(orderRefundBean.getRefund_state())) {
			if ("close".equals(orderMerchantsBean.getOrder_state())) {
				throw new AppException("订单已结算!不可退款");
			}

			int count = orderDaoC.getEndRefundOrder(
					new OrderRefundBean().setOrder_merchants_id(orderRefundBean2.getOrder_merchants_id()));
			if (count == 0) {// 此订单已全部退款
				num = orderDaoC.refundOrder(new OrderMerchantsBean()
						.setOrder_merchants_id(NumberUtils.Integer(orderRefundBean2.getOrder_merchants_id())));
				if (num <= 0) {
					throw new AppException("订单退款失败!");
				}

			}

			num = orderDaoC.insertMemberBill(new MemberBillBean().setMember_id(orderRefundBean2.getMember_id())
					.setBill_price(orderRefundBean2.getRefund_price()).setBill_type("2")
					.setOrder_merchants_id(orderRefundBean2.getOrder_merchants_id())
					.setOrder_merchants_no(orderRefundBean2.getOrder_merchants_no())
					.setRefund_id(orderRefundBean2.getRefund_id() + "").setRefund_no(orderRefundBean2.getRefund_no()));
			if (num <= 0) {
				throw new AppException("退款明细入库失败!");
			}

			if("1".equals(orderRefundBean2.getRefund_type())||"3".equals(orderRefundBean2.getRefund_type())){
				Double refund_price=NumberUtils.Double(orderRefundBean2.getRefund_price());
				OrderBean orderBean = orderDaoC
						.getOrderDetail(new OrderBean().setOrder_id(NumberUtils.Integer(orderMerchantsBean.getOrder_id())));
				Double order_price=NumberUtils.Double(orderBean.getOrder_price());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("out_trade_no", orderBean.getOut_trade_no());
				map.put("refund_no", orderRefundBean2.getRefund_no());
				if ("wx".equals(orderMerchantsBean.getPay_way())) {
					map.put("path", img_path + "apiclient_cert.p12");
					map.put("refund_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(refund_price*100):1);
					map.put("total_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(order_price*100):1);
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
				} else if ("alipay".equals(orderMerchantsBean.getPay_way())) {
					map.put("alipay_app_id", alipay_app_id);
					map.put("alipay_private_key", alipay_private_key);
					map.put("alipay_public_key", alipay_public_key);
					map.put("refund_fee", "1".equals(is_real_pay)?NumberUtils.KeepDecimal(refund_price,2):1);
					Map<String, Object> resultMap = PayUtils.alipayRefund(map);
					if ("error".equals(resultMap.get("status"))) {
						throw new AppException(resultMap.get("error") + "");
					}
				} else if ("credit".equals(orderMerchantsBean.getPay_way())) {

					num = orderDaoC.updateMemberCreditV2(new ShopMemberBean().setMember_id(orderMerchantsBean.getMember_id())
							.setMember_credit_balance(refund_price + ""));
					if (num <= 0) {
						throw new AppException("信用额度退款失败");
					}
				} else if ("balance".equals(orderMerchantsBean.getPay_way())) {

					num = orderDaoC.updateMemberBalance(new ShopMemberBean()
							.setMember_id(orderMerchantsBean.getMember_id())
							.setMember_balance(refund_price+""));
					if (num <= 0) {
						throw new AppException("余额退款失败");
					}
				}
			}
			
			if("1".equals(is_refund_template)){
				MemberBean memberBean=memberServiceC.getMemberDetail(new MemberBean()
						.setMember_id(NumberUtils.Integer(orderRefundBean2.getMember_id())));
				
				OrderGoodsBean orderGoodsBean=orderDaoC.getOrderGoodsDetail(new OrderGoodsBean()
						.setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
				
				
				String access_token=WXUtils.getAccess_token(wx_pub_appid, wx_pub_appsecret);
				String result=WXUtils.sendTemplet(access_token,refund_end_template
						.replace("open_id", memberBean.getWeixin_open_id())
						.replace("refund_id", orderRefundBean2.getRefund_id()+"")
						.replace("refund_price", "¥"+orderRefundBean2.getRefund_price())
						.replace("goods_name",orderRefundBean2.getOrder_goods_id())
						.replace("refund_no", orderRefundBean2.getRefund_no())
						.replace("refund_state", "接受售后申请"))
						.replace("time", orderRefundBean2.getCreate_time());
			}
			

		} else if ("refuse".equals(orderRefundBean.getRefund_state())) {
			
			
	
			num = orderDaoC.refuseOrderGoods(
					new OrderGoodsBean().setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id()))
							.setRefund_count(orderRefundBean2.getRefund_count())
							.setRefund_end_price(orderRefundBean2.getRefund_price()));
			if (num <= 0) {
				throw new AppException("可退款金额更新失败!");
			}
			
			if("1".equals(is_refund_template)){
				MemberBean memberBean=memberServiceC.getMemberDetail(new MemberBean()
						.setMember_id(NumberUtils.Integer(orderRefundBean2.getMember_id())));
				
				OrderGoodsBean orderGoodsBean=orderDaoC.getOrderGoodsDetail(new OrderGoodsBean()
						.setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
				
				
				String access_token=WXUtils.getAccess_token(wx_pub_appid, wx_pub_appsecret);

				String result=WXUtils.sendTemplet(access_token,refund_refuse_template
						.replace("open_id", memberBean.getWeixin_open_id())
						.replace("refund_id", orderRefundBean2.getRefund_id()+"")
						.replace("goods_name",orderRefundBean2.getOrder_goods_id())
						.replace("refund_no", orderRefundBean2.getRefund_no())
						.replace("refund_state", "拒绝售后申请"))
						.replace("time", orderRefundBean2.getCreate_time());
			}
		} else if ("accept".equals(orderRefundBean.getRefund_state())) {
			if("1".equals(is_refund_template)){
				MemberBean memberBean=memberServiceC.getMemberDetail(new MemberBean()
						.setMember_id(NumberUtils.Integer(orderRefundBean2.getMember_id())));
				
				OrderGoodsBean orderGoodsBean=orderDaoC.getOrderGoodsDetail(new OrderGoodsBean()
						.setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
				
				
				String access_token=WXUtils.getAccess_token(wx_pub_appid, wx_pub_appsecret);
	
				String result=WXUtils.sendTemplet(access_token,refund_accept_template
						.replace("open_id", memberBean.getWeixin_open_id())
						.replace("refund_id", orderRefundBean2.getRefund_id()+"")
						.replace("goods_name",orderRefundBean2.getOrder_goods_id())
						.replace("refund_no", orderRefundBean2.getRefund_no())
						.replace("refund_state", "接受售后申请"))
						.replace("time", orderRefundBean2.getCreate_time());
			}
		}
		return num;
	}

	public Object getOrderCounts(OrderBean orderBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderCounts(orderBean);
	}

	public Object getOrderPrices(OrderBean orderBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderPrices(orderBean);
	}
	
	public Object getOrderTotalAmounts(OrderBean orderBean){
		String format="yyyy-MM-dd";
		String start_time=orderBean.getStart_time();
		String end_time=orderBean.getEnd_time();
		if(StringUtils.isNull(start_time)){
			end_time=TimeUtils.getTimeDayAfter(format, TimeUtils.getCurrentTime(format), 1);
			start_time=TimeUtils.getTimeDayAfter(format, end_time, -7);
			orderBean.setStart_time(start_time);
			orderBean.setEnd_time(end_time);
		}
		
		
		List<String> timeBeans=new ArrayList<String>();
		int count=0;
		try {
			count = TimeUtils.getDayCompareDate(end_time, start_time, format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < count; i++) {
			String time=TimeUtils.getTimeDayAfter(format, start_time, i);
			timeBeans.add(time);
		}
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start_time", start_time);
		map.put("end_time", end_time);
		map.put("timeBeans", timeBeans);
		map.put("merchants_id", orderBean.getMerchants_id());
		
		List<Map<String,Object>> maps=orderDaoC.getOrderTotalAmounts(map);
				
		return maps;
	}

	public Object getOrderMerchants(OrderMerchantsBean orderMerchantsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderMerchantsBean> orderMerchants = orderDaoC.getOrderMerchants(orderMerchantsBean, pageBean);
		if(orderMerchants!=null){
			for (int i = 0; i < orderMerchants.size(); i++) {
				OrderMerchantsBean orderMerchantsBean2=orderMerchants.get(i);
				List<OrderGoodsBean> orderGoods = orderDaoC.getOrderGoods(
						new OrderGoodsBean().setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id() + ""));
				orderMerchantsBean2.setOrderGoodsBeans(orderGoods);
			}
		}
		return pageBean.setObject(orderMerchants);
	}

	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsDetail = orderDaoC.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsDetail != null) {
			OrderAddressBean orderAddress = orderDaoC
					.getOrderAddress(new OrderAddressBean().setOrder_id(orderMerchantsDetail.getOrder_id()));
			orderMerchantsDetail.setOrderAddressBean(orderAddress);

			OrderLogisticsBean orderLogisticsBean = orderDaoC.getOrderLogisticsDetail(
					new OrderLogisticsBean().setOrder_merchants_id(orderMerchantsDetail.getOrder_merchants_id() + ""));
			orderMerchantsDetail.setOrderLogisticsBean(orderLogisticsBean);

			List<OrderGoodsBean> orderGoods = orderDaoC.getOrderGoods(
					new OrderGoodsBean().setOrder_merchants_id(orderMerchantsDetail.getOrder_merchants_id() + ""));
			orderMerchantsDetail.setOrderGoodsBeans(orderGoods);

			List<OrderActivityBean> orderActivityBeans = orderDaoC.getOrderActivity(
					new OrderActivityBean().setOrder_merchants_id(orderMerchantsDetail.getOrder_merchants_id() + ""));
			orderMerchantsDetail.setOrderActivityBeans(orderActivityBeans);
		}

		return orderMerchantsDetail;
	}

	public Object updateOrderMerchants(OrderMerchantsBean orderMerchantsBean) {
		int num = orderDaoC.updateOrderMerchants(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}

		return num;

	}

	public Object sendOrder(OrderLogisticsBean orderLogisticsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDaoC.getOrderMerchantsDetail(new OrderMerchantsBean()
				.setOrder_merchants_id(NumberUtils.Integer(orderLogisticsBean.getOrder_merchants_id())));
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!orderMerchantsBean2.getOrder_state().equals("wait_send")) {
			throw new AppException("该订单不能发货");
		}

		int num = 0;
		if (orderLogisticsBean.getLogistics_order_id() == 0) {
			num = orderDaoC.sendOrder(
					new OrderMerchantsBean().setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id()));
			if (num <= 0) {
				throw new AppException("发货失败");
			}


			num = orderDaoC.insertOrderLogistics(orderLogisticsBean.setOrder_id(orderMerchantsBean2.getOrder_id()));
			if (num <= 0) {
				throw new AppException("物流入库失败");
			}
		}
		
		
		if("1".equals(is_send_template)){
			OrderAddressBean orderAddressBean=orderDaoC
					.getOrderAddress(new OrderAddressBean().setOrder_id(orderMerchantsBean2.getOrder_id()));
			MemberBean memberBean=memberServiceC
					.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(orderMerchantsBean2.getMember_id())));
			
			String access_token=WXUtils.getAccess_token(wx_pub_appid, wx_pub_appsecret);
			
			String result=WXUtils.sendTemplet(access_token,send_template
					.replace("open_id", memberBean.getWeixin_open_id())
					.replace("order_merchants_id", orderMerchantsBean2.getOrder_merchants_id()+"")
					.replace("order_merchants_no", orderMerchantsBean2.getOrder_merchants_no())
					.replace("time", TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))
					.replace("logistics_name", orderLogisticsBean.getLogistics_name())
					.replace("logistics_no", orderLogisticsBean.getLogistics_no())
					.replace("address_name", orderAddressBean.getAddress_name()+" "
									+orderAddressBean.getAddress_mobile()+"   "
									+orderAddressBean.getAddress_province()+orderAddressBean.getAddress_city()+orderAddressBean.getAddress_country()+orderAddressBean.getAddress_detailed()));
		}
		return num;
	}

	public Object updateOrderLogistics(OrderLogisticsBean orderLogisticsBean) {
		// TODO Auto-generated method stub

		int num = orderDaoC.updateOrderLogistics(orderLogisticsBean);
		if (num <= 0) {
			throw new AppException("物流更新失败");
		}
		return num;
	}

	public Object getOrderRefundBeans(OrderRefundBean orderRefundBean, PageBean pageBean) {
		List<OrderRefundBean> orderRefundBeans = orderDaoC.getOrderRefunds(orderRefundBean, pageBean);

		return pageBean.setObject(orderRefundBeans);
	}

	

	public Object getOrderRefundReasonBeans(OrderRefundReasonBean orderRefundReasonBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderRefundReasonBean> orderRefundReasonBeans = orderDaoC.getOrderRefundReasonBeans(orderRefundReasonBean,
				pageBean);

		return pageBean.setObject(orderRefundReasonBeans);
	}

	public Object getOrderRefundReasonBeanDetail(OrderRefundReasonBean orderRefundReasonBean) {
		OrderRefundReasonBean orderRefundReasonBean2 = orderDaoC.getOrderRefundReasonBeanDetail(orderRefundReasonBean);

		return orderRefundReasonBean2;
	}

	public Object moveOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean) {
		// TODO Auto-generated method stub
		String sort = orderRefundReasonBean.getSort();

		OrderRefundReasonBean orderRefundReasonBean2 = orderDaoC.moveOrderRefundReasonBean(orderRefundReasonBean);
		if (orderRefundReasonBean2 == null) {
			throw new AppException("desc".equals(orderRefundReasonBean.getSort_type()) ? "已置顶" : "已到底");
		}
		int num = orderDaoC
				.updateOrderRefundReasonBean(orderRefundReasonBean.setSort(orderRefundReasonBean2.getSort()));
		if (num <= 0) {
			throw new AppException("移动失败");
		}
		num = orderDaoC.updateOrderRefundReasonBean(new OrderRefundReasonBean()
				.setRefund_reason_id(orderRefundReasonBean2.getRefund_reason_id()).setSort(sort));
		if (num <= 0) {
			throw new AppException("移动失败");
		}

		return "移动成功";

	}

	public Object insertOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean) {
		int num = orderDaoC.insertOrderRefundReasonBean(orderRefundReasonBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}

		return num;
	}

	public Object updateOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.updateOrderRefundReasonBean(orderRefundReasonBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	public Object deleteOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.deleteOrderRefundReasonBean(orderRefundReasonBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	public Object getOrderAssessmentBeanDetail(OrderAssessmentBean orderAssessmentBean) {
		// TODO Auto-generated method stub
		OrderAssessmentBean orderAssessmentBean2 = orderDaoC.getOrderAssessmentBeanDetail(orderAssessmentBean);
		if (orderAssessmentBean2 != null) {
			if (orderAssessmentBean2.getAssessment_type().equals("goods")) {
				GoodsBean goodsBean = goodsDaoC.getGoodsDetail(
						new GoodsBean().setGoods_id(NumberUtils.Integer(orderAssessmentBean2.getRelation_id())));
				orderAssessmentBean2.setGoods_img(goodsBean.getGoods_img()).setGoods_name(goodsBean.getGoods_name());
			} else if (orderAssessmentBean2.getAssessment_type().equals("merchants")) {
				MerchantsBean merchantsBean = merchantsDaoC.getMerchantsDetail(new MerchantsBean()
						.setMerchants_id(NumberUtils.Integer(orderAssessmentBean2.getRelation_id())));
				orderAssessmentBean2.setMerchants_img(merchantsBean.getMerchants_img())
						.setMerchants_name(merchantsBean.getMerchants_name());
			}
		}

		return orderAssessmentBean2;
	}

	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderLogisticsCompanyBean> orderLogisticsCompanyBeans = orderDaoC
				.getOrderLogisticsCompanys(orderLogisticsCompanyBean, pageBean);
		return pageBean.setObject(orderLogisticsCompanyBeans);
	}

	public Object getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		OrderLogisticsCompanyBean orderLogisticsCompanyBean2 = orderDaoC
				.getOrderLogisticsCompanyDetail(orderLogisticsCompanyBean);
		return orderLogisticsCompanyBean2;
	}

	public Object insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.insertOrderLogisticsCompany(orderLogisticsCompanyBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	public Object updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.updateOrderLogisticsCompany(orderLogisticsCompanyBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	public Object deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.deleteOrderLogisticsCompany(orderLogisticsCompanyBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	public Object getOrderRefunds(OrderRefundBean orderRefundBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderRefundBean> orderRefundBeans = orderDaoC.getOrderRefunds(orderRefundBean, pageBean);
		if(orderRefundBeans!=null){
			for (int i = 0; i < orderRefundBeans.size(); i++) {
				OrderRefundBean orderRefundBean2=orderRefundBeans.get(i);
				OrderGoodsBean orderGoodsBean = orderDaoC.getOrderRefundGoodsBeanDetail(
						new OrderGoodsBean().setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
				orderRefundBean2.setOrderGoodsBean(orderGoodsBean);
			}
		}
		return pageBean.setObject(orderRefundBeans);
	}
	public Object getOrderRefundDetail(OrderRefundBean orderRefundBean) {
		OrderRefundBean orderRefundBean2 = orderDaoC.getOrderRefundDetail(orderRefundBean);
		if (orderRefundBean2 != null) {
			OrderGoodsBean orderGoodsBean = orderDaoC.getOrderRefundGoodsBeanDetail(
					new OrderGoodsBean().setOrder_goods_id(NumberUtils.Integer(orderRefundBean2.getOrder_goods_id())));
			orderRefundBean2.setOrderGoodsBean(orderGoodsBean);

			OrderAddressBean orderAddressBean = orderDaoC
					.getOrderAddress(new OrderAddressBean().setOrder_id(orderGoodsBean.getOrder_id()));
			orderRefundBean2.setOrderAddressBean(orderAddressBean);
		}

		return orderRefundBean2;
	}

	public Object getOrderAssessments(OrderAssessmentBean orderAssessmentBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderAssessmentBean> orderAssessmentBeans = orderDaoC.getOrderAssessments(orderAssessmentBean, pageBean);
		return pageBean.setObject(orderAssessmentBeans);
	}

	public Object deleteOrderAssessment(OrderAssessmentBean orderAssessmentBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.deleteOrderAssessment(orderAssessmentBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}

		return num;
	}

	public Object getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderRechargeActivityBean> orderRechargeActivityBeans = orderDaoC
				.getOrderRechargeActivitys(orderRechargeActivityBean, pageBean);
		return pageBean.setObject(orderRechargeActivityBeans);
	}

	public Object getOrderRechargeActivityDetail(OrderRechargeActivityBean orderRechargeActivityBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderRechargeActivityDetail(orderRechargeActivityBean);
	}

	public Object insertOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.insertOrderRechargeActivity(orderRechargeActivityBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}

		return num;
	}

	public Object updateOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.updateOrderRechargeActivity(orderRechargeActivityBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}

		return num;
	}

	public Object deleteOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.deleteOrderRechargeActivity(orderRechargeActivityBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}

		return num;
	}

	@Override
	public Object getOrderSales(OrderSaleBean orderSaleBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderSaleBean> orderSaleBeans = orderDaoC.getOrderSales(orderSaleBean, pageBean);
		return pageBean.setObject(orderSaleBeans);
	}

	@Override
	public Object getMemberCredits(CreditGradesBean creditGradesBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<CreditGradesBean> creditGradesBeans = orderDaoC.getMemberCredits(creditGradesBean, pageBean);
		return pageBean.setObject(creditGradesBeans);
	}

	@Override
	public Object getOrderByGoodsSales(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(orderDaoC.getOrderByGoodsSales(goodsBean, pageBean));
	}

	@Override
	public List<Map> exportGoodsSales(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderByGoodsSales(goodsBean);
	}
	
	@Override
	public Object getGoodsAllSales(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getGoodsAllSales(goodsBean);
	}

	@Override
	public Object getMemberConsumeOrderBys(MemberBillBean memberBillBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBillBean> memberBillBeans = orderDaoC.getMemberConsumeOrderBys(memberBillBean, pageBean);

		return pageBean.setObject(memberBillBeans);
	}

	@Override
	public Object getGoodsConsumeCounts(OrderGoodsBean orderGoodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderGoodsBean> orderGoodsBeans = orderDaoC.getGoodsConsumeCounts(orderGoodsBean, pageBean);
		return pageBean.setObject(orderGoodsBeans);
	}

	@Override
	public Object getTerraceTotalSales(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDaoC.getTerraceTotalConsume(orderMerchantsBean);
		OrderGoodsBean orderGoodsBean = orderDaoC
				.getTerraceTotalSales(new OrderGoodsBean().setGoods_min_time(orderMerchantsBean.getGoods_min_time())
						.setGoods_max_time(orderMerchantsBean.getGoods_max_time()));

		return orderMerchantsBean2.setGoods_num(orderGoodsBean.getGoods_num());
	}

	@Override
	public Object getMerchantsTotalSales(OrderMerchantsBean orderMerchantsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderMerchantsBean> orderMerchantsBeans = orderDaoC.getMerchantsTotalConsumes(orderMerchantsBean,
				pageBean);

		List<OrderGoodsBean> orderGoodsBeans = orderDaoC
				.getMerchantsTotalSales(new OrderGoodsBean().setGoods_min_time(orderMerchantsBean.getGoods_min_time())
						.setGoods_max_time(orderMerchantsBean.getGoods_max_time()));
		if (orderMerchantsBeans != null && orderGoodsBeans != null) {
			for (int i = 0; i < orderMerchantsBeans.size(); i++) {
				OrderMerchantsBean orderMerchantsBean2 = orderMerchantsBeans.get(i);

				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(i);
				MerchantsBean merchantsBean = merchantsDaoC.getMerchantsDetail(new MerchantsBean()
						.setMerchants_id(NumberUtils.Integer(orderMerchantsBean2.getMerchants_id())));
				if (merchantsBean == null) {
					throw new AppException("商家不存在");
				}
				orderMerchantsBean2.setMerchants_name(merchantsBean.getMerchants_name());
				orderMerchantsBean2.setGoods_num(orderGoodsBean.getGoods_num());
			}
		}
		return pageBean.setObject(orderMerchantsBeans);
	}

	@Override
	public Object getMerchantsTotalSaleDetail(OrderMerchantsBean orderMerchantsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderMerchantsBean> orderMerchantsBeans = orderDaoC.getMerchantsTotalSaleDetail(orderMerchantsBean,
				pageBean);

		return pageBean.setObject(orderMerchantsBeans);
	}

	@Override
	public Object updateReconciliationState(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.updateReconciliationState(orderMerchantsBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}

		return num;
	}

	@Override
	public Object getMerchantsTotalSale(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDaoC.getMerchantsTotalConsume(orderMerchantsBean);
		if (orderMerchantsBean2 == null) {
			throw new AppException("没有销售记录");
		}
		List<OrderGoodsBean> orderGoodsBeans = orderDaoC
				.getMerchantsTotalSales(new OrderGoodsBean().setMerchants_id(orderMerchantsBean.getMerchants_id())
						.setGoods_min_time(orderMerchantsBean.getGoods_min_time())
						.setGoods_max_time(orderMerchantsBean.getGoods_max_time()));
		MerchantsBean merchantsBean = merchantsDaoC.getMerchantsDetail(
				new MerchantsBean().setMerchants_id(NumberUtils.Integer(orderMerchantsBean2.getMerchants_id())));
		if (merchantsBean == null) {
			throw new AppException("商家不存在");
		}
		orderMerchantsBean2.setMerchants_name(merchantsBean.getMerchants_name());
		if (orderMerchantsBean != null && orderGoodsBeans != null) {
			for (int i = 0; i < orderGoodsBeans.size(); i++) {
				OrderGoodsBean orderGoodsBean = orderGoodsBeans.get(i);

				orderMerchantsBean2.setGoods_num(orderGoodsBean.getGoods_num());
			}
		}

		return orderMerchantsBean2;
	}

	@Override
	public List<Map> exportOrders(OrderBean orderBean) {
		// TODO Auto-generated method stub
		return orderDaoC.exportOrders(orderBean);
	}

	@Override
	public Object getMemberVouchers(MemberVoucherBean memberVoucherBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberVoucherBean> memberVoucherBeans = orderDaoC.getMemberVouchers(memberVoucherBean, pageBean);
		return pageBean.setObject(memberVoucherBeans);
	}

	@Override
	public Object updateGoodsChangerNote(GoodsChangerNoterBean goodsChangerNoterBean) {
		int num = orderDaoC.updateGoodsChangerNote(goodsChangerNoterBean);
		if(num <= 0 ){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object getGoodsChangerNotes(GoodsChangerBean goodsChangerBean, PageBean pageBean) {
		List<GoodsChangerNoterBean> goodsChangerNoterBeans = orderDaoC.getGoodsChangerNotes(goodsChangerBean, pageBean);
		for(GoodsChangerNoterBean goodsChangerNoterBean : goodsChangerNoterBeans){
			List<OrderAddressBean> orderAddressBeans = orderDaoC.getOrderAddressByChanger(new OrderAddressBean().setChanger_id(goodsChangerNoterBean.getChanger_id()+""));
			goodsChangerNoterBean.setOrderAddressBeans(orderAddressBeans);
		}
		return pageBean.setObject(goodsChangerNoterBeans);
	}
	
	@Override
	public List<Map> exportAdverOrders(AdvertiseOrderBean advertiseOrderBean) {
		// TODO Auto-generated method stub
		return orderDaoC.exportAdverOrders(advertiseOrderBean);
	}
	
	@Override
	public List<Map> exportFinalAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean) {
		// TODO Auto-generated method stub
		return orderDaoC.exportFinalAdvertiseOrders(advertiseOrderBean);
	}

	@Override
	public Object getOrders(OrderBean orderBean, PageBean pageBean) {
		List<OrderBean> orderBeans = orderDaoC.getOrders(orderBean,pageBean);
		return pageBean.setObject(orderBeans);
	}
	
	@Override
	public Object getOrdersTotalPrice(OrderBean orderBean) {
		return orderDaoC.getOrdersTotalPrice(orderBean);
	}

	@Override
	public int updateOrder(OrderBean orderBean) {
		int num = orderDaoC.updateOrder(orderBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		if("have_refunded".equals(orderBean.getOrder_state())){
			//同意退款 如果有优惠券 退回优惠券
			OrderBean orderBean2 = orderDaoC.getOrderDetail(new OrderBean().setOrder_id(orderBean.getOrder_id()));
			if(!StringUtils.isNull(orderBean2.getMember_coupon_id())){
				//将优惠券设置为待使用
				ShopMemberCouponBean shopMemberCouponBean = shopCouponDaoC.getShopMemberCouponDetail(new ShopMemberCouponBean().setMember_coupon_id(
						Integer.valueOf(orderBean2.getMember_coupon_id())));
				if(shopMemberCouponBean==null){
					throw new AppException("修改失败");
				}
				num = shopCouponDaoC.updateShopMemberCoupon(new ShopMemberCouponBean().setMember_coupon_id(Integer.valueOf(orderBean2.getMember_coupon_id())
						).setMember_coupon_state("1"));
				if(num <= 0){
					throw new AppException("修改失败");
				}
			}
			
		}
		return num;
	}

	@Override
	public int deleteOrder(OrderBean orderBean) {
		int num = orderDaoC.deleteOrder(orderBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object getOrderDetail(OrderBean orderBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderDetail(orderBean);
	}
	

}
