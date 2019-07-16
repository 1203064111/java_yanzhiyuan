package tst.project.yinlong.interfaces;

import tst.project.bean.yinlong.CustomizedBean;
import tst.project.bean.yinlong.CustomizedHuxingBean;
import tst.project.bean.yinlong.CustomizedHuxingProgrammeBean;
import tst.project.bean.yinlong.CustomizedOrderBean;
import tst.project.page.PageBean;

public interface ICustomizedService {
	
	/**
	 * 定制加配  订单详情
	 * @author sjb
	 * @param customizedOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getCustomizedOrderDetail(CustomizedOrderBean customizedOrderBean);
	
	/**
	 * 定制加配  订单列表
	 * @author sjb
	 * @param customizedOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getCustomizedOrders(CustomizedOrderBean customizedOrderBean,PageBean pageBean);
	
	/**
	 * 微信回调
	 * @author sjb
	 * @param customizedOrderBean
	 * @return
	 */
	public Object wxCallback(CustomizedOrderBean customizedOrderBean);
	
	/**
	 * 定制加配 获得支付凭证
	 * @author sjb
	 * @param customizedOrderBean
	 * @return
	 */
	public Object payCustomizedOrder(CustomizedOrderBean customizedOrderBean);
	
	/**
	 * 定制加配 下单
	 * @author sjb
	 * @param customizedOrderBean
	 * @return
	 */
	public Object insertCustomizedOrder(CustomizedOrderBean customizedOrderBean);
	
	/**
	 * 定制加配  项目户型方案列表
	 * @author sjb
	 * @param customizedHuxingProgrammeBean
	 * @return
	 */
	public Object getCustomizedHuxingProgrammes(CustomizedHuxingProgrammeBean customizedHuxingProgrammeBean);
	
	/**
	 * 定制加配 项目户型列表
	 * @author sjb
	 * @param customizedHuxingBean
	 * @return
	 */
	public Object getCustomizedHuxings(CustomizedHuxingBean customizedHuxingBean);
	
	/**
	 * 定制加配 项目列表
	 * @author sjb
	 * @param customizedBean
	 * @param pageBean
	 * @return
	 */
	public Object getCustomizeds(CustomizedBean customizedBean,PageBean pageBean);
	
	
}
