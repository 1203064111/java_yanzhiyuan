package tst.project.dao.interfaces;
import java.util.List;
import java.util.Map;

import javax.swing.text.Position;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;

import com.alipay.api.domain.Material;

import tst.project.annotation.Mapper;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.AssessmentBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.MemberAssessmentBean;
import tst.project.bean.information.PayDetailBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionClassesBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.RequirePositionSalaryBean;
import tst.project.bean.information.ResumeSettingBean;
import tst.project.bean.information.SalaryBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.page.PageBean;

@Mapper
public interface PositionDao {
	/**
	 * 修改签到记录
	 * @param memberSignBean
	 * @return
	 */
	public int updateMemberSign(MemberSignBean memberSignBean);
	/**
	 * 添加签到记录
	 * @param memberSignBean
	 * @return
	 */
	public int insertMemberSign(MemberSignBean memberSignBean);
	/**
	 * 获取用户签到信息
	 * @param memberSignBean
	 * @return
	 */
	public MemberSignBean getMemberSignByMemberId(MemberSignBean memberSignBean);
	
	/**
	 * 通过身份证号获取信息
	 * @param materialBean
	 * @return
	 */
	public List<MaterialBean> getMaterialByIdCard(MaterialBean materialBean);
	/**
	 * 获取当前时间与结束时间相等的职位列表
	 * @param positionBean
	 * @return
	 */
	public List<PositionBean> getPositionByClose(PositionBean positionBean);
	
	/**
	 * 获取当前时间与结束时间相差12小时的职位列表
	 * @param positionBean
	 * @return
	 */
	public List<PositionBean> getPositionByClose2(PositionBean positionBean);
	/**
	 * 根据用户id和认证id查找评论
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getAssessmentByMemberAndMaterial(AssessmentBean assessmentBean);
	/**
	 * 获取投递人被订的职位列表
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionBean> getPositionPersonList(PositionPersonsBean positionPersonsBean);
	/**
	 * 通过用户id获取认证公司对用户的评论(这里的用户id到xml里用Member2_id接收)
	 * @param memberAssessmentBean
	 * @return
	 */
	public List<MemberAssessmentBean> getMemberAssessmentByMemberId(MemberAssessmentBean memberAssessmentBean);
	/**
	 * 根据简历id获取简历关联的薪资类型列表
	 * @param requirePositionBean
	 * @return
	 */
	public List<RequirePositionSalaryBean> getSalarysByRequireId(RequirePositionBean requirePositionBean);
	/**
	 * 根据简历id获取简历关联的岗位类型列表
	 * @param requirePositionBean
	 * @return
	 */
	public List<PositionClassesBean> getPositionClassesByRequireId(RequirePositionBean requirePositionBean);
	/**
	 * 通过用户id获取简历资料
	 * @param memberBean
	 * @return
	 */
	public List<RequirePositionBean> getRequirePositionByMemberId2(MemberBean memberBean);
	
	/**
	 * 通过用户id获取认证资料
	 * @param memberBean
	 * @return
	 */
	public List<MaterialBean> getMaterialByMemberId(MemberBean memberBean);
	
	/**
	 * 根据用户获取支付明细列表
	 * @param payDetailBean
	 * @return
	 */
	public List<PayDetailBean> getPayDetailsByMember(PayDetailBean payDetailBean);
	/**
	 * 通过认证id获取认证的素有职位列表
	 * @param materialBean
	 * @return
	 */
	public List<PositionBean> getPositionsByMaterialId(PositionBean positionBean);
	/**
	 * 获取公司的所有评论
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getAssessmentsByMaterial(AssessmentBean assessmentBean);
	/**
	 * 通过认证id修改认证资料
	 * @param materialBean
	 * @return
	 */
	public int updateMaterialById(MaterialBean materialBean);
	/**
	 * 通过认证id获取认证资料
	 * @param materialBean
	 * @return
	 */
	public MaterialBean getMaterialById(MaterialBean materialBean);
	/**
	 * 添加评论或者回复
	 * @param assessmentBean
	 * @return
	 */
	public int insertAssessment(AssessmentBean assessmentBean);
	/**
	 * 添加商家对用户的评论
	 * @param memberAssessmentBean
	 * @return
	 */
	public int insertMemberAssessment(MemberAssessmentBean memberAssessmentBean);
	/**
	 * 获取用户对公司的评论
	 * @param assessmentBean
	 * @return
	 */
	public AssessmentBean getAssessmentByMember(AssessmentBean assessmentBean);
	/**
	 * 获取商家是否对用户的评论
	 * @param memberAssessmentBean
	 * @return
	 */
	public MemberAssessmentBean getMemberAssessment(MemberAssessmentBean memberAssessmentBean);
	
