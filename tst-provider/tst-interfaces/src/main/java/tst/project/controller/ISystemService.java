/**
 * 
 */
package tst.project.controller;

import java.util.List;

import tst.project.bean.member.CompanyBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.bean.system.SystemLogBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface ISystemService {
	/**
	 * 插入系统用户操作日志
	 * @author lx
	 * @param systemLogBean
	 * @return
	 */
	public int insertSystemLog(SystemLogBean systemLogBean);
	/**
	 * 获取系统用户操作日志列表
	 * @author lx
	 * @param systemLogBean
	 * @return
	 */
	public Object getSystemLogs(SystemLogBean systemLogBean,PageBean pageBean);
	/**
	 * 删除系统日志
	 * @author lx
	 * @param systemLogBean
	 * @return
	 */
	public int updateSystemLog(SystemLogBean systemLogBean);
	/**
	 * 获取公司详情
	 * @author lx
	 * @param companyBean
	 * @return
	 */
	public Object getCompany(MemberBean memberBean);
	/**
	 * 修改公司信息
	 * @author lx
	 * @param companyBean
	 * @return
	 */
	public Object updateCompany(MemberBean memberBean);

	/**
	 * 分配角色权限
	 * 
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	public int updateRoleAuthority(MoudleBean moudleBean);
	
	/**
	 * 获得角色拥有权限
	 * 
	 * @param moudleBean
	 * @return
	 */
	public Object getRoleAuthoritys(MoudleBean moudleBean);
	/**
	 * 添加系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public int insertSystemRole(RoleBean roleBean);
	
	/**
	 * 修改系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public int updateSystemRole(RoleBean roleBean);
	
	/**
	 * 删除系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public int deleteSystemRole(RoleBean roleBean);
	
	/**
	 * 系统账号角色
	 * @param systemAccountBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemRoles(RoleBean roleBean,PageBean pageBean);
	
	public Object getSystemRolesNoPage(RoleBean roleBean);
	
	/**
	 * 添加系统账号
	 * @param SystemAccountBean
	 * @return
	 */
	public int insertSystemAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 修改系统账号
	 * @param SystemAccountBean
	 * @return
	 */
	public int updateSystemAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 修改商家账号姓名
	 * @author sjb
	 * @param systemAccountBean
	 * @return
	 */
	public int updateMerchantsAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 删除系统账号
	 * @param SystemAccountBean
	 * @return
	 */
	public int deleteSystemAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 系统账号列表
	 * @param systemAccountBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemAccounts(SystemAccountBean systemAccountBean,PageBean pageBean);
	
	/**
	 * 添加系统模块
	 * @param moudleBean
	 * @param pageBean
	 * @return
	 */
	public int insertMoudle(MoudleBean moudleBean);
	
	/**
	 * 修改系统模块
	 * @param moudleBean
	 * @param pageBean
	 * @return
	 */
	public int updateMoudle(MoudleBean moudleBean);
	
	/**
	 * 删除系统模块
	 * @param moudleBean
	 * @param pageBean
	 * @return
	 */
	public int deleteMoudle(MoudleBean moudleBean);
	/**
	 * 模块列表
	 * @param moudleBean
	 * @return
	 */
	public Object getMoudles(MoudleBean moudleBean);
	/**
	 * 角色拥有的模块列表
	 * @param moudleBean
	 * @return
	 */
	public Object getRoleMoudles(MoudleBean moudleBean,int account_id1);
	
	/**
	 * 系统账号登录
	 * @param systemAccountBean
	 * @return
	 */
	public SystemAccountBean systemLogin(SystemAccountBean systemAccountBean);
}
