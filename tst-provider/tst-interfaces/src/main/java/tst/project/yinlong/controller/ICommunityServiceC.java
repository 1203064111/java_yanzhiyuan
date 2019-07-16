package tst.project.yinlong.controller;


import tst.project.bean.yinlong.MaintailServiceTimeBean;
import tst.project.bean.yinlong.MaintailVillageBean;
import tst.project.page.PageBean;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年7月31日 下午4:20:33
* 类说明
*/
public interface ICommunityServiceC {
	
	/**
	 * 删除修改时间
	 * @author sjb
	 * @param maintailServiceTimeBean
	 * @return
	 */
	public Object deleteMaintailServiceTime(MaintailServiceTimeBean maintailServiceTimeBean);
	
	/**
	 * 修改服务时间
	 * @author sjb
	 * @return
	 */
	public Object updateMaintailServiceTime(MaintailServiceTimeBean maintailServiceTimeBean);
	
	/**
	 * 添加服务时间
	 * @author sjb
	 * @param maintailServiceTimeBean
	 * @return
	 */
	public Object insertMaintailServiceTime(MaintailServiceTimeBean maintailServiceTimeBean);
	
	/**
	 * 
	 * @author sjb
	 * @param maintailServiceTimeBean
	 * @return
	 */
	public Object getMaintailServiceTimeDetail(MaintailServiceTimeBean maintailServiceTimeBean);
	
	/**
	 * 
	 * @author sjb
	 * @param maintailServiceTimeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMaintailServiceTimes(MaintailServiceTimeBean maintailServiceTimeBean,PageBean pageBean);
	
	
	/**
	 * 添加小区信息
	 * @author hxf
	 * @param MaintailVillageBean
	 * @return
	 */
	public Object insertVillage(MaintailVillageBean maintailVillageBean);
	
	/**
	 * 修改小区信息
	 * @author hxf
	 * @param MaintailVillageBean
	 * @return
	 */
	public Object updateVillage(MaintailVillageBean maintailVillageBean);
	
	/**
	 * 删除小区信息
	 * @author hxf
	 * @param MaintailVillageBean
	 * @return
	 */
	public int deleteVillage(MaintailVillageBean maintailVillageBean);
	
	/**
	 * 获得所有小区信息
	 * @author hxf
	 * @param MaintailVillageBean
	 * @return
	 */
	public Object getVillage(MaintailVillageBean maintailVillageBean,PageBean pageBean);
	
	/**
	 * 获得小区信息详情
	 * @author hxf
	 * @param MaintailVillageBean
	 * @return
	 */
	public Object getVillageDetail(MaintailVillageBean maintailVillageBean);
}
