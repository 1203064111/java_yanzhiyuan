package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IShopMemberServiceC;

@Controller
@RequestMapping("/shopMemberController/v1.0")
public class ShopMemberController {
	@Autowired
	IShopMemberServiceC shopMemebrServiceC;
	
	
	@RequestMapping("/getShopMembersKoubei") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getShopMembersKoubei(MemberBean memberBean,PageBean pageBean) throws Exception{ 
		return shopMemebrServiceC.getShopMembersKoubei(memberBean, pageBean);
	}
}
