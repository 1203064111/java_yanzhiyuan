package tst.project.zhangmu.interfaces;

import java.util.List;

import tst.project.bean.setting.HtmlBean;
import tst.project.bean.sheep.BannerBean;
import tst.project.bean.sheep.BroadBean;
import tst.project.bean.sheep.MemberGroupBean;
import tst.project.bean.sheep.QrCodeBean;
import tst.project.bean.sheep.SheepInformationBean;
import tst.project.bean.sheep.QuestionClassBean;
import tst.project.bean.sheep.SheepAdviceBean;
import tst.project.bean.sheep.SheepBean;
import tst.project.bean.sheep.SheepEarBean;
import tst.project.bean.sheep.SheepHtmlBean;
import tst.project.bean.sheep.ShopGoodsBean;
import tst.project.bean.sheep.SignBean;
import tst.project.bean.sheep.SignMonthBean;
import tst.project.bean.sheep.VideoBean;
import tst.project.bean.sheep.VideoClassBean;
import tst.project.page.PageBean;

public interface ISheepService {
	
	/**
	 * 获得羊羔列表
	 * @param sheepBean
	 * @param pageBean
	 * @return
	 */

	public Object getBitchSheeps(SheepBean sheepBean, PageBean pageBean);

	/**
	 * 获得分期羊详情
	 * @param sheepBean
	 * @return
	 */
	public Object getBitchSheepDetail(SheepBean sheepBean);

	/**
	 * 获得羊耳标
	 * @param sheepEarBean
	 * @param pageBean
	 * @return
	 */
	public Object getSheepEars(SheepEarBean sheepEarBean, PageBean pageBean);

	/**
	 * 获得羊耳标（不分页）
	 * @param sheepEarBean
	 * @return
	 */
	public Object getSheepEarsNoPage(SheepEarBean sheepEarBean);

	/**
	 * 更新分期羊
	 * @param sheepBean
	 * @return
	 */
	public Object updateBitchSheepDetail(SheepBean sheepBean);

	/**
	 * 更新养只总数量
	 * @param sheepBean
	 * @return
	 */
	public Object updateSheepDetail(SheepBean sheepBean);
	

	/**
	 * 羊详细
	 * @param sheepBean
	 * @return
	 */
	public Object getSheepDetail(SheepBean sheepBean);

	/**
	 * 签到
	 * @param signBean
	 * @return
	 */
	public Object signCoin(SignBean signBean);

	/**
	 * 获得签到记录
	 * @param signMonthBean
	 * @return
	 */
	public Object getSignCoins(SignMonthBean signMonthBean);

	/**
	 * 首页banner
	 * @param bannerBean
	 * @return
	 */
	public List<BannerBean> getBanners(BannerBean bannerBean);

	/**
	 * 资讯
	 * @param informationBean
	 * @param pageBean
	 * @return
	 */
	public Object getInformations(SheepInformationBean informationBean,PageBean pageBean);

	/**
	 * 常见问题
	 * @param questionClassBean
	 * @return
	 */
	public List<QuestionClassBean> getQuestions(QuestionClassBean questionClassBean);

	/**
	 * 轮播2
	 * @param broadBean
	 * @return
	 */
	public List<BroadBean> getBroads(BroadBean broadBean);

	/**
	 * 资讯详情
	 * @param informationBean
	 * @return
	 */
	public SheepInformationBean getInformationDetail(SheepInformationBean informationBean);

	/**
	 * 获得二维码图片
	 * @param url
	 * @param imgPath
	 * @return
	 */
	public String getQrCodeImg(String url, String imgPath)throws Exception;

	
	/**
	 * 二维码
	 * @author lx
	 * @param videoBean
	 * @return
	 */
	public List<VideoBean> getVideos(VideoBean videoBean);

	/**
	 * 金币商城商品
	 * @author lx
	 * @param shopGoodsBean
	 * @param pageBean
	 * @return
	 */
	public Object getShopGoods(ShopGoodsBean shopGoodsBean, PageBean pageBean);

	/**
	 * 商品详情
	 * @author lx
	 * @param shopGoodsBean
	 * @return
	 */
	public ShopGoodsBean getShopDetail(ShopGoodsBean shopGoodsBean);

	/**
	 * 视频详情
	 * @author lx
	 * @param videoBean
	 * @return
	 */
	public VideoBean getVideoDetail(VideoBean videoBean);

	/**
	 * 
	 * @author gxq
	 * @param videoClassBean
	 * @return
	 */
	public List<VideoClassBean> getVideoClass(VideoClassBean videoClassBean);

	/**
	 * 获取二维码s
	 * @author lx
	 * @param qrCodeBean
	 * @return
	 */
	public Object getQrCodeImgs(QrCodeBean qrCodeBean);

	/**
	 * 意见反馈
	 * @author lx
	 * @param sheepAdviceBean
	 * @return
	 */
	public int insertAdvice(SheepAdviceBean sheepAdviceBean);

	/**
	 * 获取图文详情
	 * @author lx
	 * @param htmlBean
	 * @return
	 */
	public Object getSheepHtml(SheepHtmlBean sheephtmlBean);

	/**
	 * 团购详情
	 * @author lx
	 * @param memberGroupBean
	 * @return
	 */
	public MemberGroupBean getSheepGroupDetail(MemberGroupBean memberGroupBean);

}
