package tst.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopSettingServiceC;
import tst.project.utils.RedisUtils;

@Controller
@RequestMapping("/shopSettingController/v1.0")
public class ShopSettingController {
	@Autowired
	IShopSettingServiceC shopSettingServiceC;
	
	
	@Autowired
	ISystemService systemService;

	/**
	 * 设置比例
	 * @author sjb
	 * @param percentBeans
	 * @return
	 */
	@RequestMapping("/savePercents")
	@AppController(isVerSystemToken=true)
	public Object savePercents(String json,HttpServletRequest request) throws Exception {
		List<PercentBean> percentBeans =JSON.parseArray(json, PercentBean.class);
		for(PercentBean percentBean  : percentBeans){
			systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
					.setOperate_desc("修改比例信息，比例名称为"+percentBean.getPercent_name())
					.setOperate_type("update")
					.setModule_id(percentBean.getPercent_id()+"")
					.setModule_name("比例模块"));
		}
		return shopSettingServiceC.savePercents(JSON.parseArray(json, PercentBean.class));
	}
	/**
	 * 商城比例列表
	 * @author sjb
	 * @param percentBean
	 * @return
	 */
	@RequestMapping("/getPercents")
	@AppController(isVerSystemToken=true)
	public Object getPercents(PercentBean percentBean) throws Exception {
		return shopSettingServiceC.getPercents(percentBean);
	}

	/**
	 * 轮播图列表
	 * @param shopBannerBean
	 * @return
	 */
	@RequestMapping("/getBanners")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getBanners(ShopBannerBean shopBannerBean,PageBean pageBean) throws Exception {
		return shopSettingServiceC.getBanners(shopBannerBean,pageBean);
	}

	/**
	 * 轮播图详情
	 * @param shopBannerBean
	 * @return
	 */
	@RequestMapping("/getBannerDetail")
	@AppController(isVerSystemToken=true)
	public Object getBannerDetail(ShopBannerBean shopBannerBean) throws Exception {
		return shopSettingServiceC.getBannerDetail(shopBannerBean);
	}
	
	@RequestMapping("/moveBanner")
	@AppController(isVerSystemToken=true)
	public Object moveBanner(ShopBannerBean shopBannerBean) throws Exception {
		return shopSettingServiceC.moveBanner(shopBannerBean);
	}

	/**
	 * 添加图片
	 * @param shopBannerBean
	 * @return
	 */
	@RequestMapping("/insertBanner")
	@AppController(isVerSystemToken=true)
	public Object insertBanner(ShopBannerBean shopBannerBean,HttpServletRequest request) throws Exception {
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加轮播图，轮播名称为"+shopBannerBean.getBanner_title())
				.setOperate_type("insert")
				.setModule_name("轮播模块"));
		return shopSettingServiceC.insertBanner(shopBannerBean);
	}

	/**
	 * 修改图片
	 * @param shopBannerBean
	 * @return
	 */
	@RequestMapping("/updateBanner")
	@AppController(isVerSystemToken=true)
	public Object updateBanner(ShopBannerBean shopBannerBean,HttpServletRequest request) throws Exception {
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改轮播图，轮播名称为"+shopBannerBean.getBanner_title())
				.setOperate_type("update")
				.setModule_id(shopBannerBean.getBanner_id()+"")
				.setModule_name("轮播模块"));
		return shopSettingServiceC.updateBanner(shopBannerBean);
	}
	/**
	 * 删除图片
	 * @param shopBannerBean
	 * @return
	 */
	@RequestMapping("/deleteBanner")
	@AppController(isVerSystemToken=true)
	public Object deleteBanner(ShopBannerBean shopBannerBean,HttpServletRequest request) throws Exception {
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除轮播图，轮播名称为"+shopBannerBean.getBanner_title())
				.setOperate_type("delete")
				.setModule_id(shopBannerBean.getBanner_id()+"")
				.setModule_name("轮播模块"));
		return shopSettingServiceC.deleteBanner(shopBannerBean);
	}
	
	
}
