package tst.project.maiziliao.interfaces;

import java.util.List;

import tst.project.bean.clue.ClueBean;
import tst.project.bean.clue.ClueIndustryBean;
import tst.project.bean.clue.ClueOrderBean;
import tst.project.page.PageBean;

public interface IClueService {
	
	/**
	 * 用户的线索订单列表
	 * @param clueOrderBean
	 * @param pageBean
	 * @return
	 */
	public Object getClueOrders(ClueOrderBean clueOrderBean,PageBean pageBean);
	
	/**
	 * 用户购买线索
	 * @param clueOrderBean
	 * @return
	 */
	public int insertClueOrder(ClueOrderBean clueOrderBean)throws Exception;
	
	/**
	 * 线索行业列表
	 * @param clueIndustryBean
	 * @return
	 */
	public Object getClueIndustrys(ClueIndustryBean clueIndustryBean);
	
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
}
