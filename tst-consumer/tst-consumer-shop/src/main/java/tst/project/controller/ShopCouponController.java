package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopCouponServiceC;

@Controller
@RequestMapping("/shopCouponContrllor/v1.0")
public class ShopCouponController {
	@Autowired
	IShopCouponServiceC shopCouponServiceC;
	
	@RequestMapping("/getCouponStatistics") 
    @AppController(isVerSystemToken=true)
    public Object getCouponStatistics(ShopMemberCouponBean shopMemberCouponBean) throws Exception{ 
		return shopCouponServiceC.getCouponStatistics(shopMemberCouponBean);
	}
	
	
	@RequestMapping("/getCouponGoodss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getCouponGoodss(ShopCouponBean shopCouponBean,PageBean pageBean) throws Exception{ 
		return shopCouponServiceC.getCouponGoodss(shopCouponBean, pageBean);
	}
	
	@RequestMapping("/getGoodsOutCoupon") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsOutCoupon(String coupon_id,String goods_name,String class_name,String merchants_id,PageBean pageBean) throws Exception{ 
		return shopCouponServiceC.getGoodsOutCoupon( coupon_id, goods_name, class_name, merchants_id, pageBean);
	}
	
	

	/**
	 * 优惠券列表
	 * @param shopCouponBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getShopCoupons") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getShopCoupons(ShopCouponBean shopCouponBean,PageBean pageBean) throws Exception{ 
		return shopCouponServiceC.getShopCoupons(shopCouponBean,pageBean);
	}

	/**
	 * 优惠券详情
	 * @param shopCouponBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getShopCouponDetail") 
    @AppController(isVerSystemToken=true)
    public Object getShopCouponDetail(ShopCouponBean shopCouponBean) throws Exception{ 
		return shopCouponServiceC.getShopCouponDetail(shopCouponBean);
	}
	
	/**
	 * 添加优惠券
	 * @param shopCouponBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertShopCoupon") 
    @AppController(isVerSystemToken=true)
    public Object insertShopCoupon(ShopCouponBean shopCouponBean) throws Exception{ 
		
		return shopCouponServiceC.insertShopCoupon(shopCouponBean);
	}
	
	/**
	 * 修改优惠券
	 * @param shopCouponBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateShopCoupon") 
    @AppController(isVerSystemToken=true)
    public Object updateShopCoupon(ShopCouponBean shopCouponBean) throws Exception{ 
		return shopCouponServiceC.updateShopCoupon(shopCouponBean);
	}
	
	/**
	 * 删除优惠劵
	 * @param shopCouponBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteShopCoupon") 
    @AppController(isVerSystemToken=true)
    public Object deleteShopCoupon(ShopCouponBean shopCouponBean) throws Exception{ 
		return shopCouponServiceC.deleteShopCoupon(shopCouponBean);
	}
}
