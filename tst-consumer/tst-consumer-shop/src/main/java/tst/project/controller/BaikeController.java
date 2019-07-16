package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
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
import tst.project.shop.controller.IBaikeServiceC;

@Controller
@RequestMapping("/baikeController/v1.0")
public class BaikeController {
	@Autowired
	IBaikeServiceC baikeServiceC;
	
	@Autowired
	ISystemService systemService;
	
	@RequestMapping("/getGoodsStatistics") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsStatistics(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.getGoodsStatistics(goodsBean);
	}
	
	
	@RequestMapping("/acceptGoods") 
    @AppController(isVerSystemToken=true)
    public Object acceptGoods(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.acceptGoods(goodsBean);
	}
	
	@RequestMapping("/refuseGoods") 
    @AppController(isVerSystemToken=true)
    public Object refuseGoods(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.refuseGoods(goodsBean);
	}
	
	
	@RequestMapping("/getGoodsClassOutMarketings") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsClassOutMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getGoodsClassOutMarketings(goodsClassMarketingBean,pageBean);
	}
	
	@RequestMapping("/moveGoodsClassMarketing") 
    @AppController(isVerSystemToken=true)
    public Object moveGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) throws Exception{ 
		return baikeServiceC.moveGoodsClassMarketing(goodsClassMarketingBean);
	}
	
	
	@RequestMapping("/getGoodsClassMarketings") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getGoodsClassMarketings(goodsClassMarketingBean,pageBean);
	}

	
	
	@RequestMapping("/insertGoodsClassMarketing") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) throws Exception{ 
		
		return baikeServiceC.insertGoodsClassMarketing(goodsClassMarketingBean);
	}
	

	@RequestMapping("/deleteGoodsClassMarketing") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) throws Exception{ 
		return baikeServiceC.deleteGoodsClassMarketing(goodsClassMarketingBean);
	}
	
	
	@RequestMapping("/moveGoodsMarketing") 
    @AppController(isVerSystemToken=true)
    public Object moveGoodsMarketing(GoodsMarketingBean goodsMarketingBean) throws Exception{ 
		return baikeServiceC.moveGoodsMarketing(goodsMarketingBean);
	}
	
	
	@RequestMapping("/getGoodsMarketings") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getGoodsMarketings(goodsMarketingBean,pageBean);
	}

	@RequestMapping("/getGoodsOutMarketing") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsOutMarketing(GoodsMarketingBean goodsMarketingBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getGoodsOutMarketing(goodsMarketingBean,pageBean);
	}
	
	
	@RequestMapping("/insertGoodsMarketings") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsMarketings(GoodsMarketingBean goodsMarketingBean) throws Exception{ 
		
		return baikeServiceC.insertGoodsMarketings(goodsMarketingBean);
	}
	

	@RequestMapping("/deleteGoodsMarketing") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsMarketing(GoodsMarketingBean goodsMarketingBean) throws Exception{ 
		return baikeServiceC.deleteGoodsMarketing(goodsMarketingBean);
	}
	
	
	
	
	@RequestMapping("/getGoodsBrands") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsBrands(BrandBean brandBean) throws Exception{ 
		return baikeServiceC.getGoodsBrands(brandBean);
	}
	
	
	@RequestMapping("/getGoodsTags") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsTags(GoodsClassTagBean goodsClassTagBean) throws Exception{ 
		return baikeServiceC.getGoodsTags(goodsClassTagBean);
	}
	
	@RequestMapping("/getGoodsSelectSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsSelectSpecifications(GoodsSpecificationBean goodsSpecificationBean) throws Exception{ 
		return baikeServiceC.getGoodsSelectSpecifications(goodsSpecificationBean);
	}
	
	
	@RequestMapping("/getGoodsSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsSpecifications(SpecificationBean specificationBean) throws Exception{ 
		return baikeServiceC.getGoodsSpecifications(specificationBean);
	}
	
	
	@RequestMapping("/moveGoods") 
    @AppController(isVerSystemToken=true)
    public Object moveGoods(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.moveGoods(goodsBean);
	}
	
	
	@RequestMapping("/getGoodss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodss(GoodsBean goodsBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getGoodss(goodsBean,pageBean);
	}

	@RequestMapping("/getGoodsWithSpecifications") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsWithSpecifications(GoodsBean goodsBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getGoodsWithSpecifications(goodsBean,pageBean);
	}
	
	@RequestMapping("/getGoodsDetail") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsDetail(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.getGoodsDetail(goodsBean);
	}
	
	
	@RequestMapping("/insertGoods") 
    @AppController(isVerSystemToken=true)
    public Object insertGoods(GoodsBean goodsBean,String specifications,String goods_specifications,String goods_tags,String brands,String goods_imgs) throws Exception{ 		
		return baikeServiceC.insertGoods(goodsBean,JSON.parseArray(specifications, SpecificationBean.class)
													,JSON.parseArray(goods_specifications, GoodsSpecificationBean.class)
													,JSON.parseArray(goods_tags, GoodsClassTagBean.class)
													,JSON.parseArray(brands, BrandBean.class)
													,JSON.parseArray(goods_imgs,GoodsImgBean.class));
	}
	
	
	@RequestMapping("/updateGoods") 
    @AppController(isVerSystemToken=true)
    public Object updateGoods(GoodsBean goodsBean,String specifications,String goods_specifications,String goods_tags,String brands,String goods_imgs) throws Exception{ 
		return baikeServiceC.updateGoods(goodsBean,JSON.parseArray(specifications, SpecificationBean.class)
													,JSON.parseArray(goods_specifications, GoodsSpecificationBean.class)
													,JSON.parseArray(goods_tags, GoodsClassTagBean.class)
													,JSON.parseArray(brands, BrandBean.class)
													,JSON.parseArray(goods_imgs,GoodsImgBean.class));
	}
	
	@RequestMapping("/updateGoodsState") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsState(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.updateGoodsState(goodsBean);
	}
	
	@RequestMapping("/deleteGoods") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoods(GoodsBean goodsBean) throws Exception{ 
		return baikeServiceC.deleteGoods(goodsBean);
	}
	
	
	@RequestMapping("/moveFreight") 
    @AppController(isVerSystemToken=true)
    public Object moveFreight(FreightBean freightBean) throws Exception{ 
		return baikeServiceC.moveFreight(freightBean);
	}
	
	
	@RequestMapping("/getFreights") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getFreights(FreightBean freightBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getFreights(freightBean,pageBean);
	}

	@RequestMapping("/getFreightsNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getFreightsNoPage(FreightBean freightBean) throws Exception{ 
		return baikeServiceC.getFreightsNoPage(freightBean);
	}
	
	@RequestMapping("/getFreightDetail") 
    @AppController(isVerSystemToken=true)
    public Object getFreightDetail(FreightBean freightBean) throws Exception{ 
		return baikeServiceC.getFreightDetail(freightBean);
	}
	
	
	@RequestMapping("/insertFreight") 
    @AppController(isVerSystemToken=true)
    public Object insertFreight(FreightBean freightBean,String freight_citys,String freight_frees) throws Exception{ 

		return baikeServiceC.insertFreight(freightBean,
							JSON.parseArray(freight_citys, FreightCityBean.class),
							JSON.parseArray(freight_frees, FreightFreeBean.class));
	}
	
	
	@RequestMapping("/updateFreight") 
    @AppController(isVerSystemToken=true)
    public Object updateFreight(FreightBean freightBean,String freight_citys,String freight_frees) throws Exception{ 
		return baikeServiceC.updateFreight(freightBean,
								JSON.parseArray(freight_citys, FreightCityBean.class),
								JSON.parseArray(freight_frees, FreightFreeBean.class));
	}
	
	
	@RequestMapping("/deleteFreight") 
    @AppController(isVerSystemToken=true)
    public Object deleteFreight(FreightBean freightBean) throws Exception{ 
		return baikeServiceC.deleteFreight(freightBean);
	}
	
	
	
	@RequestMapping("/moveBrand") 
    @AppController(isVerSystemToken=true)
    public Object moveBrand(BrandBean brandBean) throws Exception{ 
		return baikeServiceC.moveBrand(brandBean);
	}
	
	
	@RequestMapping("/getBrands") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getBrands(BrandBean brandBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getBrands(brandBean,pageBean);
	}

	
	@RequestMapping("/getBrandDetail") 
    @AppController(isVerSystemToken=true)
    public Object getBrandDetail(BrandBean brandBean) throws Exception{ 
		return baikeServiceC.getBrandDetail(brandBean);
	}
	
	
	@RequestMapping("/insertBrand") 
    @AppController(isVerSystemToken=true)
    public Object insertBrand(BrandBean brandBean,String classs) throws Exception{ 
		
		return baikeServiceC.insertBrand(brandBean,JSON.parseArray(classs,GoodsClassBean.class));
	}
	
	
	@RequestMapping("/updateBrand") 
    @AppController(isVerSystemToken=true)
    public Object updateBrand(BrandBean brandBean,String classs) throws Exception{ 
		return baikeServiceC.updateBrand(brandBean,JSON.parseArray(classs,GoodsClassBean.class));
	}
	
	
	@RequestMapping("/deleteBrand") 
    @AppController(isVerSystemToken=true)
    public Object deleteBrand(BrandBean brandBean) throws Exception{ 
		return baikeServiceC.deleteBrand(brandBean);
	}
	
	
	
	@RequestMapping("/insertSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object insertSpecifications(String specifications) throws Exception{ 
		return baikeServiceC.insertSpecifications(JSON.parseArray(specifications,SpecificationBean.class));
	}
	
	@RequestMapping("/getSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object getSpecifications(SpecificationBean specificationBean) throws Exception{ 
		return baikeServiceC.getSpecifications(specificationBean);
	}
	
	
	@RequestMapping("/moveIndustry") 
    @AppController(isVerSystemToken=true)
    public Object moveIndustry(IndustryBean industryBean) throws Exception{ 
		return baikeServiceC.moveIndustry(industryBean);
	}
	
	@RequestMapping("/getIndustrys") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getIndustrys(IndustryBean industryBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getIndustrys(industryBean,pageBean);
	}
	@RequestMapping("/getGoodsClassIndustrys") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsClassIndustrys(IndustryBean industryBean) throws Exception{ 
		return baikeServiceC.getGoodsClassIndustrys(industryBean);
	}
	@RequestMapping("/getIndustrysNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getIndustrysNoPage(IndustryBean industryBean) throws Exception{ 
		return baikeServiceC.getIndustrysNoPage(industryBean);
	}
	
	@RequestMapping("/getIndustryDetail") 
    @AppController(isVerSystemToken=true)
    public Object getIndustryDetail(IndustryBean industryBean) throws Exception{ 
		return baikeServiceC.getIndustryDetail(industryBean);
	}
	
	
	@RequestMapping("/insertIndustry") 
    @AppController(isVerSystemToken=true)
    public Object insertIndustry(IndustryBean industryBean) throws Exception{ 
		
		return baikeServiceC.insertIndustry(industryBean);
	}
	
	
	@RequestMapping("/updateIndustry") 
    @AppController(isVerSystemToken=true)
    public Object updateIndustry(IndustryBean industryBean) throws Exception{ 
		return baikeServiceC.updateIndustry(industryBean);
	}
	
	
	@RequestMapping("/deleteIndustry") 
    @AppController(isVerSystemToken=true)
    public Object deleteIndustry(IndustryBean industryBean) throws Exception{ 
		return baikeServiceC.deleteIndustry(industryBean);
	}
	
	@RequestMapping("/moveGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object moveGoodsClass(GoodsClassBean goodsClassBean) throws Exception{ 
		return baikeServiceC.moveGoodsClass(goodsClassBean);
	}
	
	@RequestMapping("/getGoodsClassLinks") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsClassLinks(GoodsClassBean goodsClassBean) throws Exception{ 
		return baikeServiceC.getGoodsClassLinks(goodsClassBean);
	}
	
	@RequestMapping("/getMerchantsGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object getMerchantsGoodsClass(GoodsClassBean goodsClassBean) throws Exception{ 
		return baikeServiceC.getMerchantsGoodsClass(goodsClassBean);
	}
	
	/**
	 * 删除分类
	 * @param baikeClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBaikeClass") 
    @AppController
    public Object deleteBaikeClass(BaikeClassBean baikeClassBean) throws Exception{ 
		return baikeServiceC.deleteBaikeClass(baikeClassBean);
	}
	/**
	 * 修改分类
	 * @param baikeClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBaikeClass") 
    @AppController
    public Object updateBaikeClass(BaikeClassBean baikeClassBean) throws Exception{ 
		return baikeServiceC.updateBaikeClass(baikeClassBean);
	}
	/**
	 * 添加分类
	 * @param baikeClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBaikeClass") 
    @AppController
    public Object insertBaikeClass(BaikeClassBean baikeClassBean) throws Exception{ 
		return baikeServiceC.insertBaikeClass(baikeClassBean);
	}
	/**
	 * 分类列表
	 * @param baikeClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBaikeClasss") 
    @AppController(isPage=true)
    public Object getBaikeClasss(BaikeClassBean baikeClassBean,PageBean pageBean) throws Exception{ 
		return baikeServiceC.getBaikeClasss(baikeClassBean,pageBean);
	}
	
	
	/**
	 * 分类详情
	 * @param baikeClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBaikeClassDetail") 
    @AppController(isVerSystemToken=true)
    public Object getBaikeClassDetail(BaikeClassBean baikeClassBean) throws Exception{ 
		return baikeServiceC.getBaikeClassDetail(baikeClassBean);
	}
	
	/**
	 * 添加分类
	 * @param goodsClassBean
	 * @param class_tags
	 * @param industrys
	 * @param specifications
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsClass(GoodsClassBean goodsClassBean,String class_tags,String industrys,String specifications) throws Exception{ 
		
		return baikeServiceC.insertGoodsClass(goodsClassBean,
				JSON.parseArray(class_tags,GoodsClassTagBean.class),
				JSON.parseArray(industrys,IndustryBean.class),
				JSON.parseArray(specifications,SpecificationBean.class));
	}
	
	/**
	 * 修改分类
	 * @param goodsClassBean
	 * @param class_tags
	 * @param industrys
	 * @param specifications
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsClass(GoodsClassBean goodsClassBean,String class_tags,String industrys,String specifications) throws Exception{ 
		return baikeServiceC.updateGoodsClass(goodsClassBean,
				JSON.parseArray(class_tags,GoodsClassTagBean.class),
				JSON.parseArray(industrys,IndustryBean.class),
				JSON.parseArray(specifications,SpecificationBean.class));
	}
	
	/**
	 * 删除分类
	 * @param goodsClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsClass(GoodsClassBean goodsClassBean) throws Exception{ 
		return baikeServiceC.deleteGoodsClass(goodsClassBean);
	}
	
	
}
