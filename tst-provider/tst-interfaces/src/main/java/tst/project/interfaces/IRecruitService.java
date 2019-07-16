package tst.project.interfaces;

import tst.project.bean.member.RecruitBean;
import tst.project.bean.member.TypeBean;
import tst.project.page.PageBean;

public interface IRecruitService {
	
	
	/**
	 * 工种列表
	 * @author hwq
	 * @param typeBean
	 * @return
	 */
	public Object getTypes(TypeBean typeBean);
	
	/**
	 * 招聘信息详情
	 * @param recruitBean
	 * @return
	 */
	public Object getRecruitDetail(RecruitBean recruitBean);
	
	
	/**
	 * 招聘信息列表
	 * @param recruitBean
	 * @param pageBean
	 * @return
	 */
	public Object getRecruits(RecruitBean recruitBean,PageBean pageBean);
	
	/**
	 * 发布招聘信息
	 * @param recruitBean
	 * @return
	 */
	public Object insertRecruit(RecruitBean recruitBean);
	
	

}