	/**
	 * 用户-我的报名列表（已完成）
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionBean> getFinalPositionPersonsByMember(PositionPersonsBean positionPersonsBean);
	
	
	/**
	 * 已完成的金额汇总
	 * @param positionPersonsBean
	 * @return
	 */
	public PositionBean getFinalAmountByMember(PositionPersonsBean positionPersonsBean);
	
	/**
	 * 用户-我的报名列表（已录用）
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionBean> getMiddlePositionPersonsByMember(PositionPersonsBean positionPersonsBean);
	/**
	 * 用户-我的报名列表（未录用）
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionBean> getPositionPersonsByMember(PositionPersonsBean positionPersonsBean);
	
	
	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberDetail(MemberBean memberBean);
	
	/**
	 * 修改用户评论数
	 * @param memberBean
	 * @return
	 */
	public int updateMemberById(MemberBean memberBean);
	/**
	 * 修改银行卡或者支付宝信息
	 * @param bankCardBean
	 * @return
	 */
	public int updateBankCard(BankCardBean bankCardBean);
	/**
	 * 获取用户的银行卡或者支付宝信息
	 * @param bankCardBean
	 * @return
	 */
	public BankCardBean getBankCardByMemberId(BankCardBean bankCardBean);
	/**
	 * 获取邀请简历列表
	 * @param requirePositionBean
	 * @return
	 */
	public List<RequirePositionBean> getinvateRequirePositions(RequirePositionBean requirePositionBean);
	/**
	 * 添加银行卡或者支付宝信息
	 * @param bankCardBean
	 * @return
	 */
	public int insertBankCard(BankCardBean bankCardBean);
	/*
	 * 添加支付明细
	 */
	public int insertPayDetail(PayDetailBean payDetailBean);
	/**
	 * 职位的投递列表
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public List<RequirePositionBean> getPositionPersons(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	/**
	 * 获取招聘认证资料
	 * @param positionBean
	 * @return
	 */
	public MaterialBean getMaterial(PositionBean positionBean);
	/**
	 * 获取比例
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercentDetail(PercentBean percentBean);
	/**
	 * 获取简历比例
	 * @param resumeSettingBean
	 * @return
	 */
	public ResumeSettingBean getResumeSettingDetail(ResumeSettingBean resumeSettingBean);
	/**
	 * 获取所有职位信息列表
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public List<PositionBean> getPositions(PositionBean positionBean,PageBean pageBean);
	
	/**
	 * 搜索职位
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public List<PositionBean> searchPositions(PositionBean positionBean,PageBean pageBean);
	/**
	 * 搜索简历
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 */
	public List<RequirePositionBean> searchRequirePositions(RequirePositionBean requirePositionBean,PageBean pageBean);
	
	/**
	 * 获取职位下的所有岗位列表
	 * @param positionClassBean
	 * @return
	 */
	public List<PositionClassBean> getPositionClassNames(PositionClassesBean positionClassesBean);
	
	/**
	 * 获取简历的所有薪资列表
	 * @param requirePositionSalaryBean
	 * @return
	 */
	public List<SalaryBean> getSalaryNames(RequirePositionSalaryBean requirePositionSalaryBean);
	
	
	/**
	 * 获取职位/简历关联对应的岗位列表
	 * @param positionBean
	 * @return
	 */
	public List<PositionClassesBean> getPositionClassess(PositionClassesBean positionClassesBean);
	
	/**
	 * 获取职位对应的申请人列表
	 * @param positionPersonsBean
	 * @return
	 */
	public List<PositionPersonsBean> getPositionPersonss(PositionPersonsBean positionPersonsBean);
	/**
	 * 获取职位投递记录
	 * @param positionPersonsBean
	 * @return
	 */
	public PositionPersonsBean getPositionPerson(PositionPersonsBean positionPersonsBean);
	/**
	 * 同意线下支付
	 * @param positionPersonsBean
	 * @return
	 */
	public int agreeOfflinePositionPerson(PositionPersonsBean positionPersonsBean);
	
