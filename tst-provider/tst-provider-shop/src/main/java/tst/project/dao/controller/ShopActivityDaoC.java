package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityDescendingBean;
import tst.project.bean.shop.ActivityGiveBean;
import tst.project.bean.shop.ActivityGiveGoodsBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.ActivityReduceBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopActivityDaoC {

	/**
	 * 获得活动详情
	 * @param activityBean
	 * @return
	 */
	ActivityBean getActivityDetail(ActivityBean activityBean);
	
	/**
	 * 活动赠送商品的列表
	 * @param activityGiveGoodsBean
	 * @param pageBean
	 * @return
	 */
	List<ActivityGiveGoodsBean> getActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean,PageBean pageBean);
	
	/**
	 * 添加赠送活动商品
	 * @param activityBean
	 * @return
	 */
	int insertActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean);
	
	/**
	 * 删除赠送活动商品
	 * @param activityBean
	 * @return
	 */
	int deleteActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean);
	
	/**
	 * 获得商品列表(包含规格)  除去这个满赠活动已经赠送的商品
 	 * @param activityGiveGoodsBean
	 * @param pageBean
	 * @return
	 */
	List<Map<String,Object>> getGoodsOutGiveActivity(ActivityGiveGoodsBean activityGiveGoodsBean,PageBean pageBean);
	
	/**
	 * 获得商品列表(包含规格)  除去已经在这个活动中的
 	 * @param activityGoodsBean
	 * @return
	 */
	List<Map<String,Object>> getGoodsOutActivity(ActivityGoodsBean activityGoodsBean,PageBean pageBean);
	
	/**
	 * 添加活动商品
	 * 
	 * @param activityGoodsBean
	 * @return
	 */
	int insertActivityGoods(ActivityGoodsBean activityGoodsBean);

	/**
	 * 删除活动商品
	 * 
	 * @param activityGoodsBean
	 * @return
	 */
	int deleteActivityGoods(ActivityGoodsBean activityGoodsBean);

	/**
	 * 活动商品列表
	 * 
	 * @param activityGoodsBean
	 * @param pageBean
	 * @return
	 */
	List<ActivityGoodsBean> getActivityGoodss(ActivityGoodsBean activityGoodsBean, PageBean pageBean);

	/**
	 * 活动商品列表
	 * 
	 * @param activityGoodsBean
	 * @param pageBean
	 * @return
	 */
	ActivityGoodsBean getActivityGoodsDetail(ActivityGoodsBean activityGoodsBean);

	/**
	 * 添加满赠活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	int insertActivityGive(ActivityGiveBean activityGiveBean);

	/**
	 * 修改满赠活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	int updateActivityGive(ActivityGiveBean activityGiveBean);
	
	/**
	 * 修改活动状态
	 * @param activityBean
	 * @return
	 */
	int updateActivityState(ActivityBean activityBean);

	/**
	 * 获得满赠活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	ActivityBean getActivityGiveDetail(ActivityBean activityBean);

	/**
	 * 添加满减活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	int insertActivityReduce(ActivityReduceBean activityReduceBean);

	/**
	 * 修改满减活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	int updateActivityReduce(ActivityReduceBean activityReduceBean);

	/**
	 * 获得满减活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	ActivityBean getActivityReduceDetail(ActivityBean activityBean);

	/**
	 * 添加直降活动
	 * 
	 * @param activityBean
	 * @return
	 */
	int insertActivityDescending(ActivityDescendingBean activityDescendingBean);
	
	/**
	 * 修改直降活动
	 * @param activityBean
	 * @return
	 */
	int updateActivityDescending(ActivityDescendingBean activityDescendingBean);
	
	/**
	 * 获得直降活动详情
	 * @param activityBean
	 * @return
	 */
	ActivityBean getActivityDescendingDetail(ActivityBean activityBean);
	
	/**
	 * 添加活动
	 * 
	 * @param activityBean
	 * @return
	 */
	int insertActivity(ActivityBean activityBean);

	/**
	 * 修改活动
	 * 
	 * @param activityBean
	 * @return
	 */
	int updateActivity(ActivityBean activityBean);

	/**
	 * 删除活动
	 * 
	 * @param activityBean
	 * @return
	 */
	int deleteActivity(ActivityBean activityBean);

	/**
	 * 获得活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	List<ActivityBean> getActivitys(ActivityBean activityBean, PageBean pageBean);
	
	
	
}
