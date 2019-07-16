package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberGameBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int game_id;
	private String member_id;//
	private String end_time;//结束时间
	private String member_need_experience;
	private String member_now_experience;
	private String game_state;//游戏状态
	private String game_grade;//游戏等级
	private String update_sate;
	private String create_time;
	private String is_delete;
	private GameSheepBean gameSheepBean;
	private GameBushBean gameBushBean;
	
	
	public GameBushBean getGameBushBean() {
		return gameBushBean;
	}
	public MemberGameBean setGameBushBean(GameBushBean gameBushBean) {
		this.gameBushBean = gameBushBean;
		return this;
	}
	public GameSheepBean getGameSheepBean() {
		return gameSheepBean;
	}
	public MemberGameBean setGameSheepBean(GameSheepBean gameSheepBean) {
		this.gameSheepBean = gameSheepBean;
		return this;
	}
	public int getGame_id() {
		return game_id;
	}
	public MemberGameBean setGame_id(int game_id) {
		this.game_id = game_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberGameBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MemberGameBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getMember_need_experience() {
		return member_need_experience;
	}
	public MemberGameBean setMember_need_experience(String member_need_experience) {
		this.member_need_experience = member_need_experience;
		return this;
	}
	public String getMember_now_experience() {
		return member_now_experience;
	}
	public MemberGameBean setMember_now_experience(String member_now_experience) {
		this.member_now_experience = member_now_experience;
		return this;
	}
	public String getGame_state() {
		return game_state;
	}
	public MemberGameBean setGame_state(String game_state) {
		this.game_state = game_state;
		return this;
	}
	public String getGame_grade() {
		return game_grade;
	}
	public MemberGameBean setGame_grade(String game_grade) {
		this.game_grade = game_grade;
		return this;
	}
	public String getUpdate_sate() {
		return update_sate;
	}
	public MemberGameBean setUpdate_sate(String update_sate) {
		this.update_sate = update_sate;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberGameBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberGameBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