	public int updatePosition(PositionBean positionBean);
	
	public int deletePosition(PositionBean positionBean);
	/**
	 * 添加职位信息
	 * @param positionBean
	 * @return
	 */
	public int insertPosition(PositionBean positionBean);
	
	/**
	 * 获取职位详细信息
	 * @param positionBean
	 * @return
	 */
	public PositionBean getPosition(PositionBean positionBean);
	

	/**
	 * 添加职位或者简历关联的岗位类型
	 * @param positionClassesBean
	 * @return
	 */
	public int insertPositionClasses(PositionClassesBean positionClassesBean);
	
	/**
	 * 删除职位或者简历关联的岗位类型
	 * @param positionClassesBean
	 * @return
	 */
	public int deletePositionClasses(PositionClassesBean positionClassesBean);
	/**
	 * 添加职位订单信息
	 * @param advertiseOrderBean
	 * @return
	 */
	public int insertAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 添加尾款订单
	 * @param advertiseOrderBean
	 * @return
	 */
	public int insertFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	
	/**
	 * 修改订单
	 * @param advertiseOrderBean
	 * @return
	 */
	public int updateAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 支付订单
	 * @param advertiseOrderBean
	 * @return
	 */
	public int payAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	
	
	/**
	 * 获取订单
	 * @param advertiseOrderBean
	 * @return
	 */
	public AdvertiseOrderBean getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	
	/**
	 * 职位定人状态修改
	 * @param positionPersonsBean
	 * @return
	 */
	public int updatePositionPersons(PositionPersonsBean positionPersonsBean);
	/**
	 * 删除职位申请
	 * @param positionPersonsBean
	 * @return
	 */
	public int deletePositionPersons(PositionPersonsBean positionPersonsBean);
	/**
	 * 添加职位申请
	 * @param positionPersonsBean
	 * @return
	 */
	public int insertPositionPersons(PositionPersonsBean positionPersonsBean);
	
	
	/**
	 * 获取简历表列表
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 */
	public List<RequirePositionBean> getRequirePositions(RequirePositionBean requirePositionBean,PageBean pageBean);
	
	public int updateRequirePosition(RequirePositionBean requirePositionBean);
	
	public int deleteRequirePosition(RequirePositionBean requirePositionBean);
	/**
	 * 添加简历信息
	 * @param requirePositionBean
	 * @return
	 */
	public int insertRequirePosition(RequirePositionBean requirePositionBean);
	/**
	 * 删除简历关联的薪资层级
	 * @param requirePositionSalaryBean
	 * @return
	 */
	public int deleteRequirePositionSalary(RequirePositionSalaryBean requirePositionSalaryBean);
	/**
	 * 添加简历关联的薪资层级
	 * @param requirePositionSalaryBean
	 * @return
	 */
	public int insertRequirePositionSalary(RequirePositionSalaryBean requirePositionSalaryBean);
	/**
	 * 获取简历关联的薪资列表
	 * @param requirePositionSalaryBean
	 * @return
	 */
	public List<RequirePositionSalaryBean> getRequirePositionSalaries(RequirePositionSalaryBean requirePositionSalaryBean);
	
	/**
	 * 获取简历详细信息
	 * @param requirePositionBean
	 * @return
	 */
	public RequirePositionBean getRequirePosition(RequirePositionBean requirePositionBean);
	
	/**
	 * 通过用户id获取用户简历详细
	 * @param requirePositionBean
	 * @return
	 */
	public RequirePositionBean getRequirePositionByMemberId(RequirePositionBean requirePositionBean);
	/**
	 * 添加招聘认证信息
	 * @param materialBean
	 * @return
	 */
	public int insertMaterial(MaterialBean materialBean);
	
	/**
	 * 获取岗位列表
	 * @param positionClassBean
	 * @return
	 */
	public List<PositionClassBean> getPositionClasss(PositionClassBean positionClassBean);
	/**
	 * 获取薪资列表
	 * @param salaryBean
	 * @return
	 */
	public List<SalaryBean> getSalarys(SalaryBean salaryBean);

}

