package tst.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.ResumeSettingBean;
import tst.project.bean.information.SalaryBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.information.controller.IPositionServiceC;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/positionController/v1.0")
public class PositionController {
	@Autowired
	IPositionServiceC positionServiceC;
	@Autowired
	ISystemService systemService;
	
	/**
	 * 修改打款状态
	 * @param positionPersonsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePositionPersonRemit")
	@AppController(isVerSystemToken=true)
	public Object updatePositionPersonRemit(PositionPersonsBean positionPersonsBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改打款状态,打款对象用户id:"+positionPersonsBean.getMember_id())
				.setOperate_type("update")
				.setModule_id(positionPersonsBean.getMember_id()+"")
				.setModule_name("职模块"));
		return positionServiceC.updatePositionPersonRemit(positionPersonsBean);
	}
	/**
	 * 简历列表
	 * @param positionPersonsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRequirePositions")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getRequirePositions(PositionPersonsBean positionPersonsBean, PageBean pageBean)throws Exception{
		return positionServiceC.getRequirePositions(positionPersonsBean, pageBean);
	}
	/**
	 * 认证列表
	 * @param materialBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMaterials")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMaterials(MaterialBean materialBean, PageBean pageBean)throws Exception{
		return positionServiceC.getMaterials(materialBean, pageBean);
	}	
	/**
	 * 修改认证资料
	 * @param materialBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMaterial")
	@AppController(isVerSystemToken=true)
	public Object updateMaterial(MaterialBean materialBean,HttpServletRequest request)throws Exception{
		String desc = "1".equals(materialBean.getMaterial_state())?"审核同意":"审核拒绝";
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("审核认证资料,认证资料id:"+materialBean.getMaterial_id()+" 操作结果:"+desc)
				.setOperate_type("update")
				.setModule_id(materialBean.getMaterial_id()+"")
				.setModule_name("职模块"));
		return positionServiceC.updateMaterial(materialBean);
	}	
	/**
	 * 认证资料
	 * @param materialBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMaterial")
	@AppController(isVerSystemToken=true)
	public Object getMaterial(MaterialBean materialBean)throws Exception{
		return positionServiceC.getMaterial(materialBean);
	}
	/**
	 * 职位分类
	 * @param positionClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositionClasss")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getPositionClasss(PositionClassBean positionClassBean, PageBean pageBean)throws Exception{
		return positionServiceC.getPositionClasss(positionClassBean, pageBean);
	}	
	/**
	 * 修改职位分类
	 * @param positionClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePositionClass")
	@AppController(isVerSystemToken=true)
	public Object updatePositionClass(PositionClassBean positionClassBean)throws Exception{
		return positionServiceC.updatePositionClass(positionClassBean);
	}	
	/**
	 * 职位分类
	 * @param positionClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositionClass")
	@AppController(isVerSystemToken=true)
	public Object getPositionClass(PositionClassBean positionClassBean)throws Exception{
		return positionServiceC.getPositionClass(positionClassBean);
	}
	/**
	 * 删除职位分类
	 * @param positionClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletePositionClass") 
    @AppController(isVerSystemToken=true)
    public Object deletePositionClass(PositionClassBean positionClassBean) throws Exception{ 
		return positionServiceC.deletePositionClass(positionClassBean);
	}
	/**
	 * 职位分类
	 * @param positionClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertPositionClass") 
    @AppController(isVerSystemToken=true)
	public Object insertPositionClass(PositionClassBean positionClassBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("新增职位分类，分类名称为:"+positionClassBean.getPosition_class_name())
				.setOperate_type("insert")
				.setModule_name("职模块"));
		return positionServiceC.insertPositionClass(positionClassBean);
	}
	/**
	 * 薪资列表
	 * @param salaryBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSalarys")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getSalarys(SalaryBean salaryBean, PageBean pageBean)throws Exception{
		return positionServiceC.getSalarys(salaryBean, pageBean);
	}	
	/**
	 * 修改薪资
	 * @param salaryBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSalary")
	@AppController(isVerSystemToken=true)
	public Object updateSalary(SalaryBean salaryBean)throws Exception{
		return positionServiceC.updateSalary(salaryBean);
	}	
	/**
	 * 薪资详情
	 * @param salaryBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSalary")
	@AppController(isVerSystemToken=true)
	public Object getSalary(SalaryBean salaryBean)throws Exception{
		return positionServiceC.getSalary(salaryBean);
	}
	/**
	 * 删除薪资
	 * @param salaryBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteSalary") 
    @AppController(isVerSystemToken=true)
    public Object deleteSalary(SalaryBean salaryBean) throws Exception{ 
		return positionServiceC.deleteSalary(salaryBean);
	}
	/**
	 * 添加薪资分类
	 * @param salaryBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSalary") 
    @AppController(isVerSystemToken=true)
	public Object insertSalary(SalaryBean salaryBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("新增薪资分类,分类名称为:"+salaryBean.getSalary_range())
				.setOperate_type("insert")
				.setModule_name("职模块"));
		return positionServiceC.insertSalary(salaryBean);
	}
	
	/**
	 * 简历设置列表
	 * @param resumeSettingBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getResumeSettings")
	@AppController(isVerSystemToken=true)
	public Object getResumeSettings(ResumeSettingBean resumeSettingBean)throws Exception{
		return positionServiceC.getResumeSettings(resumeSettingBean);
	}	
	/**
	 * 修改简历设置
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateResumeSetting")
	@AppController(isVerSystemToken=true)
	public Object updateResumeSetting(String json)throws Exception{
		return positionServiceC.updateResumeSetting(JSON.parseArray(json, ResumeSettingBean.class));
	}	
	/**
	 * 职位列表
	 * @param positionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositions")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getPositions(PositionBean positionBean, PageBean pageBean)throws Exception{
		return positionServiceC.getPositions(positionBean, pageBean);
	}	
	/**
	 * 修改职位状态
	 * @param positionBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePosition")
	@AppController(isVerSystemToken=true)
	public Object updatePosition(PositionBean positionBean,HttpServletRequest request)throws Exception{
		String desc ="";
		if(positionBean.getPosition_apply()!=null){
			if("0".equals(positionBean.getPosition_apply())){
				desc = "修改职位状态为上线";
			}else if("1".equals(positionBean.getPosition_apply())){
				desc = "修改职位状态为下线";
			}else{
				desc = "未知操作";
			}
		}
		if("1".equals(positionBean.getCreate_time())){
			desc = "修改职位为置顶";
		}
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc(desc)
				.setOperate_type("update")
				.setModule_id(positionBean.getPosition_id()+"")
				.setModule_name("职模块"));
		return positionServiceC.updatePosition(positionBean);
	}	
	/**
	 * 职位详情
	 * @param positionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPosition")
	@AppController(isVerSystemToken=true)
	public Object getPosition(PositionBean positionBean)throws Exception{
		return positionServiceC.getPosition(positionBean);
	}
	/**
	 * 定金订单列表
	 * @param advertiseOrderBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAdvertiseOrders")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getAdvertiseOrders(AdvertiseOrderBean advertiseOrderBean, PageBean pageBean)throws Exception{
		return positionServiceC.getAdvertiseOrders(advertiseOrderBean, pageBean);
	}	
	/**
	 * 修改定金订单
	 * @param advertiseOrderBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateAdvertiseOrder")
	@AppController(isVerSystemToken=true)
	public Object updateAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改职位订单的打款给商家状态,订单id为:"+advertiseOrderBean.getAdvertise_order_id())
				.setOperate_type("update")
				.setModule_id(advertiseOrderBean.getAdvertise_order_id()+"")
				.setModule_name("职订单模块"));
		return positionServiceC.updateAdvertiseOrder(advertiseOrderBean);
	}	
	/**
	 * 定金订单详情
	 * @param advertiseOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAdvertiseOrder")
	@AppController(isVerSystemToken=true)
	public Object getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean)throws Exception{
		return positionServiceC.getAdvertiseOrder(advertiseOrderBean);
	}
	
	
}
