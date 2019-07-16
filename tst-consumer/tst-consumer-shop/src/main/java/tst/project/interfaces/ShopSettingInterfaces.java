package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopSettingService;

@Controller
@RequestMapping("/shopSettingInterfaces/v1.0")
public class ShopSettingInterfaces {
	@Autowired
	IShopSettingService shopSettingService;
	/**
	 * 轮播图列表
	 * @param shopBannerBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBanners")
	@AppController(isPage=true)
	public Object getBanners(ShopBannerBean shopBannerBean, PageBean pageBean) throws Exception {
		return shopSettingService.getBanners(shopBannerBean, pageBean);
	}
}
