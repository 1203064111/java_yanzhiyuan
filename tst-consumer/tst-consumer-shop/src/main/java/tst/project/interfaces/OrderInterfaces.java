package tst.project.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberIntegralBean;
import tst.project.bean.shop.OrderAssessmentBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderCreditBean;
import tst.project.bean.shop.OrderLogisticsBean;
import tst.project.bean.shop.OrderLogisticsCompanyBean;
import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.bean.shop.OrderRechargeActivityBean;
import tst.project.bean.shop.OrderRechargeBean;
import tst.project.bean.shop.OrderRefundBean;
import tst.project.bean.shop.OrderRefundReasonBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IOrderService;
import tst.project.utils.WXUtils;

@Controller
@RequestMapping("/orderInterfaces/v1.0")
public class OrderInterfaces {

	@Autowired
	IOrderService orderService;
	
	
	
	@RequestMapping("/isHaveBeenOrder")
	@AppController(isVerToken=true)
	public Object isHaveBeenOrder(OrderMerchantsBean orderMerchantsBean) throws Exception{
		return orderService.isHaveBeenOrder(orderMerchantsBean);
	}
	/**
	 * 用户兑换商品
	 * @author Administrator
	 * @param goodsChangerBean
	 * @return
	 */
	@RequestMapping("/insertGoodsChanger")
	@AppController(isVerToken=true)
	public Object insertGoodsChanger(String json,String is_summit,String member_id) throws Exception{
		return orderService.insertGoodsChanger(JSON.parseObject(json, 
				GoodsChangerBean.class).setMember_id(member_id), is_summit);
	}
	/**
	 * 用户兑换商城商品
	 * @author lx
	 * @param goodsChangerBean
	 * @return
	 */
	@RequestMapping("/insertGoodsChangerOrder")
	@AppController(isVerToken=true)
	public Object insertGoodsChangerOrder(String json,String member_id) throws Exception{
		return orderService.insertGoodsChangerOrder(JSON.parseObject(json, 
				GoodsChangerBean.class).setMember_id(member_id));
	}
	/**
	 * 获取商城商品兑换记录
	 * @author lx
	 * @param goodsChangerBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getGoodsChangerNotes")
	@AppController(isVerToken=true)
	public Object getGoodsChangerNotes(GoodsChangerBean goodsChangerBean,PageBean pageBean) throws Exception{
		return orderService.getGoodsChangerNotes(goodsChangerBean,pageBean);
	}
	
	
	@RequestMapping("/timeingReceiveOrder")
	@AppController
	public Object timeingReceiveOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.timeingReceiveOrder(orderMerchantsBean);
	}

	@RequestMapping("/timeingPayNoticeOrder")
	@AppController(isLog=false)
	public Object timeingPayNoticeOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.timeingPayNoticeOrder(orderMerchantsBean);
	}
	
	
	/**
	 * 充值回调
	 * @author hwq
	 * @param order_no
	 * @param trade_no
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payRechargeCallback")
	@AppController
	public Object payRechargeCallback(String order_no,String trade_no) throws Exception {
		return orderService.payRechargeCallback(new OrderRechargeBean()
				.setOrder_no(order_no)
				.setOut_trade_no(trade_no));
	}
	
	
	
	@RequestMapping("/timeingCommissionOrder")
	@AppController(isLog=false)
	public Object timeingCommissionOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.timeingCommissionOrder(orderMerchantsBean);
	}
	
	
	
	
	@RequestMapping("/timeingCloseOrders")
	@AppController(isLog=false)
	public Object timeingCloseOrders(OrderBean orderBean) throws Exception	{
		return orderService.timeingCloseOrders(orderBean);
	}
	
	
	@RequestMapping("/timingCancelOrders")
	@AppController(isLog=false)
	public Object timingCancelOrders(OrderBean orderBean) throws Exception	{
		return orderService.timingCancelOrders(orderBean);
	}
	
	
	@RequestMapping("/sendOrderRefund")
	@AppController(isVerToken=true)
	public Object sendOrderRefund(OrderRefundBean orderRefundBean) throws Exception	{
		return orderService.sendOrderRefund(orderRefundBean);
	}
	
	
	@RequestMapping("/getOrderLogisticsCompanys")
	@AppController
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean) throws Exception	{
		return orderService.getOrderLogisticsCompanys(orderLogisticsCompanyBean);
	}
	
	
	/**
	 * @author gxq
	 * @param memberBillBean
	 * @return
	 */
	@RequestMapping("/inSertMemberBill")
	@AppController(isVerToken=true)
	public Object inSertMemberBill(MemberBillBean memberBillBean) {
		
		return orderService.inSertMemberBill(memberBillBean);
	}
	
