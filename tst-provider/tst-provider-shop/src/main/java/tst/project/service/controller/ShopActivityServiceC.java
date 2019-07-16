package tst.project.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityDescendingBean;
import tst.project.bean.shop.ActivityGiveBean;
import tst.project.bean.shop.ActivityGiveGoodsBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.ActivityReduceBean;
import tst.project.bean.shop.ActivityShoppingBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.dao.controller.ShopActivityDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopActivityServiceC;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShopActivityServiceC implements IShopActivityServiceC {
	@Autowired
	ShopActivityDaoC shopActivityDaoC;

	public Object getActivityDetail(ActivityBean activityBean) {
		// TODO Auto-generated method stub
		return shopActivityDaoC.getActivityDetail(activityBean);
	}
	
	public Object getActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ActivityGiveGoodsBean> activityGiveGoodsBeans=shopActivityDaoC.getActivityGiveGoods(activityGiveGoodsBean, pageBean);
		
		return pageBean.setObject(activityGiveGoodsBeans);
	}
	
	
	public Object insertActivityGive(ActivityGiveBean activityGiveBean) {
		// TODO Auto-generated method stub
		int num=shopActivityDaoC.insertActivityGive(activityGiveBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		return num;
	}
	
	
	public Object updateActivityGive(ActivityGiveBean activityGiveBean) {
		// TODO Auto-generated method stub
		int num=shopActivityDaoC.updateActivityGive(activityGiveBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		return num;
	}
	
	public Object deleteActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean) {
		// TODO Auto-generated method stub
		int num=shopActivityDaoC.deleteActivityGiveGoods(activityGiveGoodsBean);
		if(num<=0){
			throw new AppException("删除失败");
		}
		return num;
	}
	
	
	public Object insertActivityGiveGoods(ActivityGiveGoodsBean activityGiveGoodsBean) {
		// TODO Auto-generated method stub
		int num=shopActivityDaoC.insertActivityGiveGoods(activityGiveGoodsBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		return num;
	}
	
	
	public Object getGoodsOutGiveActivity(ActivityGiveGoodsBean activityGiveGoodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> maps=shopActivityDaoC.getGoodsOutGiveActivity(activityGiveGoodsBean, pageBean);
		return pageBean.setObject(maps);
	}
	
	
	public Object getGoodsOutActivity(ActivityGoodsBean activityGoodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> maps=shopActivityDaoC.getGoodsOutActivity(activityGoodsBean, pageBean);
		return pageBean.setObject(maps);
	}
	
	public Object insertActivityLimitGoods(List<ActivityGoodsBean> activityGoodsBeans) {
		// TODO Auto-generated method stub
		for (int i = 0; i < activityGoodsBeans.size(); i++) {
			ActivityGoodsBean activityGoodsBean=activityGoodsBeans.get(i);
			int num = shopActivityDaoC.insertActivityGoods(activityGoodsBean);
			if (num <= 0) {
				throw new AppException("添加失败");
			}
		}
		return 1;
	}
	
	public Object insertActivityGoods(ActivityGoodsBean activityGoodsBean) {
		// TODO Auto-generated method stub
		
		int num = shopActivityDaoC.insertActivityGoods(activityGoodsBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	public Object deleteActivityGoods(ActivityGoodsBean activityGoodsBean) {
		// TODO Auto-generated method stub
		int num = shopActivityDaoC.deleteActivityGoods(activityGoodsBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	public Object getActivityGoodss(ActivityGoodsBean activityGoodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ActivityGoodsBean> activityGoodsBeans = shopActivityDaoC.getActivityGoodss(activityGoodsBean, pageBean);
		return pageBean.setObject(activityGoodsBeans);
	}

	
	
	
	
	public Object insertActivity(ActivityBean activityBean,ActivityGiveBean activityGiveBean,
			ActivityReduceBean activityReduceBean,ActivityDescendingBean activityDescendingBean) {
		// TODO Auto-generated method stub
		int num = shopActivityDaoC.insertActivity(activityBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}

		if("1".equals(activityBean.getActivity_type())){//满赠活动
//			num=shopActivityDaoC.insertActivityGive(activityGiveBean.setActivity_id(activityBean.getActivity_id()+""));
//			if(num<=0){
//				throw new AppException("优惠详情添加失败");
//			}
		} else if ("2".equals(activityBean.getActivity_type())) {// 满减活动
			num = shopActivityDaoC
					.insertActivityReduce(activityReduceBean.setActivity_id(activityBean.getActivity_id() + ""));
			if (num <= 0) {
				throw new AppException("优惠详情添加失败");
			}

			
		}else if("3".equals(activityBean.getActivity_type())){//直降活动
			num=shopActivityDaoC.insertActivityDescending(activityDescendingBean.setActivity_id(activityBean.getActivity_id()+""));
			if(num<=0){
				throw new AppException("优惠详情添加失败");
			}
		}else if("4".equals(activityBean.getActivity_type())){//一元抢购
			
		}else{
			throw new AppException("活动类型异常");
		}
		return activityBean.getActivity_id();
	}

	public Object updateActivityState(ActivityBean activityBean) {
		int num = shopActivityDaoC.updateActivityState(activityBean);
		if(num<=0) {
			throw new AppException("修改失败");
		}
		return num;
	}
	
	
	public Object updateActivity(ActivityBean activityBean,ActivityGiveBean activityGiveBean,
			ActivityReduceBean activityReduceBean,ActivityDescendingBean activityDescendingBean) {
		// TODO Auto-generated method stub
		int num = shopActivityDaoC.updateActivity(activityBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}


		if("1".equals(activityBean.getActivity_type())){//满赠活动
//			num=shopActivityDaoC.updateActivityGive(activityGiveBean.setActivity_id(activityBean.getActivity_id()+""));
//			if(num<=0){
//				throw new AppException("优惠详情修改失败");
//			}
		} else if ("2".equals(activityBean.getActivity_type())) {// 满减活动
			num = shopActivityDaoC
					.updateActivityReduce(activityReduceBean.setActivity_id(activityBean.getActivity_id() + ""));
			if (num <= 0) {
				throw new AppException("优惠详情修改失败");
			}

		
		}else if("3".equals(activityBean.getActivity_type())){//直降活动
			num=shopActivityDaoC.updateActivityDescending(activityDescendingBean.setActivity_id(activityBean.getActivity_id()+""));
			if(num<=0){
				throw new AppException("优惠详情修改失败");
			}
		}else if("4".equals(activityBean.getActivity_type())){//一元抢购
			
		}else{
			throw new AppException("活动类型异常");
		}
		return num;
	}

	public Object deleteActivity(ActivityBean activityBean) {
		// TODO Auto-generated method stub
		int num = shopActivityDaoC.deleteActivity(activityBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	public Object getActivityGiveDetail(ActivityBean activityBean) {
		// TODO Auto-generated method stub
		ActivityBean activityBean2 = shopActivityDaoC.getActivityGiveDetail(activityBean);
		return activityBean2;
	}

	public Object getActivityReduceDetail(ActivityBean activityBean) {
		// TODO Auto-generated method stub
		ActivityBean activityBean2 = shopActivityDaoC.getActivityReduceDetail(activityBean);
		return activityBean2;
	}

	public Object getActivityDescendingDetail(ActivityBean activityBean) {
		// TODO Auto-generated method stub
		ActivityBean activityBean2 = shopActivityDaoC.getActivityDescendingDetail(activityBean);
		return activityBean2;
	}

	public Object getActivitys(ActivityBean activityBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ActivityBean> activityBeans = shopActivityDaoC.getActivitys(activityBean, pageBean);

		return pageBean.setObject(activityBeans);
	}

	


}
