package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.FreightCityBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.GoodsChangerNoterBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberGoodsRecordBean;
import tst.project.bean.shop.MemberIntegralBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.MemberVoucherBean;
import tst.project.bean.shop.MerchantsBalanceBean;
import tst.project.bean.shop.MerchantsBillBean;
import tst.project.bean.shop.OrderActivityBean;
import tst.project.bean.shop.OrderActivityGoodsBean;
import tst.project.bean.shop.OrderAddressBean;
import tst.project.bean.shop.OrderAssessmentBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderCreditBean;
import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.bean.shop.OrderRechargeActivityBean;
import tst.project.bean.shop.OrderRechargeBean;
import tst.project.bean.shop.OrderRefundBean;
import tst.project.bean.shop.OrderRefundReasonBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.bean.shop.OrderGoodsBean;
import tst.project.bean.shop.OrderInvoiceBean;
import tst.project.bean.shop.OrderLogisticsBean;
import tst.project.bean.shop.OrderLogisticsCompanyBean;
import tst.project.bean.shop.OrderLogisticsDetailBean;
import tst.project.page.PageBean;

@Mapper
public interface OrderDao {
	
	/**
	 * 用户发布日志
	 * @param systemInformationBean
	 * @return
	 */
	public int insertSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 获取资讯分类详情
	 * @param systemInformationClassBean
	 * @return
	 */
	public SystemInformationClassBean getSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	
	/**
	 * 删除订单
	 * @param orderBean
	 * @return
	 */
	public int deleteOrder(OrderBean orderBean);
	/**
	 * 退款订单
	 * @param orderBean
	 * @return
	 */
	public int refundOrder2(OrderBean orderBean);
	
