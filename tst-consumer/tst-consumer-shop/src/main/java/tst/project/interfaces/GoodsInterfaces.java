package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.hp.hpl.sparta.xpath.TrueExpr;

import tst.project.aspect.AppController;
import tst.project.bean.shop.GoodsAssessmentBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsClassBean;
import tst.project.bean.shop.GoodsClassMarketingBean;
import tst.project.bean.shop.GoodsClassTagBean;
import tst.project.bean.shop.GoodsCollectionBean;
import tst.project.bean.shop.GoodsHotBean;
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.MemberBrowseBean;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IGoodsService;

@Controller
@RequestMapping("/goodsInterfaces/v1.0")
public class GoodsInterfaces {
	
	@Autowired
	IGoodsService goodsService;
	
	
	
	/**
	 * 商品问题详情
	 * @param goodsIssueBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsIssueDetail")
	@AppController
	public Object getGoodsIssueDetail(GoodsIssueBean goodsIssueBean) throws Exception{
		return goodsService.getGoodsIssueDetail(goodsIssueBean);
	}
	/**
	 * 商品问题列表
	 * @param goodsIssueBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsIssues")
	@AppController
	public Object getGoodsIssues(GoodsIssueBean goodsIssueBean) throws Exception{
		return goodsService.getGoodsIssues(goodsIssueBean);
	}
	/**
	 * 添加商品问题
	 * @param goodsIssueBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsIssue")
	@AppController(isVerToken=true)
	public Object insertGoodsIssue(GoodsIssueBean goodsIssueBean) throws Exception{
		return goodsService.insertGoodsIssue(goodsIssueBean);
	}
	/**
	 * 回答问题
	 * @param goodsIssueAnswerBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsIssueAnswer")
	@AppController(isVerToken=true)
	public Object insertGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean) throws Exception{
		return goodsService.insertGoodsIssueAnswer(goodsIssueAnswerBean);
	}
	
	@RequestMapping("/getGoodsClassTags")
	@AppController
	public Object getGoodsClassTags(GoodsClassTagBean goodsClassTagBean) throws Exception {
		return goodsService.getGoodsClassTags(goodsClassTagBean);
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/getGoodsHots")
	@AppController
	public Object getGoodsHots(GoodsHotBean goodsHotBean) throws Exception {
		return goodsService.getGoodsHots(goodsHotBean);
	}
	
	
	@RequestMapping("/getMemberLoveGoodss")
	@AppController(isPage=true)
	public Object getMemberLoveGoodss(MemberBrowseBean memberBrowseBean,PageBean pageBean) throws Exception {
		return goodsService.getMemberLoveGoodss(memberBrowseBean,pageBean);
	}
	
	@RequestMapping("/getGoodsClassMarketings")
	@AppController(isPage=true)
	public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) throws Exception {
		return goodsService.getGoodsClassMarketings(goodsClassMarketingBean,pageBean);
	}
	
	
	@RequestMapping("/getGoodsMarketings")
	@AppController(isPage=true)
	public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean,PageBean pageBean) throws Exception {
		return goodsService.getGoodsMarketings(goodsMarketingBean,pageBean);
	}
	
	
	@RequestMapping("/getGoodsSpecificationDetail")
	@AppController
	public Object getGoodsSpecificationDetail(GoodsSpecificationBean goodsSpecificationBean) throws Exception {
		return goodsService.getGoodsSpecificationDetail(goodsSpecificationBean);
	}
	/**
	 * 商品详情
	 * @param goodsBean
	 * @param member_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsDetail")
	@AppController
	public Object getGoodsDetail(GoodsBean goodsBean,String member_id) throws Exception {
		return goodsService.getGoodsDetail(goodsBean,member_id);
	}
	
	@RequestMapping("/getAssessments")
	@AppController(isPage=true)
	public Object getAssessments(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean) throws Exception {
		return goodsService.getAssessments(goodsAssessmentBean,pageBean);
	}
	
	@RequestMapping("/getGoodss")
	@AppController(isPage=true)
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean) throws Exception {
		return goodsService.getGoodss(goodsBean, pageBean);
	}
	
	
	@RequestMapping("/getGoodsClasss")
	@AppController
	public Object getGoodsClasss(GoodsClassBean goodsClassBean) throws Exception {
		return goodsService.getGoodsClasss(goodsClassBean);
	}
	@RequestMapping("/getGoodsClasssLimit")
	@AppController
	public Object getGoodsClasssLimit(GoodsClassBean goodsClassBean) throws Exception {
		return goodsService.getGoodsClasssLimit(goodsClassBean);
	}
	/**
	 * 添加收藏
	 * @param goodsCollectionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsCollection")
	@AppController(isVerToken=true)
	public Object insertGoodsCollection(GoodsCollectionBean goodsCollectionBean) throws Exception{
		return goodsService.insertGoodsCollection(goodsCollectionBean);
	}
	/**
	 * 删除收藏
	 * @param goodsCollectionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsCollection")
	@AppController(isVerToken=true)
	public Object deleteGoodsCollection(GoodsCollectionBean goodsCollectionBean) throws Exception{
		return goodsService.deleteGoodsCollection(goodsCollectionBean);
	}
	/**
	 *删除收藏
	 */
	@RequestMapping("/deleteCollection")
	@AppController(isVerToken=true)
	public Object deleteCollection(GoodsCollectionBean goodsCollectionBean) throws Exception{
		return goodsService.deleteCollection(goodsCollectionBean);
	}
	/**
	 * 收藏列表
	 * @param goodsCollectionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsCollections")
	@AppController(isVerToken=true,isPage=true)
	public Object getGoodsCollections(GoodsCollectionBean goodsCollectionBean,PageBean pageBean) throws Exception {
		return goodsService.getGoodsCollections(goodsCollectionBean,pageBean);
	}
	
}
