package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.CreditGradesBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.MemberCreditBillBean;
import tst.project.bean.shop.MemberLevelBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;

@Mapper
public interface CreditGradesDaoC {
	
	
	
	/**
	 * 会员等级列表
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public List<MemberLevelBean> getMemberLevels(MemberLevelBean memberLevelBean, PageBean pageBean);
	
	/**
	 * 会员等级详情
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public MemberLevelBean getMemberLevelDetail(MemberLevelBean memberLevelBean);
	
	/**
	 * 添加会员等级
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public int insertMemberLevel(MemberLevelBean memberLevelBean);
	
	/**
	 * 修改会员等级
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public int updateMemberLevel(MemberLevelBean memberLevelBean);
	
	/**
	 * 删除会员等级
	 * @author hwq
	 * @param memberLevelBean
	 * @return
	 */
	public int deleteMemberLevel(MemberLevelBean memberLevelBean);
	
	
	/**
	 * 用户消费总额
	 * @author hwq
	 * @param memberBillBean
	 * @return
	 */
	public List<MemberBillBean> getMemberBillTotal(MemberBillBean memberBillBean, PageBean pageBean);
	
	/**
	 * 用户额度消费总额
	 * @author hwq
	 * @param memberBillBean
	 * @return
	 */
	public List<MemberCreditBillBean> getMemberCreditBillTotal(MemberCreditBillBean memberCreditBillBean, PageBean pageBean);
	
	/**
	 * 信用额度消费明细
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public List<MemberCreditBillBean> getMemberCounts(MemberCreditBillBean memberCreditBillBean, PageBean pageBean);
	
	/**
	 * 授信用户列表
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public List<ShopMemberBean> getMemberCredits(ShopMemberBean shopMemberBean, PageBean pageBean);
	
	/**
	 * 授信用户详情
	 * @author hwq
	 * @param shopMemberBean
	 * @return
	 */
	public List<ShopMemberBean> getMemberCreditDetail(ShopMemberBean shopMemberBean);
	
	
	/**
	 * 授信等级列表
	 * @author hwq
	 * @param creditGradesBean
	 * @param pageBean
	 * @return
	 */
	public List<CreditGradesBean> getCreditGradess(CreditGradesBean creditGradesBean, PageBean pageBean);
	
	/**
	 * 授信等级详情
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public CreditGradesBean getCreditGradesDetail(CreditGradesBean creditGradesBean);
	
	/**
	 * 添加授信等级
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public int insertCreditGrades(CreditGradesBean creditGradesBean);
	
	/**
	 * 修改授信等级
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public int updateCreditGrades(CreditGradesBean creditGradesBean);
	
	/**
	 * 删除授信等级
	 * @author hwq
	 * @param creditGradesBean
	 * @return
	 */
	public int deleteCreditGrades(CreditGradesBean creditGradesBean);	
	
	

}
