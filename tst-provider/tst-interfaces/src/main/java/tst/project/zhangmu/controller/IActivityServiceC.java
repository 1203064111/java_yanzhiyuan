package tst.project.zhangmu.controller;

import tst.project.bean.activity.ZMActivityBean;
import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.activity.ZMActivitySunburnBean;
import tst.project.bean.activity.ZMAyOrderBean;
import tst.project.bean.sheep.BannerBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.GoodsBean;

import tst.project.page.PageBean;

public interface IActivityServiceC {
	
	/**
	 * 添加活动
	 * @param activityBean
	 * @return
	 */
	Object insertActivity(ZMActivityBean activityBean);
	
	/**
	 * 得到活动列表
	 * @param activityBean
	 * @return
	 */
	Object getActivitys(ZMActivityBean activityBean, PageBean pageBean);

	/**
	 * 修改活动内容
	 * @param activityBean
	 * @return
	 */
	Object updateActivity(ZMActivityBean activityBean);

	/**
	 * 获得活动详情
	 * @param activityBean
	 * @return
	 */
	Object getActivityDetail(ZMActivityBean activityBean);

	/**
	 * 选择中奖用户
	 * @param ayOrderBean
	 * @return
	 */
	Object updateActivityWinMember(ZMAyOrderBean ayOrderBean);

	/**
	 * 获得活动商品订单表
	 * @param ayOrderBean
	 * @return
	 */
	Object getActivityGoodsOrder(ZMAyOrderBean ayOrderBean, PageBean pageBean);

	/**
	 * 获得用户晒单列表
	 * @param activitySunburnBean
	 * @param pageBean
	 * @return
	 */
	Object getActivitySunburn(ZMActivitySunburnBean activitySunburnBean, PageBean pageBean);

	/**
	 * 选择优质晒单
	 * @param activitySunburnBean
	 * @return
	 */
	Object updateActivitySunburn(ZMActivitySunburnBean activitySunburnBean);

	/**
	 * 删除活动
	 * @param activityBean
	 * @return
	 */
	Object deleteActivity(ZMActivityBean activityBean);

	/**
	 * 获得活动商品列表
	 * @param activityGoodsBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityGoods(ZMActivityGoodsBean activityGoodsBean, PageBean pageBean);

	/**
	 * 删除活动商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object deleteActivityGoods(ZMActivityGoodsBean activityGoodsBean);

	/**
	 * 获得没参加过此活动的商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object getOutOneYuanGoods(ZMActivityGoodsBean activityGoodsBean, PageBean pageBean);

	/**
	 * 添加活动商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object insertActivityGoods(ZMActivityGoodsBean activityGoodsBean);

	/**
	 * 获得我的试吃订单
	 * @param ayOrderBean
	 * @param pageBean
	 * @return
	 */
	Object getMyOneYuanOrder(ZMAyOrderBean ayOrderBean, PageBean pageBean);

	/**
	 * 获得我的试吃评价
	 * @param activitySunburnBean
	 * @param pageBean
	 * @return
	 */
	Object getMyOneYuanSunburn(ZMActivitySunburnBean activitySunburnBean, PageBean pageBean);
	
	/**
	 * 轮播图列表
	 * @param BannerBean
	 * @return
	 */
	public Object getBanners(BannerBean bannerBean,PageBean pageBean);
	
	/**
	 * 轮播图详情
	 * @param BannerBean
	 * @return
	 */
	public Object getBannerDetail(BannerBean bannerBean);
	
	/**
	 * 移动图片
	 * @param BannerBean
	 * @return
	 */
	public Object moveBanner(BannerBean bannerBean);
	
	/**
	 * 添加图片
	 * @param BannerBean
	 * @return
	 */
	public Object insertBanner(BannerBean bannerBean);
	
	/**
	 * 修改图片
	 * @param BannerBean
	 * @return
	 */
	public Object updateBanner(BannerBean bannerBean);
	
	/**
	 * 删除图片
	 * @param BannerBean
	 * @return
	 */
	public Object deleteBanner(BannerBean bannerBean);

	/**
	 * 修改活动商品详情
	 * @author liyong
	 * @param activityGoodsBean
	 * @param pageBean
	 * @return
	 */
	Object updateActivityGoodsDetail(ZMActivityGoodsBean activityGoodsBean, PageBean pageBean);

	/**
	 * 获得活动商品详情
	 * @author liyong
	 * @param activityGoodsBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityGoodsDetail(ZMActivityGoodsBean activityGoodsBean);

	/**
	 * 获得商品中奖者
	 * @author liyong
	 * @param ayOrderBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityGoodsWinners(ZMAyOrderBean ayOrderBean, PageBean pageBean);

}
