package tst.project.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.FreightCityBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.OrderAddressBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderGoodsBean;
import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.dao.interfaces.OrderRemoteDao;
import tst.project.shop.interfaces.IOrderRemoteService;

@Service
@Transactional(rollbackFor=Exception.class)
public class OrderRemoteService implements IOrderRemoteService{
	@Autowired
	OrderRemoteDao orderRemoteDao;
	@Override
	public PercentBean getPercentDetail(PercentBean percentBean) {
		// TODO Auto-generated method stub
		return orderRemoteDao.getPercentDetail(percentBean);
	}
	
	@Override
	public int updateShopCouponUsedNum(ShopMemberCouponBean shopMemberCouponBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.updateShopCouponUsedNum(shopMemberCouponBean);
		return num;
	}
	
	@Override
	public int updateShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.updateShopMemberCouponDetail(shopMemberCouponBean);
		return num;
	}
	
	@Override
	public List<ShopMemberCouponBean> getShopMemberCoupons(ShopMemberCouponBean shopMemberCouponBean) {
		// TODO Auto-generated method stub
		return orderRemoteDao.getShopMemberCoupons(shopMemberCouponBean);
	}
	
	/**
	 * 修改订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int updateOrder(OrderBean orderBean){
		int num=orderRemoteDao.updateOrder(orderBean);
		if(num<=0){
			throw new AppException("修改订单失败");
		}
		return num;
	}
	

	
	/**
	 * 修改订单详情
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int updateOrderMerchants(OrderMerchantsBean orderMerchantsBean){
		int num=orderRemoteDao.updateOrderMerchants(orderMerchantsBean);
		if(num<=0){
			throw new AppException("修改订单详情失败");
		}
		return num;
	}
	/**
	 * 修改订单商品的信息
	 * @sjb
	 * @param orderGoodsBean
	 * @return
	 */
	public int updateOrderGoods(OrderGoodsBean orderGoodsBean){
		int num=orderRemoteDao.updateOrderGoods(orderGoodsBean);
		if(num<=0){
			throw new AppException("修改订单商品失败");
		}
		return num;
	}
	
	/**
	 * 获得订单商品的邮费详情
	 * @sjb
	 * @param freightCityBean
	 * @return
	 */
	public Map<String, Object> getGoodsFreightDetail(FreightCityBean freightCityBean){
		return orderRemoteDao.getGoodsFreightDetail(freightCityBean);
	}
	
	@Override
	public int updateGoodsStock(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.updateGoodsStock(goodsBean);
		if(num<=0){
			throw new AppException("商品库存更新失败!");
		}
		return num;
	}
	@Override
	public int updateGoodsSpecificationStock(GoodsSpecificationBean goodsSpecificationBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.updateGoodsSpecificationStock(goodsSpecificationBean);
		if(num<=0){
			throw new AppException("规格库存更新失败!");
		}
		return num;
	}
	@Override
	public int insertOrderGoods(OrderGoodsBean orderGoodsBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.insertOrderGoods(orderGoodsBean);
		if(num<=0){
			throw new AppException("商品添加失败!");
		}
		return orderGoodsBean.getOrder_goods_id();
	}
	@Override
	public GoodsSpecificationBean getGoodsSpecificationDetail(GoodsSpecificationBean goodsSpecificationBean) {
		// TODO Auto-generated method stub
		return orderRemoteDao.getGoodsSpecificationDetail(goodsSpecificationBean);
	}
	
	@Override
	public int insertOrderMerchants(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.insertOrderMerchants(orderMerchantsBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		return orderMerchantsBean.getOrder_merchants_id();
	}
	
	@Override
	public MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		return orderRemoteDao.getMerchantsDetail(merchantsBean);
	}
	
	@Override
	public List<Map<String, Object>> getSceneGoodss(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps=orderRemoteDao.getSceneGoodssGroupMerchants(map);
		for (int i = 0; i < maps.size(); i++) {
			Map<String, Object> map2=maps.get(i);
			map.put("merchants_id", map2.get("merchants_id"));
			List<Map<String, Object>> goodsBeans=orderRemoteDao.getSceneGoodss(map);
			map2.put("goodsBeans", goodsBeans);
		}
		return maps;
	}
	
	@Override
	public int insertOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.insertOrder(orderBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		return orderBean.getOrder_id();
	}
	
	@Override
	public int insertOrderAddress(OrderAddressBean orderAddressBean) {
		// TODO Auto-generated method stub
		int num=orderRemoteDao.insertOrderAddress(orderAddressBean);
		if(num<=0){
			throw new AppException("添加地址失败");
		}
		return num;
	}
}
