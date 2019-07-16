package tst.project.koubei.controller;

import tst.project.bean.koubei.SceneBean;
import tst.project.bean.koubei.SceneClassBean;
import tst.project.bean.koubei.SceneClassMarketingBean;
import tst.project.bean.koubei.SceneGoodsBean;
import tst.project.bean.koubei.SceneMarketingBean;
import tst.project.bean.shop.GoodsBean;
import tst.project.page.PageBean;

public interface ISceneServiceC {
	
	public Object moveSceneClassMarketing(SceneClassMarketingBean sceneClassMarketingBean);
	
	/**
	 * 新增场景数
	 * @author sjb
	 * @param sceneBean
	 * @return
	 */
	public Object getSceneStatistics(SceneBean sceneBean);
	/**
	 * 通过场景
	 * @author sjb
	 * @param sceneBean
	 * @return
	 */
	public Object acceptScene(SceneBean sceneBean);
	
	/**
	 * 拒绝场景
	 * @author sjb
	 * @param sceneBean
	 * @return
	 */
	public Object refuseScene(SceneBean sceneBean);
	
	/**
	 * 删除推荐分类
	 * @author sjb
	 * @param sceneClassMarketingBean
	 * @return
	 */
	public Object deleteSceneClassMarketing(SceneClassMarketingBean sceneClassMarketingBean);
	
	/**
	 * 添加推荐分类
	 * @author sjb
	 * @param sceneClassMarketingBean
	 * @return
	 */
	public Object insertSceneClassMarketing(SceneClassMarketingBean sceneClassMarketingBean);
	
	/**
	 * 获得场景分类列表 除去已经推荐的
	 * @author sjb
	 * @param sceneClassMarketingBean
	 * @param pageBean
	 * @return
	 */
	public Object getSceneClassOutMarketings(SceneClassMarketingBean sceneClassMarketingBean,PageBean pageBean);
	
	/**
	 * 场景分类推荐列表
	 * @author sjb
	 * @param sceneClassMarketingBean
	 * @return
	 */
	public Object getSceneClassMarketings(SceneClassMarketingBean sceneClassMarketingBean,PageBean pageBean);
	
	/**
	 * 添加热门推荐
	 * @author sjb
	 * @param sceneMarketingBean
	 * @return
	 */
	public Object insertSceneMarketings(SceneMarketingBean sceneMarketingBean);
	
	/**
	 * 场景列表 除去已经去除的营销场景
	 * @author sjb
	 * @param sceneMarketingBean
	 * @param pageBean
	 * @return
	 */
	public Object getSceneOutMarketing(SceneMarketingBean sceneMarketingBean,PageBean pageBean);
	
	/**
	 * 删除推荐场景
	 * @author sjb
	 * @param sceneMarketingBean
	 * @return
	 */
	public Object deleteSceneMarketing(SceneMarketingBean sceneMarketingBean);
	
	/**
	 * 推荐的场景列表
	 * @author sjb
	 * @return
	 */
	public Object getSceneMarketings(SceneMarketingBean sceneMarketingBean,PageBean pageBean);
	
	/**
	 * 场景商品列表
	 * @author sjb
	 * @param sceneGoodsBean
	 * @param pageBean
	 * @return
	 */
	public Object getSenceGoodss(SceneGoodsBean sceneGoodsBean);
	
	/**
	 * 添加场景商品
	 * @author sjb
	 * @param sceneGoodsBean
	 * @return
	 */
	public Object insertSenceGoodss(SceneGoodsBean sceneGoodsBean,String scene_type,String apply_state);
	
	/**
	 * 删除场景商品
	 * @author sjb
	 * @param sceneGoodsBean
	 * @return
	 */
	public Object deleteSenceGoods(SceneGoodsBean sceneGoodsBean,String scene_type);
	
	/**
	 * 获得场景 可搭配商品(去除已搭配的)
	 * @author sjb
	 * @param sceneBean
	 * @return
	 */
	public Object getScenesOutGoods(SceneBean sceneBean,GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 添加场景
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object insertScene(SceneBean sceneBean);
	
	/**
	 * 修改场景
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object updateScene(SceneBean sceneBean);
	
	
	/**
	 * 删除场景
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object deleteScene(SceneBean sceneBean);
	
	
	/**
	 * 获得场景列表
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object getScenes(SceneBean sceneBean,PageBean pageBean);
	
	/**
	 * 获得场景详情
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object getSceneDetail(SceneBean sceneBean);
	
	
	
	/**
	 * 场景分类上下移动
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object moveSceneClass(SceneClassBean sceneClassBean);
	/**
	 * 添加场景分类
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object insertSceneClass(SceneClassBean sceneClassBean);
	
	/**
	 * 修改场景分类
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object updateSceneClass(SceneClassBean sceneClassBean);
	
	
	/**
	 * 删除场景分类
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object deleteSceneClass(SceneClassBean sceneClassBean);
	
	public Object getSceneClassLinks(SceneClassBean sceneClassBean);
	
	/**
	 * 获得场景分类列表
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object getSceneClasss(SceneClassBean sceneClassBean,PageBean pageBean);
	
	/**
	 * 获得场景分类详情
	 * @author sjb
	 * @param sceneClassBean
	 * @return
	 */
	public Object getSceneClassDetail(SceneClassBean sceneClassBean);
}
