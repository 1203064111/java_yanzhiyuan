package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;

import com.alibaba.dubbo.container.page.Page;

import tst.project.annotation.Mapper;
import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.shop.BrandBean;
import tst.project.bean.shop.FreightBean;
import tst.project.bean.shop.FreightCityBean;
import tst.project.bean.shop.FreightFreeBean;
import tst.project.bean.shop.GoodsAssessmentBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsClassBean;
import tst.project.bean.shop.GoodsClassMarketingBean;
import tst.project.bean.shop.GoodsClassTagBean;
import tst.project.bean.shop.GoodsImgBean;
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.MerchantsGoodsClassBean;
import tst.project.bean.shop.SpecificationBean;
import tst.project.page.PageBean;

@Mapper
public interface GoodsDaoC {
	
	/**
	 * 添加回复
	 * @param goodsAssessmentBean
	 * @return
	 */
	public int insertGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean);
	/**
	 * 商品二级回复列表
	 * @param goodsAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsAssessmentBean> getGoodsAssessmentsByParent(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean);
	/**
	 * 商品问题列表
	 * @author lx
	 * @param goodsIssueBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsIssueBean> getGoodsIssues(GoodsIssueBean goodsIssueBean,PageBean pageBean);
	/**
	 * 商品问题回答列表
	 * @author lx
	 * @param goodsIssueAnswerBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsIssueAnswerBean> getGoodsIssueAnswers(GoodsIssueAnswerBean goodsIssueAnswerBean,PageBean pageBean);
	/**
	 * 修改商品问题
	 * @author lx
	 * @param goodsIssueBean
	 * @return
	 */
	public int updateGoodsIssue(GoodsIssueBean goodsIssueBean);
	/**
	 * 修改商品回答
	 * @author lx
	 * @param goodsIssueAnswerBean
	 * @return
	 */
	public int updateGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean);
	/**
	 * 删除商品问题
	 * @author lx
	 * @param goodsIssueBean
	 * @return
	 */
	public int deleteGoodsIssue(GoodsIssueBean goodsIssueBean);
	/**
	 * 删除商品回答
	 * @author lx
	 * @param goodsIssueAnswerBean
	 * @return
	 */
	public int deleteGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean);
	
	/**
	 * 获取商家分类关联信息
	 * @param merchantsGoodsClassBean
	 * @return
	 */
	public List<MerchantsGoodsClassBean> getMerchantsGoodsClasss(MerchantsGoodsClassBean merchantsGoodsClassBean);
	
	/**
	 * 添加商家分类关联
	 * @param merchantsGoodsClassBean
	 * @return
	 */
	public int insertMerchantsGoodsClass(MerchantsGoodsClassBean merchantsGoodsClassBean);
	
	
	/**
	 * 删除商家分类关联
	 * @param merchantsGoodsClassBean
	 * @return
	 */
	public int deleteMerchantsGoodsClass(MerchantsGoodsClassBean merchantsGoodsClassBean);
	/**
	 * 商品分类不分页
	 * @param goodsClassBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasssNoPage(GoodsClassBean goodsClassBean);
	/**
	 * 商品评价列表
	 * @author lx
	 * @param goodsAssessmentBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsAssessmentBean> getGoodsAssessments(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean);
	/**
	 * 删除评价
	 * @author lx
	 * @param goodsAssessmentBean
	 * @return
	 */
	public int deleteGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean);
	/**
	 * 修改或审核评价
	 * @author lx
	 * @param goodsAssessmentBean
	 * @return
	 */
	public int updateGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean);
	/**
	 * 评价详情
	 * @author lx
	 * @param goodsAssessmentBean
	 * @return
	 */
	public GoodsAssessmentBean getGoodsAssessmentDetail(GoodsAssessmentBean goodsAssessmentBean);
	/**
	 * 商品统计
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Map<String, Object> getGoodsStatistics(GoodsBean goodsBean);
	
	/**
	 * 接受商品审核
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int acceptGoods(GoodsBean goodsBean);
	
	/**
	 * 拒绝商品审核
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int refuseGoods(GoodsBean goodsBean);
	
	
	/**
	 * 获得商品列表(按商家聚合)
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public List<Map<String,Object>> getGoodssGroupMerchants(GoodsBean goodsBean);
	
	/**
	 * 商品列表（不分页）
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodssNoPage(GoodsBean goodsBean);
	
	/**
	 * 获得商品列表（除去存在的goods_ids）
	 * @author sjb
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGoodsOutIds(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 商品分类列表 除去已经添加的商品分类
	 * @param goodsClassMarketingBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClassOutMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean);
	
	/**
	 * 商品分类营销方案列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsClassMarketingBean> getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean, PageBean pageBean);
	
	/**
	 * 商品分类营销方案详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsClassMarketingBean getGoodsClassMarketingDetail(GoodsClassMarketingBean goodsClassMarketingBean);
	
	/**
	 * 商品分类上下移动
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsClassMarketingBean getMoveGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);

	/**
	 * 添加商品分类营销方案
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);

	/**
	 * 修改商品分类营销方案
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);

	/**
	 * 删除商品分类营销方案
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);
	
	
	
	
	/**
	 * 医生/医院推荐商品列表(不分页)
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsMarketingBean> getGoodsMarketings(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 医生/医院推荐商品列表(分页)
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsMarketingBean> getGoodsMarketings(GoodsMarketingBean goodsMarketingBean, PageBean pageBean);

	
	/**
	 * 商品列表 除去已经添加的营销商品
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getGoodsOutMarketing(GoodsMarketingBean goodsMarketingBean,PageBean pageBean);
	
	/**
	 * 商品营销方案详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsMarketingBean getGoodsMarketingDetail(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 商品营销方案详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsMarketingBean getMoveGoodsMarketing(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 添加商品营销方案
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsMarketings(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 修改商品营销方案
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsMarketing(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 删除商品营销方案
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsMarketing(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 商品的轮播图列表
	 * 
	 * @param goodsImgBean
	 * @return
	 */
	public List<GoodsImgBean> getGoodsImgs(GoodsImgBean goodsImgBean);

	/**
	 * 添加商品轮播图
	 * 
	 * @param goodsImgBean
	 * @return
	 */
	public int insertGoodsImg(GoodsImgBean goodsImgBean);

	/**
	 * 修改商品轮播图
	 * 
	 * @param goodsImgBean
	 * @return
	 */
	public int updateGoodsImg(GoodsImgBean goodsImgBean);

	/**
	 * 删除商品轮播图
	 * 
	 * @param goodsImgBean
	 * @return
	 */
	public int deleteGoodsImgs(GoodsImgBean goodsImgBean);

	/**
	 * 添加商品关联品牌
	 * 
	 * @param brandBean
	 * @return
	 */
	public int insertGoodsBrand(BrandBean brandBean);

	/**
	 * 添加商品关联品牌
	 * 
	 * @param brandBean
	 * @return
	 */
	public int updateGoodsBrand(BrandBean brandBean);

	/**
	 * 添加商品关联品牌
	 * 
	 * @param brandBean
	 * @return
	 */
	public int deleteGoodsBrands(BrandBean brandBean);

	/**
	 * 商品关联品牌列表
	 * 
	 * @param brandBean
	 * @return
	 */
	public List<BrandBean> getGoodsBrands(BrandBean brandBean);

	/**
	 * 添加商品关联标签
	 * 
	 * @param goodsClassTagBean
	 * @return
	 */
	public int insertGoodsTag(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 修改商品关联标签
	 * 
	 * @param goodsClassTagBean
	 * @return
	 */
	public int updateGoodsTag(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 删除商品关联标签
	 * 
	 * @param goodsClassTagBean
	 * @return
	 */
	public int deleteGoodsTags(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 商品包含的标签列表
	 * 
	 * @return
	 */
	public List<GoodsClassTagBean> getGoodsTags(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 商品选择好的商品规格列表
	 * 
	 * @param goodsSpecificationBean
	 * @return
	 */
	public List<GoodsSpecificationBean> getGoodsSelectSpecifications(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 商品的选中规格情况列表
	 * 
	 * @param specificationBean
	 * @return
	 */
	public List<SpecificationBean> getSpecificationsChild(SpecificationBean specificationBean);

	/**
	 * 添加商品关联规格
	 * 
	 * @param goodsSpecificationBean
	 * @return
	 */
	public int insertGoodsSpecification(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 修改商品关联规格
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsSpecification(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 删除商品关联规格
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsSpecifications(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getMoveGoods(GoodsBean goodsBean);

	/**
	 * 商品列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodss(GoodsBean goodsBean, PageBean pageBean);

	public List<Map<String, Object>> getGoodsWithSpecifications(GoodsBean goodsBean, PageBean pageBean);

	/**
	 * 商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getGoodsDetail(GoodsBean goodsBean);

	/**
	 * 添加商品
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertGoods(GoodsBean goodsBean);

	/**
	 * 修改商品
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoods(GoodsBean goodsBean);

	/**
	 * 删除商品
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoods(GoodsBean goodsBean);

	/**
	 * 获得运费城市价格列表
	 * 
	 * @param freightCityBean
	 * @return
	 */
	public List<FreightCityBean> getFreightCitys(FreightCityBean freightCityBean);

	/**
	 * 添加运费城市价格
	 * 
	 * @param freightCityBean
	 * @return
	 */
	public int insertFreightCity(FreightCityBean freightCityBean);

	/**
	 * 修改运费城市价格
	 * 
	 * @param freightCityBean
	 * @return
	 */
	public int updateFreightCity(FreightCityBean freightCityBean);

	/**
	 * 删除运费城市价格
	 * 
	 * @param freightCityBean
	 * @return
	 */
	public int deleteFreightCitys(FreightCityBean freightCityBean);

	/**
	 * 添加运费城市的免邮条件
	 * 
	 * @param freightFreeBean
	 * @return
	 */
	public int insertFreightFree(FreightFreeBean freightFreeBean);

	/**
	 * 添加运费城市的免邮条件
	 * 
	 * @param freightFreeBean
	 * @return
	 */
	public int updateFreightFree(FreightFreeBean freightFreeBean);

	/**
	 * 添加运费城市的免邮条件
	 * 
	 * @param freightFreeBean
	 * @return
	 */
	public int deleteFreightFrees(FreightFreeBean freightFreeBean);

	/**
	 * 获得运费城市免邮列表
	 * 
	 * @param freightFreeBean
	 * @return
	 */
	public List<FreightFreeBean> getFreightFrees(FreightFreeBean freightFreeBean);

	/**
	 * 运费模板上下移动
	 * 
	 * @param freightBean
	 * @return
	 */
	public FreightBean getMoveFreight(FreightBean freightBean);

	/**
	 * 获得运费模板列表
	 * 
	 * @param brandBean
	 * @return
	 */
	public List<FreightBean> getFreights(FreightBean freightBean, PageBean pageBean);

	/**
	 * 获得运费模板列表
	 * 
	 * @param brandBean
	 * @return
	 */
	public List<FreightBean> getFreightsNoPage(FreightBean freightBean);

	/**
	 * 获得运费模板详情
	 * 
	 * @param brandBean
	 * @return
	 */
	public FreightBean getFreightDetail(FreightBean freightBean);

	/**
	 * 添加运费模板
	 * 
	 * @param brandBean
	 * @return
	 */
	public int insertFreight(FreightBean freightBean);

	/**
	 * 修改运费模板
	 * 
	 * @param brandBean
	 * @return
	 */
	public int updateFreight(FreightBean freightBean);

	/**
	 * 删除运费模板
	 * 
	 * @param brandBean
	 * @return
	 */
	public int deleteFreight(FreightBean freightBean);

	/**
	 * 分类勾选的规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public List<GoodsClassBean> getBrandClasss(GoodsClassBean goodsClassBean);

	/**
	 * 添加分类规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public int insertBrandClass(GoodsClassBean goodsClassBean);

	/**
	 * 修改分类规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public int updateBrandClass(GoodsClassBean goodsClassBean);

	/**
	 * 删除品牌分类
	 * 
	 * @param industryBean
	 * @return
	 */
	public int deleteBrandClass(GoodsClassBean goodsClassBean);

	/**
	 * 品牌上下移动
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public BrandBean getMoveBrand(BrandBean brandBean);

	/**
	 * 获得品牌列表
	 * 
	 * @param brandBean
	 * @return
	 */
	public List<BrandBean> getBrands(BrandBean brandBean, PageBean pageBean);

	/**
	 * 获得品牌详情
	 * 
	 * @param brandBean
	 * @return
	 */
	public BrandBean getBrandDetail(BrandBean brandBean);

	/**
	 * 添加品牌
	 * 
	 * @param brandBean
	 * @return
	 */
	public int insertBrand(BrandBean brandBean);

	/**
	 * 修改品牌
	 * 
	 * @param brandBean
	 * @return
	 */
	public int updateBrand(BrandBean brandBean);

	/**
	 * 删除品牌
	 * 
	 * @param brandBean
	 * @return
	 */
	public int deleteBrand(BrandBean brandBean);

	/**
	 * 添加规格
	 * 
	 * @param specificationBean
	 * @return
	 */
	public int insertSpecification(SpecificationBean specificationBean);

	/**
	 * 修改规格
	 * 
	 * @param specificationBean
	 * @return
	 */
	public int updateSpecification(SpecificationBean specificationBean);

	/**
	 * 删除规格
	 * 
	 * @param specificationBean
	 * @return
	 */
	public int deleteSpecifications(SpecificationBean specificationBean);

	/**
	 * 规格列表
	 * 
	 * @param specificationBean
	 * @return
	 */
	public List<SpecificationBean> getSpecifications(SpecificationBean specificationBean);

	/**
	 * 行业上下移动
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public IndustryBean getMoveIndustry(IndustryBean industryBean);

	/**
	 * 商品行业列表
	 * 
	 * @param goodsClassBean
	 * @param pageBean
	 */
	public List<IndustryBean> getIndustrys(IndustryBean industryBean, PageBean pageBean);

	public List<IndustryBean> getIndustrysNoPage(IndustryBean industryBean);

	/**
	 * 商品行业详情
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public IndustryBean getIndustryDetail(IndustryBean industryBean);

	/**
	 * 添加行业
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int insertIndustry(IndustryBean industryBean);

	/**
	 * 修改行业
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int updateIndustry(IndustryBean industryBean);

	/**
	 * 删除行业
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int deleteIndustry(IndustryBean industryBean);

	/**
	 * 获得需要移动的相邻的分类
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public GoodsClassBean getMoveClass(GoodsClassBean goodsClassBean);

	/**
	 * 商品多级分类联动列表
	 * 
	 * @param goodsClassBean
	 * @param pageBean
	 */
	public List<GoodsClassBean> getGoodsClassLinks(GoodsClassBean goodsClassBean);

	/**
	 * 商家行业所拥有的分类列表
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public List<GoodsClassBean> getMerchantsGoodsClass(GoodsClassBean goodsClassBean);

	/**
	 * 商品分类列表
	 * 
	 * @param goodsClassBean
	 * @param pageBean
	 */
	public List<GoodsClassBean> getGoodsClasss(GoodsClassBean goodsClassBean, PageBean pageBean);

	/**
	 * 商品分类详情
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public GoodsClassBean getGoodsClassDetail(GoodsClassBean goodsClassBean);

	/**
	 * 添加商品分类
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int insertGoodsClass(GoodsClassBean goodsClassBean);

	/**
	 * 修改商品分类
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int updateGoodsClass(GoodsClassBean goodsClassBean);

	/**
	 * 删除商品分类
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int deleteGoodsClass(GoodsClassBean goodsClassBean);

	/**
	 * 获得商品分类标签数组
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public List<GoodsClassTagBean> getGoodsClassTags(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 分类勾选的行业
	 * 
	 * @param industryBean
	 * @return
	 */
	public List<IndustryBean> getGoodsClassIndustrys(IndustryBean industryBean);

	/**
	 * 添加商品分类标签
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int insertGoodsClassTag(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 修改商品分类标签
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int updateGoodsClassTag(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 删除商品分类标签
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int deleteGoodsClassTags(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 添加分类行业
	 * 
	 * @param industryBean
	 * @return
	 */
	public int insertGoodsClassIndustry(IndustryBean industryBean);

	/**
	 * 修改分类行业
	 * 
	 * @param industryBean
	 * @return
	 */
	public int updateGoodsClassIndustry(IndustryBean industryBean);

	/**
	 * 删除分类行业
	 * 
	 * @param industryBean
	 * @return
	 */
	public int deleteGoodsClassIndustrys(IndustryBean industryBean);

	/**
	 * 分类勾选的规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public List<SpecificationBean> getGoodsClassSpecifications(SpecificationBean specificationBean);

	/**
	 * 添加分类规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public int insertGoodsClassSpecification(SpecificationBean specificationBean);

	/**
	 * 修改分类规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public int updateGoodsClassSpecification(SpecificationBean specificationBean);

	/**
	 * 删除分类规格
	 * 
	 * @param industryBean
	 * @return
	 */
	public int deleteGoodsClassSpecifications(SpecificationBean specificationBean);
	
	/**
	 * 获得未参加一元购的商品
	 * @param goods
	 * @return
	 */
	List<ZMActivityGoodsBean> getShopOutOneYuanGoods(String goods_ids, PageBean pageBean);
	
	/**
	 * 获得已选中的商品
	 * @param goods_ids
	 * @return
	 */
	List<ZMActivityGoodsBean> getCheckedGoods(String goods_ids);

}
