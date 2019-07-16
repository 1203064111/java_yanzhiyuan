package tst.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.aspect.AppException;
import tst.project.bean.excel.ExcelBean;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsChangerBean;
import tst.project.bean.shop.GoodsChangerNoterBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
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
import tst.project.bean.shop.ShopMemberBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IOrderServiceC;
import tst.project.shop.interfaces.IOrderService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/orderController/v1.0")
public class OrderController {
	@Autowired
	IOrderServiceC orderServiceC;
	
	@Autowired
	ISystemService systemService;
	
	@Value("${img_path}")
	private String img_path;
	

	/**
	 * 获取兑换记录列表
	 * @author lx
	 * @param goodsChangerBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getGoodsChangerNotes") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getGoodsChangerNotes(GoodsChangerBean goodsChangerBean,PageBean pageBean) throws Exception {
		return orderServiceC.getGoodsChangerNotes(goodsChangerBean,pageBean);
	}
	
	/**
	 * 修改兑换记录状态
	 * @author lx
	 * @param goodsChangerNoterBean
	 * @return
	 */
	@RequestMapping("/updateGoodsChangerNote") 
	@AppController(isVerSystemToken=true) 
	public Object updateGoodsChangerNote(GoodsChangerNoterBean goodsChangerNoterBean) throws Exception {
		return orderServiceC.updateGoodsChangerNote(goodsChangerNoterBean);
	}
	
	
	@RequestMapping("/getShopCarStatistics") 
	@AppController(isVerSystemToken=true) 
	public Object getShopCarStatistics(ShopCarBean shopCarBean) throws Exception {
		return orderServiceC.getShopCarStatistics(shopCarBean);
	}
	
	
	
