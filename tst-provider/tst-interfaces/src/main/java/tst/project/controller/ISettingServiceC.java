/**
 * 
 */
package tst.project.controller;

import java.util.List;

import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.ListShowBean;
import tst.project.bean.setting.ListTypeBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface ISettingServiceC {
	
	/**
	 * 展示的列表类型
	 * @author sjb
	 * @param listTypeBean
	 * @return
	 */
	public Object getListTypes(ListTypeBean listTypeBean);
	
	/**
	 * 展示的列表
	 * @author sjb
	 * @param listShowBean
	 * @return
	 */
	public Object getListShows(ListShowBean listShowBean);
	
	/**
	 * 反馈列表
	 * @author sjb
	 * @return
	 */
	public Object getAdvices(AdviceBean adviceBean,PageBean pageBean);
	
	/**
	 * 单层省市区
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getOneCitys(CityBean cityBean);
	
	/**
	 * 省市区列表
	 * @param cityBean
	 * @return
	 */
	public Object getCitys(CityBean cityBean);
	
	/**
	 * 热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public Object getCityHots(CityHotBean cityHotBean, PageBean pageBean);
	
	/**
	 * 非热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public Object getCityOutHots(CityBean cityBean);
	
	/**
	 * 添加热门城市
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public Object insertCityHot(CityHotBean cityHotBean);
	
	/**
	 * 删除热门城市
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public Object deleteCityHot(CityHotBean cityHotBean);
	
	/**
	 * 添加图文
	 * @param bannerBean
	 * @return
	 */
	public int insertHtml(HtmlBean htmlBean);
	
	/**
	 * 修改图文
	 * @param bannerBean
	 * @return
	 */
	public int updateHtml(HtmlBean htmlBean);
	
	/**
	 * 删除图文
	 * @param bannerBean
	 * @return
	 */
	public int deleteHtml(HtmlBean htmlBean);
	/**
	 * 图文详情
	 * @param bannerBean
	 * @return
	 */
	public Object getHtmlDetail(HtmlBean htmlBean);
	/**
	 * 图文列表
	 * @param bannerBean
	 * @return
	 */
	public Object getHtmls(HtmlBean htmlBean,PageBean pageBean);
	
	/**
	 * 消息类型
	 * @author gxq
	 * @param msgTypeBean
	 * @return
	 */
	public List<MsgTypeBean> getMsgTypes(MsgTypeBean msgTypeBean);
	/**
	 * 更新消息类型
	 * @author gxq
	 * @param msgTypeBean
	 * @return
	 */
	public int updateMsgType(MsgTypeBean msgTypeBean);
}
