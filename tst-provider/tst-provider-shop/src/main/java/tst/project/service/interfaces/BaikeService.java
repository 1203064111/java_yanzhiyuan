package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tst.project.aspect.AppException;
import tst.project.bean.shop.BaikeClassBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.bean.shop.GoodsMarketingBean;
import tst.project.bean.shop.MemberSearchBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.SearchHotBean;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.interfaces.BaikeDao;
import tst.project.dao.interfaces.GoodsDao;
import tst.project.dao.interfaces.MerchantsDao;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IBaikeService;

@Service
@Transactional(rollbackFor = Exception.class)
public class BaikeService implements IBaikeService {

	
	@Autowired
	BaikeDao baikeDao;
	
	@Autowired
	GoodsDao goodsDao;
	@Autowired
	GoodsDaoC goodsDaoC;

	@Autowired
	MerchantsDao merchantsDao;
	
	@Override
	public Object getBaikeClasses(BaikeClassBean baikeClassBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<BaikeClassBean> baikeClassBeans  = baikeDao.getBaikeClasses(baikeClassBean, pageBean);
		return pageBean.setObject(baikeClassBeans);
	}

	@Override
	public Object getBaikeClassesByParentId(BaikeClassBean baikeClassBean, PageBean pageBean) {
		List<BaikeClassBean> baikeClassBeans  = baikeDao.getBaikeClassesByParentId(baikeClassBean, pageBean);
		return pageBean.setObject(baikeClassBeans);
	}

	@Override
	public Object getBaikeClassDetail(BaikeClassBean baikeClassBean) {
		// TODO Auto-generated method stub
		return baikeDao.getBaikeClassDetail(baikeClassBean);
	}

	@Override
	public Object getMemberSearchs(MemberSearchBean memberSearchBean) {
		
		return baikeDao.getMemberSearchs(memberSearchBean);
	}
	@Override
	public Object deleteMemberSearchs(MemberSearchBean memberSearchBean) {
		int num = baikeDao.deleteMemberSearchs(memberSearchBean);
		if(num <= 0){
			throw new AppException("删除失败!");
		}
		return num;
	}
	
	@Override
	public Object getSearchHots(SearchHotBean searchHotBean) {
		// TODO Auto-generated method stub
		return baikeDao.getSearchHots(searchHotBean);
	}

	@Override
	public Object getGoodsBySearch(GoodsBean goodsBean, PageBean pageBean) {
		//同一用户搜索的相同关键词不再添加
		List<MemberSearchBean> memberSearchBeans = baikeDao.getMemberSearchByMemberAndKey(new MemberSearchBean()
				.setMember_id(goodsBean.getMember_id()).setSearch_name(goodsBean.getSearch_key()));
		if(CollectionUtils.isEmpty(memberSearchBeans)){
			int num = baikeDao.insertMemberSearch(new MemberSearchBean().setMember_id(goodsBean.getMember_id())
					.setSearch_name(goodsBean.getSearch_key()));
			if(num <= 0){
				throw new AppException("添加搜索记录失败");
			}
		}
		
		return pageBean.setObject(baikeDao.getGoodsBySearch(goodsBean, pageBean));
	}

	@Override
	public Object getMerchantsBySearch(MerchantsBean merchantsBean, PageBean pageBean) {
		List<MerchantsBean> merchantsBeans = baikeDao.getMerchantsBySearch(merchantsBean, pageBean);
		for (int i = 0; i < merchantsBeans.size(); i++) {
			MerchantsBean merchantsBean2 = merchantsBeans.get(i);
			List<GoodsMarketingBean> goodsMarketingBeans = goodsDaoC.getGoodsMarketings(new GoodsMarketingBean()
					.setMerchants_id(merchantsBean2.getMerchants_id()+"").setMarketing_type("2"),new PageBean().setPageSize(2));
			merchantsBean2.setGoodsMarketingBeans(goodsMarketingBeans);
		}
		return pageBean.setObject(merchantsBeans);
	}

}
