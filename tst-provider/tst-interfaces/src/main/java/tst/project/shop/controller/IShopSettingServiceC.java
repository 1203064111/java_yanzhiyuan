package tst.project.shop.controller;


import java.util.List;

import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.page.PageBean;

public interface IShopSettingServiceC {
	
	/**
	 * 设置比例
	 * @author sjb
	 * @param percentBeans
	 * @return
	 */
	public Object savePercents(List<PercentBean> percentBeans);
	
	/**
	 * 商城比例列表
	 * @author sjb
	 * @param percentBean
	 * @return
	 */
	public Object getPercents(PercentBean percentBean);
	
	/**
	 * 轮播图列表
	 * @param shopBannerBean
	 * @return
	 */
	public Object getBanners(ShopBannerBean shopBannerBean,PageBean pageBean);
	
	/**
	 * 轮播图详情
	 * @param shopBannerBean
	 * @return
	 */
	public Object getBannerDetail(ShopBannerBean shopBannerBean);
	
	/**
	 * 移动图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object moveBanner(ShopBannerBean shopBannerBean);
	
	/**
	 * 添加图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object insertBanner(ShopBannerBean shopBannerBean);
	
	/**
	 * 修改图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object updateBanner(ShopBannerBean shopBannerBean);
	
	/**
	 * 删除图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object deleteBanner(ShopBannerBean shopBannerBean);

	
	
	

}
