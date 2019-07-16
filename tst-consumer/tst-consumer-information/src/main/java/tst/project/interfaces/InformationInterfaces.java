package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationClassBean;
import tst.project.bean.information.ShareRelationBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.information.WellRelationBean;
import tst.project.bean.member.MemberBlackBean;
import tst.project.bean.member.MemberReportBean;
import tst.project.information.interfaces.IInformationService;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/informationInterfaces/v1.0")
public class InformationInterfaces {
	@Autowired
	IInformationService informationService;
	
	/**
	 *
	 * @param informationClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInformationClasss") 
    @AppController
    public Object getInformationClasss(InformationClassBean informationClassBean) throws Exception{ 
		return informationService.getInformationClasss(informationClassBean);
	}
	
	@RequestMapping("/getInformations") 
    @AppController(isPage=true)
    public Object getInformations(InformationBean informationBean,PageBean pageBean) throws Exception{ 
		return informationService.getInformations(informationBean,pageBean);
	}
	
	@RequestMapping("/getInformationDetail") 
    @AppController
    public Object getInformationDetail(InformationBean informationBean) throws Exception{ 
		return informationService.getInformationDetail(informationBean);
	}
	
	@RequestMapping("/getInformationMarketings") 
    @AppController
    public Object getInformationMarketings(InformationBean informationBean) throws Exception{ 
		return informationService.getInformationMarketings(informationBean);
	}
	
	
	
	/**
	 * 获取资讯列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformations")
	@AppController(isPage=true)
	public Object getSystemInformations(SystemInformationBean systemInformationBean, PageBean pageBean)throws Exception{
		return informationService.getSystemInformations(systemInformationBean, pageBean);
	}	
	/**
	 * 资讯评论列表
	 * @param informationAssessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformationAssessments")
	@AppController(isPage=true)
	public Object getSystemInformationAssessments(InformationAssessmentBean informationAssessmentBean, PageBean pageBean)throws Exception{
		return informationService.getSystemInformationAssessments(informationAssessmentBean, pageBean);
	}
	/**
	 * 用户的资讯列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformationsByMember")
	@AppController(isPage=true)
	public Object getSystemInformationsByMember(SystemInformationBean systemInformationBean, PageBean pageBean)throws Exception{
		return informationService.getSystemInformationsByMember(systemInformationBean, pageBean);
	}	
	/**
	 * 修改资讯
	 * @param systemInformationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSystemInformation")
	@AppController(isVerToken=true)
	public Object updateSystemInformation(SystemInformationBean systemInformationBean)throws Exception{
		return informationService.updateSystemInformation(systemInformationBean);
	}
//	@RequestMapping("/shareSystemInformation")
//	@AppController(isVerToken=true)
//	public Object shareSystemInformation(SystemInformationBean systemInformationBean)throws Exception{
//		return informationService.shareSystemInformation(systemInformationBean);
//	}
	/**
	 * 添加资讯
	 * @param systemInformationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemInformation")
	@AppController(isVerToken=true)
	public Object insertSystemInformation(SystemInformationBean systemInformationBean)throws Exception{
		return informationService.insertSystemInformation(systemInformationBean);
	}	
	/**
	 * 添加心得资讯
	 * @param systemInformationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemInformationXinDe")
	@AppController(isVerToken=true)
	public Object insertSystemInformationXinDe(SystemInformationBean systemInformationBean)throws Exception{
		return informationService.insertSystemInformationXinDe(systemInformationBean);
	}
	/**
	 * 资讯详情
	 * @param systemInformationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformation")
	@AppController()
	public Object getSystemInformation(SystemInformationBean systemInformationBean)throws Exception{
		return informationService.getSystemInformation(systemInformationBean);
	}
	/**
	 * 订单的资讯列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformationByOrderId")
	@AppController(isPage=true)
	public Object getSystemInformationByOrderId(SystemInformationBean systemInformationBean,PageBean pageBean)throws Exception{
		return informationService.getSystemInformationByOrderId(systemInformationBean,pageBean);
	}
	
	/**
	 * 添加点赞
	 * @param wellRelationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertWellRealtion")
	@AppController(isVerToken=true)
	public Object insertWellRealtion(WellRelationBean wellRelationBean )throws Exception{
		return informationService.insertWellRealtion(wellRelationBean);
	}	
	/**
	 * 分享资讯
	 * @param shareRelationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shareSystemInformation")
	@AppController(isVerToken=true)
	public Object insertShareRealtion(ShareRelationBean shareRelationBean )throws Exception{
		return informationService.insertShareRealtion(shareRelationBean);
	}
	/**
	 * 删除点赞
	 * @param wellRelationBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteWellRealtion")
	@AppController(isVerToken=true)
	public Object deleteWellRealtion(WellRelationBean wellRelationBean )throws Exception{
		return informationService.deleteWellRealtion(wellRelationBean);
	}	
	/**
	 * 添加资讯评论
	 * @param informationAssessmentBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertInformationAssessment")
	@AppController(isVerToken=true)
	public Object insertInformationAssessment(InformationAssessmentBean informationAssessmentBean )throws Exception{
		return informationService.insertInformationAssessment(informationAssessmentBean);
	}	
	/**
	 * 资讯相册列表
	 * @param systemInformationBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInformationImgs")
	@AppController(isPage=true)
	public Object getInformationImgs(SystemInformationBean systemInformationBean,PageBean pageBean)throws Exception{
		return informationService.getInformationImgs(systemInformationBean,pageBean);
	}
	/**
	 * 资讯分类列表
	 * @param systemInformationClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemInformationClasss")
	@AppController(isPage=true)
	public Object getSystemInformationClasss(SystemInformationClassBean systemInformationClassBean, PageBean pageBean)throws Exception{
		return informationService.getSystemInformationClasss(systemInformationClassBean, pageBean);
	}
	/**
	 * 举报用户
	 * @param memberReportBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMemberReport") 
    @AppController(isVerToken=true)
	public Object insertMemberReport(MemberReportBean memberReportBean) throws Exception{ 
		
		return informationService.insertMemberReport(memberReportBean);
	}
	/**
	 * 添加黑名单
	 * @param memberBlackBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMemberBlack") 
    @AppController(isVerToken=true)
	public Object insertMemberReport(MemberBlackBean memberBlackBean) throws Exception{ 
		
		return informationService.insertMemberBlack(memberBlackBean);
	}
}
