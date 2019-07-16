package tst.project.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.ShopCarBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopCarService;

@Controller
@RequestMapping("/shopCarInterfaces/v1.0")
public class ShopCarInterfaces {
	@Autowired
	IShopCarService shopCarService;
	
	
	
	@RequestMapping("/getMemberShopCarSum")
	@AppController(isVerToken=true)
	public Object getMemberShopCarSum(ShopCarBean shopCarBean) throws Exception {
		return shopCarService.getMemberShopCarSum(shopCarBean);
	}
	/**
	 * 购物车列表
	 * @param shopCarBean
	 * @return
	 */
	@RequestMapping("/getShopCars")
	@AppController(isVerToken=true,isPage=true)
	public Object getShopCars(ShopCarBean shopCarBean,PageBean pageBean) throws Exception {
		return shopCarService.getShopCars(shopCarBean,pageBean);
	}
	/**
	 * 添加购物车
	 * @param shopCarBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertShopCar")
	@AppController(isVerToken=true)
	public Object insertShopCar(ShopCarBean shopCarBean) throws Exception {
		return shopCarService.insertShopCar(shopCarBean);
	}
	/**
	 * 修改购物车
	 * @param shopCarBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateShopCar")
	@AppController(isVerToken=true)
	public Object updateShopCar(ShopCarBean shopCarBean) throws Exception {
		return shopCarService.updateShopCar(shopCarBean);
	}
	/**
	 * 删除购物车
	 * @param shopCarBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteShopCar")
	@AppController(isVerToken=true)
	public Object deleteShopCar(ShopCarBean shopCarBean) throws Exception {
		return shopCarService.deleteShopCar(shopCarBean);
	}
	
	/**
	 * 删除购物车
	 * @param shopCarBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteShopCars")
	@AppController(isVerToken=true)
	public Object deleteShopCars(ShopCarBean shopCarBean) throws Exception {
		return shopCarService.deleteShopCars(shopCarBean);
	}
	/**
	 * 结算购物车
	 * @param shopCarBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/balanceShopCars")
	@AppController(isVerToken=true)
	public Object balanceShopCars(ShopCarBean shopCarBean) throws Exception {
		return shopCarService.balanceShopCars(shopCarBean);
	}
	
	
	
}
