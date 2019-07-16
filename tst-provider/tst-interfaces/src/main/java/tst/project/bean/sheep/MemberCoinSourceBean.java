package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberCoinSourceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int coin_id;
	private String coin_num;
	private String member_id;
	private String coin_type;  //1  签到  ，2 产币 ,3游戏道具购买,4金币商城购买
	private String coin_type_show;
	private String is_delete;
	private String update_time;
	private String create_time;
	public int getCoin_id() {
		return coin_id;
	}
	
	
	public String getCoin_type_show() {
		return coin_type_show;
	}


	public MemberCoinSourceBean setCoin_type_show(String coin_type_show) {
		this.coin_type_show = coin_type_show;
		return this;
	}


	public MemberCoinSourceBean setCoin_id(int coin_id) {
		this.coin_id = coin_id;
		return this;
	}
	public String getCoin_num() {
		return coin_num;
	}
	public MemberCoinSourceBean setCoin_num(String coin_num) {
		this.coin_num = coin_num;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberCoinSourceBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getCoin_type() {
		return coin_type;
	}
	public MemberCoinSourceBean setCoin_type(String coin_type) {
		this.coin_type = coin_type;
		this.coin_type_show="1".equals(coin_type)?"签到":
			                 "2".equals(coin_type)?"农场产币":
			                	 "3".equals(coin_type)?"游戏道具消费":
			                		 "4".equals(coin_type)?"金币商城消费":"其他";
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberCoinSourceBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberCoinSourceBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberCoinSourceBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
