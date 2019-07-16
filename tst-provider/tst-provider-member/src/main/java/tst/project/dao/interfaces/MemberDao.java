package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.CodeBean;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.ShareRelationBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.CertificationBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberIntegralOrderBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.bean.sheep.MemberTaskBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.page.PageBean;
import tst.project.page.PageBean;

@Mapper
public interface MemberDao {
	
	/**
	 * 获取比例
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercentDetail(PercentBean percentBean);
	/**
	 * 获取任务详情
	 * @param taskClassBean
	 * @return
	 */
	public TaskClassBean getTaskClass(TaskClassBean taskClassBean);
	
	/**
	 * 获取所有的任务
	 * @param taskClassBean
	 * @return
	 */
	public List<TaskClassBean> getTaskClasses(TaskClassBean taskClassBean,PageBean pageBean);
	/**
	 * 修改发帖领取记录
	 * @param memberTaskBean
	 * @return
	 */
	public int updateMemberTask(MemberTaskBean memberTaskBean);
	/**
	 * 添加发帖领取记录
	 * @param memberTaskBean
	 * @return
	 */
	public int insertMemberTask(MemberTaskBean memberTaskBean);
	/**
	 * 获取今日发帖的次数
	 * @param systemInformationBean
	 * @return
	 */
	public Map<String, Object> getSystemInformationCount(SystemInformationBean systemInformationBean);
	
	/**
	 * 获取今日回答的次数
	 * @param informationAssessmentBean
	 * @return
	 */
	public Map<String, Object> getSystemInformationAnswerCount(InformationAssessmentBean informationAssessmentBean);
	/**
	 * 获取今日分享的次数
	 * @param shareRelationBean
	 * @return
	 */
	public Map<String, Object> getSystemInformationShareCount(ShareRelationBean shareRelationBean);
	
	/**
	 * 通过用户找到简历信息
	 * @param requirePositionBean
	 * @return
	 */
	public RequirePositionBean getRequirePositionByMember(RequirePositionBean requirePositionBean);
	
	/**
	 * 获取任务详情
	 * @param memberTaskBean
	 * @return
	 */
	public MemberTaskBean getTaskByMember(MemberTaskBean memberTaskBean);
	/**
	 * 同步后 修改状态
	 * @author sjb
	 * @param member_ids
	 * @return
	 */
	public int updateSynchronizationMembers(String member_ids);
	
	/**
	 * 获得需要同步的用户列表
	 * @author sjb
	 * @return
	 */
	public List<MemberBean> getSynchronizationMembers(MemberBean memberBean);
	
	
	/**
	 * 获得用户的消息详情
	 * @author sjb
	 * @param memberMsgBean
	 * @return
	 */
	MemberMsgBean getMemberMsgDetail(MemberMsgBean memberMsgBean);
	
	/**
	 * 修改用户充值积分订单详情
	 * @param memberIntegralOrderBean
	 * @return
	 */
	public int updateMemberIntegralOrderDetail(MemberIntegralOrderBean memberIntegralOrderBean);
	
	/**
	 * 用户充值积分下单
	 * @param memberIntegralOrderBean
	 * @return
	 */
	public int insertMemberIntegralOrder(MemberIntegralOrderBean memberIntegralOrderBean);	
	
	/**
	 * 用户充值订单详情
	 * @param memberIntegralOrderBean
	 * @return
	 */
	public MemberIntegralOrderBean getMemberIntegralOrderDetail(MemberIntegralOrderBean memberIntegralOrderBean);
	
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean);
	
//	public int updateMemberIntegral(MemberBean memberBean);
	
	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberDetail(MemberBean memberBean);
	
	
	/**
	 * 用户注册
	 * @param memberBean
	 * @return
	 */
	public int registerMember(MemberBean memberBean);
	
	/**
	 * 设置支付密码
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	public int payPassword(MemberBean memberBean);
	
	/**
	 * 添加银行卡
	 * @param bankCardBean
	 * @return
	 */
	public int insertBankCard(BankCardBean bankCardBean);
	
	/**
	 * 银行卡解除绑定
	 * @param bankCardBean
	 * @return
	 */
	public int deleteBankCard(BankCardBean bankCardBean);
	
	/**
	 * 获得银行卡列表
	 * @param bankCardBean
	 * @return
	 */
	public List<BankCardBean> getBankCards(BankCardBean bankCardBean);
	
	/**
	 * 获得银行卡详情
	 * @param bankCardBean
	 * @return
	 */
	public BankCardBean getBankCardDetail(BankCardBean bankCardBean);
	
	/**
	 * 修改银行卡详情
	 * @param bankCardBean
	 * @return
	 */
	public int updateBankCardDetail(BankCardBean bankCardBean);

	public int insertMemberMsg(MemberMsgBean memberMsgBean);

	public List<MemberMsgBean> getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean);

	public MemberMsgBean getMemberMsgsDetail(MemberMsgBean memberMsgBean);

	public int updateMemberMsgDetail(MemberMsgBean setMsg_id);

	public MsgTypeBean getMsgType(MsgTypeBean msgTypeBean);

	public List<MemberBean> getMembers(MemberBean memberBean, PageBean pageBean);

	public Map<String,String> getMsgCount(MemberMsgBean memberMsgBean);
	
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
	
}
