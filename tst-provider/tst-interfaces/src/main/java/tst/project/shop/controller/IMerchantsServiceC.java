/**
 * 
 */
package tst.project.shop.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.MerchantsBalanceBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsBillBean;
import tst.project.bean.shop.MerchantsWithdrawalsBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IMerchantsServiceC {
	
	/**
	 * 商家不分页
	 * @author lx
	 * @param merchantsBean
	 * @return
	 */
	public Object getMerchantssNoPage(MerchantsBean merchantsBean);
	
	/**
	 * 商家审核
	 * @author hwq
	 * @param merchantsBean
	 * @return
	 */
	public Object auditMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 商家统计
	 * @author sjb
	 * @return
	 */
	public Map<String,Object> getMerchantsStatistics(MerchantsBean merchantsBean);
	
	/**
	 * 处理商家提现申请
	 * @return
	 */
	public Object handleMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean);
	
	/**
	 * 商家提现列表
	 * @param merchantsWithdrawalsBean
	 * @param pageBean
	 * @return
	 */
	public Object getMerchantsWithdrawalss(MerchantsWithdrawalsBean merchantsWithdrawalsBean,PageBean pageBean);
	
	/**
	 * 商家申请提现
	 * @param merchantsWithdrawalsBean
	 * @return
	 */
	public Object applyMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean);
	
	/**
	 * 商家的账号信息
	 * @param merchantsBalanceBean
	 * @return
	 */
	public Object getMerchantsBalanceDetail(MerchantsBalanceBean merchantsBalanceBean);
	
	/**
	 * 商家账单列表
	 * @param merchantsBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMerchantsBills(MerchantsBillBean merchantsBillBean,PageBean pageBean);
	
	/**
	 * 商家列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public Object getMerchantss(MerchantsBean merchantsBean,PageBean pageBean);

	
	
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


	

	
}

