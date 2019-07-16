package tst.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
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
import tst.project.bean.shop.SpecificationBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IGoodsServiceC;

@Controller
@RequestMapping("/goodsController/v1.0")
public class GoodsController {
	@Autowired
	IGoodsServiceC goodsServiceC;
	
	@Autowired
	ISystemService systemService;
	
	
	
	@RequestMapping("/getGoodsStatistics") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsStatistics(GoodsBean goodsBean) throws Exception{ 
		return goodsServiceC.getGoodsStatistics(goodsBean);
	}
	
	@RequestMapping("/acceptGoods") 
    @AppController(isVerSystemToken=true)
    public Object acceptGoods(GoodsBean goodsBean) throws Exception{ 
		return goodsServiceC.acceptGoods(goodsBean);
	}
	
	@RequestMapping("/refuseGoods") 
    @AppController(isVerSystemToken=true)
    public Object refuseGoods(GoodsBean goodsBean) throws Exception{ 
		return goodsServiceC.refuseGoods(goodsBean);
	}
	
	
	@RequestMapping("/getGoodsClassOutMarketings") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsClassOutMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsClassOutMarketings(goodsClassMarketingBean,pageBean);
	}
	
	@RequestMapping("/moveGoodsClassMarketing") 
    @AppController(isVerSystemToken=true)
    public Object moveGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) throws Exception{ 
		return goodsServiceC.moveGoodsClassMarketing(goodsClassMarketingBean);
	}
	
	/**
	 * 商品分类推荐列表
	 * @param goodsClassMarketingBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsClassMarketings") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsClassMarketings(goodsClassMarketingBean,pageBean);
	}

	
	/**
	 * 添加分类推荐
	 * @param goodsClassMarketingBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsClassMarketing") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) throws Exception{ 
		
		return goodsServiceC.insertGoodsClassMarketing(goodsClassMarketingBean);
	}
	

	@RequestMapping("/deleteGoodsClassMarketing") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) throws Exception{ 
		return goodsServiceC.deleteGoodsClassMarketing(goodsClassMarketingBean);
	}
	
	/**
	 * 
	 * @param goodsMarketingBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/moveGoodsMarketing") 
    @AppController(isVerSystemToken=true)
    public Object moveGoodsMarketing(GoodsMarketingBean goodsMarketingBean) throws Exception{ 
		return goodsServiceC.moveGoodsMarketing(goodsMarketingBean);
	}
	
	/**
	 * 商品推荐列表
	 * @param goodsMarketingBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsMarketings") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsMarketings(goodsMarketingBean,pageBean);
	}

	@RequestMapping("/getGoodsOutMarketing") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsOutMarketing(GoodsMarketingBean goodsMarketingBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsOutMarketing(goodsMarketingBean,pageBean);
	}
	
	/**
	 * 添加商品推荐
	 * @param goodsMarketingBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsMarketings") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsMarketings(GoodsMarketingBean goodsMarketingBean) throws Exception{ 
		
		return goodsServiceC.insertGoodsMarketings(goodsMarketingBean);
	}
	
	/**
	 * 删除商品推荐
	 * @param goodsMarketingBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsMarketing") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsMarketing(GoodsMarketingBean goodsMarketingBean) throws Exception{ 
		return goodsServiceC.deleteGoodsMarketing(goodsMarketingBean);
	}
	
	
	
	
	@RequestMapping("/getGoodsBrands") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsBrands(BrandBean brandBean) throws Exception{ 
		return goodsServiceC.getGoodsBrands(brandBean);
	}
	
	
	@RequestMapping("/getGoodsTags") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsTags(GoodsClassTagBean goodsClassTagBean) throws Exception{ 
		return goodsServiceC.getGoodsTags(goodsClassTagBean);
	}
	
	@RequestMapping("/getGoodsSelectSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsSelectSpecifications(GoodsSpecificationBean goodsSpecificationBean) throws Exception{ 
		return goodsServiceC.getGoodsSelectSpecifications(goodsSpecificationBean);
	}
	
	
	@RequestMapping("/getGoodsSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsSpecifications(SpecificationBean specificationBean) throws Exception{ 
		return goodsServiceC.getGoodsSpecifications(specificationBean);
	}
	
	
	@RequestMapping("/moveGoods") 
    @AppController(isVerSystemToken=true)
    public Object moveGoods(GoodsBean goodsBean) throws Exception{ 
		return goodsServiceC.moveGoods(goodsBean);
	}
	
	/**
	 * 商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodss(GoodsBean goodsBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodss(goodsBean,pageBean);
	}

	@RequestMapping("/getGoodsWithSpecifications") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsWithSpecifications(GoodsBean goodsBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsWithSpecifications(goodsBean,pageBean);
	}
	/**
	 * 商品详情
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsDetail") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsDetail(GoodsBean goodsBean) throws Exception{ 
		return goodsServiceC.getGoodsDetail(goodsBean);
	}
	
	/**
	 * 添加商品信息
	 * @param goodsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoods") 
    @AppController(isVerSystemToken=true)
    public Object insertGoods(GoodsBean goodsBean,HttpServletRequest request) throws Exception{ 	
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加商品信息，商品名称为"+goodsBean.getGoods_name())
				.setOperate_type("insert")
				.setModule_name("商品模块"));
		return goodsServiceC.insertGoods(goodsBean);
	}
	
	/**
	 * 修改商品信息
	 * @param goodsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoods") 
    @AppController(isVerSystemToken=true)
    public Object updateGoods(GoodsBean goodsBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商品信息，商品id为"+goodsBean.getGoods_id())
				.setOperate_type("update")
				.setModule_id(goodsBean.getGoods_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.updateGoods(goodsBean);
	}
	/**
	 * 删除商品状态
	 * @param goodsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodsState") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsState(GoodsBean goodsBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商品状态，商品id为"+goodsBean.getGoods_id())
				.setOperate_type("update")
				.setModule_id(goodsBean.getGoods_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.updateGoodsState(goodsBean);
	}
	/**
	 * 删除商品
	 * @param goodsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoods") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoods(GoodsBean goodsBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除商品，商品id为"+goodsBean.getGoods_id())
				.setOperate_type("delete")
				.setModule_id(goodsBean.getGoods_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.deleteGoods(goodsBean);
	}
	
	
	@RequestMapping("/moveFreight") 
    @AppController(isVerSystemToken=true)
    public Object moveFreight(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.moveFreight(freightBean);
	}
	
	
	@RequestMapping("/getFreights") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getFreights(FreightBean freightBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getFreights(freightBean,pageBean);
	}

	@RequestMapping("/getFreightsNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getFreightsNoPage(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.getFreightsNoPage(freightBean);
	}
	
	@RequestMapping("/getFreightDetail") 
    @AppController(isVerSystemToken=true)
    public Object getFreightDetail(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.getFreightDetail(freightBean);
	}
	
	
	@RequestMapping("/insertFreight") 
    @AppController(isVerSystemToken=true)
    public Object insertFreight(FreightBean freightBean,String freight_citys,String freight_frees) throws Exception{ 

		return goodsServiceC.insertFreight(freightBean,
							JSON.parseArray(freight_citys, FreightCityBean.class),
							JSON.parseArray(freight_frees, FreightFreeBean.class));
	}
	
	
	@RequestMapping("/updateFreight") 
    @AppController(isVerSystemToken=true)
    public Object updateFreight(FreightBean freightBean,String freight_citys,String freight_frees) throws Exception{ 
		return goodsServiceC.updateFreight(freightBean,
								JSON.parseArray(freight_citys, FreightCityBean.class),
								JSON.parseArray(freight_frees, FreightFreeBean.class));
	}
	
	
	@RequestMapping("/deleteFreight") 
    @AppController(isVerSystemToken=true)
    public Object deleteFreight(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.deleteFreight(freightBean);
	}
	
	
	
	@RequestMapping("/moveBrand") 
    @AppController(isVerSystemToken=true)
    public Object moveBrand(BrandBean brandBean) throws Exception{ 
		return goodsServiceC.moveBrand(brandBean);
	}
	
	
	@RequestMapping("/getBrands") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getBrands(BrandBean brandBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getBrands(brandBean,pageBean);
	}

	
	@RequestMapping("/getBrandDetail") 
    @AppController(isVerSystemToken=true)
    public Object getBrandDetail(BrandBean brandBean) throws Exception{ 
		return goodsServiceC.getBrandDetail(brandBean);
	}
	
	
	@RequestMapping("/insertBrand") 
    @AppController(isVerSystemToken=true)
    public Object insertBrand(BrandBean brandBean,String classs) throws Exception{ 
		
		return goodsServiceC.insertBrand(brandBean,JSON.parseArray(classs,GoodsClassBean.class));
	}
	
	
	@RequestMapping("/updateBrand") 
    @AppController(isVerSystemToken=true)
    public Object updateBrand(BrandBean brandBean,String classs) throws Exception{ 
		return goodsServiceC.updateBrand(brandBean,JSON.parseArray(classs,GoodsClassBean.class));
	}
	
	
	@RequestMapping("/deleteBrand") 
    @AppController(isVerSystemToken=true)
    public Object deleteBrand(BrandBean brandBean) throws Exception{ 
		return goodsServiceC.deleteBrand(brandBean);
	}
	
	
	
	@RequestMapping("/insertSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object insertSpecifications(String specifications) throws Exception{ 
		return goodsServiceC.insertSpecifications(JSON.parseArray(specifications,SpecificationBean.class));
	}
	
	@RequestMapping("/getSpecifications") 
    @AppController(isVerSystemToken=true)
    public Object getSpecifications(SpecificationBean specificationBean) throws Exception{ 
		return goodsServiceC.getSpecifications(specificationBean);
	}
	
	
	@RequestMapping("/moveIndustry") 
    @AppController(isVerSystemToken=true)
    public Object moveIndustry(IndustryBean industryBean) throws Exception{ 
		return goodsServiceC.moveIndustry(industryBean);
	}
	
	@RequestMapping("/getIndustrys") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getIndustrys(IndustryBean industryBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getIndustrys(industryBean,pageBean);
	}
	@RequestMapping("/getGoodsClassIndustrys") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsClassIndustrys(IndustryBean industryBean) throws Exception{ 
		return goodsServiceC.getGoodsClassIndustrys(industryBean);
	}
	@RequestMapping("/getIndustrysNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getIndustrysNoPage(IndustryBean industryBean) throws Exception{ 
		return goodsServiceC.getIndustrysNoPage(industryBean);
	}
	
	@RequestMapping("/getIndustryDetail") 
    @AppController(isVerSystemToken=true)
    public Object getIndustryDetail(IndustryBean industryBean) throws Exception{ 
		return goodsServiceC.getIndustryDetail(industryBean);
	}
	
	
	@RequestMapping("/insertIndustry") 
    @AppController(isVerSystemToken=true)
    public Object insertIndustry(IndustryBean industryBean) throws Exception{ 
		
		return goodsServiceC.insertIndustry(industryBean);
	}
	
	
	@RequestMapping("/updateIndustry") 
    @AppController(isVerSystemToken=true)
    public Object updateIndustry(IndustryBean industryBean) throws Exception{ 
		return goodsServiceC.updateIndustry(industryBean);
	}
	
	
	@RequestMapping("/deleteIndustry") 
    @AppController(isVerSystemToken=true)
    public Object deleteIndustry(IndustryBean industryBean) throws Exception{ 
		return goodsServiceC.deleteIndustry(industryBean);
	}
	
	@RequestMapping("/moveGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object moveGoodsClass(GoodsClassBean goodsClassBean) throws Exception{ 
		return goodsServiceC.moveGoodsClass(goodsClassBean);
	}
	
	@RequestMapping("/getGoodsClassLinks") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsClassLinks(GoodsClassBean goodsClassBean) throws Exception{ 
		return goodsServiceC.getGoodsClassLinks(goodsClassBean);
	}
	
	@RequestMapping("/getMerchantsGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object getMerchantsGoodsClass(GoodsClassBean goodsClassBean) throws Exception{ 
		return goodsServiceC.getMerchantsGoodsClass(goodsClassBean);
	}
	/**
	 * 商品分类列表
	 * @param goodsClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsClasss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsClasss(GoodsClassBean goodsClassBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsClasss(goodsClassBean,pageBean);
	}
	/**
	 * 商品分类
	 * @param goodsClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsClasssNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsClasssNoPage(GoodsClassBean goodsClassBean) throws Exception{ 
		return goodsServiceC.getGoodsClasssNoPage(goodsClassBean);
	}
	
	
	/**
	 * 商品分类详情
	 * @param goodsClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsClassDetail") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsClassDetail(GoodsClassBean goodsClassBean) throws Exception{ 
		return goodsServiceC.getGoodsClassDetail(goodsClassBean);
	}
	
	/**
	 * 添加商品分类
	 * @param goodsClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsClass(GoodsClassBean goodsClassBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加商品分类，商品分类名称为"+goodsClassBean.getClass_name())
				.setOperate_type("insert")
				.setModule_name("商品模块"));
		return goodsServiceC.insertGoodsClass(goodsClassBean);
	}
	
	/**
	 * 修改商品分类
	 * @param goodsClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsClass(GoodsClassBean goodsClassBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商品分类，商品分类名称为"+goodsClassBean.getClass_name())
				.setOperate_type("update")
				.setModule_id(goodsClassBean.getClass_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.updateGoodsClass(goodsClassBean);
	}
	
	/**
	 * 删除商品分类
	 * @param goodsClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsClass") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsClass(GoodsClassBean goodsClassBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除商品分类，商品分类名称为"+goodsClassBean.getClass_name())
				.setOperate_type("delete")
				.setModule_id(goodsClassBean.getClass_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.deleteGoodsClass(goodsClassBean);
	}
	/**
	 * 添加商品评论
	 * @param goodsAssessmentBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertGoodsAssessment") 
    @AppController(isVerSystemToken=true)
    public Object insertGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean) throws Exception{ 
		return goodsServiceC.insertGoodsAssessment(goodsAssessmentBean);
	}
	/**
	 * 商品评论列表
	 * @param goodsAssessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsAssessments") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsAssessments(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsAssessments(goodsAssessmentBean,pageBean);
	}
	/**
	 * 商品评论二级列表
	 * @param goodsAssessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsAssessmentsByParent") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsAssessmentsByParent(GoodsAssessmentBean goodsAssessmentBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsAssessmentsByParent(goodsAssessmentBean,pageBean);
	}
	
	
	/**
	 * 商品评论信息
	 * @param goodsAssessmentBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsAssessmentDetail") 
    @AppController(isVerSystemToken=true)
    public Object getGoodsAssessmentDetail(GoodsAssessmentBean goodsAssessmentBean) throws Exception{ 
		return goodsServiceC.getGoodsAssessmentDetail(goodsAssessmentBean);
	}
	
	
	/**
	 * 修改商品评论
	 * @param goodsAssessmentBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodsAssessment") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商品评论，评论id为"+goodsAssessmentBean.getAssessment_id())
				.setOperate_type("update")
				.setModule_id(goodsAssessmentBean.getAssessment_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.updateGoodsAssessment(goodsAssessmentBean);
	}
	
	/**
	 * 删除商品评论
	 * @param goodsAssessmentBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsAssessment") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean,HttpServletRequest request) throws Exception{ 
		
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除商品评论，评论id为"+goodsAssessmentBean.getAssessment_id())
				.setOperate_type("delete")
				.setModule_id(goodsAssessmentBean.getAssessment_id()+"")
				.setModule_name("商品模块"));
		return goodsServiceC.deleteGoodsAssessment(goodsAssessmentBean);
	}
	/**
	 * 商品问题列表
	 * @param goodsIssueBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsIssues") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsIssues(GoodsIssueBean goodsIssueBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsIssues(goodsIssueBean,pageBean);
	}
	/**
	 * 商品问题回答列表
	 * @param goodsIssueAnswerBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getGoodsIssueAnswers") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getGoodsIssueAnswers(GoodsIssueAnswerBean goodsIssueAnswerBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getGoodsIssueAnswers(goodsIssueAnswerBean,pageBean);
	}
	/**
	 * 修改商品问题
	 * @param goodsIssueBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodsIssue") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsIssue(GoodsIssueBean goodsIssueBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商品问题，问题id为"+goodsIssueBean.getGoods_issue_id())
				.setOperate_type("update")
				.setModule_id(goodsIssueBean.getGoods_issue_id()+"")
				.setModule_name("商品问答模块"));
		return goodsServiceC.updateGoodsIssue(goodsIssueBean);
	}
	
	/**
	 * 删除商品问题
	 * @param goodsIssueBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsIssue") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsIssue(GoodsIssueBean goodsIssueBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除商品问题，问题id为"+goodsIssueBean.getGoods_issue_id())
				.setOperate_type("delete")
				.setModule_id(goodsIssueBean.getGoods_issue_id()+"")
				.setModule_name("商品问答模块"));
		return goodsServiceC.deleteGoodsIssue(goodsIssueBean);
	}
	/**
	 * 修改商品问答
	 * @param goodsIssueAnswerBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateGoodsIssueAnswer") 
    @AppController(isVerSystemToken=true)
    public Object updateGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商品回答，回答id为"+goodsIssueAnswerBean.getIssue_answer_id())
				.setOperate_type("update")
				.setModule_id(goodsIssueAnswerBean.getIssue_answer_id()+"")
				.setModule_name("商品问答模块"));
		return goodsServiceC.updateGoodsIssueAnswer(goodsIssueAnswerBean);
	}
	
	/**
	 * 删除商品问答
	 * @param goodsIssueAnswerBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoodsIssueAnswer") 
    @AppController(isVerSystemToken=true)
    public Object deleteGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除商品回答，回答id为"+goodsIssueAnswerBean.getIssue_answer_id())
				.setOperate_type("delete")
				.setModule_id(goodsIssueAnswerBean.getIssue_answer_id()+"")
				.setModule_name("商品问答模块"));
		return goodsServiceC.deleteGoodsIssueAnswer(goodsIssueAnswerBean);
	}
	
}
