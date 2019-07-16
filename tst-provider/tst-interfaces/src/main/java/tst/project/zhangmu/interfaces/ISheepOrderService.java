package tst.project.zhangmu.interfaces;


import java.util.Map;

import tst.project.bean.sheep.MemberAssessBean;
import tst.project.bean.sheep.MemberCoinBean;
import tst.project.bean.sheep.MemberGroupBean;
import tst.project.bean.sheep.OrderSheepBean;
import tst.project.bean.sheep.SheepHtmlBean;
import tst.project.bean.sheep.ShopGoodsBean;
import tst.project.bean.shop.OrderLogisticsDetailBean;
import tst.project.page.PageBean;

public interface ISheepOrderService {


	/**
	 * 添加订单
	 * @param OrderSheepBean
	 * @return
	 */
	public Object insertOrder(OrderSheepBean OrderSheepBean)throws Exception;

	/**
	 * 更新订单
	 * 
	 */
	public Object updateOrderDetail(OrderSheepBean orderSheepBean);
	
	/**
	 * 商品订单回调
	 * @author lx
	 * @param pay_no
	 * @param string
	 * @return
	 */
	public Object payGoodsOrder(String pay_no, String string);

	/**
	 * 羊只订单回调
	 * @param pay_no
	 * @param string
	 * @return
	 */
	public Object paySuccessOrder(String pay_no, String pay_way);

	/**
	 * 支付模拟
	 * @param orderSheepBean
	 * @return
	 */
	public Object PayOrder(OrderSheepBean orderSheepBean);

	/**
	 * 订单列表
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrders(OrderSheepBean orderBean, PageBean pageBean);

	/**
	 * 订单统计
	 * @param orderSheepBean
	 * @return
	 */
	public Map<String,String> getOrderCount(OrderSheepBean orderSheepBean);

	/**
	 * 订单详情
	 * @param orderSheepBean
	 * @return
	 */
	public OrderSheepBean getOrderDetail(OrderSheepBean orderSheepBean);

	/**
	 * 评价订单
	 * @param memberAssessBean
	 * @return
	 */
	public int assessOrder(MemberAssessBean memberAssessBean);

	/**
	 * 获得评价列表
	 * @param memberAssessBean
	 * @param pageBean
	 * @return
	 */
	public Object getSheepAssessments(MemberAssessBean memberAssessBean, PageBean pageBean);

	/**
	 * 查看物流
	 * @author lx
	 * @param orderLogisticsDetailBean
	 * @return
	 */
	public Object getlogistics(OrderLogisticsDetailBean orderLogisticsDetailBean);

	/**
	 * 
	 * @author lx
	 * @param sheepHtmlBean
	 * @return
	 */
	public SheepHtmlBean getHtml(SheepHtmlBean sheepHtmlBean);

	/**
	 * 余额支付
	 * @author lx
	 * @param orderBean
	 * @return
	 */
	public Object balancePay(OrderSheepBean orderBean);

	/**
	 * 计算订单价格
	 * @author lx
	 * @return
	 */
	public Map<String,String> getOrderPrice(OrderSheepBean orderSheepBean)throws Exception;

	/**
	 * 真实支付
	 * @author lx
	 * @param orderSheepBean
	 * @return
	 */
	public Object payRealOrder(OrderSheepBean orderSheepBean);

	

	/**
	 * 换购商品
	 * @author lx
	 * @param parseObject
	 * @return
	 */
	public Object insertGoodsOrder(OrderSheepBean orderSheepBean);

	/**
	 * 微信公众号支付
	 * @author lx
	 * @param orderSheepBean
	 * @param wxopen_id
	 * @return
	 */
	public Object wxPubPay(OrderSheepBean orderSheepBean);

	/**
	 * 取消订单
	 * @author lx
	 * @param orderSheepBean
	 * @return
	 */
	public Object cancelOrder(OrderSheepBean orderSheepBean);

	/**
	 * 取消团购订单
	 * @author lx
	 * @param sheepGroupBean
	 * @return
	 */
	public Object cancelGroupOrder(OrderSheepBean orderSheepBean);


	/**
	 * 自动拼单定时
	 * @author lx
	 * @param orderSheepBean
	 * @return
	 */
	public Object GroupOrderTimer(MemberGroupBean memberGroupBean);

	

	

}
