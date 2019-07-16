package tst.project.shop.interfaces;

import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.page.PageBean;

public interface IShopActivityService {
	
	/**
	 * 获得限时活动列表
	 * @param activityBean
	 * @return
	 */
	public Object getActivityLimits(ActivityBean activityBean,PageBean pageBean);
	
	/**
	 * 获得限时活动商品列表
	 * @param activityGoodsBean
	 * @return
	 */
	public Object getActivityLimitGoods(ActivityGoodsBean activityGoodsBean,PageBean pageBean);
}
