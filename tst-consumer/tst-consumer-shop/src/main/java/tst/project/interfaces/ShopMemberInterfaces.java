package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.shop.interfaces.IShopMemberService;

@Controller
@RequestMapping("/shopMemberInterfaces/v1.0")
public class ShopMemberInterfaces {
	@Autowired
	IShopMemberService shopMemberService;

	@RequestMapping("/synchronizationMember") 
    @AppController(isLog=false)
	public Object synchronizationMember() {
		return shopMemberService.synchronizationMember();
	}
}
