package tst.project.koubei.interfaces;

import java.util.List;

import tst.project.bean.koubei.SceneBean;
import tst.project.bean.koubei.SceneClassBean;
import tst.project.bean.koubei.SceneClassMarketingBean;
import tst.project.bean.koubei.SceneMarketingBean;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.OrderGoodsBean;
import tst.project.page.PageBean;

public interface ISceneService {
	
	
	/**
	 * 商家推荐的场景列表
	 * @author sjb
	 * @param sceneBean
	 * @return
	 */
	public Object getMerchantsRecommendScenes(SceneMarketingBean sceneMarketingBean,PageBean pageBean);
	
	public Object insertSceneOrder(SceneBean sceneBean,OrderBean orderBean,List<OrderGoodsBean> orderGoodsBeans,String order_remark,String is_summit);
	
	/**
	 * 场景详情
	 * @author sjb
	 * @param sceneBean
	 * @return
	 */
	public Object getSceneDetail(SceneBean sceneBean);
	
	/**
	 * 场景列表
	 * @author sjb
	 * @param sceneBean
	 * @param pageBean
	 * @return
	 */
	public Object getScenes(SceneBean sceneBean,PageBean pageBean);
	
	/**
	 * 推荐场景
	 * @author sjb
	 * @param sceneMarketingBean
	 * @param pageBean
	 * @return
	 */
	public Object getSceneMarketings(SceneMarketingBean sceneMarketingBean,PageBean pageBean);
	
	
	/**
	 * 分类列表
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object getSceneClasss(SceneClassBean sceneClassBean);
	
	/**
	 * 推荐场景分类
	 * @author sjb
	 * @param sceneClassMarketingBean
	 * @return
	 */
	public Object getSceneClassMarketings(SceneClassMarketingBean sceneClassMarketingBean);
}
