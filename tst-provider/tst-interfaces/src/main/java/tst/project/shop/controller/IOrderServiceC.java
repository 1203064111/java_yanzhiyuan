package tst.project.shop.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.container.page.Page;

import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.GoodsChangerNoterBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.MemberVoucherBean;
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
import tst.project.page.PageBean;

public interface IOrderServiceC {
	/**
	 * 导出支付订单
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public List<Map> exportFinalAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 导出定金订单
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public List<Map> exportAdverOrders(AdvertiseOrderBean advertiseOrderBean);
	
	/**
	 * 获取兑换记录列表
	 * @author lx
	 * @param goodsChangerBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsChangerNotes(GoodsChangerBean goodsChangerBean,PageBean pageBean);
	
	/**
	 * 修改兑换记录状态
	 * @author lx
	 * @param goodsChangerNoterBean
	 * @return
	 */
	public Object updateGoodsChangerNote(GoodsChangerNoterBean goodsChangerNoterBean);
	
	/**
	 * 用户代金券
	 * @author hwq
	 * @return
	 */
	public Object getMemberVouchers(MemberVoucherBean memberVoucherBean, PageBean pageBean);
	
	/**
	 * 购物车统计
	 * @author sjb
	 * @param shopCarBean
	 * @return
	 */
	public Map<String, Object> getShopCarStatistics(ShopCarBean shopCarBean);
	
	/**
	 * 退款统计
	 * @author sjb
	 * @return
	 */
	public Map<String,Object> getRefundStatistics(OrderRefundBean orderRefundBean);
	
	/**
	 * 销售额
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public  Map<String,Object> getTotalOrderPrice(OrderMerchantsBean orderMerchantsBean);
	

	/**
	 * 佣金结算订单
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object commissionOrder(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 佣金统计
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getCommissionPrices(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 佣金订单
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getCommissionOrders(OrderMerchantsBean orderMerchantsBean,PageBean pageBean);

	/**
	 * 获得结算金额统计
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getSettlementPrices(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 结算商家订单
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object settlementOrders(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 订单销量详情
	 * @author sjb
	 * @param orderSaleBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderSales(OrderSaleBean orderSaleBean, PageBean pageBean);
	
	/**
	 * 导出订单
	 * @author hwq
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<Map> exportOrders(OrderBean orderBean);
	
	/**
	 * 修改对账状态
	 * @author hwq
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object updateReconciliationState(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商家总销售额、总销售量详情
	 * @author hwq
	 * @param orderMerchantsBean
	 * @param pageBean
	 */
	public Object getMerchantsTotalSaleDetail(OrderMerchantsBean orderMerchantsBean, PageBean pageBean);
	
	/**
	 * 平台总销售额和总销售量
	 * @author hwq
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getTerraceTotalSales(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商家总销售额和总销售量
	 * @author hwq
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getMerchantsTotalSales(OrderMerchantsBean orderMerchantsBean, PageBean pageBean);
	
	/**
	 * 商家总销售额和总销售量
	 * @author hwq
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getMerchantsTotalSale(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商品销售统计
	 * @author hwq
	 * @param orderGoodsBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsConsumeCounts(OrderGoodsBean orderGoodsBean, PageBean pageBean);
	
	/**
	 * 用户消费排行
	 * @author hwq
	 * @param shopMemberBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberConsumeOrderBys(MemberBillBean memberBillBean, PageBean pageBean);
	
	/**
	 * 商品销量排行
	 * @author hwq
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderByGoodsSales(GoodsBean goodsBean, PageBean pageBean);
	
	/**
	 * 导出商品销量详情
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public List<Map> exportGoodsSales(GoodsBean goodsBean);
	/**
	 * 商品总销量
	 * @author hwq
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsAllSales(GoodsBean goodsBean);
	
	/**
	 * 会员等级人数统计
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public Object getMemberCredits(CreditGradesBean creditGradesBean, PageBean pageBean);
	

	
	/**
	 * 充值活动列表
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean, PageBean pageBean);
	
	/**
	 * 充值活动详情
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public Object getOrderRechargeActivityDetail(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 添加充值活动
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public Object insertOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 修改充值活动
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public Object updateOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 删除充值活动
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public Object deleteOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	
	
	/**
	 * 添加信用额度
	 * @param orderCreditBean
	 * @return
	 */
	public Object insertOrderCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 退款订单
	 * @param orderRefundBean
	 * @return
	 */
	public Object refundOrder(OrderRefundBean orderRefundBean);
	
