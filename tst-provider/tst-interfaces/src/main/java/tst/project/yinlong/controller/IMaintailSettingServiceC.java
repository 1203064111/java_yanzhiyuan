package tst.project.yinlong.controller;


import tst.project.bean.yinlong.MaintailServiceTimeBean;
import tst.project.bean.yinlong.YinlongBannerBean;
import tst.project.page.PageBean;

public interface IMaintailSettingServiceC {
	
	/**
	 * 轮播图列表
	 * @author hxf
	 * @param yinlongBannerBean
	 * @param pageBean
	 * @return
	 */
	public Object getBanners(YinlongBannerBean yinlongBannerBean,PageBean pageBean);
	
	/**
	 * 轮播图详情
	 * @param shopBannerBean
	 * @return
	 */
	public Object getBannerDetail(YinlongBannerBean yinlongBannerBean);
	

	/**
	 * 移动图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object moveBanner(YinlongBannerBean yinlongBannerBean);
	
	/**
	 * 添加图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object insertBanner(YinlongBannerBean yinlongBannerBean);
	
	/**
	 * 修改图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object updateBanner(YinlongBannerBean yinlongBannerBean);
	
	/**
	 * 删除图片
	 * @param shopBannerBean
	 * @return
	 */
	public Object deleteBanner(YinlongBannerBean yinlongBannerBean);
	
	
}
