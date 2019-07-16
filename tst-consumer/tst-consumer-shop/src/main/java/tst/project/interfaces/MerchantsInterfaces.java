package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.MemberAttentionBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsGoodsClassBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IMerchantsService;

@Controller
@RequestMapping("/merchantsInterfaces/v1.0")
public class MerchantsInterfaces {
	@Autowired
	IMerchantsService merchantsService;
	

	
	
	@RequestMapping("/cancelAttentionMerchantsOrGoods")
	@AppController(isVerToken=true)
	public Object cancelAttentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean) throws Exception{
		return merchantsService.cancelAttentionMerchantsOrGoods(memberAttentionBean);
	}
	
	@RequestMapping("/attentionMerchantsOrGoods")
	@AppController(isVerToken=true)
	public Object attentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean) throws Exception{
		return merchantsService.attentionMerchantsOrGoods(memberAttentionBean);
	}
	
	@RequestMapping("/getMemberAttentionMerchants")
	@AppController(isVerToken=true)
	public Object getMemberAttentionMerchants(MemberAttentionBean memberAttentionBean) throws Exception {
		return merchantsService.getMemberAttentionMerchants(memberAttentionBean);
	}
	
	@RequestMapping("/getMerchantsRecomendGoodss")
	@AppController(isPage=true)
	public Object getMerchantsRecomendGoodss(GoodsBean goodsBean,PageBean pageBean) throws Exception {
		return merchantsService.getMerchantsRecomendGoodss(goodsBean,pageBean);
	}
	/*
	 * 商家列表
	 */
	@RequestMapping("/getMerchantss")
	@AppController(isPage=true)
	public Object getMerchantss(MerchantsBean merchantsBean,PageBean pageBean) throws Exception {
		return merchantsService.getMerchantss(merchantsBean,pageBean);
	}

	/**
	 * 获得商家详情
	 * @param merchantsBean
	 * @return
	 */
	@RequestMapping("/getMerchantsDetail")
	@AppController
	public Object getMerchantsDetail(MerchantsBean merchantsBean) throws Exception {
		return merchantsService.getMerchantsDetail(merchantsBean);
	}
	@RequestMapping("/getMerchantsGoodsClasses")
	@AppController
	public Object getMerchantsGoodsClass(MerchantsGoodsClassBean merchantsGoodsClassBean) throws Exception {
		return merchantsService.getMerchantsGoodsClasses(merchantsGoodsClassBean);
	}
	@RequestMapping("/getGoodsByMerchantsAndClass")
	@AppController(isPage=true)
	public Object getGoodsByMerchantsAndClass(GoodsBean goodsBean,PageBean pageBean) throws Exception {
		return merchantsService.getGoodsByMerchantsAndClass(goodsBean, pageBean);
	}
	
	@RequestMapping("/getMerchantsWithGoods")
	@AppController(isPage=true)
	public Object getMerchantsWithGoods(MerchantsBean merchantsBean,PageBean pageBean) throws Exception {
		return merchantsService.getMerchantsWithGoods(merchantsBean,pageBean);
	}
	
	
}
