package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.dao.controller.CreditGradesDaoC;
import tst.project.dao.interfaces.OrderDao;
import tst.project.page.PageBean;
import tst.project.shop.controller.ICreditGradesServiceC;

@Service
@Transactional(rollbackFor=Exception.class)
public class CreditGradesServiceC implements ICreditGradesServiceC {
	
	@Autowired
	CreditGradesDaoC creditGradesDaoC;
	
	@Autowired
	OrderDao orderDao;
	
	
	
	public Object getMemberCreditBills(MemberCreditBillBean memberCreditBillBean, PageBean pageBean) {
		List<MemberCreditBillBean> memberCreditBillBeans = orderDao.
				getMemberCredits(memberCreditBillBean, pageBean);
		if(memberCreditBillBeans != null) {
			for (int i = 0; i < memberCreditBillBeans.size(); i++) {
				MemberCreditBillBean memberCreditBillBean2 = memberCreditBillBeans.get(i);
				if(memberCreditBillBean2.getCredit_bill_type().equals("1")) {
					memberCreditBillBean2.setCredit_bill_price("+" + memberCreditBillBean2.getCredit_bill_price());
				}else {
					memberCreditBillBean2.setCredit_bill_price("-" + memberCreditBillBean2.getCredit_bill_price());
				}
			}
		}
		
		return pageBean.setObject(memberCreditBillBeans);
	}
	
	public Object getMemberBills(MemberBillBean memberBillBean, PageBean pageBean) {
		List<MemberBillBean> memberBillBeans = orderDao.getMemberBills(memberBillBean, pageBean);
		if(memberBillBeans != null) {
			for (int i = 0; i < memberBillBeans.size(); i++) {
				MemberBillBean memberBillBean2 = memberBillBeans.get(i);
				if(memberBillBean2.getBill_type().equals("2") ||
						memberBillBean2.getBill_type().equals("3")) {
					memberBillBean2.setBill_price("+" + memberBillBean2.getBill_price());
				}else {
					memberBillBean2.setBill_price("-" + memberBillBean2.getBill_price());
				}
			}
		}
		
		return pageBean.setObject(memberBillBeans);
	}
	
	public Object getMemberBillTotal(MemberBillBean memberBillBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBillBean> memberBillBeans = creditGradesDaoC
				.getMemberBillTotal(memberBillBean, pageBean);
		return pageBean.setObject(memberBillBeans);
	}

	public Object getMemberCreditBillTotal(MemberCreditBillBean memberCreditBillBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberCreditBillBean> memberCreditBillBeans = creditGradesDaoC
				.getMemberCreditBillTotal(memberCreditBillBean, pageBean);
		if(memberCreditBillBeans != null) {
			for (int i = 0; i < memberCreditBillBeans.size(); i++) {
				MemberCreditBillBean memberCreditBillBean2 = memberCreditBillBeans.get(i);
				if(memberCreditBillBean2.getCredit_bill_price() == null) {
					memberCreditBillBean2.setCredit_bill_price("0");
				}
			}
		}
		return pageBean.setObject(memberCreditBillBeans);
	}

	public Object getCreditGradess(CreditGradesBean creditGradesBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<CreditGradesBean> creditGradesBeans = creditGradesDaoC.getCreditGradess(creditGradesBean, pageBean);
		return pageBean.setObject(creditGradesBeans);
	}

	public Object getCreditGradesDetail(CreditGradesBean creditGradesBean) {
		// TODO Auto-generated method stub
		return creditGradesDaoC.getCreditGradesDetail(creditGradesBean);
	}

	public Object insertCreditGrades(CreditGradesBean creditGradesBean) {
		// TODO Auto-generated method stub
		int num = creditGradesDaoC.insertCreditGrades(creditGradesBean);
		if(num <= 0) {
			throw new AppException("添加失败");
		}
		
		return num;
	}

	public Object updateCreditGrades(CreditGradesBean creditGradesBean) {
		// TODO Auto-generated method stub
		int num = creditGradesDaoC.updateCreditGrades(creditGradesBean);
		if(num <= 0) {
			throw new AppException("修改失败");
		}
		
		return num;
	}

	public Object deleteCreditGrades(CreditGradesBean creditGradesBean) {
		// TODO Auto-generated method stub
		int num = creditGradesDaoC.deleteCreditGrades(creditGradesBean);
		if(num <= 0) {
			throw new AppException("删除失败");
		}
		
		return num;
	}


	public Object getMemberCredits(ShopMemberBean shopMemberBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ShopMemberBean> shopMemberBeans = creditGradesDaoC.getMemberCredits(shopMemberBean, pageBean);
		return pageBean.setObject(shopMemberBeans);
	}
	
	
	public Object getMemberCounts(MemberCreditBillBean memberCreditBillBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberCreditBillBean> memberCreditBillBeans = creditGradesDaoC.
				getMemberCounts(memberCreditBillBean, pageBean);
		if(memberCreditBillBeans != null) {
			for (int i = 0; i < memberCreditBillBeans.size(); i++) {
				MemberCreditBillBean memberCreditBillBean2 = memberCreditBillBeans.get(i);
				if(memberCreditBillBean2.getCredit_bill_type().equals("3")) {
					memberCreditBillBean2.setCredit_bill_price("-" + memberCreditBillBean2.getCredit_bill_price());
				}else {
					memberCreditBillBean2.setCredit_bill_price("+" + memberCreditBillBean2.getCredit_bill_price());
				}
			}
		}
		return pageBean.setObject(memberCreditBillBeans);
	}

	public Object getMemberCreditDetail(ShopMemberBean shopMemberBean) {
		// TODO Auto-generated method stub
		return creditGradesDaoC.getMemberCreditDetail(shopMemberBean);
	}
	
	
	@Override
	public Object getMemberLevels(MemberLevelBean memberLevelBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberLevelBean> memberLevelBeans = creditGradesDaoC.getMemberLevels(memberLevelBean, pageBean);
		return pageBean.setObject(memberLevelBeans);
	}

	@Override
	public Object getMemberLevelDetail(MemberLevelBean memberLevelBean) {
		// TODO Auto-generated method stub
		return creditGradesDaoC.getMemberLevelDetail(memberLevelBean);
	}

	@Override
	public Object insertMemberLevel(MemberLevelBean memberLevelBean) {
		// TODO Auto-generated method stub
		int num = creditGradesDaoC.insertMemberLevel(memberLevelBean);
		if(num <= 0) {
			throw new AppException("添加失败");
		}
		
		return num;
	}

	@Override
	public Object updateMemberLevel(MemberLevelBean memberLevelBean) {
		// TODO Auto-generated method stub
		int num = creditGradesDaoC.updateMemberLevel(memberLevelBean);
		if(num <= 0) {
			throw new AppException("修改失败");
		}
		
		return num;
	}

	@Override
	public Object deleteMemberLevel(MemberLevelBean memberLevelBean) {
		// TODO Auto-generated method stub
		int num = creditGradesDaoC.deleteMemberLevel(memberLevelBean);
		if(num <= 0) {
			throw new AppException("删除失败");
		}
		
		return num;
	}
	

}
