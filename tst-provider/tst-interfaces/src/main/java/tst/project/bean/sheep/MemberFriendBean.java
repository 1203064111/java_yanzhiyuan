package tst.project.bean.sheep;

import java.io.Serializable;

import tst.project.bean.member.MemberBean;

public class MemberFriendBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String member_friend_id;
	private String member_id;
	private String friend_id;
	private String update_time;
	private String create_time;
	private String is_delete;
	private String target_id;
	private String is_agree;//0，1，2请求，接受，2拒绝
	private MemberBean memberBean;
	
	
	
	
	
	
	
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public MemberFriendBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public String getMember_friend_id() {
		return member_friend_id;
	}
	public MemberFriendBean setMember_friend_id(String member_friend_id) {
		this.member_friend_id = member_friend_id;
		return this;
	}
	public String getIs_agree() {
		return is_agree;
	}
	public MemberFriendBean setIs_agree(String is_agree) {
		this.is_agree = is_agree;
		return this;
	}
	public String getTarget_id() {
		return target_id;
	}
	public MemberFriendBean setTarget_id(String target_id) {
		this.target_id = target_id;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public MemberFriendBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}

	public String getFriend_id() {
		return friend_id;
	}
	public MemberFriendBean setFriend_id(String friend_id) {
		this.friend_id = friend_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberFriendBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberFriendBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberFriendBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
