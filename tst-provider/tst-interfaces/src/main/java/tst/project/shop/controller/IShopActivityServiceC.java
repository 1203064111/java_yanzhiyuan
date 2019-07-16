/**
 * 
 */
package tst.project.shop.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityDescendingBean;
import tst.project.bean.shop.ActivityGiveBean;
import tst.project.bean.shop.ActivityGiveGoodsBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.ActivityReduceBean;
import tst.project.bean.shop.ActivityShoppingBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IShopActivityServiceC {
	
	/**
	 * 活动赠送商品的列表
	 * @param activityGiveGoodsBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean,PageBean pageBean);
	
	/**
	 * 获得商品列表(包含规格)  除去这个满赠活动已经赠送的商品
 	 * @param activityGiveGoodsBean
	 * @param pageBean
	 * @return
	 */
	Object getGoodsOutGiveActivity(ActivityGiveGoodsBean activityGiveGoodsBean,PageBean pageBean);
	/**
	 * 获得商品列表(包含规格)  除去已经在这个活动中的
 	 * @param activityGoodsBean
	 * @return
	 */
	Object getGoodsOutActivity(ActivityGoodsBean activityGoodsBean,PageBean pageBean);
	
	/**
	 * 添加活动商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object insertActivityGoods(ActivityGoodsBean activityGoodsBean);
	
	/**
	 * 添加限时活动商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object insertActivityLimitGoods(List<ActivityGoodsBean> activityGoodsBeans);
	
	/**
	 * 删除活动商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object deleteActivityGoods(ActivityGoodsBean activityGoodsBean);
	
	/**
	 * 活动商品列表
	 * @param activityGoodsBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityGoodss(ActivityGoodsBean activityGoodsBean,PageBean pageBean);
	/**
	 * 添加赠送活动
	 * @param activityBean
	 * @return
	 */
	Object insertActivityGive(ActivityGiveBean activityGiveBean);
	
	/**
	 * 修改赠送活动
	 * @param activityBean
	 * @return
	 */
	Object updateActivityGive(ActivityGiveBean activityGiveBean);
	
	/**
	 * 修改活动状态
	 * @param activityBean
	 * @return
	 */
	Object updateActivityState(ActivityBean activityBean);
	
	/**
	 * 添加赠送活动商品
	 * @param activityBean
	 * @return
	 */
	Object insertActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean);
	
	/**
	 * 删除赠送活动商品
	 * @param activityBean
	 * @return
	 */
	Object deleteActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean);
	
	/**
	 * 添加活动
	 * @param activityBean
	 * @return
	 */
	Object insertActivity(ActivityBean activityBean,ActivityGiveBean activityGiveBean,ActivityReduceBean activityReduceBean,ActivityDescendingBean activityDescendingBean);
	
	/**
	 * 修改活动
	 * @param activityBean
	 * @return
	 */
	Object updateActivity(ActivityBean activityBean,ActivityGiveBean activityGiveBean,
			ActivityReduceBean activityReduceBean,ActivityDescendingBean activityDescendingBean);
	
	/**
	 * 删除活动
	 * @param activityBean
	 * @return
	 */
	Object deleteActivity(ActivityBean activityBean);
	
	/**
	 * 获得满赠活动详情
	 * @param activityBean
	 * @return
	 */
	Object getActivityGiveDetail(ActivityBean activityBean);
	
	/**
	 * 获得满减活动详情
	 * @param activityBean
	 * @return
	 */
	Object getActivityReduceDetail(ActivityBean activityBean);
	
	/**
	 * 获得直降活动详情
	 * @param activityBean
	 * @return
	 */
	Object getActivityDescendingDetail(ActivityBean activityBean);
	
	/**
	 * 获得直降活动详情
	 * @param activityBean
	 * @return
	 */
	Object getActivityDetail(ActivityBean activityBean);
	
	/**
	 * 获得活动列表
	 * @param activityBean
	 * @return
	 */
	Object getActivitys(ActivityBean activityBean,PageBean pageBean);
	
	
}
