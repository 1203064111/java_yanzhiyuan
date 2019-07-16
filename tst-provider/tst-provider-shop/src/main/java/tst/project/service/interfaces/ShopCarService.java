package tst.project.service.interfaces;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tst.project.aspect.AppException;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.ShopCarBean;
import tst.project.dao.interfaces.GoodsDao;
import tst.project.dao.interfaces.MerchantsDao;
import tst.project.dao.interfaces.OrderDao;
import tst.project.dao.interfaces.ShopCarDao;
import tst.project.dao.interfaces.ShopSettingDao;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopCarService;
import tst.project.utils.NumberUtils;
import tst.project.utils.UUIDUtils;

@Service
@Transactional
public class ShopCarService implements IShopCarService{
	
	@Autowired
	GoodsDao goodsDao;
	
	@Autowired
	ShopCarDao shopCarDao;
	
	@Autowired
	MerchantsDao merchantsDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ShopSettingDao shopSettingDao;
	
	
	public Object getShopCars(ShopCarBean shopCarBean,PageBean pageBean) {
//		List<Map<String,Object>> maps = shopCarDao.getShopCarsByMerchants(shopCarBean,pageBean);
//		if(maps!=null){
//			for (int i = 0; i < maps.size(); i++) {
//				Map<String,Object> map=maps.get(i);
//				List<ShopCarBean> shopCarBeans=shopCarDao.getShopCars(shopCarBean.setMerchants_id(map.get("merchants_id")+""));
//				map.put("shopCarBeans",shopCarBeans);
//				
//				String goods_ids="";
//				for (int j = 0; j < shopCarBeans.size(); j++) {
//					goods_ids+=shopCarBeans.get(j).getGoods_id()+",";
//				}
//				List<ActivityBean> activityBeans=shopCarDao.getMerchantsCarsActivitys(new ActivityGoodsBean().setGoods_id(goods_ids));
//				map.put("activityBeans",activityBeans);
//			}
//		}
		List<ShopCarBean> shopCarBeans=shopCarDao.getShopCars(shopCarBean,pageBean);
		return pageBean.setObject(shopCarBeans);
	}
	
	public Object insertShopCar(ShopCarBean shopCarBean) {
		GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean().setGoods_id
				(NumberUtils.Integer(shopCarBean.getGoods_id())));
		if(goodsBean==null) {
			throw new AppException("商品不存在");
		}
		if("0".equals(goodsBean.getGoods_state())) {
			throw new AppException("商品已下架");
		}
		
//		GoodsSpecificationBean goodsSpecificationBean = goodsDao.getGoodsSpecificationDetail(new GoodsSpecificationBean()
//				.setSpecification_id(shopCarBean.getSpecification_id()));
//		if(goodsSpecificationBean==null) {
//			throw new AppException("该规格商品不存在");
//		}
//		if(!goodsSpecificationBean.getGoods_id().equals(goodsBean.getGoods_id()+"")) {
//			throw new AppException("商品规格不匹配");
//		}
//		if("0".equals(goodsSpecificationBean.getSpecification_state())) {
//			throw new AppException("该规格商品已下架");
//		}
		
		if(NumberUtils.Integer(shopCarBean.getGoods_num())<=0) {
			throw new AppException("购物车数量异常");
		}
//		if(NumberUtils.Integer(goodsSpecificationBean.getSpecification_stock())<
//				NumberUtils.Integer(shopCarBean.getGoods_num())) {
//			throw new AppException("该规格库存不足");
//		}
//		ShopCarBean shopCarBean2=shopCarDao.getShopCarDetail(shopCarBean);
//		int num=0;
//		if(shopCarBean2==null){//之前没有添加过
//			num=shopCarDao.insertShopCar(shopCarBean.setGoods_name(goodsBean.getGoods_name())
//					.setGoods_img(goodsBean.getGoods_img())
//					.setMerchants_id(goodsBean.getMerchants_id()));
//			if(num<=0){
//				throw new AppException("添加失败!");
//			}
//		}else{//之前添加过
//			int goods_num=NumberUtils.Integer(shopCarBean.getGoods_num())+NumberUtils.Integer(shopCarBean2.getGoods_num());
//			num=shopCarDao.updateShopCar(new ShopCarBean()
//					.setCar_id(shopCarBean2.getCar_id())
//					.setGoods_num(goods_num+"")
//					.setMember_id(shopCarBean.getMember_id()));
//			if(num<=0){
//				throw new AppException("添加失败");
//			}
//		}
		
		int num=shopCarDao.insertShopCar(shopCarBean.setGoods_name(goodsBean.getGoods_name())
				.setGoods_img(goodsBean.getGoods_img())
				.setMerchants_id(goodsBean.getMerchants_id())
				.setSpecification_price(goodsBean.getGoods_now_price()));
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	public Object updateShopCar(ShopCarBean shopCarBean) {
		ShopCarBean shopCarBean2=shopCarDao.getShopCarDetail(shopCarBean);
		if(shopCarBean2==null){
			throw new AppException("购物车不存在!");
		}
		
//		GoodsSpecificationBean goodsSpecificationBean = goodsDao.getGoodsSpecificationDetail(new GoodsSpecificationBean()
//				.setSpecification_id(shopCarBean2.getSpecification_id()));
//		if(goodsSpecificationBean==null) {
//			throw new AppException("该规格商品不存在");
//		}
//		
//		if(NumberUtils.Integer(goodsSpecificationBean.getSpecification_stock())<
//				NumberUtils.Integer(shopCarBean.getGoods_num())) {
//			throw new AppException("该规格库存不足");
//		}
		
		int num=0;
		num=shopCarDao.updateShopCar(shopCarBean);
		if(num<=0){
			throw new AppException("修改失败");
		}
		return num;
	}
	
