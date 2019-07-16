package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.page.PageBean;

@Mapper
public interface MemberDaoC {
	
	/**
	 * 获取任务列表
	 * @param taskClassBean
	 * @param pageBean
	 * @return
	 */
	public List<TaskClassBean> getTaskClasses(TaskClassBean taskClassBean,PageBean pageBean);
	/**
	 * 修改任务
	 * @param taskClassBean
	 * @return
	 */
	public int updateTaskClass(TaskClassBean taskClassBean);
	/**
	 * 删除任务
	 * @param taskClassBean
	 * @return
	 */
	public int deleteTaskClass(TaskClassBean taskClassBean);
	/**
	 * 添加任务
	 * @param taskClassBean
	 * @return
	 */
	public int insertTaskClass(TaskClassBean taskClassBean);
	/**
	 * 查看任务
	 * @param taskClassBean
	 * @return
	 */
	public TaskClassBean getTaskClassDetail(TaskClassBean taskClassBean);
	/**
	 * 导出用户信息
	 * @param memberBean
	 * @return
	 */
	public List<Map> exportMembers(MemberBean memberBean);
	/**
	 * 购买用户统计
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Map<String, Object> getMemberBuyStatistics(MemberBean memberBean);
	
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
	public List<AdviceBean> getAdvices(AdviceBean adviceBean, PageBean pageBean);
	
	/**
	 * 删除用户留言
	 * @author hwq
	 * @param adviceBean
	 * @return
	 */
	public int deleteAdvice(AdviceBean adviceBean);
	
	/**
	 * 商城新增用户统计(可按时间段查询)
	 * @author hwq
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberInsertCounts(MemberBean memberBean);
	
	/**
	 * 会员地区统计
	 * @author hwq
	 * @param addressBean
	 * @param pageBean
	 * @return
	 */
	public List<AddressBean> getMemberAddressCounts(AddressBean addressBean, PageBean pageBean);
	
	/**
	 * 添加用户
	 * @param memberBean
	 * @return
	 */
	public int insertMember(MemberBean memberBean);
	
	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberDetail(MemberBean memberBean);
	
	/**
	 * 用户列表（不分页）
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getMembersNoPage(MemberBean memberBean);
	
	/**
	 * 获得用户列表
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getMembers(MemberBean memberBean, PageBean pageBean);
	
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean);
	
	/**
	 * 删除用户
	 * @param memberBean
	 * @return
	 */
	public int deleteMember(MemberBean memberBean);
	
	/**
	 * 获得用户地址
	 * @param addressBean
	 * @param pageBean
	 * @return
	 */
	public List<AddressBean> getMemberAddress(AddressBean addressBean, PageBean pageBean);
	
	/**
	 * 获得用户银行卡
	 * @param bankCardBean
	 * @param pageBean
	 * @return
	 */
	public List<BankCardBean> getMemberBankCards(BankCardBean bankCardBean, PageBean pageBean);

	
}
