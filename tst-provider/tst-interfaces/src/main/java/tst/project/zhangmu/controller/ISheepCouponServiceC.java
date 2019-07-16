package tst.project.zhangmu.controller;

import tst.project.bean.sheep.SheepCouponBean;
import tst.project.bean.sheep.WelfareCouponBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.page.PageBean;

public interface ISheepCouponServiceC {

	public Object getSheepCoupons(SheepCouponBean sheepCouponBean, PageBean pageBean);

	public int deleteSheepCoupon(SheepCouponBean sheepCouponBean);

	public int insertSheepCoupon(SheepCouponBean sheepCouponBean);

	public int updateSheepCoupon(SheepCouponBean sheepCouponBean);

	public SheepCouponBean getSheepCouponDetail(SheepCouponBean sheepCouponBean);

	public Object getWelfareCoupons(WelfareCouponBean welfareCouponBean, PageBean pageBean);

	public int insertWelfareCoupons(WelfareCouponBean welfareCouponBean);

	public int deleteWelfareCoupon(WelfareCouponBean welfareCouponBean);

	public Object getWelfareCouponsV2(WelfareCouponBean welfareCouponBean, PageBean pageBean);

	public Object getWelfareCouponsV3(ShopCouponBean shopCouponBean);

	public int insertShopWelfareCoupons(WelfareCouponBean welfareCouponBean);

	public Object deleteShopWelfareCoupon(WelfareCouponBean welfareCouponBean);

	public Object getShopCoupons(ShopCouponBean shopCouponBean, PageBean pageBean);

}
