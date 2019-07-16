package tst.project.information.interfaces;

import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.ShareRelationBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.information.WellRelationBean;
import tst.project.bean.member.MemberBlackBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.page.PageBean;

public interface IInformationService {
	
	/**
	 * 资讯分类列表
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	Object getInformationClasss(InformationClassBean informationClassBean);
	
	/**
	 * 资讯列表
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	Object getInformations(InformationBean informationBean,PageBean pageBean);
	
	/**
	 * 资讯详情
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	Object getInformationDetail(InformationBean informationBean);
	
	/**
	 * 推荐的资讯列表
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	Object getInformationMarketings(InformationBean informationBean);
	
	/**
	 * 获取系统资讯列表
	 * @author lx
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemInformations(SystemInformationBean systemInformationBean, PageBean pageBean);
	
	
	/**
	 * 获取用户的资讯列表
	 * @author lx
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemInformationsByMember(SystemInformationBean systemInformationBean, PageBean pageBean);
	/**
	 * 获取系统资讯详情
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object getSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 通过订单id获取日记列表
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object getSystemInformationByOrderId(SystemInformationBean systemInformationBean,PageBean pageBean);
	/**
	 * 修改系统资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object updateSystemInformation(SystemInformationBean systemInformationBean);
	
	/**
	 * 分享资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object shareSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 发布资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object insertSystemInformation(SystemInformationBean systemInformationBean);
	
	/**
	 * 发布个人心得资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object insertSystemInformationXinDe(SystemInformationBean systemInformationBean);
	
	/**
	 * 添加点赞记录
	 * @param wellRelationBean
	 * @return
	 */
	public Object insertWellRealtion(WellRelationBean wellRelationBean);
	
	/**
	 * 添加分享记录
	 * @author lx
	 * @param shareRelationBean
	 * @return
	 */
	public Object insertShareRealtion(ShareRelationBean shareRelationBean);
	
	
	/**
	 * 删除点赞记录
	 * @author lx
	 * @param wellRelationBean
	 * @return
	 */
	public Object deleteWellRealtion(WellRelationBean wellRelationBean);
	/**
	 * 添加评论/回复
	 * @param informationAssessmentBean
	 * @return
	 */
	public Object insertInformationAssessment(InformationAssessmentBean informationAssessmentBean);
	/**
	 * 获取用户的资讯相册列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public Object getInformationImgs(SystemInformationBean systemInformationBean,PageBean pageBean);
	
	/**
	 * 获取资讯分类列表
	 * @author lx
	 * @param systemInformationClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean,PageBean pageBean);
	
	/**
	 * 获取资讯的评论列表
	 * @author lx
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemInformationAssessments(InformationAssessmentBean informationAssessmentBean,PageBean pageBean);
	
	/**
	 * 添加举报
	 * @author lx
	 * @param memberReportBean
	 * @return
	 */
	public Object insertMemberReport(MemberReportBean memberReportBean);
	/**
	 * 拉黑用户
	 * @author lx
	 * @param memberBlackBean
	 * @return
	 */
	public Object insertMemberBlack(MemberBlackBean memberBlackBean);
	
	
	
}
