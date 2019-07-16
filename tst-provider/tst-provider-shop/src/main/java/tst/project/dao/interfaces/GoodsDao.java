package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.ActivityBean;
import tst.project.bean.shop.ActivityGoodsBean;
import tst.project.bean.shop.GoodsAssessmentBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsClassBean;
import tst.project.bean.shop.GoodsClassMarketingBean;
import tst.project.bean.shop.GoodsClassTagBean;
import tst.project.bean.shop.GoodsCollectionBean;
import tst.project.bean.shop.GoodsHotBean;
import tst.project.bean.shop.GoodsImgBean;
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.MemberBrowseBean;
import tst.project.bean.shop.MemberGoodsRecordBean;
import tst.project.bean.shop.SpecificationBean;
import tst.project.page.PageBean;

@Mapper
public interface GoodsDao {
	
	/**
	 * 获取商品的前三个评论
	 * @param goodsAssessmentBean
	 * @return
	 */
	public List<GoodsAssessmentBean> getAssessmentsLimit(GoodsAssessmentBean goodsAssessmentBean);
	
	/**
	 * 获取商品的全部评论列表
	 * @param goodsAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsAssessmentBean> getAssessments(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean);
	
	/**
	 * 获取商品的二级回复
	 * @param goodsAssessmentBean
	 * @return
	 */
	public List<GoodsAssessmentBean> getGoodsAssessmentsByParent(GoodsAssessmentBean goodsAssessmentBean);
	
