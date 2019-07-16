/**
 * 
 */
package tst.project.shop.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopCouponSignBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IShopCouponService {
	
	/**
	 * 定时处理过期优惠券
	 * @author sjb
	 * @return
	 */
	public Object timeingCouponExpire(ShopCouponBean shopCouponBean);
	
	
	
	/**
	 * 获得用户本周签到情况
	 * @author sjb
	 * @param shopCouponSignBean
	 * @return
	 */
	public Object getWeekSignCoupons(ShopCouponSignBean shopCouponSignBean);
	
	
	/**
	 * 获得商城可领取的优惠券列表
	 * @author sjb
	 * @param shopCouponBean
	 * @return
	 */
	public Object getShopCoupons(ShopMemberCouponBean shopMemberCouponBean,PageBean pageBean);
	
	/**
	 * 用户优惠券列表
	 * @param shopMemberCouponBean
	 * @return
	 */
	public Object getShopMemberCoupons(ShopMemberCouponBean shopMemberCouponBean,PageBean pageBean);
	
	/**
	 * 用户优惠券详情
	 * @return
	 */
	public ShopMemberCouponBean getShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean);

	/**
	 * 领取优惠券
	 * @param memberBean
	 * @param shopCouponBean
	 * @return
	 */
	public Object insertMemberCoupon(MemberBean memberBean, ShopCouponBean shopCouponBean);

	/**
	 * 获得优惠券详情
	 * @param shopCouponBean
	 * @return
	 */

	public Object getShopCouponDetail(ShopCouponBean shopCouponBean);
}
