package tst.project.controller;

import tst.project.bean.member.JobSearchBean;
import tst.project.page.PageBean;

public interface IJobSearchServiceC {
	
	
	/**
	 * 找工作列表
	 * @param jobSearchBean
	 * @param pageBean
	 * @return
	 */
	public Object getJobSearchs(JobSearchBean jobSearchBean ,PageBean pageBean);
	
	/**
	 * 找工作信息详情
	 * @param jobSearchBean
	 * @return
	 */
	public Object getJobSearchDetail(JobSearchBean jobSearchBean);
	
	/**
	 * 审核通过(找工作)
	 * @param jobSearchBean
	 * @return
	 */
	public Object passJobSearch(JobSearchBean jobSearchBean);
	
	/**
	 * 审核拒绝(找工作)
	 * @param jobSearchBean
	 * @return
	 */
	public Object refuseJobSearch(JobSearchBean jobSearchBean);
	
	/**
	 * 删除找工作信息
	 * @param jobSearchBean
	 * @return
	 */
	public Object deleteJobSearch(JobSearchBean jobSearchBean);
	
	

}
