package tst.project.service.controller;

import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tst.project.aspect.AppException;
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
import tst.project.bean.shop.GoodsIssueAnswerBean;
import tst.project.bean.shop.GoodsIssueBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.GoodsSpecificationBean;
import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.MerchantsGoodsClassBean;
import tst.project.bean.shop.SpecificationBean;
import tst.project.controller.ISettingServiceC;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IGoodsServiceC;

@Service
@Transactional(rollbackFor=Exception.class)
public class GoodsServiceC implements IGoodsServiceC{

	@Autowired
	GoodsDaoC goodsDaoC;
	
	@Autowired
	ISettingServiceC settingServiceC;
	
	@Value("${goods_apply_state}")
	private String goods_apply_state;
	
	@Override
	public Map<String, Object> getGoodsStatistics(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsStatistics(goodsBean);
	}
	
	@Override
	public Object acceptGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.acceptGoods(goodsBean);
		if(num<=0){
			throw new AppException("审核失败");
		}
		return num;
	}
	
	@Override
	public Object refuseGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.refuseGoods(goodsBean);
		if(num<=0){
			throw new AppException("审核失败");
		}
		return num;
	}
	
	public List<Map<String, Object>> getGoodssGroupMerchants(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps=goodsDaoC.getGoodssGroupMerchants(goodsBean);
		if(maps!=null){
			for (int i = 0; i < maps.size(); i++) {
				Map<String, Object> map=maps.get(i);
				List<GoodsBean> goodsBeans=goodsDaoC.getGoodssNoPage(new GoodsBean().setGoods_ids(map.get("goods_ids")+""));
				map.put("goodsBeans", goodsBeans);
			}
		}
		return maps;
	}
	
	public List<GoodsBean> getGoodssNoPage(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodssNoPage(goodsBean);
	}
	
	/**
	 * 获得商品列表（除去存在的goods_ids）
	 * @author sjb
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public PageBean getGoodsOutIds(GoodsBean goodsBean,PageBean pageBean){
		List<GoodsBean> goodsBeans=goodsDaoC.getGoodsOutIds(goodsBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}
	
	public Object getGoodsClassOutMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) {
		List<GoodsClassBean> goodsClasss = goodsDaoC.getGoodsClassOutMarketings(goodsClassMarketingBean, pageBean);
		return pageBean.setObject(goodsClasss);
	}
	
	public Object moveGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) {
		// TODO Auto-generated method stub
		String sort=goodsClassMarketingBean.getSort();
		
		GoodsClassMarketingBean goodsClassMarketingBean2=goodsDaoC.getMoveGoodsClassMarketing(goodsClassMarketingBean);
		if(goodsClassMarketingBean2==null){
			throw new AppException("desc".equals(goodsClassMarketingBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateGoodsClassMarketing(goodsClassMarketingBean.setSort(goodsClassMarketingBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateGoodsClassMarketing(new GoodsClassMarketingBean()
										.setMarketing_id(goodsClassMarketingBean2.getMarketing_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}

	
	public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsClassMarketingBean> goodsClassMarketingBeans=goodsDaoC.getGoodsClassMarketings(goodsClassMarketingBean, pageBean);
		return pageBean.setObject(goodsClassMarketingBeans);
	}


	
	public int insertGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) {
		// TODO Auto-generated method stub
//		GoodsClassMarketingBean goodsClassMarketingBean2=goodsDaoC.getGoodsClassMarketingDetail(goodsClassMarketingBean);
//		if(goodsClassMarketingBean2!=null){
//			throw new AppException("该商品分类已添加!");
//		}
		int num=goodsDaoC.insertGoodsClassMarketing(goodsClassMarketingBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	public int deleteGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteGoodsClassMarketing(goodsClassMarketingBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	
	
	
	
	public Object moveGoodsMarketing(GoodsMarketingBean goodsMarketingBean) {
		// TODO Auto-generated method stub
		String sort=goodsMarketingBean.getSort();
		
		GoodsMarketingBean goodsMarketingBean2=goodsDaoC.getMoveGoodsMarketing(goodsMarketingBean);
		if(goodsMarketingBean2==null){
			throw new AppException("desc".equals(goodsMarketingBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateGoodsMarketing(goodsMarketingBean.setSort(goodsMarketingBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateGoodsMarketing(new GoodsMarketingBean()
										.setMarketing_id(goodsMarketingBean2.getMarketing_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}

	
	public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsMarketingBean> goodsMarketingBeans=goodsDaoC.getGoodsMarketings(goodsMarketingBean, pageBean);
		return pageBean.setObject(goodsMarketingBeans);
	}

	
	public Object getGoodsOutMarketing(GoodsMarketingBean goodsMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans=goodsDaoC.getGoodsOutMarketing(goodsMarketingBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}

	
	public int insertGoodsMarketings(GoodsMarketingBean goodsMarketingBean) {
		// TODO Auto-generated method stub
//		GoodsMarketingBean goodsMarketingBean2=goodsDaoC.getGoodsMarketingDetail(goodsMarketingBean);
//		if(goodsMarketingBean2!=null){
//			throw new AppException("该商品已添加!");
//		}
		int num=goodsDaoC.insertGoodsMarketings(goodsMarketingBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	public int deleteGoodsMarketing(GoodsMarketingBean goodsMarketingBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteGoodsMarketing(goodsMarketingBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	public List<BrandBean> getGoodsBrands(BrandBean brandBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsBrands(brandBean);
	}
	
	
	public Object getGoodsTags(GoodsClassTagBean goodsClassTagBean) {
		// TODO Auto-generated method stub
		List<GoodsClassTagBean> goodsClassTagBeans=goodsDaoC.getGoodsClassTags(goodsClassTagBean.setParent_id("-1"));
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				GoodsClassTagBean goodsClassTagBean2=goodsClassTagBeans.get(i);
				
				List<GoodsClassTagBean> goodsClassTagBeans2=goodsDaoC
						.getGoodsTags(goodsClassTagBean.setParent_id(goodsClassTagBean2.setClass_id(goodsClassTagBean.getClass_id()).getTag_id()+""));
				goodsClassTagBean2.setGoodsClassTagBeans(goodsClassTagBeans2);
			}
		}
		return goodsClassTagBeans;
	}
	
	
	public Object getGoodsSelectSpecifications(GoodsSpecificationBean goodsSpecificationBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsSelectSpecifications(goodsSpecificationBean);
	}

	
	public List<SpecificationBean> getGoodsSpecifications(SpecificationBean specificationBean) {		
		// TODO Auto-generated method stub
		List<SpecificationBean> specificationBeans=goodsDaoC
				.getGoodsClassSpecifications(specificationBean.setIs_check("1"));
		if(specificationBeans!=null){
			for (int i = 0; i < specificationBeans.size(); i++) {
				SpecificationBean specificationBean2=specificationBeans.get(i);
				List<SpecificationBean> specificationBeans2=goodsDaoC
						.getSpecificationsChild(new SpecificationBean()
								.setParent_id(specificationBean2.getSpecification_id()+"")
								.setGoods_id(specificationBean.getGoods_id()));
				specificationBean2.setSpecificationBeans(specificationBeans2);
			}
		}
		return specificationBeans;
	}
	

	public Object moveGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		String sort=goodsBean.getSort();
		
		GoodsBean goodsBean2=goodsDaoC.getMoveGoods(goodsBean);
		if(goodsBean2==null){
			throw new AppException("desc".equals(goodsBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateGoods(goodsBean.setSort(goodsBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateGoods(new GoodsBean()
										.setGoods_id(goodsBean2.getGoods_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}

	
	
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans=goodsDaoC.getGoodss(goodsBean, pageBean);
		
		return pageBean.setObject(goodsBeans);
	}

	
	public Object getGoodsWithSpecifications(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> goodsBeans=goodsDaoC.getGoodsWithSpecifications(goodsBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}

	
	public Object getGoodsDetail(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		GoodsBean goodsBean2=goodsDaoC.getGoodsDetail(goodsBean);
		return goodsBean2;
	}

	
	
	public int insertGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		String class_uuid=UUID.randomUUID().toString();
		if("1".equals(goodsBean.getGoods_type())){
			List<MerchantsGoodsClassBean> merchantsGoodsClassBeans = goodsDaoC.getMerchantsGoodsClasss(new MerchantsGoodsClassBean()
					.setMerchants_id(goodsBean.getMerchants_id())
					.setGoods_class_id(goodsBean.getClass_id()));
			if(CollectionUtils.isEmpty(merchantsGoodsClassBeans)){
				int num2 = goodsDaoC.insertMerchantsGoodsClass(new MerchantsGoodsClassBean().setMerchants_id(goodsBean.getMerchants_id())
						.setGoods_class_id(goodsBean.getClass_id()));
				if(num2<=0){
					throw new AppException("添加商家分类失败!");
				}
			}
		}
	
		int num=goodsDaoC.insertGoods(goodsBean
				.setClass_uuid(class_uuid));
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		
		return num;
	}


	
	public int updateGoods(GoodsBean goodsBean) {
		List<MerchantsGoodsClassBean> merchantsGoodsClassBeans = goodsDaoC.getMerchantsGoodsClasss(new MerchantsGoodsClassBean()
				.setMerchants_id(goodsBean.getMerchants_id())
				.setGoods_class_id(goodsBean.getClass_id()));
		if(CollectionUtils.isEmpty(merchantsGoodsClassBeans)){
			int num2 = goodsDaoC.insertMerchantsGoodsClass(new MerchantsGoodsClassBean().setMerchants_id(goodsBean.getMerchants_id())
					.setGoods_class_id(goodsBean.getClass_id()));
			if(num2<=0){
				throw new AppException("添加商家分类失败!");
			}
		}
		int num=goodsDaoC.updateGoods(goodsBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		
		return num;
	}

	public int updateGoodsState(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.updateGoods(goodsBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	public int deleteGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteGoods(goodsBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	
	public Object moveFreight(FreightBean freightBean) {
		// TODO Auto-generated method stub
		String sort=freightBean.getSort();
		
		FreightBean freightBean2=goodsDaoC.getMoveFreight(freightBean);
		if(freightBean2==null){
			throw new AppException("desc".equals(freightBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateFreight(freightBean.setSort(freightBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateFreight(new FreightBean()
										.setFreight_id(freightBean2.getFreight_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}


	
	public Object getFreights(FreightBean freightBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<FreightBean> freightBeans=goodsDaoC.getFreights(freightBean, pageBean);
		
		return pageBean.setObject(freightBeans);
	}
	
	public Object getFreightsNoPage(FreightBean freightBean) {
		// TODO Auto-generated method stub
		List<FreightBean> freightBeans=goodsDaoC.getFreightsNoPage(freightBean);
		return freightBeans;
	}


	
	public Object getFreightDetail(FreightBean freightBean) {
		// TODO Auto-generated method stub
		FreightBean freightBean2=goodsDaoC.getFreightDetail(freightBean);
		if(freightBean2!=null){
			List<FreightCityBean> freightCityBeans=goodsDaoC
					.getFreightCitys(new FreightCityBean().setFreight_id(freightBean.getFreight_id()+""));
			freightBean2.setFreightCityBeans(freightCityBeans);
			
			List<FreightFreeBean> freightFreeBeans=goodsDaoC.getFreightFrees(new FreightFreeBean().setFreight_id(freightBean.getFreight_id()+""));
			freightBean2.setFreightFreeBeans(freightFreeBeans);
		}
		return freightBean2;
	}


	
	public int insertFreight(FreightBean freightBean,List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.insertFreight(freightBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		if("1".equals(freightBean.getFreight_way())){
			if(freightCityBeans!=null){
				for (int i = 0; i < freightCityBeans.size(); i++) {
					FreightCityBean freightCityBean=freightCityBeans.get(i);
				
					num=goodsDaoC.insertFreightCity(freightCityBean.setFreight_id(freightBean.getFreight_id()+""));
					if(num<=0){
						throw new AppException("运费价格入库失败!");
					}
				}
			}
		
			if(freightFreeBeans!=null){
				for (int i = 0; i < freightFreeBeans.size(); i++) {
					FreightFreeBean freightFreeBean=freightFreeBeans.get(i);
					num=goodsDaoC.insertFreightFree(freightFreeBean.setFreight_id(freightBean.getFreight_id()+""));
					if(num<=0){
						throw new AppException("免运费入库失败!");
					}
				}
			}
		}
		return num;
	}


	
	public int updateFreight(FreightBean freightBean,List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans) {
		// TODO Auto-generated method stub
		
		int num=0;
		if("1".equals(freightBean.getFreight_way())){
			goodsDaoC.deleteFreightCitys(new FreightCityBean().setFreight_id(freightBean.getFreight_id()+""));
			if(freightCityBeans!=null){
				for (int i = 0; i < freightCityBeans.size(); i++) {
					FreightCityBean freightCityBean=freightCityBeans.get(i);
					
					if(freightCityBean.getFreight_city_id()==0){
						num=goodsDaoC.insertFreightCity(freightCityBean.setFreight_id(freightBean.getFreight_id()+""));
						if(num<=0){
							throw new AppException("运费价格入库失败!");
						}
					}else{
						num=goodsDaoC.updateFreightCity(freightCityBean);
						if(num<=0){
							throw new AppException("运费价格修改失败!");
						}
					}
				}
			}
			
			
			goodsDaoC.deleteFreightFrees(new FreightFreeBean().setFreight_id(freightBean.getFreight_id()+""));
			if(freightFreeBeans!=null){
				for (int i = 0; i < freightFreeBeans.size(); i++) {
					FreightFreeBean freightFreeBean=freightFreeBeans.get(i);
					if(freightFreeBean.getFreight_free_id()==0){
						num=goodsDaoC.insertFreightFree(freightFreeBean.setFreight_id(freightBean.getFreight_id()+""));
						if(num<=0){
							throw new AppException("免运费入库失败!");
						}
					}else{
						num=goodsDaoC.updateFreightFree(freightFreeBean);
						if(num<=0){
							throw new AppException("免运费修改失败!");
						}
					}
					
				}
			}
		}
		num=goodsDaoC.updateFreight(freightBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}


	
	public int deleteFreight(FreightBean freightBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteFreight(freightBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	
	
	public Object moveBrand(BrandBean brandBean) {
		// TODO Auto-generated method stub
		String sort=brandBean.getSort();
		
		BrandBean brandBean2=goodsDaoC.getMoveBrand(brandBean);
		if(brandBean2==null){
			throw new AppException("desc".equals(brandBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateBrand(brandBean.setSort(brandBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateBrand(new BrandBean()
										.setBrand_id(brandBean2.getBrand_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}
	
	
	
	public Object getBrands(BrandBean brandBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<BrandBean> brandBeans=goodsDaoC.getBrands(brandBean, pageBean);
		return pageBean.setObject(brandBeans);
	}


	
	public Object getBrandDetail(BrandBean brandBean) {
		// TODO Auto-generated method stub
		BrandBean brandBean2=goodsDaoC.getBrandDetail(brandBean);
		if(brandBean2!=null){
			List<GoodsClassBean> goodsClassBeans=goodsDaoC.getBrandClasss(new GoodsClassBean().setBrand_id(brandBean.getBrand_id()+""));
			brandBean2.setGoodsClassBeans(goodsClassBeans);
		}
		return brandBean2;
	}


	
	public int insertBrand(BrandBean brandBean,List<GoodsClassBean> goodsClassBeans) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.insertBrand(brandBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		
		if(goodsClassBeans!=null){
			for (int i = 0; i < goodsClassBeans.size(); i++) {
				GoodsClassBean goodsClassBean=goodsClassBeans.get(i);
				if("1".equals(goodsClassBean.getIs_check())){
					num=goodsDaoC.insertBrandClass(goodsClassBean.setBrand_id(brandBean.getBrand_id()+""));
					if(num<=0){
						throw new AppException("品牌分类添加失败!");
					}
				}
			}
		}
		
		return num;
	}


	
	public int updateBrand(BrandBean brandBean,List<GoodsClassBean> goodsClassBeans) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.updateBrand(brandBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		
		goodsDaoC.deleteBrandClass(new GoodsClassBean().setBrand_id(brandBean.getBrand_id()+""));
		if(goodsClassBeans!=null){
			for (int i = 0; i < goodsClassBeans.size(); i++) {
				GoodsClassBean goodsClassBean=goodsClassBeans.get(i);
				if("1".equals(goodsClassBean.getIs_check())){
					if(goodsClassBean.getClass_brand_id()==0){
						num=goodsDaoC.insertBrandClass(goodsClassBean.setBrand_id(brandBean.getBrand_id()+""));
						if(num<=0){
							throw new AppException("品牌分类添加失败!");
						}
					}else{
						num=goodsDaoC.updateBrandClass(goodsClassBean);
						if(num<=0){
							throw new AppException("品牌分类添加失败!");
						}
					}
					
				}
			}
		}
		return num;
	}


	
	public int deleteBrand(BrandBean brandBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteBrand(brandBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	
	public int insertSpecifications(List<SpecificationBean> specificationBeans) {
		// TODO Auto-generated method stub
		int num=0;
		goodsDaoC.deleteSpecifications(new SpecificationBean().setGoods_id("-1"));
		if(specificationBeans != null){
			for(SpecificationBean specificationBean : specificationBeans){
				List<SpecificationBean> specificationBeans2 = specificationBean.getSpecificationBeans();
				if(specificationBeans2 != null && specificationBeans2.size() > 0){
					if(specificationBean.getSpecification_id()==0){
						goodsDaoC.insertSpecification(specificationBean.setParent_id("-1").setGoods_id("-1"));
					}else{
						num = goodsDaoC.updateSpecification(specificationBean);
					}
				}
				for(SpecificationBean specificationBeans3 : specificationBeans2){
					if(specificationBeans3.getSpecification_id() == 0){
						num = goodsDaoC.insertSpecification(specificationBeans3.setParent_id
								(specificationBean.getSpecification_id()+"").setGoods_id("-1"));
					}else{
						num=goodsDaoC.updateSpecification(specificationBeans3);
					}
				}
			}
			
		}
		
		return num;
	}
	
	
	
	public List<SpecificationBean> getSpecifications(SpecificationBean specificationBean) {
		// TODO Auto-generated method stub
		/**
		 * 规格管理
		 * 条件:
		 * 		规格表中有两级规格
		 * 		只拿平台添加的规格,也就是 goods_id = -1
		 * 1.先拿第一级规格(parent_id = -1)
		 * 2.拿第二级子规格(子规格的parent_id 等于 一级规格的specification_id)
		 * 3.将子规格放进一级规格里面
		 */
		List<SpecificationBean> specifications = goodsDaoC.getSpecifications(specificationBean.setParent_id("-1").setGoods_id("-1"));
		if(specifications != null){
			for(SpecificationBean specification1 : specifications){
				List<SpecificationBean> specifications2 = goodsDaoC.getSpecifications(specificationBean.setParent_id(specification1.getSpecification_id()+""));
				specification1.setSpecificationBeans(specifications2);
			}
		}
		return specifications;
	}
	
	
	public Object moveIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		String sort=industryBean.getSort();
		
		IndustryBean industryBean2=goodsDaoC.getMoveIndustry(industryBean);
		if(industryBean2==null){
			throw new AppException("desc".equals(industryBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateIndustry(industryBean.setSort(industryBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateIndustry(new IndustryBean()
										.setIndustry_id(industryBean2.getIndustry_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}
	
	
	public Object getIndustrys(IndustryBean industryBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<IndustryBean> industryBeans=goodsDaoC.getIndustrys(industryBean, pageBean);
		return pageBean.setObject(industryBeans);
	}
	
	
	public Object getIndustrysNoPage(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		List<IndustryBean> industryBeans=goodsDaoC.getIndustrysNoPage(industryBean);
		return industryBeans;
	}
	
	
	public Object getIndustryDetail(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		IndustryBean industryBean2=goodsDaoC.getIndustryDetail(industryBean);
	
		return industryBean2;
	}

	
	public int insertIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub		
		int num=goodsDaoC.insertIndustry(industryBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	public int updateIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.updateIndustry(industryBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	
	public int deleteIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteIndustry(industryBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	
	public Object moveGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		String sort=goodsClassBean.getSort();
		
		GoodsClassBean goodsClassBean2=goodsDaoC.getMoveClass(goodsClassBean);
		if(goodsClassBean2==null){
			throw new AppException("desc".equals(goodsClassBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=goodsDaoC.updateGoodsClass(goodsClassBean.setSort(goodsClassBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=goodsDaoC.updateGoodsClass(new GoodsClassBean()
										.setClass_id(goodsClassBean2.getClass_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}
	
	
	public Object getGoodsClassLinks(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsClassLinks(goodsClassBean);
	}
	
	
	public Object getMerchantsGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getMerchantsGoodsClass(goodsClassBean);
	}
	
	
	public Object getGoodsClasss(GoodsClassBean goodsClassBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsClassBean> goodsClassBeans=goodsDaoC.getGoodsClasss(goodsClassBean, pageBean);
		
		return pageBean.setObject(goodsClassBeans);
	}

	
	public Object getGoodsClassDetail(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		GoodsClassBean goodsClassBean2=goodsDaoC.getGoodsClassDetail(goodsClassBean);
		return goodsClassBean2;
	}

	@Override
	public Object getGoodsClassIndustrys(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsClassIndustrys(industryBean);
	}
	public List<GoodsClassTagBean> getGoodsClassTags(GoodsClassTagBean goodsClassTagBean){
		List<GoodsClassTagBean> goodsClassTagBeans=goodsDaoC.getGoodsClassTags(goodsClassTagBean.setParent_id("-1"));
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				GoodsClassTagBean goodsClassTagBean2=goodsClassTagBeans.get(i);
				goodsClassTagBean2.setGoodsClassTagBeans(goodsDaoC
						.getGoodsClassTags(goodsClassTagBean.setParent_id(goodsClassTagBean2.setClass_id(goodsClassTagBean.getClass_id()).getTag_id()+"")));
			}
		}
		return goodsClassTagBeans;
	}
	
	
	
	public int insertGoodsClass(GoodsClassBean goodsClassBean) {
		UUID uuid=UUID.randomUUID();
		int num=goodsDaoC.insertGoodsClass(goodsClassBean.setClass_uuid(uuid.toString()));
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		
		return num;
	}

	
	public int updateGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.updateGoodsClass(goodsClassBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	
	public int deleteGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		int num=goodsDaoC.deleteGoodsClass(goodsClassBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	

	public PageBean getShopOutOneYuanGoods(String goods_ids, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ZMActivityGoodsBean> GoodsBeans = goodsDaoC.getShopOutOneYuanGoods(goods_ids, pageBean);
		return pageBean.setObject(GoodsBeans);
	}

	public List<ZMActivityGoodsBean> getCheckedGoods(String goods_ids) {
		// TODO Auto-generated method stub
		List<ZMActivityGoodsBean> checkedGoods = goodsDaoC.getCheckedGoods(goods_ids);
		return checkedGoods;
	}

	@Override
	public Object getGoodsAssessments(GoodsAssessmentBean goodsAssessmentBean, PageBean pageBean) {
		List<GoodsAssessmentBean> goodsAssessmentBeans =goodsDaoC.getGoodsAssessments(goodsAssessmentBean, pageBean);
		
		return pageBean.setObject(goodsAssessmentBeans);
	}

	@Override
	public Object deleteGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean) {
		int num = goodsDaoC.deleteGoodsAssessment(goodsAssessmentBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object updateGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean) {
		int num = goodsDaoC.updateGoodsAssessment(goodsAssessmentBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object getGoodsAssessmentDetail(GoodsAssessmentBean goodsAssessmentBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsAssessmentDetail(goodsAssessmentBean);
	}

	@Override
	public Object getGoodsClasssNoPage(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsClasssNoPage(goodsClassBean);
	}

	@Override
	public Object getGoodsIssues(GoodsIssueBean goodsIssueBean, PageBean pageBean) {
		List<GoodsIssueBean> goodsIssueBeans =goodsDaoC.getGoodsIssues(goodsIssueBean, pageBean);
		
		
		// TODO Auto-generated method stub
		return pageBean.setObject(goodsIssueBeans);
	}

	@Override
	public Object getGoodsIssueAnswers(GoodsIssueAnswerBean goodsIssueAnswerBean, PageBean pageBean) {
		List<GoodsIssueAnswerBean> goodsIssueAnswerBeans = goodsDaoC.getGoodsIssueAnswers(goodsIssueAnswerBean, pageBean);
		
		// TODO Auto-generated method stub
		return pageBean.setObject(goodsIssueAnswerBeans);
	}

	@Override
	public Object updateGoodsIssue(GoodsIssueBean goodsIssueBean) {
		int num = goodsDaoC.updateGoodsIssue(goodsIssueBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object updateGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean) {
		int num = goodsDaoC.updateGoodsIssueAnswer(goodsIssueAnswerBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object deleteGoodsIssue(GoodsIssueBean goodsIssueBean) {
		int num = goodsDaoC.deleteGoodsIssue(goodsIssueBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object deleteGoodsIssueAnswer(GoodsIssueAnswerBean goodsIssueAnswerBean) {
		int num = goodsDaoC.deleteGoodsIssueAnswer(goodsIssueAnswerBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object getGoodsAssessmentsByParent(GoodsAssessmentBean goodsAssessmentBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(goodsDaoC.getGoodsAssessmentsByParent(goodsAssessmentBean, pageBean));
	}

	@Override
	public Object insertGoodsAssessment(GoodsAssessmentBean goodsAssessmentBean) {
		int num = goodsDaoC.insertGoodsAssessment(goodsAssessmentBean);
		if(num <= 0){
			throw new AppException("回复失败");
		}
		return num;
	}

	
}
