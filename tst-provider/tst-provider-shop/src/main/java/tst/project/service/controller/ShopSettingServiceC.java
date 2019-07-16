package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ShopBannerBean;
import tst.project.dao.controller.ShopSettingDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopSettingServiceC;
import tst.project.utils.RedisUtils;

@Service
@Transactional
public class ShopSettingServiceC implements IShopSettingServiceC {
	
	
	@Autowired
	ShopSettingDaoC shopSettingDaoC;
	
	public Object savePercents(List<PercentBean> percentBeans) {
		// TODO Auto-generated method stub
		if(percentBeans!=null){
			for (int i = 0; i < percentBeans.size(); i++) {
				PercentBean percentBean=percentBeans.get(i);
				int num=shopSettingDaoC.updatePercent(percentBean);
				if(num<=0){
					throw new AppException("修改失败");
				}
			}
		}
		return 1;
	}
	
	public Object getPercents(PercentBean percentBean) {
		// TODO Auto-generated method stub
		return shopSettingDaoC.getPercents(percentBean);
	}

	public Object getBanners(ShopBannerBean shopBannerBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		RedisUtils.getJedis().del("shop_banners");
		List<ShopBannerBean> shopBannerBeans = shopSettingDaoC.getBanners(shopBannerBean, pageBean);
		
		
		return pageBean.setObject(shopBannerBeans);
	}
	
	public Object getBannerDetail(ShopBannerBean shopBannerBean) {
		// TODO Auto-generated method stub
		return shopSettingDaoC.getBannerDetail(shopBannerBean);
	}

	public Object moveBanner(ShopBannerBean shopBannerBean) {
		// TODO Auto-generated method stub
		String sort = shopBannerBean.getSort();
		ShopBannerBean shopBannerBean2 = shopSettingDaoC.moveBanner(shopBannerBean);
		if(shopBannerBean2 == null) {
			throw new AppException("desc".equals(shopBannerBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num = shopSettingDaoC.updateBanner(shopBannerBean.setSort(shopBannerBean2.getSort()));
		if(num<=0) {
			throw new AppException("移动失败");
		}
		
		num = shopSettingDaoC.updateBanner(new ShopBannerBean().setBanner_id(
				shopBannerBean2.getBanner_id()).setSort(sort));
		if(num<=0) {
			throw new AppException("移动失败");
		}
		
		return "移动成功";
	}

	public Object insertBanner(ShopBannerBean shopBannerBean) {
		// TODO Auto-generated method stub
		RedisUtils.getJedis().del("shop_banners"+shopBannerBean.getBanner_type());
		int num = shopSettingDaoC.insertBanner(shopBannerBean);
		if(num<=0) { 
			throw new AppException("添加失败");
		}
		return num;
	}


	public Object updateBanner(ShopBannerBean shopBannerBean) {
		// TODO Auto-generated method stub
		RedisUtils.getJedis().del("shop_banners"+shopBannerBean.getBanner_type());
		int num = shopSettingDaoC.updateBanner(shopBannerBean);
		if(num<=0) {
			throw new AppException("修改失败");
		}
		return num;
	}


	public Object deleteBanner(ShopBannerBean shopBannerBean) {
		// TODO Auto-generated method stub
		ShopBannerBean shopBannerBean2 = shopSettingDaoC.getBannerDetail(new ShopBannerBean().setBanner_id(shopBannerBean.getBanner_id()));
		if(shopBannerBean2 == null){
			throw new AppException("删除失败");
		}
		RedisUtils.getJedis().del("shop_banners"+shopBannerBean2.getBanner_type());
		int num = shopSettingDaoC.deleteBanner(shopBannerBean);
		if(num<=0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	
}
