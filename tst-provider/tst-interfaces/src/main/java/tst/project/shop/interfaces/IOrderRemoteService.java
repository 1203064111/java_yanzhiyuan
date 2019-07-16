package tst.project.shop.interfaces;

import java.util.List;
import java.util.Map;

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

/**
 * 
 * @author sjb
 *
 */
public interface IOrderRemoteService {
	
	/**
	 * 商城比例
	 * @author sjb
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercentDetail(PercentBean percentBean);
	
	/**
	 * 修改用户优惠券详情
	 * @param shopMemberCouponBean
	 * @return
	 */
	public int updateShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 修改优惠券使用量
	 * @param shopCouponBean
	 */
	public int updateShopCouponUsedNum(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 用户可以用在场景的优惠券列表
	 * @author sjb
	 * @param shopMemberCouponBean
	 * @return
	 */
	public List<ShopMemberCouponBean> getShopMemberCoupons(ShopMemberCouponBean shopMemberCouponBean);
	
	/**
	 * 修改订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int updateOrder(OrderBean orderBean);
	
	
	/**
	 * 修改订单详情
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int updateOrderMerchants(OrderMerchantsBean orderDetailBean);

	
	/**
	 * 修改订单商品的信息
	 * @sjb
	 * @param orderGoodsBean
	 * @return
	 */
	public int updateOrderGoods(OrderGoodsBean orderGoodsBean);

	/**
	 * 获得订单商品的邮费详情
	 * @sjb
	 * @param freightCityBean
	 * @return
	 */
	public Map<String, Object> getGoodsFreightDetail(FreightCityBean freightCityBean);
	/**
	 * 修改商品规格库存
	 * @author sjb
	 * @param goodsSpecificationBean
	 * @return
	 */
	public int updateGoodsSpecificationStock(GoodsSpecificationBean goodsSpecificationBean);
	/**
	 * 修改商品库存
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsStock(GoodsBean goodsBean);
	
	/**
	 * 添加订单商品
	 * @author sjb
	 * @param orderGoodsBean
	 * @return
	 */
	public int insertOrderGoods(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 获得商品的规格详情
	 * @author sjb
	 * @param goodsSpecificationBean
	 * @return
	 */
	public GoodsSpecificationBean getGoodsSpecificationDetail(GoodsSpecificationBean goodsSpecificationBean);
	
	/**
	 * 添加商家订单
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	int insertOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 获得商家详情
	 * @author sjb
	 * @param merchantsBean
	 * @return
	 */
	MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean);
	
	/**
	 * 获得场景的商品列表
	 * @author sjb
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSceneGoodss(Map<String, Object> map);
	
	/**
	 * 订单入库
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	int insertOrder(OrderBean orderBean);
	
	/**
	 * 订单地址入库
	 * @author sjb
	 * @param orderAddressBean
	 * @return
	 */
	int insertOrderAddress(OrderAddressBean orderAddressBean);
}