	public Object deleteShopCar(ShopCarBean shopCarBean) {
		int num=shopCarDao.deleteShopCar(shopCarBean);
		if(num<=0){
			throw new AppException("删除失败");
		}
		return num;
	}
	
	public Object deleteShopCars(ShopCarBean shopCarBean) {
		int num = shopCarDao.deleteShopCars(shopCarBean);
		
		if(num<=0) {
			throw new AppException("删除失败");
		}
		
		return num;
	}

	@Override
	public Object getMemberShopCarSum(ShopCarBean shopCarBean) {
		// TODO Auto-generated method stub
		int goods_num = NumberUtils.Integer(shopCarDao.getMemberShopCarSum(shopCarBean)+"");
		return goods_num;
	}

	@Override
	public Object balanceShopCars(ShopCarBean shopCarBean) {
		Map<String, Object> map = new HashMap<>();
		//获取结算的购物车id 拆分成多个订单
		String[] car_ids = shopCarBean.getCar_ids().split(",");
		String order_nos = "";//返回的多个订单号
		String order_ids = "";//返回的多个订单id
		double order_prices = 0;
		int final_order_id = 0;
		for(String id : car_ids){
			ShopCarBean shopCarBean2 = shopCarDao.getShopCarDetail(new ShopCarBean().setCar_id(Integer.valueOf(id))
					.setMember_id(shopCarBean.getMember_id()));
			if(shopCarBean2 == null){
				throw new AppException("不存在购物车信息!");
			}
			//删除购物车信息
			int num2 = shopCarDao.deleteShopCar(shopCarBean2);
			if(num2 <= 0){
				throw new AppException("删除购物车信息失败!");
			}
			String order_no = new UUIDUtils(0).nextId(false, 10) + "";
			String order_state = "wait_pay";
			MerchantsBean merchantsBean = merchantsDao.getMerchantsDetail(new MerchantsBean()
					.setMerchants_id(Integer.valueOf(shopCarBean2.getMerchants_id())));
			if(merchantsBean == null){
				throw new AppException("供应商不存在!");
			}
			GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean()
					.setGoods_id(Integer.valueOf(shopCarBean2.getGoods_id())));
			if(goodsBean == null){
				throw new AppException("商品不存在!");
			}
			PercentBean percentBean = shopSettingDao.getPercentDetail(new PercentBean().setPercent_type("goods_order"));// 商品预约比例
			if(percentBean == null){
				throw new AppException("商品预约比例不存在!");
			}
			double goods_percent = NumberUtils.Double(percentBean.getPercent_value()) / 100;
			//商品预约价格
			double goods_order_price = NumberUtils.KeepDecimal(goods_percent * NumberUtils.Double(goodsBean.getGoods_now_price()), 2);
			//商品到店再付价格
			double goods_arrive_price  = NumberUtils.Double(goodsBean.getGoods_now_price()) - goods_order_price;
			//商品实际支付价格
			double goods_actual_price = NumberUtils.KeepDecimal(goods_percent * NumberUtils.Double(goodsBean.getGoods_now_price()), 2);
			int goods_num = NumberUtils.Integer(shopCarBean2.getGoods_num());
			if (goods_num != 1) {
				throw new AppException("限制购买数量为1!");
			}
			
			OrderBean orderBean = new OrderBean()
					.setMember_id(shopCarBean.getMember_id())
					.setGoods_num(shopCarBean2.getGoods_num())
					.setOrder_price(goodsBean.getGoods_now_price())
					.setOrder_actual_price(String.valueOf(goods_actual_price))
					.setGoods_order_price(String.valueOf(goods_order_price))
					.setGoods_arrive_price(String.valueOf(goods_arrive_price))
					.setOrder_mobile(shopCarBean.getMobile())
					.setMerchants_id(shopCarBean2.getMerchants_id())
					.setGoods_id(shopCarBean2.getGoods_id())
					.setMerchants_img(merchantsBean.getMerchants_img())
					.setMerchants_name(merchantsBean.getMerchants_name())
					.setGoods_img(goodsBean.getGoods_img())
					.setGoods_name(goodsBean.getGoods_name())
					.setGoods_price(goodsBean.getGoods_now_price())
					.setOrder_no(order_no)
					.setOrder_state(order_state);
			int num = orderDao.insertOrder(orderBean);
			if(num <= 0){
				throw new AppException("确认订单失败!");
			}
			order_nos = order_nos+order_no+",";
			order_ids = order_ids + String.valueOf(orderBean.getOrder_id()) + ",";
			final_order_id = orderBean.getOrder_id();
			order_prices = order_prices + NumberUtils.Double(orderBean.getOrder_actual_price()) ;
			
		}
		
		
		OrderBean orderBean2 = orderDao.getOrderDetail(new OrderBean().setOrder_id(final_order_id));

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(orderBean2.getPay_end_time().substring(0, 19));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long unixTimestamp = date.getTime();
		long unixTimestamp2 = System.currentTimeMillis();
		long time_num = (unixTimestamp - unixTimestamp2) / 1000;
		map.put("time_num", time_num);
		map.put("order_nos", order_nos);
		map.put("order_ids", order_ids);
		map.put("order_prices", order_prices);
		return map;
	}

	
}
