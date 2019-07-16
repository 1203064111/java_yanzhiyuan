package tst.project.zhangmu.interfaces;

import java.util.List;

import com.alibaba.fastjson.JSON;

import tst.project.bean.activity.ZMActivityBean;
import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.activity.ZMActivitySunburnBean;
import tst.project.bean.activity.ZMAyOrderBean;
import tst.project.bean.sheep.BannerBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.bean.shop.OrderRechargeBean;
import tst.project.page.PageBean;

public interface IActivityOrderServices {

	/**
	 * 得到活动商品
	 * @param activityGoodsBean
	 * @return
	 */
	Object getActivityGoods(ZMActivityGoodsBean activityGoodsBean, PageBean pageBean);
	
	/**
	 * 添加活动商品订单
	 * @param ayOrderBean
	 * @return
	 */
	Object insertActivityOrder(ZMAyOrderBean ayOrderBean, String city_names);
	
	/**
	 * 用户晒单
	 * @param activitySunburnBean
	 * @return
	 */
	Object insertActivitySunburn(ZMActivitySunburnBean activitySunburnBean);

	/**
	 * 查看评价
	 * @param activitySunburnBean
	 * @param pageBean
	 * @return
	 */
	Object getActivitySunburn(ZMActivitySunburnBean activitySunburnBean, PageBean pageBean);

	/**
	 * 查看自己的评价
	 * @param activitySunburnBean
	 * @param pageBean
	 * @return
	 */
	Object getMemberActivitySunburn(ZMActivitySunburnBean activitySunburnBean, PageBean pageBean);

	/**
	 * 商品订单真实支付
	 * @param orderBean
	 * @return
	 */
	Object payGoodsRealOrder(ZMAyOrderBean ayOrderBean);
	
	/**
	 * 邮费订单真实支付
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	Object payFreightRealOrder(ZMAyOrderBean ayOrderBean);

	/**
	 * 商品支付订单回调
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	public Object payGoodsCallback(ZMAyOrderBean ayOrderBean);
	
	/**
	 * 邮费支付订单回调
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	public Object payFreightCallback(ZMAyOrderBean ayOrderBean);
	
	/**
	 * 余额支付商品订单
	 * @author liyong
	 * @param ayOrderBean
	 * @param pay_password
	 * @return
	 */
	Object payGoodsBalanceRealOrder(ZMAyOrderBean ayOrderBean, String pay_password);
	
	/**
	 * 余额支付邮费订单
	 * @author liyong
	 * @param ayOrderBean
	 * @param pay_password
	 * @return
	 */
	Object payFrightBalanceRealOrder(ZMAyOrderBean ayOrderBean, String pay_password);

	/**
	 * 取消订单(未支付前)
	 * @param orderBean
	 * @return
	 */
	Object cancelOrder(ZMAyOrderBean ayOrderBean);

	/**
	 * 确认收货
	 * @param orderMerchantsBean
	 * @return
	 */
	Object receiveOrder(ZMAyOrderBean ayOrderBean);
	
	/**
	 * 轮播图列表
	 * @param shopBannerBean
	 * @return
	 */
	public Object getBanners(BannerBean bannerBean);

	/**
	 * 查询活动订单
	 * @author liyong
	 * @param ayOrderBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityOrder(ZMAyOrderBean ayOrderBean, PageBean pageBean);

	/**
	 * 查看订单详情
	 * @author liyong
	 * @param ayOrderBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityOrderDetail(ZMAyOrderBean ayOrderBean);

	/**
	 * 获取未读订单数量
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	Object getActivityOrderRedState(ZMAyOrderBean ayOrderBean);

	/**
	 * 获得此活动所有订单
	 * @author liyong
	 * @param ayOrderBean
	 * @param pageBean
	 * @return
	 */
	Object getAllActivityOrder(ZMAyOrderBean ayOrderBean, PageBean pageBean);

	/**
	 * 微信公众号商品支付
	 * @author liyong
	 * @param orderBean
	 * @return
	 */
	Object wxPubGoodsPay(ZMAyOrderBean ayOrderBean);

	/**
	 * 微信公众号邮费支付
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	Object wxPubFreightPay(ZMAyOrderBean ayOrderBean);

	/**
	 * 获取商品详情
	 * @author liyong
	 * @param activityGoodsBean
	 * @return
	 */
	Object getGoodsDetail(String goods_id);

	/**
	 * 获得活动详情
	 * @author liyong
	 * @param ayOrderBean
	 * @param pageBean
	 * @return
	 */
	Object getActivityDetail(ZMActivityBean activityBean);

	/**
	 * 假回调
	 * @author liyong
	 * @param out_trade_no
	 * @return
	 */
	Object wxGoodsCallback1(ZMAyOrderBean ayOrderBean);

	/**
	 * 取消订单
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	Object cancelActivityOrder(ZMAyOrderBean ayOrderBean);

	/**
	 * 获得活动id
	 * @author liyong
	 * @return
	 */
	Object getActivityID();

	

}
