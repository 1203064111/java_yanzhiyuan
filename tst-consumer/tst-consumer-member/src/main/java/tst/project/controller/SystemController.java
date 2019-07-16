package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.member.CompanyBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/systemController/v1.0")
public class SystemController {
	@Autowired
	ISystemService systemService;
	
	@RequestMapping("/updateRoleAuthority") 
    @AppController(isVerSystemToken=true)
    public Object updateRoleAuthority(String json) throws Exception{ 
		MoudleBean moudleBean=JSON.parseObject(json, MoudleBean.class);

		return systemService.updateRoleAuthority(moudleBean);
	}
	
	@RequestMapping("/getRoleAuthoritys") 
    @AppController(isVerSystemToken=true)
    public Object getRoleAuthoritys(MoudleBean moudleBean) throws Exception{ 
		return systemService.getRoleAuthoritys(moudleBean);
	}
	@RequestMapping("/getCompany") 
    @AppController(isVerSystemToken=true)
    public Object getCompany(MemberBean memberBean) throws Exception{ 
		return systemService.getCompany(memberBean);
	}
	
	@RequestMapping("/updateCompany") 
    @AppController(isVerSystemToken=true)
    public Object updateCompany(MemberBean memberBean) throws Exception{ 
		return systemService.updateCompany(memberBean);
	}
	/**
	 * 添加系统角色
	 * @param roleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemRole") 
    @AppController(isVerSystemToken=true)
    public Object insertSystemRole(RoleBean roleBean) throws Exception{ 
		return systemService.insertSystemRole(roleBean);
	}
	/**
	 * 修改系统角色
	 * @param roleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSystemRole") 
    @AppController(isVerSystemToken=true)
    public Object updateSystemRole(RoleBean roleBean) throws Exception{ 
		return systemService.updateSystemRole(roleBean);
	}
	/**
	 * 删除系统角色
	 * @param roleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteSystemRole") 
    @AppController(isVerSystemToken=true)
    public Object deleteSystemRole(RoleBean roleBean) throws Exception{ 
		return systemService.deleteSystemRole(roleBean);
	}
	/**
	 * 系统角色列表
	 * @param roleBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemRoles") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getSystemRoles(RoleBean roleBean,PageBean pageBean) throws Exception{ 
		return systemService.getSystemRoles(roleBean,pageBean);
	}
	/**
	 * 系统角色不分页
	 * @param roleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemRolesNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getSystemRolesNoPage(RoleBean roleBean) throws Exception{ 
		return systemService.getSystemRolesNoPage(roleBean);
	}
	
	/**
	 * 添加系统账户
	 * @param systemAccountBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertSystemAccount") 
    @AppController(isVerSystemToken=true)
    public Object insertSystemAccount(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.insertSystemAccount(systemAccountBean);
	}
	/**
	 *修改系统账户
	 * @param systemAccountBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSystemAccount") 
    @AppController(isVerSystemToken=true)
    public Object updateSystemAccount(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.updateSystemAccount(systemAccountBean);
	}
	/**
	 * 删除系统账户
	 * @param systemAccountBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteSystemAccount") 
    @AppController(isVerSystemToken=true)
    public Object deleteSystemAccount(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.deleteSystemAccount(systemAccountBean);
	}
	/**
	 * 系统账户
	 * @param systemAccountBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemAccounts") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getSystemAccounts(SystemAccountBean systemAccountBean,PageBean pageBean) throws Exception{ 
		return systemService.getSystemAccounts(systemAccountBean,pageBean);
	}
	
	/**
	 * 添加模块
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMoudle") 
    @AppController(isVerSystemToken=true)
    public Object insertMoudle(MoudleBean moudleBean) throws Exception{ 
		return systemService.insertMoudle(moudleBean);
	}
	/**
	 * 修改模块
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMoudle") 
    @AppController(isVerSystemToken=true)
    public Object updateMoudle(MoudleBean moudleBean) throws Exception{ 
		return systemService.updateMoudle(moudleBean);
	}
	/**
	 * 删除模块
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteMoudle") 
    @AppController(isVerSystemToken=true)
    public Object deleteMoudle(MoudleBean moudleBean) throws Exception{ 
		return systemService.deleteMoudle(moudleBean);
	}
	
	/**
	 * 模块列表
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMoudles") 
    @AppController(isVerSystemToken=true)
    public Object getMoudles(MoudleBean moudleBean) throws Exception{ 
		return systemService.getMoudles(moudleBean);
	}
	
	
	/**
	 * 系统用户登录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/systemLogin") 
    @AppController
    public Object systemLogin(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.systemLogin(systemAccountBean);
	}
	
	
	/**
	 *  角色拥有的模块列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRoleMoudles") 
    @AppController(isVerSystemToken=true)
    public Object getRoleMoudles(MoudleBean moudleBean,int account_id1) throws Exception{ 
		return systemService.getRoleMoudles(moudleBean,account_id1);
	}
	/**
	 * 系统日志列表
	 * @param systemLogBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSystemLogs") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getSystemLogs(SystemLogBean systemLogBean,PageBean pageBean) throws Exception{ 
		return systemService.getSystemLogs(systemLogBean,pageBean);
	}
}
