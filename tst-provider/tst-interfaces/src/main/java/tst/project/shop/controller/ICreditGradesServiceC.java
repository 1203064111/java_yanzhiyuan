package tst.project.shop.controller;

import java.util.List;

import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;

public interface ICreditGradesServiceC {
	
	
	/**
	 * 会员等级列表
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public Object getMemberLevels(MemberLevelBean memberLevelBean, PageBean pageBean);
	
	/**
	 * 会员等级详情
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public Object getMemberLevelDetail(MemberLevelBean memberLevelBean);
	
	/**
	 * 添加会员等级
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public Object insertMemberLevel(MemberLevelBean memberLevelBean);
	
	/**
	 * 修改会员等级
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public Object updateMemberLevel(MemberLevelBean memberLevelBean);
	
	/**
	 * 删除会员等级
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public Object deleteMemberLevel(MemberLevelBean memberLevelBean);
	
	
	/**
	 * 用户消费明细
	 * @author hwq
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberBills(MemberBillBean memberBillBean, PageBean pageBean);
	
	/**
	 * 用户额度消费明细
	 * @author hwq
	 * @param memberCreditBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberCreditBills(MemberCreditBillBean memberCreditBillBean, PageBean pageBean);
	
	/**
	 * 用户消费总额
	 * @author hwq
	 * @param memberBillBean
	 * @return
	 */
	public Object getMemberBillTotal(MemberBillBean memberBillBean, PageBean pageBean);
	
	/**
	 * 用户额度消费总额
	 * @author hwq
	 * @param memberBillBean
	 * @return
	 */
	public Object getMemberCreditBillTotal(MemberCreditBillBean memberCreditBillBean, PageBean pageBean);
	
	/**
	 * 信用额度消费明细
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public Object getMemberCounts(MemberCreditBillBean memberCreditBillBean, PageBean pageBean);
	
	
	/**
	 * 授信用户列表
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public Object getMemberCredits(ShopMemberBean shopMemberBean, PageBean pageBean);
	
	/**
	 * 授信用户详情
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public Object getMemberCreditDetail(ShopMemberBean shopMemberBean);
	
	
	/**
	 * 授信等级列表
	 * @author hwq
	 * @param creditGradesBean
	 * @param pageBean
	 * @return
	 */
	public Object getCreditGradess(CreditGradesBean creditGradesBean, PageBean pageBean);
	
	/**
	 * 授信等级详情
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public Object getCreditGradesDetail(CreditGradesBean creditGradesBean);
	
	/**
	 * 添加授信等级
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public Object insertCreditGrades(CreditGradesBean creditGradesBean);
	
	/**
	 * 修改授信等级
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public Object updateCreditGrades(CreditGradesBean creditGradesBean);
	
	/**
	 * 删除授信等级
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public Object deleteCreditGrades(CreditGradesBean creditGradesBean);	
	
	
	

}
