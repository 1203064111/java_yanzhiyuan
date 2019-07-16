package tst.project.controller;

import tst.project.bean.member.CertificationBean;
import tst.project.page.PageBean;

public interface IMoudleServiceC {
	
	/**
	 * 资质认证申请列表
	 * @param certificationBean
	 * @param pageBean
	 * @return
	 */
	public Object getCertificationBeans(CertificationBean certificationBean,PageBean pageBean);
	
	/**
	 * 资质认证申请详情
	 * @param certificationBean
	 * @param pageBean
	 * @return
	 */
	public Object getCertificationBean(CertificationBean certificationBean);
	
	/**
	 * 资质认证通过
	 * @param certificationBean
	 * @return
	 */
	public Object passCertificationBean(CertificationBean certificationBean);
	
	/**
	 * 资质认证拒绝
	 * @param certificationBean
	 * @return
	 */
	public Object refuseCertificationBean(CertificationBean certificationBean);
	
	
	/**
	 * 删除资质认证申请
	 * @param certificationBean
	 * @return
	 */
	public Object deleteCertificationBean(CertificationBean certificationBean);
	
}
