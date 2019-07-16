package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopActivityDao {
	/**
	 * 获得限时活动列表
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getActivityLimits(ActivityBean activityBean,PageBean pageBean);
	
	/**
	 * 获得限时活动商品列表
	 * @param activityGoodsBean
	 * @return
	 */
	public List<ActivityGoodsBean> getActivityLimitGoods(ActivityGoodsBean activityGoodsBean,PageBean pageBean);
}