	@RequestMapping("/getOrderLogisticsDetails")
	@AppController(isVerToken=true)
	public Object getOrderLogisticsDetails(OrderLogisticsBean orderLogisticsBean) throws Exception	{
		return orderService.getOrderLogisticsDetails(orderLogisticsBean);
	}
	
	@RequestMapping("/getMemberCreditRefund")
	@AppController(isVerToken=true)
	public Object getMemberCreditRefund(MemberCreditBillBean memberCreditBillBean) throws Exception	{
		return orderService.getMemberCreditRefund(memberCreditBillBean);
	}
	
	@RequestMapping("/payBalanceOrder")
	@AppController(isVerToken=true)
	public Object payBalanceOrder(OrderBean orderBean,String pay_password) throws Exception	{
		return orderService.payGoodsCallback(orderBean.setPay_way("balance"),pay_password);
	}
	
	@RequestMapping("/payCreditOrder")
	@AppController(isVerToken=true)
	public Object payCreditOrder(OrderBean orderBean,String pay_password) throws Exception	{
		return orderService.payGoodsCallback(orderBean.setPay_way("credit"),pay_password);
	}
	
	/**
	 * 微信app支付回调
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxCallback")
	@AppController(isNeedPackage = false)
	public Object wxpayMemberIntegralOrder(HttpServletRequest request) throws Exception {
		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		String resultStr = new String(outSteam.toByteArray(), "UTF-8");
		Map<String, String> resultMap = WXUtils.doXMLParse(resultStr);

		String out_trade_no = resultMap.get("out_trade_no");
		String transaction_id = resultMap.get("transaction_id");
		String sign = resultMap.get("sign");
		String return_code = resultMap.get("return_code");
		String cash_fee = resultMap.get("cash_fee");
		if(out_trade_no.indexOf("g")>=0){//商品支付成功回调
		    orderService.payGoodsCallback(new OrderBean().setOut_trade_no(out_trade_no),"");
		}
//		else{//充值
//			orderService.payRechargeCallback(new OrderRechargeBean().setOrder_no(out_trade_no).setOut_trade_no(transaction_id));
//		}
	    return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}
	
	
	@RequestMapping("/alipayCallback")
	@AppController
	public Object alipayCallback(String out_trade_no,String trade_no,String trade_status) throws Exception {
		if("TRADE_SUCCESS".equals(trade_status)){//支付成功回调
			if(out_trade_no.indexOf("g")>=0){//商品支付成功回调
			    return orderService.payGoodsCallback(new OrderBean().setOut_trade_no(out_trade_no),"");
			}else{
				return "ok";
			}
//			else{//充值
//			    return orderService.payRechargeCallback(new OrderRechargeBean().setOrder_no(out_trade_no).setOut_trade_no(out_trade_no));
//			}
		}else if("TRADE_CLOSED".equals(trade_status)){//退款成功回调
			return "ok";
		}else{
			return "ok";
		}
	}
	
	@RequestMapping("/payCreditCallback")
	@AppController
	public Object payCreditCallback(String order_no,String trade_no) throws Exception {
		return orderService.payCreditCallback(new OrderCreditBean()
				.setOrder_no(order_no)
				.setOut_trade_no(trade_no));
	}
	
	
	
	@RequestMapping("/getOrderRechargeActivitys")
	@AppController
	public Object getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean) throws Exception {
	    return orderService.getOrderRechargeActivitys(orderRechargeActivityBean);
	}
	
	@RequestMapping("/insertOrderCredit")
	@AppController(isVerToken=true)
	public Object insertOrderCredit(OrderCreditBean orderCreditBean)throws Exception{
		return orderService.insertOrderCredit(orderCreditBean);
	}
	
	@RequestMapping("/insertOrderRecharge")
	@AppController(isVerToken=true)
	public Object insertOrderRecharge(OrderRechargeBean orderRechargeBean) throws Exception {
		return orderService.insertOrderRecharge(orderRechargeBean);
	}
	
	@RequestMapping("/getMemberIntegrals")
	@AppController(isVerToken=true,isPage=true)
	public Object getMemberIntegrals(MemberIntegralBean memberIntegralBean,String type,PageBean pageBean) throws Exception {
		return orderService.getMemberIntegrals(memberIntegralBean,type,pageBean);
	}
	
	@RequestMapping("/getMemberDetail")
	@AppController(isVerToken=true)
	public Object getMemberDetail(ShopMemberBean shopMemberBean) throws Exception {
		return orderService.getMemberDetail(shopMemberBean);
	}
	
	@RequestMapping("/insertMemberCredit")
	@AppController(isVerToken=true)
	public Object insertMemberCredit(ShopMemberBean shopMemberBean) throws Exception {
		return orderService.insertMemberCredit(shopMemberBean);
	}
	
	@RequestMapping("/updateMemberCreditV2")
	@AppController(isVerToken=true)
	public Object updateMemberCreditV2(ShopMemberBean shopMemberBean) throws Exception {
		return orderService.updateMemberCreditV2(shopMemberBean);
	}
	
	
	@RequestMapping("/getMemberCredits")
	@AppController(isVerToken=true,isPage=true)
	public Object getMemberCredits(MemberCreditBillBean memberCreditBillBean,String type,PageBean pageBean) throws Exception {
		return orderService.getMemberCredits(memberCreditBillBean,type,pageBean);
	}
	
	@RequestMapping("/getMemberBills")
	@AppController(isVerToken=true,isPage=true)
	public Object getMemberBills(MemberBillBean memberBillBean,String type,PageBean pageBean) throws Exception {
		return orderService.getMemberBills(memberBillBean,type,pageBean);
	}
	
	@RequestMapping("/getRefundOrderDetail")
	@AppController(isVerToken=true)
	public Object getRefundOrderDetail(OrderRefundBean orderRefundBean) throws Exception {
		return orderService.getRefundOrderDetail(orderRefundBean);
	}
	
	@RequestMapping("/getRefundOrders")
	@AppController(isVerToken=true,isPage=true)
	public Object getRefundOrders(OrderRefundBean orderRefundBean,PageBean pageBean) throws Exception {
		return orderService.getRefundOrders(orderRefundBean,pageBean);
	}
	
	@RequestMapping("/getOrderRefundReasons")
	@AppController
	public Object getOrderRefundReasons(OrderRefundReasonBean orderRefundReasonBean) throws Exception {
		return orderService.getOrderRefundReasons(orderRefundReasonBean);
	}
	
	/**
	 * 退款订单
	 * @param orderGoodsBean
	 * @return
	 */
	@RequestMapping("/refundOrder")
	@AppController(isVerToken=true)
	public Object refundOrder(OrderRefundBean orderRefundBean) throws Exception {
		return orderService.refundOrder(orderRefundBean);
	}
	/**
	 * 取消退款申请
	 * @param orderRefundBean
	 * @return
	 */
	@RequestMapping("/cancelRefundOrder")
	@AppController(isVerToken=true)
	public Object cancelRefundOrder(OrderRefundBean orderRefundBean) throws Exception {
		return orderService.cancelRefundOrder(orderRefundBean);
	}
	
	
	
