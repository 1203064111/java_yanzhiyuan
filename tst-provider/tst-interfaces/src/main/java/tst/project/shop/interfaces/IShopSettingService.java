/**
 * 
 */
package tst.project.shop.interfaces;

import tst.project.bean.shop.ShopBannerBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IShopSettingService {
	
	/**
	 * 轮播图列表
	 * @param shopBannerBean
	 * @return
	 */
	public Object getBanners(ShopBannerBean shopBannerBean, PageBean pageBean);
}
