package tst.project.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.dao.interfaces.ShopMemberDao;
import tst.project.interfaces.IMemberService;
import tst.project.shop.interfaces.IShopMemberService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ShopMemberService implements IShopMemberService {
	@Autowired
	ShopMemberDao shopMemberDao;
	
	@Autowired
	IMemberService memberService;
	
	
	
	@Override
	public Object synchronizationMember() {
		// TODO Auto-generated method stub
		List<MemberBean> memberBeans=memberService.getSynchronizationMembers(new MemberBean());
		if(memberBeans!=null){
			List<ShopMemberBean> shopMemberBeans=new ArrayList<ShopMemberBean>();
			String member_ids="";
			for (int i = 0; i < memberBeans.size(); i++) {
				MemberBean memberBean=memberBeans.get(i);
				member_ids+=memberBean.getMember_id()+",";
				ShopMemberBean shopMemberBean=new ShopMemberBean().setMember_id(memberBean.getMember_id()+"");
				shopMemberBeans.add(shopMemberBean);
			}
			if(shopMemberBeans.size()>0){
				int num=shopMemberDao.synchronizationMembers(shopMemberBeans);
				if(num<=0){
					throw new AppException("同步失败!");
				}
				
				num=memberService.updateSynchronizationMembers(member_ids);
				if(num<=0){
					throw new AppException("同步失败");
				}
			}
		}
		return 1;
	}
}