	@RequestMapping("/assessmentOrder")
	@AppController(isVerToken=true)
	public Object assessmentOrder(OrderMerchantsBean orderMerchantsBean,String json) throws Exception {
		return orderService.assessmentOrder(orderMerchantsBean,JSON.parseArray(json,OrderAssessmentBean.class));
	}
	/**
	 * 订单的评价列表
	 * @param orderAssessmentBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getOrderAssessments")
	@AppController(isPage=true)
	public Object getOrderAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean) throws Exception {
		return orderService.getOrderAssessments(orderAssessmentBean,pageBean);
	}


	/**
	 * 支付订单
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("/payOrder")
	@AppController(isVerToken=true)
	public Object payOrder(OrderBean orderBean,String password) throws Exception {
		return orderService.payGoodsCallback(orderBean,password);
	}
	
	@RequestMapping("/payRealOrder")
	@AppController(isVerToken=true)
	public Object payRealOrder(OrderBean orderBean) throws Exception {
		return orderService.payRealOrder(orderBean);
	}
	
	@RequestMapping("/cancelPayOrderMerchants")
	@AppController(isVerToken=true)
	public Object cancelPayOrderMerchants(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.cancelPayOrderMerchants(orderMerchantsBean);
	}
	
	
	@RequestMapping("/cancelOrder")
	@AppController(isVerToken=true)
	public Object cancelOrder(OrderBean orderBean) throws Exception {
		return orderService.cancelOrder(orderBean);
	}
	
	@RequestMapping("/receiveOrder")
	@AppController(isVerToken=true)
	public Object receiveOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.receiveOrder(orderMerchantsBean);
	}
	
	/**
	 * 添加订单
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertOrder")
	@AppController(isVerToken=true)
	public Object insertOrder(OrderBean orderBean) throws Exception {
		return orderService.insertOrder(orderBean);
	}
	
	@RequestMapping("/deleteOrderClose")
	@AppController(isVerToken=true)
	public Object deleteOrderClose(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.deleteOrderClose(orderMerchantsBean);
	}
	
	@RequestMapping("/deleteOrderCancelWaitPay")
	@AppController(isVerToken=true)
	public Object deleteOrderCancelWaitPay(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.deleteOrderCancelWaitPay(orderMerchantsBean);
	}
	/**
	 * 获得订单详情
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("/getOrderDetail")
	@AppController(isVerToken=true)
	public Object getOrderDetail(OrderBean orderBean) throws Exception {
		return orderService.getOrderDetail(orderBean);
	}
	
	@RequestMapping("/getOrderMerchantsDetail")
	@AppController(isVerToken=true)
	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.getOrderMerchantsDetail(orderMerchantsBean);
	}

	/**
	 * 获得订单列表
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getOrders")
	@AppController(isVerToken=true,isPage=true)
	public Object getOrders(OrderBean orderBean,PageBean pageBean) throws Exception {
		return orderService.getOrders(orderBean, pageBean);
	}
	/**
	 * 支付订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("/payOrder2")
	@AppController
	public Object payOrder(OrderBean orderBean)throws Exception{
		return orderService.payOrder(orderBean);
	}
	
	@RequestMapping("/getOrderRedState")
	@AppController(isVerToken=true)
	public Object getOrderRedState(OrderBean orderBean) throws Exception{
		return orderService.getOrderRedState(orderBean);
	}
	/**
	 * 添加评论
	 * @param orderAssessmentBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertOrderAssessment")
	@AppController(isVerToken=true)
	public Object insertOrderAssessment(OrderAssessmentBean orderAssessmentBean) throws Exception{
		return orderService.insertOrderAssessment(orderAssessmentBean);
	}
	
	/**
	 * 删除订单
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteOrder")
	@AppController(isVerToken=true)
	public Object deleteOrder(OrderBean orderBean) throws Exception{
		return orderService.deleteOrder(orderBean);
	}
	/**
	 * 退款订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("/refundOrder2")
	@AppController(isVerToken=true)
	public Object refundOrder2(OrderBean orderBean) throws Exception{
		return orderService.refundOrder2(orderBean);
	}
	/**
	 * 取消退款
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("/cancelRefundOrder2")
	@AppController(isVerToken=true)
	public Object cancelRefundOrder2(OrderBean orderBean) throws Exception{
		return orderService.cancelRefundOrder2(orderBean);
	}
	/**
	 * 添加资讯
	 * @param systemInformationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemInformation")
	@AppController(isVerToken=true)
	public Object insertSystemInformation(SystemInformationBean systemInformationBean)throws Exception{
		return orderService.insertSystemInformation(systemInformationBean);
	}

	/**
	 * 支付购物车结算的订单
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("/payShopCars")
	@AppController
	public Object payShopCars(OrderBean orderBean)throws Exception{
		return orderService.payShopCars(orderBean);
	}
	
}
