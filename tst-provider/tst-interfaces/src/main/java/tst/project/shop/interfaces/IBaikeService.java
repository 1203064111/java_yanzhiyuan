package tst.project.shop.interfaces;

import tst.project.bean.shop.BaikeClassBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.MemberSearchBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.SearchHotBean;
import tst.project.page.PageBean;

public interface IBaikeService {
	
	/**
	 * 删除记录
	 * @author lx
	 * @param memberSearchBean
	 * @return
	 */
	public Object deleteMemberSearchs(MemberSearchBean memberSearchBean);
	/**
	 * 获取用户搜索记录
	 * @author lx
	 * @param memberSearchBean
	 * @return
	 */
	public Object getMemberSearchs(MemberSearchBean memberSearchBean);
	
	/**
	 * 获取热门搜索记录
	 * @author lx
	 * @param searchHotBean
	 * @return
	 */
	public Object getSearchHots(SearchHotBean searchHotBean);
	
	/**
	 * 搜索项目
	 * @author lx
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsBySearch(GoodsBean goodsBean,PageBean pageBean);
	/**
	 * 搜索医院/医生
	 * @author lx
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public Object getMerchantsBySearch(MerchantsBean merchantsBean,PageBean pageBean);

	
	/**
	 * 获取百科一级分类列表
	 * @author lx
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getBaikeClasses(BaikeClassBean baikeClassBean,PageBean pageBean);
	/**
	 * 获取百科二级分类列表
	 * @author lx
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getBaikeClassesByParentId(BaikeClassBean baikeClassBean,PageBean pageBean);
	/**
	 * 获取百科分类详情
	 * @author lx
	 * @param baikeClassBean
	 * @return
	 */
	public Object getBaikeClassDetail(BaikeClassBean baikeClassBean);
	
	
	
}
