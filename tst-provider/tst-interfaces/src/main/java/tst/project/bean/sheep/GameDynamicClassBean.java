package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class GameDynamicClassBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String member_id;
	private String dynamic_time;
	private List<GameDynamicBean> gameDynamicBeans;
	
	
	
	
	
	public String getMember_id() {
		return member_id;
	}
	public GameDynamicClassBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getDynamic_time() {
		return dynamic_time;
	}
	public GameDynamicClassBean setDynamic_time(String dynamic_time) {
		this.dynamic_time = dynamic_time;
		return this;
	}
	public List<GameDynamicBean> getGameDynamicBeans() {
		return gameDynamicBeans;
	}
	public GameDynamicClassBean setGameDynamicBeans(List<GameDynamicBean> gameDynamicBeans) {
		this.gameDynamicBeans = gameDynamicBeans;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
