package tst.project.interfaces;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.shop.BaikeClassBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsClassBean;
import tst.project.bean.shop.GoodsClassMarketingBean;
import tst.project.bean.shop.GoodsClassTagBean;
import tst.project.bean.shop.GoodsHotBean;
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.MemberBrowseBean;
import tst.project.bean.shop.MemberSearchBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.SearchHotBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IBaikeService;
import tst.project.shop.interfaces.IGoodsService;

@Controller
@RequestMapping("/baikeInterfaces/v1.0")
public class BaikeInterfaces {
	
	@Autowired
	IBaikeService baikeService;
	/**
	 * 百科分类
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBaikeClasses")
	@AppController(isPage=true)
	public Object getBaikeClasses(BaikeClassBean baikeClassBean, PageBean pageBean) throws Exception {
		return baikeService.getBaikeClasses(baikeClassBean, pageBean);
	}
	/**
	 * 百科的下级分类列表
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBaikeClassesByParentId")
	@AppController(isPage=true)
	public Object getBaikeClassesByParentId(BaikeClassBean baikeClassBean, PageBean pageBean) throws Exception {
		return baikeService.getBaikeClassesByParentId(baikeClassBean, pageBean);
	}
	/**
	 * 百科详情
	 * @param baikeClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBaikeClassDetail")
	@AppController
	public Object getBaikeClassDetail(BaikeClassBean baikeClassBean) throws Exception {
		return baikeService.getBaikeClassDetail(baikeClassBean);
	}
	/**
	 * 搜索热门列表
	 * @param searchHotBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSearchHots")
	@AppController
	public Object getSearchHots(SearchHotBean searchHotBean) throws Exception {
		return baikeService.getSearchHots(searchHotBean);
	}
	/**
	 * 用户搜索列表
	 * @param memberSearchBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberSearchs")
	@AppController()
	public Object getMemberSearchs(MemberSearchBean memberSearchBean) throws Exception {
		return baikeService.getMemberSearchs(memberSearchBean);
	}
	/**
	 * 删除用户搜索
	 * @param memberSearchBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteMemberSearchs")
	@AppController(isVerToken=true)
	public Object deleteMemberSearchs(MemberSearchBean memberSearchBean) throws Exception {
		return baikeService.deleteMemberSearchs(memberSearchBean);
	}
	/**
	 * 搜索商品
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsBySearch")
	@AppController
	public Object getGoodsBySearch(GoodsBean goodsBean,PageBean pageBean) throws Exception {
		return baikeService.getGoodsBySearch(goodsBean,pageBean);
	}
	/**
	 * 搜索商家
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMerchantsBySearch")
	@AppController
	public Object getMerchantsBySearch(MerchantsBean merchantsBean,PageBean pageBean) throws Exception {
		return baikeService.getMerchantsBySearch(merchantsBean,pageBean);
	}
	
	
	
}

