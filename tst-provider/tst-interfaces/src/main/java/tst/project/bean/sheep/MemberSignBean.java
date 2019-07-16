package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberSignBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sign_id;
	private String count;//签到次数
	private String is_delete;
	private String create_time;
	private String update_time;
	private String last_modify_time;//最近签到的时间
	private String member_id;//用户id
	
	
	public String getMember_id() {
		return member_id;
	}
	public MemberSignBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	
	public int getSign_id() {
		return sign_id;
	}
	public MemberSignBean setSign_id(int sign_id) {
		this.sign_id = sign_id;
		return this;
	}
	
	public String getIs_delete() {
		return is_delete;
	}
	public MemberSignBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberSignBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberSignBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCount() {
		return count;
	}
	public MemberSignBean setCount(String count) {
		this.count = count;
		return this;
	}
	public String getLast_modify_time() {
		return last_modify_time;
	}
	public MemberSignBean setLast_modify_time(String last_modify_time) {
		this.last_modify_time = last_modify_time;
		return this;
	}
	
	
	

}
