package tst.project.shop.interfaces;

import java.util.List;

import com.alibaba.dubbo.container.page.Page;

import tst.project.bean.activity.ZMAyOrderBean;
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
import tst.project.bean.shop.SpecificationBean;
import tst.project.page.PageBean;

public interface IGoodsService {
	/**
	 * 获取商品的评价列表
	 * @author lx
	 * @param goodsAssessmentBean
	 * @return
	 */
	public Object getAssessments(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean);
	/**
	 * 添加收藏
	 * @author lx
	 * @param goodsCollectionBean
	 * @return
	 */
	public Object insertGoodsCollection(GoodsCollectionBean goodsCollectionBean);
	/**
	 * 取消收藏
	 * @author lx
	 * @param goodsCollectionBean
	 * @return
	 */
	public Object deleteGoodsCollection(GoodsCollectionBean goodsCollectionBean);
	public Object deleteCollection(GoodsCollectionBean goodsCollectionBean);
	
	
	/**
	 * 用户收藏的商品列表
	 * @author lx
	 * @param goodsCollectionBean
	 * @return
	 */
	public Object getGoodsCollections(GoodsCollectionBean goodsCollectionBean,PageBean pageBean);
	/**
	 * 商品问题列表
	 * @author Administrator
	 * @param goodsIssueBean
	 * @return
	 */
	public Object getGoodsIssues(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 商品问题详情
	 * @author Administrator
	 * @param goodsIssueBean
	 * @return
	 */
	public Object getGoodsIssueDetail(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 分类标签列表(lebec)
	 * @author hwq
	 * @param goodsClassTagBean
	 * @return
	 */
	public Object getGoodsClassTags(GoodsClassTagBean goodsClassTagBean);
	
	
	/**
	 * 添加商品问题
	 * @author hwq
	 * @param goodsIssueBean
	 * @return
	 */
	public Object insertGoodsIssue(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 添加商品回答
	 * @author hwq
	 * @param goodsIssueBean
	 * @return
	 */
	public Object insertGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean);
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 商品热门搜索
	 * @author sjb
	 * @param goodsHotBean
	 * @return
	 */
	public Object getGoodsHots(GoodsHotBean goodsHotBean);
	/**
	 * 根据用户浏览记录 猜他喜欢
	 * @author sjb
	 * @param memberBrowseBean
	 * @return
	 */
	public Object getMemberLoveGoodss(MemberBrowseBean memberBrowseBean,PageBean pageBean);
	/**
	 * 营销商品分类列表
	 * @param goodsMarketingBean
	 * @return
	 */
	public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean);
	
	/**
	 * 营销商品列表
	 * @param goodsMarketingBean
	 * @return
	 */
	public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean,PageBean pageBean);
	/**
	 * 商品的规格详情
	 * 
	 * @param goodsSpecificationBean
	 * @return
	 */
	public GoodsSpecificationBean getGoodsSpecificationDetail(GoodsSpecificationBean goodsSpecificationBean);
	
	public List<SpecificationBean> getGoodsSpecifications(GoodsSpecificationBean goodsSpecificationBean);
	/**
	 * 商品详情
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsDetail(GoodsBean goodsBean,String member_id);
	
	/**
	 * 添加订单时查询商品需要的信息和规格
	 * @author liyong
	 * @param ayOrderBean
	 * @return
	 */
	public ZMAyOrderBean getGoodsDetailAndSpecification(ZMAyOrderBean ayOrderBean);
	
	/**
	 * 商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean);
	
	/**
	 * 商品分类列表
	 * @param goodsClassBean
	 * @param level
	 * @return
	 */
	public Object getGoodsClasss(GoodsClassBean goodsClassBean);
	
	/**
	 * 获取前九个商品分类
	 * @author lx
	 * @param goodsClassBean
	 * @return
	 */
	public Object getGoodsClasssLimit(GoodsClassBean goodsClassBean);


	/**
	 * 获得一元试吃的商品详情
	 * @author liyong
	 * @param goods_id
	 * @return
	 */
	public GoodsBean getActivityGoodsDetail(String goods_id);
	
	
}