	/**
	 * 问题个数
	 * @param goodsIssueBean
	 * @return
	 */
	public int getGoodsIssueCount(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 问题回答个数
	 * @param goodsIssueBean
	 * @return
	 */
	public int getGoodsIssueAnswerCount(GoodsIssueAnswerBean goodsIssueAnswerBean);
	
	/**
	 * 商品问题列表
	 * @author Administrator
	 * @param goodsIssueBean
	 * @return
	 */
	public List<GoodsIssueBean> getGoodsIssues(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 最新的问题(一个)
	 * @author hwq
	 * @param goodsIssueBean
	 * @return
	 */
	public GoodsIssueBean getOneGoodsIssue(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 商品回答列表
	 * @author Administrator
	 * @param goodsIssueBean
	 * @return
	 */
	public List<GoodsIssueAnswerBean> getGoodsIssueAnswers(GoodsIssueAnswerBean goodsIssueAnswerBean);
	
	/**
	 * 最新的回答(一个)
	 * @author hwq
	 * @param goodsIssueBean
	 * @return
	 */
	public GoodsIssueAnswerBean getOneGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean);
	
	/**
	 * 用户是否使用过该商品
	 * @param memberGoodsRecordBean
	 * @return
	 */
	public MemberGoodsRecordBean getMemberGoods(MemberGoodsRecordBean memberGoodsRecordBean);
	
	/**
	 * 分类标签列表(lebec)
	 * @author hwq
	 * @param goodsClassTagBean
	 * @return
	 */
	public List<GoodsClassTagBean> getGoodsClassTags(GoodsClassTagBean goodsClassTagBean);
	
	
	/**
	 * 添加商品问题
	 * @author hwq
	 * @param goodsIssueBean
	 * @return
	 */
	public int insertGoodsIssue(GoodsIssueBean goodsIssueBean);
	/**
	 * 添加收藏
	 * @param goodsCollectionBean
	 * @return
	 */
	public int insertGoodsCollection(GoodsCollectionBean goodsCollectionBean);
	/**
	 * 取消收藏
	 * @param goodsCollectionBean
	 * @return
	 */
	public int deleteGoodsCollection(GoodsCollectionBean goodsCollectionBean);
	
	public int deleteCollection(GoodsCollectionBean goodsCollectionBean);
	
	
	/**
	 * 获取用户收藏的商品列表
	 * @param goodsCollectionBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGoodsCollections(GoodsCollectionBean goodsCollectionBean,PageBean pageBean);
	
	/**
	 * 问题详情
	 * @param goodsIssueBean
	 * @return
	 */
	public GoodsIssueBean getGoodsIssueDetail(GoodsIssueBean goodsIssueBean);
	
	/**
	 * 添加商品回答
	 * @author hwq
	 * @param goodsIssueBean
	 * @return
	 */
	public int insertGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean);
	
	
	
	
	
	
	
	
	
	
	/**
	 * 商品热门搜索
	 * @author sjb
	 * @param goodsHotBean
	 * @return
	 */
	public List<GoodsHotBean> getGoodsHots(GoodsHotBean goodsHotBean);
	
	/**
	 * 根据用户浏览记录 猜他喜欢
	 * @author sjb
	 * @param memberBrowseBean
	 * @return
	 */
	public List<GoodsBean> getMemberLoveGoodss(MemberBrowseBean memberBrowseBean,PageBean pageBean);
	
	
	/**
	 * 用户浏览商品分类第一次入库
	 * @param memberBrowseBean
	 * @return
	 */
	public int insertMemberBrowse(MemberBrowseBean memberBrowseBean);
	/**
	 * 更新用户浏览商品分类次数
	 * @param memberBrowseBean
	 * @return
	 */
	public int updateMemberBrowse(MemberBrowseBean memberBrowseBean);	
	/**
	 * 营销商品分类列表
	 * @param goodsMarketingBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean);
	/**
	 * 营销商品列表
	 * @param goodsMarketingBean
	 * @return
	 */
	public List<GoodsBean> getGoodsMarketings(GoodsMarketingBean goodsMarketingBean,PageBean pageBean);
	/**
	 * 修改商品库存
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsStock(GoodsBean goodsBean);
	
	/**
	 * 修改商品信息
	 * @param goodsBean
	 * @return
	 */
	public int updateGoods(GoodsBean goodsBean);
	
	/**
	 * 修改商品规格库存
	 * @param goodsSpecificationBean
	 * @return
	 */
	public int updateGoodsSpecificationStock(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 获得商品图片列表
	 * 
	 * @param goodsImgBean
	 * @return
	 */
	public List<GoodsImgBean> getGoodsImgs(GoodsImgBean goodsImgBean);

	/**
	 * 通过商品id获取商品规格信息
	 * 
	 * @param goodsSpecificationBean
	 * @return
	 */
	public List<SpecificationBean> getGoodsSpecificationsParent(GoodsSpecificationBean goodsSpecificationBean);

	public List<SpecificationBean> getGoodsSpecificationsChild(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 商品的规格详情
	 * 
	 * @param goodsSpecificationBean
	 * @return
	 */
	public GoodsSpecificationBean getGoodsSpecificationDetail(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 商品参加的活动列表
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getGoodsActivitys(ActivityGoodsBean activityGoodsBean);
	
	/**
	 * 商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getGoodsDetail(GoodsBean goodsBean);


	/**
	 * 商品列表
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGoodss(GoodsBean goodsBean, PageBean pageBean);

	/**
	 * 商品分类列表
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasss(GoodsClassBean goodsClassBean);
	/**
	 * 获取前九个分类
	 * @param goodsClassBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasssLimit(GoodsClassBean goodsClassBean);
	

	/**
	 * 商品分类列表
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasss2(GoodsClassBean goodsClassBean);

	/**
	 * 商品分类列表
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasss3(GoodsClassBean goodsClassBean);

	/**
	 * 添加商品评价
	 * @param goodsAssessmentBean
	 * @return
	 */
	public int insertGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean);

	/**
	 * gxq
	 * 更新商品销量
	 * @param setGoods_id
	 * @return
	 */
	public int updateGoodsSales(GoodsBean setGoods_id);

	/**
	 * 获得一元试吃商品详情
	 * @param goods_id
	 * @return
	 */
	public GoodsBean getActivityGoodsDetail(String goods_id);
	
}
