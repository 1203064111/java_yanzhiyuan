package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.ICreditGradesServiceC;

@Controller
@RequestMapping("/creditGradesController/v1.0")
public class CreditGradesController {
	
	@Autowired
	ICreditGradesServiceC creditGradesServiceC;
	
	
	
	
	
	@RequestMapping("/getMemberLevels")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberLevels(MemberLevelBean memberLevelBean, PageBean pageBean)
		throws Exception {
		return creditGradesServiceC.getMemberLevels(memberLevelBean, pageBean);
	}
	
	@RequestMapping("/getMemberLevelDetail")
	@AppController(isVerSystemToken=true)
	public Object getMemberLevelDetail(MemberLevelBean memberLevelBean)
		throws Exception {
		return creditGradesServiceC.getMemberLevelDetail(memberLevelBean);
	}
	
	@RequestMapping("/insertMemberLevel")
	@AppController(isVerSystemToken=true)
	public Object insertMemberLevel(MemberLevelBean memberLevelBean)
		throws Exception {
		return creditGradesServiceC.insertMemberLevel(memberLevelBean);
	}
	
	@RequestMapping("/updateMemberLevel")
	@AppController(isVerSystemToken=true)
	public Object updateMemberLevel(MemberLevelBean memberLevelBean)
		throws Exception {
		return creditGradesServiceC.updateMemberLevel(memberLevelBean);
	}
	
	@RequestMapping("/deleteMemberLevel")
	@AppController(isVerSystemToken=true)
	public Object deleteMemberLevel(MemberLevelBean memberLevelBean)
		throws Exception {
		return creditGradesServiceC.deleteMemberLevel(memberLevelBean);
	}
	
	@RequestMapping("/getMemberBills") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMemberBills(MemberBillBean memberBillBean, PageBean pageBean) throws Exception{
		return creditGradesServiceC.getMemberBills(memberBillBean, pageBean);
	}
	
	@RequestMapping("/getMemberCreditBills") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMemberCreditBills(MemberCreditBillBean memberCreditBillBean, PageBean pageBean) throws Exception{
		return creditGradesServiceC.getMemberCreditBills(memberCreditBillBean, pageBean);
	}
	
	@RequestMapping("/getMemberBillTotal") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMemberBillTotal(MemberBillBean memberBillBean, PageBean pageBean) throws Exception{
		return creditGradesServiceC.getMemberBillTotal(memberBillBean, pageBean);
	}
	
	@RequestMapping("/getMemberCreditBillTotal") 
	@AppController(isVerSystemToken=true,isPage=true) 
	public Object getMemberCreditBillTotal(MemberCreditBillBean memberCreditBillBean, PageBean pageBean) throws Exception{
		return creditGradesServiceC.getMemberCreditBillTotal(memberCreditBillBean, pageBean);
	}
	
	@RequestMapping("/getCreditGradess")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getCreditGradess(CreditGradesBean creditGradesBean, PageBean pageBean) 
			throws Exception {
		return creditGradesServiceC.getCreditGradess(creditGradesBean, pageBean);
	}
	
	@RequestMapping("/getMemberCounts")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberCounts(MemberCreditBillBean memberCreditBillBean, PageBean pageBean) 
			throws Exception {
		return creditGradesServiceC.getMemberCounts(memberCreditBillBean, pageBean);
	}
	
	@RequestMapping("/getMemberCredits")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberCredits(ShopMemberBean shopMemberBean, PageBean pageBean) 
			throws Exception {
		return creditGradesServiceC.getMemberCredits(shopMemberBean, pageBean);
	}
	
	@RequestMapping("/getMemberCreditDetail")
	@AppController(isVerSystemToken=true)
	public Object getMemberCreditDetail(ShopMemberBean shopMemberBean) 
			throws Exception {
		return creditGradesServiceC.getMemberCreditDetail(shopMemberBean);
	}
	
	@RequestMapping("/getCreditGradesDetail")
	@AppController(isVerSystemToken=true)
	public Object getCreditGradesDetail(CreditGradesBean creditGradesBean) 
			throws Exception {
		return creditGradesServiceC.getCreditGradesDetail(creditGradesBean);
	}
	
	@RequestMapping("/insertCreditGrades")
	@AppController(isVerSystemToken=true)
	public Object insertCreditGrades(CreditGradesBean creditGradesBean) 
			throws Exception {
		return creditGradesServiceC.insertCreditGrades(creditGradesBean);
	}
	
	
	@RequestMapping("/updateCreditGrades")
	@AppController(isVerSystemToken=true)
	public Object updateCreditGrades(CreditGradesBean creditGradesBean) 
			throws Exception {
		return creditGradesServiceC.updateCreditGrades(creditGradesBean);
	}
	
	@RequestMapping("/deleteCreditGrades")
	@AppController(isVerSystemToken=true)
	public Object deleteCreditGrades(CreditGradesBean creditGradesBean) 
			throws Exception {
		return creditGradesServiceC.deleteCreditGrades(creditGradesBean);
	}
	
	
	

}
