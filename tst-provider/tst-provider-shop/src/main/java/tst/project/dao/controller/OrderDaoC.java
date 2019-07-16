package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.GoodsChangerNoterBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.MemberVoucherBean;
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
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;

@Mapper
public interface OrderDaoC {
	
	/**
	 * 订单总价
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrdersTotalPrice(OrderBean orderBean);
	/**
	 * 导出支付订单
	 * @param advertiseOrderBean
	 * @return
	 */
	public List<Map> exportFinalAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 获取兑换记录列表
	 * @param goodsChangerBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsChangerNoterBean> getGoodsChangerNotes(GoodsChangerBean goodsChangerBean,PageBean pageBean);
	
	
	
	/**
	 * 获取地址信息
	 * @param orderAddressBean
	 * @return
	 */
	public List<OrderAddressBean> getOrderAddressByChanger(OrderAddressBean orderAddressBean);
	/**
	 * 修改兑换记录
	 * @param goodsChangerNoterBean
	 * @return
	 */
	public int updateGoodsChangerNote(GoodsChangerNoterBean goodsChangerNoterBean);
	
	/**
	 * 用户代金券
	 * @author hwq
	 * @return
	 */
	public List<MemberVoucherBean> getMemberVouchers(MemberVoucherBean memberVoucherBean, PageBean pageBean);
	
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
	public Map<String,Object> getTotalOrderPrice(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 佣金结算订单
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public int commissionOrder(OrderMerchantsBean orderMerchantsBean);
	
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
	public List<OrderMerchantsBean> getCommissionOrders(OrderMerchantsBean orderMerchantsBean,PageBean pageBean);
	
	/**
	 * 获得结算金额统计
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public OrderMerchantsBean getSettlementPrices(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 结算商家订单
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public int settlementOrders(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 订单销量详情
	 * @author sjb
	 * @param orderSaleBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderSaleBean> getOrderSales(OrderSaleBean orderSaleBean, PageBean pageBean);
	
	
	/**
	 * 修改用户余额
	 * @return
	 */
	public int updateMemberBalance(ShopMemberBean shopMemberBean);

	
	/**
	 * 修改用户信用额度
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberCreditV2(ShopMemberBean shopMemberBean);
	/**
	 * 用户详情
	 * @param shopMemberBean
	 * @return
	 */
	public ShopMemberBean getMemberDetail(ShopMemberBean shopMemberBean);
	/**
	 * 订单详情
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrderDetail(OrderBean orderBean);
	
	/**
	 * 订单列表
	 * @param orderBean
	 * @return
	 */
	public List<OrderBean> getOrders(OrderBean orderBean,PageBean pageBean);
	/**
	 * 修改订单
	 * @param orderBean
	 * @return
	 */
	public int updateOrder(OrderBean orderBean);
	
	/**
	 * 删除订单
	 * @param orderBean
	 * @return
	 */
	public int deleteOrder(OrderBean orderBean);
	
	
	/**
	 * 导出定金订单
	 * @param advertiseOrderBean
	 * @return
	 */
	public List<Map> exportAdverOrders(AdvertiseOrderBean advertiseOrderBean);
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
	public int updateReconciliationState(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商家总销售额、总销售量详情
	 * @author hwq
	 * @param orderMerchantsBean
	 * @param pageBean
	 */
	public List<OrderMerchantsBean> getMerchantsTotalSaleDetail(OrderMerchantsBean orderMerchantsBean, PageBean pageBean);
	
	/**
	 * 平台总销量
	 * @author hwq
	 * @return
	 */
	public OrderGoodsBean getTerraceTotalSales(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 平台总销售额
	 * @author hwq
	 * @return
	 */
	public OrderMerchantsBean getTerraceTotalConsume(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商家总销量
	 * @author hwq
	 * @return
	 */
	public List<OrderGoodsBean> getMerchantsTotalSales(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 商家总销售额列表
	 * @author hwq
	 * @return
	 */
	public List<OrderMerchantsBean> getMerchantsTotalConsumes(OrderMerchantsBean orderMerchantsBean, PageBean pageBean);
	
	/**
	 * 商家总销售额
	 * @author hwq
	 * @return
	 */
	public OrderMerchantsBean getMerchantsTotalConsume(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商品销售统计
	 * @author hwq
	 * @param orderGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderGoodsBean> getGoodsConsumeCounts(OrderGoodsBean orderGoodsBean, PageBean pageBean);
	
	/**
	 * 用户消费排行
	 * @author hwq
	 * @param shopMemberBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBillBean> getMemberConsumeOrderBys(MemberBillBean memberBillBean, PageBean pageBean);
	
	/**
	 * 商品销量排行
	 * @author hwq
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<Map> getOrderByGoodsSales(GoodsBean goodsBean, PageBean pageBean);
	public List<Map> getOrderByGoodsSales(GoodsBean goodsBean);

	/**
	 * 商品总销量
	 * @author hwq
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getGoodsAllSales(GoodsBean goodsBean);
	
	/**
	 * 会员等级人数统计
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public List<CreditGradesBean> getMemberCredits(CreditGradesBean creditGradesBean, PageBean pageBean);
	
	
	
	/**
	 * 充值活动列表
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderRechargeActivityBean> getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean, PageBean pageBean);
	
	/**
	 * 充值活动详情
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public OrderRechargeActivityBean getOrderRechargeActivityDetail(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 添加充值活动
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public int insertOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 修改充值活动
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public int updateOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 删除充值活动
	 * @author hwq
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public int deleteOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	
	
	/**
	 * 添加信用额度
	 * @param orderCreditBean
	 * @return
	 */
	public int insertOrderCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 信用额度入账
	 * @author hwq
	 * @param orderCreditBean
	 * @return
	 */
	public int updateMemberCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 信用额度详情
	 * @param orderCreditBean
	 * @return
	 */
	public OrderCreditBean getOrderCreditDetail(OrderCreditBean orderCreditBean);
	
	/**
	 * 信用额度明细
	 * @param orderCreditBean
	 * @return
	 */
	public int insertMemberCreditBills(OrderCreditBean orderCreditBean);
	
	/**
	 * 用户账单明细入库
	 * @param memberBillBean
	 * @return
	 */
	public int insertMemberBill(MemberBillBean memberBillBean);
	
	/**
	 * 修改订单(平台)
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int refundOrder(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 计算还有没有未结束退款的订单
	 * @param orderRefundBean
	 * @return
	 */
	public int getEndRefundOrder(OrderRefundBean orderRefundBean);
	/**
	 * 退款拒绝  恢复可退款金额
	 * @param orderGoodsBean
	 * @return
	 */
	public int refuseOrderGoods(OrderGoodsBean orderGoodsBean);
	/**
	 * 退款订单
	 * @param orderRefundBean
	 * @return
	 */
	public int updateOrderRefund(OrderRefundBean orderRefundBean);
	
	/**
	 * 添加订单物流发货详情
	 * @param orderLogisticsBean
	 * @return
	 */
	public int insertOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	
	/**
	 * 修改订单物流发货详情
	 * @param orderLogisticsBean
	 * @return
	 */
	public int updateOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	
	/**
	 * 获得订单物流发货详情
	 * @param orderLogisticsBean
	 * @return
	 */
	public OrderLogisticsBean getOrderLogisticsDetail(OrderLogisticsBean orderLogisticsBean);
	
	
	/**
	 * 订单各状态数量统计
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<Map<String,Object>> getOrderCounts(OrderBean orderBean);
	
	/**
	 * 订单各状态销售统计
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<Map<String,Object>> getOrderPrices(OrderBean orderBean);
	/**
	 * 通过时间段获取这个时间段的销售额
	 * @param orderBean
	 * @return
	 */
	public List<Map<String,Object>> getOrderTotalAmounts(Map<String,Object> map);
	
	/**
	 * 获得订单地址
	 * 
	 * @param OrderAddressBean
	 * @return
	 */
	public OrderAddressBean getOrderAddress(OrderAddressBean OrderAddressBean);

	/**
	 * 获得订单商品
	 * 
	 * @param orderGoodsBean
	 * @return
	 */
	public List<OrderGoodsBean> getOrderGoods(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 订单商品详情
	 * @param orderGoodsBean
	 * @return
	 */
	public OrderGoodsBean getOrderGoodsDetail(OrderGoodsBean orderGoodsBean);

	/**
	 * 获得订单活动
	 * @param orderActivityBean
	 * @return
	 */
	public List<OrderActivityBean> getOrderActivity(OrderActivityBean orderActivityBean);

	/**
	 * 获得订单列表
	 * 
	 * @param orderMerchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderMerchantsBean> getOrderMerchants(OrderMerchantsBean orderMerchantsBean, PageBean pageBean);

	/**
	 * 得到订单详情
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public OrderMerchantsBean getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 修改订单
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int updateOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	
	/**
	 * 发货订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int sendOrder(OrderMerchantsBean orderMerchantsBean);


	/**
	 * 退款订单详情
	 * 
	 * @param orderRefundBean
	 * @return
	 */
	public OrderRefundBean getOrderRefundDetail(OrderRefundBean orderRefundBean);

	/**
	 * 退款订单商品详情
	 * 
	 * @param orderGoodsBean
	 * @return
	 */
	public OrderGoodsBean getOrderRefundGoodsBeanDetail(OrderGoodsBean orderGoodsBean);

	/**
	 * 退款原因列表
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public List<OrderRefundReasonBean> getOrderRefundReasonBeans(OrderRefundReasonBean orderRefundReasonBean,
			PageBean pageBean);

	/**
	 * 获取退款原因详情
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public OrderRefundReasonBean getOrderRefundReasonBeanDetail(OrderRefundReasonBean orderRefundReasonBean);

	/**
	 * 退款原因上下移动
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public OrderRefundReasonBean moveOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);

	/**
	 * 添加退款原因
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public int insertOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);

	/**
	 * 修改退款原因
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public int updateOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);

	/**
	 * 删除退款原因
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public int deleteOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean);


	/**
	 * 订单评价详情
	 * 
	 * @param orderAssessmentBean
	 * @return
	 */
	public OrderAssessmentBean getOrderAssessmentBeanDetail(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 删除订单评论
	 * @author hwq
	 * @param orderAssessmentBean
	 * @return
	 */
	public int deleteOrderAssessment(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 快递列表
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public List<OrderLogisticsCompanyBean> getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean,PageBean pageBean);
	
	/**
	 * 快递详情
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public OrderLogisticsCompanyBean getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 添加快递
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public int insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);

	/**
	 * 修改快递
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public int updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 删除快递
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public int deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	
	/**
	 * 获得退款订单
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderRefundBean> getOrderRefunds(OrderRefundBean orderRefundBean,PageBean pageBean);
	
	/**
	 * 获得订单评价
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderAssessmentBean> getOrderAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean);
	
	
}
