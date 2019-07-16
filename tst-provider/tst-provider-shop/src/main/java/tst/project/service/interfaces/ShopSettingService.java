package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.setting.CityBean;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.dao.interfaces.ShopSettingDao;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopSettingService;
import tst.project.utils.RedisUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class ShopSettingService implements IShopSettingService{

	@Autowired
	ShopSettingDao shopSeetingDaovice;
	
	public Object getBanners(ShopBannerBean shopBannerBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		String shop_banners=RedisUtils.getKey("shop_banners"+shopBannerBean.getBanner_type());
		
		List<ShopBannerBean> shopBannerBeans=null;
		if(shop_banners==null||shop_banners.equals("")){
			shopBannerBeans=shopSeetingDaovice.getBanners(shopBannerBean, pageBean);
			boolean is_success=RedisUtils.setKey("shop_banners"+shopBannerBean.getBanner_type(), JSON.toJSONString(shopBannerBeans));
			if(!is_success){
				throw new AppException("缓存失败!");
			}
		}else{
			shopBannerBeans=JSON.parseArray(shop_banners, ShopBannerBean.class);
		}
		
		return pageBean.setObject(shopBannerBeans);
	}
}
