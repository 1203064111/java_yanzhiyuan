package tst.project.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.page.PageBean;


public interface IMemberServiceC {
	
	
	
	/**
	 * 获取任务列表
	 * @param taskClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getTaskClasses(TaskClassBean taskClassBean,PageBean pageBean);
	/**
	 * 修改任务
	 * @param taskClassBean
	 * @return
	 */
	public Object updateTaskClass(TaskClassBean taskClassBean);
	/**
	 * 删除任务
	 * @param taskClassBean
	 * @return
	 */
	public Object deleteTaskClass(TaskClassBean taskClassBean);
	/**
	 * 添加任务
	 * @param taskClassBean
	 * @return
	 */
	public Object insertTaskClass(TaskClassBean taskClassBean);
	/**
	 * 查看任务
	 * @param taskClassBean
	 * @return
	 */
	public Object getTaskClassDetail(TaskClassBean taskClassBean);
	
	public List<Map> exportMembers(MemberBean memberBean);
	/**
	 * 用户统计
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Map<String, Object> getMemberStatistics(MemberBean memberBean);
	
	
	/**
	 * 用户留言列表
	 * @author hwq
	 * @param adviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getAdvices(AdviceBean adviceBean, PageBean pageBean);
	
	/**
	 * 删除用户留言
	 * @author hwq
	 * @param adviceBean
	 * @return
	 */
	public Object deleteAdvice(AdviceBean adviceBean);
	
	/**
	 * 购买用户统计
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Map<String, Object> getMemberBuyStatistics(MemberBean memberBean);
	
	/**
	 * 商城新增用户统计(可按时间段查询)
	 * @author hwq
	 * @param memberBean
	 * @return
	 */
	public Object getMemberInsertCounts(MemberBean memberBean);
	
	/**
	 * 会员地区统计
	 * @author hwq
	 * @param addressBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberAddressCounts(AddressBean addressBean, PageBean pageBean);
	
	/**
	 * 添加用户
	 * @param memberBean
	 * @return
	 */
	Object insertMember(MemberBean memberBean);
	
	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	MemberBean getMemberDetail(MemberBean memberBean);

	/**
	 * 获得用户列表
	 * @param memberBean
	 * @return
	 */
	Object getMembers(MemberBean memberBean, PageBean pageBean);

	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	Object updateMemberDetail(MemberBean memberBean);

	/**
	 * 删除用户
	 * @param memberBean
	 * @return
	 */
	Object deleteMember(MemberBean memberBean);

	/**
	 * 查询用户地址
	 * @param addressBean
	 * @param pageBean
	 * @return
	 */
	Object getMemberAddress(AddressBean addressBean, PageBean pageBean);

	/**
	 * 获得用户银行卡
	 * @param bankCardBean
	 * @param pageBean
	 * @return
	 */
	Object getMemberBankCards(BankCardBean bankCardBean, PageBean pageBean);
	
	/**
	 * 用户列表（不分页）
	 * @param memberBean
	 * @return
	 */
	List<MemberBean> getMembersNoPage(MemberBean memberBean);
	

	
}
