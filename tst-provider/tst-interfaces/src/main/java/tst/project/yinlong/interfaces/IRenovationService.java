package tst.project.yinlong.interfaces;

import tst.project.bean.yinlong.RenovationOrderBean;
import tst.project.bean.yinlong.RenovationStyleBean;
import tst.project.page.PageBean;

public interface IRenovationService {
	/**
	 * 订单详情
	 * @author sjb
	 * @param renovationOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getRenovationOrderDetail(RenovationOrderBean renovationOrderBean);
	
	
	/**
	 * 订单列表
	 * @author sjb
	 * @param renovationOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getRenovationOrders(RenovationOrderBean renovationOrderBean,PageBean pageBean);
	
	/**
	 * 付款回调
	 * @author sjb
	 * @param renovationOrderBean
	 * @return
	 */
	public Object wxCallback(RenovationOrderBean renovationOrderBean);
	
	/**
	 * 订单付款
	 * @author sjb
	 * @param renovationOrderBean
	 * @return
	 */
	public Object payRenovationOrder(RenovationOrderBean renovationOrderBean);
	
	/**
	 * 预约下单
	 * @author sjb
	 * @param renovationOrderBean
	 * @return
	 */
	public Object insertRenovationOrder(RenovationOrderBean renovationOrderBean);


	/**
	 * 装修风格列表
	 * @author sjb
	 * @param renovationStyleBean
	 * @return
	 */
	public Object getRenovationStyles(RenovationStyleBean renovationStyleBean);
	
	
}
