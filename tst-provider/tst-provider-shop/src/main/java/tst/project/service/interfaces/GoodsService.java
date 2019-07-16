package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.activity.ZMAyOrderBean;
import tst.project.bean.setting.PercentBean;
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
import tst.project.bean.shop.MemberGoodsRecordBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.SpecificationBean;
import tst.project.dao.interfaces.GoodsDao;
import tst.project.dao.interfaces.MerchantsDao;
import tst.project.dao.interfaces.ShopSettingDao;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IGoodsService;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsService implements IGoodsService {
	@Autowired
	GoodsDao goodsDao;

	@Autowired
	MerchantsDao merchantsDao;
	
	@Autowired
	ShopSettingDao shopSettingDao;
	
	@Override
	public Object getGoodsHots(GoodsHotBean goodsHotBean) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsHots(goodsHotBean);
	}
	
	public Object getMemberLoveGoodss(MemberBrowseBean memberBrowseBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans=goodsDao.getMemberLoveGoodss(memberBrowseBean,pageBean);
		return pageBean.setObject(goodsBeans);
	}
	
	public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsClassBean> goodsClassBeans = goodsDao.getGoodsClassMarketings(goodsClassMarketingBean, pageBean);
		return pageBean.setObject(goodsClassBeans);
	}

	public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans = goodsDao.getGoodsMarketings(goodsMarketingBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}

	public GoodsSpecificationBean getGoodsSpecificationDetail(GoodsSpecificationBean goodsSpecificationBean) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsSpecificationDetail(goodsSpecificationBean);
	}

	public Object getGoodsDetail(GoodsBean goodsBean,String member_id) {
		GoodsBean goodsBean2 = goodsDao.getGoodsDetail(goodsBean);
		if (goodsBean2 != null) {
			PercentBean percentBean = shopSettingDao.getPercentDetail(new PercentBean().setPercent_type("goods_order"));// 商品预约比例
			if(percentBean == null){
				throw new AppException("商品预约比例不存在!");
			}
			double goods_percent = NumberUtils.Double(percentBean.getPercent_value()) / 100;
			double goods_order_price = NumberUtils.KeepDecimal(goods_percent * NumberUtils.Double(goodsBean2.getGoods_now_price()), 2);
			double goods_arrive_price  = NumberUtils.Double(goodsBean2.getGoods_now_price()) - goods_order_price;
			goodsBean2.setGoods_arrive_price(String.valueOf(goods_arrive_price));
			goodsBean2.setGoods_order_price(String.valueOf(goods_order_price));
//			if(!StringUtils.isEmpty(member_id)){//用户已登录浏览
//				int num=goodsDao.updateMemberBrowse(new MemberBrowseBean()
//						.setMember_id(member_id)
//						.setClass_id(goodsBean2.getClass_id()));
//				if(num<=0){//第一次浏览
//					goodsDao.insertMemberBrowse(new MemberBrowseBean()
//							.setMember_id(member_id)
//							.setClass_id(goodsBean2.getClass_id()));
//				}
//			}
			
			
//			List<GoodsImgBean> goodsImgBeans = goodsDao
//					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBean.getGoods_id() + ""));
//			goodsBean2.setGoodsImgBeans(goodsImgBeans);
//
//			List<SpecificationBean> specificationBeans = getGoodsSpecifications(
//					new GoodsSpecificationBean().setGoods_id(goodsBean.getGoods_id() + ""));
//			goodsBean2.setSpecificationBeans(specificationBeans);
//
//			List<ActivityBean> activityBeans = goodsDao
//					.getGoodsActivitys(new ActivityGoodsBean().setGoods_id(goodsBean.getGoods_id() + ""));
//			goodsBean2.setActivityBeans(activityBeans);
			
			GoodsIssueBean goodsIssueBean = getOneGoodsIssue(new GoodsIssueBean()
					.setGoods_id(goodsBean2.getGoods_id()+""));
			
			goodsBean2.setGoodsIssueBean(goodsIssueBean);
			
			List<GoodsAssessmentBean> goodsAssessmentBeans = goodsDao.getAssessmentsLimit(new GoodsAssessmentBean().
					setGoods_id(goodsBean2.getGoods_id()+""));
			
			goodsBean2.setGoodsAssessmentBeans(goodsAssessmentBeans);
			
			MerchantsBean merchantsBean = merchantsDao.getMerchantsDetail(new MerchantsBean()
					.setMerchants_id(Integer.valueOf(goodsBean2.getMerchants_id())));
			goodsBean2.setMerchantsBean(merchantsBean);
			

//			RedisUtils.setKey("goods:detail" + goodsBean.getGoods_id(), JSON.toJSONString(goodsBean2));
		}
		return goodsBean2;
	}

	public List<SpecificationBean> getGoodsSpecifications(GoodsSpecificationBean goodsSpecificationBean) {
		List<SpecificationBean> specificationBeans = goodsDao.getGoodsSpecificationsParent(goodsSpecificationBean);
		if (specificationBeans != null) {
			for (int i = 0; i < specificationBeans.size(); i++) {
				SpecificationBean specificationBean = specificationBeans.get(i);
				List<SpecificationBean> specificationBeans2 = goodsDao.getGoodsSpecificationsChild(
						goodsSpecificationBean.setParent_id(specificationBean.getSpecification_id() + ""));
				specificationBean.setSpecificationBeans(specificationBeans2);
			}
		}
		return specificationBeans;
	}

	/**
	 * 
	 */
	
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans = goodsDao.getGoodss(goodsBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}
	

	/**
	 * 
	 */

	public Object getGoodsClasss(GoodsClassBean goodsClassBean,PageBean pageBean) {
		List<GoodsClassBean> goodsClassBeans = goodsDao.getGoodsClasss(goodsClassBean);
		return goodsClassBeans;
	}

	@Override
	public ZMAyOrderBean getGoodsDetailAndSpecification(ZMAyOrderBean ayOrderBean) {
		// TODO Auto-generated method stub
		GoodsBean goodsDetail = goodsDao.getGoodsDetail(new GoodsBean().setGoods_id(
				NumberUtils.Integer(ayOrderBean.getGoods_id())));
		
		/**
		 * GoodsSpecificationBean goodsSpecificationDetail = goodsDao.getOneYuanGoodsSpecificationDetail(new GoodsSpecificationBean()
		 
				.setGoods_id(ayOrderBean.getGoods_id()).setSpecification_id(
						NumberUtils.Integer(ayOrderBean.getSpecification_id())));
		*/
		ayOrderBean.setGoods_name(goodsDetail
				.getGoods_name()).setGoods_img(goodsDetail.getGoods_img());
		
		return ayOrderBean;
	}

	@Override
	public GoodsBean getActivityGoodsDetail(String goods_id) {
		// TODO Auto-generated method stub
		GoodsBean goodsDetail = goodsDao.getActivityGoodsDetail(goods_id);
		return goodsDetail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	




	@Override
	public Object getGoodsClassTags(GoodsClassTagBean goodsClassTagBean) {
		// TODO Auto-generated method stub
		List<GoodsClassTagBean> goodsClassTagBeans = goodsDao.getGoodsClassTags(goodsClassTagBean);
		return goodsClassTagBeans;
	}

	@Override
	public Object insertGoodsIssue(GoodsIssueBean goodsIssueBean) {
		
		int num = goodsDao.insertGoodsIssue(goodsIssueBean);
		if(num <= 0) {
			throw new AppException("提问失败");
		}
		//修改商品的问题数量
		GoodsBean goodsBean = goodsDao.getGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(goodsIssueBean.getGoods_id())));
		if(goodsBean == null){
			throw new AppException("商品不存在");
		}
		int count = NumberUtils.Integer(goodsBean.getGoods_issue_count());
		count++;
		num = goodsDao.updateGoods(new GoodsBean().setGoods_issue_count(count+"").setGoods_id(goodsBean.getGoods_id()));
		if(num <= 0){
			throw new AppException("提问失败");
		}
		return num;
	}

	@Override
	public Object insertGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean) {
		// TODO Auto-generated method stub
		GoodsIssueBean goodsIssueBean = goodsDao.getGoodsIssueDetail(new GoodsIssueBean()
				.setGoods_issue_id(goodsIssueAnswerBean.getGoods_issue_id()));
		if(goodsIssueBean == null) {
			throw new AppException("没有该问题");
		}
		
		MemberGoodsRecordBean memberGoodsRecordBean = goodsDao.getMemberGoods(new MemberGoodsRecordBean()
				.setMember_id(goodsIssueAnswerBean.getMember_id())
				.setGoods_id(goodsIssueAnswerBean.getGoods_id()));
		if(memberGoodsRecordBean == null) {
			throw new AppException("只有使用过的才能回答");
		}
		
		int num = goodsDao.insertGoodsIssueAnswer(goodsIssueAnswerBean);
		if(num <= 0) {
			throw new AppException("回答失败");
		}
		
		return num;
	}

	@Override
	public Object getGoodsIssues(GoodsIssueBean goodsIssueBean) {
		// TODO Auto-generated method stub
		List<GoodsIssueBean> goodsIssueBeans = goodsDao.getGoodsIssues(goodsIssueBean);
		if(goodsIssueBeans != null) {
			for (int i = 0; i < goodsIssueBeans.size(); i++) {
				
				GoodsIssueBean goodsIssueBean2 = goodsIssueBeans.get(i);
				
				GoodsIssueAnswerBean goodsIssueAnswerBean = goodsDao.getOneGoodsIssueAnswer(new GoodsIssueAnswerBean()
						.setGoods_issue_id(goodsIssueBean2.getGoods_issue_id()));
				
				goodsIssueBean2.setGoodsIssueAnswerBean(goodsIssueAnswerBean);
			}
		}
		
		return goodsIssueBeans;
	}

	@Override
	public Object getGoodsIssueDetail(GoodsIssueBean goodsIssueBean) {
		// TODO Auto-generated method stub
		GoodsIssueBean goodsIssueBean2 = goodsDao.getGoodsIssueDetail(goodsIssueBean);
		
		if(goodsIssueBean2 != null) {
			List<GoodsIssueAnswerBean> goodsIssueAnswerBeans = goodsDao.getGoodsIssueAnswers(new GoodsIssueAnswerBean()
					.setGoods_issue_id(goodsIssueBean2.getGoods_issue_id()));
			
			goodsIssueBean2.setGoodsIssueAnswerBeans(goodsIssueAnswerBeans);
		}
		return goodsIssueBean2;
	}


	/**
	 * 返回商品最新的一个问题和回答
	 * @param goodsIssueBean
	 * @return
	 */
	public GoodsIssueBean getOneGoodsIssue(GoodsIssueBean goodsIssueBean) {
		GoodsIssueBean goodsIssueBean2 = goodsDao.getOneGoodsIssue(goodsIssueBean);
		if(goodsIssueBean2 != null) {
			GoodsIssueAnswerBean goodsIssueAnswerBean = goodsDao.getOneGoodsIssueAnswer(new GoodsIssueAnswerBean()
					.setGoods_issue_id(goodsIssueBean2.getGoods_issue_id()));
			goodsIssueBean2.setGoodsIssueAnswerBean(goodsIssueAnswerBean);
		}
		return goodsIssueBean2;
	}

	@Override
	public Object getGoodsClasss(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsClasss(goodsClassBean);
	}
	@Override
	public Object getGoodsClasssLimit(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsClasssLimit(goodsClassBean);
	}

	@Override
	public Object insertGoodsCollection(GoodsCollectionBean goodsCollectionBean) {
		int num = goodsDao.insertGoodsCollection(goodsCollectionBean);
		if(num <= 0) {
			throw new AppException("收藏失败");
		}
		return num;
	}

	@Override
	public Object deleteGoodsCollection(GoodsCollectionBean goodsCollectionBean) {
		int num = goodsDao.deleteGoodsCollection(goodsCollectionBean);
		if(num <= 0) {
			throw new AppException("取消收藏失败");
		}
		return num;
	}

	@Override
	public Object deleteCollection(GoodsCollectionBean goodsCollectionBean) {
		int num = goodsDao.deleteCollection(goodsCollectionBean);
		if(num <= 0) {
			throw new AppException("取消收藏失败");
		}
		return num;
	}
	

	@Override
	public Object getGoodsCollections(GoodsCollectionBean goodsCollectionBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(goodsDao.getGoodsCollections(goodsCollectionBean, pageBean));
	}

	@Override
	public Object getAssessments(GoodsAssessmentBean goodsAssessmentBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsAssessmentBean> goodsAssessmentBeans = goodsDao.getAssessments(goodsAssessmentBean, pageBean);
		for(GoodsAssessmentBean goodsAssessmentBean2 : goodsAssessmentBeans){
			
			List<GoodsAssessmentBean> goodsAssessmentBeans2 = goodsDao.getGoodsAssessmentsByParent(new GoodsAssessmentBean()
					.setParent_id(goodsAssessmentBean2.getAssessment_id()+""));
			
			goodsAssessmentBean2.setGoodsAssessmentBeans(goodsAssessmentBeans2);
				
				
		
		}
 		return pageBean.setObject(goodsAssessmentBeans);
	}
	




}
