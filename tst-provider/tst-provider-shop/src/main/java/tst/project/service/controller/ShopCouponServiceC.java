package tst.project.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.cluster.merger.SetMerger;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.controller.IMemberServiceC;
import tst.project.dao.controller.ShopCouponDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopCouponServiceC;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class ShopCouponServiceC implements IShopCouponServiceC{
	
	@Autowired
	ShopCouponDaoC shopCouponDaoC;
	
	@Autowired
	IMemberServiceC memberServiceC;
	
	@Override
	public Map<String, Object> getCouponStatistics(ShopMemberCouponBean shopMemberCouponBean) {
		// TODO Auto-generated method stub
		return shopCouponDaoC.getCouponStatistics(shopMemberCouponBean);
	}
	
	public Object getCouponGoodss(ShopCouponBean shopCouponBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> maps=shopCouponDaoC.getCouponGoodss(shopCouponBean, pageBean);
		return pageBean.setObject(maps);
	}
	
	public Object getGoodsOutCoupon(String coupon_id,String goods_name,String class_name,String merchants_id, PageBean pageBean) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("coupon_id", coupon_id);
		map.put("goods_name", goods_name);
		map.put("class_name", class_name);
		map.put("merchants_id", merchants_id);
		
		List<Map<String,Object>> maps=shopCouponDaoC.getGoodsOutCoupon(map, pageBean);
		return pageBean.setObject(maps);
	}
	
	
	
	public Object insertShopCoupon(ShopCouponBean shopCouponBean) {
		// TODO Auto-generated method stub
		int num=shopCouponDaoC.insertShopCoupon(shopCouponBean);
		if(num<=0){
			throw new AppException("添加优惠券失败");
		}
		return shopCouponBean.getCoupon_id();
	}

	
	public Object updateShopCoupon(ShopCouponBean ShopCouponBean) {
		// TODO Auto-generated method stub
		int num=shopCouponDaoC.updateShopCoupon(ShopCouponBean);
		if(num<=0){
			throw new AppException("修改优惠券失败");
		}
		return num;
	}

	
	public Object deleteShopCoupon(ShopCouponBean ShopCouponBean) {
		// TODO Auto-generated method stub
		int num=shopCouponDaoC.deleteShopCoupon(ShopCouponBean);
		if(num<=0){
			throw new AppException("删除优惠券失败");
		}
		return num;
	}

	
	public Object getShopCoupons(ShopCouponBean ShopCouponBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ShopCouponBean> ShopCouponBeans=shopCouponDaoC.getShopCoupons(ShopCouponBean, pageBean);
		return pageBean.setObject(ShopCouponBeans);
	}
	@Override
	public Object getShopCouponsV2(ShopCouponBean ShopCouponBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ShopCouponBean> ShopCouponBeans=shopCouponDaoC.getShopCouponsV2(ShopCouponBean,pageBean);
		return pageBean.setObject(ShopCouponBeans);
	}

	
	public Object getShopCouponDetail(ShopCouponBean ShopCouponBean) {
		// TODO Auto-generated method stub
		return shopCouponDaoC.getShopCouponDetail(ShopCouponBean);
	}

	

}
