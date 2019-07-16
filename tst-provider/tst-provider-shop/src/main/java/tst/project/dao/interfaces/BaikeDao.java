package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.BaikeClassBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.MemberSearchBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.SearchHotBean;
import tst.project.page.PageBean;

@Mapper
public interface BaikeDao {
	/**
	 * 
	 * 删除记录
	 * @param memberSearchBean
	 * @return
	 */
	public int deleteMemberSearchs(MemberSearchBean memberSearchBean);
	/**
	 * 通过用户id和关键词获取搜索记录
	 * @param memberSearchBean
	 * @return
	 */
	public List<MemberSearchBean> getMemberSearchByMemberAndKey(MemberSearchBean memberSearchBean);
	/**
	 * 获取搜索的医院或者医生结果列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBean> getMerchantsBySearch(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 获取搜索的商品结果列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGoodsBySearch(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 添加用户搜索记录
	 * @param memberSearchBean
	 * @return
	 */
	public int insertMemberSearch(MemberSearchBean memberSearchBean);
	
	/**
	 * 获取热门搜索
	 * @param searchHotBean
	 * @return
	 */
	public List<SearchHotBean> getSearchHots(SearchHotBean searchHotBean);
	
	/**
	 * 获取用户搜索记录
	 * @param memberSearchBean
	 * @return
	 */
	public List<MemberSearchBean> getMemberSearchs(MemberSearchBean memberSearchBean);
	/**
	 * 获取百科一级分类列表
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 */
	public List<BaikeClassBean> getBaikeClasses(BaikeClassBean baikeClassBean,PageBean pageBean);
	
	/**
	 * 获取百科二级分类列表
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 */
	public List<BaikeClassBean> getBaikeClassesByParentId(BaikeClassBean baikeClassBean,PageBean pageBean);
	
	/**
	 * 获取百科分类详情
	 * @param baikeClassBean
	 * @return
	 */
	public BaikeClassBean getBaikeClassDetail(BaikeClassBean baikeClassBean);

}
