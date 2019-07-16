package tst.project.service.interfaces;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alipay.api.domain.Member;

import tst.project.aspect.AppException;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.AssessmentBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.MemberAssessmentBean;
import tst.project.bean.information.PayDetailBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionClassesBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.RequirePositionSalaryBean;
import tst.project.bean.information.ResumeSettingBean;
import tst.project.bean.information.SalaryBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.dao.interfaces.PositionDao;
import tst.project.information.interfaces.IPositionService;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.utils.JPushUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.PayUtils;
import tst.project.utils.UUIDUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class PositionService implements IPositionService {
	
	SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
	@Autowired
	PositionDao positionDao;

	@Autowired
	IMemberService memberService;

	@Value("${jiguang_appid}")
	private String jiguang_appid;

	@Value("${jiguang_appsecret}")
	private String jiguang_appsecret;

	@Value("${wx_appid}")
	private String wx_appid;

	@Value("${wx_appsecret}")
	private String wx_appsecret;

	@Value("${wx_partnerkey}")
	private String wx_partnerkey;

	@Value("${wx_mch_id}")
	private String wx_mch_id;

	@Value("${wx_notify_url}")
	private String wx_notify_url;

	@Value("${alipay_app_id}")
	private String alipay_app_id;

	@Value("${alipay_private_key}")
	private String alipay_private_key;

	@Value("${alipay_public_key}")
	private String alipay_public_key;

	@Value("${alipay_notify_url}")
	private String alipay_notify_url;

	@Value("${is_real_pay}")
	private String is_real_pay;

	@Override
	public Object getPositions(PositionBean positionBean, PageBean pageBean) {
		List<PositionBean> totalPositionBeans = new ArrayList<PositionBean>();
		if(positionBean.getPosition_salary_names()!=null && !"".equals(positionBean.getPosition_salary_names())){
			String[] totalNames = positionBean.getPosition_salary_names().split(",");
			for(String s :totalNames){
				if(s.contains("以下")){
					positionBean.setSalary_start("0");
					positionBean.setSalary_end(s.substring(0, s.length()-2));
				} else if(s.contains("以上")){
					positionBean.setSalary_start(s.substring(0, s.length()-2));
					positionBean.setSalary_end("100000000000");
				}else{
					String[] salary = s.split("-");
					positionBean.setSalary_start(salary[0]);
					positionBean.setSalary_end(salary[1]);
				}
				List<PositionBean> positionBeans = positionDao.getPositions(positionBean, pageBean);
				for (PositionBean positionBean2 : positionBeans) {
					// 职位列表显示的多个岗位
					List<PositionClassBean> positionClassesBeans = positionDao
							.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean2.getPosition_id()));
					String names = "";
					for (PositionClassBean positionClassBean : positionClassesBeans) {
						names += positionClassBean.getPosition_class_name() + ",";
					}
					positionBean2.setPosition_class_names(names);
				}
				totalPositionBeans.addAll(positionBeans);
			}
		}else{
			List<PositionBean> positionBeans = positionDao.getPositions(positionBean, pageBean);
			for (PositionBean positionBean2 : positionBeans) {
				// 职位列表显示的多个岗位
				List<PositionClassBean> positionClassesBeans = positionDao
						.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean2.getPosition_id()));
				String names = "";
				for (PositionClassBean positionClassBean : positionClassesBeans) {
					names += positionClassBean.getPosition_class_name() + ",";
				}
				positionBean2.setPosition_class_names(names);
			}
			totalPositionBeans.addAll(positionBeans);
		}
		
		return pageBean.setObject(totalPositionBeans);
	}

	@Override
	public Object getPosition(PositionBean positionBean) {
		PositionBean positionBean2 = positionDao.getPosition(positionBean);
		if (positionBean2 != null) {
			// 获取职位的岗位中文名称
			List<PositionClassBean> positionClassesBeans = positionDao
					.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean2.getPosition_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			positionBean2.setPosition_class_names(names);
			MemberBean memberBean = memberService
					.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(positionBean2.getMember_id())));
			if (memberBean != null) {
				positionBean2.setMaterial_img(memberBean.getMember_img());
			}
			MaterialBean materialBean = positionDao.getMaterialById(
					new MaterialBean().setMaterial_id(Integer.valueOf(positionBean2.getMaterial_id())));
			if (materialBean != null) {
				positionBean2.setMaterial_name(materialBean.getMaterial_name());
			}

		}
		return positionBean2;
	}

	@Override
	public Object updatePosition(PositionBean positionBean) {
		double price2 = NumberUtils.Double(positionBean.getPrice());
		// 手续费比例
		PercentBean percentBean = positionDao
				.getPercentDetail(new PercentBean().setPercent_type("position_order_charge"));
		double charge_price =  price2 * NumberUtils.Integer(percentBean.getPercent_value()) / 100;
		double final_price = price2 -charge_price;
		int num = positionDao.updatePosition(positionBean.setFinal_price(String.valueOf(final_price)));
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object insertPosition(PositionBean positionBean) {
		List<MaterialBean> materialBeans = positionDao
				.getMaterialByMemberId(new MemberBean().setMember_id(Integer.valueOf(positionBean.getMember_id())));
		if (!CollectionUtils.isEmpty(materialBeans)) {
			PositionBean positionBean2 = positionBean
					.setMaterial_id(String.valueOf(materialBeans.get(0).getMaterial_id()));
			if("1".equals(positionBean.getPosition_type())){
				String str = sdf.format(new Date()); 
				positionBean2.setEnd_time(str);
				positionBean2.setStart_time(str);
			}
			
			double price2 = NumberUtils.Double(positionBean.getPrice());
			// 手续费比例
			PercentBean percentBean = positionDao
					.getPercentDetail(new PercentBean().setPercent_type("position_order_charge"));
			double charge_price =  price2 * NumberUtils.Integer(percentBean.getPercent_value()) / 100;
			double final_price = price2 -charge_price;
			int num = positionDao.insertPosition(positionBean2.setFinal_price(String.valueOf(final_price)));
			if (num <= 0) {
				throw new AppException("发布失败");
			}
			String[] positionClassesId = positionBean2.getPosition_classes_id().split(",");
			for (int i = 0; i < positionClassesId.length; i++) {
				num = positionDao
						.insertPositionClasses(new PositionClassesBean().setPosition_id(positionBean2.getPosition_id())
								.setPosition_class_id(Integer.valueOf(positionClassesId[i])).setType("1"));
				if (num <= 0) {
					throw new AppException("添加岗位失败");
				}
			}
		} else {
			throw new AppException("用户未认证");
		}

		return positionBean;

	}

	@Override
	public Object deletePosition(PositionBean positionBean) {
		int num = positionDao.deletePosition(positionBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object getPositionPersonss(PositionPersonsBean positionPersonsBean) {
		return positionDao.getPositionPersonss(positionPersonsBean);
	}

	@Override
	public Object updatePositionPersons(PositionPersonsBean positionPersonsBean) {
		String[] require_position_ids = positionPersonsBean.getRequire_position_id().split(",");
		int num = 1;
		for (int i = 0; i < require_position_ids.length; i++) {
			num = positionDao.updatePositionPersons(
					new PositionPersonsBean().setPosition_id(positionPersonsBean.getPosition_id())
							.setRequire_position_id(require_position_ids[i]).setState(positionPersonsBean.getState()));
			if (num <= 0) {
				throw new AppException("定人失败");
			}
		}
		String position_state = "1".equals(positionPersonsBean.getState()) ? "1"
				: "2".equals(positionPersonsBean.getState()) ? "2" : "";
		if (position_state == "1") {
			if ("0".equals(positionPersonsBean.getFull_person())) {
				position_state = "0";
			}
		}

		// 定人后修改职位为已定人
		num = positionDao.updatePosition(new PositionBean().setPosition_id(positionPersonsBean.getPosition_id())
				.setPosition_state(position_state));
		if (num <= 0) {
			throw new AppException("失败");
		}

		return positionDao.getPosition(new PositionBean().setPosition_id(positionPersonsBean.getPosition_id()));
	}

	@Override
	public Object agreeOfflinePositionPerson(PositionPersonsBean positionPersonsBean) {
		int num = 1;
		PositionPersonsBean positionPersonsBean2 = positionDao.getPositionPerson(positionPersonsBean);
		if (positionPersonsBean2 == null) {
			throw new AppException("未找到投递记录");
		}
		// 投递的记录显示是已完成工作的话就可以修改同意线下支付
		if ("2".equals(positionPersonsBean2.getState())) {
			num = positionDao.agreeOfflinePositionPerson(positionPersonsBean2);
			if (num <= 0) {
				throw new AppException("操作失败");
			}
		}
		return positionDao.getPosition(new PositionBean().setPosition_id(positionPersonsBean.getPosition_id()));
	}

	@Override
	public Object insertPositionPersons(PositionPersonsBean positionPersonsBean) {
		PositionPersonsBean positionPersonsBean2 = positionDao.getPositionPerson(positionPersonsBean);
		if (positionPersonsBean2 != null) {
			throw new AppException("重复投递");
		}
		// 判断活动时间冲突
		PositionBean positionBean = positionDao
				.getPosition(new PositionBean().setPosition_id(positionPersonsBean.getPosition_id()));

		List<RequirePositionBean> requirePositionBeans = positionDao
				.getRequirePositionByMemberId2(new MemberBean().setMember_id(positionPersonsBean.getMember_id()));
		int num = 2;
		if (!CollectionUtils.isEmpty(requirePositionBeans)) {
			RequirePositionBean requirePositionBean = requirePositionBeans.get(0);
			num = positionDao.insertPositionPersons(positionPersonsBean
					.setRequire_position_id(String.valueOf(requirePositionBean.getRequire_position_id())));
			if (num <= 0) {
				throw new AppException("投递失败");
			}
			List<PositionBean> positionBeans = positionDao.getPositionPersonList(
					new PositionPersonsBean().setMember_id(positionPersonsBean.getMember_id()).setState("1")
							.setCreate_time(positionBean.getStart_time()).setUpdate_time(positionBean.getEnd_time()));
			for (PositionBean positionBean2 : positionBeans) {
				if(positionBean2.getPosition_type().equals(positionBean.getPosition_type())){
					throw new AppException(positionBean2.getStart_time().substring(0, 19) + "与"
							+ positionBean2.getEnd_time().substring(0, 19) + "中有活动与本活动时间冲突");
				}
			}

		} else {
			throw new AppException("未找到用户简历信息");
		}
		return num;
	}

	@Override
	public Object deletePositionPersons(PositionPersonsBean positionPersonsBean) {
		int num = 1;
		List<RequirePositionBean> requirePositionBeans = positionDao
				.getRequirePositionByMemberId2(new MemberBean().setMember_id(positionPersonsBean.getMember_id()));
		if (!CollectionUtils.isEmpty(requirePositionBeans)) {
			num = positionDao.deletePositionPersons(positionPersonsBean
					.setRequire_position_id(String.valueOf(requirePositionBeans.get(0).getRequire_position_id())));
			if (num <= 0) {
				throw new AppException("失败");
			}
		} else {
			throw new AppException("未找到用户简历信息");
		}

		return num;
	}

	@Override
	public Object getRequirePositions(RequirePositionBean requirePositionBean, PageBean pageBean) {
		List<RequirePositionBean> requirePositionBeans = positionDao.getRequirePositions(requirePositionBean, pageBean);
		for (RequirePositionBean requirePositionBean2 : requirePositionBeans) {
			// 获取简历的岗位名称
			List<PositionClassBean> positionClassesBeans = positionDao.getPositionClassNames(
					new PositionClassesBean().setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			requirePositionBean2.setPosition_class_names(names);
			// 获取简历的薪资名称
			List<SalaryBean> salaryBeans = positionDao.getSalaryNames(new RequirePositionSalaryBean()
					.setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String salaryNames = "";
			for (SalaryBean salaryBean : salaryBeans) {
				salaryNames += salaryBean.getSalary_range() + ",";
			}
			requirePositionBean2.setRequire_position_salaries(salaryNames);
		}

		return pageBean.setObject(requirePositionBeans);
	}

	@Override
	public Object getRequirePositionByMemberId(RequirePositionBean requirePositionBean) {
		RequirePositionBean requirePositionBean2 = positionDao.getRequirePositionByMemberId(requirePositionBean);
		if (requirePositionBean2 != null) {
			// 获取简历的岗位名称
			List<PositionClassBean> positionClassesBeans = positionDao.getPositionClassNames(
					new PositionClassesBean().setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			requirePositionBean2.setPosition_class_names(names);
			// 获取简历的薪资名称
			List<SalaryBean> salaryBeans = positionDao.getSalaryNames(new RequirePositionSalaryBean()
					.setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String salaryNames = "";
			for (SalaryBean salaryBean : salaryBeans) {
				salaryNames += salaryBean.getSalary_range() + ",";
			}
			requirePositionBean2.setRequire_position_salaries(salaryNames);
		}
		return requirePositionBean2;
	}

	@Override
	public Object getRequirePosition(RequirePositionBean requirePositionBean) {
		RequirePositionBean requirePositionBean2 = positionDao.getRequirePosition(requirePositionBean);
		if (requirePositionBean2 != null) {
			// 获取简历的岗位名称
			List<PositionClassBean> positionClassesBeans = positionDao.getPositionClassNames(
					new PositionClassesBean().setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			requirePositionBean2.setPosition_class_names(names);
			// 获取简历的薪资名称
			List<SalaryBean> salaryBeans = positionDao.getSalaryNames(new RequirePositionSalaryBean()
					.setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String salaryNames = "";
			for (SalaryBean salaryBean : salaryBeans) {
				salaryNames += salaryBean.getSalary_range() + ",";
			}
			requirePositionBean2.setRequire_position_salaries(salaryNames);
		}
		return requirePositionBean2;
	}

	private String getTotalScore(RequirePositionBean requirePositionBean) {
		BigDecimal totalScore = new BigDecimal(0.00);
		if (requirePositionBean.getAge() != null && !"".equals(requirePositionBean.getAge())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_age"));
			if (resumeSettingBean != null) {
				double age = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(age));
			}
		}
		if (requirePositionBean.getHeight() != null && !"".equals(requirePositionBean.getHeight())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_height"));
			if (resumeSettingBean != null) {
				double height = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(height));
			}
		}
		if (requirePositionBean.getSex() != null && !"".equals(requirePositionBean.getSex())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_sex"));
			if (resumeSettingBean != null) {
				double sex = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(sex));
			}
		}
		if (requirePositionBean.getRequire_position_city() != null
				&& !"".equals(requirePositionBean.getRequire_position_city())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_address"));
			if (resumeSettingBean != null) {
				double address = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(address));
			}
		}
		if (requirePositionBean.getWeight() != null && !"".equals(requirePositionBean.getWeight())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_weight"));
			if (resumeSettingBean != null) {
				double weight = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(weight));
			}
		}
		if (requirePositionBean.getRequire_position_salaries_id() != null
				&& !"".equals(requirePositionBean.getRequire_position_salaries_id())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_salary"));
			if (resumeSettingBean != null) {
				double salary = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(salary));
			}
		}
		if (requirePositionBean.getPosition_class_id() != null
				&& !"".equals(requirePositionBean.getPosition_class_id())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_position_class"));
			if (resumeSettingBean != null) {
				double positionClass = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(positionClass));
			}
		}
		if (requirePositionBean.getStart_time() != null && !"".equals(requirePositionBean.getStart_time())) {
			ResumeSettingBean resumeSettingBean = positionDao
					.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_time"));
			if (resumeSettingBean != null) {
				double startTime = NumberUtils.Integer(resumeSettingBean.getPercent_value());
				totalScore = totalScore.add(BigDecimal.valueOf(startTime));
			}
		}
		return totalScore.toString();

	}

	@Override
	public Object updateRequirePosition(RequirePositionBean requirePositionBean) {
		List<RequirePositionBean> requirePositionBeans = positionDao
				.getRequirePositionByMemberId2(new MemberBean().setMember_id(requirePositionBean.getMember_id()));
		int num = 2;
		if (requirePositionBeans != null) {
			String totalScore = getTotalScore(requirePositionBean);
			RequirePositionBean requirePositionBean2 = positionDao.getRequirePosition(new RequirePositionBean()
					.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id()));
			if (requirePositionBean2 == null) {
				throw new AppException("未找到简历信息");
			}
			num = positionDao.updateRequirePosition(requirePositionBean.setTotal_score(totalScore)
					.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id()));
			if (num <= 0) {
				throw new AppException("修改简历失败");
			}
			List<PositionClassesBean> positionClassesBeans = positionDao
					.getPositionClassesByRequireId(new RequirePositionBean()
							.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id()));
			if (!CollectionUtils.isEmpty(positionClassesBeans)) {
				num = positionDao.deletePositionClasses(new PositionClassesBean()
						.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id()));
				if (num <= 0) {
					throw new AppException("修改简历关联岗位失败");
				}
			}
			List<RequirePositionSalaryBean> requirePositionSalaryBeans = positionDao
					.getSalarysByRequireId(new RequirePositionBean()
							.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id()));
			if (!CollectionUtils.isEmpty(requirePositionSalaryBeans)) {
				num = positionDao.deleteRequirePositionSalary(new RequirePositionSalaryBean()
						.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id()));
				if (num <= 0) {
					throw new AppException("修改简历关联薪资失败");
				}
			}
			if (requirePositionBean.getRequire_position_salaries_id() != ""
					&& requirePositionBean.getRequire_position_salaries_id() != null) {
				String[] requirePositionSalaryId = requirePositionBean.getRequire_position_salaries_id().split(",");
				for (int i = 0; i < requirePositionSalaryId.length; i++) {
					num = positionDao.insertRequirePositionSalary(new RequirePositionSalaryBean()
							.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id())
							.setSalary_id(Integer.valueOf(requirePositionSalaryId[i])));
					if (num <= 0) {
						throw new AppException("修改简历关联薪资失败");
					}
				}
			}
			if (requirePositionBean.getPosition_class_id() != ""
					&& requirePositionBean.getPosition_class_id() != null) {
				String[] positionClassesId = requirePositionBean.getPosition_class_id().split(",");
				for (int j = 0; j < positionClassesId.length; j++) {
					num = positionDao.insertPositionClasses(new PositionClassesBean()
							.setRequire_position_id(requirePositionBeans.get(0).getRequire_position_id())
							.setPosition_class_id(Integer.valueOf(positionClassesId[j])).setType("0"));
					if (num <= 0) {
						throw new AppException("修改简历关联岗位失败");
					}
				}
			}
		} else {
			throw new AppException("未找到用户简历");
		}

		return num;
	}

	@Override
	public Object insertRequirePosition(RequirePositionBean requirePositionBean) {
		List<RequirePositionBean> requirePositionBeans = positionDao
				.getRequirePositionByMemberId2(new MemberBean().setMember_id(requirePositionBean.getMember_id()));
		if (!CollectionUtils.isEmpty(requirePositionBeans)) {
			throw new AppException("用户重复添加简历！");
		}
		String totalScore = getTotalScore(requirePositionBean);
		int num = 1;

		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(requirePositionBean.getMember_id()));

		if (memberBean != null) {
			num = memberService.updateMemberDetail(
					new MemberBean().setMember_id(requirePositionBean.getMember_id()).setConsume_basic("1"));
			if (num <= 0) {
				throw new AppException("添加用户简历基础信息失败");
			}
			num = positionDao.insertRequirePosition(
					requirePositionBean.setTotal_score(totalScore).setHx_account(memberBean.getHx_account()));
			if (num <= 0) {
				throw new AppException("添加简历失败");
			}
		}

		return requirePositionBean;
	}

	@Override
	public Object deleteRequirePosition(String require_position_ids) {
		int num = 1;
		String[] require_position_id = require_position_ids.split(",");
		for (int i = 0; i < require_position_id.length; i++) {
			RequirePositionBean requirePositionBean = positionDao.getRequirePosition(
					new RequirePositionBean().setRequire_position_id(Integer.valueOf(require_position_id[i])));
			if (requirePositionBean != null) {

				List<PositionClassesBean> positionClassesBeans = positionDao.getPositionClassesByRequireId(
						new RequirePositionBean().setRequire_position_id(requirePositionBean.getRequire_position_id()));
				if (!CollectionUtils.isEmpty(positionClassesBeans)) {
					num = positionDao.deletePositionClasses(new PositionClassesBean()
							.setRequire_position_id(requirePositionBean.getRequire_position_id()));
					if (num <= 0) {
						throw new AppException("修改简历关联岗位失败");
					}
				}
				List<RequirePositionSalaryBean> requirePositionSalaryBeans = positionDao.getSalarysByRequireId(
						new RequirePositionBean().setRequire_position_id(requirePositionBean.getRequire_position_id()));
				if (!CollectionUtils.isEmpty(requirePositionSalaryBeans)) {
					num = positionDao.deleteRequirePositionSalary(new RequirePositionSalaryBean()
							.setRequire_position_id(requirePositionBean.getRequire_position_id()));
					if (num <= 0) {
						throw new AppException("修改简历关联薪资失败");
					}
				}
			}
			num = positionDao.deleteRequirePosition(
					new RequirePositionBean().setRequire_position_id(Integer.valueOf(require_position_id[i])));
			if (num <= 0) {
				throw new AppException("删除失败");
			}
		}
		return num;
	}

	@Override
	public Object insertMaterial(MaterialBean materialBean) {
		List<MaterialBean> materialBean2 = positionDao
				.getMaterialByMemberId(new MemberBean().setMember_id(materialBean.getMember_id()));
		if (!CollectionUtils.isEmpty(materialBean2)) {
			throw new AppException("用户重复填写招聘！");
		}
		if("1".equals(materialBean.getMaterial_type())){
			List<MaterialBean> materialBean3 = positionDao.getMaterialByIdCard(new MaterialBean().setId_card(materialBean.getId_card()));
			if (!CollectionUtils.isEmpty(materialBean3)) {
				throw new AppException("此身份证已经被认证！");
			}
		}
		int num = 1;
		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(materialBean.getMember_id()));
		String role_type = "0".equals(materialBean.getMaterial_type()) ? "1" : "1".equals(materialBean.getMaterial_type())?"2" :"0";
