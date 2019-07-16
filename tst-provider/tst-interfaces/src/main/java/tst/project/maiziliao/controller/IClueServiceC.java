/**
 * 
 */
package tst.project.maiziliao.controller;

import tst.project.bean.clue.ClueBean;
import tst.project.bean.clue.ClueIndustryBean;
import tst.project.bean.clue.ClueMaterialBean;
import tst.project.bean.clue.ClueOrderBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface IClueServiceC {

	/**
	 * 线索材料列表
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public Object getClueMaterials(ClueMaterialBean clueMaterialBean);
	
	/**
	 * 添加线索材料
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public int insertClueMaterial(ClueMaterialBean clueMaterialBean);
	
	/**
	 * 删除线索材料
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public int deleteClueMaterial(ClueMaterialBean clueMaterialBean);
	
	/**
	 * 线索列表
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public Object getClues(ClueBean clueBean,PageBean pageBean);
	
	/**
	 * 线索详情
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public Object getClueDetail(ClueBean clueBean);
	
	/**
	 * 添加线索
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public Object insertClue(ClueBean clueBean);
	
	
	/**
	 * 修改线索
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public Object updateClue(ClueBean clueBean);
	
	/**
	 * 删除线索
	 * @param clueBean
	 * @param pageBean
	 * @return
	 */
	public Object deleteClue(ClueBean clueBean);
	
	/**
	 * 线索行业列表
	 * @param clueIndustryBean
	 * @param pageBean
	 * @return
	 */
	public Object getClueIndustrys(ClueIndustryBean clueIndustryBean,PageBean pageBean);
	public Object getClueIndustrysNoPage(ClueIndustryBean clueIndustryBean);

	/**
	 * 获得线索行业详情
	 * @param clueIndustryBean
	 * @return
	 */
	public Object getClueIndustryDetail(ClueIndustryBean clueIndustryBean);
	
	/**
	 * 添加线索行业
	 * @param clueIndustryBean
	 * @return
	 */
	public int insertClueIndustry(ClueIndustryBean clueIndustryBean);
	
	/**
	 * 修改线索行业
	 * @param clueIndustryBean
	 * @return
	 */
	public int updateClueIndustry(ClueIndustryBean clueIndustryBean);
	
	
	/**
	 * 删除线索行业
	 * @param clueIndustryBean
	 * @return
	 */
	public int deleteClueIndustry(ClueIndustryBean clueIndustryBean);

	/**
	 * 线索订单
	 * @param clueOrderBean
	 * @return
	 */
	public Object getClueOrders(ClueOrderBean clueOrderBean, PageBean pageBean);
}
