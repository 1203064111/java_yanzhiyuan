package tst.project.dao.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopCouponSignBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopCouponDao {
	
	/**
	 * 定时处理过期优惠券
	 * @author sjb
	 * @return
	 */
	public int timeingCouponExpire(ShopCouponBean shopCouponBean);
	
	/**
	 * 获得新手券列表
	 * @author sjb
	 * @param shopMemberCouponBean
	 * @return
	 */
	public List<ShopCouponBean> getNewCoupons(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 获得用户本周签到情况
	 * @author sjb
	 * @param shopCouponSignBean
	 * @return
	 */
	public List<Map<String,Object>> getWeekSignCoupons(ShopCouponSignBean shopCouponSignBean);
	
	/**
	 * 随机获得一张签到券
	 * @param shopCouponSignBean
	 * @return
	 */
	public ShopCouponBean getRandSignCoupon(ShopCouponSignBean shopCouponSignBean);
	
	/**
	 * 获得用户签到详情
	 * @param shopCouponSignBean
	 * @return
	 */
	public ShopCouponSignBean getCouponSignDetail(ShopCouponSignBean shopCouponSignBean);
	
	/**
	 * 签到领券
	 * @author sjb
	 * @param shopMemberCouponBean
	 * @return
	 */
	public int signCoupon(ShopCouponSignBean shopCouponSignBean);
	
	/**
	 * 验证用户是否已经领取该优惠券
	 * @param shopMemberCouponBean
	 * @return
	 */
	public ShopMemberCouponBean verMemberCoupon(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 用户领取的优惠券次数
	 * @param shopMemberCouponBean
	 * @return
	 */
	public List<ShopMemberCouponBean> verMemberCouponList(ShopMemberCouponBean shopMemberCouponBean);
	/**
	 * 获得商城可领取的优惠券列表
	 * @author sjb
	 * @param shopCouponBean
	 * @return
	 */
	public List<ShopCouponBean> getShopCoupons(ShopMemberCouponBean shopMemberCouponBean,PageBean pageBean);
	
	/**
	 * 获取订单可用的优惠券列表
	 * @param shopMemberCouponBean
	 * @return
	 */
	public List<ShopMemberCouponBean> getOrderCoupons(HashMap<String, Object> map);
	
	/**
	 * 用户优惠券列表
	 * @param shopMemberCouponBean
	 * @return
	 */
	public List<ShopMemberCouponBean> getShopMemberCoupons(ShopMemberCouponBean shopMemberCouponBean,PageBean pageBean);
	
	/**
	 * 用户优惠券详情
	 * @return
	 */
	public ShopMemberCouponBean getShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 修改用户优惠券详情
	 * @param shopMemberCouponBean
	 * @return
	 */
	public int updateShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean);
	
	public int updateShopMemberCouponState(ShopMemberCouponBean shopMemberCouponBean);

	/**
	 * 修改优惠券使用量
	 * @param shopCouponBean
	 */
	public int updateShopCouponUsedNum(ShopCouponBean shopCouponBean);
	/**
	 * 修改优惠券的剩余数量
	 * @param shopCouponBean
	 * @return
	 */
	public int updateShopCouponRemainNum(ShopCouponBean shopCouponBean);
	

	/**
	 * 优惠券详情
	 * @param shopCouponBean
	 * @return
	 */

	public ShopCouponBean getShopCouponDetail(ShopCouponBean shopCouponBean);

	/**
	 * 更改领取数
	 * @param setTake_num
	 * @return
	 */
	public int updateShopCouponTakeNum(ShopCouponBean setTake_num);

	/**
	 * 领取优惠券
	 * @param shopMemberCouponBean2
	 * @return
	 */
	public int insertMemberCoupon(ShopMemberCouponBean shopMemberCouponBean2);

}
