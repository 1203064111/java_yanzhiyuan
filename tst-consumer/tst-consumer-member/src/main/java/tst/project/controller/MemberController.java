package tst.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.aspect.AppException;
import tst.project.bean.excel.ExcelBean;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;
import tst.project.utils.ExcelUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/memberController/v1.0")
public class MemberController {
	
	@Autowired
	IMemberServiceC memberServiceC;
	
	@Autowired
	ISystemService systemService;
	
	@Value("${img_path}")
	private String img_path;
	
	
	/**
	 * 导出用户列表
	 * @param request
	 * @param memberBean
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportMembers")
	@AppController(isVerSystemToken=true)
	public Object exportMembers(HttpServletRequest request,MemberBean memberBean
			,HttpServletResponse response) throws Exception {
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("用户ID").setType("member_id"));
		excelBeans.add(new ExcelBean().setName("用户账号").setType("member_account"));
		excelBeans.add(new ExcelBean().setName("用户昵称").setType("member_nick_name"));
		excelBeans.add(new ExcelBean().setName("性别").setType("member_sex"));
		excelBeans.add(new ExcelBean().setName("是否禁用").setType("member_state_show"));
		excelBeans.add(new ExcelBean().setName("注册时间").setType("create_time"));
		
		
		List<Map> exportOrders = memberServiceC.exportMembers(memberBean);
		
		String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + 
				NumberUtils.createRandom(true, 6) + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/" + fileName
				, excelBeans, exportOrders);
		if(is_success) {
			return "/excel/"+fileName;
		}else {
			throw new AppException("导出失败");
		}
		
	}
	
	@RequestMapping("/getMemberStatistics")
	@AppController(isVerSystemToken=true)
	public Object getMemberStatistics(MemberBean memberBean)throws Exception{
		return memberServiceC.getMemberStatistics(memberBean);
	}
	
	@RequestMapping("/getMemberBuyStatistics")
	@AppController(isVerSystemToken=true)
	public Object getMemberBuyStatistics(MemberBean memberBean)throws Exception{
		return memberServiceC.getMemberBuyStatistics(memberBean);
	}
	
	@RequestMapping("/getAdvices")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getAdvices(AdviceBean adviceBean, PageBean pageBean) throws Exception{
		return memberServiceC.getAdvices(adviceBean, pageBean);
	}
	
	@RequestMapping("/deleteAdvice")
	@AppController(isVerSystemToken=true)
	public Object deleteAdvice(AdviceBean adviceBean) throws Exception{
		return memberServiceC.deleteAdvice(adviceBean);
	}
	
	@RequestMapping("/getMemberInsertCounts")
	@AppController(isVerSystemToken=true)
	public Object getMemberInsertCounts(MemberBean memberBean)throws Exception{
		return memberServiceC.getMemberInsertCounts(memberBean);
	}
	
	@RequestMapping("/getMemberAddressCounts")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberAddressCounts(AddressBean addressBean, PageBean pageBean)throws Exception{
		return memberServiceC.getMemberAddressCounts(addressBean, pageBean);
	}
	/**
	 * 添加用户
	 * @param memberBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMember")
	@AppController(isVerSystemToken=true)
	public Object insertMember(MemberBean memberBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加用户，用户名为"+memberBean.getMember_nick_name())
				.setOperate_type("update")
				.setModule_name("用户模块"));
		Object object = memberServiceC.insertMember(memberBean);
		return object;
	}
	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberDetail")
	@AppController(isVerSystemToken=true)
	public Object getMemberDetail(MemberBean memberBean)throws Exception{
		Object object = memberServiceC.getMemberDetail(memberBean);
		return object;
	}
	
	/**
	 * 用户列表
	 * @param memberBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMembers")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMembers(MemberBean memberBean, PageBean pageBean)throws Exception{
		Object object = memberServiceC.getMembers(memberBean, pageBean);
		return object;
	}
	/**
	 * 修改用户信息
	 * @param memberBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMemberDetail")
	@AppController(isVerSystemToken=true)
	public Object updateMemberDetail(MemberBean memberBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改用户状态，用户名为"+memberBean.getMember_nick_name())
				.setOperate_type("update")
				.setModule_id(memberBean.getMember_id()+"")
				.setModule_name("用户模块"));
		Object object = memberServiceC.updateMemberDetail(memberBean);
		return object;
	}
	/**
	 * 删除用户
	 * @param memberBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteMember")
	@AppController(isVerSystemToken=true)
	public Object deleteMember(MemberBean memberBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除用户，用户名为"+memberBean.getMember_nick_name())
				.setOperate_type("delete")
				.setModule_id(memberBean.getMember_id()+"")
				.setModule_name("用户模块"));
		Object object = memberServiceC.deleteMember(memberBean);
		
		return object;
	}
	/**
	 * 用户地址
	 * @param addressBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberAddress")
	@AppController(isVerSystemToken=true, isPage=true)
	public Object getMemberAddress(AddressBean addressBean, PageBean pageBean)throws Exception{
		Object object = memberServiceC.getMemberAddress(addressBean, pageBean);
		return object;
	}
	/**
	 * 用户银行卡列表
	 * @param bankCardBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberBankCards")
	@AppController(isVerSystemToken=true, isPage=true)
	public Object getMemberBankCards(BankCardBean bankCardBean, PageBean pageBean)throws Exception{
		Object object = memberServiceC.getMemberBankCards(bankCardBean, pageBean);
		return object;
	}
	/**
	 * 添加任务分类
	 * @param taskClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertTaskClass")
	@AppController(isVerSystemToken=true)
	public Object insertTaskClass(TaskClassBean taskClassBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("添加任务分类，分类名称为"+taskClassBean.getClass_name())
				.setOperate_type("insert")
				.setModule_name("任务模块"));
		return memberServiceC.insertTaskClass(taskClassBean);
	}
	/**
	 * 修改任务分类
	 * @param taskClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateTaskClass")
	@AppController(isVerSystemToken=true)
	public Object updateTaskClass(TaskClassBean taskClassBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("修改任务分类，分类名称为"+taskClassBean.getClass_name())
				.setOperate_type("update")
				.setModule_id(taskClassBean.getClass_id()+"")
				.setModule_name("任务模块"));
		return memberServiceC.updateTaskClass(taskClassBean);
	}
	/**
	 * 删除任务分类
	 * @param taskClassBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteTaskClass")
	@AppController(isVerSystemToken=true)
	public Object deleteTaskClass(TaskClassBean taskClassBean,HttpServletRequest request)throws Exception{
		systemService.insertSystemLog(new SystemLogBean().setAccount_id(request.getParameter("account_id1"))
				.setOperate_desc("删除任务分类，分类名称为"+taskClassBean.getClass_name())
				.setOperate_type("delete")
				.setModule_id(taskClassBean.getClass_id()+"")
				.setModule_name("任务模块"));
		return memberServiceC.deleteTaskClass(taskClassBean);
	}
	/**
	 * 分类列表
	 * @param taskClassBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTaskClasses")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getTaskClasses(TaskClassBean taskClassBean,PageBean pageBean)throws Exception{
		return memberServiceC.getTaskClasses(taskClassBean,pageBean);
	}
	/**
	 * 任务分类
	 * @param taskClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTaskClassDetail")
	@AppController(isVerSystemToken=true)
	public Object getTaskClassDetail(TaskClassBean taskClassBean)throws Exception{
		return memberServiceC.getTaskClassDetail(taskClassBean);
	}
	
}