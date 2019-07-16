package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopActivityService;

@Controller
@RequestMapping("/shopActivityInterfaces/v1.0")
public class ShopActivityInterfaces {
	@Autowired
	IShopActivityService shopActivityService;
	
	@RequestMapping("/getActivityLimitGoods")
	@AppController(isPage=true)
	public Object getActivityLimitGoods(ActivityGoodsBean activityGoodsBean,PageBean pageBean) throws Exception {
		return shopActivityService.getActivityLimitGoods(activityGoodsBean, pageBean);
	}
	
	@RequestMapping("/getActivityLimits")
	@AppController(isPage=true)
	public Object getActivityLimits(ActivityBean activityBean,PageBean pageBean) throws Exception {
		return shopActivityService.getActivityLimits(activityBean, pageBean);
	}
}
