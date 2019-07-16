package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityDescendingBean;
import tst.project.bean.shop.ActivityGiveBean;
import tst.project.bean.shop.ActivityGiveGoodsBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.ActivityReduceBean;
import tst.project.bean.shop.ActivityShoppingBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopActivityServiceC;

@Controller
@RequestMapping("/shopActivityController/v1.0")
public class ShopActivityController {
	@Autowired
	IShopActivityServiceC shopActivityServiceC;
	
	@RequestMapping("/getActivityGiveGoods") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean,PageBean pageBean) throws Exception{ 
		return shopActivityServiceC.getActivityGiveGoods(activityGiveGoodsBean,pageBean);
	}
	
	
	@RequestMapping("/getActivityGoodss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getActivityGoodss(ActivityGoodsBean activityGoodsBean,PageBean pageBean) throws Exception{ 
		return shopActivityServiceC.getActivityGoodss(activityGoodsBean,pageBean);
	}

	
	@RequestMapping("/deleteActivityGoods") 
    @AppController(isVerSystemToken=true)
    public Object deleteActivityGoods(ActivityGoodsBean activityGoodsBean) throws Exception{ 
		return shopActivityServiceC.deleteActivityGoods(activityGoodsBean);
	}
	
	
	@RequestMapping("/insertActivityGoods") 
    @AppController(isVerSystemToken=true)
    public Object insertActivityGoods(ActivityGoodsBean activityGoodsBean) throws Exception{ 
		
		return shopActivityServiceC.insertActivityGoods(activityGoodsBean);
	}
	@RequestMapping("/insertActivityLimitGoods") 
    @AppController(isVerSystemToken=true)
    public Object insertActivityLimitGoods(String json) throws Exception{ 
		return shopActivityServiceC.insertActivityLimitGoods(JSON.parseArray(json, ActivityGoodsBean.class));
	}
	
	@RequestMapping("/getActivitys") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getActivitys(ActivityBean activityBean,PageBean pageBean) throws Exception{ 
		return shopActivityServiceC.getActivitys(activityBean,pageBean);
	}

	@RequestMapping("/getGoodsOutActivity") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsOutActivity(ActivityGoodsBean activityGoodsBean,PageBean pageBean) throws Exception{ 
		return shopActivityServiceC.getGoodsOutActivity(activityGoodsBean,pageBean);
	}
	
	@RequestMapping("/getGoodsOutGiveActivity") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsOutGiveActivity(ActivityGiveGoodsBean activityGiveGoodsBean,PageBean pageBean) throws Exception{ 
		return shopActivityServiceC.getGoodsOutGiveActivity(activityGiveGoodsBean,pageBean);
	}
	
	@RequestMapping("/getActivityGiveDetail") 
    @AppController(isVerSystemToken=true)
    public Object getActivityGiveDetail(ActivityBean activityBean) throws Exception{ 
		return shopActivityServiceC.getActivityGiveDetail(activityBean);
	}
	
	@RequestMapping("/getActivityReduceDetail") 
    @AppController(isVerSystemToken=true)
    public Object getActivityReduceDetail(ActivityBean activityBean) throws Exception{ 
		return shopActivityServiceC.getActivityReduceDetail(activityBean);
	}
	
	@RequestMapping("/getActivityDescendingDetail") 
    @AppController(isVerSystemToken=true)
    public Object getActivityDescendingDetail(ActivityBean activityBean) throws Exception{ 
		return shopActivityServiceC.getActivityDescendingDetail(activityBean);
	}
	
	@RequestMapping("/getActivityDetail") 
    @AppController(isVerSystemToken=true)
    public Object getActivityDetail(ActivityBean activityBean) throws Exception{ 
		return shopActivityServiceC.getActivityDetail(activityBean);
	}
	
	@RequestMapping("/insertActivityGive") 
    @AppController(isVerSystemToken=true)
    public Object insertActivityGive(ActivityGiveBean activityGiveBean) throws Exception{ 
		
		return shopActivityServiceC.insertActivityGive(activityGiveBean);
	}
	
	@RequestMapping("/updateActivityGive") 
    @AppController(isVerSystemToken=true)
    public Object updateActivityGive(ActivityGiveBean activityGiveBean) throws Exception{ 
		
		return shopActivityServiceC.updateActivityGive(activityGiveBean);
	}
	
	@RequestMapping("/insertActivityGiveGoods") 
    @AppController(isVerSystemToken=true)
    public Object insertActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean) throws Exception{ 
		
		return shopActivityServiceC.insertActivityGiveGoods(activityGiveGoodsBean);
	}
	
	@RequestMapping("/deleteActivityGiveGoods") 
    @AppController(isVerSystemToken=true)
    public Object deleteActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean) throws Exception{ 
		
		return shopActivityServiceC.deleteActivityGiveGoods(activityGiveGoodsBean);
	}
	
	@RequestMapping("/insertActivity") 
    @AppController(isVerSystemToken=true)
    public Object insertActivity(ActivityBean activityBean,ActivityGiveBean activityGiveBean,
    		ActivityReduceBean activityReduceBean,ActivityDescendingBean activityDescendingBean) throws Exception{ 
		
		return shopActivityServiceC.insertActivity(activityBean,activityGiveBean,activityReduceBean,activityDescendingBean);
	}
	
	
	@RequestMapping("/updateActivity") 
    @AppController(isVerSystemToken=true)
    public Object updateActivity(ActivityBean activityBean,ActivityGiveBean activityGiveBean,
    		ActivityReduceBean activityReduceBean,ActivityDescendingBean activityDescendingBean) throws Exception{ 
		return shopActivityServiceC.updateActivity(activityBean,activityGiveBean,activityReduceBean,activityDescendingBean);
	}
	
	@RequestMapping("/updateActivityState") 
    @AppController(isVerSystemToken=true)
	public Object updateActivityState(ActivityBean activityBean) throws Exception {
		return shopActivityServiceC.updateActivityState(activityBean);
	}
	
	
	@RequestMapping("/deleteActivity") 
    @AppController(isVerSystemToken=true)
    public Object deleteActivity(ActivityBean activityBean) throws Exception{ 
		return shopActivityServiceC.deleteActivity(activityBean);
	}
	
}
