package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.dao.interfaces.ShopActivityDao;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopActivityService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ShopActivityService implements IShopActivityService {
	@Autowired
	ShopActivityDao shopActivityDao;
	
	public Object getActivityLimitGoods(ActivityGoodsBean activityGoodsBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ActivityGoodsBean> activityGoodsBeans=shopActivityDao.getActivityLimitGoods(activityGoodsBean, pageBean);
		return pageBean.setObject(activityGoodsBeans);
	}

	public Object getActivityLimits(ActivityBean activityBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ActivityBean> activityBeans=shopActivityDao.getActivityLimits(activityBean, pageBean);
		return pageBean.setObject(activityBeans);
	}
}
