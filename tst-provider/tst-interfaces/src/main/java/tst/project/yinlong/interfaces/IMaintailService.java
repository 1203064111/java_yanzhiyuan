package tst.project.yinlong.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.yinlong.MaintailMaterialBean;
import tst.project.bean.yinlong.MaintailOrderAddressBean;
import tst.project.bean.yinlong.MaintailOrderAssessmentBean;
import tst.project.bean.yinlong.MaintailOrderBean;
import tst.project.bean.yinlong.MaintailOrderInvoiceBean;
import tst.project.bean.yinlong.MaintailOrderMaterialBean;
import tst.project.bean.yinlong.MaintailPartsBean;
import tst.project.bean.yinlong.MaintailServiceTimeBean;
import tst.project.bean.yinlong.MaintailVillageBean;
import tst.project.page.PageBean;

public interface IMaintailService {
	
	/**
	 * 申请发票
	 * @author sjb
	 * @return
	 */
	public Object insertMaintailOrderInvoice(MaintailOrderInvoiceBean maintailOrderInvoiceBean);
	
	/**
	 * 发票详情
	 * @author hxf
	 * @param maintailOrderInvoiceBean
	 * @return
	 */
	public Object getMaintailOrderInvoiceDetail(MaintailOrderInvoiceBean maintailOrderInvoiceBean);
	
	/**
	 * 发票记录
	 * @author sjb
	 * @param maintailOrderInvoiceBean
	 * @param pageBean
	 * @return
	 */
	public Object getMaintailOrderInvoices(MaintailOrderInvoiceBean maintailOrderInvoiceBean,PageBean pageBean);
	
	/**
	 * 删除订单
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object deleteMaintailOrder(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 微信支付回调
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object wxCallback(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 小程序支付订单
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object payMaintailOrder(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 评价订单
	 * @author sjb
	 * @param maintailOrderAssessmentBean
	 * @return
	 */
	public Object insertMaintailOrderAssessment(MaintailOrderAssessmentBean maintailOrderAssessmentBean);
	
	/**
	 * 师傅拒绝接单
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object refuseWorkerOrder(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 材料列表
	 * @author sjb
	 * @param maintailOrderMaterialBeans
	 * @param pageBean
	 * @return
	 */
	public Object getMaintailMaterials(MaintailMaterialBean maintailOrderMaterialBeans,PageBean pageBean);
	
	/**
	 * 用户拒绝师傅填写的材料报价
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object refuseMaintailOrder(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 用户接受师傅填写的材料报价
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object acceptMaintailOrder(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 师傅提交维修材料接口
	 * @author sjb
	 * @param maintailOrderMaterialBeans
	 * @return
	 */
	public Object insertMaintailOrderMaterials(MaintailOrderBean maintailOrderBean,List<MaintailOrderMaterialBean> maintailOrderMaterialBeans);
	
	/**
	 * 取消报修订单
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object cancelMaintailOrder(MaintailOrderBean maintailOrderBean);
	/**
	 * 师傅订单列表
	 * @author sjb
	 * @param maintailOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getWorkerOrders(MaintailOrderBean maintailOrderBean,PageBean pageBean);
	
	/**
	 * 报修订单列表
	 * @author sjb
	 * @param maintailOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getMaintailOrders(MaintailOrderBean maintailOrderBean,PageBean pageBean);
	
	/**
	 * 报修订单详情
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object getMaintailOrderDetail(MaintailOrderBean maintailOrderBean);
	
	/**
	 * 报修下单
	 * @author sjb
	 * @param maintailOrderBean
	 * @return
	 */
	public Object insertMaintailOrder(MaintailOrderBean maintailOrderBean,MaintailOrderAddressBean maintailOrderAddressBean);
	
	/**
	 * 获得服务的小区列表
	 * @author sjb
	 * @param maintailVillageBean
	 * @return
	 */
	public Object getMaintailVillages(MaintailVillageBean maintailVillageBean,String latitual,String longitual);
	
	/**
	 * 搜索小区
	 * @author sjb
	 * @param maintailVillageBean
	 * @param pageBean
	 * @return
	 */
	public Object searchMaintailVillages(MaintailVillageBean maintailVillageBean,PageBean pageBean);
	
	/**
	 * 获得维修区域
	 * @author sjb
	 * @param maintailPartsBean
	 * @return
	 */
	public List<MaintailPartsBean> getMaintailPartss(MaintailPartsBean maintailPartsBean);
	
	/**
	 * 获得维修的服务时间
	 * @author sjb
	 * @param maintailServiceTimeBean
	 * @return
	 */
	public List<Map<String,Object>> getMaintailServiceTimes(MaintailServiceTimeBean maintailServiceTimeBean);
	
	
	
}
