package tst.project.yinlong.controller;

import java.util.List;

import tst.project.bean.yinlong.MaintailMaterialBean;
import tst.project.page.PageBean;

public interface IMaintailMaterialServiceC {
	
	/**
	 * 维修材料列表
	 * @author hxf
	 * @param maintailMaterialBean
	 * @return
	 */
	public Object getMaterial(MaintailMaterialBean maintailMaterialBean,PageBean pageBean);
	
	/**
	 * 维修材料信息详情
	 * @author hxf
	 * @param maintailMaterialBean
	 * @return
	 */
	public Object getMaterialDetail(MaintailMaterialBean maintailMaterialBean);
	
	/**
	 * 添加维修材料
	 * @author hxf
	 * @param maintailMaterialBean
	 * @return
	 */
	public Object insertMaterial(MaintailMaterialBean maintailMaterialBean);
	
	/**
	 * 修改维修材料
	 * @author hxf
	 * @param maintailMaterialBean
	 * @return
	 */
	public Object updateMaterial(MaintailMaterialBean maintailMaterialBean);
	
	/**
	 * 删除维修材料
	 * @author hxf
	 * @param maintailMaterialBean
	 * @return
	 */
	public Object deleteMaterial(MaintailMaterialBean maintailMaterialBean);
	
	/**
	 * 批量导入维修材料
	 * @author hxf
	 * @param maintailMaterialBeans
	 * @return
	 */
	public Object insertMaterials(List<MaintailMaterialBean>maintailMaterialBeans);
}
