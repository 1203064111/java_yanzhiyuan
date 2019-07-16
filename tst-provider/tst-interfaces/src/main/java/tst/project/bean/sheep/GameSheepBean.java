package tst.project.bean.sheep;

import java.io.Serializable;

public class GameSheepBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int game_sheep_id;
	private String sheep_img;
	private String sheep_nick_name;
	private String sheep_state;//0养殖中,1养殖完成和里面的is_sheep对应
	private String sheep_end_time;//体验到期时间，时间点
	private String is_delete;
	private String update_time;
	private String create_time;
	private String member_id;
	private String is_ill;//0正常，1生病(未启用)
	private String sheep_state2;//0，1，2(未进食、产币状态、生病状态）
	private String sheep_img2;
	private String  is_use;//0,1
	private String  member_goods_id;//启用的个人物品id
	private String coin_end_time;//产币结束时间
	private String produce_coin;//产币数量
	private String coin_start_time;//开始产币时间
	private String next_produce_time;//下次产币时间
	private String use_clothe;
	private int time;//产币速率
	
	
	private GameMemberGoodsBean gameMemberGoodsBean;//道具图片
	
	private GameImgConfigBean gameImgConfigBean;//初始图片
	
	
	
	public GameImgConfigBean getGameImgConfigBean() {
		return gameImgConfigBean;
	}
	public GameSheepBean setGameImgConfigBean(GameImgConfigBean gameImgConfigBean) {
		this.gameImgConfigBean = gameImgConfigBean;
		return this;
	}
	public GameMemberGoodsBean getGameMemberGoodsBean() {
		return gameMemberGoodsBean;
	}
	public GameSheepBean setGameMemberGoodsBean(GameMemberGoodsBean gameMemberGoodsBean) {
		this.gameMemberGoodsBean = gameMemberGoodsBean;
		return this;
	}
	public int getTime() {
		return time;
	}
	public GameSheepBean setTime(int time) {
		this.time = time;
		return this;
	}
	public String getUse_clothe() {
		return use_clothe;
	}
	public GameSheepBean setUse_clothe(String use_clothe) {
		this.use_clothe = use_clothe;
		return this;
	}
	public String getIs_use() {
		return is_use;
	}
	public GameSheepBean setIs_use(String is_use) {
		this.is_use = is_use;
		return this;
	}
	public String getNext_produce_time() {
		return next_produce_time;
	}
	public GameSheepBean setNext_produce_time(String next_produce_time) {
		this.next_produce_time = next_produce_time;
		return this;
	}
	public String getCoin_start_time() {
		return coin_start_time;
	}
	public GameSheepBean setCoin_start_time(String coin_start_time) {
		this.coin_start_time = coin_start_time;
		return this;
	}
	public String getProduce_coin() {
		return produce_coin;
	}
	public GameSheepBean setProduce_coin(String produce_coin) {
		this.produce_coin = produce_coin;
		return this;
	}
	public String getCoin_end_time() {
		return coin_end_time;
	}
	public GameSheepBean setCoin_end_time(String coin_end_time) {
		this.coin_end_time = coin_end_time;
		return this;
	}
	public String getSheep_state2() {
		return sheep_state2;
	}
	public GameSheepBean setSheep_state2(String sheep_state2) {
		this.sheep_state2 = sheep_state2;
		return this;
	}
	public String getMember_goods_id() {
		return member_goods_id;
	}
	public GameSheepBean setMember_goods_id(String member_goods_id) {
		this.member_goods_id = member_goods_id;
		return this;
	}
	
	public String getSheep_img2() {
		return sheep_img2;
	}
	public GameSheepBean setSheep_img2(String sheep_img2) {
		this.sheep_img2 = sheep_img2;
		return this;
	}
	public String getIs_ill() {
		return is_ill;
	}
	public GameSheepBean setIs_ill(String is_ill) {
		this.is_ill = is_ill;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GameSheepBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getGame_sheep_id() {
		return game_sheep_id;
	}
	public GameSheepBean setGame_sheep_id(int game_sheep_id) {
		this.game_sheep_id = game_sheep_id;
		return this;
	}
	public String getSheep_img() {
		return sheep_img;
	}
	public GameSheepBean setSheep_img(String sheep_img) {
		this.sheep_img = sheep_img;
		return this;
	}
	public String getSheep_nick_name() {
		return sheep_nick_name;
	}
	public GameSheepBean setSheep_nick_name(String sheep_nick_name) {
		this.sheep_nick_name = sheep_nick_name;
		return this;
	}
	public String getSheep_state() {
		return sheep_state;
	}
	public GameSheepBean setSheep_state(String sheep_state) {
		this.sheep_state = sheep_state;
		return this;
	}
	public String getSheep_end_time() {
		return sheep_end_time;
	}
	public GameSheepBean setSheep_end_time(String sheep_end_time) {
		this.sheep_end_time = sheep_end_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GameSheepBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GameSheepBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GameSheepBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
