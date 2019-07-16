package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.bean.shop.ShopCouponSignBean;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.dao.interfaces.ShopCouponDao;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IShopCouponService;

@Service
@Transactional
public class ShopCouponService implements IShopCouponService {
	@Autowired
	ShopCouponDao shopCouponDao;

	@Autowired
	OrderService orderService;
	
	@Autowired
	IMemberService memberService;
	@Override
	public Object timeingCouponExpire(ShopCouponBean shopCouponBean) {
		// TODO Auto-generated method stub
		int num=shopCouponDao.timeingCouponExpire(shopCouponBean);
		if(num<=0){
			throw new AppException("无过期优惠券");
		}
		return num;
	}
	
	
	@Override
	public Object getWeekSignCoupons(ShopCouponSignBean shopCouponSignBean) {
		// TODO Auto-generated method stub
		return shopCouponDao.getWeekSignCoupons(shopCouponSignBean);
	}
	
	@Override
	public Object getShopCoupons(ShopMemberCouponBean shopMemberCouponBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ShopCouponBean> shopCouponBeans = shopCouponDao.getShopCoupons(shopMemberCouponBean, pageBean);
		return pageBean.setObject(shopCouponBeans);
	}

	public ShopMemberCouponBean getShopMemberCouponDetail(ShopMemberCouponBean shopMemberCouponBean) {
		// TODO Auto-generated method stub
		return shopCouponDao.getShopMemberCouponDetail(shopMemberCouponBean);
	}

	public Object insertMemberCoupon(MemberBean memberBean, ShopCouponBean shopCouponBean) {

		ShopCouponBean shopCouponBean2 = shopCouponDao
				.getShopCouponDetail(new ShopCouponBean().setCoupon_id(shopCouponBean.getCoupon_id()));
		if (shopCouponBean2 == null) {
			throw new AppException("优惠券不存在!");
		}
		int remain_num = Integer.valueOf(shopCouponBean2.getRemain_num());
		if(remain_num<=0){
			throw new AppException("你来晚了，该优惠券已领取完");
		}
		int limit= Integer.valueOf(shopCouponBean2.getPeople_limit());


		List<ShopMemberCouponBean> shopMemberCouponBeanLists = shopCouponDao
				.verMemberCouponList(new ShopMemberCouponBean()
						.setMember_id(memberBean.getMember_id()+"")
						.setCoupon_id(shopCouponBean.getCoupon_id()+""));
		if(shopMemberCouponBeanLists.size()>=limit){
			throw new AppException("已超过该优惠券的领取上限");
		}
		
		int num = 0;
		ShopMemberCouponBean shopMemberCouponBean2 = new ShopMemberCouponBean()
				
				.setCoupon_id(shopCouponBean2.getCoupon_id() + "").setCoupon_end_time(shopCouponBean2.getEnd_time())
				.setCoupon_start_time(shopCouponBean2.getStart_time())
				.setCoupon_full_price(shopCouponBean2.getCoupon_full_price())
				.setPercent(shopCouponBean2.getPercent())
				.setCoupon_name(shopCouponBean2.getCoupon_name()).setCoupon_price(shopCouponBean2.getCoupon_price())
				.setCoupon_way(shopCouponBean2.getCoupon_way()).setMember_id(memberBean.getMember_id() + "");

		num = shopCouponDao.insertMemberCoupon(shopMemberCouponBean2);
		if (num <= 0) {
			throw new AppException("优惠券领取失败");
		}
		remain_num = remain_num-1;
		num = shopCouponDao
				.updateShopCouponRemainNum(new ShopCouponBean().setCoupon_id(shopCouponBean2.getCoupon_id())
						.setRemain_num(remain_num+""));
		if (num <= 0) {
			throw new AppException("优惠券领取失败");
		}
		
		
		return num;
	}

	public Object getShopCouponDetail(ShopCouponBean shopCouponBean) {
		// TODO Auto-generated method stub
		return shopCouponDao.getShopCouponDetail(shopCouponBean);
	}

	public Object getShopMemberCoupons(ShopMemberCouponBean shopMemberCouponBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ShopMemberCouponBean> shopMemberCouponBeans = shopCouponDao.getShopMemberCoupons(shopMemberCouponBean, pageBean);
		
		return pageBean.setObject(shopMemberCouponBeans);
	}


}
