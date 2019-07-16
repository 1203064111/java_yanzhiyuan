package tst.project.bean.sheep;

import java.io.Serializable;

public class GameBushBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int bush_id;
	private String bush_state;
	private String bush_num;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String bush_need_time;
	private String member_id;
	
	
	public String getMember_id() {
		return member_id;
	}
	public GameBushBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getBush_id() {
		return bush_id;
	}
	public GameBushBean setBush_id(int bush_id) {
		this.bush_id = bush_id;
		return this;
	}

	public String getBush_state() {
		return bush_state;
	}
	public GameBushBean setBush_state(String bush_state) {
		this.bush_state = bush_state;
		return this;
	}
	public String getBush_num() {
		return bush_num;
	}
	public GameBushBean setBush_num(String bush_num) {
		this.bush_num = bush_num;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GameBushBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GameBushBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GameBushBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getBush_need_time() {
		return bush_need_time;
	}
	public GameBushBean setBush_need_time(String bush_need_time) {
		this.bush_need_time = bush_need_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
