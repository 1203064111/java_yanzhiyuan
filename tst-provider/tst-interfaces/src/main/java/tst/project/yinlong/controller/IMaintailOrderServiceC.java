package tst.project.yinlong.controller;

import tst.project.bean.yinlong.MaintailOrderAddressBean;
import tst.project.bean.yinlong.MaintailOrderAssessmentBean;
import tst.project.bean.yinlong.MaintailOrderBean;
import tst.project.bean.yinlong.MaintailOrderMaterialBean;
import tst.project.page.PageBean;

public interface IMaintailOrderServiceC {
	/**
	 * 报修订单详情
	 * @author hxf
	 * @param maintailOrderBean
	 * @return
	 */
	public Object getMaintailOrderDetail(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 报修订单列表
	 * @author hxf
	 * @param maintailOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getMaintailOrders(MaintailOrderBean maintailOrderBean,PageBean pageBean);
	
	/**
	 * 给订单分配维修师傅
	 * 
	 * @param orderBean
	 * @return
	 */
	public Object sendOrder(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 获得订单评价
	 * @param maintailOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderAssessments(MaintailOrderAssessmentBean maintailOrderAssessmentBean,PageBean pageBean);
	
	/**
	 * 获得订单评价详情
	 * @author hxf
	 * @param maintailOrderAssessmentBean
	 * @return
	 */
	public Object getOrderAssessmentDetail(MaintailOrderAssessmentBean maintailOrderAssessmentBean);
	
	/**
	 * 删除订单评价
	 * @author hxf
	 * @param maintailOrderAssessmentBean
	 * @return
	 */
	public Object deleteOrderAssessment(MaintailOrderAssessmentBean maintailOrderAssessmentBean);
	
	/**
	 * 根据订单状态获取每个状态的订单数
	 * @author hxf
	 * @param maintailOrderBean
	 * @return
	 */
	public Object getOrderStateCount(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 创建订单
	 * @author hxf
	 * @param maintailOrderBean
	 * @return
	 */
	public Object insertMaintailOrder(MaintailOrderBean maintailOrderBean,MaintailOrderAddressBean maintailOrderAddressBean,MaintailOrderMaterialBean maintailOrderMaterialBean);
	
	/**
	 * 修改维修材料订单详情
	 * @author hxf
	 * @param maintailOrderMaterialBean
	 * @return
	 */
	public Object updateMaintailOrderMaterial(MaintailOrderMaterialBean maintailOrderMaterialBean);
}
