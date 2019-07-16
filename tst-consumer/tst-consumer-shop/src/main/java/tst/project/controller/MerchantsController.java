package tst.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import tst.project.aspect.AppController;
import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.MerchantsBalanceBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsBillBean;
import tst.project.bean.shop.MerchantsWithdrawalsBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;
import tst.project.shop.controller.IMerchantsServiceC;

@Controller
@RequestMapping("/merchantsController/v1.0")
public class MerchantsController {
	@Autowired
	IMerchantsServiceC merchantsServiceC;
	
	
	
	@Autowired
	ISystemService systemService;
	
	@RequestMapping("/auditMerchants") 
    @AppController(isVerSystemToken=true)
    public Object auditMerchants(MerchantsBean merchantsBean) throws Exception{ 
		return merchantsServiceC.auditMerchants(merchantsBean);
	}

	@RequestMapping("/getMerchantsStatistics") 
    @AppController(isVerSystemToken=true)
    public Object getMerchantsStatistics(MerchantsBean merchantsBean) throws Exception{ 
		return merchantsServiceC.getMerchantsStatistics(merchantsBean);
	}
	
	
	@RequestMapping("/handleMerchantsWithdrawals") 
    @AppController(isVerSystemToken=true)
    public Object handleMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean) throws Exception{ 
		return merchantsServiceC.handleMerchantsWithdrawals(merchantsWithdrawalsBean);
	}
	
	@RequestMapping("/getMerchantsWithdrawalss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getMerchantsWithdrawalss(MerchantsWithdrawalsBean merchantsWithdrawalsBean,PageBean pageBean) throws Exception{ 
		return merchantsServiceC.getMerchantsWithdrawalss(merchantsWithdrawalsBean,pageBean);
	}
	
	
	@RequestMapping("/applyMerchantsWithdrawals") 
    @AppController(isVerSystemToken=true)
    public Object applyMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean) throws Exception{ 
		return merchantsServiceC.applyMerchantsWithdrawals(merchantsWithdrawalsBean);
	}
	
	@RequestMapping("/getMerchantsBalanceDetail") 
    @AppController(isVerSystemToken=true)
    public Object getMerchantsBalanceDetail(MerchantsBalanceBean merchantsBalanceBean) throws Exception{ 
		return merchantsServiceC.getMerchantsBalanceDetail(merchantsBalanceBean);
	}
	
	
	@RequestMapping("/getMerchantsBills") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getMerchantsBills(MerchantsBillBean merchantsBillBean,PageBean pageBean) throws Exception{ 
		return merchantsServiceC.getMerchantsBills(merchantsBillBean,pageBean);
	}
	
	
	/**
	 * 商家列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMerchantss") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getMerchantss(MerchantsBean merchantsBean,PageBean pageBean) throws Exception{ 
		return merchantsServiceC.getMerchantss(merchantsBean,pageBean);
	}
	/**
	 * 商家列表 不分页
	 * @param merchantsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMerchantssNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getMerchantssNoPage(MerchantsBean merchantsBean) throws Exception{ 
		return merchantsServiceC.getMerchantssNoPage(merchantsBean);
	}
	/**
	 * 商家详情
	 * @param merchantsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMerchantsDetail") 
    @AppController(isVerSystemToken=true)
    public Object getMerchantsDetail(MerchantsBean merchantsBean) throws Exception{ 
		return merchantsServiceC.getMerchantsDetail(merchantsBean);
	}
	
	/**
	 * 添加商家
	 * @param merchantsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMerchants") 
    @AppController()
    public Object insertMerchants(MerchantsBean merchantsBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加商家，商家名称为"+merchantsBean.getMerchants_name())
				.setOperate_type("insert")
				.setModule_name("商家模块"));
		return merchantsServiceC.insertMerchants(merchantsBean);
	}
	
	/**
	 * 修改商家信息
	 * @param merchantsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMerchants") 
    @AppController(isVerSystemToken=true)
    public Object updateMerchants(MerchantsBean merchantsBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改商家信息，商家id为"+merchantsBean.getMerchants_id())
				.setOperate_type("update")
				.setModule_id(merchantsBean.getMerchants_id()+"")
				.setModule_name("商家模块"));
		return merchantsServiceC.updateMerchants(merchantsBean);
	}
	
	/**
	 * 删除商家
	 * @param merchantsBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteMerchants") 
    @AppController(isVerSystemToken=true)
    public Object deleteMerchants(MerchantsBean merchantsBean,HttpServletRequest request) throws Exception{ 
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除商家，商家id为"+merchantsBean.getMerchants_id())
				.setOperate_type("delete")
				.setModule_id(merchantsBean.getMerchants_id()+"")
				.setModule_name("商家模块"));
		return merchantsServiceC.deleteMerchants(merchantsBean);
	}
}
