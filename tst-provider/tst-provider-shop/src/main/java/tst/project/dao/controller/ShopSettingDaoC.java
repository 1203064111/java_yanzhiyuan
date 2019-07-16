package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopSettingDaoC {
	
	/**
	 * 修改商城比例
	 * @param percentBean
	 * @return
	 */
	public int updatePercent(PercentBean percentBean);
	
	/**
	 * 商城比例列表
	 * @author sjb
	 * @param percentBean
	 * @return
	 */
	public List<PercentBean> getPercents(PercentBean percentBean);
	
	/**
	 * 轮播图列表
	 * @param shopBannerBean
	 * @return
	 */
	public List<ShopBannerBean> getBanners(ShopBannerBean shopBannerBean,PageBean pageBean);
	
	/**
	 * 轮播图详情
	 * @param shopBannerBean
	 * @return
	 */
	public ShopBannerBean getBannerDetail(ShopBannerBean shopBannerBean);
	
	/**
	 * 移动图片
	 * @param shopBannerBean
	 * @return
	 */
	public ShopBannerBean moveBanner(ShopBannerBean shopBannerBean);
	
	/**
	 * 添加图片
	 * @param shopBannerBean
	 * @return
	 */
	public int insertBanner(ShopBannerBean shopBannerBean);
	
	/**
	 * 修改图片
	 * @param shopBannerBean
	 * @return
	 */
	public int updateBanner(ShopBannerBean shopBannerBean);
	
	/**
	 * 删除图片
	 * @param shopBannerBean
	 * @return
	 */
	public int deleteBanner(ShopBannerBean shopBannerBean);

	

}
