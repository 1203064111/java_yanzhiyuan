package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.MerchantsBalanceBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsBillBean;
import tst.project.bean.shop.MerchantsWithdrawalsBean;
import tst.project.page.PageBean;

@Mapper
public interface MerchantsDaoC {
	
	/**
	 * 商家不分页
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getMerchantssNoPage(MerchantsBean merchantsBean);
	
	/**
	 * 商家审核
	 * @author hwq
	 * @param merchantsBean
	 * @return
	 */
	public int auditMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 商家统计
	 * @author sjb
	 * @return
	 */
	public Map<String,Object> getMerchantsStatistics(MerchantsBean merchantsBean);
	
	/**
	 * 搜索商家主键 逗号隔开
	 * @param merchantsBean
	 * @return
	 */
	public String getMerchantsIds(MerchantsBean merchantsBean);
	
	/**
	 * 修改商家账单信息
	 * @param merchantsBillBean
	 * @return
	 */
	public int updateMerchantsBill(MerchantsBillBean merchantsBillBean);
	
	/**
	 * 申请提现详情
	 * @param merchantsWithdrawalsBean
	 * @return
	 */
	public MerchantsWithdrawalsBean getMerchantsWithdrawalsDetail(MerchantsWithdrawalsBean merchantsWithdrawalsBean);
	
	/**
	 * 修改申请信息
	 * @param merchantsWithdrawalsBean
	 * @return
	 */
	public int updateMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean);
	
	/**
	 * 商家提现列表
	 * @param merchantsWithdrawalsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsWithdrawalsBean> getMerchantsWithdrawalss(MerchantsWithdrawalsBean merchantsWithdrawalsBean,PageBean pageBean);
	
	/**
	 * 商家账单入库
	 * @param merchantsBillBean
	 * @return
	 */
	public int insertMerchantsBill(MerchantsBillBean merchantsBillBean);
	
	/**
	 * 商家申请提现入库
	 * @param merchantsWithdrawalsBean
	 * @return
	 */
	public int insertMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean);
	
	/**
	 * 修改商家的账号
	 * @param merchantsBalanceBean
	 * @return
	 */
	public int updateMerchantsBalance(MerchantsBalanceBean merchantsBalanceBean);
	
	/**
	 * 添加商家的账号
	 * @param merchantsBalanceBean
	 * @return
	 */
	public int insertMerchantsBalance(MerchantsBalanceBean merchantsBalanceBean);
	
	/**
	 * 商家的账号信息
	 * @param merchantsBalanceBean
	 * @return
	 */
	public MerchantsBalanceBean getMerchantsBalanceDetail(MerchantsBalanceBean merchantsBalanceBean);
	
	/**
	 * 商家账单列表
	 * @param merchantsBillBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBillBean> getMerchantsBills(MerchantsBillBean merchantsBillBean,PageBean pageBean);
	
	/**
	 * 商家列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBean> getMerchantss(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 商家详情
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean);
	
	/**
	 * 添加商家
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public int insertMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 修改商家
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public int updateMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 删除商家
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public int deleteMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 添加商家行业
	 * @param industryBean
	 * @return
	 */
	public int insertMerchantsIndustry(IndustryBean industryBean);
	
	/**
	 * 修改商家行业
	 * @param industryBean
	 * @return
	 */
	public int updateMerchantsIndustry(IndustryBean industryBean);
	
	/**
	 * 删除商家行业
	 * @param industryBean
	 * @return
	 */
	public int deleteMerchantsIndustrys(IndustryBean industryBean);
	
	/**
	 * 分类勾选的行业
	 * @param industryBean
	 * @return
	 */
	public List<IndustryBean> getMerchantsIndustrys(IndustryBean industryBean);
}
