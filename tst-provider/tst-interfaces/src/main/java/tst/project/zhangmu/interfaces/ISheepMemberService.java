package tst.project.zhangmu.interfaces;

import tst.project.bean.CodeBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.sheep.CameraBean;
import tst.project.bean.sheep.GameDynamicBean;
import tst.project.bean.sheep.GameDynamicClassBean;
import tst.project.bean.sheep.GameGoodsBean;
import tst.project.bean.sheep.GameMemberGoodsBean;
import tst.project.bean.sheep.GamePhotoBean;
import tst.project.bean.sheep.GameSheepBean;
import tst.project.bean.sheep.GameTaskBean;
import tst.project.bean.sheep.JokeBean;
import tst.project.bean.sheep.MemberCoinBean;
import tst.project.bean.sheep.MemberCoinSourceBean;
import tst.project.bean.sheep.MemberFriendBean;
import tst.project.bean.sheep.MemberGameBean;
import tst.project.bean.sheep.MemberGroupBean;
import tst.project.bean.sheep.MemberInvationBean;
import tst.project.bean.sheep.MemberSheepBean;
import tst.project.bean.sheep.MemberWelfareBean;
import tst.project.bean.sheep.SheepCouponBean;
import tst.project.bean.sheep.SheepJokeBean;
import tst.project.bean.sheep.SheepMemberBean;
import tst.project.bean.sheep.SheepWelfareBean;
import tst.project.bean.shop.MemberBillBean;
import tst.project.bean.shop.ShopCouponBean;
import tst.project.page.PageBean;

