package tst.project.zhangmu.controller;

import java.util.List;

import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.sheep.BannerBean;
import tst.project.bean.sheep.BroadBean;
import tst.project.bean.sheep.CameraBean;
import tst.project.bean.sheep.GameConfigBean;
import tst.project.bean.sheep.GameGoodsBean;
import tst.project.bean.sheep.GameGoodsClassBean;
import tst.project.bean.sheep.GameImgConfigBean;
import tst.project.bean.sheep.GamePhotoBean;
import tst.project.bean.sheep.GameTaskBean;
import tst.project.bean.sheep.SheepInformationBean;
import tst.project.bean.sheep.SheepJokeBean;
import tst.project.bean.sheep.JokeBean;
import tst.project.bean.sheep.MemberSheepBean;
import tst.project.bean.sheep.QuestionBean;
import tst.project.bean.sheep.QuestionClassBean;
import tst.project.bean.sheep.SheepBean;
import tst.project.bean.sheep.SheepClassBean;
import tst.project.bean.sheep.SheepEarBean;
import tst.project.bean.sheep.SheepImgBean;
import tst.project.bean.sheep.SheepImportBean;
import tst.project.bean.sheep.SheepWelfareBean;
import tst.project.bean.sheep.ShopGoodsBean;
import tst.project.bean.sheep.VideoBean;
import tst.project.page.PageBean;

public interface ISheepServiceC {

	
	public Object getSheepClasss(SheepClassBean sheepClassBean, PageBean pageBean);

	public Object deleteSheepClass(SheepClassBean sheepClassBean);

	public SheepClassBean getSheepClassDetail(SheepClassBean sheepClassBean);

	public int insertSheepClass(SheepClassBean sheepClassBean);

	public int updateSheepClass(SheepClassBean sheepClassBean);

	public Object getSheeps(SheepBean sheepBean, PageBean pageBean);

	public int insertSheep(SheepBean sheepBean,List<SheepImgBean> sheepImgBeans);

	public SheepBean getSheepDetail(SheepBean sheepBean);

	public int deleteSheep(SheepBean sheepBean);

	public List<SheepClassBean> getSheepClassNoPage(SheepClassBean sheepClassBean);

	public int updateBitchSheep(SheepBean sheepBean);

	public int updateSheep(SheepBean sheepBean,List<SheepImgBean> sheepImgBeans);

	public int insertBitchSheep(SheepBean sheepBean)throws Exception;

	public SheepBean getBitchSheepDetail(SheepBean sheepBean);

	public int importEarSignExcel(List<SheepImportBean> sheepImportBeans);

	public Object getSheepEars(SheepEarBean sheepEarBean, PageBean pageBean);

	public SheepWelfareBean getWelfareDetail(SheepWelfareBean sheepWelfareBean);

	public int updateWelfare(SheepWelfareBean sheepWelfareBean);

	public List<BannerBean> getBanners(BannerBean bannerBean);

	public List<BroadBean> getBroads(BroadBean broadBean);

	public BannerBean getBannerDetail(BannerBean bannerBean);

	public int updateBanner(BannerBean bannerBean);

	public int deleteBanner(BannerBean bannerBean);

	public int insertBanner(BannerBean bannerBean);

	public BroadBean getBroadDetail(BroadBean broadBean);

	public int updateBroad(BroadBean broadBean);

	public int deleteBroad(BroadBean broadBean);

	public int insertBroad(BroadBean broadBean);

	public Object moveBroad(BroadBean broadBean);

	public Object moveBanner(BannerBean bannerBean);

	public Object getInformations(SheepInformationBean informationBean, PageBean pageBean);

	public SheepInformationBean getInformationDetail(SheepInformationBean informationBean);

	public int deleteInformation(SheepInformationBean informationBean);

	public int updateInformation(SheepInformationBean informationBean);

	public int insertInformation(SheepInformationBean informationBean);

	public int pushInformation(SheepInformationBean informationBean);

	public Object getJokes(JokeBean jokeBean,PageBean pageBean);

	public JokeBean getjokeDetail(JokeBean jokeBean);

	public int useJoke(JokeBean jokeBean);

	public int deleteJoke(JokeBean jokeBean);

	public int updateJoke(JokeBean jokeBean);

	public Object importJokes(List<JokeBean> jokeBeans);

	public Object getvideos(VideoBean videoBean, PageBean pageBean);

	public VideoBean getVideoDetail(VideoBean videoBean);

	public int insertVideo(VideoBean videoBean);

	public int deleteVideo(VideoBean videoBean);

	public int updateVideo(VideoBean videoBean);

	public CameraBean getCameraDetail(CameraBean cameraBean);

	public int updateCamera(CameraBean cameraBean);

	public int insertCamera(CameraBean cameraBean);

	public int deleteCamera(CameraBean cameraBean);

	public List<PercentBean> getPercents(PercentBean percentBean);

	public int updatePercent(List<PercentBean> percentBeans);

	public List<MsgTypeBean> getMsgTypes(MsgTypeBean msgTypeBean);

	public Object getShopGoods(ShopGoodsBean shopGoodsBean, PageBean pageBean);

	public Object moveShopGoods(ShopGoodsBean shopGoodsBean);

	public int deleteShopGoods(ShopGoodsBean shopGoodsBean);

	public ShopGoodsBean getShopGoodsDetail(ShopGoodsBean shopGoodsBean);

