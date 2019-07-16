package tst.project.information.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.AssessmentBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.MemberAssessmentBean;
import tst.project.bean.information.PayDetailBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.SalaryBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.page.PageBean;

public interface IPositionService {
	
	/**
	 * 用户每日签到
	 * @author lx
	 * @param memberSignBean
	 * @return
	 */
	public Object updateMemberSign(MemberSignBean memberSignBean);
	
	/**
	 * 获取用户签到信息
	 * @author lx
	 * @param memberSignBean
	 * @return
	 */
	public Object getMemberSignByMemberId(MemberSignBean memberSignBean);
	
	/**
	 * 根据用户获取认证资料
	 * @author lx
	 * @param memberBean
	 * @return
	 */
	public Object getMaterialByMemberId(MemberBean memberBean);
	/**
	 * 根据用户id获取所有认证公司对用户的评论
	 * @author lx
	 * @param memberAssessmentBean
	 * @return
	 */
	public Object getMemberAssessmentByMemberId(MemberAssessmentBean memberAssessmentBean,PageBean pageBean);
	
	/**
	 * 根据用户获取支付明细列表
	 * @author lx
	 * @param payDetailBean
	 * @return
	 */
	public Object getPayDetailsByMember(PayDetailBean payDetailBean,PageBean pageBean);
	/**
	 * 添加商家对用户的评论
	 * @author lx
	 * @param memberAssessmentBean
	 * @return
	 */
	public Object insertMemberAssessment(MemberAssessmentBean memberAssessmentBean);
	/**
	 * 根据认证id获取发布的所有职位列表
	 * @author lx
	 * @param positionBean
	 * @return
	 */
	public Object getPositionsByMaterialId(PositionBean positionBean,PageBean pageBean);
	/**
	 * 获取公司认证资料
	 * @author lx
	 * @param materialBean
	 * @return
	 */
	public Object getMaterialById(MaterialBean materialBean);
	/**
	 * 获取公司的所有评论列表
	 * @author lx
	 * @param assessmentBean
	 * @return
	 */
	public Object getAssessmentsByMaterial(AssessmentBean assessmentBean,PageBean pageBean);
	/**
	 * 添加评论
	 * @author lx
	 * @param assessmentBean
	 * @return
	 */
	public Object insertAssessment(AssessmentBean assessmentBean);
	/**
	 * 获取用户对公司的评论
	 * @author lx
	 * @param assessmentBean
	 * @return
	 */
	public Object getAssessmentByMember(AssessmentBean assessmentBean);
	/**
	 * 商家获取是否对用户评论
	 * @author lx
	 * @param memberAssessmentBean
	 * @return
	 */
	public Object getMemberAssessment(MemberAssessmentBean memberAssessmentBean);
	
	/**
	 * 用户-我的报名列表（已完成）
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object getFinalPositionPersonsByMember(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	
	/**
	 * 已完成的金额汇总
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object getFinalAmountByMember(PositionPersonsBean positionPersonsBean);
	
	
	/**
	 * 用户-我的报名列表（已录用）
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object getMiddlePositionPersonsByMember(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	/**
	 * 用户-我的报名列表（未录用）
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object getPositionPersonsByMember(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	
	/**
	 * 简历邀请
	 * @author lx
	 * @param position_id
	 * @param require_position_id
	 * @return
	 */
	public Object inviteRequirePosition(String position_id,String require_position_id);
	
	/**
	 * 获取简历邀请列表
	 * @author lx
	 * @param requirePositionBean
	 * @return
	 */
	public Object getinvateRequirePositions(RequirePositionBean requirePositionBean,PageBean pageBean);
	/**
	 * 获取订单详情
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public AdvertiseOrderBean getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 获取职位投递记录
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public PositionPersonsBean getPositionPerson(PositionPersonsBean positionPersonsBean);
	
	/**
	 * 职位的投递人员列表
	 * @author lx
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public Object getPositionPersons(PositionPersonsBean positionPersonsBean,PageBean pageBean);
	/**
	 * 获取职位的认证资料
	 * @author lx
	 * @param positionBean
	 * @return
	 */
	public Object getMaterial(PositionBean positionBean);
	
