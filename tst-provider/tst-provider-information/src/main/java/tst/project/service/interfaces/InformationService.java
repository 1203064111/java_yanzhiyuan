package tst.project.service.interfaces;

import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.ShareRelationBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.information.WellRelationBean;
import tst.project.bean.member.MemberBlackBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.dao.interfaces.InformationDao;
import tst.project.information.interfaces.IInformationService;
import tst.project.page.PageBean;
import tst.project.utils.StringUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class InformationService implements IInformationService{

	@Autowired
	InformationDao informationDao;
	
	@Override
	public Object getInformationClasss(InformationClassBean informationClassBean) {
		// TODO Auto-generated method stub
		return informationDao.getInformationClasss(informationClassBean);
	}
	
	@Override
	public Object getInformations(InformationBean informationBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<InformationBean> informationBeans=informationDao.getInformations(informationBean, pageBean);
		return pageBean.setObject(informationBeans);
	}
	
	@Override
	public Object getInformationDetail(InformationBean informationBean) {
		// TODO Auto-generated method stub
		return informationDao.getInformationDetail(informationBean);
	}
	
	@Override
	public Object getInformationMarketings(InformationBean informationBean) {
		// TODO Auto-generated method stub
		return informationDao.getInformationMarketings(informationBean);
	}
	
	@Override
	public Object getSystemInformations(SystemInformationBean systemInformationBean, PageBean pageBean) {
		List<SystemInformationBean> systemInformationBeans = informationDao.getSystemInformations(systemInformationBean, pageBean);
		return pageBean.setObject(systemInformationBeans);
	}

	@Override
	public Object getSystemInformation(SystemInformationBean systemInformationBean) {
		return informationDao.getSystemInformation(systemInformationBean);
	}
	@Override
	public Object getSystemInformationByOrderId(SystemInformationBean systemInformationBean,PageBean pageBean) {
		return pageBean.setObject(informationDao.getSystemInformationByOrderId(systemInformationBean,pageBean));
	}
	

	@Override
	public Object updateSystemInformation(SystemInformationBean systemInformationBean) {
		int num = informationDao.updateSystemInformation(systemInformationBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}
	@Override
	public Object shareSystemInformation(SystemInformationBean systemInformationBean) {
		int num =1;
		SystemInformationBean systemInformationBean2 =informationDao.getSystemInformation(systemInformationBean);
		if(systemInformationBean2 != null){
			int send_num =systemInformationBean2.getSend_num();
			send_num++;
			num = informationDao.updateSystemInformation(new SystemInformationBean().setInformation_id(systemInformationBean2.getInformation_id())
					.setSend_num(send_num));
			if(num <= 0){
				throw new AppException("修改失败");
			}
		}
		
		return num;
	}

	@Override
	public Object insertSystemInformation(SystemInformationBean systemInformationBean) {
		int num =1;
		//默认是用户交流的分类
		SystemInformationClassBean systemInformationClassBean = informationDao.getSystemInformationClass(new SystemInformationClassBean().setClass_code("share"));
		if(systemInformationClassBean != null){
			num = informationDao.insertSystemInformation(systemInformationBean.setClass_id(String.valueOf(systemInformationClassBean.getClass_id())));
			if(num <= 0){
				throw new AppException("发布失败");
			}
		}
		
		return num;
	}
	
	@Override
	public Object insertSystemInformationXinDe(SystemInformationBean systemInformationBean) {
		int num =1;
		//分类个人心得
		SystemInformationClassBean systemInformationClassBean = informationDao.getSystemInformationClass(new SystemInformationClassBean().setClass_code("understand"));
		if(systemInformationClassBean != null){
			num = informationDao.insertSystemInformationXinDe(systemInformationBean.setClass_id(String.valueOf(systemInformationClassBean.getClass_id())));
			if(num <= 0){
				throw new AppException("发布失败");
			}
		}
		
		return num;
	}

	@Override
	public Object insertWellRealtion(WellRelationBean wellRelationBean) {
		WellRelationBean wellRelationBean2 = informationDao.getWellRelation(wellRelationBean);
		if(wellRelationBean2 != null){
			throw new AppException("不允许重复点赞");
		}
		int num = informationDao.insertWellRealtion(wellRelationBean);
		if(num <= 0){
			throw new AppException("点赞失败");
		}
		SystemInformationBean systemInformationBean = informationDao.getSystemInformation(new SystemInformationBean()
				.setInformation_id(Integer.valueOf(wellRelationBean.getInformation_id())));
		if(systemInformationBean != null ){
			int well_num = systemInformationBean.getWell_num();
			well_num++;
			int num2 = informationDao.updateSystemInformation(new SystemInformationBean()
					.setInformation_id(systemInformationBean.getInformation_id())
					.setWell_num(well_num));
			if(num2 <= 0){
				throw new AppException("修改失败");
			}
		
		}
		return num;
	}
	@Override
	public Object insertShareRealtion(ShareRelationBean shareRelationBean) {
	
		int num = informationDao.insertShareRealtion(shareRelationBean);
		if(num <= 0){
			throw new AppException("分享失败");
		}
		SystemInformationBean systemInformationBean = informationDao.getSystemInformation(new SystemInformationBean()
				.setInformation_id(Integer.valueOf(shareRelationBean.getInformation_id())));
		if(systemInformationBean != null ){
			int share_num = systemInformationBean.getSend_num();
			share_num++;
			int num2 = informationDao.updateSystemInformation(new SystemInformationBean()
					.setInformation_id(systemInformationBean.getInformation_id())
					.setSend_num(share_num));
			if(num2 <= 0){
				throw new AppException("修改失败");
			}
		
		}
		return num;
	}
	
	@Override
	public Object deleteWellRealtion(WellRelationBean wellRelationBean) {
		WellRelationBean wellRelationBean2 = informationDao.getWellRelation(wellRelationBean);
		if(wellRelationBean2 == null){
			throw new AppException("取消点赞失败");
		}
		int num = informationDao.updateWellRealtion(wellRelationBean);
		if(num <= 0){
			throw new AppException("点赞失败");
		}
		SystemInformationBean systemInformationBean = informationDao.getSystemInformation(new SystemInformationBean()
				.setInformation_id(Integer.valueOf(wellRelationBean.getInformation_id())));
		if(systemInformationBean != null ){
			int well_num = systemInformationBean.getWell_num();
			well_num--;
			int num2 = informationDao.updateSystemInformation(new SystemInformationBean()
					.setInformation_id(systemInformationBean.getInformation_id())
					.setWell_num(well_num));
			if(num2 <= 0){
				throw new AppException("修改失败");
			}
		
		}
		return num;
	}

	@Override
	public Object insertInformationAssessment(InformationAssessmentBean informationAssessmentBean) {
		if(!StringUtils.isNull(informationAssessmentBean.getParent_id())){
			SystemInformationBean systemInformationBean = informationDao.getSystemInformation(new SystemInformationBean()
					.setInformation_id(informationAssessmentBean.getInformation_id()));
			if(systemInformationBean== null){
				throw new AppException("资讯不存在");
			}
			if(informationAssessmentBean.getMember_id()!=systemInformationBean.getMember_id()){
				throw new AppException("您不是发帖人，无法回复");
			}
		}
		
		
		int num = informationDao.insertInformationAssessment(informationAssessmentBean);
		if(num <= 0){
			throw new AppException("评论失败");
		}
		SystemInformationBean systemInformationBean = informationDao.getSystemInformation(new SystemInformationBean()
				.setInformation_id(informationAssessmentBean.getInformation_id()));
		if(systemInformationBean != null ){
			int comment_num = systemInformationBean.getComment_num();
			comment_num++;
			int num2 = informationDao.updateSystemInformation(new SystemInformationBean()
					.setInformation_id(systemInformationBean.getInformation_id())
					.setComment_num(comment_num));
			if(num2 <= 0){
				throw new AppException("修改失败");
			}
		
		}
		
		return num;
	}

	@Override
	public Object getInformationImgs(SystemInformationBean systemInformationBean, PageBean pageBean) {
		List<Map> list = informationDao.getInformationImgs(systemInformationBean, pageBean);
		return pageBean.setObject(list);
	}

	@Override
	public Object getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean, PageBean pageBean) {
		List<SystemInformationClassBean> systemInformationClassBeans = informationDao.getSystemInformationClasss(systemInformationClassBean, pageBean);
		return pageBean.setObject(systemInformationClassBeans);
	}

	@Override
	public Object getSystemInformationsByMember(SystemInformationBean systemInformationBean, PageBean pageBean) {
		List<SystemInformationBean> systemInformationBeans = informationDao.getSystemInformationsByMember(systemInformationBean, pageBean);
		return pageBean.setObject(systemInformationBeans);
	}

	@Override
	public Object getSystemInformationAssessments(InformationAssessmentBean informationAssessmentBean,
			PageBean pageBean) {
		List<InformationAssessmentBean> informationAssessmentBeans = informationDao.getSystemInformationAssessments(informationAssessmentBean, pageBean);
		for(InformationAssessmentBean informationAssessmentBean2 : informationAssessmentBeans){
			
			List<InformationAssessmentBean> informationAssessmentBeans2 = informationDao.getSystemInformationAssessmentsByParent(new InformationAssessmentBean().setParent_id(String.valueOf(informationAssessmentBean2.getAssessment_id())));
			
			informationAssessmentBean2.setInformationAssessmentBeans(informationAssessmentBeans2);
		}
		return pageBean.setObject(informationAssessmentBeans);
	}
	
	@Override
	public Object insertMemberReport(MemberReportBean memberReportBean) {
		int num = informationDao.insertMemberReport(memberReportBean);
		if(num <= 0){
			throw new AppException("举报失败");
		}
		return num;
	}
	@Override
	public Object insertMemberBlack(MemberBlackBean memberBlackBean) {
		int num = informationDao.insertMemberBlack(memberBlackBean);
		if(num <= 0){
			throw new AppException("拉黑失败");
		}
		return num;
	}
}
