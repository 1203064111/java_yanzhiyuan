package tst.project.shop.interfaces;


import com.sun.corba.se.impl.orbutil.ObjectStreamClass_1_3_1;

import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.ShopCarBean;
import tst.project.page.PageBean;


public interface IShopCarService {
	
	
	
	
	/**
	 * 用户购物车数量
	 * @author hwq
	 * @param shopCarBean
	 * @return
	 */
	public Object getMemberShopCarSum(ShopCarBean shopCarBean);
	
	/**
	 * 购物车列表
	 * @param shopCarBean
	 * @return
	 */
	public Object getShopCars(ShopCarBean shopCarBean,PageBean pageBean);
	
	
	/**
	 * 添加购物车
	 * @param goodsCarBean
	 * @return
	 */
	public Object insertShopCar(ShopCarBean shopCarBean);
	
	/**
	 * 修改购物车
	 * @param shopCarBean
	 * @return
	 */
	public Object updateShopCar(ShopCarBean shopCarBean);
	
	/**
	 * 删除购物车
	 * @param shopCarBean
	 * @return
	 */
	public Object deleteShopCar(ShopCarBean shopCarBean);
	
	/**
	 * 批量删除购物车
	 * @param shopCarBean
	 * @return
	 */
	public Object deleteShopCars(ShopCarBean shopCarBean);
	
	
	/**
	 * 结算购物车
	 * @author lx
	 * @param shopCarBean
	 * @return
	 */
	public Object balanceShopCars(ShopCarBean shopCarBean);
	
	
}
