package tst.project.interfaces;

import tst.project.bean.member.CertificationBean;

public interface IMoudleService {

	/**
	 * 获得企业资质认证资料
	 * @param certificationBean
	 * @return
	 */
	Object getCertification(CertificationBean certificationBean);
	
	/**
	 * 添加企业资质认证
	 * @param certificationBean
	 * @return
	 */
	Object insertCertification(CertificationBean certificationBean);

	
	
}
