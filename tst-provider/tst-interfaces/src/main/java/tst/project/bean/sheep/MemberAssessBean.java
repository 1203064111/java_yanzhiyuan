package tst.project.bean.sheep;

import java.io.Serializable;

public class MemberAssessBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int assessment_id;
	private String member_id;
	private String bitch_sheep_id;
	private String sheep_title;
	private String assessment_desc;
	private String assessment_imgs;
	private String assessment_star;
	private String order_id;
	private String order_no;
	private String create_time;
	private String update_time;
	private String is_delete;
	private String member_nick_name;
	private String member_img;
	
	public String getAssessment_star() {
		return assessment_star;
	}
	public MemberAssessBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public MemberAssessBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public MemberAssessBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public int getAssessment_id() {
		return assessment_id;
	}
	public MemberAssessBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberAssessBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}
	public MemberAssessBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}
	public String getSheep_title() {
		return sheep_title;
	}
	public MemberAssessBean setSheep_title(String sheep_title) {
		this.sheep_title = sheep_title;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public MemberAssessBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public MemberAssessBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public MemberAssessBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public MemberAssessBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberAssessBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberAssessBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberAssessBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
