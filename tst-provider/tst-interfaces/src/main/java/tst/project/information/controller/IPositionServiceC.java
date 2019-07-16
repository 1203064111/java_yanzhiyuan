package tst.project.information.controller;

import java.util.List;

import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.ResumeSettingBean;
import tst.project.bean.information.SalaryBean;
import tst.project.page.PageBean;

public interface IPositionServiceC {
	/**
	 * 修改商家给用户打款状态
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object updatePositionPersonRemit(PositionPersonsBean positionPersonsBean);
	
	/**
	 * 获取职位的投递简历列表
	 * @author lx
	 * @param positionPersonsBean
	 * @param pageBean
	 * @return
	 */
	public Object getRequirePositions(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	/**
	 * 获取职位订单列表
	 * @author lx
	 * @param advertiseOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean, PageBean pageBean);
	/**
	 * 获取职位订单详细信息
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 修改职位订单打款状态
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object updateAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 获取认证资料列表
	 * @author lx
	 * @param materialBean
	 * @param pageBean
	 * @return
	 */
	public Object getMaterials(MaterialBean materialBean, PageBean pageBean);
	/**
	 * 获取认证详细资料
	 * @author lx
	 * @param materialBean
	 * @return
	 */
	public Object getMaterial(MaterialBean materialBean);
	/**
	 * 审核认证资料
	 * @author lx
	 * @param materialBean
	 * @return
	 */
	public Object updateMaterial(MaterialBean materialBean);
	/**
	 * 获取工作类型列表
	 * @author lx
	 * @param positionClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getPositionClasss(PositionClassBean positionClassBean, PageBean pageBean);
	/**
	 * 获取工作类型
	 * @author lx
	 * @param positionClassBean
	 * @return
	 */
	public Object getPositionClass(PositionClassBean positionClassBean);
	/**
	 * 修改工作类型
	 * @author lx
	 * @param positionClassBean
	 * @return
	 */
	public Object updatePositionClass(PositionClassBean positionClassBean);
	/**
	 * 添加工作类型
	 * @author lx
	 * @param positionClassBean
	 * @return
	 */
	public Object insertPositionClass(PositionClassBean positionClassBean);
	/**
	 * 删除工作类型
	 * @author lx
	 * @param positionClassBean
	 * @return
	 */
	public Object deletePositionClass(PositionClassBean positionClassBean);
	/**
	 * 获取简历评分设置
	 * @author lx
	 * @param resumeSettingBean
	 * @return
	 */
	public Object getResumeSettings(ResumeSettingBean resumeSettingBean);
	/**
	 * 修改简历评分设置
	 * @author lx
	 * @param resumeSettingBean
	 * @return
	 */
	public Object updateResumeSetting(List<ResumeSettingBean> resumeSettingBeans);
	/**
	 * 获取薪资列表
	 * @author lx
	 * @param salaryBean
	 * @param pageBean
	 * @return
	 */
	public Object getSalarys(SalaryBean salaryBean, PageBean pageBean);
	/**
	 * 获取薪资
	 * @author lx
	 * @param salaryBean
	 * @return
	 */
	public Object getSalary(SalaryBean salaryBean);
	/**
	 * 修改薪资
	 * @author lx
	 * @param salaryBean
	 * @return
	 */
	public Object updateSalary(SalaryBean salaryBean);
	/**
	 * 添加薪资
	 * @author lx
	 * @param salaryBean
	 * @return
	 */
	public Object insertSalary(SalaryBean salaryBean);
	/**
	 * 删除薪资
	 * @author lx
	 * @param salaryBean
	 * @return
	 */
	public Object deleteSalary(SalaryBean salaryBean);
	/**
	 * 获取职位列表
	 * @author lx
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public Object getPositions(PositionBean positionBean, PageBean pageBean);
	/**
	 * 获取职位详细信息
	 * @author lx
	 * @param positionBean
	 * @return
	 */
	public Object getPosition(PositionBean positionBean);
	/**
	 * 上下线职位
	 * @author lx
	 * @param positionBean
	 * @return
	 */
	public Object updatePosition(PositionBean positionBean);
	
	
	

}
