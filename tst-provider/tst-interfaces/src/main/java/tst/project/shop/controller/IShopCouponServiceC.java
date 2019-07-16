/**
 * 
 */
package tst.project.shop.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IShopCouponServiceC {
	
	/**
	 * 优惠券统计
	 * @author sjb
	 * @param shopCouponBean
	 * @return
	 */
	public Map<String,Object> getCouponStatistics(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 获得部分商品优惠券的已选商品列表
	 * @param shopCouponBean
	 * @param pageBean
	 * @return
	 */
	public Object getCouponGoodss(ShopCouponBean shopCouponBean,PageBean pageBean);
	
	/**
	 * 获得部分商品优惠券的可选商品列表
	 * @param shopCouponBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsOutCoupon(String coupon_id,String goods_name,String class_name,String merchants_id,PageBean pageBean);
	
	
	
	/**
	 * 添加优惠券
	 * @param shopCouponBanner
	 * @return
	 */
	public Object insertShopCoupon(ShopCouponBean shopCouponBanner);
	
	/**
	 * 修改优惠券
	 * @param shopCouponBanner
	 * @return
	 */
	public Object updateShopCoupon(ShopCouponBean shopCouponBanner);
	
	
	/**
	 * 删除优惠券
	 * @param shopCouponBanner
	 * @return
	 */
	public Object deleteShopCoupon(ShopCouponBean shopCouponBanner);
	
	/**
	 * 获取优惠券列表(筛选已存在的)
	 * @author gxq
	 * @param shopCouponBanner
	 * @return
	 */
	public Object getShopCouponsV2(ShopCouponBean shopCouponBean,PageBean pageBean);
	/**
	 * 获得优惠券列表
	 * @param shopCouponBanner
	 * @return
	 */
	public Object getShopCoupons(ShopCouponBean shopCouponBanner,PageBean pageBean);
	
	/**
	 * 获得优惠券详情
	 * @param shopCouponBanner
	 * @return
	 */
	public Object getShopCouponDetail(ShopCouponBean shopCouponBanner);
}