	/**
	 * 计算订单首次付款价格
	 * @author lx
	 * @param invitation_num
	 * @param price
	 * @return
	 */
	public Object getAdvertiseOrderPay(String invitation_num,String price);
	/**
	 * 获取所有职位信息列表
	 * @author lx
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public Object getPositions(PositionBean positionBean, PageBean pageBean);
	/**
	 * 关键字搜索职位
	 * @author lx
	 * @param positionBean
	 * @param pageBean
	 * @return
	 */
	public Object searchPositions(PositionBean positionBean,PageBean pageBean);
	
	
	/**
	 * 关键字搜索简历信息
	 * @author lx
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 */
	public Object searchRequirePositions(RequirePositionBean requirePositionBean,PageBean pageBean); 
	
	/**
	 * 获取岗位列表
	 * @author lx
	 * @param positionClassBean
	 * @return
	 */
	public Object getPositionClasss(PositionClassBean positionClassBean);
	/**
	 * 获取薪资列表
	 * @author lx
	 * @param salaryBean
	 * @return
	 */
	public Object getSalarys(SalaryBean salaryBean);
	/**
	 * 获取职位详细信息
	 * @author lx
	 * @param positionBean
	 * @return
	 */
	public Object getPosition(PositionBean positionBean);
	
	public Object updatePosition(PositionBean positionBean);
	/**
	 * 添加职位信息
	 * @author lx
	 * @param positionBean
	 * @return
	 */
	public Object insertPosition(PositionBean positionBean);
	/**
	 * 发布职位订单
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object insertAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 添加尾款订单
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object insertFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	
	/**
	 * 支付定金订单
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object payRealAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	/**
	 * 支付发布订单
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object payFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean);
	
	public Object deletePosition(PositionBean positionBean);
	
	
	public Object getPositionPersonss(PositionPersonsBean positionPersonsBean);
	/**
	 * 修改定人状态
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object updatePositionPersons(PositionPersonsBean positionPersonsBean);
	/**
	 * 同意线下支付
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object agreeOfflinePositionPerson(PositionPersonsBean positionPersonsBean);
	/**
	 * 添加职位申请
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object insertPositionPersons(PositionPersonsBean positionPersonsBean);
	/**
	 * 删除职位申请
	 * @author lx
	 * @param positionPersonsBean
	 * @return
	 */
	public Object deletePositionPersons(PositionPersonsBean positionPersonsBean);
	/**
	 * 获取简历信息表列表
	 * @author lx
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 */
	public Object getRequirePositions(RequirePositionBean requirePositionBean, PageBean pageBean);
	/**
	 * 获取简历详细信息
	 * @author lx
	 * @param requirePositionBean
	 * @return
	 */
	public Object getRequirePosition(RequirePositionBean requirePositionBean);
	/**
	 * 通过用户id获取用户简历详细
	 * @author lx
	 * @param requirePositionBean
	 * @return
	 */
	public Object getRequirePositionByMemberId(RequirePositionBean requirePositionBean);
	
	/**
	 * 修改简历
	 * @author lx
	 * @param requirePositionBean
	 * @return
	 */
	public Object updateRequirePosition(RequirePositionBean requirePositionBean);
	/**
	 * 修改银行卡或者支付宝信息
	 * @author lx
	 * @param bankCardBean
	 * @return
	 */
	public Object updateBankCard(BankCardBean bankCardBean);
	/**
	 * 通过用户id获取银行卡或者支付宝信息
	 * @author lx
	 * @param bankCardBean
	 * @return
	 */
	public Object getBankCardByMemberId(BankCardBean bankCardBean);
	
	/**
	 * 添加银行卡或者支付宝信息
	 * @author lx
	 * @param bankCardBean
	 * @return
	 */
	public Object insertBankCard(BankCardBean bankCardBean);
	/**
	 * 添加简历信息
	 * @author lx
	 * @param requirePositionBean
	 * @return
	 */
	public Object insertRequirePosition(RequirePositionBean requirePositionBean);
	
	public Object deleteRequirePosition(String  require_position_ids);
	/**
	 * 添加招聘认证信息
	 * @author lx
	 * @param materialBean
	 * @return
	 */
	public Object insertMaterial(MaterialBean materialBean);
	/**
	 * 修改认证信息
	 * @author lx
	 * @param materialBean
	 * @return
	 */
	public Object updateMaterial(MaterialBean materialBean);
	
	/**
	 * 订单支付回调方法
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object payOrderCallback(AdvertiseOrderBean advertiseOrderBean);
	
	/**
	 * 定时查看职位时间并关闭该职位
	 * @author lx
	 * @param advertiseOrderBean
	 * @return
	 */
	public Object timeingCloseOrders(AdvertiseOrderBean advertiseOrderBean);

}
