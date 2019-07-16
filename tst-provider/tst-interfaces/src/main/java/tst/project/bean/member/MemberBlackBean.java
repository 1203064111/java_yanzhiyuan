package tst.project.bean.member;

import java.io.Serializable;

public class MemberBlackBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int black_id;//拉黑id
	private String member_id;//用户id
	private String to_member_id;//对象用户id
	private String is_delete;//
	private String create_time;
	private String update_time;
	private String black_state;//状态 0未拉黑 1已拉黑
	public int getBlack_id() {
		return black_id;
	}
	public MemberBlackBean setBlack_id(int black_id) {
		this.black_id = black_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberBlackBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getTo_member_id() {
		return to_member_id;
	}
	public MemberBlackBean setTo_member_id(String to_member_id) {
		this.to_member_id = to_member_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberBlackBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberBlackBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberBlackBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getBlack_state() {
		return black_state;
	}
	public MemberBlackBean setBlack_state(String black_state) {
		this.black_state = black_state;
		return this;
	}
	
	
	
	
	

}
