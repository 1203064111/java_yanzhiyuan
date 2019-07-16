/**
 * 
 */
package tst.project.shop.interfaces;

import java.util.List;
import java.util.Map;


import tst.project.bean.activity.ZMAyOrderBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.FreightCityBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.OrderActivityBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberIntegralBean;
import tst.project.bean.shop.OrderAssessmentBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderCreditBean;
import tst.project.bean.shop.OrderGoodsBean;
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
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IOrderService {
	
	
	/**
	 * 支付购物车结算的订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object payShopCars(OrderBean orderBean);
	/**
	 * 发布日志
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object insertSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 删除订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object deleteOrder(OrderBean orderBean);
	/**
	 * 退款订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object refundOrder2(OrderBean orderBean);
	/**
	 * 取消退款
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object cancelRefundOrder2(OrderBean orderBean);
	/**
	 * 评价订单
	 * @author lx
	 * @param orderAssessmentBean
	 * @return
	 */
	public Object insertOrderAssessment(OrderAssessmentBean orderAssessmentBean);
	/**
	 * 支付订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object payOrder(OrderBean orderBean);
	/**
	 * 获取商城商品兑换记录
	 * @author lx
	 * @param goodsChangerBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsChangerNotes(GoodsChangerBean goodsChangerBean,PageBean pageBean);
	/**
	 * 订单已使用
	 * @author Administrator
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object isHaveBeenOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 用户兑换商品
	 * @author Administrator
	 * @param goodsChangerBean
	 * @return
	 */
	public Object insertGoodsChanger(GoodsChangerBean goodsChangerBean, String is_summit);
	
	
	/**
	 * 用户兑换商城商品
	 * @author lx
	 * @param goodsChangerBean
	 * @return
	 */
	public Object insertGoodsChangerOrder(GoodsChangerBean goodsChangerBean);
	
	/**
	 * 订单确认收货
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object timeingReceiveOrder(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 订单支付成功通知
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object timeingPayNoticeOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 店铺的订单结算
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object timeingCommissionOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 定时同步订单各个状态的销量
	 * @author sjb
	 * @param orderSaleBean
	 * @return
	 */
	public Object timeingOrderSales(OrderSaleBean orderSaleBean);
	
	
	/**
	 * 定时结算订单
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object timeingCloseOrders(OrderBean orderBean);
	
	/**
	 * 定时取消代付款订单
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object timingCancelOrders(OrderBean orderBean);
	
	/**
	 * 退货物流详情
	 * @author sjb
	 * @param orderLogisticsBean
	 * @return
	 */
	public Object getOrderRefundLogisticsDetails(OrderLogisticsBean orderLogisticsBean);
	
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
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 订单的物流信息
	 * @author sjb
	 * @param orderLogisticsDetailBean
	 * @return
	 */
	public Object getOrderLogisticsDetails(OrderLogisticsBean orderLogisticsBean);
	
	/**
	 * 信用额度(应还)    
	 * @author hwq
	 * @param orderCreditBean
	 * @return
	 */
	public Object getMemberCreditRefund(MemberCreditBillBean memberCreditBillBean);
	
	/**
	 * 信用额度还款支付成功回调
	 * @param orderCreditBean
	 * @return
	 */
	public Object payCreditCallback(OrderCreditBean orderCreditBean);
	
	/**
	 * 添加信用额度
	 * @author hwq
	 * @param orderCreditBean
	 * @return
	 */
	public Object insertOrderCredit(OrderCreditBean orderCreditBean);
	
	/**
	 * 获得充值活动列表
	 * @param orderRechargeActivityBean
	 * @return
	 */
	public Object getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean);
	
	
	/**
	 * 充值支付成功回调
	 * @param orderRechargeBean
	 * @return
	 */
	public Object payRechargeCallback(OrderRechargeBean orderRechargeBean);
	
	/**
	 * 余额充值订单
	 * @param orderRechargeBean
	 * @return
	 */
	public Object insertOrderRecharge(OrderRechargeBean orderRechargeBean);

	/**
	 * 商城部分 用户详情
	 * @param memberBean
	 * @return
	 */
	public Object getMemberDetail(ShopMemberBean shopMemberBean);
	
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
	 * 积分明细表
	 * @param memberIntegralBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberIntegrals(MemberIntegralBean memberIntegralBean,String type,PageBean pageBean);
	
	/**
	 * 信用额度明细表
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberCredits(MemberCreditBillBean memberCreditBillBean,String type,PageBean pageBean);
	
	/**
	 * 消费明细表
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberBills(MemberBillBean memberBillBean,String type,PageBean pageBean);
	
	/**
	 * 获得退款订单详情
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public Object getRefundOrderDetail(OrderRefundBean orderRefundBean);
	
	/**
	 * 获得退款订单列表
	 * @param orderRefundBean
	 * @param pageBean
	 * @return
	 */
	public Object getRefundOrders(OrderRefundBean orderRefundBean,PageBean pageBean);
	
	/**
	 * 订单的退款的原因列表
	 * @param orderRefundReasonBean
	 * @return
	 */
	public Object getOrderRefundReasons(OrderRefundReasonBean orderRefundReasonBean);
	
	/**
	 * 退款订单
	 * @param orderGoodsBean
	 * @return
	 */
	public Object refundOrder(OrderRefundBean orderRefundBean);
	
	/**
	 * 取消退款申请
	 * @author sjb
	 * @param orderRefundBean
	 * @return
	 */
	public Object cancelRefundOrder(OrderRefundBean orderRefundBean);
	
	/**
	 * 评价订单
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object assessmentOrder(OrderMerchantsBean orderMerchantsBean,List<OrderAssessmentBean> orderAssessmentBeans);
	
	/**
	 * 订单的评价列表
	 * @param orderAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean);
	
	/**
	 * 支付订单
	 * @param orderBean
	 * @return
	 */
	public Object payGoodsCallback(OrderBean orderBean,String pay_password);
	
	
	
	/**
	 * 真实支付订单
	 * @param orderBean
	 * @return
	 */
	public Object payRealOrder(OrderBean orderBean);

	/**
	 * 取消订单(待发货状态)
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object cancelPayOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	
	
	/**
	 * 取消订单(未支付之前)
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object cancelOrder(OrderBean orderBean);
	

	/**
	 * 确认收货
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object receiveOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 添加订单
	 * @param orderBean
	 * @return
	 */
	public Object insertOrder(OrderBean orderBean);
	
	/**
	 * 删除订单(已关闭)
	 * @author hwq
	 * @param orderBean
	 * @return
	 */
	public Object deleteOrderClose(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 删除订单(取消 待付款)
	 * @author hwq
	 * @param orderBean
	 * @return
	 */
	public Object deleteOrderCancelWaitPay(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 获得订单列表
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrders(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 获得订单详情
	 * @param orderBean
	 * @return
	 */
	public Object getOrderDetail(OrderBean orderBean);
	
	/**
	 * 获得订单商家详情
	 * @param orderBean
	 * @return
	 */
	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);

	
	/**
	 * 更新余额
	 * @author gxq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberBalnace(ShopMemberBean shopMemberBean,MemberBillBean memberBillBean);
	
	/**
	 * 一元试吃更新余额
	 * @author gxq
	 * @param shopMemberBean
	 * @return
	 */
	public int updateMemberBalanceOfOneYuan(String member_id, String order_price, String freight_total_price);
	
	/**
	 * 查看余额
	 * @author gxq
	 * @param shopMemberBean
	 * @return
	 */
	public ShopMemberBean getMemberBalance(ShopMemberBean shopMemberBean);

	/**
	 * 收支明细
	 * @author gxq
	 * @param memberBillBean
	 * @return
	 */
	public int inSertMemberBill(MemberBillBean memberBillBean);
	
	/**
	 * 收支明细
	 * @author lx
	 * @param memberBillBean
	 * @return
	 */
	public List<MemberBillBean> getMemberBills(MemberBillBean memberBillBean,PageBean pageBean);
	
	/**
	 * 添加账单明细
	 * @author liyong
	 * @param memberBillBean
	 * @return
	 */
	public int OneYuaninsertMemberBalanceBills(MemberBillBean memberBillBean);
	
	/**
	 * 更新商品库存
	 * @author gxq
	 * @return
	 */
	public int updateOrderGoods(OrderGoodsBean orderGoodsBean,String update_type);
	
	/**
	 * 获得订单商品的邮费详情
	 * @author liyong
	 * @param freightCityBean
	 * @return
	 */
	public Map<String, Object> getGoodsFreightDetail(ZMAyOrderBean ayOrderBean, String city_names);

	
	/**
	 * 获取未读订单数量
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	Object getOrderRedState(OrderBean orderBean);
	
}
