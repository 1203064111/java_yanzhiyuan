package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopCouponSignBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopCouponService;


@Controller
@RequestMapping("/shopCouponInterfaces/v1.0")
public class ShopCouponInterfaces {
	@Autowired
	IShopCouponService shopCouponService;

	/*
	 * 定时设置
	 */
	@RequestMapping("/timeingCouponExpire") 
    @AppController(isLog=false)
	public Object timeingCouponExpire(ShopCouponBean shopCouponBean) {
		return shopCouponService.timeingCouponExpire(shopCouponBean);
	}
	
	
	
	
	@RequestMapping("/getWeekSignCoupons") 
    @AppController(isVerToken=true)
	public Object getWeekSignCoupons(ShopCouponSignBean shopCouponSignBea) {
		return shopCouponService.getWeekSignCoupons(shopCouponSignBea);
	}
	
	
	
	/**
	 * 优惠券列表
	 * @param memberBean
	 * @param shopCouponBean
	 * @return
	 */
	@RequestMapping("/getShopCoupons") 
    @AppController(isPage=true)
	public Object getShopCoupons(ShopMemberCouponBean shopMemberCouponBean,PageBean pageBean) {
		return shopCouponService.getShopCoupons(shopMemberCouponBean,pageBean);
	}
	
	
	/**
	 * 领取优惠券
	 * @param memberBean
	 * @param shopCouponBean
	 * @return
	 */
	@RequestMapping("/insertMemberCoupon") 
    @AppController(isVerToken=true)
	public Object insertMemberCoupon(MemberBean memberBean,ShopCouponBean shopCouponBean) {
		
		return shopCouponService.insertMemberCoupon(memberBean,shopCouponBean);
	}
	
	@RequestMapping("/getShopCouponDetail") 
    @AppController
	public Object getShopCouponDetail(ShopCouponBean shopCouponBean) {
		
		return shopCouponService.getShopCouponDetail(shopCouponBean);
	}
	/**
	 * 优惠券详情
	 * @param shopMemberCouponBean
	 * @return
	 */
	@RequestMapping("/getShopMemberCouponDetail") 
    @AppController(isVerToken=true)
	public Object getShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean) {
		
		return shopCouponService.getShopMemberCouponDetail(shopMemberCouponBean);
	}
	/**
	 * 优惠券列表
	 * @param shopMemberCouponBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getShopMemberCoupons") 
    @AppController(isVerToken=true,isPage=true)
	public Object getShopMemberCoupons(ShopMemberCouponBean shopMemberCouponBean,PageBean pageBean) {
		
		return shopCouponService.getShopMemberCoupons(shopMemberCouponBean,pageBean);
	}
	

}
