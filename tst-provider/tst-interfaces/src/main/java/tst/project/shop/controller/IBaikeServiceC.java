/**
 * 
 */
package tst.project.shop.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.activity.ZMActivityGoodsBean;
import tst.project.bean.shop.BaikeClassBean;
import tst.project.bean.shop.BrandBean;
import tst.project.bean.shop.FreightBean;
import tst.project.bean.shop.FreightCityBean;
import tst.project.bean.shop.FreightFreeBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsClassBean;
import tst.project.bean.shop.GoodsClassMarketingBean;
import tst.project.bean.shop.GoodsClassTagBean;
import tst.project.bean.shop.GoodsImgBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.SpecificationBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IBaikeServiceC  {
	
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
	public Object acceptGoods(GoodsBean goodsBean);
	
	/**
	 * 接受商品审核
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object refuseGoods(GoodsBean goodsBean);
	
	/**
	 * 获得商品列表（除去存在的goods_ids）
	 * @author sjb
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public PageBean getGoodsOutIds(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 商品分类列表 除去已经添加的商品分类
	 * @author sjb
	 * @param goodsClassMarketingBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsClassOutMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean);
	
	/**
	 * 商品分类营销方案上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);

	/**
	 * 商品分类营销方案列表
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean, PageBean pageBean);


	/**
	 * 添加商品分类营销方案
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);

	

	/**
	 * 删除商品分类营销方案
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean);
	
	
	/**
	 * 商品营销方案上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveGoodsMarketing(GoodsMarketingBean goodsMarketingBean);

	/**
	 * 商品营销方案列表
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean, PageBean pageBean);

	/**
	 * 商品列表 除去已经添加的营销商品
	 * @author sjb
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsOutMarketing(GoodsMarketingBean goodsMarketingBean,PageBean pageBean);

	/**
	 * 添加商品营销方案
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsMarketings(GoodsMarketingBean goodsMarketingBean);

	

	/**
	 * 删除商品营销方案
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsMarketing(GoodsMarketingBean goodsMarketingBean);
	
	
	/**
	 * 商家行业所拥有的分类列表
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object getMerchantsGoodsClass(GoodsClassBean goodsClassBean);
	

	/**
	 * 商品关联品牌列表
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getGoodsBrands(BrandBean brandBean);

	/**
	 * 商品包含的标签列表
	 * @author sjb
	 * @return
	 */
	public Object getGoodsTags(GoodsClassTagBean goodsClassTagBean);

	/**
	 * 商品选择好的商品规格列表
	 * @author sjb
	 * @param goodsSpecificationBean
	 * @return
	 */
	public Object getGoodsSelectSpecifications(GoodsSpecificationBean goodsSpecificationBean);

	/**
	 * 商品的规格列表
	 * @author sjb
	 * @param specificationBean
	 * @return
	 */
	public List<SpecificationBean> getGoodsSpecifications(SpecificationBean specificationBean);

	/**
	 * 商品上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveGoods(GoodsBean goodsBean);

	/**
	 * 商品列表
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean);
	
	/**
	 * 商品列表（不分页）
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodssNoPage(GoodsBean goodsBean);

	/**
	 * 获得商品列表(按商家聚合)
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public List<Map<String,Object>> getGoodssGroupMerchants(GoodsBean goodsBean);
	
	/**
	 * 商品列表(带有规格)
	 * 
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsWithSpecifications(GoodsBean goodsBean, PageBean pageBean);
	
	/**
	 * 商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsDetail(GoodsBean goodsBean);

	/**
	 * 添加商品
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertGoods(GoodsBean goodsBean, List<SpecificationBean> specificationBeans,
			List<GoodsSpecificationBean> goodsSpecificationBeans, List<GoodsClassTagBean> goodsClassTagBeans,
			List<BrandBean> brandBeans, List<GoodsImgBean> goodsImgBeans);

	/**
	 * 修改商品
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int updateGoods(GoodsBean goodsBean, List<SpecificationBean> specificationBeans,
			List<GoodsSpecificationBean> goodsSpecificationBeans, List<GoodsClassTagBean> goodsClassTagBeans,
			List<BrandBean> brandBeans, List<GoodsImgBean> goodsImgBeans);

	/**
	 * 修改商品状态
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsState(GoodsBean goodsBean);
	/**
	 * 删除商品
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoods(GoodsBean goodsBean);

	/**
	 * 运费模板上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveFreight(FreightBean freightBean);

	/**
	 * 获得运费模板列表
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getFreights(FreightBean freightBean, PageBean pageBean);

	/**
	 * 获得运费模板列表
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getFreightsNoPage(FreightBean freightBean);

	/**
	 * 获得运费模板详情
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getFreightDetail(FreightBean freightBean);

	/**
	 * 添加运费模板
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int insertFreight(FreightBean freightBean, List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans);

	/**
	 * 修改运费模板
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int updateFreight(FreightBean freightBean, List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans);

	/**
	 * 删除运费模板
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int deleteFreight(FreightBean freightBean);

	/**
	 * 品牌上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveBrand(BrandBean brandBean);

	/**
	 * 获得品牌列表
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getBrands(BrandBean brandBean, PageBean pageBean);

	/**
	 * 获得品牌详情
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getBrandDetail(BrandBean brandBean);

	/**
	 * 添加品牌
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int insertBrand(BrandBean brandBean, List<GoodsClassBean> goodsClassBeans);

	/**
	 * 修改品牌
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int updateBrand(BrandBean brandBean, List<GoodsClassBean> goodsClassBeans);

	/**
	 * 删除品牌
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int deleteBrand(BrandBean brandBean);

	/**
	 * 平台总规格列表
	 * @author sjb
	 * @param specificationBean
	 * @return
	 */
	public List<SpecificationBean> getSpecifications(SpecificationBean specificationBean);

	/**
	 * 添加平台总规格
	 * @author sjb
	 * @param specificationBeans
	 * @return
	 */
	public int insertSpecifications(List<SpecificationBean> specificationBeans);

	/**
	 * 行业上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveIndustry(IndustryBean industryBean);

	/**
	 * 商品行业列表
	 * @author sjb
	 * @param goodsClassBean
	 * @param pageBean
	 */
	public Object getIndustrys(IndustryBean industryBean, PageBean pageBean);

	public Object getIndustrysNoPage(IndustryBean industryBean);

	/**
	 * 商品行业详情
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object getIndustryDetail(IndustryBean industryBean);

	/**
	 * 添加行业
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public int insertIndustry(IndustryBean industryBean);

	/**
	 * 修改行业
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public int updateIndustry(IndustryBean industryBean);

	/**
	 * 删除行业
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public int deleteIndustry(IndustryBean industryBean);

	public Object getGoodsClassIndustrys(IndustryBean industryBean);
	
	/**
	 * 分类上下移动
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object moveGoodsClass(GoodsClassBean goodsClassBean);

	/**
	 * 商品多级分类联动列表
	 * @author sjb
	 * @param goodsClassBean
	 * @param pageBean
	 */
	public Object getGoodsClassLinks(GoodsClassBean goodsClassBean);

	/**
	 * 百科分类列表
	 * @author sjb
	 * @param baikeClassBean
	 * @param pageBean
	 */
	public Object getBaikeClasss(BaikeClassBean baikeClassBean, PageBean pageBean);

	/**
	 * 百科分类详情
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public Object getBaikeClassDetail(BaikeClassBean baikeClassBean);
	
	/**
	 * 修改百科分类
	 * @author lx
	 * @param baikeClassBean
	 * @return
	 */
	public Object updateBaikeClass(BaikeClassBean baikeClassBean);
	/**
	 * 添加百科分类
	 * @author lx
	 * @param baikeClassBean
	 * @return
	 */
	public Object insertBaikeClass(BaikeClassBean baikeClassBean);
	
	/**
	 * 删除百科分类
	 * @author lx
	 * @param baikeClassBean
	 * @return
	 */
	public Object deleteBaikeClass(BaikeClassBean baikeClassBean);

	/**
	 * 添加商品分类
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public int insertGoodsClass(GoodsClassBean goodsClassBean, List<GoodsClassTagBean> goodsClassTagBeans,
			List<IndustryBean> industryBeans, List<SpecificationBean> specificationBeans);

	/**
	 * 修改商品分类
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public int updateGoodsClass(GoodsClassBean goodsClassBean, List<GoodsClassTagBean> goodsClassTagBeans,
			List<IndustryBean> industryBeans, List<SpecificationBean> specificationBeans);

	/**
	 * 删除商品分类
	 * @author sjb
	 * @param goodsClassBean
	 * @return
	 */
	public int deleteGoodsClass(GoodsClassBean goodsClassBean);
	
	/**
	 * 获得未参加一元购活动的商品
	 * @param goods
	 * @return
	 */
	PageBean getShopOutOneYuanGoods(String goods_ids, PageBean pageBean);


	/**
	 * 获得已选中的商品
	 * @param goods_ids
	 * @return
	 */
	List<ZMActivityGoodsBean> getCheckedGoods(String goods_ids);
	
	

}
