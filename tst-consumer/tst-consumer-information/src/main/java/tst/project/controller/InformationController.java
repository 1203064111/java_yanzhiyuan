package tst.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.information.controller.IInformationServiceC;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/informationController/v1.0")
public class InformationController {
	@Autowired
	IInformationServiceC informationServiceC;
	
	@Autowired
	ISystemService systemService;
	@RequestMapping("/insertInformation") 
    @AppController(isVerSystemToken=true)
    public Object insertInformation(InformationBean informationBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("新增一条资讯")
				.setOperate_type("insert")
				.setModule_name("资讯模块"));
		return informationServiceC.insertInformation(informationBean);
	}
	
	@RequestMapping("/updateInformation") 
    @AppController(isVerSystemToken=true)
    public Object updateInformation(InformationBean informationBean) throws Exception{ 
		return informationServiceC.updateInformation(informationBean);
	}
	
	@RequestMapping("/deleteInformation") 
    @AppController(isVerSystemToken=true)
    public Object deleteInformation(InformationBean informationBean) throws Exception{ 
		return informationServiceC.deleteInformation(informationBean);
	}
	
	@RequestMapping("/getInformationDetail") 
    @AppController(isVerSystemToken=true)
    public Object getInformationDetail(InformationBean informationBean) throws Exception{ 
		return informationServiceC.getInformationDetail(informationBean);
	}
	
	@RequestMapping("/getInformations") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getInformations(InformationBean informationBean,PageBean pageBean) throws Exception{ 
		return informationServiceC.getInformations(informationBean,pageBean);
	}
	
	
	
	@RequestMapping("/insertInformationClass") 
    @AppController(isVerSystemToken=true)
    public Object insertInformationClass(InformationClassBean informationClassBean) throws Exception{ 
		return informationServiceC.insertInformationClass(informationClassBean);
	}
	
	@RequestMapping("/updateInformationClass") 
    @AppController(isVerSystemToken=true)
    public Object updateInformationClass(InformationClassBean informationClassBean) throws Exception{ 
		return informationServiceC.updateInformationClass(informationClassBean);
	}
	
	@RequestMapping("/deleteInformationClass") 
    @AppController(isVerSystemToken=true)
    public Object deleteInformationClass(InformationClassBean informationClassBean) throws Exception{ 
		return informationServiceC.deleteInformationClass(informationClassBean);
	}
	
	@RequestMapping("/getInformationClassDetail") 
    @AppController(isVerSystemToken=true)
    public Object getInformationClassDetail(InformationClassBean informationClassBean) throws Exception{ 
		return informationServiceC.getInformationClassDetail(informationClassBean);
	}
	
	@RequestMapping("/getInformationClasss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getInformationClasss(InformationClassBean informationClassBean,PageBean pageBean) throws Exception{ 
		return informationServiceC.getInformationClasss(informationClassBean,pageBean);
	}
	/**
	 * 资讯分类列表
	 * @param systemInformationClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformationClasss")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean, PageBean pageBean)throws Exception{
		return informationServiceC.getSystemInformationClasss(systemInformationClassBean, pageBean);
	}	
	/**
	 * 修改资讯分类
	 * @param systemInformationClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSystemInformationClass")
	@AppController(isVerSystemToken=true)
	public Object updateSystemInformationClass(SystemInformationClassBean systemInformationClassBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改一条资讯分类,分类id:"+systemInformationClassBean.getClass_id())
				.setOperate_type("update")
				.setModule_id(systemInformationClassBean.getClass_id()+"")
				.setModule_name("资讯模块"));
		return informationServiceC.updateSystemInformationClass(systemInformationClassBean);
	}	
	/**
	 * 获取资讯分类
	 * @param systemInformationClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformationClass")
	@AppController(isVerSystemToken=true)
	public Object getSystemInformationClass(SystemInformationClassBean systemInformationClassBean)throws Exception{
		return informationServiceC.getSystemInformationClass(systemInformationClassBean);
	}
	/**
	 * 删除系统分类
	 * @param systemInformationClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteSystemInformationClass") 
    @AppController(isVerSystemToken=true)
    public Object deleteSystemInformationClass(SystemInformationClassBean systemInformationClassBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除一条资讯分类,分类id:"+systemInformationClassBean.getClass_id())
				.setOperate_type("delete")
				.setModule_id(systemInformationClassBean.getClass_id()+"")
				.setModule_name("资讯模块"));
		return informationServiceC.deleteSystemInformationClass(systemInformationClassBean);
	}
	/**
	 * 添加资讯分类
	 * @param systemInformationClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemInformationClass") 
    @AppController(isVerSystemToken=true)
	public Object insertSystemInformationClass(SystemInformationClassBean systemInformationClassBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("新增一条资讯分类,分类名称:"+systemInformationClassBean.getClass_name())
				.setOperate_type("insert")
				.setModule_name("资讯模块"));
		return informationServiceC.insertSystemInformationClass(systemInformationClassBean);
	}
	
	
	
	/**
	 * 系统资讯列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformations")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getSystemInformations(SystemInformationBean systemInformationBean, PageBean pageBean)throws Exception{
		return informationServiceC.getSystemInformations(systemInformationBean, pageBean);
	}	
	/**
	 * 修改系统资讯
	 * @param systemInformationBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSystemInformation")
	@AppController(isVerSystemToken=true)
	public Object updateSystemInformation(SystemInformationBean systemInformationBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改系统资讯,资讯id:"+systemInformationBean.getInformation_id())
				.setOperate_type("update")
				.setModule_id(systemInformationBean.getInformation_id()+"")
				.setModule_name("资讯模块"));
		return informationServiceC.updateSystemInformation(systemInformationBean);
	}	
	/**
	 * 系统资讯详情
	 * @param systemInformationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformation")
	@AppController(isVerSystemToken=true)
	public Object getSystemInformation(SystemInformationBean systemInformationBean)throws Exception{
		return informationServiceC.getSystemInformation(systemInformationBean);
	}
	/**
	 * 删除系统资讯
	 * @param systemInformationBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteSystemInformation") 
    @AppController(isVerSystemToken=true)
    public Object deleteSystemInformation(SystemInformationBean systemInformationBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除一条系统资讯,资讯id:"+systemInformationBean.getInformation_id())
				.setOperate_type("delete")
				.setModule_id(systemInformationBean.getInformation_id()+"")
				.setModule_name("资讯模块"));
		return informationServiceC.deleteSystemInformation(systemInformationBean);
	}
	/**
	 * 新增系统资讯
	 * @param systemInformationBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemInformation") 
    @AppController(isVerSystemToken=true)
	public Object insertSystemInformation(SystemInformationBean systemInformationBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("新增一条系统资讯,资讯标题为："+systemInformationBean.getInformation_title())
				.setOperate_type("insert")
				.setModule_name("资讯模块"));
		return informationServiceC.insertSystemInformation(systemInformationBean);
	}
	
	/**
	 * 资讯评论列表
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInformationAssessments") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getInformationAssessments(InformationAssessmentBean informationAssessmentBean,PageBean pageBean) throws Exception{ 
		return informationServiceC.getInformationAssessments(informationAssessmentBean,pageBean);
	}
	/**
	 * 资讯评论回复列表
	 */
	@RequestMapping("/getInformationAssessmentAnswers") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getInformationAssessmentAnswers(InformationAssessmentBean informationAssessmentBean,PageBean pageBean) throws Exception{ 
		return informationServiceC.getInformationAssessmentAnswers(informationAssessmentBean,pageBean);
	}
	/**
	 * 修改资讯评论
	 * @param informationAssessmentBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateInformationAssessment") 
    @AppController(isVerSystemToken=true)
    public Object updateInformationAssessment(InformationAssessmentBean informationAssessmentBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改资讯评论，评论id："+informationAssessmentBean.getAssessment_id())
				.setOperate_type("update")
				.setModule_id(informationAssessmentBean.getInformation_id()+"")
				.setModule_name("资讯模块"));
		return informationServiceC.updateInformationAssessment(informationAssessmentBean);
	}
	
	
	/**
	 * 删除资讯评论
	 * @param informationAssessmentBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteInformationAssessment") 
    @AppController(isVerSystemToken=true)
    public Object deleteInformationAssessment(InformationAssessmentBean informationAssessmentBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除资讯评论，评论内容："+informationAssessmentBean.getAssessment_desc())
				.setOperate_type("delete")
				.setModule_id(informationAssessmentBean.getInformation_id()+"")
				.setModule_name("资讯模块"));
		return informationServiceC.deleteInformationAssessment(informationAssessmentBean);
	}
	
	/**
	 * 用户举报列表
	 * @param memberReportBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberReports")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberReports(MemberReportBean memberReportBean, PageBean pageBean)throws Exception{
		return informationServiceC.getMemberReports(memberReportBean, pageBean);
	}	
}
