package tst.project.controller;

import tst.project.bean.member.RecruitBean;
import tst.project.page.PageBean;

public interface IRecruitServiceC {
	
	
	/**
	 * 招聘信息列表
	 * @param recruitBean
	 * @param pageBean
	 * @return
	 */
	public Object getRecruits(RecruitBean recruitBean ,PageBean pageBean);
	
	/**
	 * 招聘信息详情
	 * @param recruitBean
	 * @return
	 */
	public Object getRecruitDetail(RecruitBean recruitBean);
	
	/**
	 * 审核通过(招聘)
	 * @param recruitBean
	 * @return
	 */
	public Object passRecruit(RecruitBean recruitBean);
	
	/**
	 * 审核拒绝(招聘)
	 * @param recruitBean
	 * @return
	 */
	public Object refuseRecruit(RecruitBean recruitBean);
	
	/**
	 * 删除招聘信息
	 * @param recruitBean
	 * @return
	 */
	public Object deleteRecruit(RecruitBean recruitBean);
	
	

}
