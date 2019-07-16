package tst.project.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.MemberAttentionBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsGoodsClassBean;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.interfaces.GoodsDao;
import tst.project.dao.interfaces.MerchantsDao;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IMerchantsService;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class MerchantsService implements IMerchantsService{
	@Autowired
	MerchantsDao merchantsDao;
	
	@Autowired
	GoodsDao goodsDao;

	@Autowired
	GoodsDaoC goodsDaoC;
	
	@Autowired
	IMemberService memberService;
	
	
	@Override
	public Object getMerchantsRecomendGoodss(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans=merchantsDao.getMerchantsRecomendGoodss(goodsBean, pageBean);
		
		return pageBean.setObject(goodsBeans);
	}
	
	@Override
	public MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		MerchantsBean merchantsBean2= merchantsDao.getMerchantsDetail(merchantsBean);
		if(merchantsBean2 != null){
			List<GoodsMarketingBean> goodsMarketingBeans = goodsDaoC.getGoodsMarketings(new GoodsMarketingBean()
					.setMerchants_id(merchantsBean2.getMerchants_id()+"").setMarketing_type("2"));
			merchantsBean2.setGoodsMarketingBeans(goodsMarketingBeans);
		}
		return merchantsBean2;
	}
	
	@Override
	public Object getMerchantsWithGoods(MerchantsBean merchantsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MerchantsBean> merchantsBeans=merchantsDao.getRecommendMerchantss(merchantsBean, pageBean);
		if(merchantsBeans!=null){
			for (int i = 0; i < merchantsBeans.size(); i++) {
				MerchantsBean merchantsBean2=merchantsBeans.get(i);
				List<GoodsBean> goodsBeans=merchantsDao.getMerchantsRecomendGoodss(new GoodsBean()
						.setMerchants_id(merchantsBean2.getMerchants_id()+""), new PageBean().setPageSize(3));
				merchantsBean2.setGoodsBeans(goodsBeans);
			}
		}
		return pageBean.setObject(merchantsBeans);
	}

	@Override
	public Object getMemberAttentionMerchants(MemberAttentionBean memberAttentionBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();
		List<MerchantsBean> merchantsBeans = new ArrayList<MerchantsBean>();
		if("3".equals(memberAttentionBean.getAttention_type())) {
			List<MemberAttentionBean> memberAttentionBeans = merchantsDao.getMemberAttentions(memberAttentionBean);
			for (int i = 0; i < memberAttentionBeans.size(); i++) {
				MemberAttentionBean memberAttentionBean2 = memberAttentionBeans.get(i);
				GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean().setGoods_id(
						NumberUtils.Integer(memberAttentionBean2.getAttention_id())));
				if(goodsBean != null) {
					goodsBeans.add(goodsBean);
				}
			}
			return goodsBeans;
		}else {
			List<MemberAttentionBean> memberAttentionBeans = merchantsDao.getMemberAttentions(memberAttentionBean);
			for (int i = 0; i < memberAttentionBeans.size(); i++) {
				MemberAttentionBean memberAttentionBean2 = memberAttentionBeans.get(i);
				MerchantsBean merchantsBean = merchantsDao.getMerchantsDetail(new MerchantsBean()
						.setMerchants_id(NumberUtils.Integer(memberAttentionBean2.getAttention_id()))
						.setMerchants_type(memberAttentionBean2.getAttention_type()));
				if(merchantsBean != null) {
					merchantsBeans.add(merchantsBean);
				}
				
			}
			return merchantsBeans;
		}
		
	}

	@Override
	public Object getMerchantss(MerchantsBean merchantsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MerchantsBean> merchantsBeans = merchantsDao.getMerchantss(merchantsBean, pageBean);
		for (int i = 0; i < merchantsBeans.size(); i++) {
			MerchantsBean merchantsBean2 = merchantsBeans.get(i);
			List<GoodsMarketingBean> goodsMarketingBeans = goodsDaoC.getGoodsMarketings(new GoodsMarketingBean()
					.setMerchants_id(merchantsBean2.getMerchants_id()+"").setMarketing_type("2"),new PageBean().setPageSize(2));
			merchantsBean2.setGoodsMarketingBeans(goodsMarketingBeans);
		}
		return pageBean.setObject(merchantsBeans);
	}

	@Override
	public Object attentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean) {
		// TODO Auto-generated method stub
		int num = merchantsDao.attentionMerchantsOrGoods(memberAttentionBean);
		if(num <= 0) {
			throw new AppException("关注失败");
		}
		
		return num;
	}

	@Override
	public Object cancelAttentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean) {
		// TODO Auto-generated method stub
		int num = merchantsDao.cancelAttentionMerchantsOrGoods(memberAttentionBean);
		if(num <= 0) {
			throw new AppException("取消关注失败");
		}
		
		return num;
	}
	@Override
	public Object getMerchantsGoodsClasses(MerchantsGoodsClassBean merchantsGoodsClassBean){
		return merchantsDao.getMerchantsGoodsClasses(merchantsGoodsClassBean);
	}

	@Override
	public Object getGoodsByMerchantsAndClass(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(merchantsDao.getGoodsByMerchantsAndClass(goodsBean, pageBean));
	}
	
	
}
