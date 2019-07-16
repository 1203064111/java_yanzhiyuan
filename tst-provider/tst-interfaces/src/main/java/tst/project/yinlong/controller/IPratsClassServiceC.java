package tst.project.yinlong.controller;

import java.util.List;

import tst.project.bean.shop.GoodsClassMarketingBean;
import tst.project.bean.yinlong.MaintailMaterialBean;
import tst.project.bean.yinlong.PartsClassBean;
import tst.project.page.PageBean;

/**
* @author 作者 E-mail:hxf
* @version 创建时间：2018年8月3日 上午11:15:40
* 维修区域分类
*/
public interface IPratsClassServiceC {
	

	public Object movePratsClass(PartsClassBean partsClassBean);
	
	/**
	 * 维修区域多级分类联动列表
	 * @author hxf
	 * @param partsClassBean
	 * @return
	 */
	public Object getPratsClassLinks(PartsClassBean partsClassBean); 
	
	/**
	 * 维修区域分类列表
	 * @author hxf
	 * @param partsClassBean
	 * @param pageBean
	 * @return
	 */
	public Object getPratsClass(PartsClassBean partsClassBean,PageBean pageBean);
	
	/**
	 * 维修区域分类详情
	 * @author hxf
	 * @param partsClassBean
	 * @return
	 */
	public Object getPratsClassDetail(PartsClassBean partsClassBean);
	
	/**
	 * 添加维修区域分类
	 * @author hxf
	 * @param partsClassBean
	 * @return
	 */
	public int insertPratsClass(PartsClassBean partsClassBean);
	
	/**
	 * 修改维修区域分类
	 * @author hxf
	 * @param partsClassBean
	 * @return
	 */
	public int updatePratsClass(PartsClassBean partsClassBean);
	
	/**
	 * 删除维修区域分类
	 * @author hxf
	 * @param partsClassBean
	 * @return
	 */
	public int deletePratsClass(PartsClassBean partsClassBean);
	
	/**
	 * 批量导入维修区域
	 * @author hxf
	 * @param PartsClassBean
	 * @return
	 */
	public Object insertPratsClasses(List<PartsClassBean>partsClassBeans);
}
