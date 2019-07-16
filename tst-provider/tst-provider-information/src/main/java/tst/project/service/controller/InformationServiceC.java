package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.dao.controller.InformationDaoC;
import tst.project.information.controller.IInformationServiceC;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class InformationServiceC implements IInformationServiceC {
	@Autowired
	InformationDaoC informationDaoC;


	@Override
	public Object getInformationDetail(InformationBean informationBean) {
		// TODO Auto-generated method stub
		return informationDaoC.getInformationDetail(informationBean);
	}

	@Override
	public Object getInformations(InformationBean informationBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<InformationBean> informationBeans=informationDaoC.getInformations(informationBean, pageBean);
		return pageBean.setObject(informationBeans);
	}

	@Override
	public int insertInformation(InformationBean informationBean) {
		// TODO Auto-generated method stub
		int num = informationDaoC.insertInformation(informationBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public int updateInformation(InformationBean informationBean) {
		// TODO Auto-generated method stub
		int num = informationDaoC.updateInformation(informationBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public int deleteInformation(InformationBean informationBean) {
		// TODO Auto-generated method stub
		int num = informationDaoC.deleteInformation(informationBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	
	@Override
	public Object insertInformationClass(InformationClassBean informationClassBean) {
		// TODO Auto-generated method stub
		int num = informationDaoC.insertInformationClass(informationClassBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object updateInformationClass(InformationClassBean informationClassBean) {
		// TODO Auto-generated method stub
		int num = informationDaoC.updateInformationClass(informationClassBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object deleteInformationClass(InformationClassBean informationClassBean) {
		// TODO Auto-generated method stub
		int num = informationDaoC.deleteInformationClass(informationClassBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getInformationClassDetail(InformationClassBean informationClassBean) {
		// TODO Auto-generated method stub
		return informationDaoC.getInformationClassDetail(informationClassBean);
	}

	@Override
	public Object getInformationClasss(InformationClassBean informationClassBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<InformationClassBean> informationClassBeans = informationDaoC.getInformationClasss(informationClassBean,
				pageBean);
		return pageBean.setObject(informationClassBeans);
	}
	@Override
	public Object getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean, PageBean pageBean) {
		List<SystemInformationClassBean> systemInformationClassBeans = informationDaoC.getSystemInformationClasss(systemInformationClassBean, pageBean);
		return pageBean.setObject(systemInformationClassBeans);
	}

	@Override
	public Object getSystemInformationClass(SystemInformationClassBean systemInformationClassBean) {
		return informationDaoC.getSystemInformationClass(systemInformationClassBean);
	}

	@Override
	public Object updateSystemInformationClass(SystemInformationClassBean systemInformationClassBean) {
		int num = informationDaoC.updateSystemInformationClass(systemInformationClassBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertSystemInformationClass(SystemInformationClassBean systemInformationClassBean) {
		int num = informationDaoC.insertSystemInformationClass(systemInformationClassBean);
		if(num <= 0){
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deleteSystemInformationClass(SystemInformationClassBean systemInformationClassBean) {
		int num = informationDaoC.deleteSystemInformationClass(systemInformationClassBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}
	@Override
	public Object getSystemInformations(SystemInformationBean systemInformationBean, PageBean pageBean) {
		List<SystemInformationBean> systemInformationBeans = informationDaoC.getSystemInformations(systemInformationBean, pageBean);
		return pageBean.setObject(systemInformationBeans);
	}

	@Override
	public Object getSystemInformation(SystemInformationBean systemInformationBean) {
		return informationDaoC.getSystemInformation(systemInformationBean);
	}

	@Override
	public Object updateSystemInformation(SystemInformationBean systemInformationBean) {
		int num = informationDaoC.updateSystemInformation(systemInformationBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertSystemInformation(SystemInformationBean systemInformationBean) {
		int num = informationDaoC.insertSystemInformation(systemInformationBean);
		if(num <= 0){
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deleteSystemInformation(SystemInformationBean systemInformationBean) {
		int num = informationDaoC.deleteSystemInformation(systemInformationBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object getInformationAssessments(InformationAssessmentBean informationAssessmentBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(informationDaoC.getInformationAssessments(informationAssessmentBean, pageBean));
	}

	@Override
	public Object getInformationAssessmentAnswers(InformationAssessmentBean informationAssessmentBean,
			PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(informationDaoC.getInformationAssessmentAnswers(informationAssessmentBean, pageBean));
	}

	@Override
	public Object updateInformationAssessment(InformationAssessmentBean informationAssessmentBean) {
		int num = informationDaoC.updateInformationAssessment(informationAssessmentBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object deleteInformationAssessment(InformationAssessmentBean informationAssessmentBean) {
		int num = informationDaoC.deleteInformationAssessment(informationAssessmentBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		SystemInformationBean systemInformationBean = informationDaoC.getSystemInformation(new SystemInformationBean().setInformation_id(informationAssessmentBean.getInformation_id()));
		if(systemInformationBean!=null){
			int comment_num = systemInformationBean.getComment_num();
			comment_num = comment_num -1;
			int num2 = informationDaoC.updateSystemInformation(new SystemInformationBean().setInformation_id(systemInformationBean.getInformation_id())
					.setComment_num(comment_num));
			if(num2 <= 0){
				throw new AppException("删除失败");
			}
		}
		
		return num;
	}
	
	@Override
	public Object getMemberReports(MemberReportBean memberReportBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberReportBean> memberReportBeans = informationDaoC.getMemberReports(memberReportBean, pageBean);
		return pageBean.setObject(memberReportBeans);
	}
}
