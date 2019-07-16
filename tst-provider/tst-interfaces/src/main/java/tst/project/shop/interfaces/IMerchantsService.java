package tst.project.shop.interfaces;


import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.MemberAttentionBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsGoodsClassBean;
import tst.project.page.PageBean;

public interface IMerchantsService {
	/**
	 * 通过分类以及医生或医院id获取对应商品列表
	 * @author lx
	 * @param merchantsGoodsClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsByMerchantsAndClass(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 获取医院或医生的项目分类列表
	 * @author lx
	 * @param merchantsGoodsClassBean
	 * @return
	 */
	public Object getMerchantsGoodsClasses(MerchantsGoodsClassBean merchantsGoodsClassBean);
	
	/**
	 * 取消关注商家或商品
	 * @author Administrator
	 * @param memberAttentionBean
	 * @return
	 */
	public Object cancelAttentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean);
	
	/**
	 * 关注商家或商品
	 * @author Administrator
	 * @param memberAttentionBean
	 * @return
	 */
	public Object attentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean);
	
	/**
	 * 医院、医生列表
	 * @author hwq
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public Object getMerchantss(MerchantsBean merchantsBean, PageBean pageBean);
	
	/**
	 * 获得用户关注的商家、商品
	 * @author hwq
	 * @param merchantsBean
	 * @return
	 */
	public Object getMemberAttentionMerchants(MemberAttentionBean memberAttentionBean);
	
	/**
	 * 获得商家推荐商品
	 * @author sjb
	 * @return
	 */
	public Object getMerchantsRecomendGoodss(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 商家列表(带商品)
	 * @author sjb
	 * @param membeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMerchantsWithGoods(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 获得商家详情
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean);
}
