package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.MemberAttentionBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsGoodsClassBean;
import tst.project.page.PageBean;

@Mapper
public interface MerchantsDao {
	/**
	 * 通过分类以及医生或医院id获取对应商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGoodsByMerchantsAndClass(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 获取医院或医生项目分类列表
	 * @param merchantsGoodsClassBean
	 * @return
	 */
	public List<MerchantsGoodsClassBean> getMerchantsGoodsClasses(MerchantsGoodsClassBean merchantsGoodsClassBean);
	/**
	 * 获取用户关注列表
	 * @param memberAttentionBean
	 * @return
	 */
	public List<MemberAttentionBean> getMemberAttentions(MemberAttentionBean memberAttentionBean);
	
	/**
	 * 关注商家或商品
	 * @author Administrator
	 * @param memberAttentionBean
	 * @return
	 */
	public int attentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean);
	
	/**
	 * 取消关注商家或商品
	 * @author Administrator
	 * @param memberAttentionBean
	 * @return
	 */
	public int cancelAttentionMerchantsOrGoods(MemberAttentionBean memberAttentionBean);
	
	/**
	 * 获得用户关注的医院、医生列表
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getMemberAttentionMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 获得商家推荐商品
	 * @author sjb
	 * @return
	 */
	public List<GoodsBean> getMerchantsRecomendGoodss(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 推荐商家列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBean> getRecommendMerchantss(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 商家列表
	 * @author sjb
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBean> getMerchantss(MerchantsBean merchantsBean,PageBean pageBean);
	
	
	/**
	 * 获得商家详情
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean);
}
