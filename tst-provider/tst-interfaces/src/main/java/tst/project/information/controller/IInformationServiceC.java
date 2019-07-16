package tst.project.information.controller;

import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.page.PageBean;

public interface IInformationServiceC {
	
	
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
	public Object getInformationDetail(InformationBean informationBean);
	/**
	 * 资讯列表
	 * @author sjb
	 * @param informationBean
	 * @return
	 */
	public Object getInformations(InformationBean informationBean,PageBean pageBean);
	
	
	
	
	/**
	 * 添加资讯分类
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public Object insertInformationClass(InformationClassBean informationClassBean);
	
	/**
	 * 修改资讯分类
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public Object updateInformationClass(InformationClassBean informationClassBean);
	
	/**
	 * 删除资讯分类
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public Object deleteInformationClass(InformationClassBean informationClassBean);
	
	/**
	 * 资讯分类详情
	 * @author sjb
	 * @param informationClassBean
	 * @return
	 */
	public Object getInformationClassDetail(InformationClassBean informationClassBean);
	
	/**
	 * 资讯分类列表
	 * @author sjb
	 * @param informationClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getInformationClasss(InformationClassBean informationClassBean,PageBean pageBean);
	
	/**
	 * 获取资讯分类列表
	 * @author lx
	 * @param systemInformationClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean, PageBean pageBean);
	/*
	 * 获取资讯分类详情
	 */
	public Object getSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	/**
	 * 修改资讯分类
	 * @author lx
	 * @param systemInformationClassBean
	 * @return
	 */
	public Object updateSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	/**
	 * 添加资讯分类
	 * @author lx
	 * @param systemInformationClassBean
	 * @return
	 */
	public Object insertSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	/**
	 * 删除资讯分类
	 * @author lx
	 * @param systemInformationClassBean
	 * @return
	 */
	public Object deleteSystemInformationClass(SystemInformationClassBean systemInformationClassBean);
	
	
	/**
	 * 获取资讯列表
	 * @author lx
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemInformations(SystemInformationBean systemInformationBean, PageBean pageBean);
	/**
	 * 获取资讯详情
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object getSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 修改资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object updateSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 添加资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object insertSystemInformation(SystemInformationBean systemInformationBean);
	/**
	 * 删除资讯
	 * @author lx
	 * @param systemInformationBean
	 * @return
	 */
	public Object deleteSystemInformation(SystemInformationBean systemInformationBean);
	
	
	
	/**
	 * 获取资讯评论列表
	 * @author lx
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public Object getInformationAssessments(InformationAssessmentBean informationAssessmentBean,PageBean pageBean);
	/**
	 * 获取资讯评论回答列表
	 * @author lx
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public Object getInformationAssessmentAnswers(InformationAssessmentBean informationAssessmentBean,PageBean pageBean);
	/**
	 * 修改资讯评论
	 * @author lx
	 * @param informationAssessmentBean
	 * @return
	 */
	public Object updateInformationAssessment(InformationAssessmentBean informationAssessmentBean);
	/**
	 * 删除资讯评论
	 * @author lx
	 * @param informationAssessmentBean
	 * @return
	 */
	public Object deleteInformationAssessment(InformationAssessmentBean informationAssessmentBean);
	
	/**
	 * 举报列表
	 * @author lx
	 * @param memberReportBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberReports(MemberReportBean memberReportBean,PageBean pageBean);
	
}