	@RequestMapping("/getMemberVouchers")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberVouchers(MemberVoucherBean memberVoucherBean, PageBean pageBean)
		throws Exception{
		return orderServiceC.getMemberVouchers(memberVoucherBean, pageBean);
	}
	
	
	@RequestMapping("/getRefundStatistics") 
	@AppController(isVerSystemToken=true) 
	public Object getRefundStatistics(OrderRefundBean orderRefundBean) throws Exception {
		return orderServiceC.getRefundStatistics(orderRefundBean);
	}
	
	
	@RequestMapping("/getTotalOrderPrice") 
	@AppController(isVerSystemToken=true) 
	public Object getTotalOrderPrice(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.getTotalOrderPrice(orderMerchantsBean);
	}

	
	@RequestMapping("/commissionOrder") 
	@AppController(isVerSystemToken=true) 
	public Object commissionOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.commissionOrder(orderMerchantsBean);
	}
	
	
	
	@RequestMapping("/getCommissionPrices") 
	@AppController(isVerSystemToken=true) 
	public Object getCommissionPrices(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.getCommissionPrices(orderMerchantsBean);
	}
	
	
	@RequestMapping("/getCommissionOrders") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getCommissionOrders(OrderMerchantsBean orderMerchantsBean,PageBean pageBean) throws Exception {
		return orderServiceC.getCommissionOrders(orderMerchantsBean,pageBean);
	}
	
	
	@RequestMapping("/getSettlementPrices") 
	@AppController(isVerSystemToken=true) 
	public Object getSettlementPrices(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.getSettlementPrices(orderMerchantsBean);
	}
	
	
	@RequestMapping("/settlementOrders") 
	@AppController(isVerSystemToken=true) 
	public Object settlementOrders(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.settlementOrders(orderMerchantsBean);
	}
	
	/**
	 * 导出订单
	 * @param request
	 * @param orderBean
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportOrders")
	@AppController(isVerSystemToken=true)
	public Object exportOrders(HttpServletRequest request,OrderBean orderBean
			,HttpServletResponse response) throws Exception {
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("订单号").setType("order_no"));
		
		excelBeans.add(new ExcelBean().setName("用户ID").setType("member_id"));
		excelBeans.add(new ExcelBean().setName("用户名").setType("member_name"));
		
		excelBeans.add(new ExcelBean().setName("商家ID").setType("merchants_id"));
		excelBeans.add(new ExcelBean().setName("商家名称").setType("merchants_name"));
		excelBeans.add(new ExcelBean().setName("商品ID").setType("goods_id"));
		excelBeans.add(new ExcelBean().setName("商品名称").setType("goods_name"));
		excelBeans.add(new ExcelBean().setName("商品单价").setType("goods_price"));
		excelBeans.add(new ExcelBean().setName("商品数量").setType("goods_num"));
		excelBeans.add(new ExcelBean().setName("订单价格").setType("order_price"));
		excelBeans.add(new ExcelBean().setName("下单手机号").setType("order_mobile"));
		excelBeans.add(new ExcelBean().setName("支付方式").setType("pay_way"));
		excelBeans.add(new ExcelBean().setName("订单状态").setType("order_state_show"));
		excelBeans.add(new ExcelBean().setName("退款理由").setType("refund_reason"));
		excelBeans.add(new ExcelBean().setName("退款失败原因").setType("refund_fail_reason"));
		excelBeans.add(new ExcelBean().setName("下单时间").setType("create_time"));
		
		List<Map> exportOrders = orderServiceC.exportOrders(orderBean);
		
		String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + 
				NumberUtils.createRandom(true, 6) + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/" + fileName
				, excelBeans, exportOrders);
		if(is_success) {
			return "/excel/"+fileName;
		}else {
			throw new AppException("导出失败");
		}
		
	}
	/**
	 * 导出支付订单
	 * @param request
	 * @param advertiseOrderBean
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportFinalAdvertiseOrders")
	@AppController(isVerSystemToken=true)
	public Object exportFinalAdvertiseOrders(HttpServletRequest request,AdvertiseOrderBean advertiseOrderBean
			,HttpServletResponse response) throws Exception {
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("订单号").setType("order_no"));
		excelBeans.add(new ExcelBean().setName("下单时间").setType("create_time"));
		
		

		excelBeans.add(new ExcelBean().setName("订单类型").setType("order_type_show"));
		excelBeans.add(new ExcelBean().setName("支付方式").setType("pay_type_show"));
		excelBeans.add(new ExcelBean().setName("支付类型").setType("pay_way"));
		excelBeans.add(new ExcelBean().setName("订单总价").setType("order_pay_second"));
		
		
		excelBeans.add(new ExcelBean().setName("职位ID").setType("position_id"));
		excelBeans.add(new ExcelBean().setName("职位名称").setType("position_title"));
		excelBeans.add(new ExcelBean().setName("认证ID").setType("material_id"));
		excelBeans.add(new ExcelBean().setName("认证名称").setType("material_name"));
		excelBeans.add(new ExcelBean().setName("省").setType("position_provider"));
		excelBeans.add(new ExcelBean().setName("市").setType("position_city"));
		excelBeans.add(new ExcelBean().setName("区").setType("position_country"));
		excelBeans.add(new ExcelBean().setName("手机号").setType("mobile"));
				
		
		List<Map> exportOrders = orderServiceC.exportFinalAdvertiseOrders(advertiseOrderBean);
		
		String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + 
				NumberUtils.createRandom(true, 6) + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/" + fileName
				, excelBeans, exportOrders);
		if(is_success) {
			return "/excel/"+fileName;
		}else {
			throw new AppException("导出失败");
		}
		
	}
	/**
	 * 导出定金订单
	 * @param request
	 * @param advertiseOrderBean
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportAdvertiseOrders")
	@AppController(isVerSystemToken=true)
	public Object exportAdvertiseOrders(HttpServletRequest request,AdvertiseOrderBean advertiseOrderBean
			,HttpServletResponse response) throws Exception {
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("订单号").setType("order_no"));
		excelBeans.add(new ExcelBean().setName("下单时间").setType("create_time"));
		
		

		excelBeans.add(new ExcelBean().setName("订单类型").setType("order_type_show"));
		excelBeans.add(new ExcelBean().setName("支付方式").setType("pay_type_show"));
		excelBeans.add(new ExcelBean().setName("支付类型").setType("pay_way"));
		excelBeans.add(new ExcelBean().setName("订单总价").setType("order_pay_first"));
		excelBeans.add(new ExcelBean().setName("押金").setType("advertise_order_total"));
		excelBeans.add(new ExcelBean().setName("是否打款给商家").setType("order_remit_show"));
		
		excelBeans.add(new ExcelBean().setName("职位ID").setType("position_id"));
		excelBeans.add(new ExcelBean().setName("职位名称").setType("position_title"));
		excelBeans.add(new ExcelBean().setName("认证ID").setType("material_id"));
		excelBeans.add(new ExcelBean().setName("认证名称").setType("material_name"));
		excelBeans.add(new ExcelBean().setName("省").setType("position_provider"));
		excelBeans.add(new ExcelBean().setName("市").setType("position_city"));
		excelBeans.add(new ExcelBean().setName("区").setType("position_country"));
		excelBeans.add(new ExcelBean().setName("手机号").setType("mobile"));
				
		
		List<Map> exportOrders = orderServiceC.exportAdverOrders(advertiseOrderBean);
		
		String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + 
				NumberUtils.createRandom(true, 6) + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/" + fileName
				, excelBeans, exportOrders);
		if(is_success) {
			return "/excel/"+fileName;
		}else {
			throw new AppException("导出失败");
		}
		
	}
	
	@RequestMapping("/updateReconciliationState") 
	@AppController(isVerSystemToken=true) 
	public Object updateReconciliationState(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.updateReconciliationState(orderMerchantsBean);
	}
	
	@RequestMapping("/getMerchantsTotalSaleDetail") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMerchantsTotalSaleDetail(OrderMerchantsBean orderMerchantsBean, PageBean pageBean) throws Exception {
		return orderServiceC.getMerchantsTotalSaleDetail(orderMerchantsBean, pageBean);
	}
	
	@RequestMapping("/getTerraceTotalSales") 
	@AppController(isVerSystemToken=true) 
	public Object getTerraceTotalSales(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.getTerraceTotalSales(orderMerchantsBean);
	}
	
	@RequestMapping("/getMerchantsTotalSales") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMerchantsTotalSales(OrderMerchantsBean orderMerchantsBean, PageBean pageBean) throws Exception {
		return orderServiceC.getMerchantsTotalSales(orderMerchantsBean, pageBean);
	}
	
	@RequestMapping("/getMerchantsTotalSale") 
	@AppController(isVerSystemToken=true) 
	public Object getMerchantsTotalSale(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.getMerchantsTotalSale(orderMerchantsBean);
	}
	
	@RequestMapping("/getGoodsConsumeCounts") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getGoodsConsumeCounts(OrderGoodsBean orderGoodsBean, PageBean pageBean) throws Exception {
		return orderServiceC.getGoodsConsumeCounts(orderGoodsBean, pageBean);
	}
	
	@RequestMapping("/getMemberConsumeOrderBys") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMemberConsumeOrderBys(MemberBillBean memberBillBean, PageBean pageBean) throws Exception {
		return orderServiceC.getMemberConsumeOrderBys(memberBillBean, pageBean);
	}
	
	@RequestMapping("/getGoodsAllSales") 
	@AppController(isVerSystemToken=true) 
	public Object getGoodsAllSales(GoodsBean goodsBean) throws Exception {
		return orderServiceC.getGoodsAllSales(goodsBean);
	}
	
	@RequestMapping("/getOrderByGoodsSales") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getOrderByGoodsSales(GoodsBean goodsBean, PageBean pageBean) throws Exception {
		return orderServiceC.getOrderByGoodsSales(goodsBean, pageBean);
	}
	
	@RequestMapping("/exportGoodsSales")
	@AppController(isVerSystemToken=true)
	public Object exportGoodsSales(HttpServletRequest request,GoodsBean goodsBean
			,HttpServletResponse response) throws Exception {
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("商家").setType("merchants_name"));
		excelBeans.add(new ExcelBean().setName("品牌").setType("brand_name"));
		excelBeans.add(new ExcelBean().setName("商品名称").setType("goods_name"));
		excelBeans.add(new ExcelBean().setName("规格").setType("specification_names"));
		excelBeans.add(new ExcelBean().setName("供货价").setType("specification_wholesale_price"));
		excelBeans.add(new ExcelBean().setName("零售价").setType("specification_price"));
		excelBeans.add(new ExcelBean().setName("库存").setType("specification_stock"));
		excelBeans.add(new ExcelBean().setName("销量").setType("specification_sales"));
		
		List<Map> exportOrders = orderServiceC.exportGoodsSales(goodsBean);
		
		String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + 
				NumberUtils.createRandom(true, 6) + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/" + fileName
				, excelBeans, exportOrders);
		if(is_success) {
			return "/excel/"+fileName;
		}else {
			throw new AppException("导出失败");
		}
		
	}
	
	@RequestMapping("/getMemberCredits") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMemberCredits(CreditGradesBean creditGradesBean, PageBean pageBean) throws Exception {
		return orderServiceC.getMemberCredits(creditGradesBean, pageBean);
	}
	
	@RequestMapping("/getOrderSales") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getOrderSales(OrderSaleBean orderSaleBean, PageBean pageBean) throws Exception {
		return orderServiceC.getOrderSales(orderSaleBean, pageBean);
	}
	
	@RequestMapping("/getOrderRechargeActivitys") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getOrderRechargeActivitys(OrderRechargeActivityBean orderRechargeActivityBean, PageBean pageBean)
						throws Exception {
		return orderServiceC.getOrderRechargeActivitys(orderRechargeActivityBean, pageBean);
	}
	
	@RequestMapping("/getOrderRechargeActivityDetail") 
	@AppController(isVerSystemToken=true) 
	public Object getOrderRechargeActivityDetail(OrderRechargeActivityBean orderRechargeActivityBean)
						throws Exception {
		return orderServiceC.getOrderRechargeActivityDetail(orderRechargeActivityBean);
	}
	
	@RequestMapping("/insertOrderRechargeActivity") 
	@AppController(isVerSystemToken=true) 
	public Object insertOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean)
						throws Exception {
		return orderServiceC.insertOrderRechargeActivity(orderRechargeActivityBean);
	}
	
	@RequestMapping("/updateOrderRechargeActivity") 
	@AppController(isVerSystemToken=true) 
	public Object updateOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean)
						throws Exception {
		return orderServiceC.updateOrderRechargeActivity(orderRechargeActivityBean);
	}
	
	@RequestMapping("/deleteOrderRechargeActivity") 
	@AppController(isVerSystemToken=true) 
	public Object deleteOrderRechargeActivity(OrderRechargeActivityBean orderRechargeActivityBean)
						throws Exception {
		return orderServiceC.deleteOrderRechargeActivity(orderRechargeActivityBean);
	}
	
	
	
	@RequestMapping("/insertOrderCredit") 
	@AppController(isVerSystemToken=true) 
	public Object insertOrderCredit(OrderCreditBean OrderCreditBean) throws Exception{ 
		return orderServiceC.insertOrderCredit(OrderCreditBean);
	}
	
	@RequestMapping("/refundOrder") 
	@AppController(isVerSystemToken=true)
	public Object refundOrder(OrderRefundBean orderRefundBean) throws Exception{ 
		return orderServiceC.refundOrder(orderRefundBean);
	}
	
	@RequestMapping("/updateOrderLogistics") 
	@AppController(isVerSystemToken=true)
	public Object updateOrderLogistics(OrderLogisticsBean orderLogisticsBean) throws Exception{ 
		return orderServiceC.updateOrderLogistics(orderLogisticsBean);
	}
	
	@RequestMapping("/getOrderCounts") 
    @AppController(isVerSystemToken=true)
    public Object getOrderCounts(OrderBean orderBean) throws Exception{ 
		return orderServiceC.getOrderCounts(orderBean);
	}
	
	@RequestMapping("/getOrderPrices") 
    @AppController(isVerSystemToken=true)
    public Object getOrderPrices(OrderBean orderBean) throws Exception{ 
		return orderServiceC.getOrderPrices(orderBean);
	}
	
	@RequestMapping("/getOrderTotalAmounts") 
    @AppController(isVerSystemToken=true)
    public Object getOrderTotalAmounts(OrderBean orderBean) throws Exception{ 
		return orderServiceC.getOrderTotalAmounts(orderBean);
	}
	
	@RequestMapping("/getOrderMerchants") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getOrderMerchants(OrderMerchantsBean orderMerchantsBean, PageBean pageBean) throws Exception{ 
		return orderServiceC.getOrderMerchants(orderMerchantsBean, pageBean);
	}
	/**
	 * 订单列表
	 * @param orderBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOrders") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getOrders(OrderBean orderBean, PageBean pageBean) throws Exception{ 
		return orderServiceC.getOrders(orderBean, pageBean);
	}
	@RequestMapping("/getOrdersTotalPrice") 
    @AppController(isVerSystemToken=true)
    public Object getOrdersTotalPrice(OrderBean orderBean) throws Exception{ 
		return orderServiceC.getOrdersTotalPrice(orderBean);
	}
	
	
	/**
	 * 订单详情
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOrderDetail") 
    @AppController(isVerSystemToken=true)
    public Object getOrderDetail(OrderBean orderBean) throws Exception{ 
		return orderServiceC.getOrderDetail(orderBean);
	}
	/**
	 * 修改订单信息
	 * @param orderBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateOrder") 
    @AppController(isVerSystemToken=true)
    public Object updateOrder(OrderBean orderBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改订单信息，订单id为"+orderBean.getOrder_id())
				.setOperate_type("update")
				.setModule_id(orderBean.getOrder_id()+"")
				.setModule_name("订单模块"));
		return orderServiceC.updateOrder(orderBean);
	}
	/**
	 * 删除订单
	 * @param orderBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteOrder") 
    @AppController(isVerSystemToken=true)
    public Object deleteOrder(OrderBean orderBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除订单信息，订单id为"+orderBean.getOrder_id())
				.setOperate_type("delete")
				.setModule_id(orderBean.getOrder_id()+"")
				.setModule_name("订单模块"));
		return orderServiceC.deleteOrder(orderBean);
	}
	
	
	@RequestMapping("/getOrderMerchantsDetail") 
    @AppController(isVerSystemToken=true)
    public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean) throws Exception{ 
		return orderServiceC.getOrderMerchantsDetail(orderMerchantsBean);
	}
	
	@RequestMapping("/updateOrderMerchants") 
    @AppController(isVerSystemToken=true)
	public Object updateOrderMerchants(OrderMerchantsBean orderMerchantsBean) throws Exception{
		return orderServiceC.updateOrderMerchants(orderMerchantsBean);
	}
	
	
	@RequestMapping("/sendOrder") 
	@AppController(isVerSystemToken=true)
	public Object sendOrder(OrderLogisticsBean orderLogisticsBean) throws Exception{ 
		return orderServiceC.sendOrder(orderLogisticsBean);
	}
	
	
	
	@RequestMapping("/getOrderRefundBeans")
	@AppController(isVerSystemToken=true, isPage=true)
	public Object getOrderRefundBeans(OrderRefundBean orderRefundBean, PageBean pageBean)
										throws Exception {
		return orderServiceC.getOrderRefundBeans(orderRefundBean, pageBean);
	}
	

	@RequestMapping("/getOrderRefundDetail")
	@AppController(isVerSystemToken=true)
	public Object getOrderRefundDetail(OrderRefundBean orderRefundBean) throws Exception {
		return orderServiceC.getOrderRefundDetail(orderRefundBean);
	}
	
	@RequestMapping("/getOrderRefundReasonBeans")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getOrderRefundReasonBeans(OrderRefundReasonBean orderRefundReasonBean
			,PageBean pageBean) throws Exception {
		return orderServiceC.getOrderRefundReasonBeans(orderRefundReasonBean, pageBean);
	}
	
	@RequestMapping("/getOrderRefundReasonBeanDetail")
	@AppController(isVerSystemToken=true)
	public Object getOrderRefundReasonBeanDetail(OrderRefundReasonBean orderRefundReasonBean)
								throws Exception {
		return orderServiceC.getOrderRefundReasonBeanDetail(orderRefundReasonBean);
	}
	
	@RequestMapping("/moveOrderRefundReasonBean")
	@AppController(isVerSystemToken=true)
	public Object moveOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean)
										throws Exception {
		return orderServiceC.moveOrderRefundReasonBean(orderRefundReasonBean);
	}
	
	@RequestMapping("/insertOrderRefundReasonBean")
	@AppController(isVerSystemToken=true)
	public Object insertOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean)
										throws Exception {
		return orderServiceC.insertOrderRefundReasonBean(orderRefundReasonBean);
	}
	
	@RequestMapping("/updateOrderRefundReasonBean")
	@AppController(isVerSystemToken=true)
	public Object updateOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean)
										throws Exception {
		return orderServiceC.updateOrderRefundReasonBean(orderRefundReasonBean);
	}
	
	@RequestMapping("/deleteOrderRefundReasonBean")
	@AppController(isVerSystemToken=true)
	public Object deleteOrderRefundReasonBean(OrderRefundReasonBean orderRefundReasonBean)
										throws Exception {
		return orderServiceC.deleteOrderRefundReasonBean(orderRefundReasonBean);
	}
	
	
	@RequestMapping("/getOrderAssessmentBeanDetail")
	@AppController(isVerSystemToken=true)
	public Object getOrderAssessmentBeanDetail(OrderAssessmentBean orderAssessmentBean)
			throws Exception {
		return orderServiceC.getOrderAssessmentBeanDetail(orderAssessmentBean);
	}
	/**
	 * 删除订单评论
	 * @param orderAssessmentBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteOrderAssessment")
	@AppController(isVerSystemToken=true)
	public Object deleteOrderAssessment(OrderAssessmentBean orderAssessmentBean)
			throws Exception {
		return orderServiceC.deleteOrderAssessment(orderAssessmentBean);
	}
	
	@RequestMapping("/getOrderLogisticsCompanys")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getOrderLogisticss(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			,PageBean pageBean) throws Exception{
		return orderServiceC.getOrderLogisticsCompanys(orderLogisticsCompanyBean, pageBean);
	}
	
	@RequestMapping("/getOrderLogisticsCompanyDetail")
	@AppController(isVerSystemToken=true)
	public Object getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.getOrderLogisticsCompanyDetail(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/insertOrderLogisticsCompany")
	@AppController(isVerSystemToken=true)
	public Object insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.insertOrderLogisticsCompany(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/updateOrderLogisticsCompany")
	@AppController(isVerSystemToken=true)
	public Object updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.updateOrderLogisticsCompany(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/deleteOrderLogisticsCompany")
	@AppController(isVerSystemToken=true)
	public Object deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.deleteOrderLogisticsCompany(orderLogisticsCompanyBean);
	}
	
	
	@RequestMapping("/getOrderRefunds")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getOrderRefunds(OrderRefundBean orderRefundBean,PageBean pageBean)
			throws Exception {
		return orderServiceC.getOrderRefunds(orderRefundBean, pageBean);
	}
	/**
	 * 订单评论列表
	 * @param orderAssessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOrderAssessments")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getOrderAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean)
			throws Exception {
		return orderServiceC.getOrderAssessments(orderAssessmentBean, pageBean);
	}
	
}
