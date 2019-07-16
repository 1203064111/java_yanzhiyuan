package tst.project.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tst.project.aspect.AppException;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.PayDetailBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionClassesBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.ResumeSettingBean;
import tst.project.bean.information.SalaryBean;
import tst.project.bean.member.MemberBean;
import tst.project.dao.controller.PositionDaoC;
import tst.project.information.controller.IPositionServiceC;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class PositionServiceC  implements IPositionServiceC{
	@Autowired
	PositionDaoC positionDaoC;
	@Autowired
	IMemberService iMemberService;
	
	@Override
	public Object getMaterials(MaterialBean materialBean, PageBean pageBean) {
		List<MaterialBean> materialBeans = positionDaoC.getMaterials(materialBean, pageBean);
		return pageBean.setObject(materialBeans);
	}

	@Override
	public Object getMaterial(MaterialBean materialBean) {
		return positionDaoC.getMaterial(materialBean);
	}

	@Override
	public Object updateMaterial(MaterialBean materialBean) {
		int num = positionDaoC.updateMaterial(materialBean);
		if(num <= 0){
			throw new AppException("审核失败");
		}
		MaterialBean materialBean2 = positionDaoC.getMaterial(new MaterialBean().setMaterial_id(materialBean.getMaterial_id()));
		//同意
		if("1".equals(materialBean.getMaterial_state())){
			if(materialBean2 != null){
				MemberBean memberBean = iMemberService.getMemberDetail(new MemberBean().setMember_id(materialBean2.getMember_id()));
				if(memberBean != null){
					String role_type = "01".equals(memberBean.getRole_type())?"1":"02".equals(memberBean.getRole_type())?"2":"0";
					num = iMemberService.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setRole_type(role_type));
					if(num <= 0){
						throw new AppException("修改失败");
					}
				}
			}
		}
		//拒绝
		if("2".equals(materialBean.getMaterial_state())){
			if(materialBean2 != null){
				MemberBean memberBean = iMemberService.getMemberDetail(new MemberBean().setMember_id(materialBean2.getMember_id()));
				if(memberBean != null){
					String role_type = "01".equals(memberBean.getRole_type())?"011":"02".equals(memberBean.getRole_type())?"022":"0";
					num = iMemberService.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setRole_type(role_type));
					if(num <= 0){
						throw new AppException("修改失败");
					}
				}
			}
		}
		
		
		return num;
	}


	@Override
	public Object getPositions(PositionBean positionBean, PageBean pageBean) {
		List<PositionBean> positionBeans = positionDaoC.getPositions(positionBean, pageBean);
		return pageBean.setObject(positionBeans);
	}

	@Override
	public Object getPosition(PositionBean positionBean) {
		PositionBean positionBean2 = positionDaoC.getPosition(positionBean);
		if(positionBean2 != null){
			//获取职位的岗位中文名称
			List<PositionClassBean> positionClassesBeans = positionDaoC.getPositionClassNames(new PositionClassesBean().setPosition_id(
					positionBean2.getPosition_id()));
			String names = "";
			for(PositionClassBean positionClassBean : positionClassesBeans){
				names += positionClassBean.getPosition_class_name()+",";
			}
			positionBean2.setPosition_class_names(names);
		}
		return positionBean2;
	}

	@Override
	public Object updatePosition(PositionBean positionBean) {
		int num = positionDaoC.updatePosition(positionBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object getResumeSettings(ResumeSettingBean resumeSettingBean) {
		// TODO Auto-generated method stub
		return  positionDaoC.getResumeSettings(resumeSettingBean);
	}


	@Override
	public Object updateResumeSetting(List<ResumeSettingBean> resumeSettingBeans) {
		if(resumeSettingBeans!=null){
			for (int i = 0; i < resumeSettingBeans.size(); i++) {
				ResumeSettingBean resumeSettingBean=resumeSettingBeans.get(i);
				int num = positionDaoC.updateResumeSetting(resumeSettingBean);
				if(num<=0){
					throw new AppException("修改失败");
				}
			}
		}
		return 1;
	}

	@Override
	public Object getSalarys(SalaryBean salaryBean, PageBean pageBean) {
		List<SalaryBean> salaryBeans = positionDaoC.getSalarys(salaryBean, pageBean);
		return pageBean.setObject(salaryBeans);
	}

	@Override
	public Object getSalary(SalaryBean salaryBean) {
		return positionDaoC.getSalary(salaryBean);
	}

	@Override
	public Object updateSalary(SalaryBean salaryBean) {
		int num = positionDaoC.updateSalary(salaryBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertSalary(SalaryBean salaryBean) {
		int num = positionDaoC.insertSalary(salaryBean);
		if(num <= 0){
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deleteSalary(SalaryBean salaryBean) {
		int num = positionDaoC.deleteSalary(salaryBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}
	@Override
	public Object getPositionClasss(PositionClassBean positionClassBean, PageBean pageBean) {
		List<PositionClassBean> positionClassBeans = positionDaoC.getPositionClasss(positionClassBean, pageBean);
		return pageBean.setObject(positionClassBeans);
	}

	@Override
	public Object getPositionClass(PositionClassBean positionClassBean) {
		return positionDaoC.getPositionClass(positionClassBean);
	}

	@Override
	public Object updatePositionClass(PositionClassBean positionClassBean) {
		int num = positionDaoC.updatePositionClass(positionClassBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertPositionClass(PositionClassBean positionClassBean) {
		int num = positionDaoC.insertPositionClass(positionClassBean);
		if(num <= 0){
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deletePositionClass(PositionClassBean positionClassBean) {
		int num = positionDaoC.deletePositionClass(positionClassBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}
	@Override
	public Object getAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean, PageBean pageBean) {
		List<AdvertiseOrderBean> advertiseOrderBeans = positionDaoC.getAdvertiseOrders(advertiseOrderBean, pageBean);
		if("2".equals(advertiseOrderBean.getOrder_type())){
			for(AdvertiseOrderBean advertiseOrderBean2 : advertiseOrderBeans){
				//根据职位id去找未打款的简历 有数据 设置order_close为0  无数据 设置order_close为1
				List<PositionPersonsBean> positionPersonsBeans = positionDaoC.getRequirePositionIsNotClose(new PositionPersonsBean().setPosition_id(
						advertiseOrderBean2.getPosition_id()));
				if(CollectionUtils.isEmpty(positionPersonsBeans)){
					advertiseOrderBean2.setOrder_close("1");
				}else{
					advertiseOrderBean2.setOrder_close("0");
				}
				
			}
		}
		
		return pageBean.setObject(advertiseOrderBeans);
	}
	
	@Override
	public Object getRequirePositions(PositionPersonsBean positionPersonsBean, PageBean pageBean) {
		List<Map> requirePositionBeans = positionDaoC.getRequirePositions(positionPersonsBean, pageBean);
		return pageBean.setObject(requirePositionBeans);
	}

	@Override
	public Object getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {
		AdvertiseOrderBean advertiseOrderBean2 = positionDaoC.getAdvertiseOrder(advertiseOrderBean);
		if(advertiseOrderBean2 != null){
			PositionBean positionBean = positionDaoC.getPosition(new PositionBean().setPosition_id(
					advertiseOrderBean2.getPosition_id()));
			advertiseOrderBean2.setPositionBean(positionBean);
			MaterialBean materialBean = positionDaoC.getMaterial(new MaterialBean().setMaterial_id(
					advertiseOrderBean2.getMaterial_id()));
			advertiseOrderBean2.setMaterialBean(materialBean);
			List<PayDetailBean> payDetailBeans = positionDaoC.getPayDetails(new PayDetailBean().setAdvertise_order_id(
					advertiseOrderBean2.getAdvertise_order_id()));
			advertiseOrderBean2.setPayDetailBeans(payDetailBeans);
		}
		return advertiseOrderBean2;
	}

	@Override
	public Object updateAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {
		AdvertiseOrderBean advertiseOrderBean2 = positionDaoC.getAdvertiseOrder(advertiseOrderBean);
		int num = positionDaoC.updateAdvertiseOrder(advertiseOrderBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		num = positionDaoC.insertPayDetail(new PayDetailBean()
				.setAdvertise_order_id(advertiseOrderBean2.getAdvertise_order_id())
				.setAdvertise_order_no(advertiseOrderBean2.getOrder_no())
				.setMember_id(advertiseOrderBean2.getMember_id())
				.setPay_detail_title("定金退款")
				.setPay_detail_type("refund")
				.setPrice(advertiseOrderBean2.getAdvertise_order_total())
				);
		if(num <= 0){
			throw new AppException("添加明细失败");
		}
		
		return num;
	}

	@Override
	public Object updatePositionPersonRemit(PositionPersonsBean positionPersonsBean) {
		AdvertiseOrderBean advertiseOrderBean = positionDaoC.getAdvertiseOrder(new AdvertiseOrderBean()
				.setPosition_id(positionPersonsBean.getPosition_id())
				.setOrder_type("2"));
		List<PositionPersonsBean> positionPersonsBeans = positionDaoC.getPositionPersonss(new PositionPersonsBean().setState("2")
				.setPosition_id(positionPersonsBean.getPosition_id()));
		double total =  NumberUtils.Double(advertiseOrderBean.getOrder_pay_second());
		double people = positionPersonsBeans.size();
		double price = NumberUtils.divide(total, people);
				
		int num = positionDaoC.insertPayDetail(new PayDetailBean()
				.setAdvertise_order_id(advertiseOrderBean.getAdvertise_order_id())
				.setAdvertise_order_no(advertiseOrderBean.getOrder_no())
				.setMember_id(positionPersonsBean.getMember_id())
				.setPay_detail_title("活动收入")
				.setPay_detail_type("refund")
				.setPrice(String.valueOf(price)));
		if(num <= 0){
			throw new AppException("添加明细失败");
		}
		num = positionDaoC.updatePositionPersonRemit(positionPersonsBean);
		if(num <= 0 ){
			throw new AppException("支付失败");
		}
		return num;
	}

	


}