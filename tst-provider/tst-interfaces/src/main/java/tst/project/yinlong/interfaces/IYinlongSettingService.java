package tst.project.yinlong.interfaces;

import java.util.List;


import tst.project.bean.yinlong.YinlongBannerBean;

public interface IYinlongSettingService {
	
	/**
	 * 轮播图列表
	 * @author sjb
	 * @param yinlongBannerBean
	 * @return
	 */
	public List<YinlongBannerBean> getYinlongBanners(YinlongBannerBean yinlongBannerBean);
}