	/**
	 * 修改订单物流发货详情
	 * @param orderLogisticsBean
	 * @return
	 */
	public Object updateOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	/**
	 * 订单数量统计
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getOrderCounts(OrderBean orderBean);
	
	/**
	 * 订单个状态销售统计
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getOrderPrices(OrderBean orderBean);
	/**
	 * 订单的销售额按天统计
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object getOrderTotalAmounts(OrderBean orderBean);
	
	/**
	 * 获得订单列表
	 * 
	 * @param orderMerchantsBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderMerchants(OrderMerchantsBean orderMerchantsBean, PageBean pageBean);
	
	/**
	 * 获取订单列表
	 * @author lx
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrders(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 获取订单总价
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object getOrdersTotalPrice(OrderBean orderBean);
	/**
	 * 修改订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public int updateOrder(OrderBean orderBean);
	
	/**
	 * 删除订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public int deleteOrder(OrderBean orderBean);
	
	/**
	 * 订单详情
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object getOrderDetail(OrderBean orderBean);

	/**
	 * 获得订单详情
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 修改订单
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object updateOrderMerchants(OrderMerchantsBean orderMerchantsBean);


	/**
	 * 发货订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public Object sendOrder(OrderLogisticsBean orderLogisticsBean);
	
	
	/**
	 * 退款订单列表
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderRefundBeans(OrderRefundBean orderRefundBean,PageBean pageBean);

	
	/**
	 * 退款订单详情
	 * @param orderRefundBean
	 * @return
	 */
	public Object getOrderRefundDetail(OrderRefundBean orderRefundBean);
	
	/**
	 * 退款原因列表
	 * @param orderRefundReasonBean
	 * @return
	 */
	public Object getOrderRefundReasonBeans(OrderRefundReasonBean orderRefundReasonBean, PageBean pageBean);

	/**
	 * 获取退款原因详情
	 * @param rrderRefundReasonBean
	 * @return
	 */
	public Object getOrderRefundReasonBeanDetail(OrderRefundReasonBean orderRefundReasonBean);
	
	/**
	 * 退款原因上下移动
	 * @param orderRefundReasonBean
	 * @return
	 */
	public Object moveOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);
	
	/**
	 * 添加退款原因
	 * @param orderRefundReasonBean
	 * @return
	 */
	public Object insertOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);
	
	/**
	 * 修改退款原因
	 * @param orderRefundReasonBean
	 * @return
	 */
	public Object updateOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);
	
	/**
	 * 删除退款原因
	 * @param orderRefundReasonBean
	 * @return
	 */
	public Object deleteOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);
	
	/**
	
	/**
	 * 订单评价详情
	 * @param orderAssessmentBean
	 * @return
	 */
	public Object getOrderAssessmentBeanDetail(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 删除订单评论
	 * @author hwq
	 * @param orderAssessmentBean
	 * @return
	 */
	public Object deleteOrderAssessment(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 快递列表
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean,PageBean pageBean);

	
	/**
	 * 快递详情
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 添加快递
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 修改快递
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);

	
	/**
	 * 删除快递
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	
	/**
	 * 获得退款订单
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderRefunds(OrderRefundBean orderRefundBean,PageBean pageBean);
	
	/**
	 * 获得订单评价
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean);
	
	
}
