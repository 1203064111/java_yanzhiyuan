package tst.project.dao.controller;
import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.PayDetailBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionClassesBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.ResumeSettingBean;
import tst.project.bean.information.SalaryBean;
import tst.project.page.PageBean;

@Mapper
public interface PositionDaoC {
	/**
	 * 根据职位id去找没有打款的简历列表
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionPersonsBean> getRequirePositionIsNotClose(PositionPersonsBean positionPersonsBean);
	/**
	 * 添加退款明细
	 * @param payDetailBean
	 * @return
	 */
	public int insertPayDetail(PayDetailBean payDetailBean);
	/**
	 * 修改商家给用户打款状态
	 * @param positionPersonsBean
	 * @return
	 */
	public int updatePositionPersonRemit(PositionPersonsBean positionPersonsBean);
	/**
	 * 获取职位的投递简历列表
	 * @param positionPersonsBean
	 * @param pageBean
	 * @return
	 */
	public List<Map> getRequirePositions(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	
	/**
	 * 获取单笔订单的所有支付明细
	 * @param payDetailBean
	 * @return
	 */
	public List<PayDetailBean> getPayDetails(PayDetailBean payDetailBean);
	/**
	 * 获取职位的所有工作类型列表
	 * @param positionClassesBean
	 * @return
	 */
	public List<PositionClassBean> getPositionClassNames(PositionClassesBean positionClassesBean);
	/**
	 * 获取职位列表
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public List<PositionBean> getPositions(PositionBean positionBean,PageBean pageBean);
	/**
	 * 审核职位
	 * @param positionBean
	 * @return
	 */
	public int updatePosition(PositionBean positionBean);
	
	/**
	 * 获取职位详细信息
	 * @param positionBean
	 * @return
	 */
	public PositionBean getPosition(PositionBean positionBean);
	/**
	 * 获取简历评分设置
	 * @param resumeSettingBean
	 * @return
	 */
	public List<ResumeSettingBean> getResumeSettings(ResumeSettingBean resumeSettingBean);
	/**
	 * 修改简历评分设置
	 * @param resumeSettingBean
	 * @return
	 */
	public int updateResumeSetting(ResumeSettingBean resumeSettingBean);
	/**
	 * 获取薪资列表
	 * @param salaryBean
	 * @param pageBean
	 * @return
	 */
	public List<SalaryBean> getSalarys(SalaryBean salaryBean,PageBean pageBean);
	/**
	 * 修改薪资
	 * @param salaryBean
	 * @return
	 */
	public int updateSalary(SalaryBean salaryBean);
	/**
	 * 删除薪资
	 * @param salaryBean
	 * @return
	 */
	public int deleteSalary(SalaryBean salaryBean);
	/**
	 * 添加薪资
	 * @param salaryBean
	 * @return
	 */
	public int insertSalary(SalaryBean salaryBean);
	/**
	 * 获取薪资
	 * @param salaryBean
	 * @return
	 */
	public SalaryBean getSalary(SalaryBean salaryBean);
	/**
	 * 获取工作类型列表
	 * @param positionClassBean
	 * @param pageBean
	 * @return
	 */
	public List<PositionClassBean> getPositionClasss(PositionClassBean positionClassBean,PageBean pageBean);
	/**
	 * 修改工作类型
	 * @param positionClassBean
	 * @return
	 */
	public int updatePositionClass(PositionClassBean positionClassBean);
	/**
	 * 删除工作类型
	 * @param positionClassBean
	 * @return
	 */
	public int deletePositionClass(PositionClassBean positionClassBean);
	/**
	 * 添加工作类型
	 * @param positionClassBean
	 * @return
	 */
	public int insertPositionClass(PositionClassBean positionClassBean);
	/**
	 * 获取工作类型
	 * @param positionClassBean
	 * @return
	 */
	public PositionClassBean getPositionClass(PositionClassBean positionClassBean);
	
	/**
	 * 获取认证列表
	 * @param materialBean
	 * @param pageBean
	 * @return
	 */
	public List<MaterialBean> getMaterials(MaterialBean materialBean,PageBean pageBean);
	/**
	 * 审核认证资料
	 * @param materialBean
	 * @return
	 */
	public int updateMaterial(MaterialBean materialBean);
	/**
	 * 获取认证详细资料
	 * @param materialBean
	 * @return
	 */
	public MaterialBean getMaterial(MaterialBean materialBean);
	
	/**
	 * 获取职位订单列表
	 * @param advertiseOrderBean
	 * @param pageBean
	 * @return
	 */
	public List<AdvertiseOrderBean> getAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean,PageBean pageBean);
	/**
	 * 修改职位订单打款状态
	 * @param advertiseOrderBean
	 * @return
	 */
	public int updateAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	
	/**
	 * 获取职位订单详细信息
	 * @param advertiseOrderBean
	 * @return
	 */
	public AdvertiseOrderBean getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 获取职位申请人列表
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionPersonsBean> getPositionPersonss(PositionPersonsBean positionPersonsBean);
}

