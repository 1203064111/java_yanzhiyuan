package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
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

@Mapper
public interface InformationDao {
	/**
	 * 添加拉黑
	 * @param memberBlackBean
	 * @return
	 */
	public int insertMemberBlack(MemberBlackBean memberBlackBean);
	/**
	 * 添加举报
	 * @param memberReportBean
	 * @return
	 */
	public int insertMemberReport(MemberReportBean memberReportBean);
	/**
	 * 获取资讯回复列表
	 * @param informationAssessmentBean
	 * @return
	 */
	public List<InformationAssessmentBean> getSystemInformationAssessmentsByParent(InformationAssessmentBean informationAssessmentBean); 

	/**
	 * 获取资讯的评论列表
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<InformationAssessmentBean> getSystemInformationAssessments(InformationAssessmentBean informationAssessmentBean,PageBean pageBean); 
	/**
	 * 资讯分类列表
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	List<InformationClassBean> getInformationClasss(InformationClassBean informationClassBean);
	
	/**
	 * 资讯列表
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	List<InformationBean> getInformations(InformationBean informationBean,PageBean pageBean);
	
	
	/**
	 * 资讯详情
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	InformationBean getInformationDetail(InformationBean informationBean);
	
	/**
	 * 推荐的资讯列表
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	List<InformationBean> getInformationMarketings(InformationBean informationBean);
	
	/**
	 * 获取系统资讯列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public List<SystemInformationBean> getSystemInformations(SystemInformationBean systemInformationBean,PageBean pageBean);
	
	public List<SystemInformationBean> getSystemInformationByOrderId(SystemInformationBean systemInformationBean,PageBean pageBean);
	
	
	/**
	 * 获取用户的资讯列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public List<SystemInformationBean> getSystemInformationsByMember(SystemInformationBean systemInformationBean,PageBean pageBean);
	
	
	/**
	 * 修改系统资讯
	 * @param systemInformationBean
	 * @return
	 */
	public int updateSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 用户发布资讯
	 * @param systemInformationBean
	 * @return
	 */
	public int insertSystemInformation(SystemInformationBean systemInformationBean);
	
	/**
	 * 用户发布个人心得资讯
	 * @param systemInformationBean
	 * @return
	 */
	public int insertSystemInformationXinDe(SystemInformationBean systemInformationBean);
	
	/**
	 * 获取资讯分类详情
	 * @param systemInformationClassBean
	 * @return
	 */
	public SystemInformationClassBean getSystemInformationClass(SystemInformationClassBean systemInformationClassBean);

	/**
	 * 获取系统资讯详情
	 * @param systemInformationBean
	 * @return
	 */
	public SystemInformationBean getSystemInformation(SystemInformationBean systemInformationBean);
	
	/**
	 * 添加点赞记录
	 * @param wellRelationBean
	 * @return
	 */
	public int insertWellRealtion(WellRelationBean wellRelationBean);
	
	/**
	 * 添加分享记录
	 * @param shareRelationBean
	 * @return
	 */
	public int insertShareRealtion(ShareRelationBean shareRelationBean);
	
	
	
	/**
	 * 取消点赞记录
	 * @param wellRelationBean
	 * @return
	 */
	public int updateWellRealtion(WellRelationBean wellRelationBean);
	/**
	 * 获取点赞记录
	 * @param wellRelationBean
	 * @return
	 */
	public WellRelationBean getWellRelation(WellRelationBean wellRelationBean);
	/**
	 * 添加评论/回复
	 * @param informationAssessmentBean
	 * @return
	 */
	public int insertInformationAssessment(InformationAssessmentBean informationAssessmentBean);
	/**
	 * 获取用户的资讯相册列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public List<Map> getInformationImgs(SystemInformationBean systemInformationBean,PageBean pageBean);
	/**
	 * 获取资讯分类列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public List<SystemInformationClassBean> getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean,PageBean pageBean);
}
