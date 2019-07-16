package tst.project.service.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
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
import tst.project.controller.ISettingServiceC;
import tst.project.dao.controller.BaikeDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IBaikeServiceC;

@Service
@Transactional(rollbackFor=Exception.class)
public class BaikeServiceC implements IBaikeServiceC{

	@Autowired
	BaikeDaoC BaikeDaoC;
	
	@Autowired
	ISettingServiceC settingServiceC;
	
	@Value("${goods_apply_state}")
	private String goods_apply_state;
	
	@Override
	public Map<String, Object> getGoodsStatistics(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getGoodsStatistics(goodsBean);
	}
	
	@Override
	public Object acceptGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.acceptGoods(goodsBean);
		if(num<=0){
			throw new AppException("审核失败");
		}
		return num;
	}
	
	@Override
	public Object refuseGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.refuseGoods(goodsBean);
		if(num<=0){
			throw new AppException("审核失败");
		}
		return num;
	}
	
	public List<Map<String, Object>> getGoodssGroupMerchants(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps=BaikeDaoC.getGoodssGroupMerchants(goodsBean);
		if(maps!=null){
			for (int i = 0; i < maps.size(); i++) {
				Map<String, Object> map=maps.get(i);
				List<GoodsBean> goodsBeans=BaikeDaoC.getGoodssNoPage(new GoodsBean().setGoods_ids(map.get("goods_ids")+""));
				map.put("goodsBeans", goodsBeans);
			}
		}
		return maps;
	}
	
	public List<GoodsBean> getGoodssNoPage(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getGoodssNoPage(goodsBean);
	}
	
	/**
	 * 获得商品列表（除去存在的goods_ids）
	 * @author sjb
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public PageBean getGoodsOutIds(GoodsBean goodsBean,PageBean pageBean){
		List<GoodsBean> goodsBeans=BaikeDaoC.getGoodsOutIds(goodsBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}
	
	public Object getGoodsClassOutMarketings(GoodsClassMarketingBean goodsClassMarketingBean,PageBean pageBean) {
		List<GoodsClassBean> goodsClasss = BaikeDaoC.getGoodsClassOutMarketings(goodsClassMarketingBean, pageBean);
		return pageBean.setObject(goodsClasss);
	}
	
	public Object moveGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) {
		// TODO Auto-generated method stub
		String sort=goodsClassMarketingBean.getSort();
		
		GoodsClassMarketingBean goodsClassMarketingBean2=BaikeDaoC.getMoveGoodsClassMarketing(goodsClassMarketingBean);
		if(goodsClassMarketingBean2==null){
			throw new AppException("desc".equals(goodsClassMarketingBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateGoodsClassMarketing(goodsClassMarketingBean.setSort(goodsClassMarketingBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateGoodsClassMarketing(new GoodsClassMarketingBean()
										.setMarketing_id(goodsClassMarketingBean2.getMarketing_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}

	
	public Object getGoodsClassMarketings(GoodsClassMarketingBean goodsClassMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsClassMarketingBean> goodsClassMarketingBeans=BaikeDaoC.getGoodsClassMarketings(goodsClassMarketingBean, pageBean);
		return pageBean.setObject(goodsClassMarketingBeans);
	}


	
	public int insertGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) {
		// TODO Auto-generated method stub
//		GoodsClassMarketingBean goodsClassMarketingBean2=BaikeDaoC.getGoodsClassMarketingDetail(goodsClassMarketingBean);
//		if(goodsClassMarketingBean2!=null){
//			throw new AppException("该商品分类已添加!");
//		}
		int num=BaikeDaoC.insertGoodsClassMarketing(goodsClassMarketingBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	public int deleteGoodsClassMarketing(GoodsClassMarketingBean goodsClassMarketingBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.deleteGoodsClassMarketing(goodsClassMarketingBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	
	
	
	
	public Object moveGoodsMarketing(GoodsMarketingBean goodsMarketingBean) {
		// TODO Auto-generated method stub
		String sort=goodsMarketingBean.getSort();
		
		GoodsMarketingBean goodsMarketingBean2=BaikeDaoC.getMoveGoodsMarketing(goodsMarketingBean);
		if(goodsMarketingBean2==null){
			throw new AppException("desc".equals(goodsMarketingBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateGoodsMarketing(goodsMarketingBean.setSort(goodsMarketingBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateGoodsMarketing(new GoodsMarketingBean()
										.setMarketing_id(goodsMarketingBean2.getMarketing_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}

	
	public Object getGoodsMarketings(GoodsMarketingBean goodsMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsMarketingBean> goodsMarketingBeans=BaikeDaoC.getGoodsMarketings(goodsMarketingBean, pageBean);
		return pageBean.setObject(goodsMarketingBeans);
	}

	
	public Object getGoodsOutMarketing(GoodsMarketingBean goodsMarketingBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans=BaikeDaoC.getGoodsOutMarketing(goodsMarketingBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}

	
	public int insertGoodsMarketings(GoodsMarketingBean goodsMarketingBean) {
		// TODO Auto-generated method stub
//		GoodsMarketingBean goodsMarketingBean2=BaikeDaoC.getGoodsMarketingDetail(goodsMarketingBean);
//		if(goodsMarketingBean2!=null){
//			throw new AppException("该商品已添加!");
//		}
		int num=BaikeDaoC.insertGoodsMarketings(goodsMarketingBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	public int deleteGoodsMarketing(GoodsMarketingBean goodsMarketingBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.deleteGoodsMarketing(goodsMarketingBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	public List<BrandBean> getGoodsBrands(BrandBean brandBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getGoodsBrands(brandBean);
	}
	
	
	public Object getGoodsTags(GoodsClassTagBean goodsClassTagBean) {
		// TODO Auto-generated method stub
		List<GoodsClassTagBean> goodsClassTagBeans=BaikeDaoC.getGoodsClassTags(goodsClassTagBean.setParent_id("-1"));
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				GoodsClassTagBean goodsClassTagBean2=goodsClassTagBeans.get(i);
				
				List<GoodsClassTagBean> goodsClassTagBeans2=BaikeDaoC
						.getGoodsTags(goodsClassTagBean.setParent_id(goodsClassTagBean2.setClass_id(goodsClassTagBean.getClass_id()).getTag_id()+""));
				goodsClassTagBean2.setGoodsClassTagBeans(goodsClassTagBeans2);
			}
		}
		return goodsClassTagBeans;
	}
	
	
	public Object getGoodsSelectSpecifications(GoodsSpecificationBean goodsSpecificationBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getGoodsSelectSpecifications(goodsSpecificationBean);
	}

	
	public List<SpecificationBean> getGoodsSpecifications(SpecificationBean specificationBean) {		
		// TODO Auto-generated method stub
		List<SpecificationBean> specificationBeans=BaikeDaoC
				.getGoodsClassSpecifications(specificationBean.setIs_check("1"));
		if(specificationBeans!=null){
			for (int i = 0; i < specificationBeans.size(); i++) {
				SpecificationBean specificationBean2=specificationBeans.get(i);
				List<SpecificationBean> specificationBeans2=BaikeDaoC
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
		
		GoodsBean goodsBean2=BaikeDaoC.getMoveGoods(goodsBean);
		if(goodsBean2==null){
			throw new AppException("desc".equals(goodsBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateGoods(goodsBean.setSort(goodsBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateGoods(new GoodsBean()
										.setGoods_id(goodsBean2.getGoods_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}

	
	
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans=BaikeDaoC.getGoodss(goodsBean, pageBean);
		
		return pageBean.setObject(goodsBeans);
	}

	
	public Object getGoodsWithSpecifications(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> goodsBeans=BaikeDaoC.getGoodsWithSpecifications(goodsBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}

	
	public Object getGoodsDetail(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		GoodsBean goodsBean2=BaikeDaoC.getGoodsDetail(goodsBean);
		if(goodsBean2!=null){
			List<GoodsImgBean> goodsImgBeans=BaikeDaoC.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBean2.getGoods_id()+""));
			goodsBean2.setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBean2;
	}

	
	
	public int insertGoods(GoodsBean goodsBean,
				List<SpecificationBean> specificationBeans,
				List<GoodsSpecificationBean> goodsSpecificationBeans,
				List<GoodsClassTagBean> goodsClassTagBeans,
				List<BrandBean> brandBeans,
				List<GoodsImgBean> goodsImgBeans) {
		// TODO Auto-generated method stub
		String class_uuid=UUID.randomUUID().toString();
		int num=BaikeDaoC.insertGoods(goodsBean
				.setClass_uuid(class_uuid)
				.setApply_state(goods_apply_state));
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		if(goodsImgBeans!=null){
			for (int i = 0; i < goodsImgBeans.size()-1; i++) {
				GoodsImgBean goodsImgBean=goodsImgBeans.get(i);
				num=BaikeDaoC.insertGoodsImg(goodsImgBean.setGoods_id(goodsBean.getGoods_id()+""));
				if(num<=0){
					throw new AppException("商品图片添加失败!");
				}
			}
		}
		
		if(brandBeans!=null){
			for (int i = 0; i < brandBeans.size(); i++) {
				BrandBean brandBean=brandBeans.get(i);
				if("1".equals(brandBean.getIs_check())){
					num=BaikeDaoC.insertGoodsBrand(brandBean.setGoods_id(goodsBean.getGoods_id()+""));
					if(num<=0){
						throw new AppException("品牌添加失败!");
					}
				}
			}
		}
		
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				List<GoodsClassTagBean> goodsClassTagBeans2=goodsClassTagBeans.get(i).getGoodsClassTagBeans();
				for (int j = 0; j < goodsClassTagBeans2.size(); j++) {
					
					GoodsClassTagBean goodsClassTagBean=goodsClassTagBeans2.get(j);
					if("1".equals(goodsClassTagBean.getIs_check())){
						num=BaikeDaoC.insertGoodsTag(goodsClassTagBean.setGoods_id(goodsBean.getGoods_id()+""));
						if(num<=0){
							throw new AppException("商品标签添加失败!");
						}			
					}
				}
			}
		}
		
//		if(specificationBeans!=null){
//			for (int i = 0; i < specificationBeans.size(); i++) {
//				List<SpecificationBean> specificationBeans2=specificationBeans.get(i).getSpecificationBeans();
//				for (int j = 0; j < specificationBeans2.size(); j++) {
//					SpecificationBean specificationBean=specificationBeans2.get(j);
//					if(specificationBean.getSpecification_id()==0){
//						num=BaikeDaoC.insertSpecification(specificationBean
//								.setParent_id(specificationBeans.get(i).getSpecification_id()+"")
//								.setGoods_id(goodsBean.getGoods_id()+""));
//						if(num<=0){
//							throw new AppException("系统规格添加失败!");
//						}
//					}
//				}
//			}
//		}
		
//		int goods_stock = 0;// 商品库存
//		double min_price = 0; //规格最低价
//		double max_price = 0; //规格最搞价
//		String goods_now_price=""; //商品现价
//		double wholesale_min_price = 0; //批发最低价
//		double wholesale_max_price = 0; //批发最高价
//		String goods_wholesale_price=""; //商品批发价

//		if(goodsSpecificationBeans!=null){
//			for (int i = 0; i < goodsSpecificationBeans.size(); i++) {
//				GoodsSpecificationBean goodsSpecificationBean = goodsSpecificationBeans.get(i);
//				
//				String ids="";
//				String[] skua=goodsSpecificationBean.getSpecification_names().split(",");
//				for (int l = 0; l < skua.length; l++) {
//					for (int h = 0; h < specificationBeans.size(); h++) {
//						List<SpecificationBean> specificationBeans2=specificationBeans.get(h).getSpecificationBeans();
//						if(specificationBeans2!=null&&specificationBeans2.size()>0){
//							for (int j = 0; j < specificationBeans2.size(); j++) {
//								SpecificationBean specificationBean2=specificationBeans2.get(j);
//								if(skua[l].equals(specificationBean2.getSpecification_value())){
//									ids+=specificationBean2.getSpecification_id()+",";
//									break;
//								}
//							}
//						}
//					}
//				}
//				
//				goodsSpecificationBean.setSpecification_ids(ids.length()>0?ids.substring(0,ids.length()-1):"");
//				
//				goods_stock += NumberUtils.Integer(goodsSpecificationBean.getSpecification_stock());
//
//				if (i == 0) {
//					min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					wholesale_min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//					wholesale_max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//				} else {
//					if (min_price > NumberUtils.Double(goodsSpecificationBean.getSpecification_price())) {// 替换最小价格
//						min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					}
//					if (max_price < NumberUtils.Double(goodsSpecificationBean.getSpecification_price())) {
//						max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					}
//					if (wholesale_min_price > NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price())) {// 替换最小价格
//						wholesale_min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//					}
//					if (wholesale_max_price < NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price())) {
//						wholesale_max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//					}
//				}
//				
//				num = BaikeDaoC.insertGoodsSpecification(
//						goodsSpecificationBean.setGoods_id(goodsBean.getGoods_id() + ""));
//				if (num <= 0) {
//					throw new AppException("规格添加失败");
//				}
//			}
//			
//			goods_now_price = min_price + "";
//			if (min_price != max_price) {
//				goods_now_price = min_price + "~" + max_price;
//			}
//			goods_wholesale_price = wholesale_min_price + "";
//			if (wholesale_min_price != wholesale_max_price) {
//				goods_wholesale_price = wholesale_min_price + "~" + wholesale_max_price;
//			}
//			
//			num=BaikeDaoC.updateGoods(new GoodsBean().setGoods_id(goodsBean.getGoods_id())
//													 .setGoods_stock(goods_stock+"")
//													 .setGoods_now_price(goods_now_price)
//													 .setGoods_min_price(min_price+"")
//													 .setGoods_max_price(max_price+"")
//													 .setGoods_wholesale_price(goods_wholesale_price)
//													 .setGoods_wholesale_min_price(wholesale_min_price+"")
//													 .setGoods_wholesale_max_price(wholesale_max_price+""));
//			if(num<=0){
//				throw new AppException("商品信息更新失败");
//			}
//		}
		
		return num;
	}


	
	public int updateGoods(GoodsBean goodsBean,
							List<SpecificationBean> specificationBeans,
							List<GoodsSpecificationBean> goodsSpecificationBeans,
							List<GoodsClassTagBean> goodsClassTagBeans,
							List<BrandBean> brandBeans,
							List<GoodsImgBean> goodsImgBeans) {
		// TODO Auto-generated method stub
		if("1".equals(goods_apply_state)){//不需要审核的平台
			goodsBean.setApply_state("");
		}
		int num=BaikeDaoC.updateGoods(goodsBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		
		BaikeDaoC.deleteGoodsImgs(new GoodsImgBean().setGoods_id(goodsBean.getGoods_id()+""));
		if(goodsImgBeans!=null){
			for (int i = 0; i < goodsImgBeans.size()-1; i++) {
				GoodsImgBean goodsImgBean=goodsImgBeans.get(i);
				if(goodsImgBean.getGoods_img_id()==0){
					num=BaikeDaoC.insertGoodsImg(goodsImgBean.setGoods_id(goodsBean.getGoods_id()+""));
					if(num<=0){
						throw new AppException("商品图片添加失败!");
					}
				}else{
					num=BaikeDaoC.updateGoodsImg(goodsImgBean);
					if(num<=0){
						throw new AppException("商品图片修改失败!");
					}
				}	
			}
		}
		
		BaikeDaoC.deleteGoodsBrands(new BrandBean().setGoods_id(goodsBean.getGoods_id()+""));
		if(brandBeans!=null){
			for (int i = 0; i < brandBeans.size(); i++) {
				BrandBean brandBean=brandBeans.get(i);
				if("1".equals(brandBean.getIs_check())){
					if(brandBean.getGoods_brand_id()==0){
						num=BaikeDaoC.insertGoodsBrand(brandBean.setGoods_id(goodsBean.getGoods_id()+""));
						if(num<=0){
							throw new AppException("品牌添加失败!");
						}
					}else{
						num=BaikeDaoC.updateGoodsBrand(brandBean);
						if(num<=0){
							throw new AppException("品牌修改失败!");
						}
					}	
				}
			}
		}
		
		BaikeDaoC.deleteGoodsTags(new GoodsClassTagBean().setGoods_id(goodsBean.getGoods_id()+""));
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				List<GoodsClassTagBean> goodsClassTagBeans2=goodsClassTagBeans.get(i).getGoodsClassTagBeans();
				for (int j = 0; j < goodsClassTagBeans2.size(); j++) {
					GoodsClassTagBean goodsClassTagBean=goodsClassTagBeans2.get(j);
					if("1".equals(goodsClassTagBean.getIs_check())){
						if(goodsClassTagBean.getGoods_tag_id()==0){
							num=BaikeDaoC.insertGoodsTag(goodsClassTagBean.setGoods_id(goodsBean.getGoods_id()+""));
							if(num<=0){
								throw new AppException("商品标签添加失败!");
							}	
						}else{
							num=BaikeDaoC.updateGoodsTag(goodsClassTagBean);
							if(num<=0){
								throw new AppException("商品标签修改失败!");
							}	
						}
								
					}
				}
			}
		}
		
		
//		BaikeDaoC.deleteSpecifications(new SpecificationBean().setGoods_id(goodsBean.getGoods_id()+""));
//		if(specificationBeans!=null){
//			for (int i = 0; i < specificationBeans.size(); i++) {
//				List<SpecificationBean> specificationBeans2=specificationBeans.get(i).getSpecificationBeans();
//				for (int j = 0; j < specificationBeans2.size(); j++) {
//					SpecificationBean specificationBean=specificationBeans2.get(j);
//					if(specificationBean.getSpecification_id()==0){
//						num=BaikeDaoC.insertSpecification(specificationBean
//								.setParent_id(specificationBeans.get(i).getSpecification_id()+"")
//								.setGoods_id(goodsBean.getGoods_id()+""));
//						if(num<=0){
//							throw new AppException("系统规格添加失败!");
//						}
//					}else{
//						num=BaikeDaoC.updateSpecification(specificationBean);
//						if(num<=0){
//							throw new AppException("系统规格添加失败!");
//						}
//					}
//				}
//			}
//		}
//		
//		
//		int goods_stock = 0;// 商品库存
//		double min_price = 0;
//		double max_price = 0;
//		String goods_now_price="";
//		
//		double wholesale_min_price = 0; //批发最低价
//		double wholesale_max_price = 0; //批发最高价
//		String goods_wholesale_price=""; //商品批发价
//		
//		BaikeDaoC.deleteGoodsSpecifications(new GoodsSpecificationBean().setGoods_id(goodsBean.getGoods_id()+""));
//		if(goodsSpecificationBeans!=null){
//			for (int i = 0; i < goodsSpecificationBeans.size(); i++) {
//				GoodsSpecificationBean goodsSpecificationBean = goodsSpecificationBeans.get(i);
//				
//				String ids="";
//				String[] skua=goodsSpecificationBean.getSpecification_names().split(",");
//				
//				for (int l = 0; l < skua.length; l++) {
//					for (int h = 0; h < specificationBeans.size(); h++) {
//						List<SpecificationBean> specificationBeans2=specificationBeans.get(h).getSpecificationBeans();
//						if(specificationBeans2!=null&&specificationBeans2.size()>0){
//							for (int j = 0; j < specificationBeans2.size(); j++) {
//								SpecificationBean specificationBean2=specificationBeans2.get(j);
//								if(skua[l].equals(specificationBean2.getSpecification_value())){
//									ids+=specificationBean2.getSpecification_id()+",";
//									break;
//								}
//							}
//						}
//					}
//				}
//			
//				goodsSpecificationBean.setSpecification_ids(ids.length()>0?ids.substring(0,ids.length()-1):"");
//				
//				goods_stock += NumberUtils.Integer(goodsSpecificationBean.getSpecification_stock());
//
//				if (i == 0) {
//					min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					wholesale_min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//					wholesale_max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//				} else {
//					if (min_price > NumberUtils.Double(goodsSpecificationBean.getSpecification_price())) {// 替换最小价格
//						min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					}
//					if (max_price < NumberUtils.Double(goodsSpecificationBean.getSpecification_price())) {
//						max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_price());
//					}
//					if (wholesale_min_price > NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price())) {// 替换最小价格
//						wholesale_min_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//					}
//					if (wholesale_max_price < NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price())) {
//						wholesale_max_price = NumberUtils.Double(goodsSpecificationBean.getSpecification_wholesale_price());
//					}
//				}
//				
//				if(goodsSpecificationBean.getSpecification_id()==0){
//					num = BaikeDaoC.insertGoodsSpecification(
//							goodsSpecificationBean.setGoods_id(goodsBean.getGoods_id() + ""));
//					if (num <= 0) {
//						throw new AppException("规格添加失败");
//					}
//				}else{
//					num = BaikeDaoC.updateGoodsSpecification(
//							goodsSpecificationBean.setGoods_id(goodsBean.getGoods_id() + ""));
//					if (num <= 0) {
//						throw new AppException("规格修改失败");
//					}
//				}
//				
//			}
//			
//			goods_now_price = min_price + "";
//			if (min_price != max_price) {
//				goods_now_price = min_price + "~" + max_price;
//			}
//			
//			goods_wholesale_price = wholesale_min_price + "";
//			if (wholesale_min_price != wholesale_max_price) {
//				goods_wholesale_price = wholesale_min_price + "~" + wholesale_max_price;
//			}
//			
//			num=BaikeDaoC.updateGoods(new GoodsBean().setGoods_id(goodsBean.getGoods_id())
//													 .setGoods_stock(goods_stock+"")
//													 .setGoods_now_price(goods_now_price)
//													 .setGoods_min_price(min_price+"")
//													 .setGoods_max_price(max_price+"")
//													 .setGoods_wholesale_price(goods_wholesale_price)
//													 .setGoods_wholesale_min_price(wholesale_min_price+"")
//													 .setGoods_wholesale_max_price(wholesale_max_price+""));
//			if(num<=0){
//				throw new AppException("商品信息更新失败");
//			}
//		}
		return num;
	}

	public int updateGoodsState(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.updateGoods(goodsBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	public int deleteGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.deleteGoods(goodsBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	
	public Object moveFreight(FreightBean freightBean) {
		// TODO Auto-generated method stub
		String sort=freightBean.getSort();
		
		FreightBean freightBean2=BaikeDaoC.getMoveFreight(freightBean);
		if(freightBean2==null){
			throw new AppException("desc".equals(freightBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateFreight(freightBean.setSort(freightBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateFreight(new FreightBean()
										.setFreight_id(freightBean2.getFreight_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}


	
	public Object getFreights(FreightBean freightBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<FreightBean> freightBeans=BaikeDaoC.getFreights(freightBean, pageBean);
		
		return pageBean.setObject(freightBeans);
	}
	
	public Object getFreightsNoPage(FreightBean freightBean) {
		// TODO Auto-generated method stub
		List<FreightBean> freightBeans=BaikeDaoC.getFreightsNoPage(freightBean);
		return freightBeans;
	}


	
	public Object getFreightDetail(FreightBean freightBean) {
		// TODO Auto-generated method stub
		FreightBean freightBean2=BaikeDaoC.getFreightDetail(freightBean);
		if(freightBean2!=null){
			List<FreightCityBean> freightCityBeans=BaikeDaoC
					.getFreightCitys(new FreightCityBean().setFreight_id(freightBean.getFreight_id()+""));
			freightBean2.setFreightCityBeans(freightCityBeans);
			
			List<FreightFreeBean> freightFreeBeans=BaikeDaoC.getFreightFrees(new FreightFreeBean().setFreight_id(freightBean.getFreight_id()+""));
			freightBean2.setFreightFreeBeans(freightFreeBeans);
		}
		return freightBean2;
	}


	
	public int insertFreight(FreightBean freightBean,List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.insertFreight(freightBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		if("1".equals(freightBean.getFreight_way())){
			if(freightCityBeans!=null){
				for (int i = 0; i < freightCityBeans.size(); i++) {
					FreightCityBean freightCityBean=freightCityBeans.get(i);
				
					num=BaikeDaoC.insertFreightCity(freightCityBean.setFreight_id(freightBean.getFreight_id()+""));
					if(num<=0){
						throw new AppException("运费价格入库失败!");
					}
				}
			}
		
			if(freightFreeBeans!=null){
				for (int i = 0; i < freightFreeBeans.size(); i++) {
					FreightFreeBean freightFreeBean=freightFreeBeans.get(i);
					num=BaikeDaoC.insertFreightFree(freightFreeBean.setFreight_id(freightBean.getFreight_id()+""));
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
			BaikeDaoC.deleteFreightCitys(new FreightCityBean().setFreight_id(freightBean.getFreight_id()+""));
			if(freightCityBeans!=null){
				for (int i = 0; i < freightCityBeans.size(); i++) {
					FreightCityBean freightCityBean=freightCityBeans.get(i);
					
					if(freightCityBean.getFreight_city_id()==0){
						num=BaikeDaoC.insertFreightCity(freightCityBean.setFreight_id(freightBean.getFreight_id()+""));
						if(num<=0){
							throw new AppException("运费价格入库失败!");
						}
					}else{
						num=BaikeDaoC.updateFreightCity(freightCityBean);
						if(num<=0){
							throw new AppException("运费价格修改失败!");
						}
					}
				}
			}
			
			
			BaikeDaoC.deleteFreightFrees(new FreightFreeBean().setFreight_id(freightBean.getFreight_id()+""));
			if(freightFreeBeans!=null){
				for (int i = 0; i < freightFreeBeans.size(); i++) {
					FreightFreeBean freightFreeBean=freightFreeBeans.get(i);
					if(freightFreeBean.getFreight_free_id()==0){
						num=BaikeDaoC.insertFreightFree(freightFreeBean.setFreight_id(freightBean.getFreight_id()+""));
						if(num<=0){
							throw new AppException("免运费入库失败!");
						}
					}else{
						num=BaikeDaoC.updateFreightFree(freightFreeBean);
						if(num<=0){
							throw new AppException("免运费修改失败!");
						}
					}
					
				}
			}
		}
		num=BaikeDaoC.updateFreight(freightBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}


	
	public int deleteFreight(FreightBean freightBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.deleteFreight(freightBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	
	
	public Object moveBrand(BrandBean brandBean) {
		// TODO Auto-generated method stub
		String sort=brandBean.getSort();
		
		BrandBean brandBean2=BaikeDaoC.getMoveBrand(brandBean);
		if(brandBean2==null){
			throw new AppException("desc".equals(brandBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateBrand(brandBean.setSort(brandBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateBrand(new BrandBean()
										.setBrand_id(brandBean2.getBrand_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}
	
	
	
	public Object getBrands(BrandBean brandBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<BrandBean> brandBeans=BaikeDaoC.getBrands(brandBean, pageBean);
		return pageBean.setObject(brandBeans);
	}


	
	public Object getBrandDetail(BrandBean brandBean) {
		// TODO Auto-generated method stub
		BrandBean brandBean2=BaikeDaoC.getBrandDetail(brandBean);
		if(brandBean2!=null){
			List<GoodsClassBean> goodsClassBeans=BaikeDaoC.getBrandClasss(new GoodsClassBean().setBrand_id(brandBean.getBrand_id()+""));
			brandBean2.setGoodsClassBeans(goodsClassBeans);
		}
		return brandBean2;
	}


	
	public int insertBrand(BrandBean brandBean,List<GoodsClassBean> goodsClassBeans) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.insertBrand(brandBean);
		if(num<=0){
			throw new AppException("添加失败");
		}
		
		if(goodsClassBeans!=null){
			for (int i = 0; i < goodsClassBeans.size(); i++) {
				GoodsClassBean goodsClassBean=goodsClassBeans.get(i);
				if("1".equals(goodsClassBean.getIs_check())){
					num=BaikeDaoC.insertBrandClass(goodsClassBean.setBrand_id(brandBean.getBrand_id()+""));
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
		int num=BaikeDaoC.updateBrand(brandBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		
		BaikeDaoC.deleteBrandClass(new GoodsClassBean().setBrand_id(brandBean.getBrand_id()+""));
		if(goodsClassBeans!=null){
			for (int i = 0; i < goodsClassBeans.size(); i++) {
				GoodsClassBean goodsClassBean=goodsClassBeans.get(i);
				if("1".equals(goodsClassBean.getIs_check())){
					if(goodsClassBean.getClass_brand_id()==0){
						num=BaikeDaoC.insertBrandClass(goodsClassBean.setBrand_id(brandBean.getBrand_id()+""));
						if(num<=0){
							throw new AppException("品牌分类添加失败!");
						}
					}else{
						num=BaikeDaoC.updateBrandClass(goodsClassBean);
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
		int num=BaikeDaoC.deleteBrand(brandBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	
	public int insertSpecifications(List<SpecificationBean> specificationBeans) {
		// TODO Auto-generated method stub
		int num=0;
		BaikeDaoC.deleteSpecifications(new SpecificationBean().setGoods_id("-1"));
		if(specificationBeans != null){
			for(SpecificationBean specificationBean : specificationBeans){
				List<SpecificationBean> specificationBeans2 = specificationBean.getSpecificationBeans();
				if(specificationBeans2 != null && specificationBeans2.size() > 0){
					if(specificationBean.getSpecification_id()==0){
						BaikeDaoC.insertSpecification(specificationBean.setParent_id("-1").setGoods_id("-1"));
					}else{
						num = BaikeDaoC.updateSpecification(specificationBean);
					}
				}
				for(SpecificationBean specificationBeans3 : specificationBeans2){
					if(specificationBeans3.getSpecification_id() == 0){
						num = BaikeDaoC.insertSpecification(specificationBeans3.setParent_id
								(specificationBean.getSpecification_id()+"").setGoods_id("-1"));
					}else{
						num=BaikeDaoC.updateSpecification(specificationBeans3);
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
		List<SpecificationBean> specifications = BaikeDaoC.getSpecifications(specificationBean.setParent_id("-1").setGoods_id("-1"));
		if(specifications != null){
			for(SpecificationBean specification1 : specifications){
				List<SpecificationBean> specifications2 = BaikeDaoC.getSpecifications(specificationBean.setParent_id(specification1.getSpecification_id()+""));
				specification1.setSpecificationBeans(specifications2);
			}
		}
		return specifications;
	}
	
	
	public Object moveIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		String sort=industryBean.getSort();
		
		IndustryBean industryBean2=BaikeDaoC.getMoveIndustry(industryBean);
		if(industryBean2==null){
			throw new AppException("desc".equals(industryBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateIndustry(industryBean.setSort(industryBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateIndustry(new IndustryBean()
										.setIndustry_id(industryBean2.getIndustry_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}
	
	
	public Object getIndustrys(IndustryBean industryBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<IndustryBean> industryBeans=BaikeDaoC.getIndustrys(industryBean, pageBean);
		return pageBean.setObject(industryBeans);
	}
	
	
	public Object getIndustrysNoPage(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		List<IndustryBean> industryBeans=BaikeDaoC.getIndustrysNoPage(industryBean);
		return industryBeans;
	}
	
	
	public Object getIndustryDetail(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		IndustryBean industryBean2=BaikeDaoC.getIndustryDetail(industryBean);
	
		return industryBean2;
	}

	
	public int insertIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub		
		int num=BaikeDaoC.insertIndustry(industryBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	public int updateIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.updateIndustry(industryBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	
	public int deleteIndustry(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.deleteIndustry(industryBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	
	
	public Object moveGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		String sort=goodsClassBean.getSort();
		
		GoodsClassBean goodsClassBean2=BaikeDaoC.getMoveClass(goodsClassBean);
		if(goodsClassBean2==null){
			throw new AppException("desc".equals(goodsClassBean.getSort_type())?"已置顶":"已到底");
		}
		
		int num=BaikeDaoC.updateGoodsClass(goodsClassBean.setSort(goodsClassBean2.getSort()));
		if(num<=0){
			throw new AppException("移动失败!");
		}
		
		num=BaikeDaoC.updateGoodsClass(new GoodsClassBean()
										.setClass_id(goodsClassBean2.getClass_id())
										.setSort(sort));
		if(num<=0){
			throw new AppException("移动失败");
		}
		return "移动成功";
	}
	
	
	public Object getGoodsClassLinks(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getGoodsClassLinks(goodsClassBean);
	}
	
	
	public Object getMerchantsGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getMerchantsGoodsClass(goodsClassBean);
	}
	
	@Override
	public Object getBaikeClasss(BaikeClassBean baikeClassBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<BaikeClassBean> baikeClassBeans=BaikeDaoC.getBaikeClasss(baikeClassBean, pageBean);
		return pageBean.setObject(baikeClassBeans);
	}

	@Override
	public Object getBaikeClassDetail(BaikeClassBean baikeClassBean) {
		// TODO Auto-generated method stub
		BaikeClassBean baikeClassBean2=BaikeDaoC.getBaikeClassDetail(baikeClassBean);
		return baikeClassBean2;
	}

	@Override
	public Object getGoodsClassIndustrys(IndustryBean industryBean) {
		// TODO Auto-generated method stub
		return BaikeDaoC.getGoodsClassIndustrys(industryBean);
	}
	public List<GoodsClassTagBean> getGoodsClassTags(GoodsClassTagBean goodsClassTagBean){
		List<GoodsClassTagBean> goodsClassTagBeans=BaikeDaoC.getGoodsClassTags(goodsClassTagBean.setParent_id("-1"));
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				GoodsClassTagBean goodsClassTagBean2=goodsClassTagBeans.get(i);
				goodsClassTagBean2.setGoodsClassTagBeans(BaikeDaoC
						.getGoodsClassTags(goodsClassTagBean.setParent_id(goodsClassTagBean2.setClass_id(goodsClassTagBean.getClass_id()).getTag_id()+"")));
			}
		}
		return goodsClassTagBeans;
	}
	
	
	
	public int insertGoodsClass(GoodsClassBean goodsClassBean,
								List<GoodsClassTagBean> goodsClassTagBeans,
								List<IndustryBean> industryBeans,
								List<SpecificationBean> specificationBeans) {
		// TODO Auto-generated method stub
		UUID uuid=UUID.randomUUID();
		
		int num=BaikeDaoC.insertGoodsClass(goodsClassBean.setClass_uuid(uuid.toString()));
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		
//		if(specificationBeans!=null){
//			for (int i = 0; i < specificationBeans.size(); i++) {
//				SpecificationBean specificationBean=specificationBeans.get(i);
//				if("1".equals(specificationBean.getIs_check())){
//					num=BaikeDaoC.insertGoodsClassSpecification(specificationBean.setClass_id(goodsClassBean.getClass_id()+""));
//					if(num<=0){
//						throw new AppException("分类规格添加失败!");
//					}
//				}
//			}
//		}
		
		if(industryBeans!=null){
			for (int i = 0; i < industryBeans.size(); i++) {
				IndustryBean industryBean=industryBeans.get(i);
				if("1".equals(industryBean.getIs_check())){
					num=BaikeDaoC.insertGoodsClassIndustry(industryBean.setClass_id(goodsClassBean.getClass_id()+""));
					if(num<=0){
						throw new AppException("分类行业添加失败!");
					}
				}
			}
		}
		
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				GoodsClassTagBean goodsClassTagBean=goodsClassTagBeans.get(i);				
				List<GoodsClassTagBean> goodsClassTagBeans2=goodsClassTagBean.getGoodsClassTagBeans();
				if(goodsClassTagBeans2!=null&&goodsClassTagBeans2.size()>0){
					num=BaikeDaoC.insertGoodsClassTag(goodsClassTagBean.setTag_uuid(UUID.randomUUID().toString()).setClass_id(goodsClassBean.getClass_id()+"").setParent_id("-1"));
					if(num<=0){
						throw new AppException("父标签添加失败!");
					}
					
					for (int j = 0; j < goodsClassTagBeans2.size(); j++) {
						GoodsClassTagBean goodsClassTagBean2=goodsClassTagBeans2.get(j);
						num=BaikeDaoC.insertGoodsClassTag(goodsClassTagBean2
								.setTag_uuid(UUID.randomUUID().toString())
								.setClass_id(goodsClassBean.getClass_id()+"")
								.setParent_id(goodsClassTagBean.getTag_id()+""));
						if(num<=0){
							throw new AppException("子标签添加失败!");
						}
					}
				}
			}
		}
		
		return num;
	}

	
	public int updateGoodsClass(GoodsClassBean goodsClassBean,
								List<GoodsClassTagBean> goodsClassTagBeans,
								List<IndustryBean> industryBeans,
								List<SpecificationBean> specificationBeans) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.updateGoodsClass(goodsClassBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		
		
//		BaikeDaoC.deleteGoodsClassSpecifications(new SpecificationBean().setClass_id(goodsClassBean.getClass_id()+""));
//		if(specificationBeans!=null){
//			for (int i = 0; i < specificationBeans.size(); i++) {
//				SpecificationBean specificationBean=specificationBeans.get(i);
//				if("1".equals(specificationBean.getIs_check())){
//					if(specificationBean.getClass_specification_id()==0){
//						num=BaikeDaoC.insertGoodsClassSpecification(specificationBean.setClass_id(goodsClassBean.getClass_id()+""));
//						if(num<=0){
//							throw new AppException("分类规格添加失败!");
//						}
//					}else{
//						num=BaikeDaoC.insertGoodsClassSpecification(specificationBean.setClass_id(goodsClassBean.getClass_id()+""));
//						if(num<=0){
//							throw new AppException("分类规格修改失败!");
//						}
//					}
//				}
//			}
//		}
		
		
		BaikeDaoC.deleteGoodsClassIndustrys(new IndustryBean().setClass_id(goodsClassBean.getClass_id()+""));
		if(industryBeans!=null){
			for (int i = 0; i < industryBeans.size(); i++) {
				IndustryBean industryBean=industryBeans.get(i);
				if("1".equals(industryBean.getIs_check())){
					if(industryBean.getClass_industry_id()==0){
						num=BaikeDaoC.insertGoodsClassIndustry(industryBean.setClass_id(goodsClassBean.getClass_id()+""));
						if(num<=0){
							throw new AppException("分类行业添加失败!");
						}
					}else{
						num=BaikeDaoC.updateGoodsClassIndustry(industryBean);
						if(num<=0){
							throw new AppException("分类行业添加失败!");
						}
					}
				}
			}
		}
		
		BaikeDaoC.deleteGoodsClassTags(new GoodsClassTagBean().setClass_id(goodsClassBean.getClass_id()+""));
		if(goodsClassTagBeans!=null){
			for (int i = 0; i < goodsClassTagBeans.size(); i++) {
				GoodsClassTagBean goodsClassTagBean=goodsClassTagBeans.get(i);
				
				List<GoodsClassTagBean> goodsClassTagBeans2=goodsClassTagBean.getGoodsClassTagBeans();
				if(goodsClassTagBeans2!=null&&goodsClassTagBeans2.size()>0){
					if(goodsClassTagBean.getTag_id()==0){
						num=BaikeDaoC.insertGoodsClassTag(goodsClassTagBean.setTag_uuid(UUID.randomUUID().toString()).setClass_id(goodsClassBean.getClass_id()+"").setParent_id("-1"));
						if(num<=0){
							throw new AppException("父标签添加失败!");
						}
						
					}else{
						num=BaikeDaoC.updateGoodsClassTag(goodsClassTagBean);
						if(num<=0){
							throw new AppException("父标签修改失败!");
						}
					}
					
					
					for (int j = 0; j < goodsClassTagBeans2.size(); j++) {
						GoodsClassTagBean goodsClassTagBean2=goodsClassTagBeans2.get(j);
						if(goodsClassTagBean2.getTag_id()==0){
							num=BaikeDaoC.insertGoodsClassTag(goodsClassTagBean2
									.setTag_uuid(UUID.randomUUID().toString())
									.setClass_id(goodsClassBean.getClass_id()+"")
									.setParent_id(goodsClassTagBean.getTag_id()+""));
							if(num<=0){
								throw new AppException("子标签添加失败!");
							}
						}else{
							num=BaikeDaoC.updateGoodsClassTag(goodsClassTagBean2);
							if(num<=0){
								throw new AppException("子标签修改失败!");
							}
						}
					}
				}
			}
		}
		
		return num;
	}

	
	public int deleteGoodsClass(GoodsClassBean goodsClassBean) {
		// TODO Auto-generated method stub
		int num=BaikeDaoC.deleteGoodsClass(goodsClassBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	

	public PageBean getShopOutOneYuanGoods(String goods_ids, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ZMActivityGoodsBean> GoodsBeans = BaikeDaoC.getShopOutOneYuanGoods(goods_ids, pageBean);
		return pageBean.setObject(GoodsBeans);
	}

	public List<ZMActivityGoodsBean> getCheckedGoods(String goods_ids) {
		// TODO Auto-generated method stub
		List<ZMActivityGoodsBean> checkedGoods = BaikeDaoC.getCheckedGoods(goods_ids);
		return checkedGoods;
	}

	@Override
	public Object updateBaikeClass(BaikeClassBean baikeClassBean) {
		int num = BaikeDaoC.updateBaikeClass(baikeClassBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertBaikeClass(BaikeClassBean baikeClassBean) {
		int num = BaikeDaoC.insertBaikeClass(baikeClassBean);
		if(num <= 0){
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deleteBaikeClass(BaikeClassBean baikeClassBean) {
		int num = BaikeDaoC.deleteBaikeClass(baikeClassBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}
	
	
}
