package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.ShopCarBean;
import tst.project.page.PageBean;

@Mapper
public interface ShopCarDao {
	
	
	/**
	 * 用户购物车数量
	 * @author hwq
	 * @param shopCarBean
	 * @return
	 */
	public int getMemberShopCarSum(ShopCarBean shopCarBean);
	
	/**
	 * 获得商家购物车获得列表
	 * @return
	 */
	public List<ActivityBean> getMerchantsCarsActivitys(ActivityGoodsBean activityGoodsBean);
	
	/**
	 * 购物车详情
	 * @param shopCarBean
	 * @return
	 */
	public ShopCarBean getShopCarDetail(ShopCarBean shopCarBean);
	
	/**
	 * 购物车列表
	 * @param shopCarBean
	 * @return
	 */
	public List<ShopCarBean> getShopCars(ShopCarBean shopCarBean,PageBean pageBean);
	
	/**
	 * 购物车列表（按商家做聚合）
	 * @param shopCarBean
	 * @return
	 */
	public List<Map<String,Object>> getShopCarsByMerchants(ShopCarBean shopCarBean,PageBean pageBean);
	
	/**
	 * 添加购物车
	 * @param goodsCarBean
	 * @return
	 */
	public int insertShopCar(ShopCarBean shopCarBean);
	
	/**
	 * 修改购物车
	 * @param shopCarBean
	 * @return
	 */
	public int updateShopCar(ShopCarBean shopCarBean);
	
	/**
	 * 删除购物车
	 * @param shopCarBean
	 * @return
	 */
	public int deleteShopCar(ShopCarBean shopCarBean);
	
	/**
	 * 批量删除购物车
	 * @param shopCarBean
	 * @return
	 */
	public int deleteShopCars(ShopCarBean shopCarBean);
	
	
}
