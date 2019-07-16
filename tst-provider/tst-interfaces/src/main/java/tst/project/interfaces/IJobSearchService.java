package tst.project.interfaces;

import tst.project.bean.member.JobSearchBean;
import tst.project.page.PageBean;

public interface IJobSearchService {
	
	
	/**
	 * 找工作信息详情
	 * @param jobSearchBean
	 * @return
	 */
	public Object getJobSearchDetail(JobSearchBean jobSearchBean);
	
	
	/**
	 * 找工作列表
	 * @param jobSearchBean
	 * @param pageBean
	 * @return
	 */
	public Object getJobSearchs(JobSearchBean jobSearchBean,PageBean pageBean);
	
	/**
	 * 添加找工作信息
	 * @param jobSearchBean
	 * @return
	 */
	public Object insertJobsearch(JobSearchBean jobSearchBean);
	
	
	
	

}
