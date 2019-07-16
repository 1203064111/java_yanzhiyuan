package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.ListShowBean;
import tst.project.bean.setting.ListTypeBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.page.PageBean;

@Mapper
public interface SettingDaoC {
	
	/**
	 * 展示的列表类型
	 * @author sjb
	 * @param listTypeBean
	 * @return
	 */
	public List<ListTypeBean> getListTypes(ListTypeBean listTypeBean);
	
	/**
	 * 展示的列表
	 * @author sjb
	 * @param listShowBean
	 * @return
	 */
	public List<ListShowBean> getListShows(ListShowBean listShowBean);
	
	/**
	 * 反馈列表
	 * @author sjb
	 * @return
	 */
	public List<AdviceBean> getAdvices(AdviceBean adviceBean,PageBean pageBean);
	/**
	 * 单层省市区列表
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getOneCitys(CityBean cityBean);
	
	/**
	 * 三层省市区列表
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getCitys(CityBean cityBean);
	
	
	/**
	 * 热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public List<CityHotBean> getCityHots(CityHotBean cityHotBean, PageBean pageBean);
	
	/**
	 * 非热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getCityOutHots(CityBean cityBean);
	
	/**
	 * 添加热门城市
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public int insertCityHot(CityHotBean cityHotBean);
	
	/**
	 * 删除热门城市
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public int deleteCityHot(CityHotBean cityHotBean);
	
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
	public HtmlBean getHtmlDetail(HtmlBean htmlBean);
	/**
	 * 图文列表
	 * @param bannerBean
	 * @return
	 */
	public List<HtmlBean> getHtmls(HtmlBean htmlBean,PageBean pageBean);
	/**
	 * 消息类型列表
	 * @param msgTypeBean
	 * @return
	 */
	public List<MsgTypeBean> getMsgTypes(MsgTypeBean msgTypeBean);
	/**
	 * 修改消息类型
	 * @param msgTypeBean
	 * @return
	 */
	public int updateMsgType(MsgTypeBean msgTypeBean);
}
