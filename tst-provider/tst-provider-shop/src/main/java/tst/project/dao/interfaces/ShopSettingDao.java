package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopSettingDao {
	
	/**
	 * 比例详情
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercentDetail(PercentBean percentBean);
	/**
	 * 轮播广告列表
	 * @param shopBannerBean
	 * @return
	 */
	public List<ShopBannerBean> getBanners(ShopBannerBean shopBannerBean, PageBean pageBean);
}