public interface ISheepMemberService {
	

	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	public SheepMemberBean getMemberDetail(SheepMemberBean sheepMemberBean,MemberBean memberBean)throws Exception;
	
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean,SheepMemberBean sheepMemberBean);
	
	/**
	 * 用户注册
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	public Object registerMember(SheepMemberBean sheepMemberBean,MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 用户登录
	 * @param memberBean
	 * @return
	 */
	public Object loginMember(MemberBean memberBean, CodeBean codeBean,String select_type);

	/**
	 * 验证码用户登录
	 * @param memberBean
	 * @return
	 */
	public Object CodeLoginMember(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 用户登录
	 * @param memberBean
	 * @return
	 */
	public Object wxLoginMember(MemberBean memberBean,String code);
	
	/**
	 * 忘记密码
	 * @param memberBean
	 * @return
	 */
	public Object forgetPassword(MemberBean memberBean, CodeBean codeBean);

	/**
	 * 获取消息通知
	 * @param memberBean
	 * @param memberMsgBean
	 * @return
	 */
	public Object getMemberMsgs( MemberMsgBean memberMsgBean,PageBean pageBean);

	/**
	 * 查看消息详情
	 * @param memberBean
	 * @param memberMsgBean
	 * @return
	 */
	public Object getMemberMsgsDetail( MemberMsgBean memberMsgBean);

	/**
	 * 获得好友列表
	 * @param memberBean
	 * @param memberFriendBean
	 * @return
	 */

	public Object getMemberFriends(MemberFriendBean memberFriendBean, PageBean pageBean);

	/**
	 *  商城优惠券
	 * @param sheepCouponBean
	 * @param pageBean
	 * @return
	 */
	public Object getCoupons(SheepCouponBean sheepCouponBean, PageBean pageBean);

	/**
	 * 领取优惠券
	 * @param sheepMemberBean
	 * @param sheepCouponBean
	 * @return
	 * @throws Exception 
	 */
	public int insertMemberCoupon(SheepMemberBean sheepMemberBean, SheepCouponBean sheepCouponBean);



	/**
	 * 新手福利
	 * @param sheepWelfareBean
	 * @return
	 */
	public SheepWelfareBean getWelfareDetail(SheepWelfareBean sheepWelfareBean);

	/**
	 * 领取用户体验券
	 * @param sheepMemberBean
	 * @param memberWelfareBean
	 * @return
	 */

	public Object getNoviceWelfare(MemberWelfareBean memberWelfareBean);

	/**
	 * 领取所有优惠券
	 * @param memberWelfareBean
	 * @param sheepCouponBean
	 * @return
	 */
	public int getAllWelfare(MemberWelfareBean memberWelfareBean, SheepCouponBean sheepCouponBean);

	public Object getMemberInvations(MemberInvationBean memberInvationBean, PageBean pageBean);

	public Object getSheepGroups(MemberGroupBean memberGroupBean, PageBean pageBean);

	public Object getMemberSheeps(MemberSheepBean memberSheepBean, PageBean pageBean);

	public SheepCouponBean getMemberCouponDetail(SheepCouponBean sheepCouponBean);

	public Object getMemberCoupons(SheepCouponBean sheepCouponBean, PageBean pageBean)throws Exception;

	public JokeBean getDayjoke(JokeBean jokeBean);

	public int updateGameSheep(GameSheepBean gameSheepBean);

	public SheepCouponBean getCouponDetail(SheepCouponBean sheepCouponBean);

	public Object getMemberShopList(MemberCoinBean memberCoinBean, PageBean pageBean);

	public Object getGameDynamicClass(GameDynamicClassBean gameDynamicClassBean,PageBean pageBean);

	public MemberCoinBean getMemberShopDetail(MemberCoinBean memberCoinBean);

	public Object getBushes(SheepMemberBean sheeepMemberBean,String task_id);

	public Object verMemberDetail(MemberBean memberBean);

	public Object loginMember(SheepMemberBean sheepmemberBean, MemberBean memberBean, CodeBean codeBean,
			String select_type);

	/**
	 * 扫一扫溯源
	 * @author lx
	 * @param memberSheepBean
	 * @return
	 */
	public Object getMemberSheepDetail(MemberSheepBean memberSheepBean);

	/**
	 * 
	 * @author lx
	 * @param shopCouponBean
	 * @return
	 */
	public int insertMemberShopCoupon(ShopCouponBean shopCouponBean,SheepMemberBean sheepMemberBean);

	/**
	 *获取体验券
	 * @author lx
	 * @param memberWelfareBean
	 * @return
	 */
	public MemberWelfareBean getMemberWelfareDetail(MemberWelfareBean memberWelfareBean);

	/**
	 * 余额明细
	 * @author lx
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberBills(MemberBillBean memberBillBean, PageBean pageBean);

	public Object getMemberCoinSources(MemberCoinSourceBean memberCoinSourceBean, PageBean pageBean);

	public Object useWelfareCoupon(MemberWelfareBean memberWelfareBean);

	/**
	 * 陌生人列表
	 * @author lx
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public Object getStrangeMembers(MemberBean memberBean, PageBean pageBean);

	public int insertFriend(MemberFriendBean memberFriendBean);

	public int refuseFriend(MemberFriendBean memberFriendBean);

	public int agreeFriend(MemberFriendBean memberFriendBean);

	public Object getMemberFriendInvations(MemberFriendBean memberFriendBean, PageBean pageBean);

	public int insertGameMemberGoods(GameMemberGoodsBean gameMemberGoodsBean,String task_id);

	public Object getMemberGameGoods(GameMemberGoodsBean gameMemberGoodsBean);

	public Object getSheepCameras(CameraBean cameraBean, MemberSheepBean memberSheepBean);

	public Object getGameGoodss(GameGoodsBean gameGoodsBean, PageBean pageBean);

	public Object JokeTimer(JokeBean jokeBean);

	public Object bushTimer(SheepMemberBean sheeepMemberBean);

	public Object sheepCouponTimer(SheepCouponBean sheepCouponBean);

	/**
	 * 游戏任务列表
	 * @author lx
	 * @param gameTaskBean
	 * @param sheepMemberBean
	 * @return
	 */
	public Object getGameTasks(GameTaskBean gameTaskBean);

	/**
	 * 任务详情
	 * @author lx
	 * @param gameTaskBean
	 * @param sheepMemberBean
	 * @return
	 */
	public Object getGameTaskDetail(GameTaskBean gameTaskBean);

	/**
	 * 偷菜列表
	 * @author lx
	 * @param gameDynamicBean
	 * @param pageBean
	 * @return
	 */
	public Object getGameStealList(GameDynamicBean gameDynamicBean, PageBean pageBean);

	/**
	 * 做任务
	 * @author lx
	 * @param gameTaskBean
	 * @return
	 */
	public Object takeTask(GameTaskBean gameTaskBean);

	/**
	 * 查看朋友详情
	 * @author lx
	 * @param sheepMemberBean
	 * @return
	 */
	public Object getFriendDetail(SheepMemberBean sheepMemberBean);

	public Object GameImgTimer(SheepMemberBean sheepMemberBean);

	public Object feedSheep(GameSheepBean gameSheepBean,String task_id,String member_goods_id)throws Exception;

	public Object useGameImg(GameSheepBean gameSheepBean);

	public Object getSheepCoins(SheepMemberBean sheepMemberBean);

	public Object getDynamicDetail(GameDynamicBean gameDynamicBean);

	public Object unUseGameImg(GameSheepBean gameSheepBean);

	public Object produceCoinTimer(GameSheepBean gameSheepBean);

	public Object SheepGameTimer(GameSheepBean gameSheepBean);

	public Object getGameJoke(SheepJokeBean sheepJokeBean);

	public Object getPhotoImg(GamePhotoBean gamePhotoBean,String task_id);

	public Object illTimer(GameSheepBean gameSheepBean);

	public Object crueIll(GameMemberGoodsBean gameMemberGoodsBean);


	



	

}
