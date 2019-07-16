package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.page.PageBean;

@Mapper
public interface InformationDaoC {
	
	/**
	 * 添加资讯
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	public int insertInformation(InformationBean informationBean);
	
	/**
	 * 修改资讯
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	public int updateInformation(InformationBean informationBean);
	
	
	/**
	 * 删除资讯
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	public int deleteInformation(InformationBean informationBean);
	/**
	 * 资讯详情
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	public InformationBean getInformationDetail(InformationBean informationBean);
	/**
	 * 资讯列表
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	public List<InformationBean> getInformations(InformationBean informationBean,PageBean pageBean);

	
	
	/**
	 * 添加资讯分类
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public int insertInformationClass(InformationClassBean informationClassBean);
	
	/**
	 * 修改资讯分类
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public int updateInformationClass(InformationClassBean informationClassBean);
	
	/**
	 * 删除资讯分类
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public int deleteInformationClass(InformationClassBean informationClassBean);
	
	/**
	 * 资讯分类详情
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public InformationClassBean getInformationClassDetail(InformationClassBean informationClassBean);
	
	/**
	 * 资讯分类列表
	 * @author sjb
	 * @param informationClassBean
	 * @param pageBean
	 * @return
	 */
	public List<InformationClassBean> getInformationClasss(InformationClassBean informationClassBean,PageBean pageBean);
	
	

	public List<SystemInformationClassBean> getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean,PageBean pageBean);
	
	public int updateSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	
	public int deleteSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	
	public int insertSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	
	public SystemInformationClassBean getSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	
	public List<SystemInformationBean> getSystemInformations(SystemInformationBean systemInformationBean,PageBean pageBean);
	
	public int updateSystemInformation(SystemInformationBean systemInformationBean);
	
	public int deleteSystemInformation(SystemInformationBean systemInformationBean);
	
	public int insertSystemInformation(SystemInformationBean systemInformationBean);
	
	public SystemInformationBean getSystemInformation(SystemInformationBean systemInformationBean);
	
	
	

	/**
	 * 获取资讯评论列表
	 * @author lx
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<InformationAssessmentBean> getInformationAssessments(InformationAssessmentBean informationAssessmentBean,PageBean pageBean);
	/**
	 * 获取资讯评论回答列表
	 * @author lx
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<InformationAssessmentBean> getInformationAssessmentAnswers(InformationAssessmentBean informationAssessmentBean,PageBean pageBean);
	/**
	 * 修改资讯评论
	 * @author lx
	 * @param informationAssessmentBean
	 * @return
	 */
	public int updateInformationAssessment(InformationAssessmentBean informationAssessmentBean);
	/**
	 * 删除资讯评论
	 * @author lx
	 * @param informationAssessmentBean
	 * @return
	 */
	public int deleteInformationAssessment(InformationAssessmentBean informationAssessmentBean);
	
	/**
	 * 举报列表
	 * @param memberReportBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberReportBean> getMemberReports(MemberReportBean memberReportBean,PageBean pageBean);

}