	/**
	 * 取消退款
	 * @param orderBean
	 * @return
	 */
	public int cancelRefundOrder2(OrderBean orderBean);
	/**
	 * 添加订单评价
	 * @param orderAssessmentBean
	 * @return
	 */
	public int insertOrderAssessment(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 获取用户的商品兑换记录
	 * @param goodsChangerBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsChangerNoterBean> getGoodsChangerNotes(GoodsChangerBean goodsChangerBean,PageBean pageBean);
	
	/**
	 * 订单已使用
	 * @author Administrator
	 * @param orderMerchantsBean
	 * @return
	 */
	public int isHaveBeenOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 判断用户是否使用过该商品
	 * @author Administrator
	 * @param orderGoodsBean
	 * @return
	 */
	public int isGoodsEmploy(MemberGoodsRecordBean memberGoodsRecordBean);
	
	/**
	 * 添加用户的购买记录
	 * @param memberGoodsRecordBean
	 * @return
	 */
	public int insertGoodsEmploy(MemberGoodsRecordBean memberGoodsRecordBean);
	
	/**
	 * 添加兑换记录
	 * 
	 * @param orderBean
	 * @return
	 */
	public int insertGoodsChanger(GoodsChangerBean goodsChangerBean);
	
	/**
	 * 修改兑换记录
	 * 
	 * @param orderBean
	 * @return
	 */
	public int updateGoodsChanger(GoodsChangerBean goodsChangerBean);
	
	/**
	 * 添加兑换记录的商品信息
	 * 
	 * @param orderBean
	 * @return
	 */
	public int insertGoodsChangerNoter(GoodsChangerNoterBean goodsChangerNoterBean);
	
	/**
	 * 发货七天的订单自动收货
	 * @author hwq
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<OrderMerchantsBean> timeingReceiveOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 还未通知支付成功的订单
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<Map<String,Object>> getNoPayNoticeOrder(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 订单支付成功通知
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public int timeingPayNoticeOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 修改用户余额
	 * @return
	 */
	public int updateMemberBalanceV2(ShopMemberBean shopMemberBean);
	
	/**
	 * 会员等级信息列表
	 * @author hwq
	 * @return
	 */
	public List<MemberLevelBean> getMemberLevels();
	
	/**
	 * 用户累计消费
	 * @author hwq
	 * @return
	 */
	public double getMemberConsume(MemberBillBean memberBillBean);
	
	
	/**
	 * 赠送代金券
	 * @param orderRechargeBean
	 * @return
	 */
	public int insertMemberVoucher(MemberVoucherBean memberVoucherBean);
	
	/**
	 * 代金券入账
	 * @param orderRechargeBean
	 * @return
	 */
	public int updateMemberVoucher(ShopMemberBean shopMemberBean);
	
	/**
	 * 获得未激活代金券的充值满足金额
	 * @author hwq
	 * @return
	 */
	public OrderRechargeActivityBean getOrderRechargeActivityDetail();
	
	/**
	 * 激活代金券
	 * @author hwq
	 * @param memberVoucherBean
	 * @return
	 */
	public int updateVoucherState(MemberVoucherBean memberVoucherBean);
	
	
	
	/**
	 * 店铺的订单佣金列表
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<OrderMerchantsBean> getCommissionOrders(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 店铺的订单结算
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public int timeingCommissionOrder(OrderMerchantsBean orderMerchantsBean);
	
	
	
	
	
	/**
	 * 修改商家的余额详情
	 * @param merchantsBalanceBean
	 * @return
	 */
	public int updateMerchantsBalance(MerchantsBalanceBean merchantsBalanceBean);
	
	/**
	 * 添加商家账单
	 * @param merchantsBillBean
	 * @return
	 */
	public int insertMerchantsBill(MerchantsBillBean merchantsBillBean);
	
	
	/**
	 * 关闭商家订单
	 * @param orderMerchantsBean
	 * @return
	 */
	public int closeOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 获得可以结算的订单列表
	 * @param orderBean
	 * @return
	 */
	public List<OrderMerchantsBean> getWaitCloseOrders(OrderBean orderBean);
	
	/**
	 * 获得可以取消的订单列表
	 * @param orderBean
	 * @return
	 */
	public List<OrderBean> getWaitCancelOrders(OrderBean orderBean);
	
	/**
	 * 真实支付更新商家订单支付方式
	 * @param orderMerchantsBean
	 * @return
	 */
	public int payRealOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 退货订单 填写物流信息
	 * @param orderRefundBean
	 * @return
	 */
	public int sendOrderRefund(OrderRefundBean orderRefundBean);
	
	/**
	 * 物流公司列表
	 * @author sjb
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public List<OrderLogisticsCompanyBean> getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	

	
	/**
	 * 物流信息
	 * @author hwq
	 * @param orderLogisticsBean
	 * @return
	 */
	public OrderLogisticsBean getOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	/**
	 * 订单的物流信息
	 * @author sjb
	 * @param orderLogisticsDetailBean
	 * @return
	 */
	public List<OrderLogisticsDetailBean> getOrderLogisticsDetails(OrderLogisticsDetailBean orderLogisticsDetailBean);
	
	/**
	 * 信用额度(应还)
	 * @author hwq
	 * @param orderCreditBean
	 * @return
	 */
	public MemberCreditBillBean getMemberCreditRefund(MemberCreditBillBean memberCreditBillBean);
	
	
	/**
	 * 余额支付
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int payBalanceOrder(OrderBean orderBean);
	
	/**
	 * 累加消费金额
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateAccumulateConsume(ShopMemberBean shopMemberBean);
	
	/**
	 * 减少累积消费金额
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateAccumulateConsumeV2(ShopMemberBean shopMemberBean);
	
	/**
	 * 减少累积消费金额
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int resetAccumulateConsume(ShopMemberBean shopMemberBean);
	
	/**
	 * 一元试吃余额支付
	 * @param ayOrderBean
	 * @return
	 */
	public int updateMemberBalanceOfOneYuan(String member_id, String order_price, String freight_total_price);
	
	/**
	 * 余额支付明细入账
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int insertMemberBalanceBills(MemberBillBean memberBillBean);
	
	/**
	 * 一元试吃支付明细入账
	 * @param memberBillBean
	 * @return
	 */
	public int OneYuaninsertMemberBalanceBills(MemberBillBean memberBillBean);
	
	/**
	 * 信用额度支付
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberCredit(OrderBean orderBean);
	
	/**
	 * 信用额度支付明细入账
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int insertMemberCreditBills(MemberBillBean memberBillBean);
	
	/**
	 * 添加信用额度
	 * @param orderCreditBean
	 * @return
	 */
	public int insertOrderCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 信用额度详情
	 * @param orderCreditBean
	 * @return
	 */
	public OrderCreditBean getOrderCreditDetail(OrderCreditBean orderCreditBean);
	
	/**
	 * 信用额度还款成功
	 * @param orderCreditBean
	 * @return
	 */
	public int payOrderCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 修改用户信用额度
	 * @param orderCreditBean
	 * @return
	 */
	public int updateMemberOrderCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 用户信用额度明细
	 * @param orderCreditBean
	 * @return
	 */
	public int insertMemberCreditBillsV2(OrderCreditBean orderCreditBean);
	
	/**
	 * 用户信用额度明细
	 * @param orderCreditBean
	 * @return
	 */
	public int insertMemberCreditBillsV3(MemberCreditBillBean memberCreditBillBean);
	
	/**
	 * 订单发票入库
	 * @param orderInvoiceBean
	 * @return
	 */
	public int insertOrderInvoice(OrderInvoiceBean orderInvoiceBean);
	
	/**
	 * 获得充值活动列表
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public List<OrderRechargeActivityBean> getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean);
	/**
	 * 获得充值活动 赠送最多的活动
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public OrderRechargeActivityBean getOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean);
	
	/**
	 * 充值账单明细
	 * @param orderRechargeBean
	 * @return
	 */
	public int insertMemberRechargeBills(OrderRechargeBean orderRechargeBean);

	/**
	 * 第一次充值
	 * @param orderRechargeBean
	 * @return
	 */
	public int insertMemberOrderRecharge(OrderRechargeBean orderRechargeBean);
	
	/**
	 * 非第一次充值
	 * @param orderRechargeBean
	 * @return
	 */
	public int updateMemberOrderRecharge(OrderRechargeBean orderRechargeBean);

	/**
	 * 充值订单支付成功
	 * @param orderRechargeBean
	 * @return
	 */
	public int payOrderRecharge(OrderRechargeBean orderRechargeBean);
	
	/**
	 * 订单充值详情
	 * @param orderRechargeBean
	 * @return
	 */
	public OrderRechargeBean getOrderRechargeDetail(OrderRechargeBean orderRechargeBean);
	
	/**
	 * 充值订单入库
	 * @param orderRechargeBean
	 * @return
	 */
	public int insertOrderRecharge(OrderRechargeBean orderRechargeBean);
	
	/**
	 * 用户详情
	 * @param shopMemberBean
	 * @return
	 */
	public ShopMemberBean getMemberDetail(ShopMemberBean shopMemberBean);
	
	/**
	 * 商城部分 添加用户
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int insertMemberCredit(ShopMemberBean shopMemberBean);
	
	/**
	 * 商城部分 修改用户
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberCreditV2(ShopMemberBean shopMemberBean);
	
	/**
	 * 获得积分明细(按月统计)
	 * @param memberIntegralBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberIntegralsByMonth(MemberIntegralBean memberIntegralBean,PageBean pageBean);
	
	/**
	 * 获得积分明细(按天统计)(分页)
	 * @param memberIntegralBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberIntegralsByDay(MemberIntegralBean memberIntegralBean,PageBean pageBean);
	
	/**
	 * 获得积分明细(按天统计)
	 * @param memberIntegralBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberIntegralsByDay(MemberIntegralBean memberIntegralBean);
	
	/**
	 * 积分明细表
	 * @param memberIntegralBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberIntegralBean> getMemberIntegrals(MemberIntegralBean memberIntegralBean,PageBean pageBean);
	
	/**
	 * 积分明细表(分页)
	 * @param memberIntegralBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberIntegralBean> getMemberIntegrals(MemberIntegralBean memberIntegralBean);
	
	/**
	 * 取消订单 批量积分明细入库
	 * @return
	 */
	public int insertCancelMemberIntegrals(OrderBean orderBean);
	
	/**
	 * 订单取消退换积分
	 * @return
	 */
	public int cancelMemberIntegral(ShopMemberBean shopMemberBean);
	
	/**
	 * 购买订单 赠送积分 更新用户积分值
	 * @param orderBean
	 * @return
	 */
	public int giveMemberIntegral(OrderBean orderBean);
	
	
	
	/**
	 * 购买订单 批量给用户积分明细
	 * @param orderBean
	 * @return
	 */
	public int insertMemberIntegrals(OrderBean orderBean);
	
	/**
	 * 添加积分明细
	 * @param memberIntegralBean
	 * @return
	 */
	public int insertMemberIntegral(MemberIntegralBean memberIntegralBean);
	
	/**
	 * 更新用户详情
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMember(ShopMemberBean shopMemberBean);

	/**
	 * 获得消费明细(按月统计)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberBillsByMonth(MemberBillBean memberBillBean,PageBean pageBean);
	
	/**
	 * 获得消费明细(按天统计)(分页)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberBillsByDay(MemberBillBean memberBillBean,PageBean pageBean);
	
	/**
	 * 获得消费明细(按天统计)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberBillsByDay(MemberBillBean memberBillBean);
	
	/**
	 * 获得消费明细(分页)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBillBean> getMemberBills(MemberBillBean memberBillBean,PageBean pageBean);
	
	/**
	 * 获得消费明细
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBillBean> getMemberBills(MemberBillBean memberBillBean);
	
	
	/**
	 * 获得信用额度明细(按月统计)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberCreditsByMonth(MemberCreditBillBean memberCreditBillBean,PageBean pageBean);
	
	/**
	 * 获得信用额度明细(按天统计)(分页)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberCreditsByDay(MemberCreditBillBean memberCreditBillBean,PageBean pageBean);
	
	/**
	 * 获得信用额度明细(按天统计)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberCreditsByDay(MemberCreditBillBean memberCreditBillBean);
	
	/**
	 * 获得信用额度明细(分页)
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberCreditBillBean> getMemberCredits(MemberCreditBillBean memberCreditBillBean,PageBean pageBean);
	
	/**
	 * 获得信用额度明细
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberCreditBillBean> getMemberCredits(MemberCreditBillBean memberCreditBillBean);
	
	
	/**
	 * 用户账号详情入库
	 * @return
	 */
	public int insertMemberBills(MemberBillBean memberBillBean);
	
	/**
	 * 获得订单商品的邮费详情
	 * 
	 * @param freightCityBean
	 * @return
	 */
	public Map<String, Object> getGoodsFreightDetail(FreightCityBean freightCityBean);

	/**
	 * 获得商品参加直降活动 最低价
	 * 
	 * @param activityGoodsBean
	 * @return
	 */
	public Map<String, Object> getGoodsDescendingActivity(ActivityGoodsBean activityGoodsBean);

	/**
	 * 添加订单活动
	 * 
	 * @param orderActivityBean
	 * @return
	 */
	public int insertOrderActivity(OrderActivityBean orderActivityBean);

	/**
	 * 批量添加满赠活动
	 * @param orderActivityBean
	 * @return
	 */
	public int insertOrderActivityGives(OrderActivityBean orderActivityBean);
	
	/**
	 * 批量添加满赠商品活动
	 * @param orderActivityBean
	 * @return
	 */
	public int insertOrderActivityGoodss(OrderActivityGoodsBean orderActivityGoodsBean);
	
	/**
	 * 获得商品参加的满减活动（支持多个规格商品）
	 * 
	 * @param activityGoodsBean
	 * @return
	 */
	public List<Map<String, Object>> getGoodsReduceActivitys(ActivityGoodsBean activityGoodsBean);

	/**
	 * 获得商品参加的满赠活动（支持多个规格商品）
	 * @param activityGoodsBean
	 * @return
	 */
	public List<Map<String,Object>> getGoodsGiveActivitys(ActivityGoodsBean activityGoodsBean);
	
	/**
	 * 获得退款订单详情
	 * 
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public OrderRefundBean getRefundOrderDetail(OrderRefundBean orderRefundBean);

	/**
	 * 获得退款订单列表
	 * 
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderRefundBean> getRefundOrders(OrderRefundBean orderRefundBean, PageBean pageBean);

	/**
	 * 订单的退款的原因列表
	 * 
	 * @param orderRefundReasonBean
	 * @return
	 */
	public List<OrderRefundReasonBean> getOrderRefundReasons(OrderRefundReasonBean orderRefundReasonBean);

	/**
	 * 修改订单商品的信息
	 * 
	 * @param orderGoodsBean
	 * @return
	 */
	public int updateOrderGoods(OrderGoodsBean orderGoodsBean);

	/**
	 * 退款修改订单商品里的退款信息
	 * 
	 * @param orderGoodsBean
	 * @return
	 */
	public int refundOrderGoods(OrderGoodsBean orderGoodsBean);

	/**
	 * 申请退款订单
	 * 
	 * @param orderRefundBean
	 * @return
	 */
	public int insertOrderRefund(OrderRefundBean orderRefundBean);

	
	/**
	 * 取消退款申请
	 * @param orderRefundBean
	 * @return
	 */
	public int cancelOrderRefund(OrderRefundBean orderRefundBean);
	
	/**
	 * 获得退款详情
	 * 
	 * @param orderRefundBean
	 * @return
	 */
	public OrderRefundBean getOrderRefundDetail(OrderRefundBean orderRefundBean);

	/**
	 * 购买修改商品的销量
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int updateGoodsSales(OrderBean orderBean);

	/**
	 * 取消订单 恢复商品的销量
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int cancelGoodsSales(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 订单的评价列表
	 * 
	 * @param orderAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderAssessmentBean> getOrderAssessments(OrderAssessmentBean orderAssessmentBean, PageBean pageBean);

	/**
	 * 评价订单
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int assessmentOrder(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 评价订单详情入库
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int insertOrderAssessments(List<OrderAssessmentBean> orderAssessmentBeans);

	/**
	 * 评价订单 修改商品的星级信息
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int assessmentOrderGoods(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 评价订单 修改商家的星级信息
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int assessmentOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 取消订单 恢复商品的库存
	 * 
	 * @return
	 */
	public int cancelGoodsStock(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 支付订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int payOrder(OrderBean orderBean);

	/**
	 * 支付商家订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int payOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 取消订单(未支付之前)
	 * 
	 * @param orderBean
	 * @return
	 */
	public int cancelOrder(OrderBean orderBean);

	/**
	 * 取消订单(未支付之前)
	 * 
	 * @param orderBean
	 * @return
	 */
	public int cancelOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 取消订单(待发货状态)
	 * 
	 * @param orderBean
	 * @return
	 */
	public int cancelPayOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 确认收货
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int receiveOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 确认收货
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int receiveOrderV2(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 订单详情
	 * 
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrderDetail(OrderBean orderBean);
	
	/**
	 * 获取多个订单列表
	 * @param orderBean
	 * @return
	 */
	public List<OrderBean> getOrderDetails(OrderBean orderBean);

	/**
	 * 获得订单商家详情
	 * 
	 * @param orderBean
	 * @return
	 */
	public OrderMerchantsBean getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 获得订单地址详情
	 * 
	 * @param orderAddressBean
	 * @return
	 */
	public OrderAddressBean getOrderAddressDetail(OrderAddressBean orderAddressBean);

	/**
	 * 获得订单列表
	 * 
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderBean> getOrders(OrderBean orderBean, PageBean pageBean);

	/**
	 * 获得订单商家列表
	 * 
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderMerchantsBean> getOrderMerchantss(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 获得订单详情商品列表
	 * 
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderGoodsBean> getOrderGoodss(OrderGoodsBean orderGoodsBean);

	/**
	 * 获得订单商品详情
	 * 
	 * @param orderGoodsBean
	 * @return
	 */
	public OrderGoodsBean getOrderGoodsDetail(OrderGoodsBean orderGoodsBean);

	/**
	 * 添加订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int insertOrder(OrderBean orderBean);
	
	/**
	 * 删除订单(已关闭)
	 * @author hwq
	 * @param orderBean
	 * @return
	 */
	public int deleteOrderClose(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 删除订单(取消 待付款)
	 * @author hwq 
	 * @param orderBean
	 * @return
	 */
	public int deleteOrderCancelWaitPay(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 添加订单地址
	 * 
	 * @param orderAddressBean
	 * @return
	 */
	public int insertOrderAddress(OrderAddressBean orderAddressBean);

	/**
	 * 修改订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int updateOrder(OrderBean orderBean);

	/**
	 * 添加订单详情
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int insertOrderMerchants(OrderMerchantsBean orderDetailBean);

	/**
	 * 修改订单详情
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int updateOrderMerchants(OrderMerchantsBean orderDetailBean);

	/**
	 * 添加订单商品
	 * @param orderGoodsBean
	 * @return
	 */
	public int insertOrderGoods(OrderGoodsBean orderGoodsBean);
	

	/**
	 * 个人余额
	 * @param shopMemberBean
	 * @return
	 */
	public int createMemberBalnace(ShopMemberBean shopMemberBean);

	/**
	 * 更新个人余额
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberBalnace(ShopMemberBean shopMemberBean);
	/**
	 * 个人余额详情
	 * @param shopMemberBean
	 * @return
	 */
	public ShopMemberBean getMemberBalance(ShopMemberBean shopMemberBean);
	/**
	 * 收支记录
	 * @param memberBillBean
	 * @return
	 */
	public int inSertMemberBill(MemberBillBean memberBillBean);
	
	/**
	 * 获取用户未读订单数量
	 * @param OrderBean
	 * @return
	 */
	public int getActivityOrderRedState(OrderBean orderBean);
	
	/**
	 * 订单改变标识
	 * @param orderBean
	 * @return
	 */
	public int updateOrderRed(OrderBean orderBean);
	
		
	
}
