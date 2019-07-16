package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.controller.IMemberServiceC;
import tst.project.dao.controller.MerchantsDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopMemberServiceC;
import tst.project.utils.NumberUtils;
import tst.project.utils.StringUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class ShopMemberServiceC implements IShopMemberServiceC{
	@Autowired
	IMemberServiceC memberServiceC;
	
	@Autowired
	MerchantsDaoC merchantsDaoC;
	
	@Override
	public Object getShopMembersKoubei(MemberBean memberBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		if(!StringUtils.isNull(memberBean.getTengxun_im_account())){
			String merchants_ids=merchantsDaoC.getMerchantsIds(new MerchantsBean()
					.setMerchants_name(memberBean.getTengxun_im_account()));
			memberBean.setFill_invitation_code(merchants_ids);
		}
		
		PageBean pageBean2=(PageBean) memberServiceC.getMembers(memberBean, pageBean);
		List<MemberBean> memberBeans=(List<MemberBean>) pageBean2.getObject();
		if(memberBeans!=null){
			for (int i = 0; i < memberBeans.size(); i++) {
				MemberBean memberBean2=memberBeans.get(i);
				String fill_invitation_code=memberBean2.getFill_invitation_code();
				MerchantsBean merchantsBean=merchantsDaoC
						.getMerchantsDetail(new MerchantsBean().setMerchants_id(NumberUtils.Integer(fill_invitation_code)));
				if(merchantsBean!=null){
					memberBean2.setTengxun_im_account(merchantsBean.getMerchants_name());
				}else{
					memberBean2.setTengxun_im_account("平台");
				}
			}	
		}
		return pageBean2;
	}
}