//		String role_type = "0".equals(materialBean.getMaterial_type()) ? "01" : "1".equals(materialBean.getMaterial_type())?"02" :"0";
		if (memberBean != null) {
			num = memberService.updateMemberDetail(
					new MemberBean().setMember_id(materialBean.getMember_id()).setRole_type(role_type));
			if (num <= 0) {
				throw new AppException("修改用户角色失败");
			}
			num = positionDao.insertMaterial(materialBean.setHx_account(memberBean.getHx_account()));
			if (num <= 0) {
				throw new AppException("发布招聘失败");
			}
		}

		return materialBean;
	}

	@Override
	public Object updateMaterial(MaterialBean materialBean) {
		int num = positionDao.updateMaterialById(materialBean);
		if (num <= 0) {
			throw new AppException("修改招聘失败");
		}
		MaterialBean materialBean2 = positionDao.getMaterialById(new MaterialBean().setMaterial_id(materialBean.getMaterial_id()));
		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(materialBean2.getMember_id()));
		String role_type = "0".equals(materialBean2.getMaterial_type()) ? "01" : "1".equals(materialBean2.getMaterial_type())?"02" :"0";
		if (memberBean != null) {
			num = memberService.updateMemberDetail(
					new MemberBean().setMember_id(materialBean2.getMember_id()).setRole_type(role_type));
			if (num <= 0) {
				throw new AppException("修改用户角色失败");
			}
		}
		return num;
	}

	@Override
	public Object insertAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {
		String order_no = new UUIDUtils(0).nextId(false, 10) + "";
		int num = positionDao.insertAdvertiseOrder(advertiseOrderBean.setOrder_no(order_no).setPay_type("0"));
		if (num <= 0) {
			throw new AppException("确认订单失败");
		}
		AdvertiseOrderBean advertiseOrderBean2 = positionDao.getAdvertiseOrder(
				new AdvertiseOrderBean().setAdvertise_order_id(advertiseOrderBean.getAdvertise_order_id()));

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(advertiseOrderBean2.getPay_end_time().substring(0, 19));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long unixTimestamp = date.getTime();
		long unixTimestamp2 = System.currentTimeMillis();
		long time_num = (unixTimestamp - unixTimestamp2) / 1000;
		advertiseOrderBean2.setTime_num(String.valueOf(time_num));
		return advertiseOrderBean2;
	}

	@Override
	public Object payRealAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {

		AdvertiseOrderBean advertiseOrderBean2 = positionDao.getAdvertiseOrder(advertiseOrderBean);
		if (advertiseOrderBean2 == null) {
			throw new AppException("订单不存在!");
		}
		if (!"0".equals(advertiseOrderBean2.getOrder_state())) {
			throw new AppException("非待支付订单!");
		}
		double order_price = NumberUtils.Double(advertiseOrderBean2.getOrder_pay_first());
		String out_trade_no = "g" + new UUIDUtils(0).nextId(false, 10) + "";// 商品支付单号
		advertiseOrderBean.setOut_trade_no(out_trade_no);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);

		Map<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(advertiseOrderBean.getPay_way())) {
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);// total_fee

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}
			advertiseOrderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(advertiseOrderBean.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price, 2) : 0.01);
			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			advertiseOrderBean.setPay_charge(result);
		}
		int num = positionDao.updateAdvertiseOrder(advertiseOrderBean);
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		if ("wx".equals(advertiseOrderBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(advertiseOrderBean.getPay_way())) {
			return result;
		}
		return null;

	}

	@Override
	public Object payOrderCallback(AdvertiseOrderBean advertiseOrderBean) {

		AdvertiseOrderBean advertiseOrderBean2 = positionDao.getAdvertiseOrder(advertiseOrderBean);
		if (advertiseOrderBean2 == null) {
			throw new AppException("订单不存在!");
		}

		if (!"0".equals(advertiseOrderBean2.getOrder_state())) {
			throw new AppException("非待支付订单!");
		}

		AdvertiseOrderBean advertiseOrderBean3 = new AdvertiseOrderBean()
				.setAdvertise_order_id(advertiseOrderBean2.getAdvertise_order_id())
				.setMember_id(advertiseOrderBean2.getMember_id()).setPay_way(advertiseOrderBean2.getPay_way());

		int num = positionDao.payAdvertiseOrder(advertiseOrderBean3);
		if (num <= 0) {
			throw new AppException("付款失败!");
		}
		// 支付订单需要修改职位线上还是线下付款 以及职位已定实际工作人状态
		if ("2".equals(advertiseOrderBean2.getOrder_type())) {
			num = positionDao.updatePosition(new PositionBean().setPosition_id(advertiseOrderBean2.getPosition_id())
					.setOnline("1").setPosition_state("2"));
			if (num <= 0) {
				throw new AppException("职位付款状态修改失败!");
			}
		}
		String price = advertiseOrderBean2.getOrder_type().equals("1") ? advertiseOrderBean2.getOrder_pay_first()
				: advertiseOrderBean2.getOrder_pay_second();
		String title = advertiseOrderBean2.getOrder_type().equals("1") ? "押金支付" : "活动支付";
		num = positionDao
				.insertPayDetail(new PayDetailBean().setAdvertise_order_id(advertiseOrderBean2.getAdvertise_order_id())
						.setAdvertise_order_no(advertiseOrderBean2.getOrder_no())
						.setMember_id(advertiseOrderBean2.getMember_id()).setPay_detail_type("pay")
						.setPay_detail_no(advertiseOrderBean2.getOut_trade_no()).setPay_detail_title(title)
						.setPay_way(advertiseOrderBean2.getPay_way()).setPrice(price));
		if (num <= 0) {
			throw new AppException("明细添加失败!");
		}
		return num;
	}

	@Override
	public Object getAdvertiseOrderPay(String invitation_num, String price) {
		Map<String, Object> payMap = new HashMap<String, Object>();
		double invitation_num2 = NumberUtils.Double(invitation_num);
		double price2 = NumberUtils.Double(price);
		// 手续费比例
		PercentBean percentBean = positionDao
				.getPercentDetail(new PercentBean().setPercent_type("position_order_charge"));
		double charge_price = invitation_num2 * price2 * NumberUtils.Integer(percentBean.getPercent_value()) / 100;
		// 押金比例
		PercentBean percentBean2 = positionDao
				.getPercentDetail(new PercentBean().setPercent_type("position_order_pay"));
		double pay_price = invitation_num2 * price2 * NumberUtils.Integer(percentBean2.getPercent_value()) / 100;
		double total_price = invitation_num2 * price2;
//		double first_price = add(pay_price, charge_price);
		// 用户需支付的手续费 总费用
		payMap.put("order_fee", charge_price);
		// 押金
		payMap.put("advertise_order_total", pay_price);
		// 首款 即押金
		payMap.put("order_pay_first", pay_price);
		// 尾款
		payMap.put("order_pay_second", total_price);

		return payMap;

	}

	public double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public double subtract(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	@Override
	public Object getPositionClasss(PositionClassBean positionClassBean) {
		List<PositionClassBean> positionClassBeans = positionDao.getPositionClasss(positionClassBean);
		return positionClassBeans;
	}

	@Override
	public Object getSalarys(SalaryBean salaryBean) {
		List<SalaryBean> salaryBeans = positionDao.getSalarys(salaryBean);
		return salaryBeans;
	}

	@Override
	public Object searchPositions(PositionBean positionBean, PageBean pageBean) {
		List<PositionBean> positionBeans = positionDao.searchPositions(positionBean, pageBean);
		for (PositionBean positionBean2 : positionBeans) {
			// 职位列表显示的多个岗位
			List<PositionClassBean> positionClassesBeans = positionDao
					.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean2.getPosition_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			positionBean2.setPosition_class_names(names);
		}
		return pageBean.setObject(positionBeans);
	}

	@Override
	public Object searchRequirePositions(RequirePositionBean requirePositionBean, PageBean pageBean) {
		List<RequirePositionBean> requirePositionBeans = positionDao.searchRequirePositions(requirePositionBean,
				pageBean);
		for (RequirePositionBean requirePositionBean2 : requirePositionBeans) {
			// 获取简历的岗位名称
			List<PositionClassBean> positionClassesBeans = positionDao.getPositionClassNames(
					new PositionClassesBean().setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			requirePositionBean2.setPosition_class_names(names);
			// 获取简历的薪资名称
			List<SalaryBean> salaryBeans = positionDao.getSalaryNames(new RequirePositionSalaryBean()
					.setRequire_position_id(requirePositionBean2.getRequire_position_id()));
			String salaryNames = "";
			for (SalaryBean salaryBean : salaryBeans) {
				salaryNames += salaryBean.getSalary_range() + ",";
			}
			requirePositionBean2.setRequire_position_salaries(salaryNames);
		}
		return pageBean.setObject(requirePositionBeans);
	}

	@Override
	public Object getMaterial(PositionBean positionBean) {
		return positionDao.getMaterial(positionBean);
	}

	@Override
	public Object getPositionPersons(PositionPersonsBean positionPersonsBean, PageBean pageBean) {
		PositionBean positionBean = positionDao
				.getPosition(new PositionBean().setPosition_id(positionPersonsBean.getPosition_id()));
		if (positionBean == null) {
			throw new AppException("职位不存在!");
		}
		// 0 发布中 1 已定人 2 已结束
		String state = "0".equals(positionBean.getPosition_state()) ? "0,1"
				: "1".equals(positionBean.getPosition_state()) ? "1"
						: "2".equals(positionBean.getPosition_state()) ? "2" : "";
		List<RequirePositionBean> requirePositionBeans = positionDao
				.getPositionPersons(positionPersonsBean.setState(state), pageBean);
		for (RequirePositionBean requirePositionBean : requirePositionBeans) {
			MemberAssessmentBean memberAssessmentBean = positionDao
					.getMemberAssessment(new MemberAssessmentBean().setMember2_id(requirePositionBean.getMember_id())
							.setMember_id(Integer.valueOf(positionBean.getMember_id())));
			if (memberAssessmentBean != null) {
				requirePositionBean.setIs_comment("1");
			} else {
				requirePositionBean.setIs_comment("0");
			}
		}
		return pageBean.setObject(requirePositionBeans);
	}

	@Override
	public Object insertFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {
		// 通过职位id找到原有的押金订单信息
		AdvertiseOrderBean advertiseOrderBean2 = positionDao.getAdvertiseOrder(advertiseOrderBean.setOrder_type("1"));
		String order_no = new UUIDUtils(0).nextId(false, 10) + "";
		int num = positionDao
				.insertFinalAdvertiseOrder(advertiseOrderBean2.setPay_type(advertiseOrderBean.getPay_type())
						.setOrder_pay_second(advertiseOrderBean.getOrder_pay_second()).setOrder_no(order_no)
						.setPay_charge("").setOut_trade_no("").setOrder_state("0"));// 待支付状态
		if (num <= 0) {
			throw new AppException("确认发布订单失败");
		}
		AdvertiseOrderBean advertiseOrderBean3 = positionDao.getAdvertiseOrder(
				new AdvertiseOrderBean().setAdvertise_order_id(advertiseOrderBean2.getAdvertise_order_id()));
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(advertiseOrderBean3.getPay_end_time().substring(0, 19));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long unixTimestamp = date.getTime();
		long unixTimestamp2 = System.currentTimeMillis();
		long time_num = (unixTimestamp - unixTimestamp2) / 1000;
		advertiseOrderBean3.setTime_num(String.valueOf(time_num));
		// 线下付款修改职位状态为线下付款完成
		if ("1".equals(advertiseOrderBean3.getPay_type())) {
			// 判断此职位的所有已完成用户是否同意线下付款
			List<PositionPersonsBean> positionPersonsBeans = positionDao.getPositionPersonss(
					new PositionPersonsBean().setPosition_id(advertiseOrderBean.getPosition_id()).setState("2"));
			if (CollectionUtils.isEmpty(positionPersonsBeans)) {
				throw new AppException("职位投递记录为空");
			}
			for (PositionPersonsBean positionPersonsBean : positionPersonsBeans) {
				if (!"1".equals(positionPersonsBean.getAgree_offline())) {
					throw new AppException("用户未同意线下支付");
				}
			}
			num = positionDao.updatePosition(new PositionBean().setPosition_id(advertiseOrderBean.getPosition_id())
					.setOnline("0").setPosition_state("2"));
			if (num <= 0) {
				throw new AppException("职位付款状态修改失败");
			}
			PositionBean positionBean2 = positionDao
					.getPosition(new PositionBean().setPosition_id(advertiseOrderBean.getPosition_id()));
			if (positionBean2 != null) {
				// 获取职位的岗位中文名称
				List<PositionClassBean> positionClassesBeans = positionDao.getPositionClassNames(
						new PositionClassesBean().setPosition_id(positionBean2.getPosition_id()));
				String names = "";
				for (PositionClassBean positionClassBean : positionClassesBeans) {
					names += positionClassBean.getPosition_class_name() + ",";
				}
				positionBean2.setPosition_class_names(names);
				MemberBean memberBean = memberService
						.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(positionBean2.getMember_id())));
				if (memberBean != null) {
					positionBean2.setMaterial_img(memberBean.getMember_img());
				}
				MaterialBean materialBean = positionDao.getMaterialById(
						new MaterialBean().setMaterial_id(Integer.valueOf(positionBean2.getMaterial_id())));
				if (materialBean != null) {
					positionBean2.setMaterial_name(materialBean.getMaterial_name());
				}

			}
			return positionBean2;
		}
		return advertiseOrderBean3;
	}

	@Override
	public Object payFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {
		AdvertiseOrderBean advertiseOrderBean2 = positionDao.getAdvertiseOrder(advertiseOrderBean);
		if (advertiseOrderBean2 == null) {
			throw new AppException("订单不存在!");
		}
		if (!"0".equals(advertiseOrderBean2.getOrder_state())) {
			throw new AppException("非待支付订单!");
		}
		double order_price = NumberUtils.Double(advertiseOrderBean2.getOrder_pay_second());// 尾款
		String out_trade_no = "g" + new UUIDUtils(0).nextId(false, 10) + "";// 商品支付单号
		advertiseOrderBean.setOut_trade_no(out_trade_no);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);

		Map<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(advertiseOrderBean.getPay_way())) {
			map.put("notify_url", wx_notify_url);
			map.put("wx_appid", wx_appid);
			map.put("wx_appsecret", wx_appsecret);
			map.put("wx_partnerkey", wx_partnerkey);
			map.put("wx_mch_id", wx_mch_id);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price * 100) : 1);// total_fee

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}
			advertiseOrderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(advertiseOrderBean.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_price, 2) : 0.01);
			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			advertiseOrderBean.setPay_charge(result);
		}
		int num = positionDao.updateAdvertiseOrder(advertiseOrderBean);
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		if ("wx".equals(advertiseOrderBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(advertiseOrderBean.getPay_way())) {
			return result;
		}
		return null;
	}

	@Override
	public PositionPersonsBean getPositionPerson(PositionPersonsBean positionPersonsBean) {
		// TODO Auto-generated method stub
		return positionDao.getPositionPerson(positionPersonsBean);
	}

	@Override
	public AdvertiseOrderBean getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean) {
		// TODO Auto-generated method stub
		return positionDao.getAdvertiseOrder(advertiseOrderBean);
	}

	@Override
	public Object updateBankCard(BankCardBean bankCardBean) {
		int num = positionDao.updateBankCard(bankCardBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(bankCardBean.getMember_id())));
		if (memberBean != null) {
			if ("member".equals(bankCardBean.getRole_type())) {
				num = memberService.updateMemberDetail(
						new MemberBean().setMember_id(memberBean.getMember_id()).setPay_account("1"));
				if (num <= 0) {
					throw new AppException("修改失败");
				}
			}
			if ("shop".equals(bankCardBean.getRole_type())) {
				num = memberService.updateMemberDetail(
						new MemberBean().setMember_id(memberBean.getMember_id()).setShop_pay_account("1"));
				if (num <= 0) {
					throw new AppException("修改失败");
				}
			}

		}

		return num;
	}

	@Override
	public Object insertBankCard(BankCardBean bankCardBean) {
		int num = positionDao.insertBankCard(bankCardBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		MemberBean memberBean = memberService
				.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(bankCardBean.getMember_id())));

		if (memberBean != null) {
			if ("member".equals(bankCardBean.getRole_type())) {
				num = memberService.updateMemberDetail(
						new MemberBean().setMember_id(memberBean.getMember_id()).setPay_account("1"));
				if (num <= 0) {
					throw new AppException("修改失败");
				}
			}
			if ("shop".equals(bankCardBean.getRole_type())) {
				num = memberService.updateMemberDetail(
						new MemberBean().setMember_id(memberBean.getMember_id()).setShop_pay_account("1"));
				if (num <= 0) {
					throw new AppException("修改失败");
				}
			}

		}
		return bankCardBean;
	}

	@Override
	public Object getinvateRequirePositions(RequirePositionBean requirePositionBean, PageBean pageBean) {
		ResumeSettingBean resumeSettingBean = positionDao
				.getResumeSettingDetail(new ResumeSettingBean().setPercent_type("percent_standard"));
		List<RequirePositionBean> requirePositionBeans = null;
		if (resumeSettingBean != null) {
			String value = resumeSettingBean.getPercent_value();
			requirePositionBeans = positionDao
					.getinvateRequirePositions(new RequirePositionBean().setTotal_score(value));
		}
		return pageBean.setObject(requirePositionBeans);
	}

	@Override
	public Object inviteRequirePosition(String position_id, String require_position_id) {
		RequirePositionBean requirePositionBean = positionDao.getRequirePosition(
				new RequirePositionBean().setRequire_position_id(Integer.valueOf(require_position_id)));
		if (requirePositionBean != null) {
			 String member_id = String.valueOf(requirePositionBean.getMember_id());
			 MemberBean memberBean = positionDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(member_id)));
			 String member_jiguang_token = memberBean.getJiguang_token();
			 Map<String, String> map = new HashMap<String, String>();
			 map.put("position_id", position_id);
			 JPushUtils.sendNotificationByID(jiguang_appid,jiguang_appsecret,member_jiguang_token,"这里有一份职位邀请，请查收",JSON.toJSONString(map));
		}
		return "1";
	}

	@Override
	public Object getFinalPositionPersonsByMember(PositionPersonsBean positionPersonsBean, PageBean pageBean) {
		List<PositionBean> positionBeans = positionDao.getFinalPositionPersonsByMember(positionPersonsBean);

		for (PositionBean positionBean : positionBeans) {
			// 根据用户id和认证id查看是否有数据 有返回1 没有 返回0
			List<AssessmentBean> assessmentBeans = positionDao.getAssessmentByMemberAndMaterial(
					new AssessmentBean().setMember_id(positionPersonsBean.getMember_id())
							.setMaterial_id(Integer.valueOf(positionBean.getMaterial_id())));
			if (!CollectionUtils.isEmpty(assessmentBeans)) {
				positionBean.setIs_comment("1");
			} else {
				positionBean.setIs_comment("0");
			}
			// 职位列表显示的多个岗位
			List<PositionClassBean> positionClassesBeans = positionDao
					.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean.getPosition_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			positionBean.setPosition_class_names(names);
		}

		return pageBean.setObject(positionBeans);
	}

	@Override
	public Object getMiddlePositionPersonsByMember(PositionPersonsBean positionPersonsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<PositionBean> positionBeans = positionDao.getMiddlePositionPersonsByMember(positionPersonsBean);

		for (PositionBean positionBean : positionBeans) {

			// 职位列表显示的多个岗位
			List<PositionClassBean> positionClassesBeans = positionDao
					.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean.getPosition_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			positionBean.setPosition_class_names(names);
		}
		return pageBean.setObject(positionBeans);
	}
	@Override
	public Object getFinalAmountByMember(PositionPersonsBean positionPersonsBean) {
		// TODO Auto-generated method stub
		Map<String, Object> amountMap = new HashMap<String, Object>();
		PositionBean positionBean = positionDao.getFinalAmountByMember(positionPersonsBean);
		if(positionBean !=null){
			amountMap.put("totalPrice", positionBean.getFinal_price());
		}else{
			amountMap.put("totalPrice",0.00);
		}
		return amountMap;
	}
	@Override
	public Object getPositionPersonsByMember(PositionPersonsBean positionPersonsBean, PageBean pageBean) {
		List<PositionBean> positionBeans = positionDao.getPositionPersonsByMember(positionPersonsBean);

		for (PositionBean positionBean : positionBeans) {

			// 职位列表显示的多个岗位
			List<PositionClassBean> positionClassesBeans = positionDao
					.getPositionClassNames(new PositionClassesBean().setPosition_id(positionBean.getPosition_id()));
			String names = "";
			for (PositionClassBean positionClassBean : positionClassesBeans) {
				names += positionClassBean.getPosition_class_name() + ",";
			}
			positionBean.setPosition_class_names(names);
		}
		return pageBean.setObject(positionBeans);
	}

	@Override
	public Object getAssessmentByMember(AssessmentBean assessmentBean) {
		return positionDao.getAssessmentByMember(assessmentBean);
	}

	@Override

	public Object getMemberAssessment(MemberAssessmentBean memberAssessmentBean) {
		return positionDao.getMemberAssessment(memberAssessmentBean);
	}

	@Override
	public Object insertAssessment(AssessmentBean assessmentBean) {
		if (assessmentBean.getParent_id() == null || "".equals(assessmentBean.getParent_id())) {
			// 给公司评论数加1
			MaterialBean materialBean = positionDao
					.getMaterialById(new MaterialBean().setMaterial_id(assessmentBean.getMaterial_id()));
			int comment_num = materialBean.getComment_num();
			comment_num++;
			int num = positionDao.updateMaterialById(
					new MaterialBean().setComment_num(comment_num).setMaterial_id(materialBean.getMaterial_id()));
			if (num <= 0) {
				throw new AppException("评论失败!");
			}
		}
		
		return positionDao.insertAssessment(assessmentBean);
	}

	@Override
	public Object getAssessmentsByMaterial(AssessmentBean assessmentBean, PageBean pageBean) {
		List<AssessmentBean> assessmentBeans = positionDao.getAssessmentsByMaterial(assessmentBean);
		
		return pageBean.setObject(assessmentBeans);
	}

	@Override
	public Object getMaterialById(MaterialBean materialBean) {
		// TODO Auto-generated method stub
		return positionDao.getMaterialById(materialBean);
	}

	@Override
	public Object getPositionsByMaterialId(PositionBean positionBean, PageBean pageBean) {
		List<MaterialBean> materialBeans = positionDao
				.getMaterialByMemberId(new MemberBean().setMember_id(Integer.valueOf(positionBean.getMember_id())));
		List<PositionBean> positionBeans = null;
		if (!CollectionUtils.isEmpty(materialBeans)) {
			positionBeans = positionDao.getPositionsByMaterialId(
					positionBean.setMaterial_id(String.valueOf(materialBeans.get(0).getMaterial_id())));
			for (PositionBean positionBean2 : positionBeans) {
				// 职位列表显示的多个岗位
				List<PositionClassBean> positionClassesBeans = positionDao.getPositionClassNames(
						new PositionClassesBean().setPosition_id(positionBean2.getPosition_id()));
				String names = "";
				for (PositionClassBean positionClassBean : positionClassesBeans) {
					names += positionClassBean.getPosition_class_name() + ",";
				}
				positionBean2.setPosition_class_names(names);
			}
		} else {
			throw new AppException("未找到用户认证资料!");
		}

		return pageBean.setObject(positionBeans);
	}

	@Override
	public Object insertMemberAssessment(MemberAssessmentBean memberAssessmentBean) {
		if (memberAssessmentBean.getParent_id() == null || "".equals(memberAssessmentBean.getParent_id())) {
			// 给用户评论数加1
			MemberBean memberBean = positionDao
					.getMemberDetail(new MemberBean().setMember_id(memberAssessmentBean.getMember2_id()));
			int comment_num = memberBean.getComment_num();
			comment_num++;
			int num = positionDao.updateMemberById(
					new MemberBean().setComment_num(comment_num).setMember_id(memberAssessmentBean.getMember2_id()));
			if (num <= 0) {
				throw new AppException("评论失败!");
			}
		}
		int new_identity = Integer.valueOf(memberAssessmentBean.getAssessment_identity());
		int new_attitude = Integer.valueOf(memberAssessmentBean.getAssessment_attitude());
		int new_skill = Integer.valueOf(memberAssessmentBean.getAssessment_skill());
		
		//给简历的评论数加1
		if (memberAssessmentBean.getParent_id() == null || "".equals(memberAssessmentBean.getParent_id())) {
			// 给简历评论数加1
			RequirePositionBean requirePositionBean = positionDao.getRequirePositionByMemberId(new RequirePositionBean()
					.setMember_id(memberAssessmentBean.getMember2_id()));
			if(requirePositionBean == null){
				throw new AppException("用户简历不存在!");
			}
			int comment_count = requirePositionBean.getComment_count();
			int total_assess_identity = requirePositionBean.getComment_count() * requirePositionBean.getAssessment_identity();
			int total_assess_skill = requirePositionBean.getComment_count() * requirePositionBean.getAssessment_skill();
			int total_assess_attitdue = requirePositionBean.getComment_count() * requirePositionBean.getAssessment_attitude();
			total_assess_identity = total_assess_identity + new_identity;
			total_assess_attitdue = total_assess_attitdue + new_attitude;
			total_assess_skill = total_assess_skill + new_skill;
			comment_count =comment_count+1;
			double final_identity = NumberUtils.divide(NumberUtils.KeepDecimal(total_assess_identity,0), NumberUtils.KeepDecimal(comment_count, 0));
			int identity = NumberUtils.KeepDecimal(final_identity);
			double final_attitude = NumberUtils.divide(NumberUtils.KeepDecimal(total_assess_attitdue,0), NumberUtils.KeepDecimal(comment_count, 0));
			int attitude = NumberUtils.KeepDecimal(final_attitude);
			double final_skill = NumberUtils.divide(NumberUtils.KeepDecimal(total_assess_skill,0), NumberUtils.KeepDecimal(comment_count, 0));
			int skill = NumberUtils.KeepDecimal(final_skill);
			int num = positionDao.updateRequirePosition(new RequirePositionBean()
					.setRequire_position_id(requirePositionBean.getRequire_position_id())
					.setComment_count(comment_count)
					.setAssessment_identity(identity)
					.setAssessment_attitude(attitude)
					.setAssessment_skill(skill));
			if (num <= 0) {
				throw new AppException("评论失败!");
			}
		}
		List<MaterialBean> materialBean = positionDao
				.getMaterialByMemberId(new MemberBean().setMember_id(memberAssessmentBean.getMember_id()));
		if(CollectionUtils.isEmpty(materialBean)){
			throw new AppException("错误:商家认证资料不存在!");
		}
		MaterialBean materialBean2 = materialBean.get(0);
		
		MemberAssessmentBean memberAssessmentBean2 = memberAssessmentBean
				.setMaterial_name(materialBean2.getMaterial_name())
				.setMaterial_id(materialBean2.getMaterial_id());
		int num = positionDao.insertMemberAssessment(memberAssessmentBean2);
		if (num <= 0) {
			throw new AppException("评论失败!");
		}
			
		

		return memberAssessmentBean;
	}

	@Override
	public Object getPayDetailsByMember(PayDetailBean payDetailBean, PageBean pageBean) {
		List<PayDetailBean> payDetailBeans = positionDao.getPayDetailsByMember(payDetailBean);
		return pageBean.setObject(payDetailBeans);
	}

	@Override
	public Object getBankCardByMemberId(BankCardBean bankCardBean) {
		// TODO Auto-generated method stub
		return positionDao.getBankCardByMemberId(bankCardBean);
	}

	@Override
	public Object getMemberAssessmentByMemberId(MemberAssessmentBean memberAssessmentBean, PageBean pageBean) {
		List<MemberAssessmentBean> memberAssessmentBeans = positionDao
				.getMemberAssessmentByMemberId(memberAssessmentBean);
		
		return pageBean.setObject(memberAssessmentBeans);
	}

	@Override
	public Object getMaterialByMemberId(MemberBean memberBean) {
		List<MaterialBean> materialBeans = positionDao
				.getMaterialByMemberId(new MemberBean().setMember_id(memberBean.getMember_id()));
		if (!CollectionUtils.isEmpty(materialBeans)) {
			return materialBeans.get(0);
		}
		return null;
	}

	@Override
	public Object timeingCloseOrders(AdvertiseOrderBean advertiseOrderBean) {
		// 查看职位列表 已付款的且活动结束时间是当前时间
		List<PositionBean> positionBeans = positionDao.getPositionByClose(new PositionBean());
		for (PositionBean positionBean : positionBeans) {
			int num = positionDao.updatePosition(
					new PositionBean().setPosition_id(positionBean.getPosition_id()).setPosition_state("4"));
			if (num <= 0) {
				throw new AppException("修改失败!");
			}
		}
		// 查看职位列表 未付款的且活动结束时间是当前时间-12小时的
		List<PositionBean> positionBeans2 = positionDao.getPositionByClose2(new PositionBean());
		for (PositionBean positionBean : positionBeans2) {
			int num = positionDao.updatePosition(
					new PositionBean().setPosition_id(positionBean.getPosition_id()).setPosition_state("4"));
			if (num <= 0) {
				throw new AppException("修改失败!");
			}
		}
		return null;
	}

	@Override
	public Object getMemberSignByMemberId(MemberSignBean memberSignBean) {
		MemberSignBean memberSignBean2 = positionDao.getMemberSignByMemberId(memberSignBean);
		if(memberSignBean2 == null){
			//没有签到信息 
			return 0;
		}
		//获取今天的签到信息
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		String last_modify_time = memberSignBean2.getLast_modify_time().substring(0, 10);
		if(today.equals(last_modify_time)){
			//最近签到时间与系统时间相等 表示今日已经签到
			return 1;
		}else{
			//不相等 未签到
			return 0;
		}
	}

	@Override
	public Object updateMemberSign(MemberSignBean memberSignBean) {
		int num =1;
		MemberSignBean memberSignBean2 = positionDao.getMemberSignByMemberId(memberSignBean);
		if(memberSignBean2 == null){
			//没有签到信息 添加签到记录
			 num = positionDao.insertMemberSign(memberSignBean);
			if(num <= 0){
				throw new AppException("签到失败!");
			}
		}else{
			//有签到信息记录 修改签到信息
			int count = NumberUtils.Integer(memberSignBean2.getCount());
			count++;
			num = positionDao.updateMemberSign(new MemberSignBean().setCount(count+"").setSign_id(memberSignBean2.getSign_id()));
			if(num <= 0){
				throw new AppException("签到失败!");
			}
		}
		//签到后增加用户颜值币
		MemberBean memberBean = positionDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberSignBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		monnaie = monnaie + 10;
		num = memberService.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

}