package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class MemberGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String member_group_id;
	private String member_id;
	private String sheep_group_id;//开团主键
	private String bitch_sheep_id;
	private String ear_id;
	private String group_need_count;//团购需要人数
	private String group_now_count;
	private String group_wait_time;
	private String group_state;
	private String end_time;
	private String is_delete;
	private String create_time;
	private String update_time;
	private int group_num;//团购剩余人数 1,0
	private MemberGroupBean memberGroupBean;
	private List<MemberGroupBean> memberGroupBeans;
	private  OrderSheepBean orderSheepBean;
	
	
	private String member_nick_name;//发起人昵称
	private String member_img;//发起人头像
	
	private String is_collage;//是否同意拼单
	
	
	
	
	public OrderSheepBean getOrderSheepBean() {
		return orderSheepBean;
	}
	public MemberGroupBean setOrderSheepBean(OrderSheepBean orderSheepBean) {
		this.orderSheepBean = orderSheepBean;
		return this;
	}
	public String getIs_collage() {
		return is_collage;
	}
	public MemberGroupBean setIs_collage(String is_collage) {
		this.is_collage = is_collage;
		return this;
	}
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public MemberGroupBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public MemberGroupBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public int getGroup_num() {
		return group_num;
	}
	public MemberGroupBean setGroup_num(int group_num) {
		this.group_num = group_num;
		return this;
	}
	public List<MemberGroupBean> getMemberGroupBeans() {
		return memberGroupBeans;
	}
	public MemberGroupBean setMemberGroupBeans(List<MemberGroupBean> memberGroupBeans) {
		this.memberGroupBeans = memberGroupBeans;
		return this;
	}
	public String getSheep_group_id() {
		return sheep_group_id;
	}
	public MemberGroupBean setSheep_group_id(String sheep_group_id) {
		this.sheep_group_id = sheep_group_id;
		return this;
	}
	public MemberGroupBean getMemberGroupBean() {
		return memberGroupBean;
	}
	public MemberGroupBean setMemberGroupBean(MemberGroupBean memberGroupBean) {
		this.memberGroupBean = memberGroupBean;
		return this;
	}
	public String getMember_group_id() {
		return member_group_id;
	}
	public MemberGroupBean setMember_group_id(String member_group_id) {
		this.member_group_id = member_group_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberGroupBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}
	public MemberGroupBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}
	public String getEar_id() {
		return ear_id;
	}
	public MemberGroupBean setEar_id(String ear_id) {
		this.ear_id = ear_id;
		return this;
	}
	public String getGroup_need_count() {
		return group_need_count;
	}
	public MemberGroupBean setGroup_need_count(String group_need_count) {
		this.group_need_count = group_need_count;
		return this;
	}
	public String getGroup_now_count() {
		return group_now_count;
	}
	public MemberGroupBean setGroup_now_count(String group_now_count) {
		this.group_now_count = group_now_count;
		return this;
	}
	public String getGroup_wait_time() {
		return group_wait_time;
	}
	public MemberGroupBean setGroup_wait_time(String group_wait_time) {
		this.group_wait_time = group_wait_time;
		return this;
	}
	public String getGroup_state() {
		return group_state;
	}
	public MemberGroupBean setGroup_state(String group_state) {
		this.group_state = group_state;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MemberGroupBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberGroupBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberGroupBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberGroupBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
