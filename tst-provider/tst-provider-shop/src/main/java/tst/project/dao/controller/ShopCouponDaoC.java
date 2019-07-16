package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopCouponDaoC {
	
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
	public List<Map<String,Object>> getCouponGoodss(ShopCouponBean shopCouponBean,PageBean pageBean);
	
	/**
	 * 获得部分商品优惠券的可选商品列表
	 * @param shopCouponBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> getGoodsOutCoupon(Map<String,Object> map,PageBean pageBean);
	
	/**
	 * 后台赠送优惠券
	 * @param shopMemberCouponBean
	 * @return
	 */
	public int insertShopMemberCoupon(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 修改用户优惠券
	 * @param shopMemberCouponBean
	 * @return
	 */
	public int updateShopMemberCoupon(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 后台赠送优惠券(批量 按手机号)
	 * @param shopMemberCouponBean
	 * @return
	 */
	public int giveShopMemberCoupon(List<ShopMemberCouponBean> shopMemberCouponBeans);
	
	/**
	 * 添加优惠券
	 * @param shopCouponBean
	 * @return
	 */
	public int insertShopCoupon(ShopCouponBean shopCouponBean);
	
	/**
	 * 修改优惠券
	 * @param shopCouponBean
	 * @return
	 */
	public int updateShopCoupon(ShopCouponBean shopCouponBean);
	
	
	/**
	 * 修改优惠券领取数量
	 * @param shopCouponBean
	 * @return
	 */
	public int updateShopCouponTakeNum(ShopCouponBean shopCouponBean);
	
	
	/**
	 * 删除优惠券
	 * @param shopCouponBean
	 * @return
	 */
	public int deleteShopCoupon(ShopCouponBean shopCouponBean);
	
	
	/**
	 * 获得优惠券列表
	 * @param shopCouponBean
	 * @return
	 */
	public List<ShopCouponBean> getShopCoupons(ShopCouponBean shopCouponBean,PageBean pageBean);
	
	/**
	 * 获得优惠券详情
	 * @param shopCouponBean
	 * @return
	 */
	public ShopCouponBean getShopCouponDetail(ShopCouponBean shopCouponBean);
	
	/**
	 * 用户优惠券详情
	 * @param shopMemberCouponBean
	 * @return
	 */
	public ShopMemberCouponBean getShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean);
	

	/**
	 * 优惠券列表
	 * @param shopCouponBean
	 * @return
	 */
	public List<ShopCouponBean> getShopCouponsV2(ShopCouponBean shopCouponBean,PageBean pageBean);
}