	public int updateShopGoods(ShopGoodsBean shopGoodsBean);

	public int insertShopGoods(ShopGoodsBean shopGoodsBean);

	public Object moveSheep(SheepBean sheepBean);

	public Object getMemberSheeps(MemberSheepBean memberSheepBean, PageBean pageBean);

	public MemberSheepBean getMemberSheepDetail(MemberSheepBean memberSheepBean);

	public Object getAllSheepBitchs(MemberSheepBean memberSheepBean);

	public Object getQuestions(QuestionBean questionBean, PageBean pageBean);

	public int deleteQuestion(QuestionBean question);

	public int insertQuestion(QuestionBean question);

	public int updateQuestion(QuestionBean question);

	public QuestionBean getQuestionDetail(QuestionBean question);

	public int moveQuestion(QuestionBean question);

	public Object getQuestionClassDetail(QuestionClassBean questionClassBean);

	public Object getQuestionClass(QuestionClassBean questionClassBean, PageBean pageBean);

	public int insertQuestionClass(QuestionClassBean questionClassBean);

	public int deleteQuestionClassBean(QuestionClassBean questionClassBean);

	public int updateQuestionClass(QuestionClassBean questionClassBean);

	public List<GameConfigBean> getGameConfigs(GameConfigBean gameConfigBean);

	public Object getGameGoods(GameGoodsBean gameGoodsBean, PageBean pageBean);

	public Object getGameGoodsDetil(GameGoodsBean gameGoodsBean);

	/**
	 * 初始化图片配置
	 * @author lx
	 * @param gameImgConfigBean
	 * @return
	 */
	public GameImgConfigBean getSheepImgConfigs(GameImgConfigBean gameImgConfigBean);

	/**
	 * 更新游戏配置
	 * @author lx
	 * @param gameconfigs
	 * @return
	 */
	public Object updateGameConfg(List<GameConfigBean> gameconfigs);

	/**
	 * 更新图片配置
	 * @author lx
	 * @param gameImgConfigBean
	 * @return
	 */
	public Object updateSheepImgConfig(GameImgConfigBean gameImgConfigBean);

	/**
	 * 游戏任务列表
	 * @author lx
	 * @param gameTaskBean
	 * @return
	 */
	public Object getGameTasks(GameTaskBean gameTaskBean);

	/**
	 * 任务详情
	 * @author lx
	 * @param gameTaskBean
	 * @return
	 */
	public Object getGameTaskDetail(GameTaskBean gameTaskBean);

	/**
	 * 更新任务
	 * @author lx
	 * @param gameTaskBean
	 * @return
	 */
	public Object updateGameTask(GameTaskBean gameTaskBean);

	/**
	 * 更新游戏道具
	 * @author lx
	 * @param gameGoodsBean
	 * @return
	 */
	public Object updateGameGoods(GameGoodsBean gameGoodsBean);

	/**
	 * 道具分类
	 * @author lx
	 * @param gameGoodsClassBean
	 * @return
	 */
	public Object getGameGoodsClassDetail(GameGoodsClassBean gameGoodsClassBean);

	/**
	 * 道具分类列表
	 * @author lx
	 * @param gameGoodsClassBean
	 * @return
	 */
	public Object getGameGoodsClass(GameGoodsClassBean gameGoodsClassBean);

	/**
	 * 更新道具分类
	 * @author lx
	 * @param gameGoodsClassBean
	 * @return
	 */
	public Object updateGameGoodsClass(GameGoodsClassBean gameGoodsClassBean);

	/**
	 * 添加游戏道具
	 * @author lx
	 * @param gameGoodsBean
	 * @return
	 */
	public Object insertGameGoods(GameGoodsBean gameGoodsBean);

	/**
	 * 道具排序
	 * @author lx
	 * @param gameGoodsBean
	 * @return
	 */
	public Object moveGameGoods(GameGoodsBean gameGoodsBean);

	/**
	 * 游戏弹出语
	 * @author lx
	 * @param sheepJokeBean
	 * @param pageBean
	 * @return
	 */
	public Object getGameJokes(SheepJokeBean sheepJokeBean, PageBean pageBean);

	/**
	 * 游戏弹出语
	 * @author lx
	 * @param sheepJokeBean
	 * @return
	 */
	public Object getGameJokeDetail(SheepJokeBean sheepJokeBean);

	/**
	 * 更新弹出语
	 * @author lx
	 * @param sheepJokeBean
	 * @return
	 */
	public Object updateGameJoke(SheepJokeBean sheepJokeBean);

	/**
	 * 添加游戏弹出语
	 * @author lx
	 * @param sheepJokeBean
	 * @return
	 */
	public Object insertGameJoke(SheepJokeBean sheepJokeBean);

	/**
	 * 删除游戏弹出语
	 * @author lx
	 * @param sheepJokeBean
	 * @return
	 */
	public Object deleteGameJoke(SheepJokeBean sheepJokeBean);

	public Object getGamePhotos(GamePhotoBean gamePhotoBean, PageBean pageBean);

	public Object getGamePhotoDetail(GamePhotoBean gamePhotoBean);

	public Object deleteGamePhoto(GamePhotoBean gamePhotoBean);

	public Object updateGamePhoto(GamePhotoBean gamePhotoBean);

	public Object insertGamePhoto(GamePhotoBean gamePhotoBean);


}
