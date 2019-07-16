package tst.project.bean.information;

import java.io.Serializable;

public class MemberFocusBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_focus_id; //
	private String member_id; //
	private String material_id; //公司id
	private String is_delete;//
	private String create_time; //
	private String update_time; //
	public int getMember_focus_id() {
		return member_focus_id;
	}
	public MemberFocusBean setMember_focus_id(int member_focus_id) {
		this.member_focus_id = member_focus_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberFocusBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMaterial_id() {
		return material_id;
	}
	public MemberFocusBean setMaterial_id(String material_id) {
		this.material_id = material_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberFocusBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberFocusBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberFocusBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
