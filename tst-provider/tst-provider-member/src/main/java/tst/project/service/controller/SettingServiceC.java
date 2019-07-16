package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.ListShowBean;
import tst.project.bean.setting.ListTypeBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.controller.ISettingServiceC;
import tst.project.dao.controller.SettingDaoC;
import tst.project.page.PageBean;
import tst.project.utils.RedisUtils;

@Service 
@Transactional(rollbackFor=AppException.class)
public class SettingServiceC implements ISettingServiceC{
	@Autowired
	SettingDaoC settingDaoC;
	
	@Override
	public Object getListTypes(ListTypeBean listTypeBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getListTypes(listTypeBean);
	}
	
	@Override
	public Object getListShows(ListShowBean listShowBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getListShows(listShowBean);
	}
	
	@Override
	public Object getAdvices(AdviceBean adviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<AdviceBean> adviceBeans=settingDaoC.getAdvices(adviceBean, pageBean);
		return pageBean.setObject(adviceBeans);
	}
	
	
	@Override
	public List<CityBean> getOneCitys(CityBean cityBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getOneCitys(cityBean);
	}
	
	@Override
	public Object getCitys(CityBean cityBean) {
		// TODO Auto-generated method stub
		String citys=RedisUtils.getKey("citys");
				
		List<CityBean> cityBeans=null;
		if(citys==null||citys.equals("")){
			cityBeans=settingDaoC.getCitys(cityBean);
			boolean is_success=RedisUtils.setKey("citys", JSON.toJSONString(cityBeans));
			if(!is_success){
				throw new AppException("缓存失败!");
			}
		}else{
			cityBeans=JSON.parseArray(citys, CityBean.class);
		}
		
		return cityBeans;
	}
	
	@Override
	public Object getCityHots(CityHotBean cityHotBean, PageBean pageBean) {
		List<CityHotBean> cityHotBeans = settingDaoC.getCityHots(cityHotBean, pageBean);
		return pageBean.setObject(cityHotBeans);
	}
	
	@Override
	public Object getCityOutHots(CityBean cityBean) {
		List<CityBean> cityBeans = settingDaoC.getCityOutHots(cityBean);
		return cityBeans;
	}

	@Override
	public Object insertCityHot(CityHotBean cityHotBean) {
		int num = settingDaoC.insertCityHot(cityHotBean);
		if(num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}
	
	@Override
	public Object deleteCityHot(CityHotBean cityHotBean) {
		int num = settingDaoC.deleteCityHot(cityHotBean);
		if(num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}
	
	@Override
	public int insertHtml(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.insertHtml(htmlBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	
	@Override
	public int updateHtml(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.updateHtml(htmlBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public int deleteHtml(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.deleteHtml(htmlBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getHtmlDetail(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getHtmlDetail(htmlBean);
	}

	@Override
	public Object getHtmls(HtmlBean htmlBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<HtmlBean> htmlBeans=settingDaoC.getHtmls(htmlBean, pageBean);
		return pageBean.setObject(htmlBeans);
	}

	@Override
	public List<MsgTypeBean> getMsgTypes(MsgTypeBean msgTypeBean) {
		
		// TODO Auto-generated method stub
		return settingDaoC.getMsgTypes(msgTypeBean);
	}

	@Override
	public int updateMsgType(MsgTypeBean msgTypeBean) {
		// TODO Auto-generated method stub
		return settingDaoC.updateMsgType(msgTypeBean);
	}

}
