package tst.project.interfaces;



import java.util.List;

import tst.project.bean.CodeBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberIntegralOrderBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.sheep.MemberCoinSourceBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.bean.sheep.MemberTaskBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.page.PageBean;

public interface IMemberService {
	
	/**
	 * 获取用户完成的任务情况
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object getTasksByMember(TaskClassBean taskClassBean,PageBean pageBean);
	/**
	 * 用户点击领取分享任务奖励
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object updateInfoTask(MemberTaskBean memberTaskBean);
	
	/**
	 * 通过用户id获取分享任务进度
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object getInfoTaskByMember(MemberTaskBean memberTaskBean);
	/**
	 * 用户点击领取实名任务奖励
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object updateRealTask(MemberTaskBean memberTaskBean);
	
	/**
	 * 通过用户id获取实名认证任务进度
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object getRealTaskByMember(MemberTaskBean memberTaskBean);
	/**
	 * 用户点击领取回复任务奖励
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object updateAnswerTask(MemberTaskBean memberTaskBean);
	
	/**
	 * 通过用户id获取回复任务进度
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object getAnswerTaskByMember(MemberTaskBean memberTaskBean);
	/**
	 * 用户点击领取分享任务奖励
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object updateShareTask(MemberTaskBean memberTaskBean);
	
	/**
	 * 通过用户id获取分享任务进度
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object getShareTaskByMember(MemberTaskBean memberTaskBean);
	/**
	 * 用户点击领取任务奖励
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object updateTaskByType(MemberTaskBean memberTaskBean);
	/**
	 * 通过用户id获取发帖任务详情
	 * @author lx
	 * @param memberTaskBean
	 * @return
	 */
	public Object getSendTaskByMember(MemberTaskBean memberTaskBean);
	
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
	 * 退出登录
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Object outLogin(MemberBean memberBean);
	
	/**
	 * 获得支付宝的登录凭证
	 * @author sjb
	 * @return
	 */
	public Object getAlipayCharge();
	/**
	 * 获得用户的消息详情
	 * @author sjb
	 * @param memberMsgBean
	 * @return
	 */
	Object getMemberMsgDetail(MemberMsgBean memberMsgBean);
	
	/**
	 * 公众号充值积分回调
	 * @param order_no
	 * @param sign
	 * @return
	 */
	Object wxpayMemberIntegralOrder(String order_no,String transaction_id,String cash_fee,String sign);
	
	/**
	 * 用户添加积分订单
	 * @param pageBean
	 * @return
	 */
	Object insertMemberIntegralOrder(MemberIntegralOrderBean memberIntegralOrderBean);
	

	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	MemberBean getMemberDetail(MemberBean memberBean);
	
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	int updateMemberDetail(MemberBean memberBean);

	/**
	 * 用户注册
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object registerMember(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 用户登录
	 * @param memberBean
	 * @return
	 */
	Object loginMember(MemberBean memberBean);

	/**
	 * 验证码用户登录
	 * @param memberBean
	 * @return
	 */
	Object CodeLoginMember(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 微信用户登录
	 * @param memberBean
	 * @return
	 */
	Object wxLoginMember(MemberBean memberBean,String code);
	
	/**
	 * 微信小程序用户登录
	 * @param memberBean
	 * @return
	 */
	Object wxLiteLoginMember(String code,String is_bind_mobile);
	
	/**
	 * 微信小程序绑定手机号
	 * @author sjb
	 * @param memberBean
	 * @param codeBea
	 * @return
	 */
	Object wxLitBindMobile(MemberBean memberBean,CodeBean codeBea);

	/**
	 * 支付宝app登录
	 * @author sjb
	 * @return
	 */
	Object alipayAppLoginMember(String auth_code);
	
	
	/**
	 * 支付宝绑定手机号
	 * @param memberBean
	 * @return
	 */
	Object alipayAppBindMobile(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 微信app登录
	 * @param memberBean
	 * @return
	 */
	Object wxAppLoginMember(MemberBean memberBean);
	
	/**
	 * 微信app绑定手机号
	 * @param memberBean
	 * @return
	 */
	Object wxAppBindMobile(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 微博App登录
	 * @author lx
	 * @param memberBean
	 * @return
	 */
	Object weiboAppLoginMember(MemberBean memberBean);
	/**
	 * 微博绑定手机号
	 * @author lx
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object weiboAppBindMobile(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * qqApp登录
	 * @author lx
	 * @param memberBean
	 * @return
	 */
	Object qqAppLoginMember(MemberBean memberBean);
	/**
	 *qqApp绑定手机号
	 * @author lx
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object qqAppBindMobile(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 忘记密码
	 * @param memberBean
	 * @return
	 */
	Object forgetPassword(MemberBean memberBean, CodeBean codeBean);
	
	/**
	 * 设置支付密码
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object payPassword(MemberBean memberBean, CodeBean codeBean);
	
	/**
	 * 绑定银行卡
	 * @param bankCardBean
	 * @return
	 */
	Object insertBankCard(BankCardBean bankCardBean);

	/**
	 * 银行卡解除绑定
	 * @param bankCardBean
	 * @return
	 */
	Object deleteBankCard(BankCardBean bankCardBean);

	/**
	 * 获得银行卡列表
	 * @param bankCardBean
	 * @return
	 */
	Object getBankCards(BankCardBean bankCardBean);

	/**
	 * 获得银行卡详情
	 * @param bankCardBean
	 * @return
	 */
	Object getBankCardDetail(BankCardBean bankCardBean);

	/**
	 * 修改银行卡详情
	 * @param bankCardBean
	 * @return
	 */
	Object updateBankCardDetail(BankCardBean bankCardBean);

	/**
	 * 添加个人消息
	 * @author gxq
	 * @param memberMsgBean
	 * @return
	 */
	int insertMemberMsg(MemberMsgBean memberMsgBean);

	/**
	 * 获取个人消息
	 * @author gxq
	 * @param memberMsgBean
	 * @param pageBean
	 * @return
	 */
	Object getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean);



	/**
	 * 查看个人消息
	 * @author lx
	 * @param memberMsgBean
	 * @return
	 */
	MemberMsgBean getMemberMsgsDetail(MemberMsgBean memberMsgBean);

	/**
	 * 消息类型列表
	 * @author lx
	 * @param msgTypeBean
	 * @return
	 */
	MsgTypeBean getMsgType(MsgTypeBean msgTypeBean);
	
	/**
	 * 用户列表
	 * @author gxq
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public Object getMembers(MemberBean memberBean, PageBean pageBean);
	/**
	 * 消息统计
	 * @author lx
	 * @param memberMsgBean
	 * @return
	 */
	public Object getMsgCount(MemberMsgBean memberMsgBean);
	

}
