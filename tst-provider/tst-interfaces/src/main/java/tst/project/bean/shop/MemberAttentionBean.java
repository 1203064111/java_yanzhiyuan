package tst.project.bean.shop;

import java.io.Serializable;

public class MemberAttentionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int member_attention_id; 
	private String member_id; 
	private String attention_id;//关注的商品或商家id
	private String attention_type;//关注类型：1:医院 2:医生 3:商品
	private String attention_type_show; 
	private String is_delete; 
	private String create_time; 
	private String update_time;
	
	
	
	public int getMember_attention_id() {
		return member_attention_id;
	}
	public MemberAttentionBean setMember_attention_id(int member_attention_id) {
		this.member_attention_id = member_attention_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberAttentionBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getAttention_id() {
		return attention_id;
	}
	public MemberAttentionBean setAttention_id(String attention_id) {
		this.attention_id = attention_id;
		return this;
	}
	public String getAttention_type() {
		return attention_type;
	}
	public MemberAttentionBean setAttention_type(String attention_type) {
		this.attention_type = attention_type;
		this.attention_type_show = "1".equals(attention_type)?"医院":
								   "2".equals(attention_type)?"医生":
								   "3".equals(attention_type)?"商品":"";
		return this;
	}
	public String getAttention_type_show() {
		return attention_type_show;
	}
	public MemberAttentionBean setAttention_type_show(String attention_type_show) {
		this.attention_type_show = attention_type_show;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberAttentionBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberAttentionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberAttentionBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	} 
	
	

}
