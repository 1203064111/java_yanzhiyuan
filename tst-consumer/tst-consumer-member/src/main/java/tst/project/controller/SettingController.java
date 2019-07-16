package tst.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import tst.project.aspect.AppController;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.ListShowBean;
import tst.project.bean.setting.ListTypeBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/settingController/v1.0")
public class SettingController {
	@Autowired
	ISettingServiceC settingService;

	@Autowired
	ISystemService systemService;
	
	
	@RequestMapping("/getListTypes") 
    @AppController(isVerSystemToken=true)
    public Object getListTypes(ListTypeBean listTypeBean) throws Exception{ 
		return settingService.getListTypes(listTypeBean);
	}
	
	
	@RequestMapping("/getListShows") 
    @AppController(isVerSystemToken=true)
    public Object getListShows(ListShowBean listShowBean) throws Exception{ 
		return settingService.getListShows(listShowBean);
	}
	
	
	@RequestMapping("/getAdvices") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getAdvices(AdviceBean adviceBean,PageBean pageBean) throws Exception{ 
		return settingService.getAdvices(adviceBean,pageBean);
	}
	
	
	@RequestMapping("/getCityHots") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getCityHots(CityHotBean cityHotBean, PageBean pageBean) throws Exception{ 
		return settingService.getCityHots(cityHotBean, pageBean);
	}
	
	@RequestMapping("/getCityOutHots") 
    @AppController(isVerSystemToken=true)
    public Object getCityOutHots(CityBean cityBean) throws Exception{ 
		return settingService.getCityOutHots(cityBean);
	}
	
	@RequestMapping("/insertCityHot") 
    @AppController(isVerSystemToken=true)
    public Object insertCityHot(CityHotBean cityHotBean) throws Exception{ 
		return settingService.insertCityHot(cityHotBean);
	}
	
	@RequestMapping("/deleteCityHot") 
    @AppController(isVerSystemToken=true)
    public Object deleteCityHot(CityHotBean cityHotBean) throws Exception{ 
		return settingService.deleteCityHot(cityHotBean);
	}
	
	@RequestMapping("/getCitys") 
    @AppController(isVerSystemToken=true)
    public Object getHtmls(CityBean cityBean) throws Exception{ 
		return settingService.getCitys(cityBean);
	}
	/**
	 * 
	 * @param cityBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOneCitys") 
    @AppController(isVerSystemToken=true)
    public Object getOneCitys(CityBean cityBean) throws Exception{ 
		return settingService.getOneCitys(cityBean);
	}
	/**
	 * 图文列表
	 * @param htmlBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getHtmls") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getHtmls(HtmlBean htmlBean,PageBean pageBean) throws Exception{ 
		return settingService.getHtmls(htmlBean, pageBean);
	}
	/**
	 * 图文详情
	 * @param htmlBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getHtmlDetail") 
    @AppController(isVerSystemToken=true)
    public Object getHtmlDetail(HtmlBean htmlBean) throws Exception{ 
		return settingService.getHtmlDetail(htmlBean);
	}
	/**
	 * 添加轮播图
	 * @param htmlBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertHtml") 
    @AppController(isVerSystemToken=true)
    public Object insertHtml(HtmlBean htmlBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加轮播图，名称为:"+htmlBean.getHtml_name())
				.setOperate_type("insert")
				.setModule_name("轮播图模块"));
		return settingService.insertHtml(htmlBean);
	}
	/**
	 * 修改轮播图
	 * @param htmlBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateHtml") 
    @AppController(isVerSystemToken=true)
    public Object updateHtml(HtmlBean htmlBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改轮播图，名称为:"+htmlBean.getHtml_name())
				.setOperate_type("update")
				.setModule_id(htmlBean.getHtml_id()+"")
				.setModule_name("轮播图模块"));
		return settingService.updateHtml(htmlBean);
	}
	
	/**
	 * 删除轮播图
	 * @param htmlBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteHtml") 
    @AppController(isVerSystemToken=true)
    public Object deleteHtml(HtmlBean htmlBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除轮播图，名称为:"+htmlBean.getHtml_name())
				.setOperate_type("delete")
				.setModule_name("轮播图模块"));
		return settingService.deleteHtml(htmlBean);
	}
	
	@RequestMapping("/getMsgTypes") 
    @AppController(isVerSystemToken=true)
	public Object getMsgTypes(MsgTypeBean msgTypeBean) {
		return settingService.getMsgTypes(msgTypeBean);
		
	}
	
	@RequestMapping("/updateMsgType") 
    @AppController(isVerSystemToken=true)
	public Object updateMsgType(MsgTypeBean msgTypeBean) {
		return settingService.updateMsgType(msgTypeBean);
	}
}
