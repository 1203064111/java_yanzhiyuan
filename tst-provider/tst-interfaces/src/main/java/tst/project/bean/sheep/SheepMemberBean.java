package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

import tst.project.bean.member.MemberBean;

public class SheepMemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sheep_member_id;
	private String weixin_pub_open_id;//微信公众号唯一标识
	private String wx_code;//wxcode获取open_id
	private int member_id;//个人id
	private String friend_id;//朋友
	private int member_coin;//羊币
	private String total_balance;//红包金额
	private MemberBean memberBean;
	private String update_time;
	private String member_now_experience;
	private String member_need_experience;
	private String game_state;//游戏开启与关闭
	private String game_grade;//游戏等级
	private String bush_num;  //苜蓿总数
	private String bush_now_num;//当前可收货苜蓿数量
	private  String bush_state;//苜蓿状态  1,成长中 ，2已成熟
	private String bush_need_time;//苜蓿成长时间点
	private String bush_grew_time;//苜蓿成长时间戳
	private String steal_num;//被偷取次数
	
	private String style;//采摘方式 ，get 采摘，steal偷取
	private String is_welfare;//是否领取过新手福利,0,1
	private String is_guide;//0，1游戏引导
	private String is_sheep;//是否有羊在养殖（游戏）
	private String use_back_ground;//是否使用背景,1,2,3
	private  String member_goods_id;//游戏道具使用，多种使用以逗号隔开
	private List<GameMemberGoodsBean>  gameMemberGoodsBeans;
	private String back_img1;
	private String back_img2;
	private String back_img3;
	
	private  GameMemberGoodsBean GameMemberGoodsBean;
	
	
	
	
	
	
	public GameMemberGoodsBean getGameMemberGoodsBean() {
		return GameMemberGoodsBean;
	}
	public SheepMemberBean setGameMemberGoodsBean(GameMemberGoodsBean gameMemberGoodsBean) {
		GameMemberGoodsBean = gameMemberGoodsBean;
		return this;
	}
	public String getBack_img1() {
		return back_img1;
	}
	public SheepMemberBean setBack_img1(String back_img1) {
		this.back_img1 = back_img1;
		return this;
	}
	public String getBack_img2() {
		return back_img2;
	}
	public SheepMemberBean setBack_img2(String back_img2) {
		this.back_img2 = back_img2;
		return this;
	}
	public String getBack_img3() {
		return back_img3;
	}
	public SheepMemberBean setBack_img3(String back_img3) {
		this.back_img3 = back_img3;
		return this;
	}
	public List<GameMemberGoodsBean> getGameMemberGoodsBeans() {
		return gameMemberGoodsBeans;
	}
	public SheepMemberBean setGameMemberGoodsBeans(List<GameMemberGoodsBean> gameMemberGoodsBeans) {
		this.gameMemberGoodsBeans = gameMemberGoodsBeans;
		return this;
	}
	public String getMember_goods_id() {
		return member_goods_id;
	}
	public SheepMemberBean setMember_goods_id(String member_goods_id) {
		this.member_goods_id = member_goods_id;
		return this;
	}
	
	public String getUse_back_ground() {
		return use_back_ground;
	}
	public SheepMemberBean setUse_back_ground(String use_back_ground) {
		this.use_back_ground = use_back_ground;
		return this;
	}
	public String getIs_sheep() {
		return is_sheep;
	}
	public SheepMemberBean setIs_sheep(String is_sheep) {
		this.is_sheep = is_sheep;
		return this;
	}
	public String getIs_guide() {
		return is_guide;
	}
	public SheepMemberBean setIs_guide(String is_guide) {
		this.is_guide = is_guide;
		return this;
	}
	public String getSteal_num() {
		return steal_num;
	}
	public SheepMemberBean setSteal_num(String steal_num) {
		this.steal_num = steal_num;
		return this;
	}
	public String getIs_welfare() {
		return is_welfare;
	}
	public SheepMemberBean setIs_welfare(String is_welfare) {
		this.is_welfare = is_welfare;
		return this;
	}
	public String getWeixin_pub_open_id() {
		return weixin_pub_open_id;
	}
	public SheepMemberBean setWeixin_pub_open_id(String weixin_pub_open_id) {
		this.weixin_pub_open_id = weixin_pub_open_id;
		return this;
	}
	public String getWx_code() {
		return wx_code;
	}
	public SheepMemberBean setWx_code(String wx_code) {
		this.wx_code = wx_code;
		return this;
	}
	public String getStyle() {
		return style;
	}
	public SheepMemberBean setStyle(String style) {
		this.style = style;
		return this;
	}
	public String getFriend_id() {
		return friend_id;
	}
	public SheepMemberBean setFriend_id(String friend_id) {
		this.friend_id = friend_id;
		return this;
	}
	public String getBush_now_num() {
		return bush_now_num;
	}
	public SheepMemberBean setBush_now_num(String bush_now_num) {
		this.bush_now_num = bush_now_num;
		return this;
	}
	public String getBush_state() {
		return bush_state;
	}
	public SheepMemberBean setBush_state(String bush_state) {
		this.bush_state = bush_state;
		return this;
	}
	public String getBush_need_time() {
		return bush_need_time;
	}
	public SheepMemberBean setBush_need_time(String bush_need_time) {
		this.bush_need_time = bush_need_time;
		return this;
	}
	public String getBush_grew_time() {
		return bush_grew_time;
	}
	public SheepMemberBean setBush_grew_time(String bush_grew_time) {
		this.bush_grew_time = bush_grew_time;
		return this;
	}
	private GameSheepBean gameSheepBean;
	
	
	public GameSheepBean getGameSheepBean() {
		return gameSheepBean;
	}
	public SheepMemberBean setGameSheepBean(GameSheepBean gameSheepBean) {
		this.gameSheepBean = gameSheepBean;
		return this;
	}
	
	public String getMember_now_experience() {
		return member_now_experience;
	}
	public SheepMemberBean setMember_now_experience(String member_now_experience) {
		this.member_now_experience = member_now_experience;
		return this;
	}
	public String getMember_need_experience() {
		return member_need_experience;
	}
	public SheepMemberBean setMember_need_experience(String member_need_experience) {
		this.member_need_experience = member_need_experience;
		return this;
	}
	public String getGame_state() {
		return game_state;
	}
	public SheepMemberBean setGame_state(String game_state) {
		this.game_state = game_state;
		return this;
	}
	public String getGame_grade() {
		return game_grade;
	}
	public SheepMemberBean setGame_grade(String game_grade) {
		this.game_grade = game_grade;
		return this;
	}
	public String getBush_num() {
		return bush_num;
	}
	public SheepMemberBean setBush_num(String bush_num) {
		this.bush_num = bush_num;
		return this;
	}
	public String getTotal_balance() {
		return total_balance;
	}
	public SheepMemberBean setTotal_balance(String total_balance) {
		this.total_balance = total_balance;
		return this;
	}
	public String getSheep_member_id() {
		return sheep_member_id;
	}
	public SheepMemberBean setSheep_member_id(String sheep_member_id) {
		this.sheep_member_id = sheep_member_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepMemberBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public SheepMemberBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	
	
	public int getMember_id() {
		return member_id;
	}
	public SheepMemberBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getMember_coin() {
		return member_coin;
	}
	public SheepMemberBean setMember_coin(int member_coin) {
		this.member_coin = member_coin;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
