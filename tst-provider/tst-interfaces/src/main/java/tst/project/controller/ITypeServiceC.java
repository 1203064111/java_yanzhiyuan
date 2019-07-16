package tst.project.controller;

import tst.project.bean.member.TypeBean;
import tst.project.page.PageBean;

public interface ITypeServiceC {
	
	
	/**
	 * 上下移动工种
	 * @author hwq
	 * @param typeBean
	 * @return
	 */
	public Object moveType(TypeBean typeBean);
	
	/**
	 * 工种列表
	 * @author hwq
	 * @param typeBean
	 * @param pageBean
	 * @return
	 */
	public Object getTypes(TypeBean typeBean,PageBean pageBean);
	
	/**
	 * 工种详情
	 * @author hwq
	 * @param typeBean
	 * @param pageBean
	 * @return
	 */
	public Object getTypeDetail(TypeBean typeBean);
	
	/**
	 * 添加工种
	 * @author hwq
	 * @param typeBean
	 * @param pageBean
	 * @return
	 */
	public Object insertType(TypeBean typeBean);
	
	/**
	 * 修改工种
	 * @author hwq
	 * @param typeBean
	 * @param pageBean
	 * @return
	 */
	public Object updateType(TypeBean typeBean);
	
	/**
	 * 删除工种
	 * @author hwq
	 * @param typeBean
	 * @param pageBean
	 * @return
	 */
	public Object deleteType(TypeBean typeBean);
	
	
	

}
